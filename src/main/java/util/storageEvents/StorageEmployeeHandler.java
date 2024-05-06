package util.storageEvents;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.OrderDAO;
import dao.PersonDAO;
import dao.ProductDAO;
import entities.CD;
import entities.EditHistory;
import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;
import entities.StorageEmployee;

public class StorageEmployeeHandler implements Runnable {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Set<OrderDetail> odSet;
	
	private StorageEmployee storageEmployee;
	
	public StorageEmployeeHandler(Socket socket,ObjectInputStream ois,ObjectOutputStream oos) {
		super();
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		storageEmployee = (StorageEmployee) PersonDAO.instance.findById("NVKHPTM651513");
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(true) {
				Object obj = ois.readObject();
				if (obj == OrderEvents.EXIT) {
					// update order
					ois.close();
					oos.close();
					socket.close();
					break;
				}
				if(obj == OrderEvents.GET_ORDER) {
					// get order
					obj = ois.readObject();
					List<Order> o = new ArrayList<>();
					if (obj instanceof OrderStatus) {
						// do something
						o = OrderDAO.instance.getOrderByStatus((OrderStatus) obj);
					}
					else if (obj instanceof String&&((String) obj).equals("all")){						
						o = OrderDAO.instance.getAll();
					}
					oos.writeObject(o);
					oos.flush();
				}
				if(obj == OrderEvents.GET_ORDER_BY_ID) {
					obj = ois.readObject();
					if (obj instanceof String) {
						Order o = OrderDAO.instance.findById((String) obj);
						oos.writeObject(o);
						oos.flush();
					}
				}
				if (obj == OrderEvents.ORDER_DETAIL) {
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
				if (obj == OrderEvents.UPDATE_ORDER) {
					// update order
					obj = ois.readObject();
					if (obj instanceof Order	) {
						Order o = (Order) obj;
						if (o.getStatus() == OrderStatus.DELIVERING) {
							o.setStorageEmployee(storageEmployee);
						}
						OrderDAO.instance.update(o);
					}
				}
				if(obj == PersonEvents.GET_EXAMPLE_STORAGE_EMPLOYEE) {
					// get example storage employee
					oos.writeObject(storageEmployee);
					oos.flush();
				}
				if(obj == CDEvents.UPDATE_CD) {
					// update cd
					obj = ois.readObject();
					if (obj instanceof CD) {
						CD newCD = (CD) obj;
						CD oldCD = ProductDAO.instance.findById(newCD.getCdID());
						int state = 0;
						
						if (!newCD.getCdID().equals(oldCD.getCdID())) {
							state |= (1 << 0);
						}
						if (!newCD.getName().equals(oldCD.getName())) {
							state |= (1 << 1);
						}
						if (newCD.getQuantity() != (oldCD.getQuantity())) {
							state |= (1 << 2);
						}
						if (newCD.getPrice() != oldCD.getPrice()) {
							state |= (1 << 3);
						}
						if (newCD.isStatus() != oldCD.isStatus()) {
							state |= (1 << 4);
						}
						EditHistory eh = new EditHistory();
						eh.setCd(oldCD);
						eh.setStorageEmployee(storageEmployee);
						eh.setStatus(state);
						eh.setDateModify(LocalDate.now());
						
						ProductDAO.instance.update(newCD);
						ProductDAO.instance.insertEditHistory(eh);
						
					}
				}
				if (obj == CDEvents.GET_ALL_CD) {
					// get cd
					List<CD> cdList = new ArrayList<CD>(ProductDAO.instance.getAll());
					oos.writeObject(cdList);
					oos.flush();
				}
				if(obj == CDEvents.GET_CD) {
					// get cd
					obj = ois.readObject();
					if (obj instanceof String) {
						CD cd = ProductDAO.instance.findById((String) obj);
						oos.writeObject(cd);
						oos.flush();
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
