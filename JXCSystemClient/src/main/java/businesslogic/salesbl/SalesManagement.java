package businesslogic.salesbl;

import java.rmi.RemoteException;

import businesslogic.commoditybl.Commodity;
import businesslogic.invoicebl.Invoice;
import businesslogic.promotionbl.Promotion;
import businesslogic.systemlogbl.Systemlog;
import data.salesdata.SaleDataService_Stub;
import dataservice.salesdataservice.SalesDataService;
import po.CustomerPO;
import vo.CustomerVO;

public class SalesManagement {
	
	public SalesDataService sale = new SaleDataService_Stub();
	public InvoiceInfo invoice = new Invoice();
	SystemlogInfo systemlog = new Systemlog();
	CommodityInfo commodity = new Commodity();
	PromotionInfo promotion = new Promotion();

	public void setInfo(InvoiceInfo invoice, SystemlogInfo systemlog,
			CommodityInfo commodity) {
		this.invoice = invoice;
		this.systemlog = systemlog;
		this.commodity = commodity;
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
	
}
