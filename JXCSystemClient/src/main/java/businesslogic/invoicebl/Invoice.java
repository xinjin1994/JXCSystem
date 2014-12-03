package businesslogic.invoicebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.InvoicePO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SendGiftPO;
import data.invoicedata.InvoiceDataService_Stub;
import dataservice.invoicedataservice.InvoiceDataService;

//-1 未知错误
//1  单据不存在
//2  

public class Invoice implements businesslogic.commoditybl.InvoiceInfo,
			businesslogic.accountbl.InvoiceInfo, businesslogic.salesbl.InvoiceInfo{

	public AccountInfo accountInfo;
	public SalesInfo salesInfo;
	public CommodityInfo commodityInfo;
	
	public InvoiceDataService invoice;
	
	public ArrayList<InvoicePO> show() {
		// TODO Auto-generated method stub
		InvoiceDataService invoice= new InvoiceDataService_Stub("1","2","3");
		try {
			
			ArrayList<InvoicePO> po=invoice.getAllInvoice();
			if(po!=null){
				return po;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<InvoicePO>();
	}

	public int pass(String note) {
		
		InvoicePO tempInvoice = null;
		try {
			tempInvoice = invoice.getInvoice(note);
			
			if(tempInvoice==null){
				return 1;
			}
			
			switch(tempInvoice.getInvoiceType()){
			
			case 1: SendGiftPO po1=(SendGiftPO) tempInvoice;
			if(commodityInfo.addGood_Data(po1)!=null){
				return 0;
			}
			return -1;
				
			case 2: ImportPO po2=(ImportPO) tempInvoice;
			if(salesInfo.addImport(po2)!=null){
				return 0;
			}
			return -1;
			
			case 3: Import_ReturnPO po3=(Import_ReturnPO) tempInvoice;
			if(salesInfo.addImport_Return(po3)!=null){
				return 0;
			}
			return -1;
			
			case 4:ExportPO po4=(ExportPO) tempInvoice;
			if(salesInfo.addExport(po4)!=null){
				return 0;
			}
			return -1;
			
			case 5:Export_ReturnPO po5=(Export_ReturnPO) tempInvoice;
			if(salesInfo.addExport_Return(po5)!=null){
				return 0;
			}
			return -1;
			
			case 6:PatchPO po6=(PatchPO) tempInvoice;
			if(commodityInfo.addPatch_Data(po6)!=null){
				return 0;
			}
			return -1;
			
			case 7:ReceiptPO po7=(ReceiptPO) tempInvoice;
			if(accountInfo.addAccount_Data(po7.getName(), po7.getTotal())!=null){
				return 0;
			}
			return -1;
			
			case 8:PaymentPO po8=(PaymentPO) tempInvoice;
			if(accountInfo.addAccount_Data(po8.getName(),-po8.getTotal())!=null){
				return 0;
			}
			return -1;
			
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int refuse(String note) {
		
		InvoicePO tempInvoice=null;
		try {
			tempInvoice = invoice.getInvoice(note);
			
			if(tempInvoice==null){
				return 1;
			}
			
			if(invoice.delInvoice(tempInvoice)){
				return 0;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}


	public String add(PatchPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}//���籨��

	public String add(ImportPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

	public String add(ExportPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

	public String add(Import_ReturnPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

	public String add(Export_ReturnPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

	public String add(ReceiptPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

	public String add(PaymentPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			invoice.addInvoice(invoicePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "�ɹ�";
	}

//	public String add(CommodityPO po) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}



