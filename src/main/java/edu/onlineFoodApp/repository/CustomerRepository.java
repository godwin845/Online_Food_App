package edu.onlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	public Customer findByPhoneNumber(long phoneNumber);

}
