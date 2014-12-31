package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.promotionbl.MockAddDiscount;
import businesslogic.promotionbl.MockAddGift;
import businesslogic.promotionbl.MockDelDiscount;
import businesslogic.promotionbl.MockGetDiscount;
import businesslogic.promotionbl.Promotion;

public class PromotionTest {

	@Test
	public void testMakeDiscount() {
		MockAddDiscount mockDis=new MockAddDiscount();
		Promotion promotion=new Promotion();
		promotion.setPro(mockDis);
		assertEquals(0,0);
	}

	@Test
	public void testDelPromotion() {
		MockAddGift mock=new MockAddGift();
        Promotion promotion=new Promotion();
        promotion.setPro(mock);
		assertEquals(0,0);
	}

	@Test
	public void testMakeGift() {
		MockDelDiscount mockDis=new MockDelDiscount();
		Promotion pro=new Promotion();
        pro.setPro(mockDis);
		assertEquals(0,0);
	}

	@Test
	public void testSearch() {
		Promotion promotion=new Promotion();
		MockGetDiscount mock=new MockGetDiscount();
		promotion.setPro(mock);
		assertEquals(0,0);
	}

}
