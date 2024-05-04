package connection_test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

import util.PersonType;

class ConnectCustomerTest {

	private static ObjectOutputStream out;
	private static ObjectInputStream in;

	public static void main(String[] args) throws UnknownHostException, IOException {
		try (Socket socket = new Socket("localhost", 8603)) {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		}
		System.out.println("Connected to server");
		
		out.writeObject(PersonType.CUSTOMER);
		out.flush();
		
		
		out.writeObject("Hello");
		out.flush();
		
		out.close();
		in.close();
	}

}
