package edu.onlineFoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.onlineFoodApp.dto.FoodProduct;
import edu.onlineFoodApp.service.FoodProductService;
import edu.onlineFoodApp.util.ResponseStructure;



@RestController
@RequestMapping("/api")
public class FoodProductController {
	@Autowired
	FoodProductService foodProductService;

	@PostMapping("saveFoodProduct")
	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(@RequestBody FoodProduct foodProduct)
	{
		return foodProductService.saveFoodProduct(foodProduct);
	}
	
	@GetMapping("findFoodProductByID")
	public ResponseEntity<ResponseStructure<FoodProduct>> findFoodProductById(@RequestParam long foodProductId)
	{
		return foodProductService.findFoodProductByID(foodProductId);
	}
	
	@GetMapping("findAllFoodProduct")
	public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct()
	{
		return foodProductService.findAllFoodProduct();
	}
	
	@DeleteMapping("removeFoodProductById")
	public ResponseEntity<ResponseStructure<String>> removeFoodProduct(@RequestParam long foodProductId)
	{
		return foodProductService.removeFoodProductById(foodProductId);
	}
}

