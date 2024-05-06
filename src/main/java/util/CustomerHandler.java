package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import dao.CDDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import entities.CD;
import entities.Order;
import entities.OrderDetail;

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
		try {
			// Get the request from the client.
			String request = (String) in.readObject();

			// Handle the request.
			String entityType;
			Object entity;
			
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

				switch (entityType) {
				case "CD":
					CD cd = CDDAO.instance.findById(id);
					out.writeObject(cd);
					break;
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

				break;

			case "insert":
				entityType = (String) in.readObject();

				entity = in.readObject();
				
				if (entityType.equals(Order.class.getSimpleName())) {
					Order order = (Order) entity;
					
					
					OrderDAO.instance.insert(order);
				} else if (entityType.equals(OrderDetail.class.getSimpleName())) {
					OrderDetail orderDetail = (OrderDetail) entity;
					OrderDetailDAO.instance.insert(orderDetail);
				}
				
//				switch (entityType) {
//				case orderClassName :
//					Order order = (Order) entity;
//					OrderDAO.instance.insert(order);
//					break;
//					
//				case "OrderDetail":
//					OrderDetail orderDetail = (OrderDetail) entity;
//					OrderDetailDAO.instance.insert(orderDetail);
//					break;	
//				}
				break;

			default:
				break;
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
