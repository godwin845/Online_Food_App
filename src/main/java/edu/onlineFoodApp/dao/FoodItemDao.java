package edu.onlineFoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.FoodItems;
import edu.onlineFoodApp.repository.FoodItemRepository;

@Repository
public class FoodItemDao {
	
	@Autowired
	FoodItemRepository foodItemRepository;
	

	public FoodItems saveFoodItem(FoodItems foodItems) {
		
		return foodItemRepository.save(foodItems);
		
	}
	
	public Optional<FoodItems> findFoodItemById(long foodItemId) {
		
		Optional<FoodItems> foodItems = foodItemRepository.findById(foodItemId);
		
		return foodItems;
		
	}
	
	public FoodItems findByName(String name) {
		
		FoodItems foodItems = foodItemRepository.findByName(name);
		
		return foodItems;
		
	}
	
	public String deleteFoodItem(long foodItemId) {
		
		foodItemRepository.deleteById(foodItemId);
		
		return "Food item deleted successfully";
		
	}

	public Optional<FoodItems> findCustomerById(long foodItemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
