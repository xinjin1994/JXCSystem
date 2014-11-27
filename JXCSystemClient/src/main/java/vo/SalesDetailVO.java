package vo;
//销售明细表
public class SalesDetailVO {
	public String time;
	public String commodityName;
	public String type;
	public int num;
	public double unitPrice;
	public double total;
      public SalesDetailVO(String time,String commodityName,String type,int num,double unitPrice,double total){
    	  //时间（精确到天），商品名，型号，数量，单价，总额
    	  this.time=time;
    	  this.commodityName=commodityName;
    	  this.type=type;
    	  this.num=num;
    	  this.unitPrice=unitPrice;
    	  this.total=total;
      }
}
