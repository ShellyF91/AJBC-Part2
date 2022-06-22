package CRUD_Exercise_Storage_Management_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
			
			// checking itemDbService
			
//			Item item1 = new Item("machine", 99.9f, LocalDate.now(), 5);
//			ItemDbService service = new ItemDbService();
//			service.addItem(connection, item1);
//			service.deleteItem(connection, 1001);
//			Item itemFromGet = service.getItem(connection, 1000);
//			System.out.println(itemFromGet);
//			itemFromGet.setItemName("Machine2022");
//			service.updateItem(connection, itemFromGet);
			
			// checking locationDbService
			
//			Location location = new Location("TA", "123abc");
//			LocationDbService locationService = new LocationDbService();
//			locationService.addLocation(connection, location);
//			Location locFromGet = locationService.getLocation(connection, 1000);
//			System.out.println(locFromGet);
//			locFromGet.setLocationName("TA - tel aviv");
//			locationService.updateLocation(connection, locFromGet);
//			locationService.deleteLocation(connection, 1000);
			
			Item item1 = new Item("item1", 100.9f, LocalDate.now(), 9);
			Item item2 = new Item("item2", 100.9f, LocalDate.now(), 6);
			Item item3 = new Item("item3", 100.9f, LocalDate.now(), 4);
			List<Item> items = new ArrayList<>();
			items.add(item2);
			items.add(item3);
			BatchEx batchEx = new BatchEx();
			List<Item> itemsFromDb = batchEx.addItems(connection, items);
			System.out.println(itemsFromDb.get(0));
//			Location location1 = new Location("Haifa", "aaa111");
//			Location location2 = new Location("Jerusalem", "bbb222");
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
