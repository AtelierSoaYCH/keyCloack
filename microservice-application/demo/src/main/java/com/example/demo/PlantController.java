package com.example.demo;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping("/plant")
public class PlantController {

	private PlantService plantService;

	public PlantController(PlantService plantService) {
		this.plantService = plantService;
	}

	@GetMapping("/{plantId}")
	public Plant getPlant(@PathVariable @NotNull Long plantId) {

		log.info("Request for plant " + plantId + " received");

		return plantService.getPlant(plantId);
	}
}