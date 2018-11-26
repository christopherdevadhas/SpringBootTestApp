package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Project;
import com.letsstartcoding.springbootrestapiexample.repository.ProjectRepository;

@Service
public class ProjectDAO {
	
	@Autowired
	ProjectRepository projectRepository;
	
	/*to save an project*/
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	
	/* search all projects*/
	
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	
	
	/*get an Project by id*/
	public Project findOne(Long projectid) {
		return projectRepository.findOne(projectid);
	}
	
	
	/*delete an Project*/
	
	public void delete(Project project) {
		projectRepository.delete(project);
	}
	

}
