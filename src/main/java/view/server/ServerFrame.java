package view.server;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Constant;
import view.statiscal.PnlDoanhThuCuaHang;
import view.statiscal.PnlSanPhamTheoThang;

import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;



/**
 * @author hegoplay
 */
public class ServerFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnQuanLy;
	private JMenuItem mntmQLND;
	private JMenu mnCheckLog;
	private JMenuItem mntmAllLog;
	private JMenu mnThongKe;
	private JMenuItem mntmDoanhThu;
	private JMenuItem mntmSanPhamTheoThang;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		int x = 0;
//		System.out.println(x);
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		
		JMenuBar mnbServer = new JMenuBar();
		setJMenuBar(mnbServer);
		
		mnQuanLy = new JMenu("Quản lý");
		mnbServer.add(mnQuanLy);
		
		mntmQLND = new JMenuItem("Quản lý người dùng");
		mntmQLND.setIcon(new ImageIcon(new File("src/main/resources/img/user_icon.png").getAbsolutePath()));
		mntmQLND.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
		mntmQLND.addActionListener(this);
		mnQuanLy.add(mntmQLND);
		
		mnCheckLog = new JMenu("Dòng sự kiện");
		mnbServer.add(mnCheckLog);
		
		//Thống kê
		mnThongKe = new JMenu ("Thống kê");
		mnbServer.add(mnThongKe);
		
		mntmDoanhThu = new JMenuItem("Doanh thu cửa hàng");
		mntmDoanhThu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		mntmDoanhThu.addActionListener(this);
		mnThongKe.add(mntmDoanhThu);

		mntmSanPhamTheoThang = new JMenuItem("Sản phẩm theo tháng");
		mntmSanPhamTheoThang.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmSanPhamTheoThang.addActionListener(this);
		mnThongKe.add(mntmSanPhamTheoThang);
		
		
		mntmAllLog = new JMenuItem("Log");
		mntmAllLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mnCheckLog.add(mntmAllLog);
		mntmAllLog.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Constant.BACKGROUND_COLOR);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentPane);
		SetContentPane();
		
	}

	private void SetContentPane() {
		contentPane.setLayout(new CardLayout(0, 0));
		PnlQLND pnlQLND = new PnlQLND();
		contentPane.add(pnlQLND, "QLND");
		PnlServerLog pnlLog = new PnlServerLog();
		contentPane.add(pnlLog, "LOG");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == mntmQLND) {
	        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "QLND");
	    } else if (e.getSource() == mntmAllLog) {
	        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "LOG");
	    } else if (e.getSource() == mntmDoanhThu) {
	        // Show the "Doanh thu cửa hàng" panel
	        PnlDoanhThuCuaHang doanhThuPanel = new PnlDoanhThuCuaHang();
	        contentPane.add(doanhThuPanel, "DOANH_THU");
	        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "DOANH_THU");
	    } else if (e.getSource() == mntmSanPhamTheoThang) {
	        // Show the "Thống kê sản phẩm theo tháng" panel
	        PnlSanPhamTheoThang sanPhamPanel = new PnlSanPhamTheoThang();
	        contentPane.add(sanPhamPanel, "SAN_PHAM_THEO_THANG");
	        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "SAN_PHAM_THEO_THANG");
	    }
	}


	

}
