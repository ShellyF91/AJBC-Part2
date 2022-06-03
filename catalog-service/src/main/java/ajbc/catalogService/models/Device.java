package ajbc.catalogService.models;

import java.util.UUID;

public class Device extends Hardware {
	
	public UUID ioTThingID;

	public Device(Type type, String model, String manufacturer, UUID ioTThingID) {
		super(type, model, manufacturer);
		this.ioTThingID = ioTThingID;
	}
	
	public Device() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("Device ID = %s, type = %s, model = %s, manufacturer = %s", this.getID(), this.getType(), this.getModel(), this.getManufacturer());
	}

}
