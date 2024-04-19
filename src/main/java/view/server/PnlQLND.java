package view.server;

import javax.swing.JPanel;

import util.Constant;
import util.PersonType;
import util.ValidateForm;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import component.PersonTable;
import dao.PersonDAO;
import entities.Account;
import entities.Address;
import entities.Customer;
import entities.Person;
import entities.StatiscalEmployee;
import entities.StorageEmployee;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class PnlQLND extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAccount;
	private JPasswordField password;
	private JTextField txtHouseNo;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTable table;
	private JTextField txtFindById;
	private PersonTable tblPerson;
	private JButton btnFind;
	private JComboBox<PersonType> cmbType;
	private JButton btnRefresh;
	private JButton btnAdd;
	private JButton btnFix;
	private ButtonGroup personType;
	private JRadioButton rdCustomer;
	private JRadioButton rdStorageEmployee;
	private JRadioButton rdStatisticEmployee;
	private JDateChooser registDate;
	private JDateChooser bornDate;
	private JTextField txtEmail;
	private JButton btnDelete;

	
	
	/**
	 * Create the panel.
	 */
	public PnlQLND() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
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
		setLayout(new BorderLayout(20, 0));

		JPanel pnlTTNguoiDung = new JPanel();
		pnlTTNguoiDung.setBorder(new EmptyBorder(20, 5, 0, 5));
		add(pnlTTNguoiDung, BorderLayout.EAST);
