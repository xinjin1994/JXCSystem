package businesslogic.financialbl;

import po.CommodityPO;

public class MockCommodity implements CommodityInfo{

	public CommodityPO[] getAllCommodity() {
		// TODO Auto-generated method stub
		CommodityPO po= new CommodityPO(true, "name", "type", 10, 10, 10, 10, 10, 10);
		
		CommodityPO[] com=new CommodityPO[1];
		com[0]=po;
		return com;
	}

}
