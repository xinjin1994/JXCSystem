package businesslogic.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import po.ReceiptPO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogic.commoditybl.Commodity;
import businesslogic.invoicebl.Invoice;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.salesblservice.SalesblService;
import data.salesdata.SaleDataService_Stub;
import dataservice.salesdataservice.SalesDataService;
//1 客户名称重复
//2 客户名称不存在
//3 客户的应收应付不为0
//-1 未知错误

public class Sales implements businesslogic.accountbl.SalesInfo,
		businesslogic.invoicebl.SalesInfo, businesslogic.financialbl.SalesInfo,
		businesslogic.commoditybl.SalesInfo {

	public SalesDataService sale = new SaleDataService_Stub();
	public InvoiceInfo invoice = new Invoice();
	SystemlogInfo systemlog = new Systemlog();
	CommodityInfo commodity = new Commodity();

	public SalesDataService getSale() {
		return sale;
	}

	public void setSale(SalesDataService sale) {
		this.sale = sale;
	}

	public int addCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		try {
			if (sale.findCustomer(customerVO.cusName) != null) {
				return 1;
			}
			CustomerPO customer = new CustomerPO(customerVO.id,
					customerVO.cusName, customerVO.level,
					customerVO.classification, customerVO.tel,
					customerVO.zipCode, customerVO.ezipCode,
					customerVO.shouldGet, customerVO.mostOwe,
					customerVO.person, customerVO.address);
			if (sale.addCustomer(customer)) {
				systemlog.add_up("AddCustomer:" + customer.getName() + ","
						+ customer.getId());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		CustomerPO customer;
		try {
			customer = sale.findCustomer(customerVO.cusName);
			if (customer == null) {
				return 2;
			}
			if (customer.getMoney() != 0) {
				return 3;
			}
			if (sale.delCustomer(customer)) {
				systemlog.add_up("DelCustomer:" + customer.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int updateCustomer(CustomerVO vo1, CustomerVO vo2) {
		// TODO Auto-generated method stub
		CustomerPO customer1;
		CustomerPO customer2;
		try {
			customer1 = sale.findCustomer(vo1.cusName);
			customer2 = sale.findCustomer(vo2.cusName);

			if (customer1 == null) {
				return 2;
			}
			if (sale.updateCustomer(customer1, customer2)) {
				systemlog.add_up("UpdateCustomer:" + customer1.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int addImport(ImportPO po) {
		// TODO Auto-generated method stub
		ImportPO im = new ImportPO(null, null, null, null, null, null, 0);
		if (invoice.add(im) != null) {
			systemlog.add_up("AddImport:");
			return 0;
		}
		return -1;
	}

	public int addImport_Return(Import_ReturnPO po) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO(null, null, null, null,
				null, null, 0, null);
		if (invoice.add(im_re) != null) {
			systemlog.add_up("AddImport_Return:");
			return 0;
		}
		return -1;
	}

	public int addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Import_ReturnPO im_re = new Import_ReturnPO(null, null, note, note,
				note, note, number, note);
		if (invoice.add(im_re) != null) {
			systemlog.add_up("AddImport_Return:");
			return 0;
		}
		return -1;
	}

	public int addExport(ExportPO po) {
		// TODO Auto-generated method stub
		ExportPO ex = new ExportPO(null, null, null, null, null, null, 0, 0, 0,
				0);
		if (invoice.add(ex) != null) {
			systemlog.add_up("AddExport:");
			return 0;
		}
		return -1;
	}

	public int addExport_Return(Export_ReturnPO po) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO(null, null, null, null,
				null, null, 0, 0, 0, 0, null);
		if (invoice.add(ex_re) != null) {
			systemlog.add_up("AddExport_Return:");
			return 0;
		}
		return -1;
	}

	public int addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		Export_ReturnPO ex_re = new Export_ReturnPO(null, null, note, note,
				note, note, number, number, number, number, note);
		if (invoice.add(ex_re) != null) {
			systemlog.add_up("AddExport_Return:");
			return 0;
		}
		return -1;
	}

	public CustomerPO findCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			CustomerPO po = sale.findCustomer(name);
			if (po != null) {
				systemlog.add_up("FindCustomer:" + name);
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ImportPO> getAllImport() {
		// TODO Auto-generated method stub
		try {
			ArrayList<ImportPO> po = sale.getAllImport();
			if (po != null) {
				systemlog.add_up("GetAllImport");
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Import_ReturnPO> po = sale.getAllImport_Return();
			if (po != null) {
				systemlog.add_up("GetAllImport_Return");
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ExportPO> getAllExport() {
		// TODO Auto-generated method stub
		try {
			ArrayList<ExportPO> po = sale.getAllExport();
			if (po != null) {
				systemlog.add_up("getAllExport");
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Export_ReturnPO> po = sale.getAllExport_Return();
			if (po != null) {
				systemlog.add_up("getAllExport_Return");
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CustomerPO> searchFuzzyCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CustomerPO> po = sale.getAllCustomer();
			ArrayList<CustomerPO> array = new ArrayList<CustomerPO>();
			CustomerPO lin = sale.findCustomer(name);
			array.add(lin);
			systemlog.add_up("SearchFuzzyCustomer:" + name);
			return po;

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<CustomerPO>();
	}

	public CustomerPO searchExactCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			CustomerPO po = sale.findCustomer(name);
			systemlog.add_up("SearchExactCustomer:" + name);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CustomerPO> getAllCustomer() {
		// TODO Auto-generated method stub
		try {
			ArrayList<CustomerPO> po = sale.getAllCustomer();
			if (po != null) {
				systemlog.add_up("getAllCustomer");
			}
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CustomerPO getCustomer(String name, String id) {
		// TODO Auto-generated method stub
		try {
			if (sale.findCustomer(name) != null) {
				systemlog.add_up("GetCustomer:" + name);
			}
			return sale.findCustomer(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getCustomerNote() {
		// TODO Auto-generated method stub
		try {
			return sale.getCustomerNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport() {
		// TODO Auto-generated method stub
		try {
			ArrayList<ImportPO> importPO = sale.getAllDraftImport();

			ArrayList<ImportMenuVO> importMenu = new ArrayList<ImportMenuVO>();

			for (int i = 0; i < importPO.size(); i++) {
				CommodityListVO commodityList = new CommodityListVO(null, null,
						null, i, i, i, null);
				importMenu.set(i, new ImportMenuVO(null, null, null, null,
						commodityList, null, i, null, i, null));
			}
			systemlog.add_up("GetAllDraftImport");
			return importMenu;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ImportMenuVO> getAllDraftImport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Import_ReturnPO> import_ReturnPO = sale
					.getAllDraftImport_Return();

			ArrayList<ImportMenuVO> importMenu = new ArrayList<ImportMenuVO>();

			for (int i = 0; i < import_ReturnPO.size(); i++) {
				CommodityListVO commodityList = new CommodityListVO(null, null,
						null, i, i, i, null);
				importMenu.set(i, new ImportMenuVO(null, null, null, null,
						commodityList, null, i, null, i, null));
			}
			systemlog.add_up("GetAllDraftImport_Return");
			return importMenu;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ExportMenuVO> getAllDraftExport() {
		// TODO Auto-generated method stub

		try {
			ArrayList<ExportPO> export = sale.getAllDraftExport();

			ArrayList<ExportMenuVO> exportMenu = new ArrayList<ExportMenuVO>();

			for (int i = 0; i < export.size(); i++) {
				CommodityListVO commodityList = new CommodityListVO(null, null,
						null, i, i, i, null);
				exportMenu.set(i, new ExportMenuVO(null, null, null, null,
						commodityList, i, i, i, i));
			}
			systemlog.add_up("GetAllDraftExport");
			return exportMenu;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<ExportMenuVO> getAllDraftExport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Export_ReturnPO> export_ReturnPO = sale
					.getAllDraftExport_Return();

			ArrayList<ExportMenuVO> exportMenu = new ArrayList<ExportMenuVO>();

			for (int i = 0; i < export_ReturnPO.size(); i++) {
				CommodityListVO commodityList = new CommodityListVO(null, null,
						null, i, i, i, null);
				exportMenu.set(i, new ExportMenuVO(null, null, null, null,
						commodityList, i, i, i, i));
			}
			systemlog.add_up("GetAllDraftExport_Return");
			return exportMenu;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getImportNote() {
		// TODO Auto-generated method stub

		try {
			return sale.getImportNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String getImport_ReturnNote() {
		// TODO Auto-generated method stub
		try {
			return sale.getImport_ReturnNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String getExportNote() {
		// TODO Auto-generated method stub
		try {
			return sale.getExportNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String getExport_ReturnNote() {
		// TODO Auto-generated method stub
		try {
			return sale.getExport_ReturnNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public CommodityPO getAllCommodity() {

		return null;
	}

	public CommodityVO getCommodity(String name, String id) {
		return null;
	}

	public ArrayList<CustomerPO> getAllImportCustomer() {
		return null;
	}

	public ArrayList<CustomerPO> getAllExportCustomer() {
		return null;
	}

	public String passImport(ImportPO importPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passImport_Return(Import_ReturnPO import_ReturnPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passExport(ExportPO exportPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passExport_Return(Export_ReturnPO export_ReturnPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refuseImport(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refuseImport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refuseExport(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refuseExport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passReceipt(ReceiptPO receiptPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passPayment(PaymentPO paymentPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getClerk() {
		return 0;
	}

	public int getDiscount() {
		return 0;
	}

	public int getVoucher() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getOtherPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getClerkDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getImport_ReturnMaxNumber(String old_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getExport_ReturnMaxNumber(String old_note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addDraftImport(ImportPO importPO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addDraftExport_Return(Export_ReturnPO export_ReturnPO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addDraftExport(ExportPO exportPO) {
		return 0;
	}

	public int addDraftImport_Return(Import_ReturnPO import_ReturnPO) {
		return 0;
	}

	public ImportMenuVO searchDraftImport(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityVO getProGift(int money, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchExportNote() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchDraftExport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchImportNote(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchExportNote(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportMenuVO searchDraftExport(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportMenuVO searchDraftImport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}

}