package component;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import util.Constant;

public class PersonTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2618323511598607663L;
	private static final String[] COLUMN_NAMES = {"mã", "tên người dùng","email","tài khoản","loại người dùng"};
	
	private static final int 
	id = 1 << 0,
	name = 1 << 1,
	email = 1 << 2,
	account = 1 << 3,
	type = 1 << 4;
	
	private TableModel model;
	
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
	
}

