package ajbc.webservice.rest.api_demo.DBservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ajbc.webservice.rest.api_demo.DB.studentsAndCoursesDB;
import ajbc.webservice.rest.api_demo.models.Course;
import ajbc.webservice.rest.api_demo.models.Student;

public class StudentsDBService {
	
	private studentsAndCoursesDB db;
	private Map<Long, Student> students;
	
	public StudentsDBService() {
		db = studentsAndCoursesDB.getInstance();
		students = db.getStudents();
	}
	
	//returns all the student from the DB as a list
	
	public List<Student> getAllStudents(){
		return new ArrayList<Student>(students.values());
	}
	
	public Student getStudentById(long id) {
		return students.get(id);
	}
	
	//add student to DB
	public Student addStudent(Student student) {
		if(students.containsKey(student.getID()))
			return null;
		students.put(student.getID(), student);
		return student;
	}
	
	//update existing student
	
	public Student updateStudent(long id, Student studentDetails) {
		if(students.containsKey(id)) {
			Student currStudent = students.get(id);
			currStudent.setAverage(studentDetails.getAverage());
			currStudent.setFirstName(studentDetails.getFirstName());
			currStudent.setLastName(studentDetails.getLastName());
			
			students.put(id, currStudent);
			return currStudent;
		}
		return null;
	}
	
	
	//delete a student from map
	
	public Student deleteStudent(long id) {
		return students.remove(id);
	}
	
	//get list of students with average >= {average}
	
	public List<Student> getStudentsByAverage(double average){
		return students.values().stream().filter(s->s.getAverage()>=average).collect(Collectors.toList());
	}

	public List<Student> getStudentsByAverage(double minAverage, double maxAverage) {
		return students.values().stream().filter(s->s.getAverage()>=minAverage && s.getAverage()<=maxAverage).collect(Collectors.toList());
	}
	
	//get courses of student
//	public List<Course> getCoursesByStudentId(long id){
//		return students.get(id).getCourses();
//	}
	

}