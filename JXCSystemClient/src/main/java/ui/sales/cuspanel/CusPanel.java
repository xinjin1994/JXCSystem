package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.sales.SalesUIController;
import ui.sales.SalesSecondPanel;
import ui.setting.MyButton;

public class CusPanel extends SalesSecondPanel{
	private MyButton addCus, delCus, changeCusInfo, seeCusInfo;
	private int secondX = 1;
	
	public CusPanel(SalesUIController salesUIController){
		super(salesUIController);
		this.salesUIController = salesUIController;
		this.addCusButton();
	}
	public void addCusButton() {
		addCus = new MyButton("Image/Sales/Sales_image/增加用户.png", secondX, secondY,
				"Image/Sales/Sales_image/增加用户_stop.png", "Image/Sales/Sales_image/增加客户_press_on.png");
		addCus.addActionListener(new CusListener());
		delCus = new MyButton("Image/Sales/Sales_image/删除客户.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/删除客户_stop.png", "Image/Sales/Sales_image/删除客户_press_on.png");
		changeCusInfo = new MyButton("Image/Sales/Sales_image/修改客户信息.png", secondX, secondY + 2 * inter,
				"Image/Sales/Sales_image/修改客户信息_stop.png", "Image/Sales/Sales_image/修改客户信息_press_on.png");
		seeCusInfo = new MyButton("Image/Sales/Sales_image/查看客户信息.png", secondX, secondY + 3 * inter,
				"Image/Sales/Sales_image/查看客户信息_stop.png", "Image/Sales/Sales_image/查看客户信息_press_on.png");
		this.add(addCus);
		this.add(delCus);
		this.add(changeCusInfo);
		this.add(seeCusInfo);
	}
	
	class CusListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addCus){
				salesUIController.toPanel(0);
			}else if(e.getSource() == delCus){
			}else if(e.getSource() == changeCusInfo){
			}else if(e.getSource() == seeCusInfo){
			}
		}
		
	}
}
