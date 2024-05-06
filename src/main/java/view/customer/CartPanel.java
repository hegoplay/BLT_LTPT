package view.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.CDDAO;
import entities.CD;
import util.clients.CustomerClient;

public class CartPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField_cdName;
	private JTable table;
	private JComboBox<String> comboBox_priceFilter;
	private JButton btn_find;
	private JButton btn_placeOrder;
	
	// This variable is used to store the selected CDs from the table for order confirmation.
	public static List<CD> orderCDs = new ArrayList<CD>();
	
	// This is the temporary variable used to store the selected CDs in the Find panel to fill in the cart table.
	public static List<CD> cartCDs = new ArrayList<CD>();

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
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"CD id", "CD name", "Price", "Status", "In stock quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
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
		String action = e.getActionCommand();
		
		if (action.equals("Find")) {
			
			String cdName = textField_cdName.getText();
			String priceFilter = comboBox_priceFilter.getSelectedItem().toString();
			loadCartData(CustomerClient.instance.findByNameAndPrice(cdName, priceFilter));
			
		} else if (action.equals("Place order")) {
			
			// Get selected rows from the table.
			orderCDs = getSelectedCDs();
			
			// prompt the user with the order confirmation JDialog.
		    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		    
		    OrderConfirmationDialog orderConfirmationDialog = new OrderConfirmationDialog(parentFrame);
		    orderConfirmationDialog.loadTableData(orderCDs);
		    orderConfirmationDialog.setVisible(true);
		    orderConfirmationDialog.setLocationRelativeTo(null);

		    // Reload the data for the cart table (due to possible changes in the Order Confirmation dialog).
		    loadCartData(cartCDs);
		}
	}

	// Load the CD data to the Cart table.
	public void loadCartData(List<CD> cds) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		cds.forEach((cd) -> {
			model.addRow(new Object[] { cd.getCdID(), cd.getName(), cd.getPrice(), cd.isStatus(), cd.getQuantity(), false });
		});
	}
	
	// Method to retrieve the selected CDs from the cart table (These CDs will be displayed in the Order Confirmation dialog).
	public List<CD> getSelectedCDs() {
		List<CD> selectedCDs = new ArrayList<>();
		
		int[] selectedRows = table.getSelectedRows();
		
		for (int i = 0; i < selectedRows.length; i++) {
			int selectedRow = selectedRows[i];
			String selectedCdID = table.getValueAt(selectedRow, 0).toString();
			CD selectedCD = CustomerClient.instance.findById(selectedCdID, CD.class);
			selectedCDs.add(selectedCD);
		}
		return selectedCDs;
	}
}
