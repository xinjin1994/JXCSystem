package businesslogic.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogic.invoicebl.Invoice;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.salesblservice.SalesblService;
import data.salesdata.SaleDataService_Stub;
import dataservice.salesdataservice.SalesDataService;
//1 客户名称重复
//2 客户名称不存在
//-1 未知错误
public class Sales implements businesslogic.accountbl.SalesInfo,
			businesslogic.financialbl.SalesInfo{
	
	public SalesDataService sale=new SaleDataService_Stub();
	public InvoiceInfo invoice=new Invoice();
	SystemlogInfo systemlog=new Systemlog();
	
	public SalesDataService getSale() {
		return sale;
	}
	public void setSale(SalesDataService sale) {
		this.sale = sale;
	}
	
	public int addCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		
		
		try {
			if(sale.findCustomer(customerVO.cusName)!=null){
				return 1;
			}
			
			CustomerPO customer = new CustomerPO(customerVO.id,customerVO.cusName,customerVO.level, customerVO.classification,
				customerVO.tel, customerVO.zipCode, customerVO.ezipCode, customerVO.shouldGet, customerVO.mostOwe,
				customerVO.person, customerVO.address);
			
			if(sale.addCustomer(customer)){
				systemlog.add_up("AddCustomer:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		CustomerPO customer = new CustomerPO("1","name",1, false,
				"phone", "zip", "mail", 1000, 2000,
				"clerk", "address");
		
		try {
			if(sale.delCustomer(customer)){
				systemlog.add_up("DelCustomer:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		CustomerPO customer1 = new CustomerPO("1","name",1, false,
				"phone", "zip", "mail", 1000, 2000,
				"clerk", "address");
		CustomerPO customer2 = new CustomerPO("2","name",2, false,
				"phone", "zip", "mail", 2000, 4000,
				"clerk", "address");
		
		try {
			if(sale.updateCustomer(customer1,customer2)){
				systemlog.add_up("UpdateCustomer:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		
		try {
			if(sale.findCustomer("word")!=null){
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		ImportPO im = new ImportPO(null, null, null, null, null, null, 0);
		
		if(invoice.add(im)!=null){
			systemlog.add_up("AddImport:");
			return 0;
		}
		return -1;
	}

	public int addImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO(null, null, null, null, null, null, 0, null);
		
		if(invoice.add(im_re)!=null){
			systemlog.add_up("AddImport_Return:");
			return 0;
		}
		return -1;
	}

	public int addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO(null, null, note, note, note, note, number, note);
	
		if(invoice.add(im_re)!=null){
			systemlog.add_up("AddImport_Return:");
			return 0;
		}
		return -1;
	}

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		ExportPO ex = new ExportPO(null, null, null, null, null, null, 0, 0, 0, 0);
		
		if(invoice.add(ex)!=null){
			systemlog.add_up("AddExport:");
			return 0;
		}
		return -1;
	}

	public int addExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO(null, null, null, null, null, null, 0, 0, 0, 0, null);
		
		if(invoice.add(ex_re)!=null){
			systemlog.add_up("AddExport_Return:");
			return 0;
		}
		return -1;
	}

	public int addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO(null, null, note, note, note, note, number, number, number, number, note);
	
		if(invoice.add(ex_re)!=null){
			systemlog.add_up("AddExport_Return:");
			return 0;
		}
		return -1;
	}
	
	public CustomerPO findCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			return sale.findCustomer(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ImportPO> getAllImport() {
		// TODO Auto-generated method stub
		try {
			return sale.getAllImport();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		// TODO Auto-generated method stub
		try {
			return sale.getAllImport_Return();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ExportPO> getAllExport() {
		// TODO Auto-generated method stub
		try {
			return sale.getAllExport();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		// TODO Auto-generated method stub
		try {
			return sale.getAllExport_Return();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<CustomerPO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public CustomerPO searchExactCustomer_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<CustomerPO> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	public String delCustomer(CustomerVO customerVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public String updateCustomer(CustomerVO customerVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
//	public String addImport(ImportMenuVO importMenuVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public String addImport_Return(ImportMenuVO importMenuVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	public String addExport(ExportMenuVO exportMenuVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public String addExport_Return(ExportMenuVO exportMenuVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
