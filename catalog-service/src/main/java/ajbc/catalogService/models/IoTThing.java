package ajbc.catalogService.models;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IoTThing extends Hardware {
	
	List<Device> connectedDevices; 

	public IoTThing(Type type, String model, String manufacturer, List<Device> connectedDevices) {
		super(type, model, manufacturer);
//		connectedDevices = new ArrayList<Device>();
		this.connectedDevices = connectedDevices;
	}
	
	public IoTThing() {
		super();
	}

	public void updateConnectedDevices(List<Device> connectedDevices) {
		this.connectedDevices = connectedDevices;
	}
	
	
	public void addConnectedDevice(Device device) {
		connectedDevices.add(device);
	}
	
	public void removeConnectedDevice(Device device) {
		connectedDevices.remove(device);
	}

	public List<Device> getConnectedDevices(){
		return connectedDevices;
	}
	
	public List<Device> simulateInventoryChange() {
		Device d1 = new Device(Type.ACTUATOR, "very good model", "very good manufacturer", this.getID());
		Device d2 = new Device(Type.SENSOR, "very good model 2", "very good manufacturer 2", this.getID());
		Device d3 = new Device(Type.CONTROLLER, "very good model 3", "very good manufacturer 3", this.getID());
		Random random = new Random();
		int option = random.nextInt(3)+1;
		switch(option) {
			case 1: 
				addConnectedDevice(d1);
				break;
			case 2: 
				addConnectedDevice(d2);
				break;
			case 3: 
				addConnectedDevice(d3);
				removeConnectedDevice(connectedDevices.get(0));	
		}
		return connectedDevices;

	}
	
	
	@Override
	public String toString() {
		return String.format("IoTThing ID = %s, type = %s, model = %s, manufacturer = %s. Connected devices: %s", 
				this.getID(), this.getType(), this.getModel(), this.getManufacturer(), connectedDevices);
	}
	
	
	
}
