package vo;


//这个是库存查看的VO
public class ExamineVO {
	
	public String name;//商品名称
	public String type;//商品型号
	public int import_num;//进货数量
	public int import_return_num;//进货退货数量
	public int export_num;//销售数量
	public int export_return_num;//销售退货数量
	public int patch_num;//报溢报损数量
	public int sendgift_num;//赠品数量
	public double total_money;//总价值
	public String time;//商品进出库时间
	
	public ExamineVO(String name,String type,int import_num,int import_return_num,int export_num,int export_return_num,
			int patch_num,int sendgift_num,double total_money,String time){
		this.name=name;
		this.type=type;
		this.import_num=import_num;
		this.import_return_num=import_return_num;
		this.export_num=export_num;
		this.export_return_num=export_return_num;
		this.patch_num=patch_num;
		this.sendgift_num=sendgift_num;
		this.total_money=total_money;
		this.time=time;
	}

}
