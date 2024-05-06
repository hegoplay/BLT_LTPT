package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.CD;
import entities.Order;
import entities.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
		return StorageManager.find(CD.class, id);
	}

	@Override
	public List<CD> getAll() {
		// TODO Auto-generated method stub
//		help me get all cd in database with the help of hibernate
		return StorageManager.createQuery("from CD", CD.class).getResultList();
	}

	public Map<CD,Integer> getCDinTime(int month, int year){
		// TODO Auto-generated method stub
		CriteriaBuilder cb = StorageManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Order> root = cq.from(Order.class);
		Join<Object, Object> join = root.join("orderDetails");
		Predicate where = cb.conjunction();
		where = cb.and(where, cb.equal(cb.function("MONTH", Integer.class, root.get("createdDate")), month));
		where = cb.and(where, cb.equal(cb.function("YEAR", Integer.class, root.get("createdDate")), year));
	    cq = cq.multiselect(join, cb.sum(join.get("quantity")));
	    cq = cq.where(where);
	    cq = cq.groupBy(join);
	    List<Tuple> list = StorageManager.createQuery(cq).getResultList();
//	    for (Order order : list) {
//	    	            System.out.println(order.getOrderId());
//	    }
	    Map<CD,Integer> mp = new HashMap<>();
	    for (Tuple tuple : list) {
			OrderDetail orderDetail = tuple.get(0, OrderDetail.class);
			int quantity = tuple.get(1, Integer.class);
			mp.put(orderDetail.getCd(), quantity);
	    }
        return mp;

	}
	
}
