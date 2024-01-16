package edu.onlineFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.onlineFoodApp.dto.FoodItems;
import edu.onlineFoodApp.service.FoodItemService;
import edu.onlineFoodApp.util.ResponseStructure;



@RestController
public class FoodItemController {

	@Autowired
	FoodItemService foodItemService;
	
	@PostMapping("saveFoodItem")
	public ResponseEntity<ResponseStructure<FoodItems>> saveFoodItem(@RequestBody FoodItems foodItems,@RequestParam long customerId)
	{
		return foodItemService.saveFoodItem(foodItems,customerId);
	}
	
	@GetMapping("findFoodItemById")
	public ResponseEntity<ResponseStructure<FoodItems>> saveFoodItem(@RequestParam long foodItemId)
	{
		return foodItemService.findFoodItemById(foodItemId);
	}
	
	@DeleteMapping("deleteFoodItemById")
	public ResponseEntity<ResponseStructure<String>> deleteFoodItem(@RequestParam long foodItemsId)
	{
		return foodItemService.deleteFoodItem(foodItemsId);
	}
}

