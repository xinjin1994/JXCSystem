package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.sales.SalesUIController;
import ui.sales.SalesSecondPanel;
import ui.setting.Button.MyButton;

public class CusPanel extends SalesSecondPanel{
	/*
	 * 添加客户二级界面（主界面上点击之后第二列出现的）
	 */
	private MyButton addCus, delCus, changeCusInfo, seeCusInfo;
	private int secondX = 1;
	CusListener listener = new CusListener();
	
	public CusPanel(SalesUIController salesUIController){
		super(salesUIController);
		this.salesUIController = salesUIController;
		this.addCusButton();
	}
	public void addCusButton() {
		addCus = new MyButton("Image/Sales/Sales_image/增加用户.png", secondX, secondY,
				"Image/Sales/Sales_image/增加用户_stop.png", "Image/Sales/Sales_image/增加客户_press_on.png");
		addCus.addActionListener(listener);
		delCus = new MyButton("Image/Sales/Sales_image/删除客户.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/删除客户_stop.png", "Image/Sales/Sales_image/删除客户_press_on.png");
		delCus.addActionListener(listener);
		changeCusInfo = new MyButton("Image/Sales/Sales_image/修改客户信息.png", secondX, secondY + 2 * inter,
				"Image/Sales/Sales_image/修改客户信息_stop.png", "Image/Sales/Sales_image/修改客户信息_press_on.png");
		changeCusInfo.addActionListener(listener);
		seeCusInfo = new MyButton("Image/Sales/Sales_image/查看客户信息.png", secondX, secondY + 3 * inter,
				"Image/Sales/Sales_image/查看客户信息_stop.png", "Image/Sales/Sales_image/查看客户信息_press_on.png");
		seeCusInfo.addActionListener(listener);
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
				salesUIController.toPanel(1);
			}else if(e.getSource() == changeCusInfo){
				salesUIController.toPanel(2);
			}else if(e.getSource() == seeCusInfo){
				salesUIController.toPanel(3);
			}
		}
		
	}
}
