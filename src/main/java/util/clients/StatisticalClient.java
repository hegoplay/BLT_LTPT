package util.clients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import entities.CD;
import util.Constant;
import util.PersonType;

public class StatisticalClient {
	public static StatisticalClient instance = new StatisticalClient();
	
	private static final String HOST = "localhost";
	private static final int PORT = Constant.PORT;
	
	private Socket serverSocket = null;
	private static ObjectOutputStream out = null;
	private static ObjectInputStream in = null;
	
	public StatisticalClient() {
		super();
	}



	public void connect() {
		if(serverSocket == null) {
			try {
				serverSocket = new Socket(HOST, PORT);
				out = new ObjectOutputStream(serverSocket.getOutputStream());
				in = new ObjectInputStream(serverSocket.getInputStream());
				
				out.writeObject(PersonType.STATISCAL_EMPLOYEE);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void disconnect() {
		if(serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<CD> getAllCD(){
		connect();
		List<CD> result = null;
		
		try {
			out.writeObject("getAllCD");
			out.flush();
			result = (List<CD>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Map<CD, Integer> getCDinTime(int month, int year){
		connect();
		Map<CD, Integer> result = null;
		
		try {
			out.writeObject("getCDinTime");
			out.writeObject(month);
			out.writeObject(year);
			out.flush();
			
			result = (Map<CD, Integer>) in.readObject(); 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
