package CRUD_Exercise_Storage_Management_App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exercise.Employee;

public class ItemDbService {
	
	public Item addItem(Connection conn, Item item) {
		try (Statement statement = conn.createStatement()) {
			String query = "Insert Into Item (itemName, UnitPrice, purchase_date, quantity)"
					+ "values('%s', '%f', '%s', '%d')".formatted(item.getItemName(), item.getPrice(), item.getDate().toString(), item.getQuantity());
			if (statement.executeUpdate(query) == 1) {
				System.out.println(item);
				return item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Item getItem(Connection conn, int id) {
		ResultSet resultSet = null;
		Item item = null;
		try (Statement statement = conn.createStatement()) {
			String query = "select * from  Item where ID = %d".formatted(id);
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				item = new Item();
				item.setItemId(resultSet.getInt(1));
				item.setItemName(resultSet.getString(2));
				item.setPrice(resultSet.getFloat(3));
				item.setDate(resultSet.getDate(4).toLocalDate());
				item.setQuantity(resultSet.getInt(5));
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
		return item;
	}
	
	public Item updateItem(Connection conn, Item item) {
		Item currItem = getItem(conn, item.getItemId());
		if(!item.equals(currItem) ) {
			try (Statement statement = conn.createStatement()) {
				String query = "Update Item set itemName='%s', UnitPrice='%f', purchase_date='%s', quantity = '%d'"
						.formatted(item.getItemName(), item.getPrice(), item.getDate().toString(), item.getQuantity());
				if (statement.executeUpdate(query) == 1) {
					return item;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("No change made to DB");
		return null;
	}
	
	public Item deleteItem(Connection conn, int id) {
		Item currItem = getItem(conn, id);
		if (currItem != null) {
			try (Statement statement = conn.createStatement()) {
				String query = "delete from Item where id = %d".formatted(id);
				if (statement.executeUpdate(query) == 1) {
					return currItem;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("No change made to DB");
		return null;
	} 

}
