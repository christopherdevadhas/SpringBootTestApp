package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.UserDAO;
import com.letsstartcoding.springbootrestapiexample.model.Users;

@RestController
@RequestMapping(value="/userdetails", produces="application/json")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	/* to save a user*/
	@PostMapping("/users")
	public Users createTask(@Valid @RequestBody Users user) {
		return userDAO.save(user);
	}
	
	/*get all users*/
	@GetMapping("/users")
	public List<Users> getAllTasks(){
		return userDAO.findAll();
	}
	
	/*get user by userid*/
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getTaskById(@PathVariable(value="id") Long userid){
		
		Users user=userDAO.findOne(userid);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
		
	}
	
	
	/*update an user by userid*/
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateTask(@PathVariable(value="id") Long userid,@Valid @RequestBody Users userDetails){
		
		Users user=userDAO.findOne(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		
		user.setUser_id(userDetails.getUser_id());
		user.setFirst_name(userDetails.getFirst_name());
		user.setLast_name(userDetails.getLast_name());
		user.setEmployee_id(userDetails.getEmployee_id());
		user.setProject_id(userDetails.getProject_id());
		user.setTask_id(userDetails.getTask_id());
		
		
		Users updateUser=userDAO.save(user);
		return ResponseEntity.ok().body(updateUser);
		
		
		
	}
	
	/*Delete a user*/
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Users> deleteTask(@PathVariable(value="id") Long userid){
		
		Users user=userDAO.findOne(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(user);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

