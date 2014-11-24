package po;

import java.io.Serializable;

public class InvoicePO implements Serializable{
	String draft_condition;//�ݸ�
	String submit_condition;//�ύ״̬
	String approve_condition;//�����
	
	public InvoicePO(){
		
	}
	
	public InvoicePO(String draft_condition, String submit_condition,
			String approve_condition) {
		
		this.draft_condition = draft_condition;
		this.submit_condition = submit_condition;
		this.approve_condition = approve_condition;
	}

	public String getDraft_condition() {
		return draft_condition;
	}

	public String getSubmit_condition() {
		return submit_condition;
	}

	public String getApprove_condition() {
		return approve_condition;
	}
}
