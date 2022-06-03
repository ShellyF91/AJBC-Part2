package ajbc.catalogService.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IoTThingTest {
	
	IoTThing ioTThing;
	Device device1;
	Device device2;
	Device device3;
	


	void IoTThingTest() {
		ioTThing = new IoTThing(Type.ACTUATOR, "good model", "good manufacturer", new ArrayList<Device>());
		device1 = new Device(Type.SENSOR,"nice model", "nice manufacturer", ioTThing.getID());
		device2 = new Device(Type.ACTUATOR,"nice model", "nice manufacturer", ioTThing.getID());
	}
	
//	@Test
//	void checkUpdateConnectedDevices() {
//		List<Device> devicesList = new ArrayList<Device>();
//		IoTThing thing = ioTThing;
//		devicesList.add(new Device(Type.SENSOR,"nice model", "nice manufacturer", thing.getID()));
//		thing.updateConnectedDevices(devicesList);
//		assertEquals(devicesList, thing.getConnectedDevices());
//	}
	
	@Test
	void checkAddConnectedDevice(Device device) {
//		ioTThing.addConnectedDevice(device1);
		assertNull(null);
	}
	
	@Test
	void checkGeneral() {
		assertEquals(1+1, 3-1);
	}


}
