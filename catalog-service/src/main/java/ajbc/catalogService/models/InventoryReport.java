package ajbc.catalogService.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class InventoryReport {
	
	private IoTThing ioTThing;
	private final String SERVER_NAME = "localhost";
	private final int SERVER_PORT = 9090, NUM_THREADS = 5;
	
	public InventoryReport(IoTThing ioTThing) {
		this.ioTThing = ioTThing;
	}
	
	public void startInventoryReport() throws InterruptedException {
		ScheduledExecutorService clientsService = Executors.newScheduledThreadPool(NUM_THREADS);
		clientsService.scheduleAtFixedRate(new InventoryReportRunnable(ioTThing),1, 5, TimeUnit.SECONDS);
	}
	
	public class InventoryReportRunnable implements Runnable{

		Socket clientSocket = null;
		PrintWriter writer = null;
		BufferedReader bufferReader = null;
		IoTThing ioTThing;
		
		public InventoryReportRunnable(IoTThing ioTThing) {
			this.ioTThing = ioTThing;
		}
		
		
		@Override
		public void run() {
			try {
				clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
				System.out.println("Connected to server");
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				Gson gson = new Gson();
				String thingJson = gson.toJson(ioTThing);
				writer.println(thingJson);
				System.out.println("sending the IoTThing:" + ioTThing);
				String line = bufferReader.readLine();
				System.out.println("server says: " + line);
			} catch (IOException e) {
				System.err.println("Socket failed");
				e.printStackTrace();
			}	finally {
				if(clientSocket != null)
					try {
						clientSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				if(bufferReader != null)
					try {
						bufferReader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				if(writer != null)
					writer.close();
			}	
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		IoTThing thing = new IoTThing(Type.ACTUATOR, "2017-ep", "lalala", new ArrayList<Device>()); 
		thing.addConnectedDevice(new Device(Type.SENSOR, "best model", "Solaredge", thing.getID()));
		InventoryReport report = new InventoryReport(thing);
		report.startInventoryReport();
		System.out.println(thing);
	}

}


