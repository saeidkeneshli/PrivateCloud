package org.j2os.classFinal.api;

import org.j2os.classFinal.domain.Car;
import org.j2os.classFinal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/car")
public class CarAPI {
    @Autowired
    private CarService carService;

    @GetMapping("/save")
    public Car save(HttpServletRequest request) {
        Car car = new Car();
        car.setModel(request.getParameter("model"));
        car.setOwnerId(Long.valueOf(request.getParameter("ownerid")));
        car.setCarId(Long.valueOf(request.getParameter("carid")));
        carService.save(car);
        return car;
    }

    @GetMapping("/findByOwner")
    public Car findByOwnerId(HttpServletRequest request){
        Car car = carService.findByOwner(Long.valueOf(request.getParameter("id")));
        return car;
    }

    @GetMapping("/updateModel")
    public Car updateModel(HttpServletRequest request){
        Car car = carService.updateModel(Long.valueOf(request.getParameter("carid")), request.getParameter("model"));
        return car;
    }
}
