package view.storageEmployee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderBill extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modell;
	private JTable table_1;
	private JTextField txtTenKH;
	private JTextField txtMaSP;
	private JTextField txtSanPham;
	private JTextField txtDiaChi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderBill frame = new OrderBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(942, 11, 283, 61);
		contentPane.add(lblUser);
		
		JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(1221, 15, 80, 50);
        contentPane.add(menuBar_1);

        JMenu quanLy = new JMenu("Người dùng");
        menuBar_1.add(quanLy);

        JMenuItem info = new JMenuItem("Thông Tin");
        quanLy.add(info);

        JMenuItem thoat = new JMenuItem("Thoát");
        quanLy.add(thoat);
		
		JLabel lblNewLabel = new JLabel("In Hóa Đơn ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1334, 61);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "X\u00E1c Nh\u1EADn \u0110\u01A1n H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 94, 322, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setBounds(10, 23, 120, 23);
		panel.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(10, 47, 239, 20);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setBounds(10, 78, 120, 23);
		panel.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(10, 101, 239, 20);
		panel.add(txtMaSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setBounds(10, 134, 120, 23);
		panel.add(lblTenSP);
		
		txtSanPham = new JTextField();
		txtSanPham.setColumns(10);
		txtSanPham.setBounds(10, 156, 239, 20);
		panel.add(txtSanPham);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(10, 187, 120, 23);
		panel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 210, 239, 20);
		panel.add(txtDiaChi);
		
		JButton btnTimHD = new JButton("Tìm Hóa Đơn");
		btnTimHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimHD.setBounds(10, 275, 141, 53);
		panel.add(btnTimHD);
		
		JButton btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setBounds(171, 275, 141, 53);
		panel.add(btnInHoaDon);
		
		JPanel panel_1 = new JPanel(new BorderLayout()); 
	    panel_1.setBounds(339, 94, 1005, 628);
	    contentPane.add(panel_1);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    panel_1.add(scrollPane_1, BorderLayout.CENTER); 
						
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JTableHeader tb1 = table_1.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight1 = 30;
		int rowMargin1 = 10;
		String[] col = {"Tên Khách Hàng","Mã Sản Phẩm", "Tên sản phẩm","Số Lượng","Tổng Tiền","Ngày Lập","Ngày Giao","Địa Chỉ" };
		modell = new DefaultTableModel(col, 0);
		table_1.setModel(modell);
		
		btnInHoaDon.addActionListener(this);
		btnTimHD.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
