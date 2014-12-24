package ui.commodity.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class DelComPanel extends FatherPanel implements ActionListener{

	private CommodityAllUIController commodityAllUIController;
	private MyFrame frame;
	private MyButton forwardButton;
	private CommodityVO comDel;
	
	private MyTextFieldBorder name,typeID;
	
	private ResultPanelController resController;
	private CommodityblService commodityblService;
	
	private String nameString,typeString,failedAddress;
	

	public DelComPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.commodityAllUIController = controller;
		this.frame = frame;
		this.repaint();
		commodityblService = new CommodityController();
		commodityAllUIController.setBack_second(this, 183, 151);
		resController = new ResultPanelController(frame, this);
		commodityblService = new CommodityController();
		setFailedAddress();
		init();
	}
	
	protected void setFailedAddress() {
		failedAddress = "com/delCom";
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
		if(nameString.equals("")||typeString.equals("")){
			frame.remove(this);
			resController.failed("存在输入为空！", failedAddress);
		}else{
			comDel = commodityblService.searchAccurateCommodity_up(nameString, typeString);
			if(comDel==null){
				frame.remove(this);
				resController.failed("您要删除的商品不存在！", failedAddress);
			}else{
			SortVO sort = new SortVO(comDel.fatherSort);
			commodityAllUIController.setTempPanel(this);
			commodityAllUIController.confirmCom(comDel, "del",sort);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			getDelCom();
		}
	}

}
