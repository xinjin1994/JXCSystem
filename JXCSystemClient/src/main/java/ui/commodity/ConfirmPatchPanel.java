package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.PatchVO;

public class ConfirmPatchPanel extends PatchDetailPanel implements ActionListener{
	private MyButton forwardButton;
	
	private ResultPanelController resControllerS,resControllerF;
	private String failedAddress;
	public ConfirmPatchPanel(MyFrame frame, String string,
			CommodityAllUIController commodityAllUIController,PatchVO newPatch) {
		
		super(frame, string, commodityAllUIController, newPatch);
		setForward();
		resControllerS = new ResultPanelController(frame,this);
		resControllerF = new ResultPanelController(frame, commodityAllUIController.getMainPanel());
		this.failedAddress = "commodity3";
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
			resControllerS.succeeded("成功添加报溢报损单！", "commodity");
		} 
	}
}
