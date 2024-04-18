package view.server;

import javax.swing.JPanel;

import util.Constant;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;

public class PnlQLND extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAccount;
	private JPasswordField password;
	private JTextField txtHouseNo;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtZip;

	/**
	 * Create the panel.
	 */
	public PnlQLND() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		class GridData {
			public int x;
			public int y;
			public int maxWidth;

			public GridData(int maxWidth) {
				x = 0;
				y = 0;
				this.maxWidth = maxWidth;
			}

			public void UpdateData(final int val) {
				y += val;
				if (y >= maxWidth) {
					y = 0;
					x++;
				}
			}
		}
//		set jpanel color
		setBackground(Constant.BACKGROUND_COLOR);
//		set layout borderlayout
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTTNguoiDung = new JPanel();
		pnlTTNguoiDung.setBorder(new EmptyBorder(20, 5, 0, 5));
		add(pnlTTNguoiDung, BorderLayout.EAST);
//		set color for pnlTTNguoiDung
		pnlTTNguoiDung.setBackground(Constant.CYAN_2);
		GridBagLayout gbl_pnlTTNguoiDung = new GridBagLayout();
		gbl_pnlTTNguoiDung.columnWidths = new int[] { 375 - 230, 230 };
		gbl_pnlTTNguoiDung.rowHeights = new int[] { 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlTTNguoiDung.columnWeights = new double[] { 1.0, 1.0 };
		gbl_pnlTTNguoiDung.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		pnlTTNguoiDung.setLayout(gbl_pnlTTNguoiDung);

		GridData gridData = new GridData(gbl_pnlTTNguoiDung.columnWidths.length);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new File("src/main/resources/img/XL_user_icon.png").getAbsolutePath()));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pnlTTNguoiDung.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblTitle = new JLabel("Người dùng");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		pnlTTNguoiDung.add(lblTitle, gbc_lblTitle);

		JLabel lblId = new JLabel("Mã người ");
		lblId.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		pnlTTNguoiDung.add(lblId, gbc_lblId);

		txtId = new JTextField();
		txtId.setText("KHPTM015");
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 2;
		pnlTTNguoiDung.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblName = new JLabel("Tên");
		lblName.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		pnlTTNguoiDung.add(lblName, gbc_lblName);

		txtName = new JTextField();
		lblName.setLabelFor(txtName);
		txtName.setText("Phạm Thế Mạnh");
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 3;
		pnlTTNguoiDung.add(txtName, gbc_txtName);
		txtName.setColumns(10);

		Label lblBornDate = new Label("Ngày sinh");
		lblBornDate.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblBornDate = new GridBagConstraints();
		gbc_lblBornDate.anchor = GridBagConstraints.EAST;
		gbc_lblBornDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBornDate.gridx = 0;
		gbc_lblBornDate.gridy = 4;
		pnlTTNguoiDung.add(lblBornDate, gbc_lblBornDate);

		JDateChooser bornDate = new JDateChooser();
		GridBagConstraints gbc_bornDate = new GridBagConstraints();
		gbc_bornDate.insets = new Insets(0, 0, 5, 0);
		gbc_bornDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_bornDate.gridx = 1;
		gbc_bornDate.gridy = 4;
		pnlTTNguoiDung.add(bornDate, gbc_bornDate);

		JLabel lblAccount = new JLabel("Tài khoản");
		lblAccount.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblAccount = new GridBagConstraints();
		gbc_lblAccount.anchor = GridBagConstraints.EAST;
		gbc_lblAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccount.gridx = 0;
		gbc_lblAccount.gridy = 5;
		pnlTTNguoiDung.add(lblAccount, gbc_lblAccount);

		txtAccount = new JTextField();
		GridBagConstraints gbc_txtAccount = new GridBagConstraints();
		gbc_txtAccount.insets = new Insets(0, 0, 5, 0);
		gbc_txtAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAccount.gridx = 1;
		gbc_txtAccount.gridy = 5;
		pnlTTNguoiDung.add(txtAccount, gbc_txtAccount);
		txtAccount.setColumns(10);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 6;
		pnlTTNguoiDung.add(lblPassword, gbc_lblPassword);

		password = new JPasswordField();
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 0);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 1;
		gbc_password.gridy = 6;
		pnlTTNguoiDung.add(password, gbc_password);

		JLabel lblHouseNo = new JLabel("Số nhà");
		lblHouseNo.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblHouseNo = new GridBagConstraints();
		gbc_lblHouseNo.anchor = GridBagConstraints.EAST;
		gbc_lblHouseNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHouseNo.gridx = 0;
		gbc_lblHouseNo.gridy = 7;
		pnlTTNguoiDung.add(lblHouseNo, gbc_lblHouseNo);

		txtHouseNo = new JTextField();
		GridBagConstraints gbc_txtHouseNo = new GridBagConstraints();
		gbc_txtHouseNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtHouseNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHouseNo.gridx = 1;
		gbc_txtHouseNo.gridy = 7;
		pnlTTNguoiDung.add(txtHouseNo, gbc_txtHouseNo);
		txtHouseNo.setColumns(10);

		JLabel lblStreet = new JLabel("Đường");
		lblStreet.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 8;
		pnlTTNguoiDung.add(lblStreet, gbc_lblStreet);

		txtStreet = new JTextField();
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.insets = new Insets(0, 0, 5, 0);
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.gridx = 1;
		gbc_txtStreet.gridy = 8;
		pnlTTNguoiDung.add(txtStreet, gbc_txtStreet);
		txtStreet.setColumns(10);

		JLabel lblCity = new JLabel("Thành phố");
		lblCity.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 9;
		pnlTTNguoiDung.add(lblCity, gbc_lblCity);

		txtCity = new JTextField();
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 0);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 9;
		pnlTTNguoiDung.add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);

		JLabel lblZipCode = new JLabel("Mã zip");
		lblZipCode.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.EAST;
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode.gridx = 0;
		gbc_lblZipCode.gridy = 10;
		pnlTTNguoiDung.add(lblZipCode, gbc_lblZipCode);

		txtZip = new JTextField();
		GridBagConstraints gbc_txtZip = new GridBagConstraints();
		gbc_txtZip.insets = new Insets(0, 0, 5,0);
		gbc_txtZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZip.gridx = 1;
		gbc_txtZip.gridy = 10;
		pnlTTNguoiDung.add(txtZip, gbc_txtZip);
		txtZip.setColumns(10);

		JLabel lblRegistDate = new JLabel("Ngày đk");
		lblRegistDate.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblRegistDate = new GridBagConstraints();
		gbc_lblRegistDate.anchor = GridBagConstraints.EAST;
		gbc_lblRegistDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistDate.gridx = 0;
		gbc_lblRegistDate.gridy = 11;
		pnlTTNguoiDung.add(lblRegistDate, gbc_lblRegistDate);

		JDateChooser registDate = new JDateChooser();
		GridBagConstraints gbc_registDate = new GridBagConstraints();
		gbc_registDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_registDate.insets = new Insets(0, 0, 5, 0);
		gbc_registDate.gridx = 1;
		gbc_registDate.gridy = 11;
		pnlTTNguoiDung.add(registDate, gbc_registDate);

		JPanel pnlType = new JPanel();
		pnlType.setBackground(Constant.CYAN_2);
		GridBagConstraints gbc_pnlType = new GridBagConstraints();
		gbc_pnlType.gridwidth = 2;
		gbc_pnlType.insets = new Insets(0, 0, 5, 5);
		gbc_pnlType.fill = GridBagConstraints.BOTH;
		gbc_pnlType.gridx = 0;
		gbc_pnlType.gridy = 12;
		pnlTTNguoiDung.add(pnlType, gbc_pnlType);
		pnlType.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton rdCustomer = new JRadioButton("Khách hàng");
		rdCustomer.setBackground(Constant.CYAN_2);
		pnlType.add(rdCustomer);

		JRadioButton rdStorageEmployee = new JRadioButton("NV Tồn kho");
		rdStorageEmployee.setBackground(Constant.CYAN_2);
		pnlType.add(rdStorageEmployee);

		JRadioButton rdStatisticEmployee = new JRadioButton("NV Thống kê");
		rdStatisticEmployee.setBackground(Constant.CYAN_2);
		pnlType.add(rdStatisticEmployee);

		JPanel pnlOptions = new JPanel();
		pnlOptions.setBackground(Constant.CYAN_2);
		GridBagConstraints gbc_pnlOptions = new GridBagConstraints();
		gbc_pnlOptions.gridwidth = 2;
		gbc_pnlOptions.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlOptions.gridx = 0;
		gbc_pnlOptions.gridy = 13;
		pnlTTNguoiDung.add(pnlOptions, gbc_pnlOptions);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnAdd.setBackground(Constant.CYAN_6);
		btnAdd.setForeground(Color.WHITE);
		pnlOptions.add(btnAdd);

		JButton btnFix = new JButton("Sửa");
		btnFix.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFix.setBackground(Constant.CYAN_6);
		btnFix.setForeground(Color.WHITE);
		pnlOptions.add(btnFix);

		JButton btnRefresh = new JButton("Làm mới");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRefresh.setBackground(Constant.CYAN_6);
		btnRefresh.setForeground(Color.WHITE);
		pnlOptions.add(btnRefresh);
		
		ButtonGroup personType = new ButtonGroup();
		
		personType.add(rdCustomer);
		personType.add(rdStorageEmployee);
		personType.add(rdStatisticEmployee);

	}

}
