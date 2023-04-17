package org.j2os.classFinal.service;

import org.j2os.classFinal.domain.Car;
import org.j2os.classFinal.repository.CarClassicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
    @Autowired
    private CarClassicRepository carClassicRepository;

    @Transactional
    public void save(Car car) {
        carClassicRepository.save(car);
    }

    @Transactional
    public Car findByOwner(Long id) {
        return carClassicRepository.findByOwnerId(id);
    }

    @Transactional
    public Car updateModel(Long id, String model) {
        return carClassicRepository.updateModel(id, model);
    }
}
