package businesslogic.financialbl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public interface SalesInfo {
	public ImportPO[] getAllImport();
	
	public Import_ReturnPO[] getAllImport_Return();
	
	public ExportPO[] getAllExport();
	
	public Export_ReturnPO[] getAllExport_Return();
}
