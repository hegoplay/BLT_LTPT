package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CartPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CD's name :");
		lblNewLabel.setBounds(124, 70, 70, 14);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(204, 67, 455, 20);
		add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Under 100,000", "100,000 - 200,000", "200,000 - 300,000", "Above 300,000" }));
		comboBox.setBounds(799, 66, 116, 22);
		add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Filter by price");
		lblNewLabel_1.setBounds(706, 70, 84, 14);
		add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 148, 925, 303);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "CD id", "CD name", "Price", "Status", "Quantity", "Select" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Integer.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("MY SELECTED CDs");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(57, 114, 162, 14);
		add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(266, 472, 143, 53);
		add(btnNewButton);

		JButton btnAddToCart = new JButton("Place order");
		btnAddToCart.setBounds(594, 472, 143, 53);
		add(btnAddToCart);

		JLabel lblNewLabel_3 = new JLabel("MY CART");
		lblNewLabel_3.setBounds(489, 21, 70, 14);
		add(lblNewLabel_3);
		new JPanel();
		setBorder(new EmptyBorder(50, 0, 50, 0));
	}

}
