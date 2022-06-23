package runner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.slf4j.LoggerFactory;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import com.google.gson.Gson;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.InsertOneResult;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import DAO.CustomersDAO;
import DAO.HotelDAO;
import DAO.OrdersDAO;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import models.Address;
import models.Customer;
import models.Hotel;
import models.Order;
import models.Room;
import utils.MyConnectionString;

public class Runner {

	public static void main(String[] args) {
		
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.ERROR);

		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(MyConnectionString.uri())
				.codecRegistry(codecRegistry).serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
				.build();
//		
//		Room roomHermoso1 = new Room(111, true, 2);
//		Room roomHermoso2 = new Room(112, true, 2);
//		Room roomHermoso3 = new Room(113, false, 2);
//		Room roomHermoso4 = new Room(114, false, 2);
//		List<Room> hermosoRooms = new ArrayList<>();
//		hermosoRooms.add(roomHermoso1);
//		hermosoRooms.add(roomHermoso2);
//		hermosoRooms.add(roomHermoso3);
//		hermosoRooms.add(roomHermoso4);
//		
//		Room roomLindo1 = new Room(201, true, 4);
//		Room roomLindo2 = new Room(202, true, 4);
//		Room roomLindo3 = new Room(203, false, 4);
//		List<Room> lindoRooms = new ArrayList<>();
//		lindoRooms.add(roomLindo1);
//		lindoRooms.add(roomLindo2);
//		lindoRooms.add(roomLindo3);
//		
//		Room roomBello1 = new Room(10, true, 3);
//		Room roomBello2 = new Room(11, true, 3);
//		List<Room> belloRooms = new ArrayList<>();
//		belloRooms.add(roomBello1);
//		belloRooms.add(roomBello2);
		
//		Address addressHermoso = new Address("Yaffo", 50, "Jerusalem", "Israel");
//		Address addressLindo = new Address("Dizengoff", 12, "Tel-Aviv", "Israel");
//		Address addressBello = new Address("Yefe-Nof", 35, "Haifa", "Israel");
//		
//		Hotel hermoso = new Hotel("Hermoso", addressHermoso, 8.9, new ArrayList<Room>(), 670, new ArrayList<ObjectId>());
//		Hotel lindo = new Hotel("Lindo", addressLindo, 9.1, new ArrayList<Room>(), 850, new ArrayList<ObjectId>());
//		Hotel bello = new Hotel("Bello", addressBello, 9.0, new ArrayList<Room>(), 580, new ArrayList<ObjectId>());
//		
//		Customer customer1 = new Customer(302222971, "Shelly", "Foran", "Israel", new ArrayList<Order>());
//		Customer customer2 = new Customer(21928486, "Eran", "Krivine", "Israel", new ArrayList<Order>());
//
//		Order order1 = new Order(bello.getId(), customer1.getId(),Date.valueOf(LocalDate.now()) ,Date.valueOf("2022-07-22"), 2, 1160);
//		Order order2 = new Order(hermoso.getId(), customer2.getId(),Date.valueOf(LocalDate.now()) ,Date.valueOf("2022-11-04"), 2, 1340);
//	


		try (MongoClient mongoClient = MongoClients.create(settings)) {

			MongoDatabase myDB = mongoClient.getDatabase("Booking_Reservations_project");
			MongoCollection<Hotel> hotelCollection = myDB.getCollection("Hotels", Hotel.class);
			MongoCollection<Order> orderCollection = myDB.getCollection("Orders", Order.class);
			MongoCollection<Customer> customersCollection= myDB.getCollection("Customers", Customer.class);


			//checking ex 2
//			HotelDAO hotelDAO = new HotelDAO(hotelCollection);
//			List<Hotel> hotels = hotelDAO.findHotelsByCity("Haifa");
//			System.out.println(hotels);
			
			//ex 3
			
//			HotelDAO hotelDAO = new HotelDAO(hotelCollection);
//			ObjectId objectId1 = new ObjectId("62b2cb94329d591d2dd10c57");
//			Hotel lindo = hotelDAO.getHotelById(objectId1);
//			ObjectId objectId2 = new ObjectId("62b2cb94329d591d2dd10c58");
//			Hotel bello = hotelDAO.getHotelById(objectId2);
//			ObjectId objectId3 = new ObjectId("62b2cb94329d591d2dd10c59");
//			Hotel hermoso = hotelDAO.getHotelById(objectId3);
//			
//			lindo.setRooms(lindoRooms);
//			bello.setRooms(belloRooms);
//			hermoso.setRooms(hermosoRooms);
//			
//			hotelDAO.updateHotel(hermoso);
//			hotelDAO.updateHotel(lindo);
//			hotelDAO.updateHotel(bello);
			
			hotelCollection.aggregate(Arrays.asList(Aggregates.sort(descending("_id"))));
			System.out.println("end");
			
			
		}

	}

}
	
