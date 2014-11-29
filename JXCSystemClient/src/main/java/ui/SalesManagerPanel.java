package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 3销售经理
 * 
 * @author lsy
 * @version 2014年11月29日下午2:54:20
 */
public class SalesManagerPanel extends FatherPanel {

	private static final long serialVersionUID = -4472929361380810275L;

	public SalesManagerPanel(JFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		addButton();
	}
	private void addButton() {
		
		MyButton customerManageButton = new MyFirstButton
				("Image/Sales/Sales_image/客户管理.png", 2, 110, this,"Image/Sales/Sales_image/客户管理_stop.png","Image/Sales/Sales_image/客户管理_press_on.png");
			
	}

}
