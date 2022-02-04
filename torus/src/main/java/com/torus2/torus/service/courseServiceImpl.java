package com.torus2.torus.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.torus2.torus.dao.CourseDao;
import com.torus2.torus.entities.Course;
import org.springframework.data.domain.Pageable;
@Service
public class courseServiceImpl implements CourseService {
  @Autowired
	private CourseDao courseDao;
	//List<Course> list;
	public  courseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(125,"Core java","basic"));
//		list.add(new Course(128,"Advance java","Advance"));
//		list.add(new Course(129,"SpringBoot","RestApi"));
		
	}
	@Override
	public List<Course> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Course> pagedResult= courseDao.findAll(paging);
		return pagedResult.toList();
	}
	@SuppressWarnings("deprecation")
	@Override
	public Optional<Course> getCourse(long courseId) {
		// TODO Auto-generated method stub
//	   Course c=null;
//	   for(Course course:list)
//	   {
//		   if(course.getId()==courseId) {
//			   c=course;
//			   break;
//		   }
//	   }
		return courseDao.findById(courseId);
	}
	
	@Override
	public Course addCourse(Course course)
	{
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course)
	{
//		list.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//				
//		});
		courseDao.save(course);
		
		return course;
	}
	@Override
	public Course deleteCourse(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	Course entity= courseDao.getOne(parseLong);
	courseDao.delete(entity);
   	return null;
	}
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
