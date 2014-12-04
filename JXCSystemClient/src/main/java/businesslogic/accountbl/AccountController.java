package businesslogic.accountbl;

import businesslogicservice.accountblservice.AccountblService;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CustomerVO;
import vo.GetVO;
import vo.PayVO;
import vo.UserVO;

public class AccountController implements AccountblService{
	public Account account=new Account();

	public AccountVO checkAccount_up() {
		// TODO Auto-generated method stub
		AccountVO message=account.checkAccount_up();
		return message;
	}

	public int addAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
		int message=account.addAccount_up(vo);
		return message;
	}

	public int delAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
		int message=account.delAccount_up(vo);
		return message;
	}

	public int updateAccount_up(AccountVO vo1,AccountVO vo2) {
		// TODO Auto-generated method stub
		int message=account.updateAccount_up(vo1,vo2);
		return message;
	}

	public ArrayList<AccountVO> searchFuzzyAccount_up(String word) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> result=account.searchFuzzyAccount_up(word);
		return result;
	}

	public int addReceipt_up(GetVO vo) {
		// TODO Auto-generated method stub
		int message=account.addReceipt_up(vo);
		return message;
	}

	public int addPayment_up(PayVO vo) {
		// TODO Auto-generated method stub
		int message=account.addPayment_up(vo);
		return message;
	}

	public ArrayList<AccountVO> searchAccurateAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOperator_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReceiptNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPaymentNote_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public int calTotalMoney_up(GetVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int calTotalMoney_up(PayVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserVO getNowUser_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CustomerVO> getAllCustomer_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AccountVO> getAllAccount_up() {
		// TODO Auto-generated method stub
		return null;
	}

}
