package po;

import java.io.Serializable;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	String name;//���
	String password;//����
	int duty;//ְ��
	String note;
	
	public UserPO(String n,String p,int d,String note) {
		name = n;
		password = p;
		duty = d;
	}
	
	public UserPO copy(){
		return new UserPO(name, password, duty,note);
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getDuty() {
		return duty;
	}
	
	public String getNote(){
		return note;
	}
}
