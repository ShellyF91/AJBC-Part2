package CRUD_Exercise_Storage_Management_App;

public class Location {
	
	private int locationId; 
	private String locationName; 
	private String accessCode;
	
	
	public Location(String locationName, String accessCode) {
		this.locationName = locationName;
		this.accessCode = accessCode;
	}
	
	public Location() {}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", accessCode=" + accessCode
				+ "]";
	}
	
	
	
	
	
	

}
