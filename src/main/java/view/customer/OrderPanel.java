package view.customer;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;
import util.clients.CustomerClient;

public class OrderPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable orderTable;
	private JTable orderDetailTable;
	private JTextField textField_orderId;
	private JTextField textField_total;
	private JTextField textField_status;
	private JTextField textField_shippedDate;
	private JTextField textField_address;
	private JComboBox<String> comboBox_orderStatus;

	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("My Orders :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 71, 108, 34);
		add(lblNewLabel);

		comboBox_orderStatus = new JComboBox<String>();
		// Set order status for the combo box from OrderStatus enum.
		OrderStatus[] statuses = OrderStatus.values();
		String[] statusNames = new String[statuses.length];

		for (int i = 0; i < statuses.length; i++) {
		    statusNames[i] = statuses[i].toString();
		}
		comboBox_orderStatus
				.setModel(new DefaultComboBoxModel(statusNames));
		comboBox_orderStatus.setBounds(329, 63, 111, 22);
		add(comboBox_orderStatus);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 110, 414, 417);
		add(scrollPane);

		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, },
				new String[] { "Order id", "Order date", "Status" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(orderTable);

		JLabel lblNewLabel_1 = new JLabel("Order Detail :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(550, 71, 151, 22);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Order id :");
		lblNewLabel_2.setBounds(550, 108, 65, 14);
		add(lblNewLabel_2);

		textField_orderId = new JTextField();
		textField_orderId.setEditable(false);
		textField_orderId.setColumns(10);
		textField_orderId.setBounds(625, 105, 400, 20);
		add(textField_orderId);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(534, 143, 491, 182);
		add(scrollPane_1);

		orderDetailTable = new JTable();
		scrollPane_1.setViewportView(orderDetailTable);
		orderDetailTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"CD id", "CD name", "Quantity", "Price", "Subtotal"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Integer.class, Object.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Total :");
		lblNewLabel_3.setBounds(550, 371, 46, 14);
		add(lblNewLabel_3);

		textField_total = new JTextField();
		textField_total.setEditable(false);
		textField_total.setColumns(10);
		textField_total.setBounds(636, 368, 380, 20);
		add(textField_total);

		JLabel lblNewLabel_3_1 = new JLabel("Status :");
		lblNewLabel_3_1.setBounds(550, 412, 46, 14);
		add(lblNewLabel_3_1);

		textField_status = new JTextField();
		textField_status.setEditable(false);
		textField_status.setColumns(10);
		textField_status.setBounds(636, 409, 384, 20);
		add(textField_status);

		JLabel lblNewLabel_3_2 = new JLabel("Shipped date :");
		lblNewLabel_3_2.setBounds(550, 454, 100, 14);
		add(lblNewLabel_3_2);

		textField_shippedDate = new JTextField();
		textField_shippedDate.setEditable(false);
		textField_shippedDate.setColumns(10);
		textField_shippedDate.setBounds(640, 451, 380, 20);
		add(textField_shippedDate);

		JLabel lblNewLabel_3_3 = new JLabel("Address :");
		lblNewLabel_3_3.setBounds(550, 494, 65, 14);
		add(lblNewLabel_3_3);

		textField_address = new JTextField();
		textField_address.setEditable(false);
		textField_address.setColumns(10);
		textField_address.setBounds(640, 491, 380, 20);
		add(textField_address);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(491, 40, 2, 507);
		add(separator);

		orderTable.addMouseListener(this);
		orderDetailTable.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == orderTable) {
			// Load the order detail data of the selected order.
			int row = orderTable.getSelectedRow();
			String orderId = orderTable.getValueAt(row, 0).toString();
			loadOrderDetailData(orderId);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void loadOrderTableData() {
		// Get all orders of the current customer. (There should be some mechanism to
		// retrieve the current customer).
		List<Order> result = new ArrayList<>();
		
		// DAO to get orders.
//		result = OrderDAO.instance.findByCustomerId(CustomerGui.customerID);
		
		// Use client to request all Order(s) attached to the currently logged in customer.
		result = CustomerClient.instance.findByCustomerId(CustomerGui.customer.getPersonID());
		
		DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
		model.setRowCount(0);
		for (Order order : result) {
			model.addRow(new Object[] { order.getOrderId(), order.getCreatedDate(), order.getStatus() });
		}
	}

	/*
	 * Set order detail data for the provided orderId
	 *  (including table and text fields).
	 * */ 
	public void loadOrderDetailData(String orderId) {
		List<OrderDetail> result = new ArrayList<>();
		
		// Use client to request the order details attached to the provided orderId.
		result = CustomerClient.instance.findByOrderId(orderId);

		DefaultTableModel model = (DefaultTableModel) orderDetailTable.getModel();
		model.setRowCount(0);
		for (OrderDetail orderDetail : result) {
			model.addRow(new Object[] { orderDetail.getCd().getCdID(), orderDetail.getCd().getName(),
					orderDetail.getQuantity(), orderDetail.getCd().getPrice(), orderDetail.getSubTotal() });
		}

		// Use client to request the Order object.
		Order order = CustomerClient.instance.findById(orderId, Order.class);

		// Set total, status, shipped date, address.
		double total = 0;
		for (OrderDetail od : result) {
			total += od.getSubTotal();
		}
		
		textField_orderId.setText("");
		textField_total.setText("");
		textField_status.setText("");
		textField_shippedDate.setText("");
		textField_address.setText("");
		
		if (order.getShippedDate() != null) {
			textField_shippedDate.setText(order.getShippedDate().toString());
		}
		else {
			textField_shippedDate.setText("not yet shipped");
		}
		
		textField_orderId.setText(orderId);
		textField_total.setText(String.valueOf(total));
		textField_status.setText(order.getStatus().toString());
		textField_address.setText(order.getShippingAddress().toString());
	}

}
