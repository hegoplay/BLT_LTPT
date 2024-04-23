package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class findPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public findPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CD's name :");
		lblNewLabel.setBounds(138, 78, 70, 14);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 75, 455, 20);
		add(textField);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Under 100,000", "100,000 - 200,000", "200,000 - 300,000", "Above 300,000"}));
		comboBox.setBounds(800, 74, 116, 22);
		this.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Filter by price");
		lblNewLabel_1.setBounds(720, 78, 84, 14);
		add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 148, 925, 303);
		this.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "CD id", "CD name", "Price", "Status" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("RESULT :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(71, 122, 84, 14);
		add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBounds(280, 480, 143, 53);
		add(btnNewButton);

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBounds(608, 480, 143, 53);
		add(btnAddToCart);

		JLabel lblNewLabel_3 = new JLabel("FIND CDs");
		lblNewLabel_3.setBounds(503, 29, 70, 14);
		add(lblNewLabel_3);

	}

}
