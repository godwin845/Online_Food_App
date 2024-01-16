package edu.onlineFoodApp.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private double totalCost;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<FoodProduct> products;

	public List<FoodItems> getFoodItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFoodItems(ArrayList<FoodItems> foodItems) {
		// TODO Auto-generated method stub
		
	}

	public void setFoodItems(List<FoodItems> filterValidItems) {
		// TODO Auto-generated method stub
		
	}

}
