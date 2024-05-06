package view.customer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.CD;
import entities.Customer;
import entities.Person;
import util.clients.CustomerClient;

public class CustomerGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JMenuBar menuBar_main;
	private JMenu menu_shopping;
	private JMenu menu_helloUser;
	private JMenuItem menuItem_myCart;
	private JMenuItem menuItem_findCDs;
	private JMenuItem menuItem_myOrders;
	private JMenuItem menuItem_profile;
	private JMenuItem menuItem_signOut;
	private JMenuItem menuItem_mainPage;
	
	private Socket socket;
	
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private mainPanel mainPanel;
	private findPanel findPanel;
	private CartPanel cartPanel;
	private MyProfilePanel myProfilePanel;
	private OrderPanel myOrdersPanel;
	public static Customer customer;
	
	// This temporary variable represents the current logged in user.
//	public static final String customerID = "khmk8123";
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			private CustomerGui frame;
//
//			public void run() {
//				try {
//					frame = new CustomerGui();
//					frame.setLocationRelativeTo(null);
//					frame.setVisible(true);
//					frame.connect2Server();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public CustomerGui() throws UnknownHostException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 650);

		menuBar_main = new JMenuBar();
		menuBar_main.setBackground(new Color(193, 255, 255));
		menuBar_main.setForeground(new Color(0, 0, 0));
		setJMenuBar(menuBar_main);

		menu_shopping = new JMenu("Shopping");
		menu_shopping.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar_main.add(menu_shopping);
		
		menuItem_mainPage = new JMenuItem("Main Page");
		menu_shopping.add(menuItem_mainPage);

		menuItem_findCDs = new JMenuItem("Find CDs");
		menuItem_findCDs.setIcon(null);
		menuItem_findCDs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_shopping.add(menuItem_findCDs);

		menuItem_myCart = new JMenuItem("My Cart");
		menuItem_myCart.setIcon(null);
		menuItem_myCart.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuItem_myCart.setHorizontalAlignment(SwingConstants.LEFT);
		menu_shopping.add(menuItem_myCart);

		menuItem_myOrders = new JMenuItem("My Orders");
		menu_shopping.add(menuItem_myOrders);

		// Add some rigid space to align Shopping to the right
		menuBar_main.add(Box.createRigidArea(new Dimension(732, 12)));
		
		Socket socket = new Socket("172.28.64.180", 8603);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		
		CustomerGui.customer = (Customer) CustomerClient.establish();

		menu_helloUser = new JMenu("Hello " + CustomerGui.customer.getName() + " !");
		menu_helloUser.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menu_helloUser.setForeground(new Color(0, 128, 192));
		menu_helloUser.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar_main.add(menu_helloUser);

		menuItem_profile = new JMenuItem("My profile");
		menuItem_profile.setIcon(new ImageIcon(
				"D:\\IUH\\6th_semester\\distributed_programming_java\\course_project\\BLT_LTPT\\src\\main\\resources\\images\\profile_icon.png"));
		menuItem_profile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_helloUser.add(menuItem_profile);

		menuItem_signOut = new JMenuItem("Sign out");
		menuItem_signOut.setIcon(new ImageIcon(
				"D:\\IUH\\6th_semester\\distributed_programming_java\\course_project\\BLT_LTPT\\src\\main\\resources\\images\\sign_out_icon.png"));
		menuItem_signOut.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_helloUser.add(menuItem_signOut);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		getContentPane().add(cardPanel);
		
		mainPanel = new mainPanel();
		findPanel = new findPanel();
		cartPanel = new CartPanel();
		myProfilePanel = new MyProfilePanel();
		myOrdersPanel = new OrderPanel();
		
		cardPanel.add(mainPanel, "Main Page");
		cardPanel.add(findPanel, "Find CDs");
		cardPanel.add(cartPanel, "My Cart");
		cardPanel.add(myOrdersPanel, "My Orders");
		cardPanel.add(myProfilePanel, "My profile");
		
		menuItem_mainPage.addActionListener(this);
		menuItem_findCDs.addActionListener(this);
		menuItem_myCart.addActionListener(this);
		menuItem_myOrders.addActionListener(this);
		menuItem_profile.addActionListener(this);
		menuItem_signOut.addActionListener(this);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 0, 50, 0));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the action command (the text of the menu item)
		String command = e.getActionCommand();

		// Use CardLayout to switch between GUI panels based on the menu item clicked
		cardLayout.show(cardPanel, command);
		
		if (command.equals("My Cart")) {
			// Load the selected CDs to the Cart table.
			this.cartPanel.loadCartData(CartPanel.cartCDs);
		}
		else if (command.equals("My Orders")) {
			// Load the orders of the currently logged in customer.
			this.myOrdersPanel.loadOrderTableData();
		}
		else if (command.equals("My profile")) {
			// Load the profile of the currently logged in customer.
			this.myProfilePanel.loadProfileData();
		} 
		else if (command.equals("Find CDs")) {
			// Load the main page.
			List<CD> all = CustomerClient.instance.getAll(CD.class);
			this.findPanel.setTableData(all);
		}
		else if (command.equals("Sign out")) {
			// Log out the current user & release all the resoucres.
			CustomerClient.close();
			System.exit(0);
		}
	}
}
