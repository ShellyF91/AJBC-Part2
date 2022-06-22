package exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private String url;
	private String serverAddress;
	private String port;
	private String databaseName;
	private String serverName;
	private String userName;
	private String password;

	public ConnectionManager(String serverAddress, String port, String databaseName, String serverName, String userName,
			String password) {
		this.serverAddress = serverAddress;
		this.port = port;
		this.databaseName = databaseName;
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;
		buildUrl();
	}

	public void buildUrl() {
		this.url = "jdbc:sqlserver://" + serverAddress + ":" + port + ";databaseName=" + databaseName + ";servername="
				+ serverName + ";" + ";encrypt=false";
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}

	public static void main(String[] args) {
		String serverAddress = "localhost";
		String port = "1433";
		String databaseName = "JDBC-DEMO";
		String serverName = "LAPTOP-AD69TIIH";
		String userName = "Shelly";
		String password = "eses2020";

		try (Connection connection = new ConnectionManager(serverAddress, port, databaseName, serverName, userName, password).connect();){
			System.out.println("Connected");
//			Employee employee1 = new Employee("Moshe", "Levi", "ml@ggg.com", "HR", 2000);
//			Employee employee2 = new Employee("Eli", "Cohen", "ec@ggg.com", "HR", 5000);
//			Employee employee3 = new Employee("Avi", "Hatchol", "eu@ggg.com", "HR", 5000);
//			EmployeeDbService service = new EmployeeDbService();
//			service.addEmployee(connection, employee3);
//			service.deleteEmployee(connection, 1014);
//			Employee emp = service.getEmployee(connection, 1001);
//			employee2.setEmail("lalala@la.com");
//			service.updateEmployee(connection, employee2);
//			System.out.println(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
