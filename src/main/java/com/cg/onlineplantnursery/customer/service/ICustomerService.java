package com.cg.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;
@Service
public class ICustomerService {
	
	@Autowired
	private ICustomerRepository response;
	
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return response.findAll();
	}
	
	public Customer addCustomer(Customer customer) {
		return response.save(customer);
	}
	
	public Customer updateCustomer(Customer tenant) {
		return response.save(tenant);
	}
	
	public Customer deleteCustomer(Customer tenant) {
		response.delete(tenant);
		return tenant;
	}
	
	public Customer viewCustomer(int customerId) {
		Optional<Customer> customer = response.findById(Integer.toString(customerId));
		return customer.get();
	}
	/*
	public boolean validateCustomer(String userName, String password) {
		Optional<Customer> customer = response.findById(userName);
	}
    */
}
