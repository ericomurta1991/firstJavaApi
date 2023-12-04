package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> searchUserById(@PathVariable Long id){
		return userService.searchUserByid(id);
	}
	
	@GetMapping
	public List<User> searchAllUsers(){
		return userService.searchAllUsers();
	}
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return userService.registerUser(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return userService.deleteUser(id);
	}
	
	
	
	
	
	
	
}
