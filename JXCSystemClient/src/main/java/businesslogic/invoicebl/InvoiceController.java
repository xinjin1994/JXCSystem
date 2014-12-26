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
			switch(po.get(i).getDocType()){
			case 1: SendGiftPO po1=(SendGiftPO) po.get(i);
					SendGiftVO vo1=new SendGiftVO(po1.getNote(), po1.getTime(),"",po1.getCommodity().getName(),po1.getCommodity().getType(),po1.getNumber(),null);
					vo.add(vo1);
					break;
			case 2: ImportPO po2=(ImportPO) po.get(i);
					CommodityListVO com2=new CommodityListVO(po2.getImportGoodList().get(0).getCommodity().getNote(), po2.getImportGoodList().get(0).getCommodity().getName(), po2.getImportGoodList().get(0).getCommodity().getType(), po2.getImportGoodList().get(0).getNumber(), po2.getImportGoodList().get(0).getPrice(), po2.getImportGoodList().get(0).getMoney(), po2.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo2=new ImportMenuVO(po2.getNote(),po2.getCustomer().getName(),po2.getWareHouse(),po2.getOperator(),
							com2,po2.getPs(),po2.getTotalMoney(),po2.getTime(),2,null);
					vo.add(vo2);
					break;
			case 3: Import_ReturnPO po3=(Import_ReturnPO) po.get(i);
					CommodityListVO com3=new CommodityListVO(po3.getImportGoodList().get(0).getCommodity().getNote(), po3.getImportGoodList().get(0).getCommodity().getName(), po3.getImportGoodList().get(0).getCommodity().getType(), po3.getImportGoodList().get(0).getNumber(), po3.getImportGoodList().get(0).getPrice(), po3.getImportGoodList().get(0).getMoney(), po3.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo3=new ImportMenuVO(po3.getNote(),po3.getCustomer().getName(),po3.getWareHouse(),po3.getOperator(),
							com3,po3.getPs(),po3.getTotalMoney(),po3.getTime(),3,null);
					vo.add(vo3);
					break;
			case 4: ExportPO po4=(ExportPO) po.get(i);
					CommodityListVO com4=new CommodityListVO(po4.getExportGoodList().get(0).getCommodity().getNote(), po4.getExportGoodList().get(0).getCommodity().getName(), po4.getExportGoodList().get(0).getCommodity().getType(), po4.getExportGoodList().get(0).getNumber(), po4.getExportGoodList().get(0).getPrice(), po4.getExportGoodList().get(0).getMoney(), po4.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo4=new ExportMenuVO(po4.getNote(),po4.getCustomer().getName(),po4.getClerk(),po4.getOperator(),po4.getWareHouse(),
							com4,po4.getTotalMoneyBefore(),po4.getDiscount(),po4.getVoucher(),
							po4.getTotalMoneyAfter(),po4.getPs(),po4.getTime(),4,null);
					vo.add(vo4);
					break;
			case 5: Export_ReturnPO po5=(Export_ReturnPO) po.get(i);
					CommodityListVO com5=new CommodityListVO(po5.getExportGoodList().get(0).getCommodity().getNote(), po5.getExportGoodList().get(0).getCommodity().getName(), po5.getExportGoodList().get(0).getCommodity().getType(), po5.getExportGoodList().get(0).getNumber(), po5.getExportGoodList().get(0).getPrice(), po5.getExportGoodList().get(0).getMoney(), po5.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo5=new ExportMenuVO(po5.getNote(),po5.getCustomer().getName(),po5.getClerk(),po5.getOperator(),po5.getWareHouse(),
							com5,po5.getTotalMoneyBefore(),po5.getDiscount(),po5.getVoucher(),
							po5.getTotalMoneyAfter(),po5.getPs(),po5.getTime(),5,null);
					vo.add(vo5);
					break;
			case 6: PatchPO po6=(PatchPO) po.get(i);
					PatchVO vo6=new PatchVO(po6.getCommodity().getName(),po6.getCommodity().getType(),po6.getNumber(),po6.getNote(),po6.getTime(),po6.getOperator(),null);
					vo.add(vo6);
					break;
			case 7: ReceiptPO po7=(ReceiptPO) po.get(i);
					TransferListVO trans=new TransferListVO(po7.getTransfer().get(0).getAccount(),po7.getTransfer().get(0).getMoney(),po7.getTransfer().get(0).getPs());
					GetVO vo7=new GetVO(po7.getNote(), po7.getCustomer().getName(), po7.getOperator(), trans,po7.getTime(),null);
					vo.add(vo7);
					break;
			case 8: PaymentPO po8=(PaymentPO) po.get(i);
					ItemList item=new ItemList(po8.getItem().get(0).getItemName(), po8.getItem().get(0).getMoney(), po8.getItem().get(0).getPs());
					PayVO vo8=new PayVO(po8.getNote(),po8.getOperator(),po8.getAccount().getName(),item,po8.getTime(),null);
					vo.add(vo8);
					break;
			}
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
		for(int i=0;i<vo.size();i++){
			int res=pass_up(vo.get(i));
			if(res!=0){
				return res;
			}
		}	
		return 0;
	}

	public int refuseInvoice_up(String invoice_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public InvoiceVO searchNote_up(String note) {
		// TODO Auto-generated method stub
		InvoicePO po=invoice.findInvoice(note);
		
		if(po==null){
			return null;
		}
		
		switch(po.getDocType()){
		case 1: SendGiftPO po1=(SendGiftPO) po;
				SendGiftVO vo1=new SendGiftVO(po1.getNote(), po1.getTime(),"",po1.getCommodity().getName(),po1.getCommodity().getType(),po1.getNumber(),null);
				return vo1;
		case 2: ImportPO po2=(ImportPO) po;
				CommodityListVO com2=new CommodityListVO(po2.getImportGoodList().get(0).getCommodity().getNote(), po2.getImportGoodList().get(0).getCommodity().getName(), po2.getImportGoodList().get(0).getCommodity().getType(), po2.getImportGoodList().get(0).getNumber(), po2.getImportGoodList().get(0).getPrice(), po2.getImportGoodList().get(0).getMoney(), po2.getImportGoodList().get(0).getPs()); 
				ImportMenuVO vo2=new ImportMenuVO(po2.getNote(),po2.getCustomer().getName(),po2.getWareHouse(),po2.getOperator(),
						com2,po2.getPs(),po2.getTotalMoney(),po2.getTime(),2,null);
				return vo2;
		case 3: Import_ReturnPO po3=(Import_ReturnPO) po;
				CommodityListVO com3=new CommodityListVO(po3.getImportGoodList().get(0).getCommodity().getNote(), po3.getImportGoodList().get(0).getCommodity().getName(), po3.getImportGoodList().get(0).getCommodity().getType(), po3.getImportGoodList().get(0).getNumber(), po3.getImportGoodList().get(0).getPrice(), po3.getImportGoodList().get(0).getMoney(), po3.getImportGoodList().get(0).getPs()); 
				ImportMenuVO vo3=new ImportMenuVO(po3.getNote(),po3.getCustomer().getName(),po3.getWareHouse(),po3.getOperator(),
						com3,po3.getPs(),po3.getTotalMoney(),po3.getTime(),3,null);
				return vo3;
		case 4: ExportPO po4=(ExportPO) po;
				CommodityListVO com4=new CommodityListVO(po4.getExportGoodList().get(0).getCommodity().getNote(), po4.getExportGoodList().get(0).getCommodity().getName(), po4.getExportGoodList().get(0).getCommodity().getType(), po4.getExportGoodList().get(0).getNumber(), po4.getExportGoodList().get(0).getPrice(), po4.getExportGoodList().get(0).getMoney(), po4.getExportGoodList().get(0).getPs()); 
				ExportMenuVO vo4=new ExportMenuVO(po4.getNote(),po4.getCustomer().getName(),po4.getClerk(),po4.getOperator(),po4.getWareHouse(),
						com4,po4.getTotalMoneyBefore(),po4.getDiscount(),po4.getVoucher(),
						po4.getTotalMoneyAfter(),po4.getPs(),po4.getTime(),4,null);
				return vo4;
		case 5: Export_ReturnPO po5=(Export_ReturnPO) po;
				CommodityListVO com5=new CommodityListVO(po5.getExportGoodList().get(0).getCommodity().getNote(), po5.getExportGoodList().get(0).getCommodity().getName(), po5.getExportGoodList().get(0).getCommodity().getType(), po5.getExportGoodList().get(0).getNumber(), po5.getExportGoodList().get(0).getPrice(), po5.getExportGoodList().get(0).getMoney(), po5.getExportGoodList().get(0).getPs()); 
				ExportMenuVO vo5=new ExportMenuVO(po5.getNote(),po5.getCustomer().getName(),po5.getClerk(),po5.getOperator(),po5.getWareHouse(),
						com5,po5.getTotalMoneyBefore(),po5.getDiscount(),po5.getVoucher(),
						po5.getTotalMoneyAfter(),po5.getPs(),po5.getTime(),5,null);
				return vo5;
		case 6: PatchPO po6=(PatchPO) po;
				PatchVO vo6=new PatchVO(po6.getCommodity().getName(),po6.getCommodity().getType(),po6.getNumber(),po6.getNote(),po6.getTime(),po6.getOperator(),null);
				return vo6;
		case 7: ReceiptPO po7=(ReceiptPO) po;
				TransferListVO trans=new TransferListVO(po7.getTransfer().get(0).getAccount(),po7.getTransfer().get(0).getMoney(),po7.getTransfer().get(0).getPs());
				GetVO vo7=new GetVO(po7.getNote(), po7.getCustomer().getName(), po7.getOperator(), trans,po7.getTime(),null);
				return vo7;
		case 8: PaymentPO po8=(PaymentPO) po;
				ItemList item=new ItemList(po8.getItem().get(0).getItemName(), po8.getItem().get(0).getMoney(), po8.getItem().get(0).getPs());
				PayVO vo8=new PayVO(po8.getNote(),po8.getOperator(),po8.getAccount().getName(),item,po8.getTime(),null);
				return vo8;
		}
		return null;
	}

	public InvoiceVO searchInvoiceNote_up(String invoice_note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InvoiceVO> show_pass() {
		// TODO Auto-generated method stub
		ArrayList<InvoicePO> po=invoice.getPass();
		ArrayList<InvoiceVO> vo=new ArrayList<InvoiceVO>();
		int i=0;
		for(i=0;i<po.size();i++){
			switch(po.get(i).getDocType()){
			case 1: SendGiftPO po1=(SendGiftPO) po.get(i);
					SendGiftVO vo1=new SendGiftVO(po1.getNote(), po1.getTime(),"",po1.getCommodity().getName(),po1.getCommodity().getType(),po1.getNumber(),null);
					vo.add(vo1);
					break;
			case 2: ImportPO po2=(ImportPO) po.get(i);
					CommodityListVO com2=new CommodityListVO(po2.getImportGoodList().get(0).getCommodity().getNote(), po2.getImportGoodList().get(0).getCommodity().getName(), po2.getImportGoodList().get(0).getCommodity().getType(), po2.getImportGoodList().get(0).getNumber(), po2.getImportGoodList().get(0).getPrice(), po2.getImportGoodList().get(0).getMoney(), po2.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo2=new ImportMenuVO(po2.getNote(),po2.getCustomer().getName(),po2.getWareHouse(),po2.getOperator(),
							com2,po2.getPs(),po2.getTotalMoney(),po2.getTime(),2,null);
					vo.add(vo2);
					break;
			case 3: Import_ReturnPO po3=(Import_ReturnPO) po.get(i);
					CommodityListVO com3=new CommodityListVO(po3.getImportGoodList().get(0).getCommodity().getNote(), po3.getImportGoodList().get(0).getCommodity().getName(), po3.getImportGoodList().get(0).getCommodity().getType(), po3.getImportGoodList().get(0).getNumber(), po3.getImportGoodList().get(0).getPrice(), po3.getImportGoodList().get(0).getMoney(), po3.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo3=new ImportMenuVO(po3.getNote(),po3.getCustomer().getName(),po3.getWareHouse(),po3.getOperator(),
							com3,po3.getPs(),po3.getTotalMoney(),po3.getTime(),3,null);
					vo.add(vo3);
					break;
			case 4: ExportPO po4=(ExportPO) po.get(i);
					CommodityListVO com4=new CommodityListVO(po4.getExportGoodList().get(0).getCommodity().getNote(), po4.getExportGoodList().get(0).getCommodity().getName(), po4.getExportGoodList().get(0).getCommodity().getType(), po4.getExportGoodList().get(0).getNumber(), po4.getExportGoodList().get(0).getPrice(), po4.getExportGoodList().get(0).getMoney(), po4.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo4=new ExportMenuVO(po4.getNote(),po4.getCustomer().getName(),po4.getClerk(),po4.getOperator(),po4.getWareHouse(),
							com4,po4.getTotalMoneyBefore(),po4.getDiscount(),po4.getVoucher(),
							po4.getTotalMoneyAfter(),po4.getPs(),po4.getTime(),4,null);
					vo.add(vo4);
					break;
			case 5: Export_ReturnPO po5=(Export_ReturnPO) po.get(i);
					CommodityListVO com5=new CommodityListVO(po5.getExportGoodList().get(0).getCommodity().getNote(), po5.getExportGoodList().get(0).getCommodity().getName(), po5.getExportGoodList().get(0).getCommodity().getType(), po5.getExportGoodList().get(0).getNumber(), po5.getExportGoodList().get(0).getPrice(), po5.getExportGoodList().get(0).getMoney(), po5.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo5=new ExportMenuVO(po5.getNote(),po5.getCustomer().getName(),po5.getClerk(),po5.getOperator(),po5.getWareHouse(),
							com5,po5.getTotalMoneyBefore(),po5.getDiscount(),po5.getVoucher(),
							po5.getTotalMoneyAfter(),po5.getPs(),po5.getTime(),5,null);
					vo.add(vo5);
					break;
			case 6: PatchPO po6=(PatchPO) po.get(i);
					PatchVO vo6=new PatchVO(po6.getCommodity().getName(),po6.getCommodity().getType(),po6.getNumber(),po6.getNote(),po6.getTime(),po6.getOperator(),null);
					vo.add(vo6);
					break;
			case 7: ReceiptPO po7=(ReceiptPO) po.get(i);
					TransferListVO trans=new TransferListVO(po7.getTransfer().get(0).getAccount(),po7.getTransfer().get(0).getMoney(),po7.getTransfer().get(0).getPs());
					GetVO vo7=new GetVO(po7.getNote(), po7.getCustomer().getName(), po7.getOperator(), trans,po7.getTime(),null);
					vo.add(vo7);
					break;
			case 8: PaymentPO po8=(PaymentPO) po.get(i);
					ItemList item=new ItemList(po8.getItem().get(0).getItemName(), po8.getItem().get(0).getMoney(), po8.getItem().get(0).getPs());
					PayVO vo8=new PayVO(po8.getNote(),po8.getOperator(),po8.getAccount().getName(),item,po8.getTime(),null);
					vo.add(vo8);
					break;
			}
		}
		return vo;
	}

	public ArrayList<InvoiceVO> show_refuse() {
		// TODO Auto-generated method stub
		ArrayList<InvoicePO> po=invoice.getRefuse();
		ArrayList<InvoiceVO> vo=new ArrayList<InvoiceVO>();
		int i=0;
		for(i=0;i<po.size();i++){
			switch(po.get(i).getDocType()){
			case 1: SendGiftPO po1=(SendGiftPO) po.get(i);
					SendGiftVO vo1=new SendGiftVO(po1.getNote(), po1.getTime(),"",po1.getCommodity().getName(),po1.getCommodity().getType(),po1.getNumber(),null);
					vo.add(vo1);
					break;
			case 2: ImportPO po2=(ImportPO) po.get(i);
					CommodityListVO com2=new CommodityListVO(po2.getImportGoodList().get(0).getCommodity().getNote(), po2.getImportGoodList().get(0).getCommodity().getName(), po2.getImportGoodList().get(0).getCommodity().getType(), po2.getImportGoodList().get(0).getNumber(), po2.getImportGoodList().get(0).getPrice(), po2.getImportGoodList().get(0).getMoney(), po2.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo2=new ImportMenuVO(po2.getNote(),po2.getCustomer().getName(),po2.getWareHouse(),po2.getOperator(),
							com2,po2.getPs(),po2.getTotalMoney(),po2.getTime(),2,null);
					vo.add(vo2);
					break;
			case 3: Import_ReturnPO po3=(Import_ReturnPO) po.get(i);
					CommodityListVO com3=new CommodityListVO(po3.getImportGoodList().get(0).getCommodity().getNote(), po3.getImportGoodList().get(0).getCommodity().getName(), po3.getImportGoodList().get(0).getCommodity().getType(), po3.getImportGoodList().get(0).getNumber(), po3.getImportGoodList().get(0).getPrice(), po3.getImportGoodList().get(0).getMoney(), po3.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo3=new ImportMenuVO(po3.getNote(),po3.getCustomer().getName(),po3.getWareHouse(),po3.getOperator(),
							com3,po3.getPs(),po3.getTotalMoney(),po3.getTime(),3,null);
					vo.add(vo3);
					break;
			case 4: ExportPO po4=(ExportPO) po.get(i);
					CommodityListVO com4=new CommodityListVO(po4.getExportGoodList().get(0).getCommodity().getNote(), po4.getExportGoodList().get(0).getCommodity().getName(), po4.getExportGoodList().get(0).getCommodity().getType(), po4.getExportGoodList().get(0).getNumber(), po4.getExportGoodList().get(0).getPrice(), po4.getExportGoodList().get(0).getMoney(), po4.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo4=new ExportMenuVO(po4.getNote(),po4.getCustomer().getName(),po4.getClerk(),po4.getOperator(),po4.getWareHouse(),
							com4,po4.getTotalMoneyBefore(),po4.getDiscount(),po4.getVoucher(),
							po4.getTotalMoneyAfter(),po4.getPs(),po4.getTime(),4,null);
					vo.add(vo4);
					break;
			case 5: Export_ReturnPO po5=(Export_ReturnPO) po.get(i);
					CommodityListVO com5=new CommodityListVO(po5.getExportGoodList().get(0).getCommodity().getNote(), po5.getExportGoodList().get(0).getCommodity().getName(), po5.getExportGoodList().get(0).getCommodity().getType(), po5.getExportGoodList().get(0).getNumber(), po5.getExportGoodList().get(0).getPrice(), po5.getExportGoodList().get(0).getMoney(), po5.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo5=new ExportMenuVO(po5.getNote(),po5.getCustomer().getName(),po5.getClerk(),po5.getOperator(),po5.getWareHouse(),
							com5,po5.getTotalMoneyBefore(),po5.getDiscount(),po5.getVoucher(),
							po5.getTotalMoneyAfter(),po5.getPs(),po5.getTime(),5,null);
					vo.add(vo5);
					break;
			case 6: PatchPO po6=(PatchPO) po.get(i);
					PatchVO vo6=new PatchVO(po6.getCommodity().getName(),po6.getCommodity().getType(),po6.getNumber(),po6.getNote(),po6.getTime(),po6.getOperator(),null);
					vo.add(vo6);
					break;
			case 7: ReceiptPO po7=(ReceiptPO) po.get(i);
					TransferListVO trans=new TransferListVO(po7.getTransfer().get(0).getAccount(),po7.getTransfer().get(0).getMoney(),po7.getTransfer().get(0).getPs());
					GetVO vo7=new GetVO(po7.getNote(), po7.getCustomer().getName(), po7.getOperator(), trans,po7.getTime(),null);
					vo.add(vo7);
					break;
			case 8: PaymentPO po8=(PaymentPO) po.get(i);
					ItemList item=new ItemList(po8.getItem().get(0).getItemName(), po8.getItem().get(0).getMoney(), po8.getItem().get(0).getPs());
					PayVO vo8=new PayVO(po8.getNote(),po8.getOperator(),po8.getAccount().getName(),item,po8.getTime(),null);
					vo.add(vo8);
					break;
			}
		}
		return vo;
	}
	
	public ArrayList<InvoiceVO> show_wait() {
		// TODO Auto-generated method stub
		ArrayList<InvoicePO> po=invoice.getWait();
		ArrayList<InvoiceVO> vo=new ArrayList<InvoiceVO>();
		int i=0;
		for(i=0;i<po.size();i++){
			switch(po.get(i).getDocType()){
			case 1: SendGiftPO po1=(SendGiftPO) po.get(i);
					SendGiftVO vo1=new SendGiftVO(po1.getNote(), po1.getTime(),"",po1.getCommodity().getName(),po1.getCommodity().getType(),po1.getNumber(),null);
					vo.add(vo1);
					break;
			case 2: ImportPO po2=(ImportPO) po.get(i);
					CommodityListVO com2=new CommodityListVO(po2.getImportGoodList().get(0).getCommodity().getNote(), po2.getImportGoodList().get(0).getCommodity().getName(), po2.getImportGoodList().get(0).getCommodity().getType(), po2.getImportGoodList().get(0).getNumber(), po2.getImportGoodList().get(0).getPrice(), po2.getImportGoodList().get(0).getMoney(), po2.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo2=new ImportMenuVO(po2.getNote(),po2.getCustomer().getName(),po2.getWareHouse(),po2.getOperator(),
							com2,po2.getPs(),po2.getTotalMoney(),po2.getTime(),2,null);
					vo.add(vo2);
					break;
			case 3: Import_ReturnPO po3=(Import_ReturnPO) po.get(i);
					CommodityListVO com3=new CommodityListVO(po3.getImportGoodList().get(0).getCommodity().getNote(), po3.getImportGoodList().get(0).getCommodity().getName(), po3.getImportGoodList().get(0).getCommodity().getType(), po3.getImportGoodList().get(0).getNumber(), po3.getImportGoodList().get(0).getPrice(), po3.getImportGoodList().get(0).getMoney(), po3.getImportGoodList().get(0).getPs()); 
					ImportMenuVO vo3=new ImportMenuVO(po3.getNote(),po3.getCustomer().getName(),po3.getWareHouse(),po3.getOperator(),
							com3,po3.getPs(),po3.getTotalMoney(),po3.getTime(),3,null);
					vo.add(vo3);
					break;
			case 4: ExportPO po4=(ExportPO) po.get(i);
					CommodityListVO com4=new CommodityListVO(po4.getExportGoodList().get(0).getCommodity().getNote(), po4.getExportGoodList().get(0).getCommodity().getName(), po4.getExportGoodList().get(0).getCommodity().getType(), po4.getExportGoodList().get(0).getNumber(), po4.getExportGoodList().get(0).getPrice(), po4.getExportGoodList().get(0).getMoney(), po4.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo4=new ExportMenuVO(po4.getNote(),po4.getCustomer().getName(),po4.getClerk(),po4.getOperator(),po4.getWareHouse(),
							com4,po4.getTotalMoneyBefore(),po4.getDiscount(),po4.getVoucher(),
							po4.getTotalMoneyAfter(),po4.getPs(),po4.getTime(),4,null);
					vo.add(vo4);
					break;
			case 5: Export_ReturnPO po5=(Export_ReturnPO) po.get(i);
					CommodityListVO com5=new CommodityListVO(po5.getExportGoodList().get(0).getCommodity().getNote(), po5.getExportGoodList().get(0).getCommodity().getName(), po5.getExportGoodList().get(0).getCommodity().getType(), po5.getExportGoodList().get(0).getNumber(), po5.getExportGoodList().get(0).getPrice(), po5.getExportGoodList().get(0).getMoney(), po5.getExportGoodList().get(0).getPs()); 
					ExportMenuVO vo5=new ExportMenuVO(po5.getNote(),po5.getCustomer().getName(),po5.getClerk(),po5.getOperator(),po5.getWareHouse(),
							com5,po5.getTotalMoneyBefore(),po5.getDiscount(),po5.getVoucher(),
							po5.getTotalMoneyAfter(),po5.getPs(),po5.getTime(),5,null);
					vo.add(vo5);
					break;
			case 6: PatchPO po6=(PatchPO) po.get(i);
					PatchVO vo6=new PatchVO(po6.getCommodity().getName(),po6.getCommodity().getType(),po6.getNumber(),po6.getNote(),po6.getTime(),po6.getOperator(),null);
					vo.add(vo6);
					break;
			case 7: ReceiptPO po7=(ReceiptPO) po.get(i);
					TransferListVO trans=new TransferListVO(po7.getTransfer().get(0).getAccount(),po7.getTransfer().get(0).getMoney(),po7.getTransfer().get(0).getPs());
					GetVO vo7=new GetVO(po7.getNote(), po7.getCustomer().getName(), po7.getOperator(), trans,po7.getTime(),null);
					vo.add(vo7);
					break;
			case 8: PaymentPO po8=(PaymentPO) po.get(i);
					ItemList item=new ItemList(po8.getItem().get(0).getItemName(), po8.getItem().get(0).getMoney(), po8.getItem().get(0).getPs());
					PayVO vo8=new PayVO(po8.getNote(),po8.getOperator(),po8.getAccount().getName(),item,po8.getTime(),null);
					vo.add(vo8);
					break;
			}
		}
		return vo;
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
