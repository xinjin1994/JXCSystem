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
import businesslogic.accountbl.Account;
import businesslogic.commoditybl.Commodity;
import businesslogic.salesbl.Sales;
import data.invoicedata.InvoiceDataService_Stub;
import dataservice.invoicedataservice.InvoiceDataService;

//-1 未知错误
//1  单据不存在

public class Invoice implements businesslogic.commoditybl.InvoiceInfo,
			businesslogic.accountbl.InvoiceInfo, businesslogic.salesbl.InvoiceInfo{

	public AccountInfo accountInfo;
	public SalesInfo salesInfo;
	public CommodityInfo commodityInfo;
	
	public void setInfo(AccountInfo account,SalesInfo sales, CommodityInfo commodity){
		this.accountInfo=account;
		this.salesInfo=sales;
		this.commodityInfo=commodity;
	}
	
	public InvoiceDataService invoice= new InvoiceDataService_Stub("1","2","3");
	
	public ArrayList<InvoicePO> show() {
		// TODO Auto-generated method stub
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
	
	public InvoicePO findInvoice(String note){
		try {
			return invoice.getInvoice(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int pass(InvoicePO po) {
		int i=0;
		InvoicePO tempInvoice = null;
		try {
			tempInvoice = invoice.getInvoice(po.getNote());
			invoice.passInvoice(po);
			
			if(tempInvoice==null){
				return 1;
			}
			
			switch(tempInvoice.getDocType()){
			
			case 1: SendGiftPO po1=(SendGiftPO) po;
			if(commodityInfo.passSendGift(po1)!=null){
				return 0;
			}
			return -1;
				
			case 2: ImportPO po2=(ImportPO) po;
			if(salesInfo.passImport(po2)!=null){
				commodityInfo.passImport(po2);
				return 0;
			}
			return -1;
			
			case 3: Import_ReturnPO po3=(Import_ReturnPO) po;
			if(salesInfo.passImport_Return(po3)!=null){
				commodityInfo.passImport_Return(po3);
				return 0;
			}
			return -1;
			
			case 4:ExportPO po4=(ExportPO) po;
			if(salesInfo.passExport(po4)!=null){
				commodityInfo.passExport(po4);
				return 0;
			}
			return -1;
			
			case 5:Export_ReturnPO po5=(Export_ReturnPO) po;
			if(salesInfo.passExport_Return(po5)!=null){
				commodityInfo.passExport_Return(po5);
				return 0;
			}
			return -1;
			
			case 6:PatchPO po6=(PatchPO) po;
			if(commodityInfo.passPatch(po6)!=null){
				return 0;
			}
			return -1;
			
			case 7:ReceiptPO po7=(ReceiptPO) po;
			for(i=0;i<po7.getTransfer().size();i++){
				salesInfo.passReceipt(po7);
				if(accountInfo.addReceipt_Data(po7)==null){
					return -1;
				}
			}
			return 0;
		
			case 8:PaymentPO po8=(PaymentPO) po;
			if(accountInfo.addPayment_Data(po8)!=null){
				salesInfo.passPayment(po8);
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
			
			switch(tempInvoice.getDocType()){
			
			case 1: SendGiftPO po1=(SendGiftPO) tempInvoice;
			if(commodityInfo.refuseSendGift(note)!=null){
				return 0;
			}
			return -1;
				
			case 2: ImportPO po2=(ImportPO) tempInvoice;
			if(salesInfo.refuseImport(note)!=null){
				return 0;
			}
			return -1;
			
			case 3: Import_ReturnPO po3=(Import_ReturnPO) tempInvoice;
			if(salesInfo.refuseImport_Return(note)!=null){
				return 0;
			}
			return -1;
			
			case 4:ExportPO po4=(ExportPO) tempInvoice;
			if(salesInfo.refuseExport(note)!=null){
				return 0;
			}
			return -1;
			
			case 5:Export_ReturnPO po5=(Export_ReturnPO) tempInvoice;
			if(salesInfo.refuseExport_Return(note)!=null){
				return 0;
			}
			return -1;
			
			case 6:PatchPO po6=(PatchPO) tempInvoice;
			if(commodityInfo.refusePatch(note)!=null){
				return 0;
			}
			return -1;
			
			case 7:ReceiptPO po7=(ReceiptPO) tempInvoice;
			for(int i=0;i<po7.getTransfer().size();i++){
				if(accountInfo.refuseReceipt_Data(note)==null){
					return -1;
				}
			}
			return 0;
		
			case 8:PaymentPO po8=(PaymentPO) tempInvoice;
			if(accountInfo.refusePayment_Data(note)!=null){
				return 0;
			}
			return -1;
			
			}
			
			
			
			if(invoice.passInvoice(tempInvoice)){
				return 0;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}


	
	public String add(InvoicePO po){
		try {
			po.setCondition(1);
			invoice.addInvoice(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}
	
	public String add(PatchPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		try {
			po.setCondition(1);
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
			po.setCondition(1);
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
			po.setCondition(1);
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
			po.setCondition(1);
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
			po.setCondition(1);
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
			po.setCondition(1);
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
			po.setCondition(1);
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



