package businesslogic.invoicebl;

import java.util.ArrayList;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.InvoicePO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import vo.InvoiceVO;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class InvoiceController implements InvoiceblService{
	
	public Invoice invoice=new Invoice();

	public ArrayList<InvoiceVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<InvoicePO> po=invoice.show();
		ArrayList<InvoiceVO> vo=new ArrayList<InvoiceVO>();
		int i=0;
		for(i=0;i<po.size();i++){
			InvoiceVO lin=new InvoiceVO(po.get(i).getInvoiceNote(),po.get(i).getNote(),po.get(i).getInvoiceType(),"");
			vo.add(lin);
		}
		return vo;
	}

	public int pass(String note) {
		// TODO Auto-generated method stub
		return invoice.pass(note);
	}

	public int refuse_up(String note) {
		// TODO Auto-generated method stub
		return invoice.refuse(note);
	}

	public int pass_up(InvoiceVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
