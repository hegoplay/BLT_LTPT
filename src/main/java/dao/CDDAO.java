package dao;

import java.util.List;

import entities.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.ConnectDB;

public class CDDAO implements InterfaceDAO<CD>{
	public static CDDAO instance = new CDDAO();
	
	private EntityManager StorageManager;
	
	private CDDAO() {
		StorageManager = ConnectDB.instance.manager;
	}
	
	@Override
	public void insert(CD obj) {
		EntityTransaction transaction = null;
		try {
			transaction = StorageManager.getTransaction();
			transaction.begin();
			StorageManager.persist(obj);
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
			transaction = StorageManager.getTransaction();
			transaction.begin();
			StorageManager.merge(obj);
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
			transaction = StorageManager.getTransaction();
			transaction.begin();
			StorageManager.remove(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public CD findById(String id) {
		return StorageManager.find(CD.class, id);
	}

	@Override
	public List<CD> getAll() {
//		help me get all cd in database with the help of hibernate
		return StorageManager.createQuery("from CD", CD.class).getResultList();
	}

	
	public List<CD> findByNameAndPrice(String cdName, String priceFilter) {
	    String sortOrder = "asc".equalsIgnoreCase(priceFilter) ? "asc" : "desc";
	    String queryString = "from CD where cdName like :cdName order by price " + sortOrder;
		
		return StorageManager.createQuery(queryString, CD.class)
				.setParameter("cdName", "%" + cdName + "%")
				.getResultList();
    }

}
