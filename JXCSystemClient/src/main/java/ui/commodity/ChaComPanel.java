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
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class ChaComPanel extends FatherPanel implements ActionListener{

	private CommodityAllUIController commodityAllUIController;
	private MyFrame frame;
	private ResultPanelController resController;
	private MyButton forwardButton;
	private MyTextFieldBorder name,typeID;
	private String nameString,typeString;
	
	private CommodityVO finCom;
	private CommodityblService commodityblService;
	
	
	public ChaComPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
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

	private void setTextField() {
		name = new MyTextFieldBorder(259, 254);
		typeID = new MyTextFieldBorder(259, 344);
		
		this.add(name);
		this.add(typeID);
		
		name.setForeground(new ColorFactory().accColor);
		typeID.setForeground(new ColorFactory().accColor);
	}

	private void getChaCom() {
		nameString = name.getText();
		typeString = typeID.getText();
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(591, 403);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			getChaCom();
		///	finCom = new CommodityVO("" ,nameString, typeString, 11, 11, 11, 12, 12, 12, "g");
			commodityAllUIController.changeComD(finCom);
		}
	}

}
