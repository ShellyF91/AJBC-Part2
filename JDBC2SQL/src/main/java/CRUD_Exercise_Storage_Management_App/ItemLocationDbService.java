package CRUD_Exercise_Storage_Management_App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemLocationDbService {
	

	public ItemLocation addItemLocation(Connection conn, ItemLocation itemLocation) {
		try (Statement statement = conn.createStatement()) {
			String query = "Insert Into ItemLocation (itemID, locationID)"
					+ "values('%d', '%d')".formatted(itemLocation.getItemID(), itemLocation.getLocationID());
			if (statement.executeUpdate(query) == 1) {
				return itemLocation;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
//	
//	public Location getLocation(Connection conn, int locationId) {
//		ResultSet resultSet = null;
//		Location location = null;
//		try (Statement statement = conn.createStatement()) {
//			String query = "select * from  Location where locationID = %d".formatted(locationId);
//			resultSet = statement.executeQuery(query);
//			if (resultSet.next()) {
//				location = new Location();
//				location.setLocationId(resultSet.getInt(1));
//				location.setLocationName(resultSet.getString(2));
//				location.setAccessCode(resultSet.getString(3));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				resultSet.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return location;
//	}
//	
//	public Location updateLocation(Connection conn, Location location) {
//		Location currLocation = getLocation(conn, location.getLocationId());
//		if(!location.equals(currLocation) ) {
//			try (Statement statement = conn.createStatement()) {
//				String query = "Update Location set locationName='%s', accessCode = '%s'"
//						.formatted(location.getLocationName(), location.getAccessCode());
//				if (statement.executeUpdate(query) == 1) {
//					return location;
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("No change made to DB");
//		return null;
//	}
//	
//	public Location deleteLocation(Connection conn, int id) {
//		Location currLocation = getLocation(conn, id);
//		if (currLocation != null) {
//			try (Statement statement = conn.createStatement()) {
//				String query = "delete from Location where locationID = %d".formatted(id);
//				if (statement.executeUpdate(query) == 1) {
//					return currLocation;
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("No change made to DB");
//		return null;
//	} 

}
