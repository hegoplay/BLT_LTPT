package view.storageEmployee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JButton;
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

import component.OrderTable;
import entities.Order;
import entities.OrderStatus;
import util.storageEvents.StrEmployeeEvt;

public class PnlOrderBill extends JPanel implements ActionListener {

	private static final long serialVersionUID = 10000234852L;
	private DefaultTableModel modell;
	private JTable table_1;
	private JTextField txtTenKH;
	private JTextField txtMaSP;
	private JTextField txtSanPham;
	private JTextField txtDiaChi;
	private OrderTable tblOrder;

	
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	/**
	 * Create the frame.
	 */
	public PnlOrderBill(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setLayout(null);
		
		JPanel pnlFind = new JPanel();
		pnlFind.setBorder(new TitledBorder(null, "X\u00E1c Nh\u1EADn \u0110\u01A1n H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlFind.setBackground(new Color(255, 255, 255));
		pnlFind.setBounds(10, 11, 322, 589);
		this.add(pnlFind);
		pnlFind.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setBounds(10, 23, 120, 23);
		pnlFind.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(10, 47, 239, 20);
		pnlFind.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setBounds(10, 78, 120, 23);
		pnlFind.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(10, 101, 239, 20);
		pnlFind.add(txtMaSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setBounds(10, 134, 120, 23);
		pnlFind.add(lblTenSP);
		
		txtSanPham = new JTextField();
		txtSanPham.setColumns(10);
		txtSanPham.setBounds(10, 156, 239, 20);
		pnlFind.add(txtSanPham);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(10, 187, 120, 23);
		pnlFind.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 210, 239, 20);
		pnlFind.add(txtDiaChi);
		
		JButton btnTimHD = new JButton("Tìm Hóa Đơn");
		btnTimHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimHD.setBounds(10, 275, 141, 53);
		pnlFind.add(btnTimHD);
		
		JButton btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setBounds(171, 275, 141, 53);
		pnlFind.add(btnInHoaDon);
		
		JPanel pnlOrder = new JPanel(new BorderLayout()); 
	    pnlOrder.setBounds(350, 11, 960, 589);
	    this.add(pnlOrder);
	    
	    JScrollPane scrOrder = new JScrollPane();
	    pnlOrder.add(scrOrder, BorderLayout.CENTER); 
						
		tblOrder = new OrderTable();
		scrOrder.setViewportView(tblOrder);
		
		btnInHoaDon.addActionListener(this);
		btnTimHD.addActionListener(this);
		
		loadAllOrders();
	}

	private void loadAllOrders() {
		// TODO Auto-generated method stub
		try {
			oos.writeObject(StrEmployeeEvt.GET_ORDER);
			oos.writeObject("all");
//			oos.writeObject(null);
			oos.flush();
			List<Order> orders = (List<Order>) ois.readObject();
			System.out.println("YES");
			System.out.println(orders.size());
			tblOrder.ReloadTable(orders);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
