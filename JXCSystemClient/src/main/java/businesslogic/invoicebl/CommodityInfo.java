package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.SendGiftPO;

public interface CommodityInfo {
	
	public String passPatch(PatchPO po);
	
	public String refusePatch(String note);
	
	public String passSendGift(SendGiftPO po);
	
	public String refuseSendGift(String note);
	
	public String passImport(ImportPO po);
	
	public String passImport_Return(Import_ReturnPO po);
	
	public String passExport(ExportPO po);
	
	public String passExport_Return(Export_ReturnPO po);
	
//	public String addGood_Data(SendGiftPO po);
	
//	public String addPatch_Data(PatchPO po);

}
