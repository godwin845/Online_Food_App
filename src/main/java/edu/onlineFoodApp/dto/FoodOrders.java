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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<FoodProduct> getProducts() {
		return products;
	}

	public void setProducts(List<FoodProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "FoodOrders [id=" + id + ", description=" + description + ", totalCost=" + totalCost + ", customer="
				+ customer + ", products=" + products + "]";
	}

	public List<FoodItems> getFoodItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFoodItems(ArrayList<FoodItems> foodItems) {
		// TODO Auto-generated method stub
		
	}
}
