package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;


@Service
public class UserService {
	private static Map<Long, User> userList = new HashMap<>();
	
	//search by id
	public ResponseEntity<User> searchUserByid(Long id){
		User user = userList.get(id);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);		
	}
	
	//search for  all users
	public List<User> serachAllUsers(){
		return new ArrayList<>(userList.values());
	}
	
	//Register User
	public ResponseEntity<User> registerUser(User user){
		userList.put(user.getId(), user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	//Update User
	public ResponseEntity<User> updateUser(User user){
		User userFound = userList.get(user.getId());
		if(userFound == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		userList.put(user.getId(), user);
		return ResponseEntity.status(HttpStatus.OK).body(userFound);
	}
	
	//Delete User
	public ResponseEntity<String> deleteUser(Long id){
		User userFound = userList.get(id);
		if(userFound == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		userList.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("user successfully deleted");
	}
	
	
	
	
	
	
}
