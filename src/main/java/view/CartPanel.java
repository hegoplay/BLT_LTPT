package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CartPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField_cdName;
	private JTable table;
	private JComboBox<String> comboBox_priceFilter;
	private JButton btn_find;
	private JButton btn_placeOrder;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CD's name :");
		lblNewLabel.setBounds(124, 70, 70, 14);
		add(lblNewLabel);

		textField_cdName = new JTextField();
		textField_cdName.setBounds(204, 67, 455, 20);
		add(textField_cdName);
		textField_cdName.setColumns(10);

		comboBox_priceFilter = new JComboBox<String>();
		comboBox_priceFilter.setModel(new DefaultComboBoxModel<String>(new String[] {"Ascending", "Descending"}));
		comboBox_priceFilter.setBounds(799, 66, 116, 22);
		add(comboBox_priceFilter);

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

		btn_find = new JButton("Find");
		btn_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_find.setBounds(266, 472, 143, 53);
		add(btn_find);

		btn_placeOrder = new JButton("Place order");
		btn_placeOrder.setBounds(594, 472, 143, 53);
		add(btn_placeOrder);

		JLabel lblNewLabel_3 = new JLabel("MY CART");
		lblNewLabel_3.setBounds(489, 21, 70, 14);
		add(lblNewLabel_3);
		new JPanel();
		setBorder(new EmptyBorder(50, 0, 50, 0));
		
		btn_find.addActionListener(this);
		btn_placeOrder.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if (action.equals("Find")) {
			String cdName = textField_cdName.getText();
			String priceFilter = comboBox_priceFilter.getSelectedItem().toString();
			System.out.println("Find button clicked");
		} else if (action.equals("Place order")) {
			// Get selected rows from the table.
			
			System.out.println("Place order button clicked");
		}
	}

}
