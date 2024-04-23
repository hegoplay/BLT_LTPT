package views;

import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class OrderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("My Orders :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 71, 108, 34);
		add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Pending", "Confirmed", "Delivering", "Delivered" }));
		comboBox.setBounds(329, 63, 111, 22);
		add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 110, 414, 417);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, },
				new String[] { "Order id", "Order date", "Status" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Order Detail :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(550, 71, 151, 22);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Order id :");
		lblNewLabel_2.setBounds(550, 108, 65, 14);
		add(lblNewLabel_2);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(625, 105, 190, 20);
		add(textField_5);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(534, 143, 491, 182);
		add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "CD id", "CD name", "Quantity", "Price", "Subtotal" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Integer.class, Object.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Total :");
		lblNewLabel_3.setBounds(550, 371, 46, 14);
		add(lblNewLabel_3);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(636, 368, 242, 20);
		add(textField_6);

		JLabel lblNewLabel_3_1 = new JLabel("Status :");
		lblNewLabel_3_1.setBounds(550, 412, 46, 14);
		add(lblNewLabel_3_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(636, 409, 242, 20);
		add(textField_7);

		JLabel lblNewLabel_3_2 = new JLabel("Shipped date :");
		lblNewLabel_3_2.setBounds(550, 454, 100, 14);
		add(lblNewLabel_3_2);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(640, 451, 238, 20);
		add(textField_8);

		JLabel lblNewLabel_3_3 = new JLabel("Address :");
		lblNewLabel_3_3.setBounds(550, 494, 65, 14);
		add(lblNewLabel_3_3);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(640, 491, 380, 20);
		add(textField_9);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(491, 40, 2, 507);
		add(separator);

	}

}
