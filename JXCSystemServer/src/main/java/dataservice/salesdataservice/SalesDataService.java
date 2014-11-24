package dataservice.salesdataservice;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public interface SalesDataService {
	public boolean addCustomer(CustomerPO po);
	public boolean delCustomer(CustomerPO po);
	public boolean updateCustomer(CustomerPO po1,CustomerPO po2);
	public CustomerPO findCustomer(String name);
	public boolean addImport(ImportPO po);
	public boolean addImport_Return(Import_ReturnPO po);
	public boolean addExport(ExportPO po);
	public boolean addExport_Return(Export_ReturnPO po);
	public CustomerPO[] getAllCustomer();
	public ImportPO[] getAllImport();
	public Import_ReturnPO[] getAllImport_Return();
	public ExportPO[] getAllExport();
	public Export_ReturnPO[] getAllExport_Return();
	public boolean clear();
	
}
