package businesslogic.salesbl;

import java.util.ArrayList;

import po.CommodityPO;
import po.CustomerPO;
import po.ExportGoodPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportGoodPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.UserPO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService {

	public Sales sale = new Sales();

	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> result = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.searchFuzzyCustomer_up(name);
		for (int i = 0; i < po.size(); i++) {
			CustomerVO vo = new CustomerVO(po.get(i).getId(), po.get(i)
					.getType(), po.get(i).getLevel(), po.get(i).getName(), po
					.get(i).getPhone(), po.get(i).getAddress(), po.get(i)
					.getZip(), po.get(i).getMail(), po.get(i).getAmount(), po
					.get(i).getMoney(), po.get(i).getClerk());
			result.add(vo);
		}
		return result;
	}

	public CustomerVO searchExactCustomer_up(String name) {
		// TODO Auto-generated method stub
		CustomerPO po = sale.searchExactCustomer_up(name);
		CustomerVO result = new CustomerVO(po.getId(), po.getType(),
				po.getLevel(), po.getName(), po.getPhone(), po.getAddress(),
				po.getZip(), po.getMail(), po.getAmount(), po.getMoney(),
				po.getClerk());
		return result;
	}

	public int addCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message = sale.addCustomer_up(customerVO);
		return message;
	}

	public int delCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message = sale.delCustomer_up(customerVO);
		return message;
	}

	public int updateCustomer_up(CustomerVO vo1, CustomerVO vo2) { // 这里的参数个数有问题
		// TODO Auto-generated method stub
		int message = sale.updateCustomer(vo1, vo2); // 这里的对应方法名有问题
		return message;
	}

	// public int updateCustomer(CustomerVO customerVO) {
	// // TODO Auto-generated method stub
	// int message=sale.updateCustomer(customerVO);
	// return message;
	// }

	// public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO) {
	// // TODO Auto-generated method stub
	// ArrayList<CustomerVO> result=sale.searchCustomer(customerVO);
	// return result;
	// }

	public int addImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(
				importMenuVO.commodityList.name,
				importMenuVO.commodityList.type);

		ImportGoodPO importGoodPO = new ImportGoodPO(commodityPO,
				importMenuVO.commodityList.num,
				importMenuVO.commodityList.price,
				importMenuVO.commodityList.total,
				importMenuVO.commodityList.remark);

		ArrayList<ImportGoodPO> importGood = new ArrayList<ImportGoodPO>();

		importGood.add(importGoodPO);

		UserPO user = new UserPO(null, null, 0, null); // 这里有问题

		CustomerPO customerPO = new CustomerPO(importMenuVO.supplier, null, 0,
				false, null, null, null, 0, 0, null, null); // 这里也有问题

		ImportPO imp = new ImportPO(customerPO, importGood,
				importMenuVO.remark, importMenuVO.operator, user.getName(),
				importMenuVO.warehouse, importMenuVO.total);

		int message = sale.addImport_up(imp);
		return message;
	}

	public int addImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(
				importMenuVO.commodityList.name,
				importMenuVO.commodityList.type);

		ImportGoodPO importGoodPO = new ImportGoodPO(commodityPO,
				importMenuVO.commodityList.num,
				importMenuVO.commodityList.price,
				importMenuVO.commodityList.total,
				importMenuVO.commodityList.remark);

		ArrayList<ImportGoodPO> importGood = new ArrayList<ImportGoodPO>();

		importGood.add(importGoodPO);

		UserPO user = new UserPO(null, null, 0, null); // 这里有问题

		CustomerPO customerPO = new CustomerPO(importMenuVO.supplier, null, 0,
				false, null, null, null, 0, 0, null, null); // 这里也有问题

		Import_ReturnPO imp = new Import_ReturnPO(customerPO, importGood,
				importMenuVO.remark, importMenuVO.operator, user.getName(),
				importMenuVO.warehouse, importMenuVO.total, null);

		int message = sale.addImport_Return_up(imp);

		return message;
	}

	// public int addImport_Return(String note, int number) {
	// // TODO Auto-generated method stub
	// int message=sale.addImport_Return(note, number);
	// return message;
	// }

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub

		CommodityPO commodityPO = new CommodityPO(null, null);
		ExportGoodPO exportGoodPO = new ExportGoodPO(null, 0, 0, 0, null);
		ArrayList<ExportGoodPO> exportGood = new ArrayList<ExportGoodPO>();
		exportGood.add(exportGoodPO);
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		ExportPO ex = new ExportPO(null, null, null, null, null, null, 0, 0, 0,
				0);
		int message = sale.addExport_up(ex);
		return message;

	}

	public int addExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(null, null);
		ExportGoodPO exportGoodPO = new ExportGoodPO(null, 0, 0, 0, null);
		ArrayList<ExportGoodPO> exportGood = new ArrayList<ExportGoodPO>();
		exportGood.add(exportGoodPO);
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		Export_ReturnPO ex = new Export_ReturnPO(null, null, null, null, null,
				null, 0, 0, 0, 0, null);

		int message = sale.addExport_Return_up(ex);
		return message;
	}

	// public int addExport_Return(String note, int number) {
	// // TODO Auto-generated method stub
	// int message=sale.addExport_Return(note, number);
	// return message;
	// }

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		ArrayList<CommodityVO> commodityVO = new ArrayList<CommodityVO>();
		CommodityPO po = sale.getAllCommodity();
		CommodityVO vo = new CommodityVO(po.getNote(), po.getName(),
				po.getType(), po.getNumber(), po.getIn_price(),
				po.getOut_price(), po.getRecent_in_price(),
				po.getRecent_out_price(), po.warn);
		commodityVO.add(vo);
		return commodityVO;
	}

	public CommodityVO getCommodity_up(CommodityVO vo) {//这里有问题~
		// TODO Auto-generated method stub
		CommodityPO po = sale.getCommodity(vo.name,vo.id);
		
		CommodityVO commodity = new CommodityVO(po.getNote(), po.getName(),
				po.getType(), po.getNumber(), po.getIn_price(),
				po.getOut_price(), po.getRecent_in_price(),
				po.getRecent_out_price(), po.warn);

		return commodity;
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
