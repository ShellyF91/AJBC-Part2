package ajbc.catalogService.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import ajbc.catalogService.DB.DBMock;
import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.InventoryReport;
import ajbc.catalogService.models.IoTThing;
import ajbc.catalogService.models.Type;

public class DBService {
	
	DBMock db; 
	static Map<UUID,IoTThing> ioTThingMap;
	static Map<UUID, Device> devicesMap;
	
	public DBService() {
		db = DBMock.getInstance();
		ioTThingMap = db.getIotThingsMap();
		devicesMap = db.getDeviceMap();
	}
	
	public void updateDB(IoTThing ioTThing){
		//update IoTThings map 
		ioTThingMap.put(ioTThing.getID(), ioTThing);
		//update devices map 
		List<Device> devicesList = ioTThing.getConnectedDevices();
		//put new devices in devices map
		for(int i = 0; i < devicesList.size(); i++) {
			devicesMap.put(devicesList.get(i).getID(), devicesList.get(i));
		}
		//check for devices to remove 
		
		List<Device> devicesOfCurrentThing = ioTThing.getConnectedDevices();
		
		 for (Map.Entry<UUID,Device> entry : devicesMap.entrySet()) {
			 if(entry.getValue().ioTThingID == ioTThing.getID() && ! devicesOfCurrentThing.contains(entry.getValue()))
				 devicesMap.remove(entry.getKey());
		 }
	}
	
	
	//methods for http requests
	
	//things
	
	public List<IoTThing> getAllIoTThings(){
		return ioTThingMap.values().stream().collect(Collectors.toList());
	}
	
	public IoTThing getThingsByID(UUID ID) {
		if(ioTThingMap.containsKey(ID))
			return ioTThingMap.get(ID);
		else
			return null;
	}

	
	public List<IoTThing> getThingsByModel(String model){
		return ioTThingMap.values().stream().filter((x)-> model.equals(x.getModel())).toList();
	}
	
	public List<IoTThing> getThingsByManufacturer(String manufacturer){
		return ioTThingMap.values().stream().filter((x)-> manufacturer.equals(x.getManufacturer())).toList();
	}
	
	
	public List<IoTThing> getThingsByType(String type){
		Type t = Type.valueOf(type);
		return ioTThingMap.values().stream().filter((x)-> t.equals(x.getType())).toList();
	}
	
	public List<IoTThing> getThingsByFields(String type, String model, String manufacturer){
		List<IoTThing> ThingsList = ioTThingMap.values().stream().collect(Collectors.toList());
		List<IoTThing> filteredThingsList = new ArrayList<IoTThing>();
		for(IoTThing ioTThing : ThingsList) {
			if(ioTThing.getType().toString().equals(type)&& ioTThing.getModel().equals(model) && ioTThing.getManufacturer().equals(manufacturer))
				filteredThingsList.add(ioTThing);
		}
		return filteredThingsList;
	}
	
	
	
	//devices
	
	public List<Device> getAllDevices(){
		return devicesMap.values().stream().collect(Collectors.toList());
	}
	
	public Device getDevicesByID(String ID) {
		if(devicesMap.containsKey(ID))
			return devicesMap.get(ID);
		else
			return null;
	}
	
	public List<Device> getDevicesByModel(String model){
		return devicesMap.values().stream().filter((x)-> model.equals(x.getModel())).toList();
	}
	
	public List<Device> getDevicesByManufacturer(String manufacturer){
		return devicesMap.values().stream().filter((x)-> manufacturer.equals(x.getManufacturer())).toList();
	}
	
	public List<Device> getDevicesByType(String type){
		return devicesMap.values().stream().filter((x)-> type.equals(x.getType().toString())).toList();
	}
	

	public List<Device> getDevicesByFields(String type, String model, String manufacturer){
		List<Device> deviceList = devicesMap.values().stream().collect(Collectors.toList());
		List<Device> filteredDevicesList = new ArrayList<Device>();
		for(Device device : deviceList) {
			if(device.getType().toString().equals(type)&& device.getModel().equals(model) && device.getManufacturer().equals(manufacturer))
				filteredDevicesList.add(device);
		}
		return filteredDevicesList;
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
