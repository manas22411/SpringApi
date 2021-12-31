package com.springapi.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.springapi.entiies.Course;
import com.springapi.springapi.services.CourseService;

@RestController
public class MyController {
	@Autowired
	public CourseService var1;
	
	@GetMapping("/home")
	public String home() {
		return "Hello Manas here";
	}
	
	@GetMapping("/course")
	public List<Course> getCourse(){
		
		return this.var1.getCourse();
	}
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return this.var1.getCourse(Long.parseLong(courseId));
	}
	@PostMapping(path = "/course", consumes = "application/json")
	public List<Course> addCourse(@RequestBody Course course) {
		return this.var1.setCourse(course);
		
	}
	
	@PutMapping("/course/{courseId}")
	public Course updateCourse(@RequestBody Course course) {
		return this.var1.updateCourse(course);
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.var1.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
