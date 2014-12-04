package businesslogicservice.invoiceblservice;

import java.util.ArrayList;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import vo.InvoiceVO;

//int错误类型：
//-1 未知错误
//1  单据不存在

public interface InvoiceblService {

	//显示所有待审批单据
	public ArrayList<InvoiceVO> show();
	
	//通过审批
	public int pass(String note);
	
	//未通过审批
	public int refuse(String note);
	
	//添加单据
//	public String add(PatchPO po);
//	
//	public String add(ImportPO po);
//	
//	public String add(ExportPO po);
//	
//	public String add(Import_ReturnPO po);
//	
//	public String add(Export_ReturnPO po);
//	
//	public String add(ReceiptPO po);
//	
//	public String add(PaymentPO po);

	
}
