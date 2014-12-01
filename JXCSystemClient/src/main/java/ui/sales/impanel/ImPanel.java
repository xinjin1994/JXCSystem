package ui.sales.impanel;

import ui.sales.SalesUIController;
import ui.sales.SalesSecondPanel;
import ui.setting.MyButton;

public class ImPanel extends SalesSecondPanel{
	
	private MyButton importMenu,importBackMenu;
	public ImPanel(SalesUIController salesUIController){
		super(salesUIController);
		this.salesUIController = salesUIController;
		this.addImportButton();
	}
	public void addImportButton() {
		importMenu = new MyButton("Image/Sales/Sales_image/进货单.png", secondX, secondY,
				"Image/Sales/Sales_image/进货单_stop.png", "Image/Sales/Sales_image/进货单_press_on.png");
		importBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		this.add(importMenu);
		this.add(importBackMenu);
	}
}
