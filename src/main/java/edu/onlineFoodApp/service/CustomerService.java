package edu.onlineFoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.onlineFoodApp.Exception.CustomerIdNotPresentException;
import edu.onlineFoodApp.dao.CustomerDao;
import edu.onlineFoodApp.dto.Customer;
import edu.onlineFoodApp.util.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer id created successfully");
		responseStructure.setData(customerDao.saveCustomer(customer));
		
		ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		
		return entity;
				
	}
	
	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(long customerId) {
		
		Optional<Customer> customer = customerDao.findCustomerById(customerId);
		
		if (customer.isPresent()) {
			
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer details are founded successfully");
			responseStructure.setData(customer.get());
			
			ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
			
			return entity;
			
			
		} else
			
			throw new CustomerIdNotPresentException();
	
	}
	
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhoneNumber1(long customerPhoneNumber) {
		
		Optional<Customer> optional = customerDao.findCustomerByPhoneNumber(customerPhoneNumber);
		
		if (optional.isPresent()) {
			
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer details are founded successfully");
			responseStructure.setData(optional.get());
			
			ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
			
			return entity;
			
			
		} else {
			
			throw new CustomerIdNotPresentException();

		}
	}
		
		
		public ResponseEntity<ResponseStructure<Customer>> findAllCustomer() {
			
			Optional<List<Customer>> customers = customerDao.findAllCustomer();
			
			if (customers.isPresent()) {
				
				List<Customer> list = customerDao.findAllCustomer().get();
				
				ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Customer details are retrieved successfully");
				responseStructure.setData(list);
				
				ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(HttpStatus.OK);
				
				return entity;
				
				
			} else {
				
				throw new CustomerIdNotPresentException();

			}
		}
			
			
			public ResponseEntity<ResponseStructure<Customer>> UpdateCustomer(long customerId, Customer customer) {
				
				Optional<Customer> optionalCustomer = customerDao.findCustomerById(customerId);
				
				if (optionalCustomer.isPresent()) {
					
					customer.getId();
					
					Customer customerUpdate = customerDao.saveCustomer(customer);
					
					ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
					responseStructure.setStatus(HttpStatus.OK.value());
					responseStructure.setMessage("Customer details update");
					responseStructure.setData(customerUpdate);
					
					ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
					
					return entity;
					
					
				} else {
					
					throw new CustomerIdNotPresentException();

				}
			}
				
		
				public ResponseEntity<ResponseStructure<Customer>> removeCustomer(long customerId) {
					
					Optional<Customer> CustomerOptional = customerDao.findCustomerById(customerId);
					
					if (CustomerOptional.isPresent()) {
						
						String removeCustomer = customerDao.removeCustomer(customerId);
						
						ResponseStructure<String> responseStructure = new ResponseStructure<>();
						responseStructure.setStatus(HttpStatus.NO_CONTENT.value());
						responseStructure.setMessage("Customer details are founded successfully");
						responseStructure.setData(removeCustomer);
						
						ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(HttpStatus.NO_CONTENT);
						
						return entity;
						
						
					} else {
						
						throw new CustomerIdNotPresentException();

					}
		
	}

}
