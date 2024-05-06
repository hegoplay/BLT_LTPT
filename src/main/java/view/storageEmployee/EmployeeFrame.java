package view.storageEmployee;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.PersonType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class EmployeeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlBackground;
	private JPanel pnlContent;
	private JLabel lblTitle;

	private int port = 8603;
	private Socket socket;
	private String serverAddress = "localhost";
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
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
		connectServer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitle = new JLabel("NHÂN VIÊN TỒN KHO");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(10, 0, 1346, 99); // Adjusted width
        contentPane.add(lblTitle);

        
        
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
        panel_1.setBounds(952, 11, 392, 55);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(281, 11, 80, 40);
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
        
        
        
        
        
        pnlContent = new JPanel();
        pnlContent.setBounds(10, 77, 1320, 606);
        contentPane.add(pnlContent);
        pnlContent.setLayout(new CardLayout(0, 0));
        
        pnlBackground = new JPanel();
        pnlBackground.setLayout(new BorderLayout(0, 0));
        pnlContent.add(pnlBackground, "Pnl_Background");
        
        PnlOrderBill pnlOrderBill = new PnlOrderBill(socket, oos, ois);
        pnlContent.add(pnlOrderBill, "Pnl_OrderBill");
		
        PnlConfirmOrder pnlConfirmOrder = new PnlConfirmOrder(socket, oos, ois);
        pnlContent.add(pnlConfirmOrder, "Pnl_ConfirmOrder");
        
        PnlProduct pnlProduct = new PnlProduct();
        pnlContent.add(pnlProduct, "Pnl_Product");
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/img/61xSP8mYRUS.jpg"));
        pnlBackground.add(lblNewLabel_1, BorderLayout.CENTER);
        
        // Set up action listeners
        mntmProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CardLayout cardLayout = (CardLayout) pnlContent.getLayout();
    			cardLayout.show(pnlContent, "Pnl_Product");
    			lblTitle.setText("SẢN PHẨM TỒN KHO");
            	
            }
        });
        
        mntmConfirmOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CardLayout cardLayout = (CardLayout) pnlContent.getLayout();
    			cardLayout.show(pnlContent, "Pnl_ConfirmOrder");
    			lblTitle.setText("Xác Nhận Đơn Hàng");
            }
        });

        mntmReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CardLayout cardLayout = (CardLayout) pnlContent.getLayout();
    			cardLayout.show(pnlContent, "Pnl_OrderBill");
    			lblTitle.setText("IN HÓA ĐƠN");
            }
        });
        
	}
	
	private void connectServer() {
		// TODO Auto-generated method stub
		try {
			socket = new Socket(serverAddress, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(PersonType.STORAGE_EMPLOYEE);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void closeServer() {
		// TODO Auto-generated method stub
		try {
			oos.close();
			ois.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
