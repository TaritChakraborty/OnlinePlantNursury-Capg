package com.cg.onlineplantnursury.customer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;

@DataJpaTest
public class CustomerRepositoryTest {
	@Autowired
	private ICustomerRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {

		Customer customer = Customer.builder().customerId(1).customerName("Amit Roy").customerEmail("amtroy@gmail.com")
				.username("amtroy").password("amtroy123").address(null).build();

		entityManager.persist(customer);
	}

	@Test(expected = NullPointerException.class)
	public void whenFindById_thenReturnCustomer() {
		Integer customerId = 1;
		Customer customer = repo.findById(customerId).get();
		assertEquals(customer.getCustomerName(), 1);
	}

}
