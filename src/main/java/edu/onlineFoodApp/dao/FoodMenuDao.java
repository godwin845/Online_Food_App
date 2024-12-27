package edu.onlineFoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.FoodMenu;
import edu.onlineFoodApp.repository.FoodMenuRepository;

@Repository
public class FoodMenuDao {
	 
	@Autowired
	FoodMenuRepository foodMenuRepository;
	
	public FoodMenu saveFoodMenu(FoodMenu foodMenu) {
		
		return foodMenuRepository.save(foodMenu);
		
	}
	
	public Optional<FoodMenu> findFoodMenuById(Long foodMenuId) {
		
		Optional<FoodMenu> opt = foodMenuRepository.findById(foodMenuId);
		
		return opt;
		
	}
	
	public List<FoodMenu> findAllFoodMenu() {
		
		return foodMenuRepository.findAll();
		
	}
	
	public String removeFoodMenuById(Long foodMenuById) {
		
		foodMenuRepository.deleteById(foodMenuById);
		
		return "Data removed successfully";
		
	}
	
	public FoodMenu updateFoodMenu(FoodMenu foodMenu) {
		
		FoodMenu menu = foodMenuRepository.save(foodMenu);
		
		return menu;
		
	}

}
