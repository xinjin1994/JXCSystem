package po;

import java.io.Serializable;

public class UserPO implements Serializable{
	String name;//Ãû³Æ
	String password;//ÃÜÂë
	int duty;//Ö°Ôğ
	
	public UserPO(String n,String p,int d) {
		name = n;
		password = p;
		duty = d;
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
}
