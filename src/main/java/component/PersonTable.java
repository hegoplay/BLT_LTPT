package component;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.PersonDAO;
import entities.Customer;
import entities.Person;
import entities.StatiscalEmployee;
import entities.StorageEmployee;
import util.Constant;
import util.PersonType;



/**
 * @Author: hegoplay
 * This class is a custom JTable to display the list of persons
 */
public class PersonTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2618323511598607663L;
	private static final String[] COLUMN_NAMES = {"mã", "tên người dùng","email","tài khoản","loại người dùng"};
	
	private final int 
	id = 0,
	name = 1,
	email = 2,
	account = 3,
	type = 4;
	
	private TableModel model;
	private TableRowSorter<DefaultTableModel> sorter;
	
	public PersonTable() {
		model = new DefaultTableModel(COLUMN_NAMES, 0) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -2462779278108489448L;
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return String.class;
			}
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(this.type, SortOrder.ASCENDING));
		
	}
	@Override
	public void setDefaultRenderer(Class<?> columnClass, TableCellRenderer renderer) {
		
		renderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 5537752880318049510L;

			/**
			 * 
			 */
			

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground((row % 2) == 0 ? Constant.CYAN_1 : Constant.CYAN_3);
//				c.setFont(Constant.BOLD_16);
				return c;
			}
		};
		// TODO Auto-generated method stub
		super.setDefaultRenderer(columnClass, renderer);
	}
	
//	Hàm này dùng để tìm kiếm người dùng theo id và type
	public void findPerson(String id, PersonType type) {
//		write a method to find a person by id and type in jtable first column
		if (type == PersonType.NONE || type == null) {
			for (int i = 0; i < model.getRowCount(); i++) {
				if (model.getValueAt(i, this.id).equals(id)) {
					this.setRowSelectionInterval(i, i);
					return;
				}
			}
			
		}
		if(id == null || id.equals("") && type != null && type != PersonType.NONE) {
			for (int i = 0; i < model.getRowCount(); i++) {
				if (model.getValueAt(i, this.type).equals(type.getValue())) {
					for (int j = i+1; j < model.getRowCount(); j++) {
						if (!model.getValueAt(j, this.type).equals(type.getValue())) {
							this.setRowSelectionInterval(i, j-1);
							return;
						}
					}
					this.setRowSelectionInterval(i, model.getRowCount()-1);
					return;
				}
			}
		}
			
		else {
			for (int i = 0; i < model.getRowCount(); i++) {
				if (model.getValueAt(i, this.id).equals(id) && model.getValueAt(i,this.type).equals(type.toString())) {
					this.setRowSelectionInterval(i, i);
					return;
				}
				
			}
		}
	}

	
//	Hàm này dùng để load dữ liệu từ database lên bảng
	public void ReloadTable() {
		((DefaultTableModel) model).setRowCount(0);
		List<Person> list = PersonDAO.instance.getAll();
		for (Person p : list) {
			PersonType type = PersonType.NONE;
			if(p instanceof Customer) {
				type = PersonType.CUSTOMER;
			}
			else if(p instanceof StatiscalEmployee) {
				type = PersonType.STATISCAL_EMPLOYEE;
			}
			else if (p instanceof StorageEmployee) {
				type = PersonType.STORAGE_EMPLOYEE;
			}
	
			((DefaultTableModel) model)
				.addRow(new Object[] { p.getPersonID(), p.getName(), p.getEmail(), p.getAccount().getUserName(), type.getValue() });
		}
	}
	
	
	
}

