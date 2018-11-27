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

import com.letsstartcoding.springbootrestapiexample.dao.ProjectDAO;
import com.letsstartcoding.springbootrestapiexample.model.Project;

@RestController
@RequestMapping(value="/projectdetails", produces="application.json")
@CrossOrigin("*")
public class ProjectController {
	
	@Autowired
	ProjectDAO projectDAO;
	
	/* to save a project*/
	@PostMapping("/projects")
	public Project createTask(@Valid @RequestBody Project project) {
		return projectDAO.save(project);
	}
	
	/*get all projects*/
	@GetMapping("/projects")
	public List<Project> getAllTasks(){
		return projectDAO.findAll();
	}
	
	/*get project by projectid*/
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> getTaskById(@PathVariable(value="id") Long projectid){
		
		Project project=projectDAO.findOne(projectid);
		
		if(project==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(project);
		
	}
	
	
	/*update an project by projectid*/
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> updateTask(@PathVariable(value="id") Long projectid,@Valid @RequestBody Project projectDetails){
		
		Project project=projectDAO.findOne(projectid);
		if(project==null) {
			return ResponseEntity.notFound().build();
		}
		
		project.setProject_id(projectDetails.getProject_id());
		project.setPriority(projectDetails.getPriority());
		project.setPriority(projectDetails.getProject());
		
		Project updateProject=projectDAO.save(project);
		return ResponseEntity.ok().body(updateProject);
		
		
		
	}
	
	/*Delete a project*/
	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Project> deleteTask(@PathVariable(value="id") Long projectid){
		
		Project project=projectDAO.findOne(projectid);
		if(project==null) {
			return ResponseEntity.notFound().build();
		}
		projectDAO.delete(project);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

