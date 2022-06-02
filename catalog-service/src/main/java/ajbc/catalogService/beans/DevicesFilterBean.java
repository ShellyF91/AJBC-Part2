package ajbc.catalogService.beans;

import jakarta.ws.rs.QueryParam;

public class DevicesFilterBean {
	

	@QueryParam("model") String model;
	@QueryParam("manufacturer") String manufacturer;
	@QueryParam("type") String type;
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getType() {
		return type; 
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

}
