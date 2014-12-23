package businesslogic.accountbl;

import java.util.ArrayList;

import main.ClientStart;
import po.AccountPO;
import po.CustomerPO;
import po.ItemPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.TransferPO;
import vo.AccountVO;
import vo.CustomerVO;
import vo.bill.GetVO;
import vo.bill.ItemList;
import vo.bill.PayVO;
import vo.bill.TransferListVO;
import businesslogicservice.accountblservice.AccountblService;

public class AccountController implements AccountblService{
	public Account account=new Account();
	
	public AccountController(){
		account=ClientStart.account;
	}

	public AccountVO checkAccount_up() {
		// TODO Auto-generated method stub
		AccountPO po=account.checkAccount_up();
		AccountVO message=new AccountVO(po.name, po.money);
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
		ArrayList<AccountVO> result=new ArrayList<AccountVO>();
		ArrayList<AccountPO> po=account.searchFuzzyAccount_up(word);
		
		for(int i=0;i<po.size();i++){
			AccountVO vo=new AccountVO(po.get(i).getName(),po.get(i).getMoney());
			result.add(vo);
		}
		
		return result;
	}

	public int addReceipt_up(GetVO vo) {
		// TODO Auto-generated method stub
		CustomerPO cus=new CustomerPO(vo.cusName,0, true, "");
		ArrayList<TransferPO> trans=new ArrayList<TransferPO>();
		TransferPO tra=new TransferPO(vo.transferList.bankAccount,vo.transferList.transferValue,vo.transferList.remark);
		trans.add(tra);
		ReceiptPO po=new ReceiptPO(getOperator_up(), cus, trans);
		po.setNote(vo.note);
		po.setCondition(1);
		
		int message=account.addReceipt_up(po);
		return message;
	}

	public int addPayment_up(PayVO vo) {
		// TODO Auto-generated method stub
		
		ArrayList<ItemPO> item=new ArrayList<ItemPO>();
		ItemPO it=new ItemPO(vo.itemList.itemName,vo.itemList.money,vo.itemList.remark);
		item.add(it);
		AccountPO acc=new AccountPO(vo.bankAccount,0);
		PaymentPO po=new PaymentPO(acc, getOperator_up(), item);
		po.setCondition(1);
		po.setNote(vo.note);
		
		int message=account.addPayment_up(po);
		return message;
	}

	public ArrayList<AccountVO> searchAccurateAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> result=new ArrayList<AccountVO>();
		AccountPO po=account.searchAccurateAccount_up(vo.name);
		
		AccountVO vo1=new AccountVO(po.getName(),po.getMoney());
		result.add(vo1);
		return result;
	}

	public String getOperator_up() {
		// TODO Auto-generated method stub
		return account.getOperator();
	}

	public String getReceiptNote_up() {
		// TODO Auto-generated method stub
		return account.getReceiptNote();
	}

	public String getPaymentNote_up() {
		// TODO Auto-generated method stub
		return account.getPaymentNote();
	}

	public double calTotalMoney_up(GetVO vo) {
		// TODO Auto-generated method stub
		return vo.transferList.transferValue;
	}

	public double calTotalMoney_up(PayVO vo) {
		// TODO Auto-generated method stub
		return vo.itemList.money;
	}

