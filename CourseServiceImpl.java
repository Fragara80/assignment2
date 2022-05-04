package com.fran.assignment2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.fran.assignment2.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	Map<Long,Course> courses = new HashMap<>();
	long currentId = 123;
	
	public CourseServiceImpl() {
		init();
	}
	void init() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("Course1");
		course.setTaughtBy("Peter");
		course.setPrice(1000);
		course.setRating(5);
		courses.put(course.getId(), course);
	}
	
	@Override
	public List<Course> getCourses() {
		Collection<Course> results = courses.values();
		List<Course> response = new ArrayList<>(results);
		return response;
	}
	
	@Override
	public Course getCourse(long id) {
		
		return courses.get(id);
	}
	@Override
	public Response createCourse(Course course) {
		course.setId(++currentId);
		courses.put(course.getId(), course);
		return Response.ok(course).build();
	}
	@Override
	public Response updateCourse(Course course) {
		Course currentCourse = courses.get(course.getId());
		Response response;
		if (currentCourse != null) {
			courses.put(course.getId(), course);
			response = Response.ok().build(); 
		}else {
			response = Response.notModified().build();
		}
		return response;
	}
	@Override
	public Response deleteCourse(long id) {
		Course currentCourse = courses.get(id);
		Response response;
		if(currentCourse != null) {
			courses.remove(id);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}

}
