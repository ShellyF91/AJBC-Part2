package ajbc.webservice.rest.api_demo.resources;

import java.util.List;

import ajbc.webservice.rest.api_demo.DBservice.CoursesDBService;
import ajbc.webservice.rest.api_demo.models.Course;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/courses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CoursesResource {
	
	CoursesDBService coursesDB = new CoursesDBService();
	
	@GET
	public List<Course> getAllCourses(){
		return coursesDB.getAllCourses();
	}
	
//	@GET
//	public List<Course> getCourseByStudentId(@PathParam("id")long id){
//		return coursesDB.getCoursesByStudentId(id);
//		
//	}
	
	@POST
	public Course addCourse(Course course) {
		return coursesDB.addCourse(course);
	}

}
