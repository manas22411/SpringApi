package com.springapi.springapi.services;

import java.util.List;

import com.springapi.springapi.entiies.Course;

public interface CourseService {
	
	public List<Course> getCourse();
	public Course getCourse(long course);
	public List<Course> setCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long course);
}
