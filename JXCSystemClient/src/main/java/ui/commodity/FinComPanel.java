package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class FinComPanel extends FatherPanel implements ActionListener{
	
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,typeID,info;
	private String nameString,infoString,typeIDString;
	
	private CommodityVO com;
	private ResultPanelController resController;
	public FinComPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		this.repaint();
	
		resController = new ResultPanelController(frame, this);
		commodityAllUIController.setBack_second(this,178 ,115 );
		init();
	}




	private void init() {
		setForward();
		setTextField();
	}




	private void setTextField() {
		name = new MyTextFieldBorder(254, 218);
		typeID = new MyTextFieldBorder(254, 307);
		info = new MyTextFieldBorder(254, 423);
		
		this.add(typeID);
		this.add(name);
		this.add(info);
	}



	private void setForward() {
		ForwardButton exactForward = new ForwardButton(630, 304);
		ForwardButton fuzzyForward = new ForwardButton(630, 424);
		
		exactForwardButton = exactForward.forward_white;
		fuzzyForwardButton = fuzzyForward.forward_white;
		
		this.add(exactForwardButton);
		this.add(fuzzyForwardButton);
		
		exactForwardButton.addActionListener(this);
		fuzzyForwardButton.addActionListener(this);
	}




	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exactForwardButton){
			frame.remove(this);
			exactFind();
		
			commodityAllUIController.comDetail(com);
		}else if(e.getSource() == fuzzyForwardButton){
			frame.remove(this);
			fuzzyFind();
			
		}
	}




	private void fuzzyFind() {
		infoString = info.getText();
		
	}




	private void exactFind() {
		nameString = name.getText();
		typeIDString = typeID.getText();
//		com = new CommodityVO("" ,nameString, typeIDString, 11, 11, 11, 12, 12, 12, "g");
		commodityAllUIController.comDetail(com);
	}
	
	

	
}
