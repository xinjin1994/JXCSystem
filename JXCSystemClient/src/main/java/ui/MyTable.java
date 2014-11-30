package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
/*
 * 实现table初始化，内容添加，删除，显示，查找等操作
 */
public class MyTable extends JTable{
	JPanel backPanel;
	static JPanel tablePanel;
	static JScrollPane tableSp ;
	static JTable table;
	DefaultTableModel tableModel;
	Vector columnNames, rowData;
	static DefaultTableCellRenderer render;
	
	Color headerColor = new Color(239,140,142);
	Color evenColor = new Color(237,237,237);
	Color oddColor = new Color(245,190,185);
	Color fontColor = new Color(159,122,116);
	
	public MyTable(JPanel backPanel){
		
		this.backPanel = backPanel;
		setPanel();
	}
	
	/*
	 * 初始化panel
	 */
	private  void setPanel() {
		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBounds(350, 75,450 ,525);
		tablePanel.removeAll();
		tablePanel.setOpaque(false);
		tablePanel.setVisible(true);
		backPanel.add(tablePanel);
		
	}
	
	/*
	 * 初始化table
	 */
	public void setTable(ArrayList<String> info){
		render = new DefaultTableCellRenderer();
		transInformation(info);
		
		tableModel = new DefaultTableModel(rowData,columnNames);
		table = new JTable(tableModel);
		//setHeader();
		//table.setBounds(55, 35, 350, 410);
		table.setShowGrid(false);//不显示边框
		table.setEnabled(false);
		
		makeFace(table);
		table.setOpaque(false);// 现将table设置为透明
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
//		table.setRowHeight(25);//第一行行高
//		table.setRowHeight(0,30);//其余行高
	
		render.setOpaque(false);// 将渲染器设置为透明
		table.setDefaultRenderer(Object.class, render);

		
		tableSp = new JScrollPane(table);
		tableSp.setBounds(55,35,350,410);
		
		tableSp.setBorder(new LineBorder(Color.gray));
		tableSp.getViewport().setOpaque(false);
		tableSp.setOpaque(false);
		tableSp.setViewportView(table);
		table.setFillsViewportHeight(true);
		tablePanel.add(tableSp);
		
//		tablePanel.add(table);
		
//		tablePanel.updateUI();
	}
	
	/*
	 * 设置表头，方法未用，可能以后会改==
	 */
	private void setHeader() {
		tableHeader = table.getTableHeader();
		tableHeader.setResizingAllowed(true);
		tableHeader.setOpaque(false);
		tableHeader.setBackground(headerColor);
		tableHeader.setForeground(Color.white);
	}
	/*
	 * 解析初始传进的数据
	 */
	private void transInformation(ArrayList<String> info) {
	
		columnNames = new Vector();
		String[] columnNameString = info.get(0).split(";");//表头

		for (int i = 0; i < columnNameString.length; i++) {
			columnNames.add(columnNameString[i]);
		}
		rowData = new Vector();
		for (int i = 1; i < info.size(); i++) {
			Vector dVector = new Vector();
			dVector.clear();
			String[] rowStrings = info.get(i).split(";");
			for (int j = 0; j < rowStrings.length; j++) {
				dVector.add(rowStrings[j]);
			}
			rowData.add(dVector);
		}
	}
	/*
	 * 渲染器
	 */
	private void makeFace(JTable table) {

	    try {
	      DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table,
	            Object value, boolean isSelected, boolean hasFocus,
	            int row, int column) {
//        	
//	        	if(row == 0){
//	        		setBackground(headerColor);
//	        		setForeground(Color.white);
//	        	}
	        	if(isSelected){
	        		setSelectionBackground(Color.white);
	        		setForeground(Color.red);
	        		System.out.println("kkk");
	        	}
	        	else{
	        		if (row% 2 == 0){
	        			setBackground(oddColor); //设置奇数行底色
	        			setForeground(fontColor);
	        			setSelectionBackground(oddColor);
	        		}
	        		else if (row % 2 == 1){
	        			setBackground(evenColor); 
	        			setForeground(fontColor);//设置偶数行底色
	        			setSelectionBackground(evenColor);
	        		}
	        	}

	          return super.getTableCellRendererComponent(table, value,
	              isSelected, hasFocus, row, column);
	        }
	      };
	      for (int i = 0; i < table.getColumnCount(); i++) {
	        table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
	      }
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }

	  }

	/*
	 * 添加一行，自动添至末尾
	 */
	public void add(String info){
		Vector addInfo = new Vector();
		addInfo.clear();
		String[] addRow = info.split(";");
		for(int i = 0;i < addRow.length;i++){
			System.out.println(addRow[i]);
			addInfo.add(addRow[i]);
			System.out.println(addInfo.get(i));
		}
		System.out.println(addInfo.get(0));
		tableModel.addRow(addInfo);
	}
	/*
	 * 删除行，参数为行数
	 */
	public void del(int loc){
		tableModel.removeRow(loc);
	}
	/*
	 * 查找行，参数为开始行数，结束行数
	 */
	public void find(int loc1,int loc2){
		Color selectColor = new Color(1,1,1,50);
		
		table.setRowSelectionInterval(loc1,loc2);
		table.setSelectionBackground(selectColor);
		table.setSelectionForeground(new Color(30,30,30));
		}

	
}
