package po;


//这个是库存查看中的单个PO对象
//用以出入库的商品记录
public class StockViewPO {

	CommodityPO commodity;
	int number;
	int totalMoney;
	int condition;    	//1表示进货，2表示进货退货，3表示销售，4表示销售退货，5表示库存报溢，6表示库存报损，7表示商品赠送
	
	public StockViewPO(ImportPO po){
	}
	
	
	
}
