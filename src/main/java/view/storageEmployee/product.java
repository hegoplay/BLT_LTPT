package view.storageEmployee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entities.OrderDetail;
import javax.swing.border.TitledBorder;

public class product extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenSanPham;
	private JTextField txtSoLuong;
	private JTextField txtPrice;
	private DefaultTableModel modell;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product frame = new product();
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
	public product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);

		JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(1221, 11, 80, 50);
        contentPane.add(menuBar_1);

        JMenu quanLy = new JMenu("Người dùng");
        menuBar_1.add(quanLy);

        JMenuItem info = new JMenuItem("Thông Tin");
        quanLy.add(info);

        JMenuItem thoat = new JMenuItem("Thoát");
        quanLy.add(thoat);
		
		JLabel lblTieuDe = new JLabel("Sản Phẩm");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(304, -11, 850, 90);
		getContentPane().add(lblTieuDe);

		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(15, 69, 1329, 653);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblThongTinSanPham = new JLabel("Thông tin sản phẩm");
		lblThongTinSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTinSanPham.setBounds(54, 11, 256, 25);
		panel.add(lblThongTinSanPham);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 47, 509, 595);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblmaCD = new JLabel("Mã CD");
		lblmaCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaCD.setBounds(20, 30, 133, 25);
		panel_1.add(lblmaCD);

		JTextField txtmaCD = new JTextField();
		txtmaCD.setBounds(163, 32, 307, 25);
		txtmaCD.setEditable(false);
		panel_1.add(txtmaCD);
		txtmaCD.setColumns(10);

		JLabel lblSoLuong = new JLabel("Quantity");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(20, 223, 133, 25);
		panel_1.add(lblSoLuong);

		JLabel lblPrice = new JLabel("Giá Bán | VND");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(20, 125, 133, 25);
		panel_1.add(lblPrice);

		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(163, 225, 307, 25);
		panel_1.add(txtSoLuong);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(163, 129, 307, 25);
		panel_1.add(txtPrice);
		
		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setBounds(20, 176, 133, 25);
		panel_1.add(lblTrangThai);
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JComboBox comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setBounds(163, 178, 305, 25);
		panel_1.add(comboBoxTrangThai);
		comboBoxTrangThai.addItem("Có hàng");
		comboBoxTrangThai.addItem("Không có hàng");
		

			comboBoxTrangThai.setSelectedIndex(0);
			
						JLabel lblTenSamPham = new JLabel("Tên Sản Phẩm");
						lblTenSamPham.setBounds(20, 78, 133, 25);
						panel_1.add(lblTenSamPham);
						lblTenSamPham.setFont(new Font("Tahoma", Font.BOLD, 15));
						
								txtTenSanPham = new JTextField();
								txtTenSanPham.setBounds(163, 80, 305, 25);
								panel_1.add(txtTenSanPham);
								txtTenSanPham.setEditable(false);
								txtTenSanPham.setColumns(10);
								
								JButton btnThem = new JButton("New button");
								btnThem.setBounds(10, 438, 110, 30);
								panel_1.add(btnThem);
								btnThem.setForeground(Color.WHITE);
								btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnThem.setBackground(new Color(0, 128, 255));
								btnThem.setText("Thêm");
								
								JButton btnSua = new JButton("New button");
								btnSua.setBounds(257, 438, 110, 30);
								panel_1.add(btnSua);
								btnSua.setBackground(new Color(0, 128, 255));
								btnSua.setForeground(Color.WHITE);
								btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnSua.setText("Sửa thông tin");
										
								JButton btnXoaRong = new JButton("New button");
								btnXoaRong.setBounds(389, 438, 110, 30);
								panel_1.add(btnXoaRong);
								btnXoaRong.setForeground(Color.WHITE);
								btnXoaRong.setBackground(new Color(0, 128, 255));
								btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnXoaRong.setText("Xoá rỗng");
												
								JButton btnXoa = new JButton("Xoá");
								btnXoa.setForeground(Color.WHITE);
								btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnXoa.setBackground(new Color(0, 128, 255));
								btnXoa.setBounds(137, 438, 110, 30);
								panel_1.add(btnXoa);
											
								btnXoa.addActionListener(this);
								btnXoaRong.addActionListener(this);
								btnSua.addActionListener(this);
								btnThem.addActionListener(this);
								
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(528, 47, 791, 595);
		panel.add(panel_1_1);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				
		JLabel lbldanhSachSanPham = new JLabel("Danh sách Sản Phẩm");
		lbldanhSachSanPham.setForeground(new Color(0, 27, 72));
		lbldanhSachSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldanhSachSanPham.setBounds(25, 11, 340, 25);
		panel_1_1.add(lbldanhSachSanPham);
						

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
		String[] col = {"Mã Sản Phẩm", "Tên sản phẩm", "Số Lượng", "Giá","Trạng Thái" };
		modell = new DefaultTableModel(col, 0);
		table_1.setModel(modell);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(942, 0, 283, 72);
		contentPane.add(lblUser);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
