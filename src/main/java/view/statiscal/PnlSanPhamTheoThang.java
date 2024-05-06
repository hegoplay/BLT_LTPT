package view.statiscal;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Choice;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;


import component.CDTable;
import dao.CDDAO;
import dao.PersonDAO;
import entities.CD;
import entities.Customer;
import entities.Person;
import entities.StatiscalEmployee;
import entities.StorageEmployee;
import util.Constant;
import util.clients.StatisticalClient;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PnlSanPhamTheoThang extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTable table; // Biến cho bảng hiển thị danh sách sản phẩm

	// Các biến JTextField để hiển thị thông tin sản phẩm được chọn
	private JTextField textId;
	private JTextField textName;
	private JTextField textGiaThanh;
	private JTextField textSoLuong;

	// Các biến JTextField để nhập thông tin sản phẩm mới
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField text_GiaThanh;
	private JTextField text_SoLuong;

	// Các biến JRadioButton cho trạng thái sản phẩm
	private JRadioButton rdbtnCon;
	private JRadioButton rdbtnHet;

	// Các biến JButton để thực hiện các thao tác
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnXoa;

	// Biến JTextField để nhập mã sản phẩm cần tìm kiếm
	private JTextField textTimTheoMa;

	// Biến JComboBox cho việc chọn tháng
	private JComboBox coboBoxT;

	// Biến JComboBox cho việc chọn năm
	private JComboBox comboBoxNam;
	private DefaultTableModel tableModel;
	private JLabel lblTitle;
	private CDTable tblSP;
	private JComboBox cmbMonth;
	private JLabel lblSum;

	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private JComboBox cmbYear;
	private JButton btnTim;
	
	/**
	 * 
	 * 
	 * Create the panel.
	 */
	public PnlSanPhamTheoThang() {
		setLayout(null);
		
		Panel pnlBG = new Panel();
		pnlBG.setBackground(new Color(255, 255, 215));
		pnlBG.setForeground(new Color(230, 221, 208));
		pnlBG.setBounds(10, 10, 1318, 751);
		add(pnlBG);
		pnlBG.setLayout(null);
		
		Panel pnlMain = new Panel();
		pnlMain.setBounds(23, 25, 1281, 716);
		pnlMain.setBackground(new Color(128, 255, 255));
		pnlBG.add(pnlMain);
		pnlMain.setLayout(null);
		
		lblTitle = new JLabel("Thống kê sản phẩm theo tháng\r\n");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblTitle.setBounds(21, 11, 448, 56);
		pnlMain.add(lblTitle);
		
		cmbMonth = new JComboBox();
		cmbMonth.setModel(new DefaultComboBoxModel(new String[] {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"}));
		cmbMonth.setSelectedIndex(4);
		cmbMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cmbMonth.setBounds(468, 28, 136, 32);
		pnlMain.add(cmbMonth);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tìm sản phẩm theo mã\r\n");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 272, 195, 32);
		pnlMain.add(lblNewLabel_1_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(20, 90, 712, 125);
		pnlMain.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng sản phẩm đã bán\r\n");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setBounds(10, 11, 692, 32);
		panel_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		lblSum = new JLabel("0");
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		lblSum.setForeground(Color.WHITE);
		lblSum.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSum.setBounds(10, 54, 692, 32);
		panel_2.add(lblSum);
		
		textTimTheoMa = new JTextField();
		textTimTheoMa.setColumns(10);
		textTimTheoMa.setBounds(203, 274, 411, 32);
		pnlMain.add(textTimTheoMa);
		
		Panel pnlDSSP = new Panel();
		pnlDSSP.setLayout(null);
		pnlDSSP.setBackground(new Color(0, 64, 128));
		pnlDSSP.setBounds(20, 318, 712, 371);
		pnlMain.add(pnlDSSP);
		
		JLabel lblCDTitle = new JLabel("Danh sách sản phẩm");
		lblCDTitle.setForeground(new Color(255, 255, 255));
		lblCDTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCDTitle.setBounds(10, 11, 257, 32);
		pnlDSSP.add(lblCDTitle);
		
		JScrollPane srcSP = new JScrollPane();
		srcSP.setBounds(10, 54, 692, 306);
		pnlDSSP.add(srcSP);
		
		tblSP = new CDTable();
		srcSP.setViewportView(tblSP);
	
		
		btnTim = new JButton("Tìm\r\n");
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setBackground(new Color(0, 64, 128));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTim.setBounds(624, 272, 95, 32);
		pnlMain.add(btnTim);
		
		cmbYear = new JComboBox();
		cmbYear.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		cmbYear.setSelectedIndex(2);
		cmbYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cmbYear.setBounds(627, 28, 105, 32);
		pnlMain.add(cmbYear);
		
		setLayout(null);
        
        JLabel lblThngTinSn = new JLabel("Thông tin sản phẩm");
        lblThngTinSn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        lblThngTinSn.setBounds(864, 11, 334, 56);
        pnlMain.add(lblThngTinSn);
        
        Panel pnlContent = new Panel();
        pnlContent.setLayout(null);
        pnlContent.setBackground(new Color(0, 64, 128));
        pnlContent.setBounds(790, 90, 467, 599);
        pnlMain.add(pnlContent);
        
        JLabel lblMa = new JLabel("Mã");
        lblMa.setForeground(new Color(255, 255, 255));
        lblMa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblMa.setBounds(10, 23, 105, 32);
        pnlContent.add(lblMa);
        
        txtMa = new JTextField();
        txtMa.setColumns(10);
        txtMa.setBounds(10, 55, 208, 32);
        pnlContent.add(txtMa);
        
        JLabel lblTen = new JLabel("Tên sản phẩm");
        lblTen.setForeground(Color.WHITE);
        lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblTen.setBounds(10, 108, 105, 32);
        pnlContent.add(lblTen);
        
        txtTen = new JTextField();
        txtTen.setColumns(10);
        txtTen.setBounds(10, 143, 447, 32);
        pnlContent.add(txtTen);
        
        JLabel lblGiaThanh = new JLabel("Giá thành");
        lblGiaThanh.setForeground(Color.WHITE);
        lblGiaThanh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblGiaThanh.setBounds(10, 197, 105, 32);
        pnlContent.add(lblGiaThanh);
        
        text_GiaThanh = new JTextField();
        text_GiaThanh.setColumns(10);
        text_GiaThanh.setBounds(10, 234, 447, 32);
        pnlContent.add(text_GiaThanh);
        
        JLabel lblSoLuong = new JLabel("Số lượng\r\n");
        lblSoLuong.setForeground(Color.WHITE);
        lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSoLuong.setBounds(10, 284, 105, 32);
        pnlContent.add(lblSoLuong);
        
        JLabel lblTrangThai = new JLabel("Trạng thái\r\n");
        lblTrangThai.setForeground(Color.WHITE);
        lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblTrangThai.setBounds(10, 362, 105, 32);
        pnlContent.add(lblTrangThai);
        
        text_SoLuong = new JTextField();
        text_SoLuong.setColumns(10);
        text_SoLuong.setBounds(10, 319, 447, 32);
        pnlContent.add(text_SoLuong);
        
        JRadioButton rdbtnConHang = new JRadioButton("Còn hàng");
        rdbtnConHang.setBounds(10, 401, 111, 23);
        pnlContent.add(rdbtnConHang);
        
        Panel panel_1_1 = new Panel();
        JRadioButton rdbtHetHang = new JRadioButton("Hết hàng");
        rdbtHetHang.setBounds(161, 401, 111, 23);
        pnlContent.add(rdbtHetHang);
//		panel_1_1.add(textName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá thành");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 221, 110, 32);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		textGiaThanh = new JTextField();
		textGiaThanh.setColumns(10);
		textGiaThanh.setBounds(10, 250, 312, 32);
		panel_1_1.add(textGiaThanh);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 296, 110, 32);
		panel_1_1.add(lblNewLabel_1_1_1_1);
		
		textSoLuong = new JTextField();
		textSoLuong.setColumns(10);
		textSoLuong.setBounds(10, 326, 312, 32);
		panel_1_1.add(textSoLuong);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Trạng thái\n");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(10, 372, 110, 32);
		panel_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton rdbtnCon = new JRadioButton("Còn hàng");
		rdbtnCon.setBounds(9, 411, 111, 23);
		panel_1_1.add(rdbtnCon);
		
		JRadioButton rdbtnHet = new JRadioButton("Hết hàng");
		rdbtnHet.setBounds(163, 408, 111, 23);
		panel_1_1.add(rdbtnHet);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 64, 128));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThem.setBounds(10, 468, 95, 32);
		panel_1_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa\r\n");
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(0, 64, 128));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSua.setBounds(127, 468, 95, 32);
		panel_1_1.add(btnSua);
		
		JButton btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.setBackground(new Color(0, 64, 128));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLamMoi.setBounds(244, 468, 110, 32);
		panel_1_1.add(btnLamMoi);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0, 64, 128));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXoa.setBounds(375, 468, 83, 32);
		panel_1_1.add(btnXoa);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnCon);
		btnGroup.add(rdbtnHet);
		
		setLayout(null);
		
		tblSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = tblSP.getSelectedRow();
				CD p = CDDAO.instance.findById(tblSP.getValueAt(row, 0).toString());
				txtMa.setText(p.getCdID());
				txtTen.setText(p.getName());
				text_GiaThanh.setText(p.getPrice() + "");
				text_SoLuong.setText(p.getQuantity() + "");
				if (p.isStatus()) {
					rdbtnConHang.setSelected(true);
				} else {
					rdbtHetHang.setSelected(true);
				}
				
			}
		});
		
		
		
		loadData();
//		CDDAO.instance.getCDinTime(5,2024);
		
		btnTim.addActionListener(this);

	}

	private void loadData() {
		// TODO Auto-generated method stub
		Map<CD,Integer> listCD = StatisticalClient.instance.getCDinTime(cmbMonth.getSelectedIndex() + 1, 2022 + cmbYear.getSelectedIndex());
//		Map<CD,Integer> listCD = CDDAO.instance.getCDinTime(5,2024);
		List<CD> ls = new ArrayList<>();
		int sum = 0;
//		iterate pair through map
		
		
		for (Entry<CD,Integer> e : listCD.entrySet()) {
			sum += e.getValue();
			CD cd = e.getKey();
			cd.setQuantity(e.getValue());
			ls.add(cd);
		}
		lblSum.setText(sum + "");
		tblSP.ReloadTable(ls);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnTim) {
			loadData();
		}
	}
}