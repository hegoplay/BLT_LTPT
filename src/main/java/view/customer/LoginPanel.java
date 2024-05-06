package view.customer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CD SHOP APPLICATION FOR CUSTOMER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(261, 24, 620, 67);
		add(lblNewLabel);

	}

}
