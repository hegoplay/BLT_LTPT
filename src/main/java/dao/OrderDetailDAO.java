package dao;

import java.util.List;

import entities.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.ConnectDB;

public class OrderDetailDAO implements InterfaceDAO<OrderDetail>{
	
	public static OrderDetailDAO instance = new OrderDetailDAO();
	
	private static EntityManager manager;
	
	
	public OrderDetailDAO() {
        manager = ConnectDB.instance.manager;
    }
	
	@Override
	public void insert(OrderDetail obj) {
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
	public void update(OrderDetail obj) {
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
	public void delete(OrderDetail obj) {
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
	public OrderDetail findById(String id) {
		return manager.find(OrderDetail.class, id);
	}

	@Override
	public List<OrderDetail> getAll() {
		return manager.createQuery("from OrderDetail", OrderDetail.class).getResultList();
	}
	
	// Get all order details by orderId.
	public List<OrderDetail> findByOrderId(String orderId) {
		return manager.createQuery("from OrderDetail where order.orderId = :orderId", OrderDetail.class)
				.setParameter("orderId", orderId).getResultList();
	}

}
