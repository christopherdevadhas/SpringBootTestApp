package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Users;
import com.letsstartcoding.springbootrestapiexample.repository.UserRepository;

@Service
public class UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	/*to save an project*/
	
	public Users save(Users user) {
		return userRepository.save(user);
	}
	
	
	/* search all users*/
	
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	
	/*get an user by id*/
	public Users findOne(Long userid) {
		return userRepository.findOne(userid);
	}
	
	
	/*delete an user*/
	
	public void delete(Users user) {
		userRepository.delete(user);
	}
	

}
