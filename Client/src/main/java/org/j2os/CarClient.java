package org.j2os;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("car-service")
@RequestMapping("/car")
public interface CarClient {
	@GetMapping("/save")
    Object save(@RequestParam("model") String model,
                @RequestParam("carid") Long carId,
                @RequestParam("ownerid") Long ownerId);

    @GetMapping("/findByOwner")
    Object findByOwnerId(@RequestParam("id") Long id);

    @GetMapping("/updateModel")
    Object updateModel(@RequestParam("carid") Long carid, @RequestParam("model") String model);
}