//		set color for pnlTTNguoiDung
		pnlTTNguoiDung.setBackground(Constant.CYAN_2);
		GridBagLayout gbl_pnlTTNguoiDung = new GridBagLayout();
		gbl_pnlTTNguoiDung.columnWidths = new int[] { 375 - 230, 230 };
		gbl_pnlTTNguoiDung.rowHeights = new int[] { 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlTTNguoiDung.columnWeights = new double[] { 1.0, 1.0 };
		gbl_pnlTTNguoiDung.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
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
		txtId.setEditable(false);
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
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		pnlTTNguoiDung.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("thmnh113@gmail.com");
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		pnlTTNguoiDung.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		Label lblBornDate = new Label("Ngày sinh");
		lblBornDate.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblBornDate = new GridBagConstraints();
		gbc_lblBornDate.anchor = GridBagConstraints.EAST;
		gbc_lblBornDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBornDate.gridx = 0;
		gbc_lblBornDate.gridy = 5;
		pnlTTNguoiDung.add(lblBornDate, gbc_lblBornDate);

		bornDate = new JDateChooser();
		GridBagConstraints gbc_bornDate = new GridBagConstraints();
		gbc_bornDate.insets = new Insets(0, 0, 5, 0);
		gbc_bornDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_bornDate.gridx = 1;
		gbc_bornDate.gridy = 5;
		pnlTTNguoiDung.add(bornDate, gbc_bornDate);

		JLabel lblAccount = new JLabel("Tài khoản");
		lblAccount.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblAccount = new GridBagConstraints();
		gbc_lblAccount.anchor = GridBagConstraints.EAST;
		gbc_lblAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccount.gridx = 0;
		gbc_lblAccount.gridy = 6;
		pnlTTNguoiDung.add(lblAccount, gbc_lblAccount);

		txtAccount = new JTextField();
		txtAccount.setText("hegoplay");
		txtAccount.setToolTipText("");
		GridBagConstraints gbc_txtAccount = new GridBagConstraints();
		gbc_txtAccount.insets = new Insets(0, 0, 5, 0);
		gbc_txtAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAccount.gridx = 1;
		gbc_txtAccount.gridy = 6;
		pnlTTNguoiDung.add(txtAccount, gbc_txtAccount);
		txtAccount.setColumns(10);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 7;
		pnlTTNguoiDung.add(lblPassword, gbc_lblPassword);

		password = new JPasswordField();
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 0);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 1;
		gbc_password.gridy = 7;
		pnlTTNguoiDung.add(password, gbc_password);

		JLabel lblHouseNo = new JLabel("Số nhà");
		lblHouseNo.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblHouseNo = new GridBagConstraints();
		gbc_lblHouseNo.anchor = GridBagConstraints.EAST;
		gbc_lblHouseNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHouseNo.gridx = 0;
		gbc_lblHouseNo.gridy = 8;
		pnlTTNguoiDung.add(lblHouseNo, gbc_lblHouseNo);

		txtHouseNo = new JTextField();
		txtHouseNo.setText("64/4");
		GridBagConstraints gbc_txtHouseNo = new GridBagConstraints();
		gbc_txtHouseNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtHouseNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHouseNo.gridx = 1;
		gbc_txtHouseNo.gridy = 8;
		pnlTTNguoiDung.add(txtHouseNo, gbc_txtHouseNo);
		txtHouseNo.setColumns(10);

		JLabel lblStreet = new JLabel("Đường");
		lblStreet.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 9;
		pnlTTNguoiDung.add(lblStreet, gbc_lblStreet);

		txtStreet = new JTextField();
		txtStreet.setText("6");
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.insets = new Insets(0, 0, 5, 0);
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.gridx = 1;
		gbc_txtStreet.gridy = 9;
		pnlTTNguoiDung.add(txtStreet, gbc_txtStreet);
		txtStreet.setColumns(10);

		JLabel lblCity = new JLabel("Thành phố");
		lblCity.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 10;
		pnlTTNguoiDung.add(lblCity, gbc_lblCity);

		txtCity = new JTextField();
		txtCity.setText("HCMC");
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 0);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 10;
		pnlTTNguoiDung.add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);

		JLabel lblZipCode = new JLabel("Mã zip");
		lblZipCode.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.EAST;
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode.gridx = 0;
		gbc_lblZipCode.gridy = 11;
		pnlTTNguoiDung.add(lblZipCode, gbc_lblZipCode);

		txtZip = new JTextField();
		txtZip.setText("713000");
		GridBagConstraints gbc_txtZip = new GridBagConstraints();
		gbc_txtZip.insets = new Insets(0, 0, 5,0);
		gbc_txtZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZip.gridx = 1;
		gbc_txtZip.gridy = 11;
		pnlTTNguoiDung.add(txtZip, gbc_txtZip);
		txtZip.setColumns(10);

		JLabel lblRegistDate = new JLabel("Ngày đk");
		lblRegistDate.setFont(Constant.BOLD_22_TITLE);
		GridBagConstraints gbc_lblRegistDate = new GridBagConstraints();
		gbc_lblRegistDate.anchor = GridBagConstraints.EAST;
		gbc_lblRegistDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistDate.gridx = 0;
		gbc_lblRegistDate.gridy = 12;
		pnlTTNguoiDung.add(lblRegistDate, gbc_lblRegistDate);

		registDate = new JDateChooser();
		GridBagConstraints gbc_registDate = new GridBagConstraints();
		gbc_registDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_registDate.insets = new Insets(0, 0, 5, 0);
		gbc_registDate.gridx = 1;
		gbc_registDate.gridy = 12;
		pnlTTNguoiDung.add(registDate, gbc_registDate);

		JPanel pnlType = new JPanel();
		pnlType.setBackground(Constant.CYAN_2);
		GridBagConstraints gbc_pnlType = new GridBagConstraints();
		gbc_pnlType.gridwidth = 2;
		gbc_pnlType.insets = new Insets(0, 0, 5, 0);
		gbc_pnlType.fill = GridBagConstraints.BOTH;
		gbc_pnlType.gridx = 0;
		gbc_pnlType.gridy = 13;
		pnlTTNguoiDung.add(pnlType, gbc_pnlType);
		pnlType.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		rdCustomer = new JRadioButton("Khách hàng");
		rdCustomer.setSelected(true);
		rdCustomer.setFont(Constant.BOLD_16);
		rdCustomer.setBackground(Constant.CYAN_2);
		pnlType.add(rdCustomer);

		rdStorageEmployee = new JRadioButton("NV Tồn kho");
		rdStorageEmployee.setFont(Constant.BOLD_16);
		rdStorageEmployee.setBackground(Constant.CYAN_2);
		pnlType.add(rdStorageEmployee);

		rdStatisticEmployee = new JRadioButton("NV Thống kê");
		rdStatisticEmployee.setFont(Constant.BOLD_16);
		rdStatisticEmployee.setBackground(Constant.CYAN_2);
		pnlType.add(rdStatisticEmployee);

		JPanel pnlOptions = new JPanel();
		pnlOptions.setBackground(Constant.CYAN_2);
		GridBagConstraints gbc_pnlOptions = new GridBagConstraints();
		gbc_pnlOptions.gridwidth = 2;
		gbc_pnlOptions.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlOptions.gridx = 0;
		gbc_pnlOptions.gridy = 14;
		pnlTTNguoiDung.add(pnlOptions, gbc_pnlOptions);

		btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnAdd.setBackground(Constant.CYAN_6);
		btnAdd.setForeground(Color.WHITE);
		pnlOptions.add(btnAdd);

		btnFix = new JButton("Sửa");
		btnFix.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFix.setBackground(Constant.CYAN_6);
		btnFix.setForeground(Color.WHITE);
		pnlOptions.add(btnFix);

		btnRefresh = new JButton("Làm mới");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRefresh.setBackground(Constant.CYAN_6);
		btnRefresh.setForeground(Color.WHITE);
		pnlOptions.add(btnRefresh);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBackground(new Color(16, 96, 141));
		pnlOptions.add(btnDelete);
		
		personType = new ButtonGroup();
		
		personType.add(rdCustomer);
		personType.add(rdStorageEmployee);
		personType.add(rdStatisticEmployee);
		
		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(Constant.CYAN_2);
		pnlTable.setBorder(new TitledBorder(null, "Th\u00F4ng tin ng\u01B0\u1EDDi d\u00F9ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnlTable, BorderLayout.CENTER);
		pnlTable.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBackground(Constant.CYAN_2);
		pnlTable.add(pnlInfo, BorderLayout.NORTH);
		FlowLayout fl_pnlInfo = new FlowLayout();
		fl_pnlInfo.setHgap(10);
		pnlInfo.setLayout(fl_pnlInfo);
		
		Label lblFindById = new Label("Mã người");
		lblFindById.setFont(Constant.BOLD_16);
		pnlInfo.add(lblFindById);
		
		txtFindById = new JTextField();
		txtFindById.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInfo.add(txtFindById);
		txtFindById.setColumns(10);
		
		Label lblType = new Label("Loại người");
		lblType.setFont(Constant.BOLD_16);
		pnlInfo.add(lblType);
		
		cmbType = new JComboBox<PersonType>(PersonType.values()) ;
		cmbType.setFont(Constant.BOLD_16);
		cmbType.setRenderer(new DefaultListCellRenderer() {
			
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub
				value = ((PersonType)value).getValue();
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});
//		cmbType.addItem("Khách hàng");
		pnlInfo.add(cmbType);
		
		btnFind = new JButton("Tìm");
		btnFind.setBackground(Constant.CYAN_6);
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(Constant.BOLD_16);
		pnlInfo.add(btnFind);
		
		JScrollPane srcPerson = new JScrollPane();
		pnlTable.add(srcPerson, BorderLayout.CENTER);
		
		tblPerson = new PersonTable();
		srcPerson.setViewportView(tblPerson);
		
		btnFind.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnAdd.addActionListener(this);
		btnFix.addActionListener(this);
		btnDelete.addActionListener(this);
	
		tblPerson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = tblPerson.getSelectedRow();
				Person p = PersonDAO.instance.findById(tblPerson.getValueAt(row, 0).toString());
				txtId.setText(p.getPersonID());
				txtName.setText(p.getName());
				txtEmail.setText(p.getEmail());
				txtAccount.setText(p.getAccount().getUserName());
				txtHouseNo.setText(p.getAddress().getNumber());
				txtStreet.setText(p.getAddress().getStreet());
				txtCity.setText(p.getAddress().getCity());
				txtZip.setText(p.getAddress().getZip());
				registDate.setDate(Constant.convertToDateViaInstant(p.getRegistDate()));
				bornDate.setDate(Constant.convertToDateViaInstant(p.getDob()));
				if (p instanceof Customer) {
					rdCustomer.setSelected(true);
				} else if (p instanceof StorageEmployee) {
					rdStorageEmployee.setSelected(true);
				} else if (p instanceof StatiscalEmployee) {
					rdStatisticEmployee.setSelected(true);
				}
				
			}
		});
		
		tblPerson.ReloadTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o == btnFind) {
			String id = txtFindById.getText();
			PersonType type = (PersonType) cmbType.getSelectedItem();
			tblPerson.findPerson(id, type);
		}
		if (o == btnRefresh) {
			tblPerson.ReloadTable();
			ResetField();
		}
		if(o == btnAdd) {
			Person p = CreateNewPerson(GetPersonFromField());
			if (p == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				return;
			}
			PersonDAO.instance.insert(p);
			tblPerson.ReloadTable();
		}
		if (o==btnFix){
			if (txtId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng cần sửa");
				return;
			}
			Person temp = PersonDAO.instance.findById(txtId.getText());
			if (temp == null) {
				JOptionPane.showMessageDialog(null, "Người dùng không tồn tại");
				return;
			}
			Person p = GetPersonFromField();
			if (p == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				return;
			}
			
			PersonDAO.instance.update(p);
			tblPerson.ReloadTable();
		}
		if (o == btnDelete) {
			if (txtId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng cần xóa");
				return;
			}
			Person p = PersonDAO.instance.findById(txtId.getText());
			if (p == null) {
				JOptionPane.showMessageDialog(null, "Người dùng không tồn tại");
				return;
			}
			PersonDAO.instance.delete(p);
			tblPerson.ReloadTable();
		}
		
	}

	private Person CreateNewPerson(Person p) {
		if (p == null) {
			return null;
		}
		String personId = "";
		if(rdCustomer.isSelected()) {
			personId += "KH";
		}
		else if (rdStorageEmployee.isSelected()) {
			personId += "NVKH";
		} else if (rdStatisticEmployee.isSelected()) {
			personId += "NVTK";
		}
		String[] nameArr = txtName.getText().split(" ");
		for (String s : nameArr) {
			personId += Character.toUpperCase(s.charAt(0));
		}
		
		personId += Constant.convertToLocalDateViaInstant(registDate.getDate()).getDayOfYear();
		personId += Constant.convertToLocalDateViaInstant(registDate.getDate()).getMonthValue();
		personId += LocalDateTime.now().getHour();
		personId += LocalDateTime.now().getMinute();
		p.setPersonID(personId);
		return p;
	}
	
	private Person GetPersonFromField() {
		// TODO Auto-generated method stub
		Person currentPerson = null;
		if ( txtName.getText().isEmpty() || ValidateForm.isEmail(txtEmail.getText()) == false
				|| txtAccount.getText().isEmpty() || txtHouseNo.getText().isEmpty()
				|| txtStreet.getText().isEmpty() || txtCity.getText().isEmpty() || ValidateForm.isZipCode(txtZip.getText()) == false
				|| bornDate.getDate() == null) {
			return null;
		}
		if (registDate == null) {
			registDate.setDate(Constant.convertToDateViaInstant(LocalDate.now()));
		}
		if(rdCustomer.isSelected()) {
			currentPerson = new Customer();
		}
		else if (rdStorageEmployee.isSelected()) {
			currentPerson = new StorageEmployee();
		} else if (rdStatisticEmployee.isSelected()){
			currentPerson = new StatiscalEmployee();
		}
		
		currentPerson.setPersonID(txtId.getText());
		currentPerson.setName(txtName.getText());
		currentPerson.setDob(Constant.convertToLocalDateViaInstant(bornDate.getDate()));
		currentPerson.setEmail(txtEmail.getText());
		Account account = new Account();
		account.setUserName(txtAccount.getText());
		currentPerson.setAccount(account);
		String pass = new String(this.password.getPassword());
		if(password.getPassword().length > 0) {
			pass = DigestUtils.sha1Hex(pass);
		}
		else if (PersonDAO.instance.findById(currentPerson.getPersonID()) == null) {
			JOptionPane.showMessageDialog(null, "");
			return null;
			
		}
		else {
			pass = PersonDAO.instance.findById(txtId.getText()).getAccount().getPassword();
		}
		account.setPassword(pass);
		Address address = new Address();
		address.setCity(txtCity.getText());
		address.setNumber(txtHouseNo.getText());
		address.setStreet(txtStreet.getText());
		address.setZip(txtZip.getText());
		currentPerson.setAddress(address);
		currentPerson.setRegistDate(Constant.convertToLocalDateViaInstant(registDate.getDate()));
//		p.setAccount(txtAccount.getText());
		return currentPerson;
	}

	private void ResetField() {
		txtId.setText("");
		txtName.setText("");
		txtAccount.setText("");
		password.setText("");
		txtHouseNo.setText("");
		txtStreet.setText("");
		txtCity.setText("");
		txtZip.setText("");
		cmbType.setSelectedIndex(0);
		txtEmail.setText("");
		bornDate.setDate(null);
		registDate.setDate(null);
	}
	
}
