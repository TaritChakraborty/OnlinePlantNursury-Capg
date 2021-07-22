package com.cg.onlineplantnursery.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.ICustomerService;

@RestController
public class ICustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/customer")
	public List<Customer> viewAllCustomers(){
		return service.viewAllCustomers();
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@Validated @RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@Validated @RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@DeleteMapping("/customer")
	public Customer deleteCustomer(Customer customer) {
		service.deleteCustomer(customer);
		return customer;
	}
	
	@GetMapping("/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") int customerId) {
		return service.viewCustomer(customerId);
	}

}
