package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;


public interface SalesInfo {
	
	public String addImport(ImportPO importPO);
	
	public String addImport_Return(Import_ReturnPO import_ReturnPO);
	
	public String addExport(ExportPO exportPO);

	public String addExport_Return(Export_ReturnPO export_ReturnPO);
	
	public String delImport(ImportPO importPO);
	
	public String delImport_Return(Import_ReturnPO import_ReturnPO);
	
	public String delExport(ExportPO exportPO);

	public String delExport_Return(Export_ReturnPO export_ReturnPO);
	

}
