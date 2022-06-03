package ajbc.catalogService.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import ajbc.catalogService.DB.DBMock;
import ajbc.catalogService.DBService.DBService;
import ajbc.catalogService.models.IoTThing;

public class InventoryServer extends Thread {
	
	private final int PORT = 9090;
	DBService dbService = new DBService();
	ExecutorService executorService;
	
	@Override
	public void run() {
		startInventoryServer();
	}
	
	
	public void startInventoryServer() {
		executorService = Executors.newCachedThreadPool();
		try (ServerSocket serverSocket = new ServerSocket(PORT);) {
			System.out.println("Inventory Server started on port " + PORT);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				executorService.execute(new InventoryServerRunnable(clientSocket, dbService));
			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		}
	}
	
	public void kill() {

		try {
			executorService.shutdown();
			executorService.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private class InventoryServerRunnable implements Runnable {
		
		private Socket clientSocket;
		DBService dbService;
		BufferedReader bufferReader;
		PrintWriter writer;
		JsonReader jsonReader;

		public InventoryServerRunnable(Socket clientSocket, DBService dbService) {
			this.clientSocket = clientSocket;
			this.dbService = dbService;
			bufferReader = null;
			writer = null; 
			jsonReader = null;
		}
		
		
		@Override
		public void run() {
			
		
		try {
			bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			
			System.out.println("Client is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());
			
			String line = bufferReader.readLine();
			Gson gson = new Gson();
			IoTThing ioTThing = gson.fromJson(line, IoTThing.class);
			System.out.println("A new report has arrived: " + ioTThing);
			sendToDB(ioTThing);
			writer.println("The report was sent to the DB.");
			
			System.out.println("Checking if the DB was updated:");
			DBMock db = DBMock.getInstance();
			System.out.println(db.getIotThingsMap());
		}  catch (IOException e) {
			e.printStackTrace();
		} finally {
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

		private synchronized void sendToDB(IoTThing ioTThing) {
			dbService.updateDB(ioTThing);
		}
		
}


//	public static void main(String[] args) throws InterruptedException {
//		InventoryServer inventoryServer = new InventoryServer();
//		inventoryServer.startInventoryServer();
//	}

}
