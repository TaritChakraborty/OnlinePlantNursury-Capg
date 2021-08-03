package com.cg.onlineplantnursery.customer.controller;

import java.lang.reflect.Field;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.CustomerService;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.order.entity.Orders;
import com.cg.onlineplantnursery.order.service.OrderService;

@RestController
@RequestMapping("/customer")
public class ICustomerController {
	
	private int validUser = 0;
	private Integer validId = 0;
	private String welcome = "Welcome \n........................\n Customer Id : ";
	@Autowired
	private CustomerService service;
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@Validated @RequestBody Customer customer) {
		return ResponseEntity.ok(service.addCustomer(customer));
	}
	
	@PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveOrder(@RequestBody Orders order) {
		if(validUser == 1) {
			return ResponseEntity.ok(orderservice.addOrder(order));
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@DeleteMapping("/customer")
	public ResponseEntity<?> deleteCustomer() {
		if(validUser == 1) {
			return ResponseEntity.ok(service.deleteCustomer(validId));
		}else
			return ResponseEntity.ok("Not Logged In");
		
	}
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> validateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		boolean value = service.validateCustomer(username, password);		
		if (value == true) {
			validUser = 1;
			Customer customer = service.viewByUserName(username, password).get();
			validId = customer.getCustomerId();
			
			return ResponseEntity.ok(welcome + validId + 
					                 "\n Name : " + customer.getCustomerName() + 
					                 "\n Email : " + customer.getCustomerEmail() + 
					                 "\n.........................\n Address --- \n House no : " 
					                  + customer.getAddress().getHouseNo() + 
					                 "\n Colony : " + customer.getAddress().getColony() +
					                 "\n City : " +	customer.getAddress().getCity() + 
					                 "\n State : " + customer.getAddress().getState() +
					                 "\n Pincode : " +	customer.getAddress().getPincode());
		}
		else
			return ResponseEntity.ok("Invalid Credentials");		
	}
	
	
	@GetMapping("/order/{id}")
	public Orders viewOrder(@PathVariable("id") Integer orderId) throws OrderIdNotFoundException {
		return orderservice.viewOrder(orderId);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<?> viewCustomer() {
		if(validUser == 1)
	    {
	      Customer customer = service.viewCustomer(validId);
	      return ResponseEntity.ok(customer);
	    }else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@GetMapping("/order")
	public ResponseEntity<?> fetchOrders(){
		if(validUser == 1) {
			Customer customer = service.viewCustomer(validId);
			/*return ResponseEntity.ok(welcome + customer.getCustomerId() +
									"\n Name : " + customer.getCustomerName() + 
									"\n Email : " + customer.getCustomerEmail() + 
	                 				"\n.........................\n Orders --- \n " +
									customer.getOrders()); */
			return ResponseEntity.ok(customer.getOrders()); 
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@PatchMapping(path = "/customer")
	public ResponseEntity<?> updateCustomerById(@RequestBody Map<Object, Object> fields) {
	    if(validUser == 1)
	    {
	      Customer customer = service.viewCustomer(validId);
	      if(customer != null) {
	    	  fields.forEach((key,value) -> {
	    		  Field field = ReflectionUtils.findField(Customer.class, (String)key);
	    		  field.setAccessible(true);
	    		  ReflectionUtils.setField(field, customer, value);
	    	  });	    	  
	      }return ResponseEntity.ok(service.updateCustomer(customer));
	      
	    }else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@PutMapping("/address")
	public ResponseEntity<?> updateAddressById(@RequestBody Address address){
		if(validUser == 1) {
			return ResponseEntity.ok(service.updateAddress(validId, address));			
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		if(validUser == 1) {
			validUser = 0;
			return ResponseEntity.ok("Logged out...");		
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
}
