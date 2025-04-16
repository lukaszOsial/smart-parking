package com.lukaszosial.smartparking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukaszosial.smartparking.model.User;
import com.lukaszosial.smartparking.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(Integer userId) {
		return userRepository.findById(userId);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
