package view.customer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class mainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public mainPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CD SHOP SAVAGE BOYS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(383, 23, 315, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTACT INFORMATION :");
		lblNewLabel_1.setBounds(28, 460, 327, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address : 12 Nguyen Van Bao, ward 4, Go Vap, Saigon");
		lblNewLabel_2.setBounds(28, 485, 327, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone : 0909123456");
		lblNewLabel_3.setBounds(28, 510, 327, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email : savageboyCD@gmail.com");
		lblNewLabel_4.setBounds(28, 535, 327, 19);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("src\\main\\resources\\images\\CD_store.jpg"));
		lblNewLabel_5.setBounds(67, 68, 940, 368);
		add(lblNewLabel_5);

	}

}
