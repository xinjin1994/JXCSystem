package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class DelComPanel extends FatherPanel implements ActionListener{

	private CommodityAllUIController commodityAllUIController;
	private MyFrame frame;
	private MyButton forwardButton;
	private CommodityVO comDel;
	
	private MyTextFieldBorder name,typeID;
	
	private ResultPanelController resController;
	private CommodityblService commodityblService;
	
	private String nameString,typeString;
	public DelComPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.commodityAllUIController = controller;
		this.frame = frame;
		this.repaint();
		
		commodityAllUIController.setBack_second(this, 183, 151);
		resController = new ResultPanelController(frame, this);
		commodityblService = new CommodityController();
		init();
	}
	private void init() {
		setTextField();
		setForward();
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(591, 403);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	private void setTextField() {
		name = new MyTextFieldBorder(259, 254);
		typeID = new MyTextFieldBorder(259, 344);
		
		this.add(name);
		this.add(typeID);
		
		name.setForeground(new ColorFactory().accColor);
		typeID.setForeground(new ColorFactory().accColor);
	}
	/**
	 * 根据商品名称，型号搜索com
	 */
	private void getDelCom() {
		nameString = name.getText();
		typeString = typeID.getText();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			getDelCom();
			comDel = new CommodityVO("" ,nameString, typeString, 11, 11, 11, 12, 12, 12, "g");
			commodityAllUIController.confirmCom(comDel, "del");
		}
	}

}
