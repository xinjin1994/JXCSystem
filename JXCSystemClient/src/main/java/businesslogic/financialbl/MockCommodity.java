package businesslogic.financialbl;

import java.util.ArrayList;

import po.CommodityPO;

public class MockCommodity implements CommodityInfo{

	public ArrayList<CommodityPO> getAllCommodity() {
		// TODO Auto-generated method stub
		CommodityPO po= new CommodityPO(true, "name", "type", 10, 10, 10, 10, 10, 10);
		
		ArrayList<CommodityPO> com=new ArrayList<CommodityPO>();
		com.add(po);
		return com;
	}

}
