package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.commodity.storage.PatchDetailPanel;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.PatchVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class ConfirmPatchPanel extends PatchDetailPanel implements ActionListener{
	private MyButton forwardButton;
	private CommodityblService commodityblService;
	private ResultPanelController resControllerS,resControllerF;
	private String failedAddress;
	public ConfirmPatchPanel(MyFrame frame, String string,
			CommodityAllUIController commodityAllUIController,PatchVO newPatch) {
		
		super(frame, string, commodityAllUIController, newPatch);
		setForward();
		resControllerS = new ResultPanelController(frame, commodityAllUIController.getMainPanel());
		resControllerF = new ResultPanelController(frame, commodityAllUIController.getPanel());
		this.failedAddress = "commodity3";
		commodityblService = new CommodityController();
	}

	protected void back() {
		commodityAllUIController.setBack_third(this);
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(724, 426);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
//			resControllerS.succeeded("成功添加报溢报损单！", "commodity");
			switch(commodityblService.patch_up(patch)){
			case 0:
				resControllerS.succeeded("成功添加报溢报损单！", "commodity");
				break;
			default:
				resControllerF.failedConfirm("未知错误！", failedAddress);
			}
		} 
	}
}
