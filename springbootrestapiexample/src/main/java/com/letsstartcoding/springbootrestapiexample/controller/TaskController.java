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

import com.letsstartcoding.springbootrestapiexample.dao.TaskDAO;
import com.letsstartcoding.springbootrestapiexample.model.Task;

@RestController
@RequestMapping(value="/taskdetails", produces="application.json")
@CrossOrigin("*")
public class TaskController {
	
	@Autowired
	TaskDAO taskDAO;
	
	/* to save a task*/
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskDAO.save(task);
	}
	
	/*get all tasks*/
	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskDAO.findAll();
	}
	
	/*get task by taskid*/
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value="id") Long taskid){
		
		Task task=taskDAO.findOne(taskid);
		
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(task);
		
	}
	
	
	/*update an task by taskid*/
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value="id") Long taskid,@Valid @RequestBody Task taskDetails){
		
		Task task=taskDAO.findOne(taskid);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		
		task.setParent_id(taskDetails.getParent_id());
		task.setProject_id(taskDetails.getProject_id());
		task.setPriority(taskDetails.getPriority());
		task.setStatus(taskDetails.getStatus());
		task.setTask(taskDetails.getTask());
		
		Task updateTask=taskDAO.save(task);
		return ResponseEntity.ok().body(updateTask);
		
		
		
	}
	
	/*Delete a task*/
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable(value="id") Long taskid){
		
		Task task=taskDAO.findOne(taskid);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		taskDAO.delete(task);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

