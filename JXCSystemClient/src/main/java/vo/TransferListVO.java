package vo;

public class TransferListVO {
	public String bankAccount;
	public double transferValue;
	public String remark;
	public TransferListVO(String bankAccount,double transferValue,String remark){
		//银行账户，转账金额，备注。
		this.bankAccount=bankAccount;
		this.transferValue=transferValue;
		this.remark=remark;
	}
}
