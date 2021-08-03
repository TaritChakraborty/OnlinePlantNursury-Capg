package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@Service
public class PlanterService implements IPlanterService{
	
	@Autowired
	private IPlanterRepository response;

	@Override
	public Planter addPlanter(Planter planter) {
		return response.save(planter);
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		return response.save(planter);
	}

	@Override
	public Planter deletePlanter(Integer planterId) {
		Planter planter = response.findById(planterId).get();
		response.deleteById(planterId);
		return planter;
	}

	@Override
	public Planter viewPlanter(Integer planterId) {
		Optional<Planter> planter = response.findById(planterId);
		return planter.get();
	}
     
	@Override
	public Planter viewPlanterByShape(String planterShape) {
		return response.findByPlanterShape(planterShape);
	}
    
	@Override
	public List<Planter> viewAllPlanters() {
		return response.findAll();
	}

	@Override
	public List<Planter> viewAllPlantersByCost(double minCost, double maxCost) {
		List<Planter> planters = response.findByPlanterCostBetween(minCost, maxCost);
		return planters;
	}

	@Override
	public double viewPlantCost(Integer planterId) {
		Optional<Planter> planter = response.findById(planterId);
		double price = planter.get().getPlanterCost();
		return price;
	}

}
