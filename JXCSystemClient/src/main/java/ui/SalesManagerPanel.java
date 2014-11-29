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

	int firstX = 2;
	int firstY = 110;
	int inter = 54;
	int secondX = 177;
	int secondY = 110;

	MyButton cusManage, salesManage, importManage, addCus, delCus, changeCusInfo, seeCusInfo, importMenu,
	importBackMenu, salesMenu, salesBackMenu,detail,back;
	private static final long serialVersionUID = -4472929361380810275L;

	public SalesManagerPanel(JFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.addButton();
	}
	private void addButton() {
		
		cusManage = new MyFirstButton
				("Image/Sales/Sales_image/客户管理.png", firstX, firstY, this,"Image/Sales/Sales_image/客户管理_stop.png","Image/Sales/Sales_image/客户管理_press_on.png");
		salesManage = new MyFirstButton("Image/Sales/Sales_image/销售管理.png",firstX-2,firstY+inter,this,"Image/Sales/Sales_image/销售管理_stop.png","Image/Sales/Sales_image/销售管理_press_on.png");
		importManage = new MyFirstButton("Image/Sales/Sales_image/进货管理.png",firstX-1,firstY+2*inter,this,"Image/Sales/Sales_image/进货管理_stop.png","Image/Sales/Sales_image/进货管理_press_on.png");
		addCus = new MyButton("Image/Sales/Sales_image/增加用户.png",secondX,secondY,this,"Image/Sales/Sales_image/增加用户_stop.png","Image/Sales/Sales_image/增加客户_press_on.png");
		delCus = new MyButton("Image/Sales/Sales_image/删除客户.png",secondX,secondY+inter,this,"Image/Sales/Sales_image/删除客户_stop.png","Image/Sales/Sales_image/删除客户_press_on.png");
		changeCusInfo = new MyButton("Image/Sales/Sales_image/修改客户信息.png",secondX,secondY+2*inter,this,"Image/Sales/Sales_image/修改客户信息_stop.png","Image/Sales/Sales_image/修改客户信息_press_on.png");
		seeCusInfo = new MyButton("Image/Sales/Sales_image/查看客户信息.png",secondX,secondY+3*inter,this,"Image/Sales/Sales_image/查看客户信息_stop.png","Image/Sales/Sales_image/查看客户信息_press_on.png");
		importMenu = new MyButton("Image/Sales/Sales_image/进货单.png",secondX,secondY,this,"Image/Sales/Sales_image/进货单_stop.png","");
		importBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png",secondX,secondY+inter,this,"Image/Sales/Sales_image/进货退货单_stop.png","Image/Sales/Sales_image/进货退货单_press_on.png");
		salesMenu = new MyButton("Image/Sales/Sales_image/销售单.png",secondX,secondY,this,"Image/Sales/Sales_image/销售单_stop.png","Image/Sales/Sales_image/销售单_press_on.png");
		salesBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png",secondX,secondY+inter,this,"Image/Sales/Sales_image/进货退货单_stop.png","Image/Sales/Sales_image/进货退货单_press_on.png");
		detail = new MyButton("Image/Sales/Sales_image/details.png",670,537,this,"","Image/Sales/Sales_image/details_press_on.png");
	    back = new MyButton("Image/Sales/Sales_image/返回.png",13,21,this,"","Image/Sales/Sales_image/返回_press_on.png");
	    
	}

}
