package vo;

import po.UserPO;

public class UserVO {
	
	public String id;
	public String name;//���
	public String password;//����
	public int duty;//ְ��

	public UserVO(String id,String name,String password,int duty){
		this.id = id;
		this.name=name;
		this.password=password;
		this.duty=duty;
	
	}
	
}
