package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.GetVO;
import vo.PayVO;


public interface AccountblService {
	
	//查看当前账户信息
	public AccountVO checkAccount_up();

	//添加账户
	public int addAccount_up(AccountVO vo);

	//删除账户
	public int delAccount_up(AccountVO vo);

	//修改账户
	public int updateAccount_up(AccountVO vo1, AccountVO vo2);

	//模糊查找账户
	public ArrayList<AccountVO> searchFuzzyAccount_up(String word);
	
	//精确查找账户
	public ArrayList<AccountVO> searchAccurateAccount_up(AccountVO vo);

	//添加收款单
	public int addReceipt_up(GetVO vo);
	//添加付款单
	public int addPayment_up(PayVO vo);
	
}
