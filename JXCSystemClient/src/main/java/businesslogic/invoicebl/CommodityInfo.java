package businesslogic.invoicebl;

import po.CommodityPO;
import po.PatchPO;

public interface CommodityInfo {
	
	public String addPatch(PatchPO po);
	
	public String delPatch(PatchPO po);
	
	public String addGood_Data(CommodityPO po);
	
	public String addPatch_Data(PatchPO po);

}
