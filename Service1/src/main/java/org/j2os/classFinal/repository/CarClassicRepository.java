package org.j2os.classFinal.repository;

import org.j2os.classFinal.domain.Car;
import org.springframework.stereotype.Repository;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CarClassicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Car car)
    {
        entityManager.persist(car);
    }

    public Car findByOwnerId(Long ownerId) {
        Car carResult = new Car();
        Query query = entityManager.createQuery("select c from car c where c.ownerId=:n");
        query.setParameter("n",ownerId);

        List<Car> carList = query.getResultList();

        for (Car car : carList) {
            carResult.setId(car.getId());
            carResult.setCarId(car.getCarId());
            carResult.setOwnerId(car.getOwnerId());
            carResult.setModel(car.getModel());
        }
        return carResult;
    }

    public Car updateModel(Long carId, String model){
        Car car = entityManager.find(Car.class, carId);
        entityManager.detach(car);
        car.setModel(model);
        return car;
    }
}
