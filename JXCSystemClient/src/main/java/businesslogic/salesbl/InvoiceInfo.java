package businesslogic.salesbl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public interface InvoiceInfo {
	
	public String add(ImportPO po) ;

	public String add(ExportPO po) ;

	public String add(Import_ReturnPO po) ;

	public String add(Export_ReturnPO po) ;

}
