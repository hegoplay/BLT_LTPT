package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import dao.CDDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.PersonDAO;
import entities.CD;
import entities.Order;
import entities.OrderDetail;
import entities.Person;

public class CustomerHandler implements Runnable {

	private Socket clientSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public CustomerHandler(Socket clientSocket, ObjectInputStream in, ObjectOutputStream out) {
		super();
		this.clientSocket = clientSocket;
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		boolean isRunning = true;
		while (isRunning) {
			try {
				// Get the request (the operation to be performed) from the client.
				String request = (String) in.readObject();

				System.out.println("\nRequest received: " + request);

				// Handle the request.
				String entityType = null;
				Object entity = null;

				switch (request) {
					
					case "findByNameAndPrice":
						// Get the params from the client.
						String name = (String) in.readObject();
						String priceOrder = (String) in.readObject();
						List<CD> result = null;
	
						// Use the DAO to interact with the database.
						result = CDDAO.instance.findByNameAndPrice(name, priceOrder);
	
						// Send the result back to the client.
						out.writeObject(result);
						out.flush();
						break;
	
					case "findById":
						entityType = (String) in.readObject();
						String id = (String) in.readObject();
	
						if (entityType.equals(CD.class.getSimpleName())) {
							System.out.println("Finding CD with id: " + id);
							CD cd = CDDAO.instance.findById(id);
							out.writeObject(cd);
						} else if (entityType.equals(Order.class.getSimpleName())) {
							Order order = OrderDAO.instance.findById(id);
							out.writeObject(order);
						} else if (entityType.equals(OrderDetail.class.getSimpleName())) {
							OrderDetail orderDetail = OrderDetailDAO.instance.findById(id);
							out.writeObject(orderDetail);
						} else if (entityType.equals(Person.class.getSimpleName())) {
							Person person = PersonDAO.instance.findById(id);
							out.writeObject(person);
						}
	
						out.flush();
						break;
	
					case "findByCustomerId":
						String customerId = (String) in.readObject();
						List<Order> orders = OrderDAO.instance.findByCustomerId(customerId);
						out.writeObject(orders);
						out.flush();
						break;
	
					case "findByOrderId":
						String orderId = (String) in.readObject();
						List<OrderDetail> orderDetails = OrderDetailDAO.instance.findByOrderId(orderId);
						out.writeObject(orderDetails);
						out.flush();
						break;
	
					case "getAll":
						entityType = (String) in.readObject();
						
						if (entityType.equals(Order.class.getSimpleName())) {
							List<Order> allOrders = OrderDAO.instance.getAll();
							out.writeObject(allOrders);
							out.flush();
						} else if (entityType.equals(OrderDetail.class.getSimpleName())) {
							List<OrderDetail> allOrderDetails = OrderDetailDAO.instance.getAll();
							out.writeObject(allOrderDetails);
							out.flush();
						} else if (entityType.equals(CD.class.getSimpleName())) {
							List<CD> allCDs = CDDAO.instance.getAll();
							out.writeObject(allCDs);
							out.flush();
						}
						
						break;
	
					case "insert":
						entityType = (String) in.readObject();
	
						entity = in.readObject();
	
						if (entityType.equals(Order.class.getSimpleName())) {
							Order order = (Order) entity;
							OrderDAO.instance.insert(order);
	
							System.out.println("Order inserted: " + order.getOrderId());
	
						} else if (entityType.equals(OrderDetail.class.getSimpleName())) {
							OrderDetail orderDetail = (OrderDetail) entity;
							OrderDetailDAO.instance.insert(orderDetail);
	
							System.out.println("OrderDetail inserted: " + orderDetail.getOrder().getOrderId());
						}
						break;
				
					default:
						System.out.println("Invalid request.");
						break;
				}

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
