package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;


public class MockSales implements SalesInfo{

	public String addImport(ImportPO importPO) {
		return "成功";
	}
	public String addImport_Return(Import_ReturnPO import_ReturnPO) {
		return "成功";
	}

	public String addExport(ExportPO exportPO) {
		return "成功";
	}

	public String addExport_Return(Export_ReturnPO export_ReturnPO) {
		return "成功";
	}

	public String delImport(ImportPO importPO) {
		return "成功";
	}

	public String delImport_Return(Import_ReturnPO import_ReturnPO) {
		return "成功";
	}

	public String delExport(ExportPO exportPO) {
		return "成功";
	}

	public String delExport_Return(Export_ReturnPO export_ReturnPO) {
		return "成功";
	}

}
