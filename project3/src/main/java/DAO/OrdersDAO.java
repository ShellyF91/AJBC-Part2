package DAO;

import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import models.Customer;
import models.Hotel;
import models.Order;

public class OrdersDAO {
	

	private MongoCollection<Order> ordersCollection;
	
	
	public OrdersDAO(MongoCollection<Order> ordersCollection) {
		this.ordersCollection = ordersCollection;
	}
	
	public void insertOrder(ObjectId hotelId ,Order order, MongoCollection<Hotel> hotelsCollection, MongoCollection<Customer> customersCollection) {
		Date date = order.getStartDate();
		HotelDAO hotelDAO = new HotelDAO(hotelsCollection);
		CustomersDAO customersDAO = new CustomersDAO(customersCollection);
		boolean isAvailable = hotelDAO.isAvailableAtDate(hotelId, date, ordersCollection);
		if(isAvailable) {
			ordersCollection.insertOne(order);
			//adding to the hotel 
			Order newOrderFromDB = getOrderByIdForInnerUse(order.getOrderId());
			Hotel hotelToUpdate = hotelDAO.getHotelById(hotelId);
			hotelToUpdate.getOrders().add(newOrderFromDB.getId());
			hotelDAO.updateHotel(hotelToUpdate);
			//adding to the customer
			Customer customer = customersDAO.getCustomerById(order.getCustomerId());
			customer.getOrders().add(newOrderFromDB);
			customersDAO.updateCustomer(customer);
		}
		
		else
			System.out.println("The hotel is not available for this order.");
	}
	

	public Order getOrderById(ObjectId id) {
		Order orderFromDb = ordersCollection.find(Filters.eq("_id", id)).first();
		return orderFromDb;
	}
	
	public Order getOrderByIdForInnerUse(int id) {
		Order orderFromDb = ordersCollection.find(Filters.eq("order_id", id)).first();
		return orderFromDb;
	}
	
	public Order updateOrder(Order order) {
		Bson filter = Filters.eq("_id", order.getId()); 
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Order updatedorder = ordersCollection.findOneAndReplace(filter, order, returnDocAfterReplace);
		return updatedorder;
	}
	
	public void deleteOrderById(ObjectId id,  MongoCollection<Hotel> hotelsCollection, MongoCollection<Customer> customersCollection) {
		
		Order orderToDelete = getOrderById(id);
		
		HotelDAO hotelDAO = new HotelDAO(hotelsCollection);
		CustomersDAO customersDAO = new CustomersDAO(customersCollection);
		//delete from the customer
		Customer customer = customersDAO.getCustomerById(orderToDelete.getCustomerId());
		customer.getOrders().remove(orderToDelete);
		customersDAO.updateCustomer(customer);
		//delete from the hotel
		//TODO 
		//delete from Orders db
		Bson filter = Filters.eq("_id", id);
		System.out.println(ordersCollection.deleteOne(filter));
		

		
		
		

	}
	
	


}
