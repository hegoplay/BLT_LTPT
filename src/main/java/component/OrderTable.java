package component;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import dao.PersonDAO;
import entities.Customer;
import entities.Order;
import entities.Person;
import entities.StatiscalEmployee;
import entities.StorageEmployee;
import util.Constant;
import util.PersonType;



/**
 * @Author: hegoplay
 * This class is a custom JTable to display the list of persons
 */
public class OrderTable extends JTable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 7958171193332637790L;
	private static final String[] COLUMN_NAMES = {"mã", "tên khách hàng","ngày gửi","tổng tiền"};
	
	private final int 
	id = 0,
	name = 1,
	date = 2,
	total = 3;
	
	private TableModel model;
	
	
	public OrderTable() {
		model = new DefaultTableModel(COLUMN_NAMES, 0) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -2462779278108489448L;
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == total) {
					return Double.class;
				}
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
		
	}
	
	

	/**
	 * This method is used to reload the table
	 * need to update this to Socket method
	 */
	public void ReloadTable(List<Order> list) {
		((DefaultTableModel) model).setRowCount(0);
		
		for (Order o : list) {
			((DefaultTableModel) model)
			.addRow(new Object[] { o.getOrderId(), o.getCustomer().getName(), 
					o.getCreatedDate().toString(), o.getTotal() });
		}
	}

	
	
	
	
}

