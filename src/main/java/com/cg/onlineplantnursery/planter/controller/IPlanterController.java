package com.cg.onlineplantnursery.planter.controller;

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

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.PlanterService;

@RestController
@RequestMapping("/planter")
public class IPlanterController {
	@Autowired
	private PlanterService service;
	
	@PostMapping("/planter")
	public Planter addPlanter(@RequestBody Planter planter) {
		return service.addPlanter(planter);
	}

	@GetMapping("/planter")
	public List<Planter> viewAllPlanters() {
		return service.viewAllPlanters();
	}
	
	@GetMapping("/planter/{id}")
	public Planter viewById(@PathVariable("id") int planterId) {
		return service.viewPlanter(planterId);
	}
	
	@GetMapping("/planter/{minCost, maxCost}")
	public List<Planter> viewAllPlanters(@PathVariable("minCost, maxCost") double minCost, double maxCost) {
		return service.viewAllPlantersByCost(minCost, maxCost);
	}
	
	@GetMapping("/viewplanter/{planterShape}")
	public Planter viewById(@PathVariable("planterShape") String planterShape) {
		return service.viewPlanterByShape(planterShape);
	}

	@DeleteMapping("/planter/{id}")
	public void deleteById(@PathVariable("id") Integer planterId) {
		service.deletePlanter(planterId);
	}

	@PutMapping("/planter")
	public Planter updatePlanter(@RequestBody Planter planter) {
		return service.updatePlanter(planter);
	}

}
