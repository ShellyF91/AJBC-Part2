package ajbc.catalogService.models;

import java.util.HashMap;

public class Runner {

	public static void main(String[] args) {
		
//		IoTThing iotThing = new IoTThing(Type.ACTUATOR, "2017", "solarEdge");
//		iotThing.addConnectedDevice(new Device(Type.SENSOR, "2018", "sumsung"));
//		iotThing.addConnectedDevice(new Device(Type.SENSOR, "2016", "lala"));
//		System.out.println(iotThing);
		
        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
  
        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");
        System.out.println(hash_map);

	}

}
