package com.cg.onlineplantnursery.customer.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.onlineplantnursery.customer.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByUsername(String username);	
	
	Optional<Customer> findByUsernameAndPassword(String username, String password);	
	
	//@Query("SELECT customerId,customerName,customerEmail,username, address FROM Customer WHERE username = :username AND password = :password")
	//Object login(@Param("username") String username, @Param("password") String password);
	
	@Query("SELECT customerName,customerEmail,orders FROM Customer WHERE customerId = :customerId")
	List<Object[]> findOrders(@Param("customerId") Integer customerId);
}
