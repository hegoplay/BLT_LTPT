package view.storageEmployee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class PnlOrderBill extends JPanel implements ActionListener {

	private static final long serialVersionUID = 10000234852L;
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
					PnlOrderBill frame = new PnlOrderBill();
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
	public PnlOrderBill() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "X\u00E1c Nh\u1EADn \u0110\u01A1n H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 15, 322, 707);
		this.add(panel);
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
	    panel_1.setBounds(350, 15, 960, 585);
	    this.add(panel_1);
	    
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
