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

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Integer userId) {
		return userRepository.findById(userId);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		if (userRepository.existsById(user.getId())) {
			userRepository.save(user);
		} else {
			throw new RuntimeException("User with id: " + user.getId() + " not found");
		}
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
