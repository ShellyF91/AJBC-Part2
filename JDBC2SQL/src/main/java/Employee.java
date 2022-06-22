
public class Employee {
	
	private int id; 
	private String firstName; 
	private String lastName; 
	private String email; 
	private String department;
	private float salary;
	
	public Employee(int id, String firstName, String lastName, String email, String department, float salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	
	public Employee(String firstName, String lastName, String email, String department, float salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Employee() {}
	
	
	

	
	
	
	

}
