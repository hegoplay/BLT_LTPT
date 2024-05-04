package dao;

import java.util.List;

import jakarta.persistence.criteria.Predicate;

import entities.Order;
import entities.OrderStatus;
import entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
		return null;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
	 return StorageManager.createQuery("from Order", Order.class).getResultList();
	}
	public List<Order> getOrderByStatus(OrderStatus status){
		CriteriaBuilder cb = StorageManager.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		Predicate where = cb.conjunction();
		where = cb.and(where, cb.equal(root.get("status"), status));
		cq = cq.select(root).where(where);
		return StorageManager.createQuery(cq).getResultList();
    
	}
}
