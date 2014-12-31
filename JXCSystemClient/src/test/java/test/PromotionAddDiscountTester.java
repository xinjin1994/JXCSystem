package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.DiscountPO;
import businesslogic.promotionbl.MockAddDiscount;
import businesslogic.promotionbl.Promotion;
import data.promotiondata.PromotionDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionAddDiscountTester {

	@Test
	public void test() {
		MockAddDiscount mockDis=new MockAddDiscount();
		Promotion promotion=new Promotion();
		promotion.setPro(mockDis);
		assertEquals(0,0);
		
	    
	}

}
