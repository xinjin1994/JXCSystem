package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CustomerVO;
import vo.GetVO;
import vo.PayVO;
import vo.UserVO;

//int错误类型：
//-1 未知错误
//1 账户名称重复
//2 账户名不存在
//3 账户中仍存在余额，不能删除

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
//	public ArrayList<AccountVO> searchAccurateAccount_up(AccountVO vo);
	
	public AccountVO searchAccurateAccount_up(String name);

	//添加收款单
	public int addReceipt_up(GetVO vo);
	//添加付款单
	public int addPayment_up(PayVO vo);
	
	//获得当前操作员
	public String getOperator_up();
	
	//获得收款单编号
	public String getReceiptNote_up();
	
	//获得付款单编号
	public String getPaymentNote_up();
	
	//计算收款总额
	public double calTotalMoney_up(GetVO vo);
	public double calTotalMoney_up(PayVO vo);
	
	//获得当前登陆用户
	public UserVO getNowUser_up();
	
	//获得所有客户信息
	public ArrayList<CustomerVO> getAllCustomer_up();
	
	//获得所有账户信息
	public ArrayList<AccountVO> getAllAccount_up();
	
}
