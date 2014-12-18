package ui.setting;

import java.awt.Frame;
import java.util.ArrayList;

import po.Import_ReturnPO;
import ui.UIController;
import ui.account.payRe.ConfirmPaymentPanel;
import ui.account.payRe.ConfirmReceiptPanel;
import ui.commodity.PatchDetailPanel;
import ui.manager.ManagerAllUIController;
import ui.manager.SendGiftPanel;
import vo.SendGiftVO;
import vo.bill.ExportMenuVO;
import vo.bill.GetVO;
import vo.bill.ImportMenuVO;
import vo.bill.InvoiceVO;
import vo.bill.PatchVO;
import vo.bill.PayVO;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class SaveTempBills {
	ArrayList<InvoiceVO> invoiceBills = new ArrayList<InvoiceVO>();
	InvoiceblService invoiceblService;
	InvoiceVO temp,bill;
	UIController uiController;
	MyFrame frame;
	
	public SaveTempBills(MyFrame frame,ArrayList<InvoiceVO> invoiceBills,UIController uiController) {
		this.invoiceBills = invoiceBills;
		this.uiController = uiController;
		this.frame = frame;
		
		invoiceblService = new InvoiceController();
	}
	
	public void getInvoiceInfo(int loc){
		temp = invoiceBills.get(loc);
		bill = invoiceblService.searchNote_up(temp.note);
		checkType(temp.bill_note);
	}

	private void checkType(int bill_note) {
		frame.remove(uiController.getMainPanel());
		switch (bill_note) {
		case 1:
			frame.setPanel(new SendGiftPanel(frame,"Image/Manager/snedGift.jpg"
					,uiController,(SendGiftVO)(bill)));
			break;
		case 2:
//			(ImportMenuVO)(bill);
			break;
		case 3:
//			(ImportMenuVO)(bill);
			break;
		case 4:
//			(ExportMenuVO)(bill);
			break;
		case 5:
//			(ExportMenuVO)(bill); 
			break;
		case 6:
			frame.setPanel(new PatchDetailPanel(frame, "Image/Commodity/stockManage/patchDetail.jpg",
					uiController, (PatchVO)(bill)));
			break;
		case 7:
			frame.setPanel(new ConfirmReceiptPanel(frame, "Image/Account/receiptDetails.jpg", uiController, 
					(GetVO)(bill)));
			break;
		case 8:
			frame.setPanel(new ConfirmPaymentPanel(frame, "Image/Account/paymentDetails.jpg", uiController, 
					(PayVO)(bill)));
			break;	
		}
		frame.repaint();
	}
}
