package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CustomerVO;
import vo.UserVO;
import vo.bill.GetVO;
import vo.bill.PayVO;

//int错误类型：
//-1 未知错误
//1 账户名称重复
//2 账户名不存在
//3 账户中仍存在余额，不能删除
//4 客户不存在

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
	public AccountVO searchAccurateAccount_up(String name);
	
	//添加收款单
	public int addReceipt_up(GetVO vo);
	//添加草稿收款单
	public int addDraftReceipt_up(GetVO vo);
	//获得所有的草稿收款单
	public ArrayList<GetVO> getAllDraftReceipt_up();
	//根据编号查找收款单
	public GetVO searchReceipt_up(String note);
	//根据编号查找草稿收款单
	public GetVO searchDraftReceipt_up(String note);
	
	//添加付款单
	public int addPayment_up(PayVO vo);
	//添加草稿付款单
	public int addDraftPayment_up(PayVO vo);
	//获得所有的草稿付款单
	public ArrayList<PayVO> getAllDraftPayment_up();
	//根据编号查找付款单
	public PayVO searchPayment_up(String note);
	//根据编号查找草稿付款单
	public PayVO searchDraftPayment_up(String note);
	
	//获得当前操作员
	public String getOperator_up();
	
	//获得收款单编号
	public String getReceiptNote_up();
	//获得付款单编号
	public String getPaymentNote_up();
	
	//计算收付款总额
	public double calTotalMoney_up(GetVO vo);
	public double calTotalMoney_up(PayVO vo);
	
	//获得当前登陆用户
	public UserVO getNowUser_up();
	
	//获得所有客户信息
	public ArrayList<CustomerVO> getAllCustomer_up();
	
	//获得所有账户信息
	public ArrayList<AccountVO> getAllAccount_up();
	
	
}
