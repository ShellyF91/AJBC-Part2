package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import models.Customer;
import models.Order;

public class CustomersDAO {

	private MongoCollection<Customer> customersCollection;
	
	public CustomersDAO(MongoCollection<Customer> customersCollection) {
		this.customersCollection = customersCollection;
	}
	
	public void insertCustomer(Customer customer) {
		customersCollection.insertOne(customer);
	}

	public Customer getCustomerById(int id) {
		Customer customerFromDb = customersCollection.find(Filters.eq("_id", id)).first();
		return customerFromDb;
	}
	
	public Customer updateCustomer(Customer customer) {
		Bson filter = Filters.eq("_id", customer.getId()); 
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Customer updatedCustomer = customersCollection.findOneAndReplace(filter, customer, returnDocAfterReplace);
		return updatedCustomer;
	}
	
	public void deleteCustomerById(ObjectId id) {
		Bson filter = Filters.eq("_id", id);
		System.out.println(customersCollection.deleteOne(filter));
	}
	
	public List<Order> getOrdersById(int id, MongoCollection<Order> orderCollection){
		List<Order> ordersList = orderCollection.find(Filters.eq("customer_id", id)).into(new ArrayList<>());
		return ordersList;
	}





}
