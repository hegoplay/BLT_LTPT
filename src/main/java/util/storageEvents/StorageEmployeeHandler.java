package util.storageEvents;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.OrderDAO;
import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;

public class StorageEmployeeHandler implements Runnable {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Set<OrderDetail> odSet;
	
	
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
			while(true) {
				Object obj = ois.readObject();
				if (obj == StrEmployeeEvt.EXIT) {
					// update order
					ois.close();
					oos.close();
					socket.close();
					break;
				}
				if(obj == StrEmployeeEvt.GET_ORDER) {
					// get order
					obj = ois.readObject();
					List<Order> o = new ArrayList<>();
					if (obj instanceof OrderStatus) {
						// do something
						o = OrderDAO.instance.getOrderByStatus((OrderStatus) obj);
					}
					else {						
						o = OrderDAO.instance.getAll();
					}
					oos.writeObject(o);
					oos.flush();
				}
				if(obj == StrEmployeeEvt.GET_ORDER_BY_ID) {
					obj = ois.readObject();
					if (obj instanceof String) {
						Order o = OrderDAO.instance.findById((String) obj);
						oos.writeObject(o);
						oos.flush();
					}
				}
				if (obj == StrEmployeeEvt.ORDER_DETAIL) {
					// update order
					obj = ois.readObject();
					
					if (obj instanceof String) {
						Order o = OrderDAO.instance.findById((String) obj);
						odSet = OrderDAO.instance.getODSetByOrder(o);
					}
					else if (obj instanceof Order) {
						odSet = OrderDAO.instance.getODSetByOrder((Order) obj);
					}
					else {
						odSet = null;
					}
					oos.writeObject(odSet);
					oos.flush();
				}
				if (obj == StrEmployeeEvt.UPDATE_ORDER) {
					// update order
					obj = ois.readObject();
					if (obj instanceof Order	) {
						Order o = (Order) obj;
						
						OrderDAO.instance.update(o);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			ois.close();
			oos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
