package models;

import java.time.LocalDate;
import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import com.google.gson.annotations.SerializedName;

public class Order {
	

	private ObjectId id;
	@BsonProperty(value = "order_id")
	private int orderId;
	@BsonProperty(value = "customer_id")
	private int customerId;
	@BsonProperty(value = "order_date")
	private Date orderDate; 
	@BsonProperty(value = "start_date")
	private Date startDate;
	private int nights;
	@BsonProperty(value = "total_price")
	private double totalPrice;
	
	public Order(ObjectId id, int customerId, Date orderDate, Date startDate, int nights,
			double totalPrice) {
		this.id = id;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.nights = nights;
		this.totalPrice = totalPrice;
	}

	public Order(int orderId, int customerId, Date orderDate, Date startDate, int nights, double totalPrice) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.nights = nights;
		this.totalPrice = totalPrice;
	}
	
	public Order(int customerId, Date orderDate, Date startDate, int nights, double totalPrice) {
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.nights = nights;
		this.totalPrice = totalPrice;
	}
	
	public Order() {}
	

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
				+ ", startDate=" + startDate + ", nights=" + nights + ", totalPrice=" + totalPrice + "]";
	} 
	
	
	
	
	
	

}
