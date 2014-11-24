package businesslogic.salesbl;

import businesslogicservice.salesblservice.SalesblService;

public class SalesController implements SalesblService{
	
	Sales sale=new Sales();

	public String addCustomer(String name, int level, String phone, String zip,
			String mail, int money, String clerk) {
		// TODO Auto-generated method stub
		return sale.addCustomer(name, level, phone, zip, mail, money, clerk);
	}

	public String delCustomer(String name) {
		// TODO Auto-generated method stub
		return sale.delCustomer(name);
	}

	public String updateCustomer(String name, int level, String phone,
			String zip, String mail, int money, String clerk) {
		// TODO Auto-generated method stub
		return sale.updateCustomer(name, level, phone, zip, mail, money, clerk);
	}

	public String searchCustomer(String word) {
		// TODO Auto-generated method stub
		return sale.searchCustomer(word);
	}

	public String addImport(String name, int warehouse, String good_name,
			String good_type, String ps, int number) {
		// TODO Auto-generated method stub
		return sale.addImport(name, warehouse, good_name, good_type, ps, number);
	}

	public String addImport_Return(String name, int warehouse,
			String good_name, String good_type, String ps, int number) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(name, warehouse, good_name, good_type, ps, number);
	}

	public String addImport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addImport_Return(note, number);
	}

	public String addExport(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount) {
		// TODO Auto-generated method stub
		return sale.addExport(name, warehouse, good_name, good_type, ps, number, price, discount);
	}

	public String addExport_Return(String name, int warehouse,
			String good_name, String good_type, String ps, int number,
			int price, int discount) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(name, warehouse, good_name, good_type, ps, number, price, discount);
	}

	public String addExport_Return(String note, int number) {
		// TODO Auto-generated method stub
		return sale.addExport_Return(note, number);
	}

}
