package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import entities.Customer;
import entities.Person;

public class MyProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_userId;
	private JTextField textField_name;
	private JTextField textField_dob;
	private JTextField textField_address;
	private JTextField textField_email;

	/**
	 * Create the panel.
	 */
	public MyProfilePanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MY PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(438, 41, 130, 43);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User id :");
		lblNewLabel_1.setBounds(156, 123, 101, 14);
		add(lblNewLabel_1);
		
		textField_userId = new JTextField();
		textField_userId.setBounds(287, 120, 540, 20);
		add(textField_userId);
		textField_userId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setBounds(156, 167, 86, 14);
		add(lblNewLabel_1_1);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(287, 164, 540, 20);
		add(textField_name);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date of birth :");
		lblNewLabel_1_2.setBounds(156, 223, 101, 14);
		add(lblNewLabel_1_2);
		
		textField_dob = new JTextField();
		textField_dob.setColumns(10);
		textField_dob.setBounds(287, 220, 540, 20);
		add(textField_dob);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address :");
		lblNewLabel_1_3.setBounds(156, 277, 86, 14);
		add(lblNewLabel_1_3);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(287, 274, 540, 20);
		add(textField_address);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email :");
		lblNewLabel_1_4.setBounds(156, 326, 86, 14);
		add(lblNewLabel_1_4);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(287, 323, 540, 20);
		add(textField_email);
		
		loadData();

	}
	
	public void loadData() {
		// Load user data to text fields.
		Customer customer = new Customer();
		// Use DAO to get user data from database.
		
		textField_userId.setText(customer.getPersonID());
		textField_name.setText(customer.getName());
		textField_dob.setText(customer.getDob().toString());
		textField_address.setText(customer.getAddress().toString());
	}
}
