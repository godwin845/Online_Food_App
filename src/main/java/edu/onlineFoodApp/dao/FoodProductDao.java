package edu.onlineFoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.FoodProduct;
import edu.onlineFoodApp.repository.FoodProductRepository;

@Repository
public class FoodProductDao {

    @Autowired
    FoodProductRepository foodProductRepository;
    

    public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
    	
        return foodProductRepository.save(foodProduct);
    }
    

    public Optional<FoodProduct> findFoodProductById(long id) {
    	
        return foodProductRepository.findById(id);
    }
    

    public List<FoodProduct> findAllFoodProducts() {
    	
        return foodProductRepository.findAll();
    }
    

    public String removeFoodProductById(long id) {
    	
        if (foodProductRepository.existsById(id)) {
        	
            foodProductRepository.deleteById(id);
            
            return "Food product removed successfully";
            
        } else {
        	
            return "Food product with id " + id + " not found";
        }
    }
    

    public List<FoodProduct> findFoodProductsByType(String type) {
    	
        return foodProductRepository.findAllByType(type);
    }
    

    public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
    	
        return foodProductRepository.save(foodProduct);
    }
    

    public List<FoodProduct> findFoodProductsByStaff(long userId) {
    	
        return foodProductRepository.findAll();
    }
    

	public List<FoodProduct> findFoodProduct() {
		
		return null;
	}
}
