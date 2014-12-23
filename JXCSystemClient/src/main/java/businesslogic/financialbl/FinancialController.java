package businesslogic.financialbl;

import java.util.ArrayList;

import main.ClientStart;
import po.AllBillPO;
import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.OperatingConditionPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SaleListPO;
import po.SendGiftPO;
//import vo.AllBillConditionVO;
//import vo.AllBillVO;
import vo.ConditionVO;
//import vo.ExportMenuVO;
//import vo.ImportMenuVO;
import vo.SaleListConditionVO;
import vo.SalesDetailVO;
import vo.SendGiftVO;
import vo.bill.AllBillConditionVO;
import vo.bill.AllBillVO;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.GetVO;
import vo.bill.ImportMenuVO;
import vo.bill.ItemList;
import vo.bill.PatchVO;
import vo.bill.PayVO;
import vo.bill.TransferListVO;
import businesslogic.userbl.User;
import businesslogicservice.financialblservice.FinancialblService;

public class FinancialController implements FinancialblService{
	

	
	public Financial financial=new Financial();
	
	public FinancialController(){
		financial=ClientStart.financial;
	}
	
	public ArrayList<SalesDetailVO> saleList_up(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, String warehouse) {
		// TODO Auto-generated method stub
		ArrayList<SaleListPO> array=financial.saleList(time1, time2, good_name, good_type, customer_name, clerk, warehouse);
	
		ArrayList<SalesDetailVO> res=new ArrayList<SalesDetailVO>();
		int i=0;
		for(i=0;i<array.size();i++){
			res.add(new SalesDetailVO(array.get(i).time,array.get(i).getCommodity().getName(),array.get(i).getCommodity().getType(),array.get(i).getNumber(),(double) array.get(i).getPrice(),(double) array.get(i).getTotalmoney()));
		}
		
		return res;
	}

