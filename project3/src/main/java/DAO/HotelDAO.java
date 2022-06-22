package DAO;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import models.Hotel;


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
	
	public Hotel updateHotelById(ObjectId id) {
		Bson filter = Filters.eq("_id", id); 
		Hotel hotelBeforeUpdate = getHotelById(id);
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Hotel updatedHotel = hotelsCollection.findOneAndReplace(filter, hotelBeforeUpdate, returnDocAfterReplace);
		return updatedHotel;
	}
	
	public void deleteHotelById(ObjectId id) {
		Bson filter = Filters.eq("_id", id);
		System.out.println(hotelsCollection.deleteOne(filter));

	}

}
