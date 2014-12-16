package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.promotionbl.MockDelDiscount;
import businesslogic.promotionbl.Promotion;

public class PromotionDelDiscountTester {

	@Test
	public void test() {
		MockDelDiscount mockDis=new MockDelDiscount();
		Promotion pro=new Promotion();
        pro.setPro(mockDis);
		assertEquals("成功",pro.delDiscount(0));
	}

}
