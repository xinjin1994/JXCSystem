package businesslogicservice.salesblservice;

public interface SalesblService {
	
	//添加客户
	public String addCustomer(String name, int level, String phone, 
			String zip, String mail, int money, String clerk);
	
	//删除客户
	public String delCustomer(String name);
	
	//修改客户
	public String updateCustomer(String name, int level, String phone,
			String zip, String mail, int money, String clerk);
	
	//查找客户
	public String searchCustomer(String word);
	
	//添加进货单
	public String addImport(String name, int warehouse, String good_name,
			String good_type, String ps, int number);
	
	//添加进货退货单
	public String addImport_Return(String name, int warehouse, String good_name,
			String good_type, String ps, int number);
	public String addImport_Return(String note, int number);
	
	//添加销售单
	public String addExport(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount);
	
	//添加销售退货单
	public String addExport_Return(String name, int warehouse, String good_name,
			String good_type, String ps, int number, int price, int discount);
	public String addExport_Return(String note, int number);
	
}
