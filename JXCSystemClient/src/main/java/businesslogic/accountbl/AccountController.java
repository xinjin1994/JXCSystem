package businesslogic.accountbl;

import businesslogicservice.accountblservice.AccountblService;
import java.util.ArrayList;

import vo.AccountVO;
import vo.GetVO;
import vo.PayVO;

public class AccountController implements AccountblService{
	public Account account=new Account();

	public AccountVO checkAccount() {
		// TODO Auto-generated method stub
		AccountVO message=account.checkAccount();
		return message;
	}

	public int addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		int message=account.addAccount(vo);
		return message;
	}

	public int delAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		int message=account.delAccount(vo);
		return message;
	}

	public int updateAccount(AccountVO vo1,AccountVO vo2) {
		// TODO Auto-generated method stub
		int message=account.updateAccount(vo1,vo2);
		return message;
	}

	public ArrayList<AccountVO> searchAccount(String word) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> result=account.searchAccount(word);
		return result;
	}

	public int addReceipt(GetVO vo) {
		// TODO Auto-generated method stub
		int message=account.addReceipt(vo);
		return message;
	}

	public int addPayment(PayVO vo) {
		// TODO Auto-generated method stub
		int message=account.addPayment(vo);
		return message;
	}

}
