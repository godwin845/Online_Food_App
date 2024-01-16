package edu.onlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.FoodOrders;

public interface FoodOrderRepository extends JpaRepository<FoodOrders, Long>{
	

}
