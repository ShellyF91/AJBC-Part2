package CRUD_Exercise_Storage_Management_App;

import java.time.LocalDate;

public class Item {
	
	private int itemId; 
	private String itemName; 
	private float price; 
	private LocalDate purchaseDate; 
	private int quantity;
	
	public Item() {}

	public Item(String itemName, float price, LocalDate purchaseDate, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return purchaseDate;
	}

	public void setDate(LocalDate date) {
		this.purchaseDate = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", purchaseDate="
				+ purchaseDate + ", quantity=" + quantity + "]";
	}
	

	
	
	


}
