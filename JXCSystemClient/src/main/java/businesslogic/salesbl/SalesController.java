package businesslogic.salesbl;

import java.util.ArrayList;

import main.ClientStart;
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
import businesslogic.userbl.User;
import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService {

	public Sales sale = new Sales();

	public SalesController() {
		sale = ClientStart.sales;
	}

	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> result = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.searchFuzzyCustomer(name);
		for (int i = 0; i < po.size(); i++) {
			CustomerVO vo = new CustomerVO(po.get(i).getId(), po.get(i)
					.getType(), po.get(i).getLevel(), po.get(i).getName(), po
					.get(i).getPhone(), po.get(i).getAddress(), po.get(i)
					.getZip(), po.get(i).getMail(), po.get(i).getAmount(), po
					.get(i).getMoneyIn(), po.get(i).getMoneyOut(), po.get(i)
					.getClerk());
			result.add(vo);
		}
		return result;
	}

	public CustomerVO searchExactCustomer_up(String name) {
		// TODO Auto-generated method stub
		CustomerPO po = sale.searchExactCustomer(name);
		CustomerVO result = new CustomerVO(po.getId(), po.getType(),
				po.getLevel(), po.getName(), po.getPhone(), po.getAddress(),
				po.getZip(), po.getMail(), po.getAmount(), po.getMoneyIn(),
				po.getMoneyOut(), po.getClerk());
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
		CustomerPO customerPO = sale.getCustomer(importMenuVO.supplier, "id");
		ImportPO imp = new ImportPO(customerPO, importGood,
				importMenuVO.remark, customerPO.clerk, User.operator,
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
		CustomerPO customerPO = sale.getCustomer(importMenuVO.supplier, "id");
		Import_ReturnPO imp = new Import_ReturnPO(customerPO, importGood,
				importMenuVO.remark, customerPO.clerk, User.operator,
				importMenuVO.warehouse, importMenuVO.total, sale
						.searchImportNote(importMenuVO.supplier).getNote());
		int message = sale.addImport_Return(imp);
		return message;
	}

	public int addExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(
				exportMenuVO.commodityList.name,
				exportMenuVO.commodityList.type);
		ExportGoodPO exportGoodPO = new ExportGoodPO(commodityPO,
				exportMenuVO.commodityList.num,
				exportMenuVO.commodityList.price,
				exportMenuVO.commodityList.total,
				exportMenuVO.commodityList.remark);
		ArrayList<ExportGoodPO> exportGood = new ArrayList<ExportGoodPO>();
		exportGood.add(exportGoodPO);
		CustomerPO customerPO = sale.findCustomer(exportMenuVO.cusName);
		ExportPO ex = new ExportPO(customerPO, exportGood, exportMenuVO.remark,
				exportMenuVO.salesMan, User.operator, exportMenuVO.warehouse,
				exportMenuVO.beforeValue, exportMenuVO.afterValue,
				exportMenuVO.discount, exportMenuVO.voucherPrice);
		int message = sale.addExport(ex);
		return message;
	}

	public int addExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = new CommodityPO(
				exportMenuVO.commodityList.name,
				exportMenuVO.commodityList.type);
		ExportGoodPO exportGoodPO = new ExportGoodPO(commodityPO,
				exportMenuVO.commodityList.num,
				exportMenuVO.commodityList.price,
				exportMenuVO.commodityList.total,
				exportMenuVO.commodityList.remark);
		ArrayList<ExportGoodPO> exportGood = new ArrayList<ExportGoodPO>();
		exportGood.add(exportGoodPO);
		CustomerPO customerPO = sale.findCustomer(exportMenuVO.cusName);
		Export_ReturnPO ex = new Export_ReturnPO(customerPO, exportGood,
				exportMenuVO.remark, exportMenuVO.salesMan, User.operator,
				exportMenuVO.warehouse, exportMenuVO.beforeValue,
				exportMenuVO.afterValue, exportMenuVO.discount,
				exportMenuVO.voucherPrice, sale.searchExport_ReturnNote(
						exportMenuVO.cusName).getNote());
		int message = sale.addExport_Return(ex);
		return message;
	}

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		ArrayList<CommodityVO> commodityVO = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> po = sale.getAllCommodity();
		for (int i = 0; i < po.size(); i++) {
			CommodityVO vo = new CommodityVO(po.get(i).getNote(), po.get(i)
					.getName(), po.get(i).getType(), po.get(i).getNumber(), po
					.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i)
					.getRecent_in_price(), po.get(i).getRecent_out_price(),
					po.get(i).warn);
			commodityVO.add(vo);
		}
		return commodityVO;
	}

	public ArrayList<CustomerVO> getAllCustomer_up() {
		// TODO Auto-generated method stub
		System.out.print(111 + "arraylist");
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i, new CustomerVO(po.get(i).getId(), po.get(i)
					.getType(), po.get(i).getLevel(), po.get(i).getName(), po
					.get(i).getPhone(), po.get(i).getAddress(), po.get(i)
					.getZip(), po.get(i).getMail(), po.get(i).getAmount(), po
					.get(i).getMoneyIn(), po.get(i).getMoneyOut(), po.get(i)
					.getClerk()));
		}
		return customerVO;
	}

	public CustomerVO getCustomer_up(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO po = sale.getCustomer(vo.cusName, vo.id);
		CustomerVO customer = new CustomerVO(po.getId(), po.getType(),
				po.getLevel(), po.getName(), po.getPhone(), po.getAddress(),
				po.getZip(), po.getMail(), po.getAmount(), po.getMoneyIn(),
				po.getMoneyOut(), po.getClerk());
		return customer;
	}

	public ArrayList<CustomerVO> getAllImportCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllImportCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i,
					new CustomerVO(po.get(i).id, po.get(i).type,
							po.get(i).level, po.get(i).name, po.get(i).phone,
							po.get(i).address, po.get(i).zip, po.get(i).mail,
							po.get(i).amount, po.get(i).moneyIn,
							po.get(i).moneyOut, po.get(i).clerk));
		}
		return customerVO;
	}

	public ArrayList<CustomerVO> getAllExportCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVO = new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po = sale.getAllExportCustomer();
		for (int i = 0; i < po.size(); i++) {
			customerVO.set(i,
					new CustomerVO(po.get(i).id, po.get(i).type,
							po.get(i).level, po.get(i).name, po.get(i).phone,
							po.get(i).address, po.get(i).zip, po.get(i).mail,
							po.get(i).amount, po.get(i).moneyIn,
							po.get(i).moneyOut, po.get(i).clerk));
		}
		return customerVO;
	}

	public int addDraftImport_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(
				importMenuVO.commodityList.name,
				importMenuVO.commodityList.type);
		ImportGoodPO importGood = new ImportGoodPO(commodity,
				importMenuVO.commodityList.num,
				importMenuVO.commodityList.price,
				importMenuVO.commodityList.total,
				importMenuVO.commodityList.remark);
		ArrayList<ImportGoodPO> importGoodPO = new ArrayList<ImportGoodPO>();
		CustomerPO customerPO = sale.getCustomer(importMenuVO.supplier, "id");
		ImportPO importPO = new ImportPO(customerPO, importGoodPO,
				importMenuVO.remark, customerPO.clerk, User.operator,
				importMenuVO.warehouse, importMenuVO.total);
		importPO.setCondition(0);
		importPO.setNote(importMenuVO.note);
		int message = sale.addDraftImport(importPO);
		return message;
	}

	public int addDraftExport_Return_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(
				exportMenuVO.commodityList.name,
				exportMenuVO.commodityList.type);
		ExportGoodPO exportGood = new ExportGoodPO(commodity,
				exportMenuVO.commodityList.num,
				exportMenuVO.commodityList.price,
				exportMenuVO.commodityList.total,
				exportMenuVO.commodityList.remark);
		ArrayList<ExportGoodPO> exportGoodPO = new ArrayList<ExportGoodPO>();
		CustomerPO customerPO = sale.getCustomer(exportMenuVO.cusName, "id");
		Export_ReturnPO export_returnPO = new Export_ReturnPO(customerPO,
				exportGoodPO, exportMenuVO.remark, customerPO.clerk,
				User.operator, exportMenuVO.warehouse,
				exportMenuVO.beforeValue, exportMenuVO.afterValue,
				exportMenuVO.discount, exportMenuVO.voucherPrice, sale
						.searchExportNote(exportMenuVO.cusName).getNote());
		export_returnPO.setCondition(0);
		export_returnPO.setNote(exportMenuVO.note);
		int message = sale.addDraftExport_Return(export_returnPO);
		return message;
	}

	public int addDraftImport_Return_up(ImportMenuVO importMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(
				importMenuVO.commodityList.name,
				importMenuVO.commodityList.type);
		ImportGoodPO importGood = new ImportGoodPO(commodity,
				importMenuVO.commodityList.num,
				importMenuVO.commodityList.price,
				importMenuVO.commodityList.total,
				importMenuVO.commodityList.remark);
		ArrayList<ImportGoodPO> importGoodPO = new ArrayList<ImportGoodPO>();
		CustomerPO customerPO = sale.getCustomer(importMenuVO.supplier, "id");
		Import_ReturnPO import_returnPO = new Import_ReturnPO(customerPO,
				importGoodPO, importMenuVO.remark, customerPO.clerk,
				User.operator, importMenuVO.warehouse, importMenuVO.total, sale
						.searchExportNote(importMenuVO.supplier).getNote());
		import_returnPO.setCondition(0);
		import_returnPO.setNote(importMenuVO.note);
		int message = sale.addDraftImport_Return(import_returnPO);
		return message;
	}

	public int addDraftExport_up(ExportMenuVO exportMenuVO) {
		// TODO Auto-generated method stub
		CommodityPO commodity = new CommodityPO(
				exportMenuVO.commodityList.name,
				exportMenuVO.commodityList.type);
		ExportGoodPO exportGood = new ExportGoodPO(commodity,
				exportMenuVO.commodityList.num,
				exportMenuVO.commodityList.price,
				exportMenuVO.commodityList.total,
				exportMenuVO.commodityList.remark);
		ArrayList<ExportGoodPO> exportGoodPO = new ArrayList<ExportGoodPO>();
		CustomerPO customerPO = sale.getCustomer(exportMenuVO.cusName, "id");
		ExportPO exportPO = new ExportPO(customerPO, exportGoodPO,
				exportMenuVO.remark, customerPO.clerk, User.operator,
				exportMenuVO.warehouse, exportMenuVO.beforeValue,
				exportMenuVO.afterValue, exportMenuVO.discount,
				exportMenuVO.voucherPrice);
		exportPO.setCondition(0);
		exportPO.setNote(exportMenuVO.note);
		int message = sale.addDraftExport(exportPO);
		return message;
	}

	// ///////////////////////////////////////////////////////
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

	// ///////////////////////////////////////////////////////
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
		ArrayList<ImportPO> po = sale.getAllDraftImport();
		ArrayList<ImportMenuVO> vo = new ArrayList<ImportMenuVO>();
		for (int i = 0; i < po.size(); i++) {
			CommodityListVO commodityList = new CommodityListVO(null, null,
					null, i, i, i, null);
			vo.set(i, new ImportMenuVO(null, null, null, null, null, null, i,
					null, i, null));
		}
		return vo;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_Return_up() {
		// TODO Auto-generated method stub
		ArrayList<Import_ReturnPO> po = sale.getAllDraftImport_Return();
		ArrayList<ImportMenuVO> vo = new ArrayList<ImportMenuVO>();
		for (int i = 0; i < po.size(); i++) {
			CommodityListVO commodityList = new CommodityListVO(null, null,
					null, i, i, i, null);
			vo.set(i, new ImportMenuVO(null, null, null, null, null, null, i,
					null, i, null));
		}
		return vo;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_up() {
		// TODO Auto-generated method stub
		ArrayList<ExportPO> po = sale.getAllDraftExport();
		ArrayList<ExportMenuVO> vo = new ArrayList<ExportMenuVO>();
		for (int i = 0; i < po.size(); i++) {
			CommodityListVO commodityList = new CommodityListVO(null, null,
					null, i, i, i, null);
			vo.set(i, new ExportMenuVO(null, null, null, null, null, null, i,
					i, i, i, null, null, i, null));
		}
		return vo;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport_Return_up() {
		// TODO Auto-generated method stub
		ArrayList<Export_ReturnPO> po = sale.getAllDraftExport_Return();
		ArrayList<ExportMenuVO> vo = new ArrayList<ExportMenuVO>();
		for (int i = 0; i < po.size(); i++) {
			CommodityListVO commodityList = new CommodityListVO(null, null,
					null, i, i, i, null);
			vo.set(i, new ExportMenuVO(null, null, null, null, null, null, i,
					i, i, i, null, null, i, null));
		}
		return vo;
	}

	public ImportMenuVO searchDraftImport_Return_up(String note) {
		// TODO Auto-generated method stub
		Import_ReturnPO po = sale.searchDraftImport_Return(note);
		CommodityListVO commodityList = new CommodityListVO(po
				.getImportGoodList().get(0).getCommodity().getNote(), po
				.getImportGoodList().get(0).getCommodity().getName(), po
				.getImportGoodList().get(0).getCommodity().getType(), po
				.getImportGoodList().get(0).getCommodity().getNumber(), po
				.getImportGoodList().get(0).getPrice(), po.getImportGoodList()
				.get(0).getMoney(), po.getImportGoodList().get(0).getPs());
		ImportMenuVO vo = new ImportMenuVO(po.getNote(), po.getImportGoodList()
				.get(0).getCommodity().getName(), po.getWareHouse(),
				User.operator, commodityList, po.getPs(), po.getTotalMoney(),
				po.getTime(), po.getDocType(), "Invoice_note");
		return vo;
	}

	public ImportMenuVO searchDraftImport_up(String note) {
		// TODO Auto-generated method stub
		ImportPO po = sale.searchDraftImport(note);
		CommodityListVO commodityList = new CommodityListVO(po
				.getImportGoodList().get(0).getCommodity().getNote(), po
				.getImportGoodList().get(0).getCommodity().getName(), po
				.getImportGoodList().get(0).getCommodity().getType(), po
				.getImportGoodList().get(0).getCommodity().getNumber(), po
				.getImportGoodList().get(0).getPrice(), po.getImportGoodList()
				.get(0).getMoney(), po.getImportGoodList().get(0).getPs());
		ImportMenuVO importMenu = new ImportMenuVO(po.getNote(), po.getImportGoodList()
				.get(0).getCommodity().getName(), po.getWareHouse(),
				User.operator, commodityList, po.getPs(), po.getTotalMoney(),
				po.getTime(), po.getDocType(), "Invoice_note");
		return importMenu;
	}

	public ExportMenuVO searchDraftExport_up(String note) {
		// TODO Auto-generated method stub
		ExportPO exportPO = sale.searchDraftExport(note);
		CommodityListVO commodityList = new CommodityListVO(exportPO., note, note,
				0, 0, 0, note);
		ExportMenuVO exportMenu = new ExportMenuVO(note, note, note, note,
				note, commodityList, 0, 0, 0, 0, note, note, 0, note);
		return exportMenu;
	}

	public ExportMenuVO searchDraftExport_Return_up(String note) {
		// TODO Auto-generated method stub
		Export_ReturnPO export_ReturnPO = sale.searchDraftExport_Return(note);
		CommodityListVO commodityList = new CommodityListVO(note, note, note,
				0, 0, 0, note);
		ExportMenuVO exportMenu = new ExportMenuVO(note, note, note, note,
				note, commodityList, 0, 0, 0, 0, note, note, 0, note);
		return exportMenu;
	}

	public ImportMenuVO searchImportNote_up(String note) {
		// TODO Auto-generated method stub
		ImportPO po = sale.searchImportNote(note);
		CommodityListVO commodityList = new CommodityListVO(note, note, note,
				0, 0, 0, note);
		ImportMenuVO vo = new ImportMenuVO(note, note, note, note,
				commodityList, note, 0, note, 0, note);
		return vo;
	}

	public ExportMenuVO searchExportNote_up(String note) {
		// TODO Auto-generated method stub
		ExportPO po = sale.searchExportNote(note);
		CommodityListVO commodityList = new CommodityListVO(note, note, note,
				0, 0, 0, note);
		ExportMenuVO vo = new ExportMenuVO(note, note, note, note, note,
				commodityList, 0, 0, 0, 0, note, note, 0, note);
		return vo;
	}

	public ImportMenuVO searchImport_ReturnNote_up(String note) {
		// TODO Auto-generated method stub
		Import_ReturnPO po = sale.searchImport_ReturnNote(note);
		CommodityListVO commodityList = new CommodityListVO(note, note, note,
				0, 0, 0, note);
		ImportMenuVO vo = new ImportMenuVO(note, note, note, commodityList, 0);
		return vo;
	}

	public ExportMenuVO searchExport_ReturnNote_up(String note) {
		// TODO Auto-generated method stub
		Export_ReturnPO po = sale.searchExport_ReturnNote(note);
		CommodityListVO commodityList = new CommodityListVO(note, note, note,
				0, 0, 0, note);
		ExportMenuVO vo = new ExportMenuVO(note, note, note, note, note,
				commodityList, 0, 0, 0, 0, note, note, 0, note);
		return vo;
	}

	public CommodityVO getProGift_up(int money, int level) {
		// TODO Auto-generated method stub
		CommodityPO po = sale.getProGift(money, level);
		CommodityVO vo = new CommodityVO(null, null, null, level, level, level,
				level, level, level);
		return vo;
	}

	public CommodityVO getCommodity_up(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO po = sale.getCommodity(name, type);
		CommodityVO vo = new CommodityVO(type, type, type, 0, 0, 0, 0, 0, 0);
		return vo;
	}

}
