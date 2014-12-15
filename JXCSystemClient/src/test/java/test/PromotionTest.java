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
		assertEquals("成功",promotion.makeDiscount(1, 1, 1, "t1", "t2"));
	}

	@Test
	public void testDelPromotion() {
		MockAddGift mock=new MockAddGift();
        Promotion promotion=new Promotion();
        promotion.setPro(mock);
		assertEquals("成功",promotion.makeGift(1, "time1","time2"));
	}

	@Test
	public void testMakeGift() {
		MockDelDiscount mockDis=new MockDelDiscount();
		Promotion pro=new Promotion();
        pro.setPro(mockDis);
		assertEquals("成功",pro.delDiscount("t1"));
	}

	@Test
	public void testSearch() {
		Promotion promotion=new Promotion();
		MockGetDiscount mock=new MockGetDiscount();
		promotion.setPro(mock);
		assertEquals("成功",promotion.getAllDiscount());
	}

}
