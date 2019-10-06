package com.java.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.user.model.User;
import com.java.user.model.UserRepository;

@RequestMapping("api")
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("findAllUsers")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<User> getUsers() {
		System.out.println("find all ");
		return userRepository.findAll();
	}
	
	
	@PostMapping("addUser")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String saveBook(@RequestBody User user) {
		userRepository.save(user);
		return "Added book user id : " + user.getId();
	}

	@GetMapping("findAllUsers/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Optional<User> getBook(@PathVariable long id) {
		return userRepository.findById(id);
	}

	@DeleteMapping("delete/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public User deleteUser(@PathVariable long id) {
		System.out.println("deleting " + id);
		userRepository.deleteById(id);
		User user = new User();
		user.setId(id);
		return user;
	}
	
}
