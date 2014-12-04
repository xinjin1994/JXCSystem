package businesslogic.salesbl;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.CustomerVO;
import vo.ExportMenuVO;
import vo.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService{
	
	public Sales sale=new Sales();

	public int addCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.addCustomer_up(customerVO);
	}

	public int delCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.delCustomer_up(customerVO);
	}

	public int updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.updateCustomer(customerVO);
	}

	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return sale.searchCustomer(customerVO);
	}

	public int addImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport_up(importMenuVO);
	}

	public int addImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return sale.addImport_Return_up(importMenuVO);
	}

	public int addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(note, number);
	}

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport_up(exportMenuVO);
	}

	public int addExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return sale.addExport_Return_up(exportMenuVO);
	}

	public int addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(note, number);
	}

	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerVO searchExactCustomer_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateCustomer_up(CustomerVO vo1, CustomerVO vo2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityVO getCommodity_up(CommodityVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CustomerVO> getAllCustomer_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerVO getCustomer_up(CustomerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CustomerVO> getAllImportCustomer_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CustomerVO> getAllExportCustomer_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getClerk_up() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDiscount_up(int money, int level) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getVoucher_up(int money, int level) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CommodityVO getProGift_up(int money, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOtherPromotion_up() {
		// TODO Auto-generated method stub
		return null;
	}

}
