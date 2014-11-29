package businesslogic.salesbl;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.ExportMenuVO;
import vo.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService{
	
	public Sales sale=new Sales();

	public String addCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.addCustomer(customerVO);
	}

	public String delCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.delCustomer(customerVO);
	}

	public String updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.updateCustomer(customerVO);
	}

	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.searchCustomer(customerVO);
	}

	public String addImport(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport(importMenuVO);
	}

	public String addImport_Return(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(importMenuVO);
	}

	public String addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(note, number);
	}

	public String addExport(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport(exportMenuVO);
	}

	public String addExport_Return(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(exportMenuVO);
	}

	public String addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(note, number);
	}

}
