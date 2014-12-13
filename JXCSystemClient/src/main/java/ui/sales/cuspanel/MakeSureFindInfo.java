package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.Button.MyButton;

public class MakeSureFindInfo extends FatherPanel{

	private FindCusPanel findCusPanel;
	private MyButton forward;
	private MyFrame frame;
	private MyTable table;
	private String info;
	private MyTable showTable; 
	private ColorFactory colors = new ColorFactory();
	ArrayList<String> infoArray = new ArrayList<String>();
	private SalesUIController salesUIController;
	
	public MakeSureFindInfo(MyFrame frame,String url,UIController controller,FindCusPanel findCusPanel,String info,
			SalesUIController salesUIController){
		super(frame,url,controller);
		this.findCusPanel = findCusPanel;
		this.info = info;
		this.frame = frame;
		this.addButton();
		this.salesUIController = salesUIController;
		infoArray.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
		infoArray.add(info);
		this.setTable(infoArray);
	}
	public MakeSureFindInfo(MyFrame frame,String url,UIController controller,FindCusPanel findCusPanel,ArrayList<String> info,
			SalesUIController salesUIController){
		super(frame,url,controller);
		this.findCusPanel = findCusPanel;
		this.frame = frame;
		this.addButton();
		this.salesUIController = salesUIController;
		this.setTable(info);
	}
	
	public void addButton() {
//		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
//				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
//		this.add(back);
		this.add(forward);
//		back.addActionListener(buttonListener);
		forward.addMouseListener(new ButtonListener());
	}
	
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.remove(this);
		frame.add(showTable.tablePanel);
		salesUIController.backPanel(this);
		frame.repaint();
//		this.add(showTable.tablePanel);
	}
	
	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			frame.remove(MakeSureFindInfo.this);
			frame.setPanel(findCusPanel);
			frame.repaint();			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
