package businesslogicservice.salesblservice;

public interface SalesblService {
	
	public String addCustomer(String name, int level, String phone, 
			String zip, String mail, int money, String clerk);
	
	public String delCustomer(String name);
	
	public String updateCustomer(String name, int level, String phone,
			String zip, String mail, int money, String clerk);
	
	public String searchCustomer(String word);
	
	public String addImport(String name, int warehouse, String good_name,
			String good_type, String ps, int number);
	
	public String addImport_Return(String name, int warehouse, String good_name,
			String good_type, String ps, int number);
	public String addImport_Return(String note, int number);
	
	public String addExport(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount);
	
	public String addExport_Return(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount);
	public String addExport_Return(String note, int number);
	

}
