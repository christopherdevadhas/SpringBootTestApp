package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Task;
import com.letsstartcoding.springbootrestapiexample.repository.TaskRepository;

@Service
public class TaskDAO {
	
	@Autowired
	TaskRepository taskRepository;
	
	/*to save an employee*/
	
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	
	/* search all employees*/
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Task findOne(Long taskid) {
		return taskRepository.findOne(taskid);
	}
	
	
	/*delete an employee*/
	
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	

}
