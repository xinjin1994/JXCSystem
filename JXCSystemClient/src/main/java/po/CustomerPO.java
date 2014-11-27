package po;

import java.io.Serializable;

public class CustomerPO implements Serializable{

	int id;//�ͻ����
	String name;//�ͻ����
	int level;//�ͻ��ȼ�
	String type;//�ͻ�����
	String phone;//��ϵ��ʽ
	String zip;//�ʱ�
	String mail;//����
	int money;//Ӧ�ն��
	int amount;//Ӧ��Ӧ��
	String clerk;//ҵ��Ա
	String address;//��ַ
	
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
	
	
	public CustomerPO copy(){
		return new CustomerPO( id, name, level, type, phone, zip, mail, money, amount,clerk, address);
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