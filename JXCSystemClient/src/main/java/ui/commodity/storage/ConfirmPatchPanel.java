package ui.commodity.storage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.CommodityPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.SetTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.InvoiceVO;
import vo.bill.PatchVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
/**
 * 报溢报损确认界面
 * @author ZYC
 *
 */
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
				ArrayList<PatchVO> patchs = commodityblService.getAllPatch_up();
				ArrayList<String> info  = new ArrayList<String>();
				info.add("时间;单据编号");
				ArrayList<InvoiceVO> patchIn = new ArrayList<InvoiceVO>();
				for(PatchVO temp:patchs){
					info.add(temp.time+";"+temp.note);
					patchIn.add((InvoiceVO)temp);
				}
				
				SaveTempBills bills = new SaveTempBills(frame, patchIn, commodityAllUIController);
				CommodityPanel temp = (CommodityPanel)(commodityAllUIController.getMainPanel());
				temp.setTable(info, bills);
				frame.setPanel(temp);
				frame.repaint();
				commodityAllUIController.setMainPanel(temp);
				break;
			default:
				resControllerF.failedConfirm("未知错误！", failedAddress);
			}
		} 
	}
}
