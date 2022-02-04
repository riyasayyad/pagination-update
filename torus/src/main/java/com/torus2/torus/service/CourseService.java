package com.torus2.torus.service;

import java.util.List;
import java.util.Optional;

import com.torus2.torus.entities.Course;

public interface CourseService {
	public List<Course> getCourse();
	public Optional<Course> getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public Course deleteCourse(long parseLong);
	public List<Course> findPaginated(int pageNo, int PageSize);
	
   
}
