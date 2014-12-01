package vo;
//库存
public class StockVO {
	public String name;
	public String size;
	public int num;
	public double averageValue;
	public int batch;
	public int batchNum;
	public String date;
	public String lineNum;
	
	public StockVO(String name,String size,int num,double averageValue,int batch,int batchNum,String date,String lineNum){
	//名称，型号，库存数量，库存均价，批次，批号，出厂日期，行号
	this.name=name;
	this.size=size;
	this.num=num;
	this.averageValue=averageValue;
	this.batch=batch;
	this.batchNum=batchNum;
	this.date=date;
	this.lineNum=lineNum;
	
	}
}
