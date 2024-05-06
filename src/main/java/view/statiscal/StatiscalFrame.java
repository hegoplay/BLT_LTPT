package view.statiscal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;

public class StatiscalFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel pnlMain;
	private JMenuItem mntnTKDT;
	private JMenuItem mntmTKSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatiscalFrame frame = new StatiscalFrame();
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
	public StatiscalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlMain);
		pnlMain.setLayout(new CardLayout(0, 0));
		
		PnlDoanhThuCuaHang pnlDTCH = new PnlDoanhThuCuaHang();
		pnlMain.add(pnlDTCH, "DTCH");
		
		PnlSanPhamTheoThang pnlDTSP = new PnlSanPhamTheoThang();
		pnlMain.add(pnlDTSP, "DTSP");
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnDoanhThu = new JMenu("Doanh Thu");
		menuBar.add(mnDoanhThu);
		
		mntnTKDT = new JMenuItem("Thống kê doanh thu");
		mnDoanhThu.add(mntnTKDT);
		
		JMenu mnSanPham = new JMenu("Sản Phẩm");
		menuBar.add(mnSanPham);
		
		mntmTKSP = new JMenuItem("Thống kê sản phẩm");
		mnSanPham.add(mntmTKSP);
		
		mntnTKDT.addActionListener(this);
		mntmTKSP.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(mntnTKDT)) {
			CardLayout cl = (CardLayout) pnlMain.getLayout();
			cl.show(pnlMain, "DTCH");
		} else if (o.equals(mntmTKSP)) {
			CardLayout cl = (CardLayout) pnlMain.getLayout();
			cl.show(pnlMain, "DTSP");
		}
	}

}
