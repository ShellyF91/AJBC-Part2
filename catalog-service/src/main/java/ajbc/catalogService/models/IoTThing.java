package ajbc.catalogService.models;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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

	
	public void addConnectedDevice(Device device) {
		
		connectedDevices.add(device);
	}
	
	public void removeConnectedDevice(Device device) {
		connectedDevices.remove(device);
	}
	
//	public Report createReport() {
//		
//	}
	
//	public void transmitReportsPeriodically() {
//		
//	}
	public List<Device> getConnectedDevices(){
		return connectedDevices;
	}
	
	@Override
	public String toString() {
		return String.format("IoTThing ID = %s, type = %s, model = %s, manufacturer = %s. Connected devices: %s", 
				ID, type, model, manufacturer, connectedDevices);
	}
	
	
	
}
