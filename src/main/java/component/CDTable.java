package component;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entities.CD;
import entities.OrderDetail;

public class CDTable extends JTable {
/**
	 * 
	 */
	private static final long serialVersionUID = -2889426248835663159L;

private static final String[] COLUMN_NAMES = {"mã", "tên đĩa","số lượng","giá","Trạng thái"};
	
	private final int 
	id = 0,
	name = 1,
	quantity = 2,
	price = 3,
	isValid = 4;
	
	private TableModel model;
	
	public CDTable() {
		model = new DefaultTableModel(COLUMN_NAMES, 0) {

			
			/**
			 * 
			 */
			private static final long serialVersionUID = 699067730092345263L;
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == quantity) {
					return Integer.class;
				}
				if (columnIndex == price) {
					return Double.class;
				}
				if (columnIndex == isValid) {
					return Boolean.class;
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
	public void ReloadTable(List<CD> list) {
		((DefaultTableModel) model).setRowCount(0);
		
		for (CD cd : list) {
			((DefaultTableModel) model)
			.addRow(new Object[] { cd.getCdID(),cd.getName(), 
                    cd.getQuantity(), cd.getPrice(),cd.isStatus()});
		}
	}
}
