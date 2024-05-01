package view.storageEmployee;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class EmployeeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("NHÂN VIÊN TỒN KHO");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 0, 1346, 99); // Adjusted width
        contentPane.add(lblNewLabel);

        
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 32, 200, 34); 
        contentPane.add(panel);
        panel.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 200, 34); 
        panel.add(menuBar);

        JMenu mnNewMenu = new JMenu("Tác Vụ");
        mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
        menuBar.add(mnNewMenu);
        mnNewMenu.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));  

        JMenuItem mntmProduct = new JMenuItem("Quản lý Sản Phẩm");
        mnNewMenu.add(mntmProduct);

        JMenuItem mntmConfirmOrder = new JMenuItem("Xác Nhận Đơn");
        mnNewMenu.add(mntmConfirmOrder);

        JMenuItem mntmReport = new JMenuItem("In Đơn Hàng");
        mnNewMenu.add(mntmReport);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(952, 11, 392, 72);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(281, 11, 80, 50);
        panel_1.add(menuBar_1);

        JMenu quanLy = new JMenu("Người dùng");
        menuBar_1.add(quanLy);

        JMenuItem info = new JMenuItem("Thông Tin");
        quanLy.add(info);

        JMenuItem thoat = new JMenuItem("Thoát");
        quanLy.add(thoat);

        JLabel lblUser = new JLabel("User");
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        lblUser.setBounds(0, 0, 283, 72);
        panel_1.add(lblUser);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/img/61xSP8mYRUS.jpg"));
        lblNewLabel_1.setBounds(10, 101, 1334, 621);
        contentPane.add(lblNewLabel_1);
        
        // Set up action listeners
        mntmProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                product pd = new product();
                pd.setVisible(true);
                dispose();
            }
        });
        
        mntmConfirmOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ConfirmOrder co = new ConfirmOrder();
               co.setVisible(true);
               dispose();
            }
        });

        mntmReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               OrderBill ob = new OrderBill();
               ob.setVisible(true);
               dispose();
            }
        });
        
	}
}
