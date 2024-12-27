package edu.onlineFoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.Customer;
import edu.onlineFoodApp.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer);
		
	}
	

	public Optional<Customer> findCustomerById(Long customerId) {
		
		Optional<Customer> cusOptional = customerRepository.findById(customerId);
		
		return cusOptional;
		
	}
	
	public Optional<Customer> findCustomerByPhoneNumber(Long customerPhoneNumber) {
		
		Customer customer = customerRepository.findByPhoneNumber(customerPhoneNumber);
		
		return Optional.ofNullable(customer);
		 
	}
	
	public Optional<List<Customer>> findAllCustomer() {
		
		List<Customer> customers = customerRepository.findAll();
		
		return Optional.ofNullable(customers);
				
		
	}
	
		
	public Customer updateCustomer(Customer customer) {
		
		return customerRepository.save(customer);
		
	}
	
	public String removeCustomer(Long customerId) {
		
		customerRepository.deleteById(customerId);
		
		return "Customer detail removed successfully";
		
	}
	
	
}
