package util.storageEvents;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StorageEmployeeHandler implements Runnable {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	public StorageEmployeeHandler(Socket socket,ObjectInputStream ois,ObjectOutputStream oos) {
		super();
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String message = (String) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
