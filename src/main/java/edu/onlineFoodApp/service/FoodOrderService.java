package edu.onlineFoodApp.service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.onlineFoodApp.Exception.CustomerIdNotPresentException;
import edu.onlineFoodApp.Exception.NoSuchAFoodOrder;
import edu.onlineFoodApp.Exception.NoSuchDataFoundException;
import edu.onlineFoodApp.dao.CustomerDao;
import edu.onlineFoodApp.dao.FoodItemDao;
import edu.onlineFoodApp.dao.FoodOrderDao;
import edu.onlineFoodApp.dao.FoodProductDao;
import edu.onlineFoodApp.dto.Customer;
import edu.onlineFoodApp.dto.FoodItems;
import edu.onlineFoodApp.dto.FoodOrders;
import edu.onlineFoodApp.dto.FoodProduct;
import edu.onlineFoodApp.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	FoodProductDao foodProductDao;
	
	public ResponseEntity<ResponseStructure<FoodOrders>> saveFoodOrder(FoodOrders foodOrders,long customerId)
	{
		Optional<Customer> customer=customerDao.findCustomerById(customerId);
		
		ArrayList<FoodItems> foodItems= new ArrayList<FoodItems>();
		
		if(customer.isPresent())
		{	
				foodOrders.setCustomer(customer.get());
				List<FoodItems> foodItems2=foodOrders.getFoodItems();
				List<FoodProduct> foodProducts=	foodProductDao.findFoodProduct();
				double cost=0; 
				
				for(FoodItems items: foodItems2)
				{
					for(FoodProduct foodProduct: foodProducts)
					{
						if(items.getName().equals(foodProduct.getName())) 
						{
							if(items.getQuantity() == foodProduct.getAvailability())
							{ 
									foodItems.add(items);
									double costPerItem=foodProduct.getTotalPrice();
									double discount=foodProduct.getDiscount();
									double finalPrice=(costPerItem)-((costPerItem/100)*discount);
									
									int quantityPerItem=items.getQuantity();
									
									cost=cost+(finalPrice*quantityPerItem);
							}
						}
					}
				}
				
			foodOrders.setFoodItems(foodItems);
			foodOrders.setTotalCost(cost);
			FoodOrders orders =	foodOrderDao.saveFoodOrder(foodOrders);
			ResponseStructure<FoodOrders> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Order Placed sucessfully");				
			responseStructure.setData(orders);
			
			ResponseEntity<ResponseStructure<FoodOrders>> entity=new ResponseEntity<ResponseStructure<FoodOrders>>(responseStructure, HttpStatus.CREATED);
		
			return entity;
		}		
		else 
			throw new CustomerIdNotPresentException();
	
	}
	
	public ResponseEntity<ResponseStructure<FoodOrders>> findFoodOrderByID(long id) {
		Optional<FoodOrders> foodOrders=foodOrderDao.findFoodOrderById(id);
		if(foodOrders.isPresent())
		{
			ResponseStructure<FoodOrders> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Food Order founded sucessfully.");
			responseStructure.setData(foodOrders.get());
			
			ResponseEntity<ResponseStructure<FoodOrders>> responseEntity=new ResponseEntity<ResponseStructure<FoodOrders>>(responseStructure, HttpStatus.OK);
			return responseEntity;
		}
		else
			throw new NoSuchAFoodOrder();
	}
	
	public ResponseEntity<ResponseStructure<List<FoodOrders>>> findAllFoodOrders()
	{
		
		List<FoodOrders> foodOrders=foodOrderDao.findAllOrders();
		if(foodOrders!=null)
		{
		ResponseStructure<List<FoodOrders>> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Data Save Sucessfull");
		responseStructure.setData(findAllFoodOrders());
		
		ResponseEntity<ResponseStructure<List<FoodOrders>>> responseEntity=new ResponseEntity<ResponseStructure<List<FoodOrders>>>(responseStructure, HttpStatus.OK);
		
		return responseEntity;
		}
		else
			throw new NoSuchDataFoundException();
	}
	
	public ResponseEntity<ResponseStructure<String>> removeFoodOrderById(long id)
	{
		Optional<FoodOrders> foodOrders=foodOrderDao.findFoodOrderById(id);
		if(foodOrders.isPresent())
		{
			String str=foodOrderDao.removeFoodOrderById(id);	
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("Food Order deliverd sucessfully.");		
			responseStructure.setData(str);
			
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
			return responseEntity;
		}
		else 
			throw new NoSuchAFoodOrder();
	}
	
	
}
