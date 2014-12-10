package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTable;

public class MakeSureFindInfo extends FatherPanel{

	private FindCusPanel findCusPanel;
	private MyButton forward;
	private MyFrame frame;
	private MyTable table;
	private String info;
	
	public MakeSureFindInfo(MyFrame frame,String url,UIController controller,FindCusPanel findCusPanel,String info){
		super(frame,url,controller);
		this.findCusPanel = findCusPanel;
		this.info = info;
		this.frame = frame;
		this.addButton();
		this.setTable();
		this.add(table);
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
	
	public void setTable(){
		table = new MyTable(this);
		ArrayList <String> infoArray = new ArrayList<String>();
		infoArray.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
		table.setTable(infoArray);
		table.add(info);
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
