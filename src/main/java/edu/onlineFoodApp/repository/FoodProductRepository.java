package edu.onlineFoodApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.FoodProduct;


public interface FoodProductRepository extends JpaRepository<FoodProduct, Long>{
	
	public FoodProduct findByName(String name);
	public List<FoodProduct> findAllByType(String type);

}
