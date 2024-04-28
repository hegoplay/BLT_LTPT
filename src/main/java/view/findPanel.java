package view;

import entities.CD;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class findPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField_cdName;
	private JTable table;
	private JComboBox<String> comboBox_priceFilter;
	private JButton btn_find;
	private JButton btn_addToCart;

	/**
	 * Create the panel.
	 */
	public findPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CD's name :");
		lblNewLabel.setBounds(138, 78, 70, 14);
		add(lblNewLabel);

		textField_cdName = new JTextField();
		textField_cdName.setColumns(10);
		textField_cdName.setBounds(218, 75, 455, 20);
		add(textField_cdName);

		comboBox_priceFilter = new JComboBox<String>();
		comboBox_priceFilter.setModel(new DefaultComboBoxModel<String>(new String[] {"Ascending", "Descending"}));
		comboBox_priceFilter.setBounds(800, 74, 116, 22);
		this.add(comboBox_priceFilter);

		JLabel lblNewLabel_1 = new JLabel("Filter by price");
		lblNewLabel_1.setBounds(720, 78, 84, 14);
		add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 148, 925, 303);
		this.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "CD id", "CD name", "Price", "Status" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("RESULT :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(71, 122, 84, 14);
		add(lblNewLabel_2);

		btn_find = new JButton("Find");
		btn_find.setBounds(280, 480, 143, 53);
		add(btn_find);

		btn_addToCart = new JButton("Add to cart");
		btn_addToCart.setBounds(608, 480, 143, 53);
		add(btn_addToCart);

		JLabel lblNewLabel_3 = new JLabel("FIND CDs");
		lblNewLabel_3.setBounds(503, 29, 70, 14);
		add(lblNewLabel_3);
		
		btn_find.addActionListener(this);
		btn_addToCart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Find")) {
			System.out.println("Find button clicked");
			
			String cdName = textField_cdName.getText();
			String priceFilter = comboBox_priceFilter.getSelectedItem().toString();
			setTableData(getFoundCDs(cdName, priceFilter));
			
		} else if (command.equals("Add to cart")) {
			
			System.out.println("Add to cart button clicked");
		}
	}
	
	
	// (Need to be implemented) Method to get list of CDs with provided CD name and price criterion. 
	public List<CD> getFoundCDs(String cdName, String priceFilter) {
		List<CD> result = new ArrayList<>();
		
		// Use ProductDAO to get result.
		
		return result;
	}
	
	// Method to set data for the table.
	public void setTableData(List<CD> cds) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (CD cd : cds) {
			model.addRow(new Object[] { cd.getCdID(), cd.getName(), cd.getPrice(), cd.isStatus() });
		}
	}

}
