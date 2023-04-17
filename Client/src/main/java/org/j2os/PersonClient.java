package org.j2os;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("person-service")
public interface PersonClient {

	@GetMapping("/person/save")
		 Object save(@RequestParam("name") String name,
					 @RequestParam("family") String family,
					 @RequestParam("carid") Long carId);

	@GetMapping("person/findByName")
		Object findByName(@RequestParam("name") String name);
}
