import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) {
		String conStr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC-DEMO;servername=LAPTOP-AD69TIIH;encrypt=false;";
		Connection connection = null;  
		try {
			connection = DriverManager.getConnection(conStr, "Shelly", "eses2020");
			if(connection.isValid(5))
				System.out.println("Connected to database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
