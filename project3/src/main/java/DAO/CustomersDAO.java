package DAO;

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

	public Customer getCustomerById(ObjectId id) {
		Customer customerFromDb = customersCollection.find(Filters.eq("_id", id)).first();
		return customerFromDb;
	}
	
	public Customer updateCustomerById(ObjectId id) {
		Bson filter = Filters.eq("_id", id); 
		Customer customerBeforeUpdate = getCustomerById(id);
		FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions()
				.returnDocument(ReturnDocument.AFTER);
		Customer updatedCustomer = customersCollection.findOneAndReplace(filter, customerBeforeUpdate, returnDocAfterReplace);
		return updatedCustomer;
	}
	
	public void deleteCustomerById(ObjectId id) {
		Bson filter = Filters.eq("_id", id);
		System.out.println(customersCollection.deleteOne(filter));
	}




}
