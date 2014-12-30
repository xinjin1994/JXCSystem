package vo;

public class CustomerVO {
	public String id;
	public boolean classification;
	public int level;
	public String cusName;
	public String tel;
	public String address;
	public String zipCode;
	public String ezipCode;
	public double mostOwe;
	public double shouldPay;
	public double shouldGet;
	public String person;
 public CustomerVO(String id,boolean classification,int level,String cusName,String tel,String address,String zipCode,String ezipCode,double mostOwe,double shouldGet,
		 double shouldPay,String person){
	//编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
	//0代表进货商，非0代表销售商
	 //false代表进货商，true代表销售商
	 this.id=id;
	 this.classification=classification;
	 this.level=level;
	 this.cusName=cusName;
	 this.tel=tel;
     this.address=address;
     this.zipCode=zipCode;
     this.ezipCode=ezipCode;
     this.mostOwe=mostOwe;
     this.shouldGet=shouldGet;
     this.shouldPay = shouldPay;
     this.person=person;
 }
}
