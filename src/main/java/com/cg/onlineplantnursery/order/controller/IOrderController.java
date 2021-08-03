package com.cg.onlineplantnursery.order.controller;

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

import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.order.entity.Orders;
import com.cg.onlineplantnursery.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class IOrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping("/order")
	public Orders saveOrder(@RequestBody Orders order) {
		return service.addOrder(order);
	}

	@GetMapping("/order")
	public List<Orders> fetchAllOrders() {
		return service.viewAllOrders();
	}
    
	@GetMapping("/order/{id}")
	public Orders viewOrder(@PathVariable("id") Integer co_fk) throws OrderIdNotFoundException {
		return service.viewOrder(co_fk);
	}
	
	@DeleteMapping("/order/{id}")
	public void deleteById(@PathVariable("id") Integer orderId) {
		service.deleteOrder(orderId);
	}

	@PutMapping("/order")
	public Orders updateOrder(@RequestBody Orders order) {
		return service.updateOrder(order);
	}

}
