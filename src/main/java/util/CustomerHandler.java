package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CustomerHandler implements Runnable {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	public CustomerHandler(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
		super();
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			try {
				String s = (String) ois.readObject();
				System.out.println(s);
				oos.writeObject(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
