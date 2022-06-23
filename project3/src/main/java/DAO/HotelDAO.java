package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Accumulators.*;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Sorts;

import models.Hotel;
import models.Order;


public class HotelDAO {

	private MongoCollection<Hotel> hotelsCollection;
	
	
	public HotelDAO(MongoCollection<Hotel> hotelsCollection) {
		this.hotelsCollection = hotelsCollection;
	}
	
	public void insertHotel(Hotel hotel) {
		hotelsCollection.insertOne(hotel);
	}
	
	public Hotel getHotelById(ObjectId id) {
		Hotel hotelFromDb = hotelsCollection.find(Filters.eq("_id", id)).first();
		return hotelFromDb;
	}
	
	public Hotel updateHotel(Hotel hotel) {
		Bson filter = Filters.eq("_id", hotel.getId()); 
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Hotel updatedHotel = hotelsCollection.findOneAndReplace(filter, hotel, returnDocAfterReplace);
		return updatedHotel;
	}
	
	public void deleteHotelById(ObjectId id) {
		Bson filter = Filters.eq("_id", id);
		System.out.println(hotelsCollection.deleteOne(filter));

	}
	
	public List<Hotel> findHotelsByCity(String city){
		List<Hotel> hotels = hotelsCollection.find(Filters.eq("address.city", city)).into(new ArrayList<>());
		return hotels;
	}
	
	
	public boolean isAvailableAtDate(ObjectId id, Date date, MongoCollection<Order> ordersCollection) {
		OrdersDAO ordersDAO = new OrdersDAO(ordersCollection);
		Hotel hotel = getHotelById(id);
		int numberOfRooms = hotel.getRooms().size();
		int counter = 0; 
		for(int i = 0; i < hotel.getOrders().size(); i++) {
			ObjectId orderid = hotel.getOrders().get(i);
			Order order = ordersDAO.getOrderById(orderid);
			if(order.getStartDate().equals(date))
				counter++;
		}
		return counter < numberOfRooms;
	}
	
	


}
