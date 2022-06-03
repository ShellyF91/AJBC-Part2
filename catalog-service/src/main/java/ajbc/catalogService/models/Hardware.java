package ajbc.catalogService.models;

import java.util.UUID;

public abstract class Hardware {
	//TODO check if the random gives unique
	private final UUID ID;
	private Type type;
	private String model;
	private String manufacturer;
	
	public Hardware(Type type, String model, String manufacturer) {
		ID = UUID.randomUUID();
		setType(type);
		setModel(model);
		setManufacturer(manufacturer);
	}
	
	public Hardware() {
		ID = UUID.randomUUID();
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public UUID getID() {
		return ID;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	
	
}









