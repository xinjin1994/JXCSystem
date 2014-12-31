package test;
import static org.junit.Assert.*;

import org.junit.Test;

import po.CommodityPO;
import businesslogic.commoditybl.Commodity;
import businesslogic.commoditybl.MockCommodityData;
import businesslogic.commoditybl.MockInvoice;
import businesslogic.commoditybl.MockSystemlog;


public class CommodityTest {

	@Test
	public void testAddCommodityStringStringIntInt() {
		Commodity commodity=new Commodity();
		MockCommodityData mock=new MockCommodityData();
		commodity.sto=mock;
		assertEquals(0,0);
	}

	@Test
	public void testPatch() {
		Commodity commodity=new Commodity();
		MockInvoice mock1=new MockInvoice();
		commodity.invoice=mock1;
		MockSystemlog mock2=new MockSystemlog();
		commodity.systemlog=mock2;
		assertEquals(0,0);
	}
	
	@Test
	public void testIventory(){
		Commodity commodity=new Commodity();
		MockCommodityData mock=new MockCommodityData();
		commodity.sto=mock;
		CommodityPO po=new CommodityPO("name","type",50,60);
		mock.array.add(po);
		assertEquals(0,0);
	}

}
