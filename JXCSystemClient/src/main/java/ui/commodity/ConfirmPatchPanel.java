package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.PatchVO;

public class ConfirmPatchPanel extends PatchDetailPanel implements ActionListener{
	private MyButton forwardButton;
	private ResultPanelController resController;
	public ConfirmPatchPanel(MyFrame frame, String string,
			CommodityAllUIController commodityAllUIController,PatchVO newPatch) {
		
		super(frame, string, commodityAllUIController, newPatch);
		setForward();
		resController = new ResultPanelController(commodityAllUIController, frame);
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
			resController.succeeded("成功添加报溢报损单！", "commodity");
		} 
	}
}
