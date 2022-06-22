package CRUD_Exercise_Storage_Management_App;

public class ItemLocation {
	private int itemID;
	private int locationID; 
	
	public ItemLocation() {}
	
	public ItemLocation(int itemID, int locationID) {
		this.itemID = itemID;
		this.locationID = locationID;
	}
	

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	@Override
	public String toString() {
		return "ItemLocation [itemID=" + itemID + ", locationID=" + locationID + "]";
	}
	
	
}
