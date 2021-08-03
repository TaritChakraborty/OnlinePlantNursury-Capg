package com.cg.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.repository.IPlantRepository;

@Service
public class PlantService implements IPlantService{
	@Autowired
	private IPlantRepository response;

	public Plant addPlant(Plant plant) {
		return response.save(plant);
	}

	@Override
	public Plant updatePlant(Plant plant) {
		return response.save(plant);
	}

	@Override
	public Plant deletePlant(Integer plantId) {
		Optional<Plant> plant = response.findById(plantId);
		response.deleteById(plantId);
		return plant.get();
	}

	@Override
	public Plant viewPlant(int plantId) {
		Optional<Plant> plant = response.findById(plantId);
		if (!plant.isPresent()) {
			throw new ResourceNotFoundException("Plant Id is invalid");
		} else {
			return plant.get();
		}
	}

	@Override
	public Plant viewPlantByName(String commonName) {
		Plant dept = response.findByCommonNameIgnoreCase(commonName);
		if (dept == null) {
			throw new ResourceNotFoundException("Plant Name is not available");
		} else {
			return response.findByCommonNameIgnoreCase(commonName);
		}
	}

	@Override
	public List<Plant> viewAllPlants() {
		return response.findAll();
	}

	@Override
	public List<Plant> viewAllPlantsByType(String typeOfPlant) {
		List<Plant> plant = response.findByTypeOfPlantIgnoreCase(typeOfPlant);
		if (plant == null) {
			throw new ResourceNotFoundException("Plant Type is not available");
		} else {
			return plant;
		}
	}
}
