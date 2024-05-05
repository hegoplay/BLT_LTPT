package view.storageEmployee;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

import dao.ProductDAO;
import entities.CD;

public class PnlProduct extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlBackground;
	private JPanel pnlContent;
	private JLabel lblTitle;
	private JTextField txtTenSanPham;
	private JTextField txtSoLuong;
	private JTextField txtPrice,txtmaCD;
	private DefaultTableModel modell;
	private JTable table_1;
	private JButton btnXoaRong,btnXoa,btnSua,btnThem;
	JComboBox comboBoxTrangThai;
	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PnlProduct frame = new PnlProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PnlProduct() {
		 this.setBounds(100, 100, 1339, 665);
		 
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
	

		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1339, 664);
		this.add(panel);
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

		 txtmaCD = new JTextField();
		txtmaCD.setBounds(163, 32, 307, 25);
		
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
		
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(163, 225, 307, 25);
		panel_1.add(txtSoLuong);
		
		txtPrice = new JTextField();
		
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
	
		txtTenSanPham.setColumns(10);
								
		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 438, 110, 30);
		panel_1.add(btnThem);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));
	
								
		btnSua = new JButton("Sửa thông tin");
		btnSua.setBounds(257, 438, 110, 30);
		panel_1.add(btnSua);
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
										
		btnXoaRong = new JButton("Xoá rỗng");
		btnXoaRong.setBounds(389, 438, 110, 30);
		panel_1.add(btnXoaRong);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(new Color(0, 128, 255));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	
												
		btnXoa = new JButton("Xoá");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBackground(new Color(0, 128, 255));
		btnXoa.setBounds(137, 438, 110, 30);
		panel_1.add(btnXoa);
										
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
		
		
		
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);	
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);

		refreshTableData();
	}
	public void themData() {
		List<CD> cd = new ArrayList<>();
		DefaultTableModel md = (DefaultTableModel) table_1.getModel();
		for (CD sp : cd) {
			md.addRow(new Object[] { sp.getCdID(), sp.getName(), sp.getQuantity(),sp.getPrice(),sp.isStatus() });
		}
	}
	private void refreshTableData() {
	    List<CD> cds = ProductDAO.instance.getAll();
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    model.setRowCount(0); 
	    for (CD cd : cds) {
	        model.addRow(new Object[]{cd.getCdID(), cd.getName(), cd.getQuantity(), cd.getPrice(), cd.isStatus() ? "Có hàng" : "Không có hàng" });
	    }
	}
	private void themSp() {
	    CD newCD = new CD();
	    newCD.setCdID(txtmaCD.getText());
	    newCD.setName(txtTenSanPham.getText());
	    newCD.setPrice(Double.parseDouble(txtPrice.getText()));
	    boolean status = comboBoxTrangThai.getSelectedIndex() == 0; // Assuming 0 is "Có hàng"
	    newCD.setStatus(status);
	    newCD.setQuantity(Integer.parseInt(txtSoLuong.getText()));
	    ProductDAO.instance.insert(newCD); 
	    refreshTableData(); 
	}
	private void xoaSp() {
	    int selectedRow = table_1.getSelectedRow();
	    if (selectedRow >= 0) {
	        String cdID = (String) table_1.getModel().getValueAt(selectedRow, 0); 
	        CD cd = ProductDAO.instance.findById(cdID);
	        if (cd != null) {
	            ProductDAO.instance.delete(cd);
	            ((DefaultTableModel) table_1.getModel()).removeRow(selectedRow); 
	        } else {
	            JOptionPane.showMessageDialog(this, "Khong tim thay san pham", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Chon san pham de xoa", "No selection", JOptionPane.WARNING_MESSAGE);
	    }
	}
	private void suaSp() {
	    int selectedRow = table_1.getSelectedRow();
	    if (selectedRow >= 0) {
	        String cdID = txtmaCD.getText();  
	        CD suaCD = ProductDAO.instance.findById(cdID);
	        if (suaCD != null) {
	        	suaCD.setCdID(txtmaCD.getText());
	        	suaCD.setName(txtTenSanPham.getText());
	        	suaCD.setPrice(Double.parseDouble(txtPrice.getText()));
	            boolean status = comboBoxTrangThai.getSelectedIndex() == 0;  
	            suaCD.setStatus(status);  
	            suaCD.setQuantity(Integer.parseInt(txtSoLuong.getText()));
	            ProductDAO.instance.update(suaCD);
	            refreshTableData();  
	        } else {
	            JOptionPane.showMessageDialog(this, "Loi", "Update Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Chon san pham de sua", "No selection", JOptionPane.WARNING_MESSAGE);
	    }
	}
	private void xoaRong() {
	    txtmaCD.setText("");
	    txtTenSanPham.setText("");
	    txtPrice.setText("");
	    txtSoLuong.setText("");
	    comboBoxTrangThai.setSelectedIndex(0);

	    // Example: Disable the update button if it should not be usable when fields are empty
	    btnSua.setEnabled(false);
	    // Similarly, you might enable it elsewhere when fields are filled
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			themSp();
		}
		else if ( o.equals(btnXoa)) {
			xoaSp();
		}
		else if ( o.equals(btnSua)) {
			suaSp();
		}
		else if (o.equals(btnXoaRong)){
			xoaRong();
		}
	}

}
