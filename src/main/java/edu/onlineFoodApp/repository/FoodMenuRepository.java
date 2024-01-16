package edu.onlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long>{

}