	public ArrayList<AllBillVO> allBill_up(String time1, String time2, String note_type,
			String customer_name, String clerk, String warehouse) {
		// TODO Auto-generated method stub
		ArrayList<AllBillPO> array=financial.allBill(time1, time2, note_type, customer_name, clerk, warehouse);
		ArrayList<AllBillVO> res=new ArrayList<AllBillVO>();
		AllBillVO vo=null;
		int i=0;
		for(i=0;i<array.size();i++){
			switch(array.get(i).getDocType()){
			
			case 1: SendGiftPO gift=(SendGiftPO) array.get(i);
					vo= new SendGiftVO(gift.getNote(), gift.getTime(),null,gift.getCommodity().getName(),gift.getCommodity().getType(),gift.getNumber(),gift.getInvoiceNote()); 
					break;
			
			case 2: ImportPO importpo=(ImportPO) array.get(i);
					CommodityPO com=importpo.getImportGoodList().get(0).getCommodity();
					CommodityListVO comList=new CommodityListVO(com.getNote(), com.getName(), com.getType(), importpo.getImportGoodList().get(0).getNumber(), importpo.getImportGoodList().get(0).getPrice(), importpo.getImportGoodList().get(0).getMoney(), importpo.getImportGoodList().get(0).getPs()); 
					vo=new ImportMenuVO(importpo.getNote(),importpo.getCustomer().getName(),importpo.getWareHouse(),importpo.getOperator(),
							comList,importpo.getImportGoodList().get(0).getPs(),importpo.getTotalMoney(),importpo.getTime(),2,importpo.getInvoiceNote());
					break;
					
			case 3: Import_ReturnPO imp_retpo=(Import_ReturnPO) array.get(i);
					CommodityPO com1=imp_retpo.getImportGoodList().get(0).getCommodity();
					CommodityListVO comList1=new CommodityListVO(com1.getNote(), com1.getName(), com1.getType(), imp_retpo.getImportGoodList().get(0).getNumber(), imp_retpo.getImportGoodList().get(0).getPrice(), imp_retpo.getImportGoodList().get(0).getMoney(), imp_retpo.getImportGoodList().get(0).getPs()); 
					vo=new ImportMenuVO(imp_retpo.getNote(),imp_retpo.getCustomer().getName(),imp_retpo.getWareHouse(),imp_retpo.getOperator(),
							comList1,imp_retpo.getImportGoodList().get(0).getPs(),imp_retpo.getTotalMoney(),imp_retpo.getTime(),3,imp_retpo.getInvoiceNote());
					break;
			
			case 4: ExportPO exportpo=(ExportPO) array.get(i);
					CommodityPO com2=exportpo.getExportGoodList().get(0).getCommodity();
					CommodityListVO comList2=new CommodityListVO(com2.getNote(), com2.getName(), com2.getType(), exportpo.getExportGoodList().get(0).getNumber(), exportpo.getExportGoodList().get(0).getPrice(), exportpo.getExportGoodList().get(0).getMoney(), exportpo.getExportGoodList().get(0).getPs());
					vo=new ExportMenuVO(exportpo.getNote(),exportpo.getCustomer().getName(),exportpo.getClerk(),exportpo.getOperator(),exportpo.getWareHouse(),
							comList2,exportpo.getTotalMoneyBefore(),exportpo.getDiscount(),exportpo.getVoucher(),
							exportpo.getTotalMoneyAfter(),exportpo.getExportGoodList().get(0).getPs(),exportpo.getTime(),4,exportpo.getInvoiceNote());
					break;
			
			case 5: Export_ReturnPO exp_retpo=(Export_ReturnPO) array.get(i);
					CommodityPO com3=exp_retpo.getExportGoodList().get(0).getCommodity();
					CommodityListVO comList3=new CommodityListVO(com3.getNote(), com3.getName(), com3.getType(), exp_retpo.getExportGoodList().get(0).getNumber(), exp_retpo.getExportGoodList().get(0).getPrice(), exp_retpo.getExportGoodList().get(0).getMoney(), exp_retpo.getExportGoodList().get(0).getPs());
					vo=new ExportMenuVO(exp_retpo.getNote(),exp_retpo.getCustomer().getName(),exp_retpo.getClerk(),exp_retpo.getOperator(),exp_retpo.getWareHouse(),
							comList3,exp_retpo.getTotalMoneyBefore(),exp_retpo.getDiscount(),exp_retpo.getVoucher(),
							exp_retpo.getTotalMoneyAfter(),exp_retpo.getExportGoodList().get(0).getPs(),exp_retpo.getTime(),5,exp_retpo.getInvoiceNote());
					break;
			
			case 6: PatchPO patch=(PatchPO) array.get(i);
					vo=new PatchVO(patch.getCommodity().getName(),patch.getCommodity().getType(),patch.getNumber(),patch.getNote(),patch.getTime(),patch.getOperator(),patch.getInvoiceNote());
					break;
					
			case 7: ReceiptPO receipt=(ReceiptPO) array.get(i);
					TransferListVO transfer=new TransferListVO(receipt.getTransfer().get(0).getAccount(),receipt.getTransfer().get(0).getMoney(),receipt.getTransfer().get(0).getPs());
					vo=new GetVO(receipt.getNote(), receipt.getCustomer().getName(), receipt.getOperator(), transfer,receipt.getTime(),receipt.getInvoiceNote());
					break;
					
			case 8: PaymentPO payment=(PaymentPO) array.get(i);
					ItemList item=new ItemList(payment.getItem().get(0).getItemName(), payment.getItem().get(0).getMoney(), payment.getItem().get(0).getPs());
					vo=new PayVO(payment.getNote(),payment.getOperator(),payment.getAccount().getName(),item,payment.getTime(),payment.getInvoiceNote());
					break;
					
			case 9: continue;
			
			case 10: continue;
			
			}
			
			
			res.add(vo);
		}
		return res;
	}

	public ArrayList<ConditionVO> operatingCondition_up(String time1, String time2) {
		// TODO Auto-generated method stub
		ArrayList<OperatingConditionPO> po=financial.operatingCondition(time1, time2);
		ArrayList<ConditionVO> vo=new ArrayList<ConditionVO>();
		ConditionVO con;
		for(int i=0;i<po.size();i++){
			con=new ConditionVO(po.get(i).getOldNote(),po.get(i).getIncome(),po.get(i).getGoodIncome(),po.get(i).getDiscount(),po.get(i).getOutcome(),po.get(i).getGoodOutcome());
			vo.add(con);
		}
		return vo;
	}
	
	public int saleListExcel_up(ArrayList<SaleListConditionVO> saleList_condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int allBillExcel_up(ArrayList<AllBillConditionVO> allBill_condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int operatingConditionExcel_up(ArrayList<ConditionVO> operating_condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int redRush_up(AllBillVO allBill) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasPower_up() {
		// TODO Auto-generated method stub
//		if(User.operator==4||User.operator==5){
//			return true;
//		}
		return false;
	}

	public String getOperator_up() {
		// TODO Auto-generated method stub
		return User.operator;
	}



}
