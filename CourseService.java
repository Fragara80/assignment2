package com.fran.assignment2;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fran.assignment2.model.Course;

@Path("/courseService")
public interface CourseService {
	
	@Path("/courses")
	@GET
	List<Course> getCourses();
	
	@Path("/courses/{id}")
	@GET
	Course getCourse(@PathParam("id")long id);
	
	@Path("/courses")
	@POST
	Response createCourse(Course course);
	
	@Path("/courses")
	@PUT
	Response updateCourse(Course course);
	
	@Path("/courses/{id}")
	@DELETE
	Response deleteCourse(@PathParam("id") long id);

}
