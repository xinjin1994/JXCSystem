package businesslogic.financialbl;

import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import vo.AllBillConditionVO;
import vo.AllBillVO;
import vo.ConditionGetVO;
import vo.ConditionPayVO;
import vo.ConditionVO;
import vo.SaleListConditionVO;
import vo.SalesDetailVO;
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
		int i=0;
		for(i=0;i<array.size();i++){
			AllBillVO vo=new AllBillVO();
			vo.importList =array.get(i).getImportList();
			vo.import_ReturnList = array.get(i).getImport_ReturnList();
			vo.exportList = array.get(i).getExportList();
			vo.export_ReturnList =array.get(i).getExport_ReturnList();
			vo.paymentList =array.get(i).getPaymentList();
			vo.receiptList =array.get(i).getReceiptList();
			vo.patch=array.get(i).getPatch();
			vo.gift=array.get(i).getGift();
			vo.bill_note=array.get(i).getNote();
			res.add(vo);
		}
		return res;
	}

	public ConditionVO operatingCondition_up(String time1, String time2) {
		// TODO Auto-generated method stub
		OperatingConditionPO po=financial.operatingCondition(time1, time2);
		ConditionVO vo=new ConditionVO();
		vo.get=new ConditionGetVO(0, 0, 0, 0, 0, po.getIncome()-po.getDiscount());
		vo.pay=new ConditionPayVO(0, 0, 0, po.getOutcome());
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

	public AllBillVO getPassList() {
		// TODO Auto-generated method stub
		return null;
	}

	public AllBillVO getRefuseList() {
		// TODO Auto-generated method stub
		return null;
	}

}
