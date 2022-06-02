package ajbc.catalogService.models;

public class Device extends Hardware {
	
	public IoTThing ioTThing;

	public Device(Type type, String model, String manufacturer, IoTThing ioTThing) {
		super(type, model, manufacturer);
		this.ioTThing = ioTThing;
	}
	
	public Device() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("Device ID = %s, type = %s, model = %s, manufacturer = %s", ID, type, model, manufacturer);
	}

}
