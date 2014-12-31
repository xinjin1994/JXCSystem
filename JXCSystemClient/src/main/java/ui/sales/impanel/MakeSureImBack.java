package ui.sales.impanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;

public class MakeSureImBack extends MakeSureIm{
	/*
	 * 确认添加进货退货单界面
	 */

	public MakeSureImBack(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, ImInPanel imInPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller, importMenuVO, commodityListVO, personLabel, operatorLabel, imInPanel,
				salesUIController);
		
	}
	
	public void addButton(){
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addActionListener(buttonListener);
		forward.addActionListener(buttonListener);
	}
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == back){
				frame.remove(MakeSureImBack.this);
				frame.setPanel(imInPanel);
				frame.repaint();
			}else if(e.getSource() == forward){
//				System.out.println("hello");
				SalesResult salesResult = new SalesResult(frame,controller,salesUIController,MakeSureImBack.this);
				switch(salesblService.addImport_up(importMenuVO)){
				case 0:
					salesResult.succeeded("添加成功！");
					break;
				case 5:
					salesResult.failed("超过最大可退货数量！", "import_returnFailed");
					break;
				default:
					salesResult.failed("添加失败！", "import_returnFailed");
				}
			}
		}
	}
}