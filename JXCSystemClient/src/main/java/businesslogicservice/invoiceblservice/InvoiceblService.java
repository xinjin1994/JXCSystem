package businesslogicservice.invoiceblservice;

import java.util.ArrayList;

import vo.InvoiceVO;

//int错误类型：
//-1 未知错误
//1  单据不存在

public interface InvoiceblService {

	//显示所有待审批单据
	public ArrayList<InvoiceVO> show_up();
	
	//显示所有审批通过单据
	public ArrayList<InvoiceVO> show_pass();
	//显示所有审批拒绝的单据
	public ArrayList<InvoiceVO> show_refuse();
	
	//通过审批
	public int pass_up(InvoiceVO vo);
	public int pass_up(ArrayList<InvoiceVO> vo);
	
	//未通过审批
	public int refuse_up(String note);
	public int refuseInvoice_up(String invoice_note);
	
	//根据编号查找单据信息，上面是根据单据本身编号查找，下面是根据Invoice编号查找
	public InvoiceVO searchNote_up(String note);
	public InvoiceVO searchInvoiceNote_up(String invoice_note);
	
	
	
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
