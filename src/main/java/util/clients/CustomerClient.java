package util.clients;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import entities.CD;
import entities.Order;
import entities.OrderDetail;
import entities.Person;
import util.Constant;
import util.PersonType;

// This class is used to send Customer related requests to the server.
public class CustomerClient {
	public static CustomerClient instance = new CustomerClient();

//	private static final String HOST = "172.28.64.180";
	private static final String HOST = "localhost";
	private static final int PORT = Constant.PORT;

	private static Socket serverSocket = null;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;

	private CustomerClient() {
		super();
	}



	public static void connect() {
		if (serverSocket == null) {
			try {
				serverSocket = new Socket(HOST, PORT);
				out = new ObjectOutputStream(serverSocket.getOutputStream());
				in = new ObjectInputStream(serverSocket.getInputStream());

				out.writeObject(PersonType.CUSTOMER);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
				serverSocket = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method is used to find a CD by its name and price.
	public List<CD> findByNameAndPrice(String name, String priceOrder) {
		connect();
		List<CD> cds = null;
		try {
			// Second send the operation type to the server.
			out.writeObject("findByNameAndPrice");

			// Then send the name and price order to the server.
			out.writeObject(name);
			out.writeObject(priceOrder);

			// Finally flush the output stream.
			out.flush();

			// Get the result from the server.
			cds = (List<CD>) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cds;
	}

	public <T> T findById(String id, Class<T> entityType) {
		connect();
		T result = null;
		System.out.println("id: " + id + " entityType: " + entityType.getSimpleName());
		try {

			out.writeObject("findById");

			out.writeObject(entityType.getSimpleName());

			out.writeObject(id);

			out.flush();

			result = (T) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> void insert(T entity, Class<T> entityType) {
		connect();
		try {

			out.writeObject("insert");

			out.writeObject(entityType.getSimpleName());

			out.writeObject(entity);

			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Order> findByCustomerId(String id) {
		connect();
		List<Order> orders = null;
		try {

			out.writeObject("findByCustomerId");

			out.writeObject(id);

			out.flush();

			orders = (List<Order>) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public <T> List<T> getAll(Class<T> entityType) {
		connect();
		List<T> result = null;
		try {
			out.writeObject("getAll");
			out.writeObject(entityType.getSimpleName());
			out.flush();
			result = (List<T>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<OrderDetail> findByOrderId(String id) {
		connect();
		List<OrderDetail> orderDetails = null;
		try {

			out.writeObject("findByOrderId");

			out.writeObject(id);

			out.flush();

			orderDetails = (List<OrderDetail>) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

}
