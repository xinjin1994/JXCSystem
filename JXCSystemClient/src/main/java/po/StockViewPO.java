package po;

import java.io.Serializable;


//这个是库存查看中的单个PO对象
//用以出入库的商品记录
public class StockViewPO implements Serializable{

	CommodityPO commodity;
	int number;
	int totalMoney;
	int condition;    	//1表示进货，2表示进货退货，3表示销售，4表示销售退货，5表示库存报溢，6表示库存报损，7表示商品赠送
	
	public StockViewPO(CommodityPO commodity,int number, int totalMoney, int condition){
		this.commodity=commodity.copy();
		this.number=number;
		this.totalMoney=totalMoney;
		this.condition=condition;
	}
	
	public StockViewPO add(StockViewPO po){
		if(po.condition==condition){
			if(po.commodity.getName().equals(commodity.getName())&&
					po.commodity.getType().equals(commodity.getType())){
				this.number=po.number+this.number;
				this.totalMoney=po.totalMoney+this.totalMoney;
				return this;
			}
		}
		return null;
	}
	
}
