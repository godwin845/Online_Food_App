package edu.onlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineFoodApp.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);
	public User findByPhoneNumber(long phoneNumber);

}