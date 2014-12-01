package ui.sales.salespanel;

import ui.sales.SalesUIController;
import ui.sales.SalesSecondPanel;
import ui.setting.MyButton;

public class SalesPanel extends SalesSecondPanel{

	private MyButton salesMenu,salesBackMenu ;
	public SalesPanel(SalesUIController salesUIController){
		super(salesUIController);
		this.salesUIController = salesUIController;
		this.addSalesButton();
	}
	public void addSalesButton() {
		salesMenu = new MyButton("Image/Sales/Sales_image/销售单.png", secondX, secondY,
				"Image/Sales/Sales_image/销售单_stop.png", "Image/Sales/Sales_image/销售单_press_on.png");
		salesBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		this.add(salesMenu);
		this.add(salesBackMenu);

	}
}
