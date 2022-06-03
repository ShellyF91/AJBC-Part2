package ajbc.catalogService.resources;

import java.util.List;

import ajbc.catalogService.DBService.DBService;
import ajbc.catalogService.beans.DevicesFilterBean;
import ajbc.catalogService.beans.ThingsFilterBean;
import ajbc.catalogService.models.Device;
import ajbc.catalogService.models.IoTThing;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("devices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {
	
DBService dbService = new DBService();
	
	@GET
	public Response getAllDevices(){
		List<Device> list= dbService.getAllDevices();
		return Response.ok().entity(list).build();
	}

//	@GET
//	@Path("/{id}")
//	public Device getDevicesByID(@QueryParam("ID") String ID){
//		return dbService.getDevicesByID(ID);
//	}
	
//	@GET
//	@Path("/{model}")
//	public Response getDevicesByModel(@QueryParam("model") String model){
//		List<Device> list = dbService.getDevicesByModel(model);
//		return Response.ok().entity(list).build();
//	}
	
//	@GET
//	@Path("/{manufacturer}")
//	public Response getDevicesByManufacturer(@QueryParam("manufacturer") String manufacturer){
//		List<Device> list = dbService.getDevicesByManufacturer(manufacturer);
//		return Response.ok().entity(list).build();
//	}
	
//	@GET
//	@Path("/{type}")
//	public Response getDevicesByType(@QueryParam("type") String type){
//		List<Device> list = dbService.getDevicesByType(type);
//		return Response.ok().entity(list).build();
//	}
	
	@GET
	@Path("/filter")
	public Response getDevicesByFields(@BeanParam DevicesFilterBean devicesFilterBean) {
		List<Device> filteredList = dbService.getDevicesByFields(devicesFilterBean.getType(), devicesFilterBean.getModel(), devicesFilterBean.getManufacturer());
		return Response.ok().entity(filteredList).build();
	}

}
