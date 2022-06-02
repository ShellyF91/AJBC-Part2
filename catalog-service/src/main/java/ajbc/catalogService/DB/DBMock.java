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
		
		//creates things
		IoTThing thing1 = new IoTThing(Type.CONTROLLER,"2017","SE", new ArrayList<Device>());
		IoTThing thing2 = new IoTThing(Type.ACTUATOR,"2020","LK", new ArrayList<Device>());
		IoTThing thing3 = new IoTThing(Type.SENSOR,"2021","PO", new ArrayList<Device>());
		//creates devices 
		Device d1 = new Device(Type.ACTUATOR, "good model", "good manufacturer", thing1.ID);
		Device d2 = new Device(Type.CONTROLLER, "great model", "great manufacturer", thing1.ID);
		Device d3 = new Device(Type.SENSOR, "best model", "best manufacturer", thing2.ID);
		Device d4 = new Device(Type.ACTUATOR, "best model ever", "best manufacturer ever", thing2.ID);
		Device d5 = new Device(Type.CONTROLLER, "awesome model", "awesome manufacturer", thing3.ID);
		Device d6 = new Device(Type.ACTUATOR, "amazing model", "amazing manufacturer", thing3.ID);
		//creates device lists
		List<Device> devices1 = new ArrayList<Device>();
		List<Device> devices2 = new ArrayList<Device>();
		List<Device> devices3 = new ArrayList<Device>();
		//adding to device lists
		devices1.add(d1);
		devices1.add(d2);
		devices2.add(d3);
		devices2.add(d4);
		devices3.add(d5);
		devices3.add(d6);
		//adding devices to things
//		thing1.updateConnectedDevices(devices1);
//		thing2.updateConnectedDevices(devices2);
//		thing2.updateConnectedDevices(devices3);
		//creating IoTThings map 
		iotThingsMap.put(thing1.ID, thing1);
		iotThingsMap.put(thing2.ID, thing2);
		iotThingsMap.put(thing3.ID, thing3);
		//add to devices
		deviceMap.put(d1.ID, d1);
		deviceMap.put(d2.ID, d2);
		deviceMap.put(d3.ID, d3);
		deviceMap.put(d4.ID, d4);
		deviceMap.put(d5.ID, d5);
		deviceMap.put(d6.ID, d6);
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
