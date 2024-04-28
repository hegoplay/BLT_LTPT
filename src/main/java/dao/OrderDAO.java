package dao;

import java.util.List;

import entities.Order;
import entities.Person;
import jakarta.persistence.EntityManager;
import util.ConnectDB;

public class OrderDAO implements InterfaceDAO<Order> {
public static OrderDAO instance = new OrderDAO();
	
	private EntityManager StorageManager;
	
	private OrderDAO() {
		StorageManager = ConnectDB.instance.manager;
	}
	@Override
	public void insert(Order obj) {
		// TODO Auto-generated method stub
		StorageManager.getTransaction().begin();
		StorageManager.persist(obj.getCustomer());
		StorageManager.persist(obj);
		StorageManager.getTransaction().commit();
		
	}

	@Override
	public void update(Order obj) {
		// TODO Auto-generated method stub
		StorageManager.getTransaction().begin();
		StorageManager.merge(obj);
		StorageManager.getTransaction().commit();
	}

	@Override
	public void delete(Order obj) {
		// TODO Auto-generated method stub
		StorageManager.getTransaction().begin();
		StorageManager.remove(obj);
		StorageManager.getTransaction().commit();
	}

	@Override
	public Order findById(String id) {
		// TODO Auto-generated method stub
		return StorageManager.find(Order.class, id);
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
	 return StorageManager.createQuery("from Order", Order.class).getResultList();
	}

}
