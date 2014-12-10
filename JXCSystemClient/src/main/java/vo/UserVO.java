package vo;

import po.UserPO;

public class UserVO {
	
	public String name;//���
	public String password;//����
	public int duty;//ְ��
	public String note;

	public UserVO(String name,String password,int duty){
		this.name=name;
		this.password=password;
		this.duty=duty;
	
	}public UserVO(UserPO po){
		this.name=po.getName();
		this.password=po.getPassword();
		this.duty=po.getDuty();
	}
}
