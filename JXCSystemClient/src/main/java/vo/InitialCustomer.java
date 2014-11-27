package vo;

public class InitialCustomer {

	public String type;
	public String name;
	public String tel;
	public double shouldPay;
	public double shouldGet;
	public double balance;

	public InitialCustomer(String type, String name, String tel, double shouldPay, double shouldGet, double balance) {
		//客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），银行账户信息（名称，余额）
		this.type = type;
		this.name = name;
		this.tel = tel;
		this.shouldPay = shouldPay;
		this.shouldGet = shouldGet;
		this.balance = balance;
	}

}
