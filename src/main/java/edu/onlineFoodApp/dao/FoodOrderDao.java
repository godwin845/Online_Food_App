package edu.onlineFoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.FoodOrders;
import edu.onlineFoodApp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepository foodOrderRepository;
	

	public FoodOrders saveFoodOrder(FoodOrders foodOrders  ) {

		return foodOrderRepository.save(foodOrders);
	}

	public Optional<FoodOrders> findFoodOrderById(long id) {
		
		Optional<FoodOrders> foodOrders = foodOrderRepository.findById(id);
		
		return foodOrders;
		
	}
	
	public List<FoodOrders> findAllOrders() {
		
		return foodOrderRepository.findAll();
		
	}
	
	public FoodOrders updateFoodOrders(FoodOrders foodOrders) {
		
		return foodOrderRepository.save(foodOrders);
		
	}
	
	public String removeFoodOrderById(long id) {
		
		foodOrderRepository.deleteById(id);
		
		return "Order removed successfully";
		
	}

	public List<FoodOrders> findAllFoodOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
