package dao;

import java.util.List;


import entities.CD;
import entities.Person;
import jakarta.persistence.EntityManager;
import util.ConnectDB;
import view.storageEmployee.PnlProduct;

public class ProductDAO implements InterfaceDAO<CD> {

public static ProductDAO instance = new ProductDAO();
	
	private EntityManager StorageManager;
	
	private ProductDAO() {
		StorageManager = ConnectDB.instance.manager;
	}
	
	@Override
	public void insert(CD obj) {
		// TODO Auto-generated method stub
		StorageManager.getTransaction().begin();
		StorageManager.persist(obj.getCdID());
		StorageManager.persist(obj);
		StorageManager.getTransaction().commit();
		
	}

	@Override
	public void update(CD obj) {
		StorageManager.getTransaction().begin();
		StorageManager.merge(obj);
		StorageManager.getTransaction().commit();
	}

	@Override
	public void delete(CD obj) {
		// TODO Auto-generated method stub
		StorageManager.getTransaction().begin();
		StorageManager.remove(obj);
		StorageManager.getTransaction().commit();
	}

	@Override
	public CD findById(String id) {
		// TODO Auto-generated method stub
		return StorageManager.find(CD.class, id);
	}

	@Override
	public List<CD> getAll() {
		// TODO Auto-generated method stub
		return StorageManager.createQuery("from CD", CD.class).getResultList();
	}

	
	

}
