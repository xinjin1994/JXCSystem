package ui.setting;

import java.util.ArrayList;

import ui.UIController;
import ui.account.payRe.ConfirmPaymentPanel;
import ui.account.payRe.ConfirmReceiptPanel;
import ui.commodity.PatchDetailPanel;
import ui.manager.SendGiftPanel;
import ui.sales.impanel.ImInBillPanel;
import ui.sales.impanel.ImInDraftBill;
import ui.sales.salespanel.SalesBillPanel;
import ui.sales.salespanel.SalesDraftBill;
import vo.SendGiftVO;
import vo.bill.ExportMenuVO;
import vo.bill.GetVO;
import vo.bill.ImportMenuVO;
import vo.bill.InvoiceVO;
import vo.bill.PatchVO;
import vo.bill.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogic.commoditybl.CommodityController;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.accountblservice.AccountblService;
import businesslogicservice.commodityblservice.CommodityblService;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class SaveTempBills {
	ArrayList<InvoiceVO> invoiceBills = new ArrayList<InvoiceVO>();
	InvoiceblService invoiceblService;
	CommodityblService commodityblService;
	AccountblService accountblService;
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
		commodityblService = new CommodityController();
		accountblService = new AccountController();
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
			try{
			ImportMenuVO imp = (ImportMenuVO)(bill);
			frame.setPanel(new ImInBillPanel(frame,"Image/Sales/详细信息/importDetail.jpg",uiController,imp));
			}catch(Exception e){
				frame.setPanel(new ImInDraftBill(frame,"Image/Sales/详细信息/importDetail.jpg",uiController,(ImportMenuVO)(bill)));
			}
			break;
		case 3:
//			(ImportMenuVO)(bill);
			try{
			frame.setPanel(new ImInBillPanel(frame,"Image/Sales/详细信息/import_returnDetail.jpg",uiController,(ImportMenuVO)(bill)));
			}catch(Exception e){
				frame.setPanel(new ImInDraftBill(frame,"Image/Sales/详细信息/import_returnDetail.jpg",uiController,(ImportMenuVO)(bill)));
			}
			break;
		case 4:
//			(ExportMenuVO)(bill);
			//MyFrame frame, String url, UIController controller,ExportMenuVO exportMenuVO
			try{
			frame.setPanel(new SalesBillPanel(frame,"Image/Sales/详细信息/exportDetail.jpg",uiController,(ExportMenuVO)(bill)));
			}catch(Exception e){
				frame.setPanel(new SalesDraftBill(frame,"Image/Sales/详细信息/exportDetail.jpg",uiController,(ExportMenuVO)(bill)));
			}
			break;
		case 5:
//			(ExportMenuVO)(bill); 
			try{
			frame.setPanel(new SalesBillPanel(frame,"Image/Sales/详细信息/export_returnDetail.jpg",uiController,(ExportMenuVO)(bill)));
			}catch(Exception e){
				frame.setPanel(new SalesDraftBill(frame,"Image/Sales/详细信息/export_returnDetail.jpg",uiController,(ExportMenuVO)(bill)));
			}
			break;
		case 6:
			try {
				frame.setPanel(new PatchDetailPanel(frame, "Image/Commodity/stockManage/patchDetail.jpg",
						uiController, (PatchVO)(bill)));
			} catch (Exception e) {
				UIController.commodityAllUIController.patchDraft(commodityblService.searchDraftPatch_up(temp.note));
			}
			
			break;
		case 7:
			try {
				frame.setPanel(new ConfirmReceiptPanel(frame, "Image/Account/receiptDetail.jpg", uiController, 
						(GetVO)(bill)));
			} catch (Exception e) {
				UIController.accountAllUIController.addReceiptDraft(accountblService.searchDraftReceipt_up(temp.note));
			}
			
			break;
		case 8:
			try {
				frame.setPanel(new ConfirmPaymentPanel(frame, "Image/Account/paymentDetail.jpg", uiController, 
						(PayVO)(bill)));
			} catch (Exception e) {
				
				System.out.println(invoiceBills+"bill");
				UIController.accountAllUIController.addPaymentDraft(accountblService.searchDraftPayment_up(temp.note));
			}
		
			break;	
		}
		frame.repaint();
	}
}
