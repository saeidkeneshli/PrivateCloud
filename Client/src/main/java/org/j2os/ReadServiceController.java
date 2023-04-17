package org.j2os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ReadServiceController {

	@Autowired
	private PersonClient personClient;

	@Autowired
	private CarClient carClient;


	@GetMapping("/saveBoth")
	public ResponseEntity<Object> saveBoth(@RequestParam("name") String name,
												 @RequestParam("family") String family,
												 @RequestParam("carid") Long carId,
												 @RequestParam("model") String model){

		HashMap personMap = (HashMap) personClient.save(name, family, carId);
		Integer id = (Integer) personMap.get("id");
		carClient.save(model, carId, Long.valueOf(id));

		return ResponseEntity.ok(personMap);
	}

	@GetMapping("/updateByName")
	public ResponseEntity<Object> updateByName(@RequestParam("name") String name,
											   @RequestParam("model") String model){

		HashMap personMap = (HashMap) personClient.findByName(name);
		Integer personId = (Integer) personMap.get("id");

		HashMap carMap = (HashMap) carClient.findByOwnerId(Long.valueOf(personId));
		Integer carId = (Integer) carMap.get("id");
		String carModel = (String) carMap.get("model");

		HashMap carResult = (HashMap) carClient.updateModel(Long.valueOf(carId), carModel);
		return ResponseEntity.ok(carResult);
	}
}
