package businesslogic.salesbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.DiscountPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import po.ProGiftPO;
import po.ReceiptPO;
import po.VoucherPO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogic.commoditybl.Commodity;
import businesslogic.invoicebl.Invoice;
import businesslogic.promotionbl.Promotion;
import businesslogic.systemlogbl.Systemlog;
import businesslogic.userbl.User;
import businesslogicservice.salesblservice.SalesblService;
import data.salesdata.SaleDataService_Stub;
import dataservice.salesdataservice.SalesDataService;
//1 客户名称重复
//2 客户名称不存在
//3 客户的应收应付不为0
//-1 未知错误
//5 销售退货数量超出可退数量
//6 进货退货数量超出可退数量
//7 库存数量不足

public class Sales implements businesslogic.accountbl.SalesInfo,
		businesslogic.invoicebl.SalesInfo, businesslogic.financialbl.SalesInfo,
		businesslogic.commoditybl.SalesInfo {

	public SalesDataService sale = new SaleDataService_Stub();
	public InvoiceInfo invoice = new Invoice();
	SystemlogInfo systemlog = new Systemlog();
	CommodityInfo commodity = new Commodity();
	PromotionInfo promotion = new Promotion();

	public SalesDataService getSale() {
		return sale;
	}

	public void setSale(SalesDataService sale) {
		this.sale = sale;
	}

	public void setInfo(InvoiceInfo invoice, SystemlogInfo systemlog,
			CommodityInfo commodity) {
		this.invoice = invoice;
		this.systemlog = systemlog;
		this.commodity = commodity;
	}

	public CommodityPO findCommodity(String name, String type) {
		return commodity.findCommodity(name, type);
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
					customerVO.shouldGet, customerVO.shouldPay,
					customerVO.mostOwe, customerVO.person, customerVO.address);
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
			if ((customer.getMoneyIn() != 0) || (customer.getMoneyOut() != 0)) {
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
			customer1 = new CustomerPO(vo1.id, vo1.cusName, vo1.level,
					vo1.classification, vo1.tel, vo1.zipCode, vo1.ezipCode,
					vo1.shouldGet, vo1.shouldPay, vo1.mostOwe, vo1.person,
					vo1.address);
			customer2 = new CustomerPO(vo2.id, vo2.cusName, vo2.level,
					vo2.classification, vo2.tel, vo2.zipCode, vo2.ezipCode,
					vo2.shouldGet, vo2.shouldPay, vo2.mostOwe, vo2.person,
					vo2.address);
			if (sale.updateCustomer(customer1, customer2)) {
				systemlog.add_up("UpdateCustomer:" + customer1.getName());
				// System.out.println(customer2.getClerk());
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
		invoice.add(po);
		try {
			if (sale.addImport(po)) {
				systemlog.add_up("addImport: ");

				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int addImport_Return(Import_ReturnPO po) {
		// TODO Auto-generated method stub
		System.out.print(po.getOldNote());
		if (po.getOldNote() == null) {
			return 6;
		}
		int number = getImport_ReturnMaxNumber(po.getOldNote());
		System.out.println("要求退货数量："
				+ po.getImportGoodList().get(0).getNumber());
		System.out.println("可退货数量：" + number);
		CommodityPO commodityPO = commodity.findCommodity(po
				.getImportGoodList().get(0).getCommodity().getName(), po
				.getImportGoodList().get(0).getCommodity().getType());
		ArrayList<CommodityPO> array = new ArrayList<CommodityPO>();
		array = commodity.getAllCommodity();
		for (int i = 0; i < array.size(); i++) {
			if ((array.get(i).getName() == commodityPO.getName())
					&& (array.get(i).getType() == commodityPO.getType())) {
				if (commodityPO.number < po.getImportGoodList().get(0)
						.getNumber()) {
					return 6;
				}
			}
		}

		if (po.getImportGoodList().get(0).getNumber() > number) {
			return 6;
		} else {
			invoice.add(po);
			try {
				sale.addImport_Return(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			systemlog.add_up("AddImport_Return:" + User.operator);
			return 0;
		}
	}

	// public int addImport_Return(String note, int number) {
	// // TODO Auto-generated method stub
	// Import_ReturnPO im_re = new Import_ReturnPO(null, null, note, note,
	// note, note, number, note);
	// if (invoice.add(im_re) != null) {
	// systemlog.add_up("AddImport_Return:");
	// return 0;
	// }
	// return -1;
	// }

	public int addExport(ExportPO po) {
		// TODO Auto-generated method stub
		CommodityPO commodityPO = commodity.findCommodity(po
				.getExportGoodList().get(0).getCommodity().getName(), po
				.getExportGoodList().get(0).getCommodity().getType());
		if (commodityPO == null) {
			return 7;
		} else if (po.getExportGoodList().get(0).getNumber() > commodityPO.number) {
			return 7;
		} else {
			invoice.add(po);
			try {
				sale.addExport(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProGiftPO proGiftPO = promotion.getProGift(po.getCustomer()
					.getLevel());
			if (proGiftPO == null) {
				systemlog.add_up("addExport: ");
				System.out.println("addExport:before ");
				return 0;
			} else {
				System.out.println("addExport:after");
				String time = Sales.getNowTime();
				int start = time.compareTo(proGiftPO.getStartTime());
				int end = time.compareTo(proGiftPO.getEndTime());
//				System.out.println("time:"+time);
//				System.out.println("money1:"+po.getTotalMoneyAfter()+" money2: "+proGiftPO.getStartMoney());
			
				if ((start >= 0) && (end <= 0)) {
					if (po.getTotalMoneyAfter()>= proGiftPO
							.getStartMoney()) {
						
						commodity.addSendGift(proGiftPO.getGift(),
								proGiftPO.getNumber(), po.getCustomer());
					}
				}
				systemlog.add_up("addExport: ");
				return 0;
			}
		}
	}

	public int addExport_Return(Export_ReturnPO po) {
		// TODO Auto-generated method stub
		int number = getExport_ReturnMaxNumber(po.getOldNote());
		if (po.getExportGoodList().get(0).getNumber() > number) {
			return 5;
		} else {
			invoice.add(po);
			try {
				sale.addExport_Return(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			systemlog.add_up("AddExport_Return:" + User.operator);
			return 0;
		}

	}

	// public int addExport_Return(String note, int number) {
	// // TODO Auto-generated method stub
	// Export_ReturnPO ex_re = new Export_ReturnPO(null, null, note, note,
	// note, note, number, number, number, number, note);
	// if (invoice.add(ex_re) != null) {
	// systemlog.add_up("AddExport_Return:");
	// return 0;
	// }
	// return -1;
	// }

	public CustomerPO findCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			CustomerPO po = sale.findCustomer(name);
			if (po != null) {
				systemlog.add_up("FindCustomer:" + name);
				return po;
			}

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
				return po;
			}

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
				return po;
			}

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
				return po;
			}

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
				return po;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CustomerPO> searchFuzzyCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			// ArrayList<CustomerPO> po = sale.getAllCustomer();
			CustomerPO po = sale.findCustomer(name);
			ArrayList<CustomerPO> customer = new ArrayList<CustomerPO>();
			if (po != null) {
				systemlog.add_up("SearchFuzzyCustomer:" + name);
				customer.add(po);
				return customer;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CustomerPO searchExactCustomer(String name) {
		// TODO Auto-generated method stub
		try {
			CustomerPO po = sale.findCustomer(name);
			if (po != null) {
				systemlog.add_up("SearchExactCustomer:" + name);
				return po;
			}
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

	// // //////////////////////////////////
	// public String getOtherPromotion() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// //////////////////////////////////////
	// public double getClerkDiscount() {
	// // TODO Auto-generated method stub
	// if (User.duty == 3) {
	//
	// } else {
	//
	// }
	// return 0;
	// }

	public int getImport_ReturnMaxNumber(String old_note) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = sale.getImport_ReturnMaxNumber(old_note);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int getExport_ReturnMaxNumber(String old_note) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = sale.getExport_ReturnMaxNumber(old_note);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// ////////////////////////////////////////////////////////////////////////////////
	public String getImportOldNote(String cusName, String name, String type) {
		String oldNote = null;
		System.out.println("getImportOldNote,before:" + oldNote);
		try {
			oldNote = sale.getImportOldNote(cusName, name, type);
			System.out.println("getImportOldNote,after" + oldNote);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getImportOldNote客户端： " + oldNote);
		return oldNote;
	}

	public String getExportOldNote(String cusName, String name, String type) {
		String oldNote = null;
		try {
			oldNote = sale.getExportOldNote(cusName, name, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldNote;
	}

	public ArrayList<CustomerPO> getAllImportCustomer() {
		ArrayList<CustomerPO> po = new ArrayList<CustomerPO>();
		try {
			po = sale.getAllImportCustomer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<CustomerPO> getAllExportCustomer() {
		ArrayList<CustomerPO> po = new ArrayList<CustomerPO>();
		try {
			po = sale.getAllExportCustomer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<CommodityPO> getAllCommodity() {
		ArrayList<CommodityPO> commodityPO = commodity.getAllCommodity();
		return commodityPO;
	}

	public CommodityPO getCommodity(String name, String id) {
		CommodityPO commodityPO = commodity.findCommodity(name, id);
		if (commodityPO == null) {
			System.out.println("getCommodity is null!");
		}
		return commodityPO;
	}

	public String passImport(ImportPO importPO) {
		try {
			if (sale.passImport(importPO)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passImport_Return(Import_ReturnPO import_ReturnPO) {
		try {
			if (sale.passImport_Return(import_ReturnPO)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passExport(ExportPO exportPO) {
		try {
			if (sale.passExport(exportPO)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passExport_Return(Export_ReturnPO export_ReturnPO) {
		try {
			if (sale.passExport_Return(export_ReturnPO)) {

				CommodityPO commodityPO = commodity.findCommodity(
						export_ReturnPO.getExportGoodList().get(0)
								.getCommodity().getName(), export_ReturnPO
								.getExportGoodList().get(0).getCommodity()
								.getType());
				ArrayList<CommodityPO> array = new ArrayList<CommodityPO>();
				array = commodity.getAllCommodity();
				for (int i = 0; i < array.size(); i++) {
					if ((array.get(i).getName() == commodityPO.getName())
							&& (array.get(i).getType() == commodityPO.getType())) {
						commodityPO.number = commodityPO.getNumber()
								+ export_ReturnPO.getExportGoodList().get(0)
										.getNumber();
					}
				}
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String refuseImport(String note) {
		try {
			if (sale.refuseImport(note)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String refuseImport_Return(String note) {
		try {
			if (sale.refuseImport_Return(note)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String refuseExport(String note) {
		try {
			if (sale.refuseExport(note)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String refuseExport_Return(String note) {
		// TODO Auto-generated method stub

		try {
			if (sale.refuseExport_Return(note)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passReceipt(ReceiptPO receiptPO) {
		try {
			if (sale.passReceipt(receiptPO)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passPayment(PaymentPO paymentPO) {
		try {
			if (sale.passPayment(paymentPO)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public double getDiscount(double money, int level) {
		// TODO Auto-generated method stub
		DiscountPO discountPO = promotion.getDiscount(level);
		if (discountPO == null) {
			System.out.println("SalesgetDiscount: " + discountPO);
			return 0;
		} else {
			System.out.println("disCount is not null");
			String time = Sales.getNowTime();
			int start = time.compareTo(discountPO.getStartTime());
			int end = time.compareTo(discountPO.getEndTime());
			System.out.println("time " + time + "start "
					+ discountPO.getStartTime() + "end "
					+ discountPO.getEndTime());
			if ((start >= 0) && (end <= 0)) {
				if (money > discountPO.getEndMoney()) {
					int result = (int) (discountPO.getEndMoney() / discountPO
							.getStartMoney());
					return result * discountPO.getDiscountMoney();
				} else {
					int result = (int) (money / discountPO.getStartMoney());
					return result * discountPO.getDiscountMoney();
				}
			}
		}
		return 0;

	}

	// public ProGiftPO getProGift(double money, int level) {
	// // TODO Auto-generated method stub
	// ProGiftPO proGiftPO = promotion.getProGift(level);
	// String time = Sales.getNowTime();
	// int start = time.compareTo(proGiftPO.getStartTime());
	// int end = time.compareTo(proGiftPO.getEndTime());
	// if ((start >= 0) && (end <= 0)) {
	// if (money > proGiftPO.getStartMoney()) {
	// return proGiftPO;
	// }
	// }
	// return null;
	// }

	// public double getVoucher(double money, int level) {
	// // TODO Auto-generated method stub
	// VoucherPO voucherPO = promotion.getVoucher(level);
	// String time = Sales.getNowTime();
	// int start = time.compareTo(voucherPO.getStartTime());
	// int end = time.compareTo(voucherPO.getEndTime());
	// if ((start >= 0) && (end <= 0)) {
	// if (money > voucherPO.getStartMoney()) {
	// return voucherPO.getVoucherMoney();
	// }
	// }
	// return 0;
	// }

	public static String getNowTime() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sysDatetime = fmt.format(rightNow.getTime());
		return sysDatetime;
	}

}