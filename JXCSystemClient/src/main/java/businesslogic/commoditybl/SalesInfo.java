package businesslogic.commoditybl;

import java.util.ArrayList;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public interface SalesInfo {
	
	public ArrayList<ImportPO> getAllImport();
	public ArrayList<Import_ReturnPO> getAllImportReturn();
	public ArrayList<ExportPO> getAllExport();
	public ArrayList<Export_ReturnPO> getAllExportReturn();
	
}
