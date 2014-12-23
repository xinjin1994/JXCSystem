package businesslogic.invoicebl;

import java.util.ArrayList;

import main.ClientStart;
import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.InvoicePO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SendGiftPO;
import vo.SendGiftVO;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.GetVO;
import vo.bill.ImportMenuVO;
import vo.bill.InvoiceVO;
import vo.bill.ItemList;
import vo.bill.PatchVO;
import vo.bill.PayVO;
import vo.bill.TransferListVO;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class InvoiceController implements InvoiceblService{
	
	public Invoice invoice=new Invoice();
	
	public InvoiceController(){
		invoice=ClientStart.invoice;
	}

	public ArrayList<InvoiceVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<InvoicePO> po=invoice.show();
		ArrayList<InvoiceVO> vo=new ArrayList<InvoiceVO>();
		int i=0;
		for(i=0;i<po.size();i++){
			InvoiceVO lin=new InvoiceVO(po.get(i).getInvoiceNote(),po.get(i).getNote(),po.get(i).getDocType(),po.get(i).getTime(),"");
			vo.add(lin);
		}
		return vo;
	}

//	public int pass(String note) {
//		// TODO Auto-generated method stub
//		return invoice.pass(note);
//	}

	public int refuse_up(String note) {
		// TODO Auto-generated method stub
		return invoice.refuse(note);
	}

	public int pass_up(InvoiceVO vo) {
		// TODO Auto-generated method stub
		InvoicePO po=invoice.findInvoice(vo.note);
		int res=0;;
		switch(vo.bill_note){
		
		case 1: SendGiftPO gift=(SendGiftPO) po;
				SendGiftVO giftvo=(SendGiftVO) vo;
				gift.setNumber(giftvo.number);
				res=invoice.pass((InvoicePO) gift);
				break;
		
		case 2: ImportPO importpo=(ImportPO) po;
				ImportMenuVO importvo=(ImportMenuVO) vo;
				importpo.getImportGoodList().get(0).price=importvo.commodityList.price;
				importpo.getImportGoodList().get(0).number=importvo.commodityList.num;
				importpo.getImportGoodList().get(0).money=importpo.getImportGoodList().get(0).getPrice()*importpo.getImportGoodList().get(0).getNumber();
				importpo.total_money=importpo.getImportGoodList().get(0).money;
				res=invoice.pass((InvoicePO) importpo);
				break;
				
		case 3: Import_ReturnPO imp_retpo=(Import_ReturnPO) po;
				ImportMenuVO imp_retvo=(ImportMenuVO) vo;
				imp_retpo.getImportGoodList().get(0).price=imp_retvo.commodityList.price;
				imp_retpo.getImportGoodList().get(0).number=imp_retvo.commodityList.num;
				imp_retpo.getImportGoodList().get(0).money=imp_retpo.getImportGoodList().get(0).getPrice()*imp_retpo.getImportGoodList().get(0).getNumber();
				imp_retpo.total_money=imp_retpo.getImportGoodList().get(0).money;
				res=invoice.pass(imp_retpo);
				break;
		
		case 4: ExportPO exportpo=(ExportPO) po;
				ExportMenuVO exportvo=(ExportMenuVO) vo;
				exportpo.getExportGoodList().get(0).price=exportvo.commodityList.price;
				exportpo.getExportGoodList().get(0).number=exportvo.commodityList.num;
				exportpo.getExportGoodList().get(0).money=exportpo.getExportGoodList().get(0).getPrice()*exportpo.getExportGoodList().get(0).getNumber();
				exportpo.discount=exportvo.discount;
				exportpo.voucher=exportvo.voucherPrice;
				exportpo.total_money_before=exportpo.getExportGoodList().get(0).money;
				exportpo.total_money_after=exportpo.getTotalMoneyBefore()-exportpo.getDiscount()-exportpo.getVoucher();
				res=invoice.pass(exportpo);
				break;
		
		case 5: Export_ReturnPO exp_retpo=(Export_ReturnPO) po;
				ExportMenuVO exp_retvo=(ExportMenuVO) vo;
				exp_retpo.getExportGoodList().get(0).price=exp_retvo.commodityList.price;
				exp_retpo.getExportGoodList().get(0).number=exp_retvo.commodityList.num;
				exp_retpo.getExportGoodList().get(0).money=exp_retpo.getExportGoodList().get(0).getPrice()*exp_retpo.getExportGoodList().get(0).getNumber();
				exp_retpo.discount=exp_retvo.discount;
				exp_retpo.voucher=exp_retvo.voucherPrice;
				exp_retpo.total_money_before=exp_retpo.getExportGoodList().get(0).money;
				exp_retpo.total_money_after=exp_retpo.getTotalMoneyBefore()-exp_retpo.getDiscount()-exp_retpo.getVoucher();
				res=invoice.pass(exp_retpo);
				break;
		
		case 6: PatchPO patch=(PatchPO) po;
				PatchVO patchvo=(PatchVO) vo;
				patch.setNumber(patchvo.number);
				res=invoice.pass(patch);
				break;
				
		case 7: ReceiptPO receipt=(ReceiptPO) po;
				GetVO get=(GetVO) vo;
				receipt.getTransfer().get(0).money=get.transferList.transferValue;
				receipt.total_money=receipt.getTransfer().get(0).getMoney();
				res=invoice.pass(receipt);
				break;
				
		case 8: PaymentPO payment=(PaymentPO) po;
				PayVO pay=(PayVO) vo;
				payment.getItem().get(0).money=pay.itemList.money;
				payment.total_money=payment.getItem().get(0).money;
				res=invoice.pass(payment);
				break;
				
		}
		
		return res;
	}

	public int pass_up(ArrayList<InvoiceVO> vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int refuseInvoice_up(String invoice_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public InvoiceVO searchNote_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public InvoiceVO searchInvoiceNote_up(String invoice_note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InvoiceVO> show_pass() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InvoiceVO> show_refuse() {
		// TODO Auto-generated method stub
		return null;
	}

//	public String add(PatchPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(ImportPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(ExportPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(Import_ReturnPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(Export_ReturnPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(ReceiptPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}
//
//	public String add(PaymentPO po) {
//		// TODO Auto-generated method stub
//		return invoice.add(po);
//	}

}
