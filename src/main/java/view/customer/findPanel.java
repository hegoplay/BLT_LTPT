package view.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.CDDAO;
import entities.CD;
import util.clients.CustomerClient;

public class findPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField_cdName;
	private JTable table;
	private JComboBox<String> comboBox_priceFilter;
	private JButton btn_find;
	private JButton btn_addToCart;

	/**
	 * Create the panel.
	 */
	public findPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CD's name :");
		lblNewLabel.setBounds(138, 78, 70, 14);
		add(lblNewLabel);

		textField_cdName = new JTextField();
		textField_cdName.setColumns(10);
		textField_cdName.setBounds(218, 75, 455, 20);
		add(textField_cdName);

		comboBox_priceFilter = new JComboBox<String>();
		comboBox_priceFilter.setModel(new DefaultComboBoxModel<String>(new String[] { "Ascending", "Descending" }));
		comboBox_priceFilter.setBounds(800, 74, 116, 22);
		this.add(comboBox_priceFilter);

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

		btn_find = new JButton("Find");
		btn_find.setBounds(280, 480, 143, 53);
		add(btn_find);

		btn_addToCart = new JButton("Add to cart");
		btn_addToCart.setBounds(608, 480, 143, 53);
		add(btn_addToCart);

		JLabel lblNewLabel_3 = new JLabel("FIND CDs");
		lblNewLabel_3.setBounds(503, 29, 70, 14);
		add(lblNewLabel_3);

		btn_find.addActionListener(this);
		btn_addToCart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Find")) {
			String cdName = textField_cdName.getText();
			String priceFilter = comboBox_priceFilter.getSelectedItem().toString();

			// Use client to request data from the server (ie. the list of CDs matching the search criteria)
			setTableData(CustomerClient.instance.findByNameAndPrice(cdName, priceFilter));

		} else if (command.equals("Add to cart")) {
			// Call the method to get and store selected CDs
			getAndStoreSelectedCDs();	
		}
	}

	// Method to set data for the table.
	public void setTableData(List<CD> cds) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (CD cd : cds) {
			model.addRow(new Object[] { cd.getCdID(), cd.getName(), cd.getPrice(), cd.isStatus() });
		}
	}

	// Method to retrieve selected CDs from the table and store it into the temporary varibale selectedCDs in CartPanel.
	public void getAndStoreSelectedCDs() {
		// Get the selected rows from the table
		int[] selectedRows = table.getSelectedRows();
		
		// Loop through the selected rows
		for (int i = 0; i < selectedRows.length; i++) {
			// Get the selected row
			int selectedRow = selectedRows[i];

			// Get the selected CD id from the selected row
			String selectedCdID = table.getValueAt(selectedRow, 0).toString();

			// Use client to request data insertion from the server.
			CD selectedCD = CustomerClient.instance.findById(selectedCdID, CD.class);

			CartPanel.cartCDs.add(selectedCD);
		}
	}
}
