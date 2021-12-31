package com.springapi.springapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springapi.springapi.entiies.Course;

@Service
public class CourseServiceImpl implements CourseService{
	 
	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(12,"Java","Basis of java"));
		list.add(new Course(13,"Python","Machine learning consept"));
	}

	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
		for(Course var1:list) {
			if (var1.getId() == courseId) {
				return var1;
			}
			
		}
		return null;
	}
	
	@Override
	public List<Course> setCourse(Course course){
		list.add(course);
		return list;
	}
	
	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}
	
	@Override
	public void deleteCourse(long parselong) {
		
		list=this.list.stream().filter(e->e.getId()!=parselong).collect(Collectors.toList());
	}
    
}
