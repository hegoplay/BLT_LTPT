package view.storageEmployee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import component.OrderDetailTable;
import component.OrderTable;
import dao.OrderDAO;
import entities.Order;
import entities.OrderStatus;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

public class PnlConfirmOrder extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modell;
	private JTable table_1;
	private JTextField txtOrderId;
	private JTextField txtNumber;
	private JTextField txtRoad;
	private JTextField txtCity;
	private JTextField txtCustomer;
	private JTextField txtTotal;
	private OrderTable tblOrder;
	private OrderDetailTable tblOD;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public PnlConfirmOrder() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 1366, 768);
//        contentPane = new JPanel();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1334, 655);
		this.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thông Tin Đơn Hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 286, 40);
		panel.add(lblNewLabel_1);

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(
				new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfo.setBackground(new Color(255, 255, 255));
		pnlInfo.setBounds(10, 47, 509, 543);
		panel.add(pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[] { 100, 0, 10 };
		gbl_pnlInfo.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 0, 30};
		gbl_pnlInfo.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gbl_pnlInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlInfo.setLayout(gbl_pnlInfo);

		JLabel lblOrderID = new JLabel("Mã đơn");
		GridBagConstraints gbc_lblOrderID = new GridBagConstraints();
		gbc_lblOrderID.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderID.gridx = 0;
		gbc_lblOrderID.gridy = 0;
		pnlInfo.add(lblOrderID, gbc_lblOrderID);

		txtOrderId = new JTextField();
		txtOrderId.setEditable(false);
		GridBagConstraints gbc_txtOrderId = new GridBagConstraints();
		gbc_txtOrderId.insets = new Insets(0, 0, 5, 0);
		gbc_txtOrderId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrderId.gridx = 2;
		gbc_txtOrderId.gridy = 0;
		pnlInfo.add(txtOrderId, gbc_txtOrderId);
		txtOrderId.setColumns(10);

		JLabel lblCreatedDate = new JLabel("Ngày tạo đơn");
		GridBagConstraints gbc_lblCreatedDate = new GridBagConstraints();
		gbc_lblCreatedDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreatedDate.gridx = 0;
		gbc_lblCreatedDate.gridy = 1;
		pnlInfo.add(lblCreatedDate, gbc_lblCreatedDate);

		JDateChooser dateOrder = new JDateChooser();
		dateOrder.getCalendarButton().setEnabled(false);

		GridBagConstraints gbc_dateOrder = new GridBagConstraints();
		gbc_dateOrder.insets = new Insets(0, 0, 5, 0);
		gbc_dateOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateOrder.gridx = 2;
		gbc_dateOrder.gridy = 1;
		pnlInfo.add(dateOrder, gbc_dateOrder);

		JLabel lblNumber = new JLabel("Số nhà");
		GridBagConstraints gbc_lblNumber = new GridBagConstraints();
		gbc_lblNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber.gridx = 0;
		gbc_lblNumber.gridy = 2;
		pnlInfo.add(lblNumber, gbc_lblNumber);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		GridBagConstraints gbc_txtNumber = new GridBagConstraints();
		gbc_txtNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumber.gridx = 2;
		gbc_txtNumber.gridy = 2;
		pnlInfo.add(txtNumber, gbc_txtNumber);
		txtNumber.setColumns(10);

		JLabel lblRoad = new JLabel("Tên đường");
		GridBagConstraints gbc_lblRoad = new GridBagConstraints();
		gbc_lblRoad.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoad.gridx = 0;
		gbc_lblRoad.gridy = 3;
		pnlInfo.add(lblRoad, gbc_lblRoad);

		txtRoad = new JTextField();
		txtRoad.setEditable(false);
		GridBagConstraints gbc_txtRoad = new GridBagConstraints();
		gbc_txtRoad.insets = new Insets(0, 0, 5, 0);
		gbc_txtRoad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRoad.gridx = 2;
		gbc_txtRoad.gridy = 3;
		pnlInfo.add(txtRoad, gbc_txtRoad);
		txtRoad.setColumns(10);

		JLabel lblCity = new JLabel("Thành phố");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 4;
		pnlInfo.add(lblCity, gbc_lblCity);

		txtCity = new JTextField();
		txtCity.setEditable(false);
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 0);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 2;
		gbc_txtCity.gridy = 4;
		pnlInfo.add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);

		JLabel lblCustomer = new JLabel("Khách Hàng");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 0;
		gbc_lblCustomer.gridy = 5;
		pnlInfo.add(lblCustomer, gbc_lblCustomer);

		txtCustomer = new JTextField();
		txtCustomer.setEditable(false);
		GridBagConstraints gbc_txtCustomer = new GridBagConstraints();
		gbc_txtCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomer.gridx = 2;
		gbc_txtCustomer.gridy = 5;
		pnlInfo.add(txtCustomer, gbc_txtCustomer);
		txtCustomer.setColumns(10);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		GridBagConstraints gbc_lblTongTien = new GridBagConstraints();
		gbc_lblTongTien.insets = new Insets(0, 0, 5, 5);
		gbc_lblTongTien.gridx = 0;
		gbc_lblTongTien.gridy = 6;
		pnlInfo.add(lblTongTien, gbc_lblTongTien);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 2;
		gbc_txtTotal.gridy = 6;
		pnlInfo.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);

		JPanel pnlChiTietDonHang = new JPanel();
		pnlChiTietDonHang.setBorder(new TitledBorder(null, "Chi ti\u1EBFt \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietDonHang.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_pnlChiTietDonHang = new GridBagConstraints();
		gbc_pnlChiTietDonHang.insets = new Insets(0, 0, 5, 0);
		gbc_pnlChiTietDonHang.gridwidth = 3;
		gbc_pnlChiTietDonHang.fill = GridBagConstraints.BOTH;
		gbc_pnlChiTietDonHang.gridx = 0;
		gbc_pnlChiTietDonHang.gridy = 7;
		pnlInfo.add(pnlChiTietDonHang, gbc_pnlChiTietDonHang);
		pnlChiTietDonHang.setLayout(new BorderLayout(0, 0));

		JScrollPane scrOD = new JScrollPane();
		tblOD = new OrderDetailTable();
		scrOD.setViewportView(tblOD);
		pnlChiTietDonHang.add(scrOD);

		JPanel lblOptions = new JPanel();
		lblOptions.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.fill = GridBagConstraints.BOTH;
		gbc_lblOptions.gridwidth = 3;
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 8;
		pnlInfo.add(lblOptions, gbc_lblOptions);

		JButton btnAccept = new JButton("Chấp nhận");
		lblOptions.add(btnAccept);

		JButton btnReject = new JButton("Hủy đơn");
		lblOptions.add(btnReject);

//		btnXoa.addActionListener(this);
//		btnSua.addActionListener(this);
//		btnThem.addActionListener(this);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(529, 47, 791, 543);
		panel.add(panel_1_1);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		JLabel lbldanhSachDonHang = new JLabel("Danh sách Đơn Hàng");
		lbldanhSachDonHang.setForeground(new Color(0, 27, 72));
		lbldanhSachDonHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldanhSachDonHang.setBounds(25, 11, 340, 25);
		panel_1_1.add(lbldanhSachDonHang);

		JScrollPane scrOrder = new JScrollPane();
		scrOrder.setBounds(24, 46, 744, 486);
		panel_1_1.add(scrOrder);

		tblOrder = new OrderTable();
		scrOrder.setViewportView(tblOrder);
//		JTableHeader tb1 = table_1.getTableHeader();
//		tb1.setBackground(new Color(221, 242, 251));
//		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
//		int rowHeight1 = 30;
//		int rowMargin1 = 10;
//		String[] col = { "Tên Khách Hàng", "Mã Sản Phẩm", "Tên sản phẩm", "Tổng Tiền", "Ngày Lập", "Ngày Giao",
//				"Địa Chỉ" };
//		modell = new DefaultTableModel(col, 0);
//		table_1.setModel(modell);
		loadAllOrders();
	}

	private void loadAllOrders() {
		// TODO Auto-generated method stub
		List<Order> orders = OrderDAO.instance.getOrderByStatus(OrderStatus.PENDING);
		
		tblOrder.ReloadTable(orders);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
