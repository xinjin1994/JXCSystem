package businesslogic.financialbl;

import java.util.ArrayList;

import po.AllBillPO;
import po.ExportPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.OperatingConditionPO;
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
import vo.bill.*;
import businesslogicservice.financialblservice.FinancialblService;

public class FinancialController implements FinancialblService{
	
	public Financial financial=new Financial();

	public ArrayList<SalesDetailVO> saleList_up(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse) {
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
			String customer_name, String clerk, int warehouse) {
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
					vo=new ImportMenuVO(importpo.getNote(),importpo.getCustomer().getName(),importpo.getWareHouse(),importpo.getOperator(),
							importpo.getImportGoodList().get(0).getCommodity().getName(),importpo.getImportGoodList().get(0).getPs(),importpo.getTotalMoney(),importpo.getTime(),2,importpo.getInvoiceNote());
					break;
					
			case 3: Import_ReturnPO imp_retpo=(Import_ReturnPO) array.get(i);
					vo=new ImportMenuVO(imp_retpo.getNote(),imp_retpo.getCustomer().getName(),imp_retpo.getWareHouse(),imp_retpo.getOperator(),
							imp_retpo.getImportGoodList().get(0).getCommodity().getName(),imp_retpo.getImportGoodList().get(0).getPs(),imp_retpo.getTotalMoney(),imp_retpo.getTime(),3,imp_retpo.getInvoiceNote());
					break;
			case 4: ExportPO exportpo=(ExportPO) array.get(i);
					vo=new ExportMenuVO(exportpo.getNote(),exportpo.getCustomer().getName(),exportpo.getClerk(),exportpo.getOperator(),exportpo.getWareHouse(),
							exportpo.getImportGoodList().get(0).getCommodity().getName(),exportpo.getTotalMoneyBefore(),exportpo.getDiscount(),exportpo.getVoucher(),
							exportpo.getTotalMoneyAfter(),exportpo.getImportGoodList().get(0).getPs(),exportpo.getTime(),4,exportpo.getInvoiceNote());
					break;
			case 5:
			
			}
			
			
			res.add(vo);
		}
		return res;
	}

	public ArrayList<ConditionVO> operatingCondition_up(String time1, String time2) {
		// TODO Auto-generated method stub
		OperatingConditionPO po=financial.operatingCondition(time1, time2);
		ConditionVO con=new ConditionVO(po.getIncome(),po.getGoodIncome(),po.getDiscount(),po.getOutcome(),po.getGoodOutcome());
		
		ArrayList<ConditionVO> vo=new ArrayList<ConditionVO>();
		vo.add(con);
		return vo;
	}

	public int saleListExcel_up(SaleListConditionVO saleList_condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int allBillExcel_up(AllBillConditionVO allBill_condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int operatingConditionExcel_up(String start_time, String end_time) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int redRush_up(AllBillVO allBill) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasPower_up() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getClerk_up() {
		// TODO Auto-generated method stub
		return 0;
	}

}
