package com.cg.onlineplantnursery.plant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.PlantService;

@RestController
@RequestMapping("/plant")
public class IPlantController {
	@Autowired
	private PlantService plantService;

	@PostMapping("/addPlant")
	public Plant saveOrder(@RequestBody Plant plant) {
		return plantService.addPlant(plant);
	}

	@PutMapping("/updatePlant")
	public Plant updatePlant(@RequestBody Plant plant) {
		return plantService.updatePlant(plant);
	}
	@DeleteMapping("/deletePlant/{deleteId}")
	public void deletePlant(@PathVariable Integer deleteId) {
		plantService.deletePlant(deleteId);
	}

	@GetMapping("/fetchAllPlants")
	public List<Plant> fetchAllOrders() {
		return plantService.viewAllPlants();
	}

	@GetMapping("/order/{id}")
	public Plant fetchById(@PathVariable("id") int plantId) {
		return plantService.viewPlant(plantId);
	}

	@GetMapping("/order/{name}")
	public Plant fetchByName(@PathVariable("name") String commonName) {
		return plantService.viewPlantByName(commonName);
	}
	@GetMapping("/order/{type}")
	public Plant fetchByType(@PathVariable("name") String plantType) {
		return (Plant) plantService.viewAllPlantsByType(plantType);
	}

}
