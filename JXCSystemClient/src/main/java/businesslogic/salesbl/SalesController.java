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
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService {

	public Sales sale = new Sales();

	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> result = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.searchFuzzyCustomer(name);
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
		CustomerPO po = sale.searchExactCustomer(name);
		CustomerVO result = new CustomerVO(po.getId(), po.getType(),
				po.getLevel(), po.getName(), po.getPhone(), po.getAddress(),
				po.getZip(), po.getMail(), po.getAmount(), po.getMoney(),
				po.getClerk());
		return result;
	}

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
		UserPO user = new UserPO(null, null, 0, null);
		CustomerPO customerPO = new CustomerPO(importMenuVO.supplier, null, 0,
				false, null, null, null, 0, 0, null, null);
		ImportPO imp = new ImportPO(customerPO, importGood,
				importMenuVO.remark, importMenuVO.operator, user.getName(),
				importMenuVO.warehouse, importMenuVO.total);
		int message = sale.addImport(imp);
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
		int message = sale.addImport_Return(imp);
		return message;
	}

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(null, null);
		ExportGoodPO exportGoodPO = new ExportGoodPO(null, 0, 0, 0, null);
		ArrayList<ExportGoodPO> exportGood = new ArrayList<ExportGoodPO>();
		exportGood.add(exportGoodPO);
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		ExportPO ex = new ExportPO(null, null, null, null, null, null, 0, 0, 0,
				0);
		int message = sale.addExport(ex);
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
		int message = sale.addExport_Return(ex);
		return message;
	}

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		ArrayList<CommodityVO> commodityVO = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> po = sale.getAllCommodity();
		for(int i=0;i<po.size();i++){
			CommodityVO vo = new CommodityVO(po.get(i).getNote(), po.get(i).getName(),
				po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(),
				po.get(i).getOut_price(), po.get(i).getRecent_in_price(),
				po.get(i).getRecent_out_price(), po.get(i).warn);
			commodityVO.add(vo);
		}		
		return commodityVO;
	}

	public ArrayList<CustomerVO> getAllCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i, new CustomerVO(null, false, i, null, null, null,
					null, null, i, i, null));
		}
		return customerVO;
	}

	public CustomerVO getCustomer_up(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO po = sale.getCustomer(vo.cusName, vo.id);
		CustomerVO customer = new CustomerVO(null, false, 0, null, null, null,
				null, null, 0, 0, null);
		return customer;
	}

	public ArrayList<CustomerVO> getAllImportCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllImportCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i, new CustomerVO(null, false, i, null, null, null,
					null, null, i, i, null));
		}
		return customerVO;
	}

	public ArrayList<CustomerVO> getAllExportCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllExportCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i, new CustomerVO(null, false, i, null, null, null,
					null, null, i, i, null));
		}
		return customerVO;
	}

	public int addDraftImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(null, null, null, 0, 0, null,
				0, 0, 0);
		ImportGoodPO importGood = new ImportGoodPO(commodity, 0, 0, 0, null);
		ArrayList<ImportGoodPO> importGoodPO = new ArrayList<ImportGoodPO>();
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		ImportPO importPO = new ImportPO(null, null, null, null, null, null, 0);
		importPO.setCondition(0);
		importPO.setNote(importMenuVO.note);
		int message = sale.addDraftImport(importPO);
		return message;
	}

	public int addDraftExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(null, null, null, 0, 0, null,
				0, 0, 0);
		ExportGoodPO exportGood = new ExportGoodPO(commodity, 0, 0, 0, null);
		ArrayList<ExportGoodPO> exportGoodPO = new ArrayList<ExportGoodPO>();
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		Export_ReturnPO export_ReturnPO = new Export_ReturnPO(null, null, null,
				null, null, null, 0, 0, 0, 0, null);
		export_ReturnPO.setCondition(0);
		export_ReturnPO.setNote(exportMenuVO.note);
		int message = sale.addDraftExport_Return(export_ReturnPO);
		return message;
	}

	public int addDraftImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(null, null, null, 0, 0, null,
				0, 0, 0);
		ImportGoodPO importGood = new ImportGoodPO(commodity, 0, 0, 0, null);
		ArrayList<ImportGoodPO> importGoodPO = new ArrayList<ImportGoodPO>();
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		Import_ReturnPO import_ReturnPO = new Import_ReturnPO(null, null, null,
				null, null, null, 0, null);

		import_ReturnPO.setCondition(0);
		import_ReturnPO.setNote(importMenuVO.note);
		int message = sale.addDraftImport_Return(import_ReturnPO);
		return message;
	}

	public int addDraftExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(null, null, null, 0, 0, null,
				0, 0, 0);
		ExportGoodPO exportGood = new ExportGoodPO(commodity, 0, 0, 0, null);
		ArrayList<ExportGoodPO> exportGoodPO = new ArrayList<ExportGoodPO>();
		CustomerPO customerPO = new CustomerPO(null, 0, false, null);
		ExportPO exportPO = new ExportPO(null, null, null, null, null, null, 0,
				0, 0, 0);

		exportPO.setCondition(0);
		exportPO.setNote(exportMenuVO.note);
		int message = sale.addDraftExport(exportPO);
		return message;
	}

	public int addCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message = sale.addCustomer(customerVO);
		return message;
	}

	public int delCustomer_up(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		int message = sale.delCustomer(customerVO);
		return message;
	}

	public int updateCustomer_up(CustomerVO vo1, CustomerVO vo2) {
		// TODO Auto-generated method stub
		int message = sale.updateCustomer(vo1, vo2);
		return message;
	}

	public int getClerk_up() {
		// TODO Auto-generated method stub
		return sale.getClerk();
	}

	public int getDiscount_up(int money, int level) {
		// TODO Auto-generated method stub
		return sale.getDiscount();
	}

	public int getVoucher_up(int money, int level) {
		// TODO Auto-generated method stub
		return sale.getVoucher();
	}

	public String getOtherPromotion_up() {
		// TODO Auto-generated method stub
		return sale.getOtherPromotion();
	}

	public String getImportNote_up() {
		// TODO Auto-generated method stub
		return sale.getImportNote();
	}

	public String getImport_ReturnNote_up() {
		// TODO Auto-generated method stub
		return sale.getImport_ReturnNote();
	}

	public String getExportNote_up() {
		// TODO Auto-generated method stub
		return sale.getExportNote();
	}

	public String getExport_ReturnNote_up() {
		// TODO Auto-generated method stub
		return sale.getExport_ReturnNote();
	}

	public int getImport_ReturnMaxNumber_up(String old_note) {
		// TODO Auto-generated method stub
		return sale.getImport_ReturnMaxNumber(old_note);
	}

	public int getExport_ReturnMaxNumber_up(String old_note) {
		// TODO Auto-generated method stub
		return sale.getExport_ReturnMaxNumber(old_note);
	}

	public int getClerkDiscount_up() {
		// TODO Auto-generated method stub
		return sale.getClerkDiscount();
	}

	public String getCustomerNote_up() {
		// TODO Auto-generated method stub
		return sale.getCustomerNote();
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_up() {
		// TODO Auto-generated method stub
		return sale.getAllDraftImport();
	}

	public ImportMenuVO searchDraftImport_up(String note) {
		// TODO Auto-generated method stub
		ImportPO po=sale.searchDraftImport(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ImportMenuVO importMenu=new ImportMenuVO(note, note, note, note, commodityList, note, 0, note, 0, note);
		return importMenu;
	}

	public CommodityVO getProGift_up(int money, int level) {
		// TODO Auto-generated method stub
		CommodityPO po=sale.getProGift(money, level);
		CommodityVO vo=new CommodityVO(null, null, null, level, level, level, level, level, level);
		return vo;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_Return_up() {
		// TODO Auto-generated method stub
		return sale.getAllDraftImport_Return();
	}

	public ImportMenuVO searchDraftImport_Return_up(String note) {
		// TODO Auto-generated method stub
		Import_ReturnPO po=sale.searchDraftImport_Return(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ImportMenuVO vo=new ImportMenuVO(note, note, note, note, commodityList, note, 0, note, 0, note);
		return vo;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_up() {
		// TODO Auto-generated method stub
		return sale.getAllDraftExport();
	}

	public ExportMenuVO searchDraftExport_up(String note) {
		// TODO Auto-generated method stub
		ExportPO exportPO=sale.searchDraftExport(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ExportMenuVO exportMenu=new ExportMenuVO(note, note, note, note, note, commodityList, 0, 0, 0, 0, note, note, 0, note);
		return exportMenu;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_Return_up() {
		// TODO Auto-generated method stub
		return sale.getAllDraftExport_Return();
	}

	public ExportMenuVO searchDraftExport_Return_up(String note) {
		// TODO Auto-generated method stub
		Export_ReturnPO export_ReturnPO=sale.searchDraftExport_Return(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ExportMenuVO exportMenu=new ExportMenuVO(note, note, note, note, note, commodityList, 0, 0, 0, 0, note, note, 0, note);
		return exportMenu;
	}

	public ImportMenuVO searchImportNote_up(String note) {
		// TODO Auto-generated method stub
		ImportPO po=sale.searchImportNote(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ImportMenuVO vo=new ImportMenuVO(note, note, note, note, commodityList, note, 0, note, 0, note);
		return vo;
	}

	public ExportMenuVO searchExportNote_up(String note) {
		// TODO Auto-generated method stub
		ExportPO po=sale.searchExportNote(note);
		CommodityListVO commodityList=new CommodityListVO(note, note, note, 0, 0, 0, note);
		ExportMenuVO vo=new ExportMenuVO(note, note, note, note, note, commodityList, 0, 0, 0, 0, note, note, 0, note);
		return vo;
	}

	public CommodityVO getCommodity_up(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO po=sale.getCommodity(name, type);
		CommodityVO vo=new CommodityVO(type, type, type, 0, 0, 0, 0, 0, 0);
		return vo;
	}
}
