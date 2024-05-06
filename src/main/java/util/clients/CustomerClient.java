package util.clients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import entities.CD;
import entities.Order;
import entities.OrderDetail;
import util.Constant;
import util.PersonType;

// This class is used to send Customer related requests to the server.
public class CustomerClient {

	public static CustomerClient instance = new CustomerClient();

	private static final String HOST = "localhost";
	private static final int PORT = Constant.PORT;

	private Socket serverSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	private CustomerClient() {
		super();

	}

	// This method is used to find a CD by its name and price.
	public List<CD> findByNameAndPrice(String name, String priceOrder) {
		List<CD> cds = null;
		try {
			// First create a socket to connect to the server.
			serverSocket = new Socket(HOST, PORT);
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			in = new ObjectInputStream(serverSocket.getInputStream());
			
			// Send the person type to the server.
			out.writeObject(PersonType.CUSTOMER);
			out.flush();

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
		T result = null;
		try {
			serverSocket = new Socket(HOST, PORT);
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			in = new ObjectInputStream(serverSocket.getInputStream());

			out.writeObject(PersonType.CUSTOMER);
			out.flush();

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
		try {
            serverSocket = new Socket(HOST, PORT);
            out = new ObjectOutputStream(serverSocket.getOutputStream());
            in = new ObjectInputStream(serverSocket.getInputStream());

            out.writeObject(PersonType.CUSTOMER);
            out.flush();

            out.writeObject("insert");
            
            out.writeObject(entityType.getSimpleName());

            out.writeObject(entity);

            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public List<Order> findByCustomerId(String id){
        List<Order> orders = null;
        try {
            serverSocket = new Socket(HOST, PORT);
            out = new ObjectOutputStream(serverSocket.getOutputStream());
            in = new ObjectInputStream(serverSocket.getInputStream());

            out.writeObject(PersonType.CUSTOMER);
            out.flush();

            out.writeObject("findByCustomerId");

            out.writeObject(id);

            out.flush();

            orders = (List<Order>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }
	
	public List<OrderDetail> findByOrderId(String id) {
		List<OrderDetail> orderDetails = null;
		try {
			serverSocket = new Socket(HOST, PORT);
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			in = new ObjectInputStream(serverSocket.getInputStream());

			out.writeObject(PersonType.CUSTOMER);
			out.flush();

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
