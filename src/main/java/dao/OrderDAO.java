package dao;

import java.util.List;
import java.util.Set;

import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;
import entities.OrderDetail;
import entities.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

		// TODO Auto-generated method stub
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		Predicate where = cb.conjunction();
		where = cb.and(where, cb.equal(root.get("id"), id));
		cq = cq.select(root).where(where);
		return manager.createQuery(cq).getSingleResult();
	}

	public Set<OrderDetail> getODSetByOrder(Order order) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<OrderDetail> cq = cb.createQuery(OrderDetail.class);
		Root<OrderDetail> root = cq.from(OrderDetail.class);
		Predicate where = cb.conjunction();
		where = cb.and(where, cb.equal(root.get("order"), order));
		cq = cq.select(root).where(where);
		return manager.createQuery(cq).getResultList().stream().collect(java.util.stream.Collectors.toSet());
	}
	
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
	 return manager.createQuery("from Order", Order.class).getResultList();
	}
	public List<Order> getOrderByStatus(OrderStatus status){
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		Predicate where = cb.conjunction();
		where = cb.and(where, cb.equal(root.get("status"), status));
		cq = cq.select(root).where(where);
		return manager.createQuery(cq).getResultList();
    
	}
	
	public List<Order> findByCustomerId(String customerId){
		CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> root = cq.from(Order.class);
        Predicate where = cb.conjunction();
        where = cb.and(where, cb.equal(root.get("customer").get("id"), customerId));
        cq = cq.select(root).where(where);
        return manager.createQuery(cq).getResultList();
	}
}
