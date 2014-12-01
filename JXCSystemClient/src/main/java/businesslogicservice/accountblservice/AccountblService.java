package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.GetVO;
import vo.PayVO;


public interface AccountblService {
	
	//查看当前账户信息
	public AccountVO checkAccount();

	//添加账户
	public int addAccount(AccountVO vo);

	//删除账户
	public int delAccount(AccountVO vo);

	//修改账户
	public int updateAccount(AccountVO vo1, AccountVO vo2);

	//查找账户
	public ArrayList<AccountVO> searchAccount(String word);

	//添加收款单
	public int addReceipt(GetVO vo);
	//添加付款单
	public int addPayment(PayVO vo);
	
}
