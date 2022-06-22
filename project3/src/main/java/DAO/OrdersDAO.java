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
import models.Order;

public class OrdersDAO {
	

	private MongoCollection<Order> ordersCollection;
	
	public OrdersDAO(MongoCollection<Order> ordersCollection) {
		this.ordersCollection = ordersCollection;
	}
	
	public void insertOrder(Order order) {
		ordersCollection.insertOne(order);
	}
	

	public Order getOrderById(ObjectId id) {
		Order orderFromDb = ordersCollection.find(Filters.eq("_id", id)).first();
		return orderFromDb;
	}
	
	public Order updateOrderById(ObjectId id) {
		Bson filter = Filters.eq("_id", id); 
		Order orderBeforeUpdate = getOrderById(id);
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Order updatedorder = ordersCollection.findOneAndReplace(filter, orderBeforeUpdate, returnDocAfterReplace);
		return updatedorder;
	}
	
	public void deleteOrderById(ObjectId id) {
		Bson filter = Filters.eq("_id", id);
		System.out.println(ordersCollection.deleteOne(filter));
	}

}
