package businesslogic.salesbl;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService{
	
	public Sales sale=new Sales();

	public int addCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message=sale.addCustomer_up(customerVO);
		
		return message;
	}

	public int delCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message=sale.delCustomer_up(customerVO);
		
		return message;
	}

	public int updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message=sale.updateCustomer(customerVO);
		return message;
	}

	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> result=sale.searchCustomer(customerVO);
		return result;
	}

	public int addImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		int message=sale.addImport_up(importMenuVO);
		return message;
	}

	public int addImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		int message= sale.addImport_Return_up(importMenuVO);
		
		return message;
	}

	public int addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		int message=sale.addImport_Return(note, number);
		return message;
	}

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		int message=sale.addExport_up(exportMenuVO);
		return message;
	}

	public int addExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		int message=sale.addExport_Return_up(exportMenuVO);
		return message;
	}

	public int addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		int message=sale.addExport_Return(note, number);
		return message;
	}

	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> result=sale.searchFuzzyCustomer_up(name);
		return result;
	}

	public CustomerVO searchExactCustomer_up(String name) {
		// TODO Auto-generated method stub
		CustomerVO result=sale.searchExactCustomer_up(name);
		return result;
	}

	public int updateCustomer_up(CustomerVO vo1, CustomerVO vo2) {       //这里的参数个数有问题
		// TODO Auto-generated method stub
		int message=sale.updateCustomer(vo1);                            //这里的对应方法名有问题
		return message;
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

	public String getImportNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImport_ReturnNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExportNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExport_ReturnNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchImportNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchExportNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getImport_ReturnMaxNumber_up(String old_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getExport_ReturnMaxNumber_up(String old_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getClerkDiscount_up() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addDraftImport_up(ImportMenuVO impoerMenuVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchDraftImport_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addDraftImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_Return_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchDraftImport_Return_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addDraftExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchDraftExport_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addDraftExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_Return_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchDraftExport_Return_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCustomerNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchImportNote_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchExportNote_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityVO getCommodity_up(String name, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
