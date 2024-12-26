package edu.onlineFoodApp.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="User name can't be empty")
	private String name;	
	
	@Column(unique = true)
	@Email(message = "Invalid email id")
	private String email;
	
	@Column(unique = true)
	@Min(value = 600000001)
	@Max(value = 999999991)
	private long phoneNumber;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany
	private List<FoodOrders> foodOrders;

}