//	public UserVO getNowUser_up() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public ArrayList<CustomerVO> getAllCustomer_up() {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> vo=new ArrayList<CustomerVO>();
		ArrayList<CustomerPO> po=account.getAllCustomer();
		for(int i=0;i<po.size();i++){
			CustomerVO cus=new CustomerVO(po.get(i).getId(),po.get(i).getType(),po.get(i).getLevel(),po.get(i).getName(),po.get(i).getPhone(),po.get(i).getAddress(),po.get(i).getZip(),po.get(i).getMail(),po.get(i).getAmount(),po.get(i).getMoneyIn(),po.get(i).getMoneyOut(),po.get(i).getClerk());
			vo.add(cus);
		}
		return vo;
	}

	public ArrayList<AccountVO> getAllAccount_up() {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> array=new ArrayList<AccountVO>();
		ArrayList<AccountPO> po=account.getAllAccount();
		AccountVO vo;
		for(int i=0;i<po.size();i++){
			vo=new AccountVO(po.get(i).getName(),po.get(i).getMoney());
			array.add(vo);
		}
		return array;
	}

	public int addDraftReceipt_up(GetVO vo) {
		// TODO Auto-generated method stub
		CustomerPO cus=new CustomerPO(vo.cusName,0, true, "");
		ArrayList<TransferPO> trans=new ArrayList<TransferPO>();
		TransferPO tra=new TransferPO(vo.transferList.bankAccount,vo.transferList.transferValue,vo.transferList.remark);
		ReceiptPO po=new ReceiptPO(getOperator_up(), cus, trans);
		po.setNote(vo.note);
		po.setCondition(0);
		
		
		return account.addDraftReceipt(po);
	}

	public ArrayList<GetVO> getAllDraftReceipt_up() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> po=account.getAllDraftReceipt();
		ArrayList<GetVO> array=new ArrayList<GetVO>();
		GetVO vo=null;
		for(int i=0;i<po.size();i++){
			TransferListVO trans=new TransferListVO(po.get(i).getTransfer().get(0).getAccount(),po.get(i).getTransfer().get(0).getMoney(),po.get(i).getTransfer().get(0).getPs());
			vo=new GetVO(po.get(i).getNote(), po.get(i).getCustomer().getName(), po.get(i).getOperator(), trans,po.get(i).getTime(),po.get(i).getInvoiceNote());
			array.add(vo);
		}
		return array;
	}

	public GetVO searchDraftReceipt_up(String note) {
		// TODO Auto-generated method stub
//		ReceiptPO po=account.searchDraftReceipt(note);
		
		ArrayList<ReceiptPO> po=account.getAllDraftReceipt();
		GetVO vo=null;
		for(int i=0;i<po.size();i++){
			if(po.get(i).getNote().equals(note)){
				TransferListVO trans=new TransferListVO(po.get(i).getTransfer().get(0).getAccount(),po.get(i).getTransfer().get(0).getMoney(),po.get(i).getTransfer().get(0).getPs());
				vo=new GetVO(po.get(i).getNote(), po.get(i).getCustomer().getName(), po.get(i).getOperator(), trans,po.get(i).getTime(),po.get(i).getInvoiceNote());
			}
		}
		return vo;
	}

	public int addDraftPayment_up(PayVO vo) {
		// TODO Auto-generated method stub
		ArrayList<ItemPO> item=new ArrayList<ItemPO>();
		ItemPO it=new ItemPO(vo.itemList.itemName,vo.itemList.money,vo.itemList.remark);
		item.add(it);
		AccountPO acc=new AccountPO(vo.bankAccount,0);
		PaymentPO po=new PaymentPO(acc, getOperator_up(), item);
		po.setCondition(0);
		po.setNote(vo.note);
		
		int message=account.addDraftPayment(po);
		return message;
	}

	public ArrayList<PayVO> getAllDraftPayment_up() {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> po=account.getAllDraftPayment();
		ArrayList<PayVO> array=new ArrayList<PayVO>();
		PayVO vo=null;
		for(int i=0;i<po.size();i++){
				ItemList item=new ItemList(po.get(i).getItem().get(0).getItemName(),po.get(0).getItem().get(0).getMoney(),po.get(0).getItem().get(0).getPs());
				vo=new PayVO(po.get(i).getNote(),po.get(i).getOperator(),po.get(i).getAccount().getName(),item,po.get(i).getTime(),po.get(i).getInvoiceNote()); 
				array.add(vo);
		}
		return array;
	}

	public PayVO searchDraftPayment_up(String note) {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> po=account.getAllDraftPayment();
		PayVO vo=null;
		for(int i=0;i<po.size();i++){
			if(po.get(i).getNote().equals(note)){
				ItemList item=new ItemList(po.get(i).getItem().get(0).getItemName(),po.get(i).getItem().get(0).getMoney(),po.get(i).getItem().get(0).getPs());
				vo=new PayVO(po.get(i).getNote(),po.get(i).getOperator(),po.get(i).getAccount().getName(),item,po.get(i).getTime(),po.get(i).getInvoiceNote()); 
				return vo;
			}
		}
		return null;
	}

	public GetVO searchReceipt_up(String note) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> po=account.getAllReceipt();
		GetVO vo=null;
		for(int i=0;i<po.size();i++){
			if(po.get(i).getNote().equals(note)){
				TransferListVO trans=new TransferListVO(po.get(i).getTransfer().get(0).getAccount(),po.get(i).getTransfer().get(0).getMoney(),po.get(i).getTransfer().get(0).getPs());
				vo=new GetVO(po.get(i).getNote(), po.get(i).getCustomer().getName(), po.get(i).getOperator(), trans,po.get(i).getTime(),po.get(i).getInvoiceNote());
				return vo;
			}
		}
		return null;
	}

	public PayVO searchPayment_up(String note) {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> po=account.getAllPayment();
		PayVO vo=null;
		for(int i=0;i<po.size();i++){
			if(po.get(i).getNote().equals(note)){
				ItemList item=new ItemList(po.get(i).getItem().get(0).getItemName(),po.get(i).getItem().get(0).getMoney(),po.get(i).getItem().get(0).getPs());
				vo=new PayVO(po.get(i).getNote(),po.get(i).getOperator(),po.get(i).getAccount().getName(),item,po.get(i).getTime(),po.get(i).getInvoiceNote()); 
				return vo;
			}
		}
		return null;
	}

	public AccountVO searchAccurateAccount_up(String name) {
		// TODO Auto-generated method stub
		AccountPO po=account.searchAccurateAccount_up(name);
		AccountVO vo=new AccountVO(po.getName(),po.getMoney());
		return vo;
	}
	
	public ArrayList<GetVO> getAllReceipt_up(){
		ArrayList<ReceiptPO> po=account.getAllReceipt();
		ArrayList<GetVO> array=new ArrayList<GetVO>();
		GetVO vo=null;
		for(int i=0;i<po.size();i++){
			TransferListVO trans=new TransferListVO(po.get(i).getTransfer().get(0).getAccount(),po.get(i).getTransfer().get(0).getMoney(),po.get(i).getTransfer().get(0).getPs());
			vo=new GetVO(po.get(i).getNote(), po.get(i).getCustomer().getName(), po.get(i).getOperator(), trans,po.get(i).getTime(),po.get(i).getInvoiceNote());
			array.add(vo);
		}
		return array;
	}
	
	public ArrayList<PayVO> getAllPayment_up(){
		ArrayList<PaymentPO> po=account.getAllPayment();
		ArrayList<PayVO> array=new ArrayList<PayVO>();
		PayVO vo=null;
		for(int i=0;i<po.size();i++){
			ItemList item=new ItemList(po.get(i).getItem().get(0).getItemName(),po.get(i).getItem().get(0).getMoney(),po.get(i).getItem().get(0).getPs());
			vo=new PayVO(po.get(i).getNote(),po.get(i).getOperator(),po.get(i).getAccount().getName(),item,po.get(i).getTime(),po.get(i).getInvoiceNote()); 
			array.add(vo);
		}
		return array;
	}
}
