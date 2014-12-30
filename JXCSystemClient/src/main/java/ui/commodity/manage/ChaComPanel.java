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
/**
 * 修改商品对话框界面，结束后跳转修改商品具体界面ChaComDPanel
 * @author ZYC
 *
 */
public class ChaComPanel extends FatherPanel implements ActionListener {

	private CommodityAllUIController commodityAllUIController;
	private MyFrame frame;
	private ResultPanelController resController;
	private MyButton forwardButton;
	private MyTextFieldBorder name, typeID;
	private String nameString, typeString;

	private CommodityVO finCom;
	private CommodityblService commodityblService;
	private String failedAddress;

	public ChaComPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.repaint();

		commodityAllUIController.setBack_second(this, 183, 151);
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "com/chaCom";

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
		if (nameString.equals("") || typeString.equals("")) {
			frame.remove(this);
			resController.failed("存在输入为空！", failedAddress);
		} else {
				finCom = commodityblService.searchAccurateCommodity_up(nameString, typeString);
				if (finCom == null) {
					frame.remove(this);
					resController.failed("您要修改的商品不存在！", failedAddress);
				} else {
					String fatherSort = finCom.fatherSort;
					SortVO sortVO = new SortVO(fatherSort);
					frame.remove(this);
					commodityAllUIController.setTempPanel(this);
					commodityAllUIController.changeComD(finCom);
				}

		}
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(591, 403);
		forwardButton = forward.forward_white;

		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			commodityAllUIController.setTempPanel(this);
			getChaCom();
		}
	}

}
