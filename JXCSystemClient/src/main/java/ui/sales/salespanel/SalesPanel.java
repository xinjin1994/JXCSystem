package ui.sales.salespanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.sales.SalesSecondPanel;
import ui.sales.SalesUIController;
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
		salesMenu.addMouseListener(new SaleListener());
		salesBackMenu.addMouseListener(new SaleListener());
	}
	
	class SaleListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == salesMenu){
				salesUIController.toPanel(6);
			}else if(e.getSource() == salesBackMenu){
				salesUIController.toPanel(7);
			}
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
