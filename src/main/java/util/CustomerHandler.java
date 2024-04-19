package util;

import java.net.Socket;

public class CustomerHandler implements Runnable {

	private Socket socket;
	
	public CustomerHandler(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
