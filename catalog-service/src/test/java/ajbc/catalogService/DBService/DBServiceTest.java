package ajbc.catalogService.DBService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ajbc.catalogService.DB.DBMock;
import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.IoTThing;

class DBServiceTest {
	
	DBService dbService = new DBService();;
	DBMock dbMock = DBMock.getInstance();

	@Test
	@DisplayName("Should show a list of IoTThings.")
	void checkGetAllIoTThings() {
		List<IoTThing> thingsList = dbService.getAllIoTThings();
		assertNotNull(thingsList);
	}
	
	@Test
	@DisplayName("Should show an IoTThing that matches the ID.")
	void checkGetThingsByID() {
		UUID someID = dbMock.getIotThingsMap().keySet().stream().toList().get(0);
		IoTThing thing = dbService.getThingsByID(someID);
		assertEquals(someID, thing.getID());
	}
	
	@Test
	@DisplayName("Should show a list of IoTThings filtered by the arguments.")
	void checkGetThingsByFields() {
		List<IoTThing> filterdList= dbService.getThingsByFields("SENSOR", "2021", "PO");
		assertNotNull(filterdList);
	}

}
