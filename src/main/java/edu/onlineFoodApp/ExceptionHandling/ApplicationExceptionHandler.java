package edu.onlineFoodApp.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.onlineFoodApp.Exception.CustomerIdNotPresentException;
import edu.onlineFoodApp.Exception.FoodIdNotAvailableException;
import edu.onlineFoodApp.Exception.FoodItemIdNotFoundException;
import edu.onlineFoodApp.Exception.FoodItemIdNotPresent;
import edu.onlineFoodApp.Exception.FoodMenuIdNotPresentException;
import edu.onlineFoodApp.Exception.FoodOrderCustomerNotFoundException;
import edu.onlineFoodApp.Exception.FoodProductIdNotPresent;
import edu.onlineFoodApp.Exception.InCorrectPasswordException;
import edu.onlineFoodApp.Exception.InvalidEmailIdNotPresentException;
import edu.onlineFoodApp.Exception.NoSuchAFoodOrder;
import edu.onlineFoodApp.Exception.NoSuchDataFoundException;
import edu.onlineFoodApp.Exception.UserDataNotFoundInTheDatabase;
import edu.onlineFoodApp.Exception.UserRoleDoesNotMatch;
import edu.onlineFoodApp.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>> dataNotFound(NoSuchDataFoundException noSuchDataFoundException) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("No such data found in the database");
		responseStructure.setData(noSuchDataFoundException.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@ExceptionHandler(UserDataNotFoundInTheDatabase.class)
	public ResponseEntity<ResponseStructure<String>> userDataNotFound(UserDataNotFoundInTheDatabase userDataNotFoundInTheDatabase) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("user data not found in the database");
		responseStructure.setData(userDataNotFoundInTheDatabase.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}
	
	@ExceptionHandler(UserRoleDoesNotMatch.class)
	public ResponseEntity<ResponseStructure<String>> roledataNotFound(UserRoleDoesNotMatch userRoleDoesNotMatch) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User role not match with database");
		responseStructure.setData(userRoleDoesNotMatch.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}
	
	@ExceptionHandler(InvalidEmailIdNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmailId(InvalidEmailIdNotPresentException invalidEmailIdNotPresentException) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Invalid Email id");
		responseStructure.setData(invalidEmailIdNotPresentException.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}
	
	@ExceptionHandler(InCorrectPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> incorrectPassword(InCorrectPasswordException inCorrectPasswordException) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Incorrect password");
		responseStructure.setData(inCorrectPasswordException.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}
	
		@ExceptionHandler(FoodItemIdNotPresent.class)
		public ResponseEntity<ResponseStructure<String>> foodItemIdNotFound(FoodItemIdNotPresent foodItemIdNotPresent) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Food item id is correct");
			responseStructure.setData(foodItemIdNotPresent.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(FoodMenuIdNotPresentException.class)
		public ResponseEntity<ResponseStructure<String>> foodMenuIdNoFound(FoodMenuIdNotPresentException foodMenuIdNotPresentException) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Food menu id is incorrect either invalid");
			responseStructure.setData(foodMenuIdNotPresentException.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		
		@ExceptionHandler(FoodProductIdNotPresent.class)
		public ResponseEntity<ResponseStructure<String>> foodProductIdNotFound(FoodProductIdNotPresent foodProductIdNotPresent) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Food product id is incorrect");
			responseStructure.setData(foodProductIdNotPresent.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(CustomerIdNotPresentException.class)
		public ResponseEntity<ResponseStructure<String>> CustomerIdNotFound(CustomerIdNotPresentException customerIdNotPresentException) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Customer detail is incorrect");
			responseStructure.setData(customerIdNotPresentException.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(FoodOrderCustomerNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> foodMenuIdNotFound(FoodOrderCustomerNotFoundException foodOrderCustomerNotFoundException) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Invalid customer details");
			responseStructure.setData(foodOrderCustomerNotFoundException.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(NoSuchAFoodOrder.class)
		public ResponseEntity<ResponseStructure<String>> foodMenuIdNotPresent(NoSuchAFoodOrder noSuchAFoodOrder) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Food order not found");
			responseStructure.setData(noSuchAFoodOrder.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(FoodItemIdNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> foodItemIdNotPresent(FoodItemIdNotFoundException foodItemIdNotPresent) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Invalid item details");
			responseStructure.setData(foodItemIdNotPresent.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
		@ExceptionHandler(FoodIdNotAvailableException.class)
		public ResponseEntity<ResponseStructure<String>> foodItemIdNotPresent(FoodIdNotAvailableException foodIdNotAvailableException) {
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("No such data found in the database");
			responseStructure.setData(foodIdNotAvailableException.getMessage());
			
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
			
			return responseEntity;
			
		}
		
}
