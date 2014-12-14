package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 查找账户对话框
 * @author ZYC
 * 
 */
public class FindAccountPanel extends FatherPanel implements ActionListener{
	private ColorFactory colors;
	MyTable showTable;
	ManagerAllUIController managerController;
	AccountAllUIController accountController;
	AccountblService accountblService;
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,info;
	private String nameString,infoString;
	private MyFrame frame;
	private String type = "account";
	private MyLabel failLabel;
	
	public FindAccountPanel(MyFrame frame,String url,
			AccountAllUIController accountController){
		super(frame,url,accountController);
		colors = new ColorFactory();
		this.frame = frame;
		this.accountController =accountController;
		this.repaint();
		accountblService = new AccountController();
		accountController.setBack_second(this,150,130);
		init();
		addLabel();
	}
	
	public FindAccountPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.managerController =uiController;
		this.repaint();
		this.type = type;
		
		uiController.setBack_second(this,150,130);
		init();
	}
	
	private void init() {
		setForward();
		setTextField();
	}
	
	/**
	 * 前进按钮
	 * @param exactForwardButton 精确查找
	 * @param fuzzyForwardButton 模糊查找
	 * @see ForwardButton
	 */
	private void setForward() {
		ForwardButton exactForward = new ForwardButton(600, 231);
		ForwardButton fuzzyForward = new ForwardButton(600, 369);
		
		exactForwardButton = exactForward.forward_white;
		fuzzyForwardButton = fuzzyForward.forward_white;
		
		this.add(exactForwardButton);
		this.add(fuzzyForwardButton);
		
		exactForwardButton.addActionListener(this);
		fuzzyForwardButton.addActionListener(this);
	}
	/**
	 * 设置输入框
	 * @see MyTextFieldBoarder
	 * @see ColorFactory
	 */
	private void setTextField() {
		name = new MyTextFieldBorder(225, 234);
		info = new MyTextFieldBorder(225, 368);
		
		name.setForeground(new ColorFactory().greyFont);
		info.setForeground(new ColorFactory().greyFont);
		
		this.add(name);
		this.add(info);
		
	}
	
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.remove(this);
		frame.add(showTable.tablePanel);
		accountController.addMainPanel();
		frame.repaint();
	}
	
	public void addLabel() {
		failLabel = new MyLabel(245, 440, 200, 35);
		this.add(failLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exactForwardButton){
			nameString = name.getText();
			if(nameString.equals("")){
				failLabel.setText("请正确输入信息！");
			}else{
			name.setText("");
			
			frame.remove(FindAccountPanel.this);
			if(type.equals("account")){
				accountController.accountDetail(getFoundAcc());
			}else if(type.equals("manager")){
				managerController.accountDetail(getFoundAcc());
				}
			}
		}else if(e.getSource() == fuzzyForwardButton){
			infoString = info.getText();
			if(infoString.equals("")){
				failLabel.setText("请正确输入信息！");
			}else{
			info.setText("");
			ArrayList<AccountVO> fuzzyAccVO = accountblService.searchFuzzyAccount_up(infoString);	
			ArrayList <String> infoArray = new ArrayList<String>();
			infoArray.add("账户名称;账户余额");
			/*for(int i=0; i<fuzzyAccVO.size();i++){
				String infoOfArray = fuzzyAccVO.get(i).name+";"+fuzzyAccVO.get(i).balance;
				infoArray.add(infoOfArray);
			}*/
				setTable(infoArray);
			}
			//返回主界面列表显示所有可能account
		}
		
	}
	private AccountVO getFoundAcc() {
		AccountVO foundAcc = accountblService.searchAccurateAccount_up(nameString);
		//从bl层获得的Account
		return foundAcc;
	}
}