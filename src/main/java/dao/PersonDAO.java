package dao;

import java.util.List;

import entities.Account;
import entities.Person;
import jakarta.persistence.EntityManager;
import util.ConnectDB;
import util.Constant;

public class PersonDAO implements InterfaceDAO<Person> {

	public static PersonDAO instance = new PersonDAO();
	
	private EntityManager manager;
	
	private PersonDAO() {
		manager = ConnectDB.instance.manager;
	}
	
	@Override
	public void insert(Person obj) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(obj.getAccount());
		manager.persist(obj);
		manager.getTransaction().commit();
	}

	@Override
	public void update(Person obj) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
	}

	@Override
	public void delete(Person obj) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(obj);
		manager.getTransaction().commit();
	}

	@Override
	public Person findById(String id) {
		// TODO Auto-generated method stub
		return manager.find(Person.class, id);
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return manager.createQuery("from Person", Person.class).getResultList();
	}
	
	public Account getAccount(Person p) {
		return manager.find(Account.class, p.getPersonID());
	}
	
	

}
