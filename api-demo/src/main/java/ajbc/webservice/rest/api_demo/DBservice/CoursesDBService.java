package ajbc.webservice.rest.api_demo.DBservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ajbc.webservice.rest.api_demo.DB.studentsAndCoursesDB;
import ajbc.webservice.rest.api_demo.models.Course;

public class CoursesDBService {
	
	private studentsAndCoursesDB db;
	private Map<Long, Course> courses;
	
	public CoursesDBService() {
		db = studentsAndCoursesDB.getInstance();
		courses = db.getcourses();
	}
	
	//returns all the student from the DB as a list
	
	public List<Course> getAllCourses(){
		return new ArrayList<Course>(courses.values());
	}
	
	
	//add a course
	
	public Course addCourse(Course course) {
		courses.put(course.getNUMBER(), course);
		return course;
	}
	
//	
//	public Student getStudentById(long id) {
//		return students.get(id);
//	}
//	
//	//add student to DB
//	public Student addStudent(Student student) {
//		students.put(student.getID(), student);
//		return student;
//	}
//	
//
//	public List<Course> getCoursesByStudentId(long id) {
//	}

	
}
