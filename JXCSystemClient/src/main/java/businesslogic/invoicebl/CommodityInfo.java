package businesslogic.invoicebl;

import po.PatchPO;
import po.SendGiftPO;

public interface CommodityInfo {
	
	public String passPatch(PatchPO po);
	
	public String refusePatch(String note);
	
	public String passSendGift(SendGiftPO po);
	
	public String refuseSendGift(String note);
	
//	public String addGood_Data(SendGiftPO po);
	
//	public String addPatch_Data(PatchPO po);

}
