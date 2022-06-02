package ajbc.catalogService.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.InventoryReport;
import ajbc.catalogService.models.IoTThing;
import ajbc.catalogService.models.Type;

public class DBMock {
	
	private static DBMock instance = null; 
	private static Map<String, IoTThing> iotThingsMap; 
	private static Map<String, Device> deviceMap;
	
	public static synchronized DBMock getInstance() {
		if (instance == null)
			instance = new DBMock();
		return instance;
	}
	
	private DBMock(){
		iotThingsMap = new HashMap<String, IoTThing>();
		deviceMap = new HashMap<String, Device>();
		addToMapsDemo();
	}
	
	private void addToMapsDemo() {
		
		IoTThing thing1 = new IoTThing(Type.CONTROLLER,"2017","SE", new ArrayList<Device>());
		List<Device> devices = new ArrayList<Device>();
		devices.add(new Device(Type.SENSOR, "ff", "gg", thing1));
		IoTThing thing2 = new IoTThing(Type.ACTUATOR,"2017","SE", devices);
		IoTThing thing3 = new IoTThing(Type.SENSOR,"2017","SE", devices);
//		thing1.addConnectedDevice(new Device(Type.SENSOR, "ff", "gg", thing1));
//		thing2.addConnectedDevice(new Device(Type.SENSOR, "ff", "gg", thing2));
//		thing3.addConnectedDevice(new Device(Type.SENSOR, "ff", "gg", thing3));
		iotThingsMap.put(thing1.ID, thing1);
		iotThingsMap.put(thing2.ID, thing2);
		iotThingsMap.put(thing3.ID, thing3);
	}
	
	public Map<String, IoTThing> getIotThingsMap(){
		return iotThingsMap;
	}
	
	public Map<String, Device> getDeviceMap(){
		return deviceMap;
	}
	
	public static void main(String[] args) {
		DBMock db;
		db = DBMock.getInstance();
		System.out.println(db.getIotThingsMap().toString());
	}

}
