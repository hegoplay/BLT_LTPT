package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.CDDAO;
import entities.CD;

public class StatisticalEmployeeHandler implements Runnable {

	private Socket clientSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public StatisticalEmployeeHandler(Socket clientSocket, ObjectInputStream in, ObjectOutputStream out) {
		super();
		this.clientSocket = clientSocket;
		this.out = out;
		this.in = in;
	}


	@Override
	public void run() {
		boolean running = true;
		while(running) {
			try {
				// get the requested operation type.
				String request = (String) in.readObject();
				
				
				switch (request) {
				
				case "getAllCD": 
					List<CD> result = null;
					result = (List<CD>) CDDAO.instance.getAll();
					out.writeObject(result);
					out.flush();
					break;
					
				case "getCDinTime":
					Map<CD, Integer> resultCDinTime = null;
					
					int month = (int) in.readObject();
					int year = (int) in.readObject();
					
					resultCDinTime = CDDAO.instance.getCDinTime(month, year);
					out.writeObject(resultCDinTime);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + request);
				}
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				running = false;
			}
			
		}
	}

}
