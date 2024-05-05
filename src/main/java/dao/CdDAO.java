package dao;

import java.util.List;

import entities.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.ConnectDB;

public class CdDAO implements InterfaceDAO<CD> {

	public static CdDAO instance = new CdDAO();

	private static EntityManager manager;

	public CdDAO() {
		manager = ConnectDB.instance.manager;
	}

	@Override
	public void insert(CD obj) {
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
	public void update(CD obj) {
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
	public void delete(CD obj) {
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
	public CD findById(String id) {
		return manager.find(CD.class, id);
	}

	@Override
	public List<CD> getAll() {
		return manager.createQuery("from CD", CD.class).getResultList();
	}

	public List<CD> findByNameAndPrice(String name, String priceOrder) {
		String order = "asc";
		if ("Ascending".equalsIgnoreCase(priceOrder)) {
			order = "asc";
		} else if ("Descending".equalsIgnoreCase(priceOrder)) {
			order = "desc";
		} else {
			throw new IllegalArgumentException("Invalid priceOrder: " + priceOrder);
		}
		return manager.createQuery("from CD where name like :name order by price " + order, CD.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

}
