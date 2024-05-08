package run;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dao.PersonDAO;
import entities.Account;
import entities.Address;
import entities.Customer;
import entities.Order;
import util.clients.CustomerClient;
import view.customer.CustomerGui;

public class CustomerViewDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		Address address = new Address("7000", "Sai Gon", "3/2", "888");
//		Account account = new Account("khmk8123", "123456");
//		Set<Order> orders = new HashSet<>();
//		Customer customer = new Customer("khmk8123", "Nguyen Minh Khang", LocalDate.of(2003, 12, 8), address, "khangDepTrai123@gmail.com", account, LocalDate.of(2024, 5, 1), orders);
//		PersonDAO.instance.insert(customer);
		
		
		CustomerGui customerGui = new CustomerGui();
		customerGui.setLocationRelativeTo(null);
		customerGui.setVisible(true);
	}
}
