package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
	public  EntityManagerFactory entityFactory;
	public  EntityManager manager;
	public static final String split = "_";
	
	public static ConnectDB instance = new ConnectDB();
	
	private ConnectDB() {
		entityFactory = Persistence.createEntityManagerFactory("JPA_SQL_SERVER");
		manager = entityFactory.createEntityManager();
	}
	public void closeConnection() {
		manager.close();
		entityFactory.close();
	}
	public void inputValues() {
		
	}
}
