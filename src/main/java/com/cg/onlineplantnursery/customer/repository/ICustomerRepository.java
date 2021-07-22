package com.cg.onlineplantnursery.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.customer.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String>{
	
	//public boolean validateCustomer(String userName, String password);
}
