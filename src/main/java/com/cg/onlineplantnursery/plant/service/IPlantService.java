package com.cg.onlineplantnursery.plant.service;

import java.util.List;

import com.cg.onlineplantnursery.plant.entity.Plant;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant);

	Plant viewPlant(int plantId);

	Plant viewPlantByName(String commonName);

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlantsByType(String typeOfPlant);

	Plant deletePlant(Integer plantId);

}
