package view.customer;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import dao.CDDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.PersonDAO;
import entities.Address;
import entities.CD;
import entities.Customer;
import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;
import entities.StorageEmployee;

public class OrderConfirmationDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtTotal;
	private JTextField text_zip;
	private JButton btnRemove;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JTextField text_city;
	private JTextField text_street;
	private JTextField text_number;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderConfirmationView frame = new OrderConfirmationView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public OrderConfirmationDialog(Frame owner) {
		
		super(owner, true); // true makes the dialog modal
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 779, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ORDER CONFIRMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(240, 24, 296, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Order Detail :");
		lblNewLabel_1.setBounds(24, 86, 91, 14);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 123, 529, 213);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"CD id", "CD name", "Price", "Quantity", "Subtotal"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("Total :");
		lblNewLabel_2.setBounds(354, 356, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(393, 353, 161, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Zip :");
		lblNewLabel_3.setBounds(64, 405, 67, 14);
		contentPane.add(lblNewLabel_3);

		text_zip = new JTextField();
		text_zip.setBounds(134, 405, 420, 20);
		contentPane.add(text_zip);
		text_zip.setColumns(10);

		btnRemove = new JButton("Remove Item");
		btnRemove.setBounds(602, 213, 127, 55);
		contentPane.add(btnRemove);

		btnConfirm = new JButton("Confirm Order");
		btnConfirm.setBounds(602, 408, 127, 55);
		contentPane.add(btnConfirm);

		btnCancel = new JButton("Cancel Order");
		btnCancel.setBounds(602, 479, 127, 55);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_3_1 = new JLabel("City :");
		lblNewLabel_3_1.setBounds(63, 446, 68, 14);
		contentPane.add(lblNewLabel_3_1);
		
		text_city = new JTextField();
		text_city.setColumns(10);
		text_city.setBounds(133, 446, 420, 20);
		contentPane.add(text_city);
		
		JLabel lblNewLabel_3_2 = new JLabel("Street :");
		lblNewLabel_3_2.setBounds(65, 483, 66, 14);
		contentPane.add(lblNewLabel_3_2);
		
		text_street = new JTextField();
		text_street.setColumns(10);
		text_street.setBounds(135, 483, 420, 20);
		contentPane.add(text_street);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Number :");
		lblNewLabel_3_1_1.setBounds(64, 517, 67, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		text_number = new JTextField();
		text_number.setColumns(10);
		text_number.setBounds(134, 517, 420, 20);
		contentPane.add(text_number);
		
		JLabel lblNewLabel_4 = new JLabel("SHIPPING ADDRESS :");
		lblNewLabel_4.setBounds(24, 377, 132, 14);
		contentPane.add(lblNewLabel_4);

		btnRemove.addActionListener(this);
		btnConfirm.addActionListener(this);
		btnCancel.addActionListener(this);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addTableModelListener(e -> {
			if(e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                
                // Check if the modified column is the quantity column.
                if(col == 3) {
                    int quantity = (int) model.getValueAt(row, col);
                    double price = (double) model.getValueAt(row, 2);
                    model.setValueAt(quantity * price, row, 4);
                    
                    // reset the total price.
                    setTotal();
                }
            }
		});
	}

	public void loadTableData(List<CD> cds) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		cds.forEach(cd -> {
			model.addRow(new Object[] { cd.getCdID(), cd.getName(), cd.getPrice(), 1,
					cd.getPrice() * 1 });
		});
		setTotal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Remove Item")) {
			removeItem();
		} else if (command.equals("Confirm Order")) {
			// Confirm order
			requestOrder();
			this.dispose();
		} else if (command.equals("Cancel Order")) {
			// Cancel order
			this.dispose();
		}
	}

	public void removeItem() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			
			// get the selected CD from the table and remove it from the orderCDs list in CartPanel.
			CD removeCd = CDDAO.instance.findById((String) table.getValueAt(rows[i], 0));
			CartPanel.orderCDs.remove(removeCd);
		}
		loadTableData(CartPanel.orderCDs);
	}
	
	// Request Order to the Server (storage employee).
	public void requestOrder() {
		if (table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Your drafted order is currently empty ! Please add some CDs to the order before confirming it");
			return;
		}
		
		// Initialize the previously confirmed order. 
		Order order = new Order();
		List<OrderDetail> orderDetails = new ArrayList<>();
		
		// MISSING INFORMATION - NEED TO IMPLEMENT !!!
		Address shippingAddress = new Address(text_zip.getText().trim(), text_city.getText().trim(), text_street.getText().trim(), text_number.getText().trim());
		Customer customer = (Customer) PersonDAO.instance.findById(CustomerGui.customerID);
		customer.getOrders().add(order);
		
		order.setCreatedDate(LocalDate.now());
		order.setShippedDate(null);
		order.setShippingAddress(shippingAddress);
		order.setStorageEmployee(null);
		order.setCustomer(customer);
		// Order created by Customer is always in PENDING status. Storage employee will process it later.
		order.setStatus(OrderStatus.PENDING);
		
		// Insert the order into the database.
		OrderDAO.instance.insert(order);
		
		// process the order details.
		processOrderDetails(order);
		
		// Remove the previously selected CDs for the Order from the CartPanel.cartCDs list.
		CartPanel.orderCDs.forEach(cd -> {
			CartPanel.cartCDs.remove(cd);
		});
		CartPanel.orderCDs.clear();
	}
	
	/*
	 * This method initializes each order detail and inserts them into the database.
	 * Note that the to-be-created order detail already possess the order id (parameter "order").
	 * */ 
	public void	processOrderDetails(Order order){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		// Loop through the table and insert each order detail into the database.
		for (int i = 0; i < model.getRowCount(); i++) {
			
			CD cd = CDDAO.instance.findById((String) model.getValueAt(i, 0));
			int orderedQuantity = (int) model.getValueAt(i, 3);
			
			OrderDetail orderDetail = new OrderDetail(order, cd, orderedQuantity);
			OrderDetailDAO.instance.insert(orderDetail);
		}
	}
	
	public void setTotal() {
		double total = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			total += (double) model.getValueAt(i, 4);
		}
		txtTotal.setText(total + "");
	}
}
