package com.lukaszosial.smartparking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukaszosial.smartparking.model.User;
import com.lukaszosial.smartparking.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public Optional<User> getProductById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}
}
