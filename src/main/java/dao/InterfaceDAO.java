package dao;

import java.util.List;

public interface InterfaceDAO<T> {
	public void insert(T obj);

	public void update(T obj);

	public void delete(T obj);

	public T findById(String id);
	
	public List<T> getAll();
}
