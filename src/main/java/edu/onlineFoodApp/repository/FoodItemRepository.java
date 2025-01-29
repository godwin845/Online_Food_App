package edu.onlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.FoodItems;

public interface FoodItemRepository extends JpaRepository<FoodItems, Long>{
		
	public FoodItems findByName(String name);
}
