package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class MyProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setBounds(287, 120, 540, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setBounds(156, 167, 86, 14);
		add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(287, 164, 540, 20);
		add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date of birth :");
		lblNewLabel_1_2.setBounds(156, 223, 101, 14);
		add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(287, 220, 540, 20);
		add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address :");
		lblNewLabel_1_3.setBounds(156, 277, 86, 14);
		add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(287, 274, 540, 20);
		add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email :");
		lblNewLabel_1_4.setBounds(156, 326, 86, 14);
		add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(287, 323, 540, 20);
		add(textField_4);

	}
}
