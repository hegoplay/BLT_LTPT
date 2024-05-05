package dao;

import java.util.List;

import entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.ConnectDB;

public class OrderDAO implements InterfaceDAO<Order>{
	
	private EntityManager manager;
	
	public static OrderDAO instance = new OrderDAO();
	
	public OrderDAO() {
		manager = ConnectDB.instance.manager;
	}
	
	
	@Override
	public void insert(Order obj) {
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public void update(Order obj) {
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public void delete(Order obj) {
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Order findById(String id) {
		return manager.find(Order.class, id);
	}

	@Override
	public List<Order> getAll() {
		return manager.createQuery("from Order", Order.class).getResultList();
	}
	
	// Method to retrieve all Orders of a customer.
	public List<Order> findByCustomerId(String customerId) {
		return manager.createQuery("Select o From Order o Where o.customer.personID = :customerId ", Order.class)
				.setParameter("customerId", customerId).getResultList();
	}

}
