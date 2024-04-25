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
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PnlDoanhThuCuaHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDoanhThu;
	private JTextField textDoanhSo;
	private JTextField textLoiNhuan;
	private JTable table;
	private DefaultTableModel tableModel;
	/**
	 * Create the panel.
	 */
	public PnlDoanhThuCuaHang() {
		setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(10, 10, 1293, 792);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Doanh thu cửa hàng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel.setBounds(39, 11, 352, 56);
		panel_1.add(lblNewLabel);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(101, 81, 278, 124);
		panel_1.add(panel_2);
		
		textDoanhThu = new JTextField();
		textDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		textDoanhThu.setColumns(10);
		textDoanhThu.setBounds(10, 55, 258, 58);
		panel_2.add(textDoanhThu);
		textDoanhThu.setText("9890000 VNĐ");
		textDoanhThu.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Doanh thu (VNĐ)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(50, 11, 173, 33);
		panel_2.add(lblNewLabel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 64, 128));
		panel_3.setBounds(458, 81, 308, 124);
		panel_1.add(panel_3);
		
		textDoanhSo = new JTextField();
		textDoanhSo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		textDoanhSo.setColumns(10);
		textDoanhSo.setBounds(10, 55, 288, 58);
		panel_3.add(textDoanhSo);
		textDoanhSo.setText("8990000 VNĐ");
		textDoanhSo.setEditable(false);
		
		JLabel lblNewLabel_2_2 = new JLabel("Doanh số \r\n");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(108, 11, 109, 33);
		panel_3.add(lblNewLabel_2_2);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 64, 128));
		panel_2_1.setBounds(850, 81, 299, 124);
		panel_1.add(panel_2_1);
		
		textLoiNhuan = new JTextField();
		textLoiNhuan.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		textLoiNhuan.setColumns(10);
		textLoiNhuan.setBounds(10, 55, 279, 58);
		panel_2_1.add(textLoiNhuan);
		textLoiNhuan.setText("990000 VNĐ");
		textLoiNhuan.setEditable(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Lợi nhuận (VNĐ)");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(61, 11, 173, 33);
		panel_2_1.add(lblNewLabel_2_1);
		
		Panel panel_2_2 = new Panel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(0, 64, 128));
		panel_2_2.setBounds(706, 240, 528, 489);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Thông tin đĩa CD");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(186, 11, 173, 33);
		panel_2_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã đĩa CD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 55, 111, 22);
		panel_2_2.add(lblNewLabel_1_1);
		
		TextField textId_CD = new TextField();
		textId_CD.setBounds(10, 82, 217, 27);
		panel_2_2.add(textId_CD);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên đĩa CD");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 122, 111, 22);
		panel_2_2.add(lblNewLabel_1_1_1);
		
		TextField textName_CD = new TextField();
		textName_CD.setBounds(10, 150, 347, 27);
		panel_2_2.add(textName_CD);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số lượng bán ra");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 201, 158, 22);
		panel_2_2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Giá thành");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2.setBounds(10, 280, 173, 22);
		panel_2_2.add(lblNewLabel_1_1_1_2);
		
		TextField textQuantity = new TextField();
		textQuantity.setBounds(10, 232, 347, 27);
		panel_2_2.add(textQuantity);
		
		TextField textPrice = new TextField();
		textPrice.setBounds(10, 308, 347, 27);
		panel_2_2.add(textPrice);
		
		TextField textThanhTien = new TextField();
		textThanhTien.setBounds(10, 384, 347, 27);
		panel_2_2.add(textThanhTien);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Thành tiền");
		lblNewLabel_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2_1.setBounds(10, 356, 173, 22);
		panel_2_2.add(lblNewLabel_1_1_1_2_1);
		
		// Khởi tạo panel chứa JTable
		Panel panel_2_2_1 = new Panel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBackground(new Color(0, 64, 128));
		panel_2_2_1.setBounds(22, 317, 647, 412); // Đặt kích thước của panel
		panel_1.add(panel_2_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách đĩa CD bán chạy nhất");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 214, 22);
		panel_2_2_1.add(lblNewLabel_1);
		
		// Thiết lập kích thước cho JTable
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"CD001", "Album A", "50", "200000", "1000000"},
				{"CD002", "Album B", "30", "900000", "150000000"},
				{"CD003", "Album C", "20", "200000", "20000000"},
				{"CD004", "Album D", "40", "700000", "65000000"},
				{"CD005", "Album E", "10", "500000", "87000000"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"Mã đĩa CD", "Tên đĩa CD", "Số lượng bán ra", "Giá thành", "Thành tiền"
			}
		));
		table.setBounds(10, 44, 627, 357);
		panel_2_2_1.add(table);
		

		setLayout(null);

		// Khởi tạo model với các cột tương ứng
        String[] columnNames = {"Mã đĩa CD", "Tên đĩa CD", "Số lượng bán ra", "Giá thành", "Thành tiền"};
        tableModel = new DefaultTableModel(columnNames, 0); // 0 rows initially

        // Thêm dữ liệu mẫu vào model (có thể thêm nhiều dòng tùy ý)
        Object[] data1 = {"CD001", "Album A", 50, 200000, 10000000};
        Object[] data2 = {"CD002", "Album B", 30, 150000, 4500000};
        Object[] data3 = {"CD003", "Album C", 40, 180000, 7200000};
        tableModel.addRow(data1);
        tableModel.addRow(data2);
        tableModel.addRow(data3);

        // Khởi tạo JTable với model đã được tạo
        table = new JTable(tableModel);
        table.setBounds(10, 44, 627, 357);
        panel_2_2_1.add(table);
    
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy chỉ số dòng được chọn
                int row = table.getSelectedRow();

                // Lấy dữ liệu từ dòng được chọn và hiển thị lên các textfield tương ứng
                textId_CD.setText(table.getValueAt(row, 0).toString());
                textName_CD.setText(table.getValueAt(row, 1).toString());
                textQuantity.setText(table.getValueAt(row, 2).toString());
                textPrice.setText(table.getValueAt(row, 3).toString());
                textThanhTien.setText(table.getValueAt(row, 4).toString());
            }
        });

        
	}
}
