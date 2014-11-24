package po;

import java.io.Serializable;

public class CustomerPO implements Serializable{

	int id;//客户编号
	String name;//客户名称
	int level;//客户等级
	String type;//客户分类
	String phone;//联系方式
	String zip;//邮编
	String mail;//邮箱
	int money;//应收额度
	int amount;//应收应付
	String clerk;//业务员
	String address;//地址
	
	public CustomerPO(int id, String name, int level, String type,
			String phone, String zip, String mail, int money, int amount,
			String clerk, String address) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.type = type;
		this.phone = phone;
		this.zip = zip;
		this.mail = mail;
		this.money = money;
		this.amount = amount;
		this.clerk = clerk;
		this.address = address;
	}
	
	public CustomerPO(String name,int level, String type, String phone){
		this.name=name;
		this.level=level;
		this.type=type;
		this.phone=phone;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public String getType() {
		return type;
	}

	public String getPhone() {
		return phone;
	}

	public String getZip() {
		return zip;
	}

	public String getMail() {
		return mail;
	}

	public int getMoney() {
		return money;
	}

	public int getAmount() {
		return amount;
	}

	public String getClerk() {
		return clerk;
	}

	public String getAddress() {
		return address;
	}

}