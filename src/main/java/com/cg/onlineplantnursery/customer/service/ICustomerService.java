package com.cg.onlineplantnursery.customer.service;

import java.util.List;

import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	//Customer updateCustomerById(Integer customerId, Customer tenant);
	
	Customer updateCustomer(Customer tenant);

	Customer deleteCustomer(Integer customerId);

	Customer viewCustomer(Integer customerId);	

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
	
	List<Object[]> viewOrders(Integer customerId);
	
	Customer updateAddress(Integer customerId, Address address);

}
