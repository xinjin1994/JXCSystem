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
					customerVO.shouldGet,customerVO.shouldPay, customerVO.mostOwe,
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
			if ((customer.getMoneyIn() != 0)||(customer.getMoneyOut()!=0)) {
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

	public ArrayList<ImportPO> getAllDraftImport() {
		// TODO Auto-generated method stub
		try {
			ArrayList<ImportPO> importPO = sale.getAllDraftImport();
			systemlog.add_up("GetAllDraftImport");
			return importPO;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Import_ReturnPO> getAllDraftImport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Import_ReturnPO> import_ReturnPO = sale
					.getAllDraftImport_Return();
			systemlog.add_up("GetAllDraftImport_Return");
			return import_ReturnPO;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ExportPO> getAllDraftExport() {
		// TODO Auto-generated method stub

		try {
			ArrayList<ExportPO> export = sale.getAllDraftExport();
			systemlog.add_up("GetAllDraftExport");
			return export;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<Export_ReturnPO> getAllDraftExport_Return() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Export_ReturnPO> export_ReturnPO = sale
					.getAllDraftExport_Return();
			systemlog.add_up("GetAllDraftExport_Return");
			return export_ReturnPO;
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

	public int addDraftImport(ImportPO importPO) {
		// TODO Auto-generated method stub

		try {
			importPO.setCondition(0);
			sale.addDraftImport(importPO);
			systemlog.add_up("AddDraftImport");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addDraftExport_Return(Export_ReturnPO export_ReturnPO) {
		// TODO Auto-generated method stub

		try {
			export_ReturnPO.setCondition(0);
			sale.addDraftExport_Return(export_ReturnPO);
			systemlog.add_up("AddDraftExport_Return");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addDraftExport(ExportPO exportPO) {
		try {
			exportPO.setCondition(0);
			sale.addDraftExport(exportPO);
			systemlog.add_up("AddDraftExport");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addDraftImport_Return(Import_ReturnPO import_ReturnPO) {
		try {
			import_ReturnPO.setCondition(0);
			sale.addDraftImport_Return(import_ReturnPO);
			systemlog.add_up("AddDraftImport_Return");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public ImportPO searchDraftImport(String note) {
		try {
			systemlog.add_up("SearchDraftImport" + note);
			return sale.getDraftImport(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Export_ReturnPO searchDraftExport_Return(String note) {
		// TODO Auto-generated method stub
		try {
			systemlog.add_up("SearchDraftExport_Return" + note);
			return sale.getDraftExport_Return(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ExportPO searchDraftExport(String note) {
		// TODO Auto-generated method stub
		try {
			systemlog.add_up("SearchDraftExport" + note);
			return sale.getDraftExport(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Import_ReturnPO searchDraftImport_Return(String note) {
		// TODO Auto-generated method stub
		try {
			systemlog.add_up(note);
			return sale.getDraftImport_Return(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ImportPO searchImportNote(String note) {
		// TODO Auto-generated method stub
		try {
			systemlog.add_up(note);
			return sale.getImport(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ExportPO searchExportNote(String note) {
		// TODO Auto-generated method stub
		try {
			systemlog.add_up(note);
			return sale.getExport(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Import_ReturnPO searchImport_ReturnNote(String note) {
		try {
			systemlog.add_up(note);
			return sale.getImport_Return(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Export_ReturnPO searchExport_ReturnNote(String note) {
		try {
			systemlog.add_up(note);
			return sale.getExport_Return(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CommodityPO getProGift(int money, int level) {
		// TODO Auto-generated method stub
		return null;
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

	// ////////////////////////////////////////////////////////////////////////////////
	

	public ArrayList<CustomerPO> getAllImportCustomer() {
		return null;
	}

	public ArrayList<CustomerPO> getAllExportCustomer() {
		return null;
	}

	
	public ArrayList<CommodityPO> getAllCommodity() {
		return null;
	}

	public CommodityPO getCommodity(String name, String id) {
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

}