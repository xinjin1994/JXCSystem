package businesslogic.invoicebl;

import po.AllBillPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.SendGiftPO;

public interface FinancialInfo {
	
	public boolean addSaleList(ExportPO po);
	
	public boolean addSaleList(Export_ReturnPO po);
	
	public boolean addAllBill(AllBillPO po);
	
	public boolean addOperatingCondition(ImportPO po);

	public boolean addOperatingCondition(Import_ReturnPO po);
	
	public boolean addOperatingCondition(ExportPO po);

	public boolean addOperatingCondition(Export_ReturnPO po);
	
	public boolean addOperatingCondition(SendGiftPO po);

	public boolean addOperatingCondition(PatchPO po);

}
