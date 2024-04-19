package view.server;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Constant;

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

	/**
	 * Launch the application.
	 */
	static void Test(int x) {
		x++;
	}
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
		
		mntmAllLog = new JMenuItem("Log");
		mntmAllLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mnCheckLog.add(mntmAllLog);
		mntmAllLog.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Constant.BACKGROUND_COLOR);
		

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		PnlQLND pnlQLND = new PnlQLND();
		contentPane.add(pnlQLND, "QLND");
		PnlLog pnlLog = new PnlLog();
		contentPane.add(pnlLog, "LOG");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmQLND) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.show(contentPane, "QLND");
		}
		else if (e.getSource()==mntmAllLog) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.show(contentPane, "LOG");
		}
	}
	
	

}
