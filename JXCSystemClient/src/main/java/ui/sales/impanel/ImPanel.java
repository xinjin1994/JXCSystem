package ui.sales.impanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.sales.SalesSecondPanel;
import ui.sales.SalesUIController;
import ui.setting.Button.MyButton;

public class ImPanel extends SalesSecondPanel{
	
	private MyButton importMenu,importBackMenu;
    ImListener listener;
	public ImPanel(SalesUIController salesUIController){
		super(salesUIController);
		this.salesUIController = salesUIController;
		listener = new ImListener();
		this.addImportButton();
	}
	public void addImportButton() {
		importMenu = new MyButton("Image/Sales/Sales_image/进货单.png", secondX, secondY,
				"Image/Sales/Sales_image/进货单_stop.png", "Image/Sales/Sales_image/进货单_press_on.png");
		importBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		this.add(importMenu);
		this.add(importBackMenu);
		importMenu.addActionListener(listener);
		importBackMenu.addActionListener(listener);
	}
	
	class ImListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == importMenu){
				salesUIController.toPanel(4);
			}else if(e.getSource() == importBackMenu){
				salesUIController.toPanel(5);
			}
		}
		
	}
}
