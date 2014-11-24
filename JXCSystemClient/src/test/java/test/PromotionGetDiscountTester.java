package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.promotionbl.MockGetDiscount;
import businesslogic.promotionbl.Promotion;

public class PromotionGetDiscountTester {

	@Test
	public void test() {
		Promotion promotion=new Promotion();
		MockGetDiscount mock=new MockGetDiscount();
		promotion.setPro(mock);
		assertEquals("成功",promotion.search());
		
	}

}
