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
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PnlSanPhamTheoThang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textId;
	private JTextField textName;
	private JTextField textGiaThanh;
	private JTextField textSoLuong;
	private JTextField textTimTheoMa;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public PnlSanPhamTheoThang() {
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 215));
		panel.setForeground(new Color(230, 221, 208));
		panel.setBounds(0, 0, 1314, 816);
		add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(23, 25, 742, 739);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê sản phẩm theo tháng\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel.setBounds(21, 11, 448, 56);
		panel_1.add(lblNewLabel);
		
		JComboBox coboBoxT = new JComboBox();
		coboBoxT.setModel(new DefaultComboBoxModel(new String[] {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"}));
		coboBoxT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		coboBoxT.setBounds(468, 28, 136, 32);
		panel_1.add(coboBoxT);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tìm sản phẩm theo mã\r\n");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 272, 195, 32);
		panel_1.add(lblNewLabel_1_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(20, 90, 334, 125);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng sản phẩm đã bán\r\n");
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setBounds(37, 11, 257, 32);
		panel_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 64, 128));
		panel_2_1.setBounds(385, 90, 334, 125);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tổng sản phẩm hoàn trả\r\n\r\n");
		lblNewLabel_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2_1_1.setBounds(25, 11, 287, 32);
		panel_2_1.add(lblNewLabel_1_2_1_1);
		
		textTimTheoMa = new JTextField();
		textTimTheoMa.setColumns(10);
		textTimTheoMa.setBounds(203, 274, 411, 32);
		panel_1.add(textTimTheoMa);
		
		Panel panel_2_2 = new Panel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(0, 64, 128));
		panel_2_2.setBounds(20, 318, 712, 411);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1_2_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1_2.setBounds(10, 11, 257, 32);
		panel_2_2.add(lblNewLabel_1_2_1_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"SP001", "Sản phẩm A", 100000, 50, "Còn hàng"},
				{"SP002", "Sản phẩm B", 200000, 30, "Còn hàng"},
				{"SP003", "Sản phẩm C", 300000, 60, "Còn hàng"},
				{"SP004", "Sản phẩm D", 1500000, 10, "Còn hàng"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Giá thành", "Số lượng", "Trạng thái"
			}
		));
		table.setBounds(10, 42, 692, 358);
		panel_2_2.add(table);
		
		JButton btnTim = new JButton("Tìm\r\n");
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setBackground(new Color(0, 64, 128));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTim.setBounds(624, 272, 95, 32);
		panel_1.add(btnTim);
		
		JComboBox comboBoxNam = new JComboBox();
		comboBoxNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		comboBoxNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBoxNam.setBounds(627, 28, 105, 32);
		panel_1.add(comboBoxNam);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1.setBounds(815, 25, 468, 739);
		panel.add(panel_1_1);
		
		JLabel lblThngTinSn = new JLabel("Thông tin sản phẩm");
		lblThngTinSn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblThngTinSn.setBounds(91, 8, 292, 56);
		panel_1_1.add(lblThngTinSn);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox_1.setBounds(536, 25, 136, 32);
		panel_1_1.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 69, 110, 32);
		panel_1_1.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setBounds(10, 101, 197, 32);
		panel_1_1.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm\r\n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 147, 110, 32);
		panel_1_1.add(lblNewLabel_1_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(10, 178, 312, 32);
		panel_1_1.add(textName);
		
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
		
		setLayout(null);

        // Các dòng tiếp theo trong constructor

        // Khởi tạo model với các cột tương ứng
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Giá thành", "Số lượng", "Trạng thái"};
        tableModel = new DefaultTableModel(columnNames, 0); // 0 rows initially

        // Thêm dữ liệu mẫu vào model (có thể thêm nhiều dòng tùy ý)
        Object[] data1 = {"SP001", "Sản phẩm A", 100000, 50, "Còn hàng"};
        Object[] data2 = {"SP002", "Sản phẩm B", 150000, 30, "Hết hàng"};
        Object[] data3 = {"SP003", "Sản phẩm C", 200000, 40, "Còn hàng"};
        tableModel.addRow(data1);
        tableModel.addRow(data2);
        tableModel.addRow(data3);

        // Khởi tạo JTable với model đã được tạo
        table = new JTable(tableModel);
        table.setBounds(10, 42, 692, 358);
        panel_2_2.add(table);

	}
}
