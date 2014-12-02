package businesslogic.salesbl;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.ExportMenuVO;
import vo.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService{
	
	public Sales sale=new Sales();

	public int addCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.addCustomer(customerVO);
	}

	public int delCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.delCustomer(customerVO);
	}

	public int updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.updateCustomer(customerVO);
	}

	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.searchCustomer(customerVO);
	}

	public int addImport(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport(importMenuVO);
	}

	public int addImport_Return(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(importMenuVO);
	}

	public int addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(note, number);
	}

	public int addExport(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport(exportMenuVO);
	}

	public int addExport_Return(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(exportMenuVO);
	}

	public int addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(note, number);
	}

}
