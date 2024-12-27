package edu.onlineFoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineFoodApp.dto.User;
import edu.onlineFoodApp.repository.UserRepository;

@Repository
public class UserDao {
	
	final static Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User saveUser(User user) {
		
		logger.info("Entering the user DAO class in saveUser(User user) Method");
		
		User user2 = userRepository.save(user);
		
		logger.info("Existing the user DAO class in saveUser(User user) Method");
		
		return user2;
		
	}
	
	public Optional<User> findById(Long userId) {
		
		logger.info("Entering the user DAO class in findById(long userId) Method");
		
		Optional<User> u = userRepository.findById(userId);
		
		logger.info("exiting the user DAO class in findById(long userId) Method");
		
		return u;
		
	}
	

	public Optional<User> findByNumber(Long phoneNumber) {
		
		logger.info("Entering the user DAO class in findByNumber(Long phoneNumber) Method");
		
		User u = userRepository.findByPhoneNumber(phoneNumber);
		
		logger.info("exiting the user DAO class in findByNumber(Long phoneNumber) Method");
		
		return Optional.ofNullable(u);
		
	}
	
	public List<User> findAllUser() {
		
		logger.info("Entering the user DAO class in findAllUser() Method");
		
		List<User> list = userRepository.findAll();
		
		logger.info("exiting the user DAO class in findAllUser() Method");
		
		return list;
		
	}
	
	public User updateUser(User user) {
		
		logger.info("Entering the user DAO class in updateUser(User user) Method");
		
		User userUpdate = userRepository.save(user);
		
		logger.info("exiting the user DAO class in updateUser(User user) Method");
		
		return userUpdate;
		
	}
	
	public String removeUser(Long id) {
		
		logger.info("Entering the User DAO class in removeUser(long id) Method");
		
		userRepository.deleteById(id);
		
		logger.info("Exiting the User DAO class in removeUser(long id) Method");
		
		return "User details removed";
		
	}

	public Optional<User> findByEmail(String email) {
		return null;
	}
}
