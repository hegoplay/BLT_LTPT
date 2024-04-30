package view.storageEmployee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ConfirmOrder extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JComboBox cbbTenKh;
	private DefaultTableModel modell;
	private JTable table_1;
	private JTextField txtTenSP;
	private JTextField txtDiaChi;
	private JTextField txtTongTien;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmOrder frame = new ConfirmOrder();
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
	public ConfirmOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Xác Nhận Đơn Hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 0, 1346, 71); // Adjusted width
        contentPane.add(lblNewLabel);
		
		JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(1229, 21, 80, 50);
        contentPane.add(menuBar_1);

        JMenu quanLy = new JMenu("Người dùng");
        menuBar_1.add(quanLy);

        JMenuItem info = new JMenuItem("Thông Tin");
        quanLy.add(info);

        JMenuItem thoat = new JMenuItem("Thoát");
        quanLy.add(thoat);

        JLabel lblUser = new JLabel("User");
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        lblUser.setBounds(936, 5, 283, 72);
        contentPane.add(lblUser);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 67, 1334, 655);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Thông Tin Đơn Hàng");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(10, 11, 286, 40);
        panel.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 47, 509, 595);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblmaCD = new JLabel("Tên Khách Hàng");
		lblmaCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaCD.setBounds(20, 30, 133, 25);
		panel_1.add(lblmaCD);

		JLabel lblSoLuong = new JLabel("Ngày Lập");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(20, 223, 133, 25);
		panel_1.add(lblSoLuong);

		JLabel lblPrice = new JLabel("Tên Sản Phẩm");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(20, 125, 133, 25);
		panel_1.add(lblPrice);
		
		
		JLabel lblTrangThai = new JLabel("Tổng Tiền ");
		lblTrangThai.setBounds(20, 176, 133, 25);
		panel_1.add(lblTrangThai);
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
			
		JLabel lblTenSamPham = new JLabel("Mã Sản Phẩm");
		lblTenSamPham.setBounds(20, 78, 133, 25);
		panel_1.add(lblTenSamPham);
		lblTenSamPham.setFont(new Font("Tahoma", Font.BOLD, 15));
						
		cbbTenKh = new JComboBox<String>();
		cbbTenKh.setBounds(163, 80, 305, 25);
		panel_1.add(cbbTenKh);
		cbbTenKh.addItem("Khách Hàng A");
		cbbTenKh.addItem("Khách Hàng B");
	
		cbbTenKh.setSelectedIndex(0);
		
		
		
		JButton btnThem = new JButton("New button");
		btnThem.setBounds(43, 438, 110, 30);
		panel_1.add(btnThem);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));
		btnThem.setText("Xác nhận Đơn");
								
		JButton btnSua = new JButton("New button");
		btnSua.setBounds(358, 438, 110, 30);
		panel_1.add(btnSua);
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setText("Sửa Đơn");
												
								JButton btnXoa = new JButton("Xoá Đơn ");
								btnXoa.setForeground(Color.WHITE);
								btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnXoa.setBackground(new Color(0, 128, 255));
								btnXoa.setBounds(202, 438, 110, 30);
								panel_1.add(btnXoa);
								
								JLabel lblNgyGiao = new JLabel("Ngày Giao");
								lblNgyGiao.setFont(new Font("Tahoma", Font.BOLD, 15));
								lblNgyGiao.setBounds(20, 272, 133, 25);
								panel_1.add(lblNgyGiao);
								
								JLabel lbDiaCHi = new JLabel("Địa chỉ");
								lbDiaCHi.setFont(new Font("Tahoma", Font.BOLD, 15));
								lbDiaCHi.setBounds(20, 319, 133, 25);
								panel_1.add(lbDiaCHi);
								
								txtTenSP = new JTextField();
								txtTenSP.setEditable(false);
								txtTenSP.setColumns(10);
								txtTenSP.setBounds(163, 129, 307, 25);
								panel_1.add(txtTenSP);
								
								txtDiaChi = new JTextField();
								txtDiaChi.setEditable(false);
								txtDiaChi.setColumns(10);
								txtDiaChi.setBounds(163, 319, 307, 25);
								panel_1.add(txtDiaChi);
								
								txtTongTien = new JTextField();
								txtTongTien.setEditable(false);
								txtTongTien.setColumns(10);
								txtTongTien.setBounds(163, 180, 307, 25);
								panel_1.add(txtTongTien);
								
								
								
								JDateChooser dateChooser = new JDateChooser();
								dateChooser.setBounds(163, 223, 307, 25);
								panel_1.add(dateChooser);
								
								JDateChooser dateChooser_1 = new JDateChooser();
								dateChooser_1.setBounds(161, 272, 307, 25);
								panel_1.add(dateChooser_1);
											
								btnXoa.addActionListener(this);
								btnSua.addActionListener(this);
								btnThem.addActionListener(this);
								
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(528, 47, 791, 595);
		panel.add(panel_1_1);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				
		JLabel lbldanhSachDonHang = new JLabel("Danh sách Đơn Hàng");
		lbldanhSachDonHang.setForeground(new Color(0, 27, 72));
		lbldanhSachDonHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldanhSachDonHang.setBounds(25, 11, 340, 25);
		panel_1_1.add(lbldanhSachDonHang);
						

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 46, 744, 527);
		panel_1_1.add(scrollPane_1);
						
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JTableHeader tb1 = table_1.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight1 = 30;
		int rowMargin1 = 10;
		String[] col = {"Tên Khách Hàng","Mã Sản Phẩm", "Tên sản phẩm","Tổng Tiền","Ngày Lập","Ngày Giao","Địa Chỉ" };
		modell = new DefaultTableModel(col, 0);
		table_1.setModel(modell);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
