package businesslogic.financialbl;

import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import vo.AllBillVO;
import vo.ConditionGetVO;
import vo.ConditionPayVO;
import vo.ConditionVO;
import vo.SalesDetailVO;
import businesslogicservice.financialblservice.FinancialblService;

public class FinancialController implements FinancialblService{
	
	public Financial financial=new Financial();

	public ArrayList<SalesDetailVO> saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, String warehouse) {
		// TODO Auto-generated method stub
		ArrayList<SaleListPO> array=financial.saleList(time1, time2, good_name, good_type, customer_name, clerk, warehouse);
	
		ArrayList<SalesDetailVO> res=new ArrayList<SalesDetailVO>();
		int i=0;
		for(i=0;i<array.size();i++){
			res.add(new SalesDetailVO(array.get(i).time,array.get(i).getCommodity(),array.get(i).getType(),array.get(i).getNumber(),array.get(i).getPrice(),array.get(i).getTotalmoney()));
		}
		
		return res;
	}

	public ArrayList<AllBillVO> allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, String warehouse) {
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
			vo.note=array.get(i).getNote();
			res.add(vo);
		}
		return res;
	}

	public ConditionVO operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
		OperatingConditionPO po=financial.operatingCondition(time1, time2);
		ConditionVO vo=new ConditionVO();
		vo.get=new ConditionGetVO(0, 0, 0, 0, 0, po.getIncome()-po.getDiscount());
		vo.pay=new ConditionPayVO(0, 0, 0, po.getOutcome());
		return vo;
	}

}
