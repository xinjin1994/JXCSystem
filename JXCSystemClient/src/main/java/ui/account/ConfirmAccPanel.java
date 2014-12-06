package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.accountbl.Account;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;

public class ConfirmAccPanel extends AccountDetailPanel implements ActionListener{
	
	MyButton forwardButtonAdd,forwardButtonDel,forwardButtonCha;
	AccountVO acc;
	String ope;
	ResultPanelController resController;
	AccountAllUIController uiController;
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
		this.uiController = uiController;
		resController = new ResultPanelController(uiController,frame);
		setOpe();
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
		
		this.add(forwardButtonCha);
		forwardButtonDel.addActionListener(this);
	}

	private void setForwardDel() {
		ForwardButton forwardDel = new ForwardButton(607, 393);
		forwardButtonDel = forwardDel.forward_white;
		
		this.add(forwardButtonDel);
		forwardButtonDel.addActionListener(this);
	}

	private void setForwardAdd() {
//		System.out.println("kld");
		ForwardButton forward = new ForwardButton(607, 393);
		forwardButtonAdd = forward.forward_white;
		
		this.add(forwardButtonAdd);
		forwardButtonAdd.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButtonAdd){
			addAcc();
		}else if(e.getSource() == forwardButtonDel){
			delAcc();
		}else if(e.getSource() == forwardButtonCha){
			chaAcc();
		}
			
	}
		
	
	/**
	 * 向bl层传送数据accountVO，修改账户
	 */
	private void chaAcc() {
		frame.remove(this);
		resController.accSucceeded("成功修改账户！");
	}

	/**
	 * 向bl层传送数据accountVO,删除账户
	 * @param 
	 */	
	private void delAcc() {
		frame.remove(this);
		resController.accSucceeded("成功删除账户！");
	}

	/**
	 * 向bl层传送数据accountVO,添加账户
	 * @param 
	 */
	private void addAcc() {
		frame.remove(this);
		System.out.println("kl");
		resController.accSucceeded("成功新增账户！");
		

	}
	/**
	 * 当添加或者删除账户成功后显示结果Label
	 */
	
}
