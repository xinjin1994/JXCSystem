package po;

import java.io.Serializable;

public class CustomerPO implements Serializable {

	public String id;// �ͻ����
	public String name;// �ͻ����
	public int level;// �ͻ��ȼ�
	public boolean type;// �ͻ�����
	public String phone;// ��ϵ��ʽ
	public String zip;// �ʱ�
	public String mail;// ����
	public double moneyIn;// Ӧ�ն��
	public double moneyOut;
	public double amount;// Ӧ��Ӧ��
	public String clerk;// ҵ��Ա
	public String address;// ��ַ

	public CustomerPO(String id2, String name, int level, boolean b,
			String phone, String zip, String mail, double moneyIn,
			double moneyOut, double mostOwe, String clerk, String address) {
		this.id = id2;
		this.name = name;
		this.level = level;
		this.type = b;
		this.phone = phone;
		this.zip = zip;
		this.mail = mail;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
		this.amount = mostOwe;
		this.clerk = clerk;
		this.address = address;
	}

	public CustomerPO(String name, int level, boolean type, String phone) {
		this.name = name;
		this.level = level;
		this.type = type;
		this.phone = phone;
	}

	public CustomerPO copy() {
		return new CustomerPO(id, name, level, type, phone, zip, mail, moneyIn,
				moneyOut, amount, clerk, address);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public boolean getType() {
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

	public double getMoneyIn() {
		return moneyIn;
	}

	public double getMoneyOut() {
		return moneyOut;
	}

	public double getAmount() {
		return amount;
	}

	public String getClerk() {
		return clerk;
	}

	public String getAddress() {
		return address;
	}

}