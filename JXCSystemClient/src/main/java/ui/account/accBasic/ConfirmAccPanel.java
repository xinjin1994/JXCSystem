package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.account.AccountAllUIController;
import ui.account.AccountDetailPanel;
import ui.manager.ManagerAllUIController;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;

public class ConfirmAccPanel extends AccountDetailPanel implements ActionListener{
	
	MyButton forwardButtonAdd,forwardButtonDel,forwardButtonCha;
	AccountblService accountblService;
	AccountVO acc,newAcc;
	String ope;
	ResultPanelController resControllerS,resControllerF;
	String type = "account";
	/**
	 * 
	 * @param frame
	 * @param url
	 * @param uiController
	 * @param foundAcc
	 * @param ope   解析操作，有添加账户，删除账户两种类型的操作
	 */
	public ConfirmAccPanel(MyFrame frame, String url,
			AccountAllUIController uiController, AccountVO acc,String ope) {
		super(frame, url, uiController, acc);
	
		this.acc = acc;
		this.ope = ope;
		SetBackAcc();
		accountblService = new AccountController();
		resControllerS = new ResultPanelController(frame,uiController.getMainPanel());
		resControllerF = new ResultPanelController(frame, uiController.getPanel());
		setOpe();
	}
	
	public ConfirmAccPanel(MyFrame frame, String url,
			AccountAllUIController uiController, AccountVO acc,String ope,AccountVO newAcc) {
		super(frame, url, uiController, newAcc);
		this.acc = acc;
		this.newAcc = newAcc;
		this.ope = ope;
		System.out.println(newAcc.name);
		SetBackAcc();
		accountblService = new AccountController();
		resControllerS = new ResultPanelController(frame, uiController.getMainPanel());
		resControllerF = new ResultPanelController(frame, uiController.getPanel());
		setOpe();
	}
	public ConfirmAccPanel(MyFrame frame, String url,
			ManagerAllUIController uiController, AccountVO acc,String ope,String type) {
		super(frame, url, uiController, acc);
		this.acc = acc;
		this.ope = ope;
		this.type = type;
		SetBackMan();
		accountblService = new AccountController();
		resControllerS = new ResultPanelController(frame, uiController.getMainPanel());
		resControllerF = new ResultPanelController(frame, uiController.getPanel());
		setOpe();
	}

	public ConfirmAccPanel(MyFrame frame, String url,
			ManagerAllUIController uiController, AccountVO acc,String ope,String type,AccountVO newAcc) {
		super(frame, url, uiController, newAcc);
		this.acc = acc;
		this.newAcc = newAcc;
		this.ope = ope;
		this.type = type;
		SetBackMan();
		accountblService = new AccountController();
		resControllerS = new ResultPanelController(frame, uiController.getMainPanel());
		resControllerF = new ResultPanelController(frame, uiController.getPanel());
		setOpe();
	}
	protected void SetBackAcc(){
		accountController.setBack_third(ConfirmAccPanel.this);
	}
	protected void SetBackMan() {
		System.out.println("123");
		managerController.setBack_third(ConfirmAccPanel.this);
	}
	private void setOpe() {
		if(ope.equals("add")){
			setForwardAdd();
		}else if(ope.equals("del")){
			setForwardDel();
		}else if(ope.equals("change")){
			setForwardCha();
		}
	}

	private void setForwardCha() {
		ForwardButton forwardCha = new ForwardButton(607, 393);
		forwardButtonCha = forwardCha.forward_white;
		if(type.equals("account")){
			forwardButtonCha = forwardCha.forward_white;
		}else {
			forwardButtonCha = forwardCha.forward_black;
		}
		this.add(forwardButtonCha);
		forwardButtonCha.addActionListener(this);
	}

	private void setForwardDel() {
		ForwardButton forwardDel = new ForwardButton(607, 393);
		forwardButtonDel = forwardDel.forward_white;
		if(type.equals("account")){
			forwardButtonDel = forwardDel.forward_white;
		}else {
			forwardButtonDel = forwardDel.forward_black;
		}
		this.add(forwardButtonDel);
		forwardButtonDel.addActionListener(this);
	}

	private void setForwardAdd() {
		ForwardButton forwardAdd = new ForwardButton(607, 393);
		if(type.equals("account")){
			forwardButtonAdd = forwardAdd.forward_white;
		}else {
			forwardButtonAdd = forwardAdd.forward_black;
		}
		
		this.add(forwardButtonAdd);
		forwardButtonAdd.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButtonAdd){
			addAcc();
		}else if(e.getSource() == forwardButtonDel){
			delAcc();
		}else if(e.getSource() == forwardButtonCha){
			chaAcc(acc,newAcc);
		}
			
	}
		
	
	/**
	 * 向bl层传送数据accountVO，修改账户
	 */
	private void chaAcc(AccountVO acc,AccountVO newAcc) {
		switch(accountblService.updateAccount_up(acc,newAcc)){
		//-1 未知错误
		//1 账户名称重复
		//2 账户名不存在
		//3 账户中仍存在余额，不能删除
		case 0:
			frame.remove(this);
			resControllerS.succeeded("成功修改账户！", type);
			break;
		case 1:
			frame.remove(this);
			resControllerF.failedConfirm("账户名称重复！", type);
			break;
		case 2:
			frame.remove(this);
			resControllerF.failedConfirm("账户名不存在！", type);
			break;
		case -1:
			frame.remove(this);
			resControllerF.failedConfirm("未知错误！", type);
			break;
		}
	}

	/**
	 * 向bl层传送数据accountVO,删除账户
	 * @param 
	 */	
	private void delAcc() {
		switch(accountblService.delAccount_up(acc)){
		//-1 未知错误
		//1 账户名称重复
		//2 账户名不存在
		//3 账户中仍存在余额，不能删除
		case 0:
			frame.remove(this);
			resControllerS.succeeded("成功删除账户！", type);
			break;
		case 2:
			frame.remove(this);
			resControllerF.failedConfirm("账户名不存在！", type);
			break;
		case 3:
			frame.remove(this);
			resControllerF.failedConfirm("账户名中仍存在余额，不能删除！", type);
			break;
		case -1:
			frame.remove(this);
			resControllerF.failedConfirm("未知错误！", type);
			break;
		}
	}

	/**
	 * 向bl层传送数据accountVO,添加账户
	 * @param 
	 */
	private void addAcc() {
		switch(accountblService.addAccount_up(acc)){
		//-1 未知错误
		//1 账户名称重复
		//2 账户名不存在
		//3 账户中仍存在余额，不能删除
		case 0:
			frame.remove(this);
			resControllerS.succeeded("成功添加账户！", type);
			break;
		case 1:
			frame.remove(this);
			resControllerF.failedConfirm("账户名称重复！", type);
			break;
		case -1:
			frame.remove(this);
			resControllerF.failedConfirm("未知错误！", type);
			break;
		}
	}
	/**
	 * 当添加或者删除账户成功后显示结果Label
	 */
	
}
