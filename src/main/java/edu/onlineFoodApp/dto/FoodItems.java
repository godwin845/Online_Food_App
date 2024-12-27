package edu.onlineFoodApp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double price;
	
	@Column(length = 3000)
	private String description;
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private Type type;

}
