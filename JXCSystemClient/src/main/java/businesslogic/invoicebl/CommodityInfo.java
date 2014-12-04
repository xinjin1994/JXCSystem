package businesslogic.invoicebl;

import po.PatchPO;
import po.SendGiftPO;

public interface CommodityInfo {
	
	public String addPatch(PatchPO po);
	
	public String delPatch(PatchPO po);
	
	public String addGood_Data(SendGiftPO po);
	
	public String addPatch_Data(PatchPO po);

}
