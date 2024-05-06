package dao;

import java.util.List;

import entities.CD;
import jakarta.persistence.EntityManager;
import util.ConnectDB;

public class CDDAO implements InterfaceDAO<CD>{
	public static CDDAO instance = new CDDAO();
	
	private EntityManager StorageManager;
	
	private CDDAO() {
		StorageManager = ConnectDB.instance.manager;
	}
	
	@Override
	public void insert(CD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CD findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CD> getAll() {
		// TODO Auto-generated method stub
//		help me get all cd in database with the help of hibernate
		return StorageManager.createQuery("from CD", CD.class).getResultList();
	}

}
