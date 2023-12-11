package edu.onlineFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.onlineFoodApp.dto.Customer;
import edu.onlineFoodApp.service.CustomerService;
import edu.onlineFoodApp.util.ResponseStructure;


@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("saveCustomerFoodItemDao")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("findCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(@RequestParam long customerId) {
		return customerService.findCustomerById(customerId);
	}
	
	@GetMapping("findCustomerByPhoneNumber")
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhoneNumber(@RequestParam long customerPhoneNumber) {
		return customerService.findCustomerByPhoneNumber1(customerPhoneNumber);
	}
	
	@GetMapping("findAllCustomer")
	public ResponseEntity<ResponseStructure<Customer>> findAllCustomer()
	{
		return customerService.findAllCustomer();
	}
	
	@PutMapping("updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam long customerId,@RequestBody Customer customer)
	{
		return customerService.UpdateCustomer(customerId, customer);
	}
	
	@DeleteMapping("removeCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> removeCustomerById(@RequestParam long customerId) {
		return customerService.removeCustomer(customerId);
	}
	
}

