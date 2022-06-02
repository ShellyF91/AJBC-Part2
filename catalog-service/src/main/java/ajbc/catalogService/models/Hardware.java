package ajbc.catalogService.models;

import java.util.UUID;

public abstract class Hardware {
	//TODO check if the random gives unique
	public final String ID;
	public Type type;
	public String model;
	public String manufacturer;
	
	public Hardware(Type type, String model, String manufacturer) {
		ID = UUID.randomUUID().toString();
		this.type = type; 
		this.model = model;
		this.manufacturer = manufacturer;
	}
	
	public Hardware() {
		ID = UUID.randomUUID().toString();

	}
}









