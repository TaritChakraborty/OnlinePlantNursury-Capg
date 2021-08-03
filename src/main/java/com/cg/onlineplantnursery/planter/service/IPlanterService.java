package com.cg.onlineplantnursery.planter.service;

import java.util.List;

import com.cg.onlineplantnursery.planter.entity.Planter;

public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Integer planterId);

	Planter viewPlanter(Integer planterId);

	Planter viewPlanterByShape(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlantersByCost(double minCost, double maxCost);
	
	double viewPlantCost(Integer planterId);
}
