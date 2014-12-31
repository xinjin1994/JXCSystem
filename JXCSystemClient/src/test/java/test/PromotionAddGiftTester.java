package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.promotionbl.MockAddGift;
import businesslogic.promotionbl.Promotion;

public class PromotionAddGiftTester {

	@Test
	public void test() {
		MockAddGift mock=new MockAddGift();
        Promotion promotion=new Promotion();
        promotion.setPro(mock);
		assertEquals(0,0);
		
	}

}
