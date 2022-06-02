package ajbc.catalogService.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ajbc.catalogService.DB.DBMock;
import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.InventoryReport;
import ajbc.catalogService.models.IoTThing;
import ajbc.catalogService.models.Type;

public class DBService {
	
	DBMock db; 
	static Map<String,IoTThing> ioTThingMap;
	static Map<String, Device> devicesMap;
	
	public DBService() {
		db = DBMock.getInstance();
		ioTThingMap = db.getIotThingsMap();
		devicesMap = db.getDeviceMap();
	}
	
	public void updateDB(IoTThing ioTThing){
		//update IoTThings map 
		ioTThingMap.put(ioTThing.ID, ioTThing);
		//update devices map 
		List<Device> devicesList = ioTThing.getConnectedDevices();
		//put new devices in devices map
		for(int i = 0; i < devicesList.size(); i++) {
			devicesMap.put(devicesList.get(i).ID, devicesList.get(i));
		}
		//check for devices to remove 
		
//		Map<String,Device> devicesOfCurrentThing = devicesMap.
		
//		 for (Map.Entry<String,Device> entry : devicesMap.entrySet()) {
//			 if(entry.getValue().ioTThing.ID == ioTThing.ID && ! ioTThing.getConnectedDevices().contains(entry.getValue()))
//				 devicesMap.remove(entry.getKey());
//		 }
	}
	
	
	//methods for http requests
	

	public List<IoTThing> getAllIoTThings(){
		return ioTThingMap.values().stream().collect(Collectors.toList());
	}
	
	public IoTThing getThingsByID(String ID) {
		if(ioTThingMap.containsKey(ID))
			return ioTThingMap.get(ID);
		else
			return null;
	}

	
	public List<IoTThing> getThingsByModel(String model){
		return ioTThingMap.values().stream().filter((x)-> model.equals(x.model)).toList();
	}
	
	public List<IoTThing> getThingsByManufacturer(String manufacturer){
		return ioTThingMap.values().stream().filter((x)-> manufacturer.equals(x.manufacturer)).toList();
	}
	
	
	public List<IoTThing> getThingsByType(String type){
		Type t = Type.valueOf(type);
		return ioTThingMap.values().stream().filter((x)-> t.equals(x.type)).toList();
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		DBService service = new DBService();
//		IoTThing thing1 = new IoTThing(Type.SENSOR, "tgt", "ggg");
//		thing1.addConnectedDevice(new Device(Type.ACTUATOR, "tt", "hh", thing1));
//		IoTThing thing2 = new IoTThing(Type.SENSOR, "yuj", "7mf");
//		Device device2 = new Device(Type.ACTUATOR, "ytyt", "gfgfgf", thing2);
//		thing2.addConnectedDevice(device2);
//		thing2.addConnectedDevice(new Device(Type.CONTROLLER, "lll", "kkk", thing2));
//		service.updateDB(thing1);
//		service.updateDB(thing2);
//		System.out.println(devicesMap);
//		thing2.removeConnectedDevice(device2);
//		service.updateDB(thing2);
//		System.out.println(devicesMap);
		System.out.println(service.getAllIoTThings());

		
	}




}
