package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;


public interface SalesInfo {
	
	public String passImport(ImportPO importPO);
	
	public String passImport_Return(Import_ReturnPO import_ReturnPO);
	
	public String passExport(ExportPO exportPO);

	public String passExport_Return(Export_ReturnPO export_ReturnPO);
	
	public String refuseImport(String note);
	
	public String refuseImport_Return(String note);
	
	public String refuseExport(String note);

	public String refuseExport_Return(String note);
	

}
