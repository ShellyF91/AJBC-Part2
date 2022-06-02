package ajbc.catalogService.models;

public class Device extends Hardware {
	
	public String ioTThingID;

	public Device(Type type, String model, String manufacturer, String ioTThingID) {
		super(type, model, manufacturer);
		this.ioTThingID = ioTThingID;
	}
	
	public Device() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("Device ID = %s, type = %s, model = %s, manufacturer = %s", ID, type, model, manufacturer);
	}

}
