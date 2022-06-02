package ajbc.catalogService.resources;

import java.util.ArrayList;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import ajbc.catalogService.DBService.DBService;
import ajbc.catalogService.beans.ThingsFilterBean;
import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.IoTThing;
import ajbc.catalogService.models.Type;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("things")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IoTThingResource {
	
	DBService dbService = new DBService();
	
	@GET
	public Response getAllIoTThings(){
		List<IoTThing> list= dbService.getAllIoTThings();
		return Response.ok().entity(list).build();
	}

//	@GET
//	@Path("/{id}")
//	public IoTThing getThingsByID(@QueryParam("ID") String ID){
//		return dbService.getThingsByID(ID);
//	}
	
//	@GET
//	@Path("/{model}")
//	public List<IoTThing> getThingsByModel(@QueryParam("model") String model){
//		return dbService.getThingsByModel(model);
//	}
	
//	@GET
//	@Path("/{manufacturer}")
//	public List<IoTThing> getThingsByManufacturer(@QueryParam("manufacturer") String manufacturer){
//		return dbService.getThingsByManufacturer(manufacturer);
//	}
	
	@GET
	@Path("/{type}")
	public List<IoTThing> getThingsByType(@QueryParam("type") String type){
		return dbService.getThingsByType(type);
	}
	
//	@GET
//	public List<IoTThing> getThingsByProperties(@BeanParam ThingsFilterBean thingsFilterBean){
//		if
//	}
	 

}
