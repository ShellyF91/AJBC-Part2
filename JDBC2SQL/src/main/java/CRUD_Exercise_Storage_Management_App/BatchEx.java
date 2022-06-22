package CRUD_Exercise_Storage_Management_App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchEx {
	
	public List<Item> addItems(Connection conn, List<Item> items){
		ItemDbService service = new ItemDbService();
		List<Item> ItemsBackFromDb = new ArrayList<Item>();
		for(var item: items) {
			addItem(conn, item);
			ItemsBackFromDb.add(service.getItem(conn, findItemLastId(conn)));
		}
		return ItemsBackFromDb;
	}
	
	public List<Location> addLocations(Connection conn, List<Location> locations){
		LocationDbService service = new LocationDbService();
		List<Location> locationsBackFromDb = new ArrayList<>();
		for(var location: locations) {
			addLocation(conn, location);
			locationsBackFromDb.add(service.getLocation(conn, findLocationLastId(conn)));
		}
		return locationsBackFromDb;
	}
	
	public void addItem(Connection conn, Item item) {
		String query = "Insert Into Item (itemName, UnitPrice, purchase_date, quantity)"
				+ "values(?,?,?,?)";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setString(1, item.getItemName());
			preparedStatement.setFloat(2, item.getPrice());
			preparedStatement.setObject(3, item.getDate());
			preparedStatement.setInt(4, item.getQuantity());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " rows has been affected.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addLocation(Connection conn, Location location) {
		String query = "Insert Into Location (locationName, accessCode)"
				+ "values(?,?)";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setString(1, location.getLocationName());
			preparedStatement.setString(2, location.getAccessCode());

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " rows has been affected.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void addItemsLocations(Connection conn, List<Item> items,  List<Location> locations) throws SQLException {
		for(int i = 0; i < items.size(); i++) {
			ItemLocation itemLocation = new ItemLocation(items.get(i).getItemId(), locations.get(i).getLocationId());
			addItemLocation(conn, itemLocation);
		}
	}
	
	public ItemLocation addItemLocation(Connection conn, ItemLocation itemLocation) throws SQLException {
		String query = "Insert Into ItemLocation (itemID, locationID)"
				+ "values(?,?)";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, itemLocation.getItemID());
			preparedStatement.setInt(2, itemLocation.getLocationID());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " rows has been affected.");
			return itemLocation;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return null;
	}
	
	public int findItemLastId(Connection conn) {
		ResultSet resultSet = null;
		int maxId = 0; 
		try (Statement statement = conn.createStatement()) {
			String query = "select max(ID) from Item";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				maxId = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maxId; 			
	}
	
	public int findLocationLastId(Connection conn) {
		ResultSet resultSet = null;
		int maxId = 0; 
		try (Statement statement = conn.createStatement()) {
			String query = "select max(ID) from Location";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				maxId = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maxId; 			
	}

}
