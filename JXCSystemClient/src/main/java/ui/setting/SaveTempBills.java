package ui.setting;

import java.util.ArrayList;

import ui.UIController;
import ui.account.payRe.ConfirmPaymentPanel;
import ui.account.payRe.ConfirmReceiptPanel;
import ui.commodity.PatchDetailPanel;
import ui.manager.SendGiftPanel;
import ui.sales.impanel.ImInBillPanel;
import ui.sales.salespanel.SalesBillPanel;
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
	
	InvoiceVO pending;
	public SaveTempBills(MyFrame frame,ArrayList<InvoiceVO> invoiceBills,UIController uiController) {
		System.out.println(invoiceBills+"bills");
		System.out.println(invoiceBills.get(0));
		this.invoiceBills = invoiceBills;
		this.uiController = uiController;
		this.frame = frame;
		
		invoiceblService = new InvoiceController();
	}
	/**
	 * 单击
	 * @param loc
	 */
	public void setInfo(int loc){
		pending = invoiceBills.get(loc);
	}
	public InvoiceVO getInfo(){
		return pending;
	}
	/**
	 * 双击
	 * @param loc
	 */
	public void getInvoiceInfo(int loc){
		System.out.println(loc);
		temp = invoiceBills.get(loc);
		bill = invoiceblService.searchNote_up(temp.note);
		System.out.println(temp+"aaaaa");
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
			frame.setPanel(new ImInBillPanel(frame,"Image/Sales/详细信息/importDetail.jpg",uiController,(ImportMenuVO)(bill)));
			break;
		case 3:
//			(ImportMenuVO)(bill);
			frame.setPanel(new ImInBillPanel(frame,"Image/Sales/详细信息/import_returnDetail.jpg",uiController,(ImportMenuVO)(bill)));
			break;
		case 4:
//			(ExportMenuVO)(bill);
			//MyFrame frame, String url, UIController controller,ExportMenuVO exportMenuVO
			frame.setPanel(new SalesBillPanel(frame,"Image/Sales/详细信息/exportDetail.jpg",uiController,(ExportMenuVO)(bill)));
			break;
		case 5:
//			(ExportMenuVO)(bill); 
			frame.setPanel(new SalesBillPanel(frame,"Image/Sales/详细信息/export_returnDetail.jpg",uiController,(ExportMenuVO)(bill)));
			break;
		case 6:
			frame.setPanel(new PatchDetailPanel(frame, "Image/Commodity/stockManage/patchDetail.jpg",
					uiController, (PatchVO)(bill)));
			break;
		case 7:
			frame.setPanel(new ConfirmReceiptPanel(frame, "Image/Account/receiptDetail.jpg", uiController, 
					(GetVO)(bill)));
			break;
		case 8:
			frame.setPanel(new ConfirmPaymentPanel(frame, "Image/Account/paymentDetail.jpg", uiController, 
					(PayVO)(bill)));
			break;	
		}
		frame.repaint();
	}
}
