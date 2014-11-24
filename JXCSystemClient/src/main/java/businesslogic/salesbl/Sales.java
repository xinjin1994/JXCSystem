package businesslogic.salesbl;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import businesslogic.invoicebl.Invoice;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.salesblservice.SalesblService;
import data.salesdata.SaleDataService_Stub;
import dataservice.salesdataservice.SalesDataService;

public class Sales implements SalesblService, businesslogic.accountbl.SalesInfo,
			businesslogic.financialbl.SalesInfo{
	
	SalesDataService sale=new SaleDataService_Stub();
	public InvoiceInfo invoice=new Invoice();
	SystemlogInfo systemlog=new Systemlog();
	
	public SalesDataService getSale() {
		return sale;
	}
	public void setSale(SalesDataService sale) {
		this.sale = sale;
	}
	
	public String addCustomer(String name, int level, String phone, String zip,
			String mail, int money, String clerk) {
		// TODO Auto-generated method stub
		CustomerPO customer = new CustomerPO(1,name,1, "type",
				"phone", "zip", "mail", 1000, 2000,
				"clerk", "address");
		
		if(sale.addCustomer(customer)){
			systemlog.add("AddCustomer:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String delCustomer(String name) {
		// TODO Auto-generated method stub
		CustomerPO customer = new CustomerPO(1,name,1, "type",
				"phone", "zip", "mail", 1000, 2000,
				"clerk", "address");
		
		if(sale.delCustomer(customer)){
			systemlog.add("DelCustomer:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String updateCustomer(String name, int level, String phone,
			String zip, String mail, int money, String clerk) {
		// TODO Auto-generated method stub
		CustomerPO customer1 = new CustomerPO(1,name,1, "type",
				"phone", "zip", "mail", 1000, 2000,
				"clerk", "address");
		CustomerPO customer2 = new CustomerPO(2,name,2, "type",
				"phone", "zip", "mail", 2000, 4000,
				"clerk", "address");
		
		if(sale.updateCustomer(customer1,customer2)){
			systemlog.add("UpdateCustomer:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String searchCustomer(String word) {
		// TODO Auto-generated method stub
		
		if(sale.findCustomer(word)!=null){
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addImport(String name, int warehouse, String good_name,
			String good_type, String ps, int number) {
		// TODO Auto-generated method stub
		ImportPO im = new ImportPO("2222/2/2",name,good_name,good_type,
				ps, "serialnum", "clerk", "operator",
				warehouse,number,50, 1, 500);
		
		if(invoice.add(im)!=null){
			systemlog.add("AddImport:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addImport_Return(String name, int warehouse,
			String good_name, String good_type, String ps, int number) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO("2222/2/2",name,good_name,good_type,
				ps, "serialnum", "clerk", "operator",
				warehouse,number,50, 1, 500);
		
		if(invoice.add(im_re)!=null){
			systemlog.add("AddImport_Return:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO("2222/2/2","name","good_name","good_type",
				"ps", "serialnum", "clerk", "operator",
				1,number,50, 1, 500);
	
		if(invoice.add(im_re)!=null){
			systemlog.add("AddImport_Return:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addExport(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount) {
		// TODO Auto-generated method stub
		ExportPO ex = new ExportPO("ti",1,2,3,4,"cn","gn","gt","p","sn","c","o",
				5,6,7,8,9);
		
		if(invoice.add(ex)!=null){
			systemlog.add("AddExport:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addExport_Return(String name, int warehouse,
			String good_name, String good_type, String ps, int number,
			int price, int discount) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO("ti",1,2,3,4,"cn","gn","gt","p","sn","c","o",
				5,6,7,8,9);
		
		if(invoice.add(ex_re)!=null){
			systemlog.add("AddExport_Return:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO("ti",1,2,3,4,"cn","gn","gt","p","sn","c","o",
				5,6,7,8,9);
	
		if(invoice.add(ex_re)!=null){
			systemlog.add("AddExport_Return:");
			return "�ɹ�";
		}
		return "ʧ��";
	}
	
	public CustomerPO findCustomer(String name) {
		// TODO Auto-generated method stub
		return sale.findCustomer(name);
	}
	public ImportPO[] getAllImport() {
		// TODO Auto-generated method stub
		return sale.getAllImport();
	}
	public Import_ReturnPO[] getAllImport_Return() {
		// TODO Auto-generated method stub
		return sale.getAllImport_Return();
	}
	public ExportPO[] getAllExport() {
		// TODO Auto-generated method stub
		return sale.getAllExport();
	}
	public Export_ReturnPO[] getAllExport_Return() {
		// TODO Auto-generated method stub
		return sale.getAllExport_Return();
	}

}
