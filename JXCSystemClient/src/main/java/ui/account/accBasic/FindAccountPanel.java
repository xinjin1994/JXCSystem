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
import ui.setting.SetTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 查找账户对话框
 * @author ZYC
 * 
 */
public class FindAccountPanel extends FatherPanel implements ActionListener{
	private ColorFactory colors = new ColorFactory();;
	MyTable showTable;
	ManagerAllUIController managerController;
	AccountAllUIController accountController;
	AccountblService accountblService;
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,info;
	private String nameString,infoString;
	private MyFrame frame;
	private String type = "account";
	private String failedAddress;
	
	private ResultPanelController resController;
	private AccountAllUIController accountAllUIController;
	public FindAccountPanel(MyFrame frame,String url,
			AccountAllUIController accountController){
		super(frame,url,accountController);
		
		this.frame = frame;
		this.accountController =accountController;
		this.repaint();
		accountblService = new AccountController();
		resController = new ResultPanelController(frame, this);
		accountController.setBack_second(this,150,130);
		init();
		this.failedAddress = "acc/accManage/finAcc";
	}
	
	public FindAccountPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.frame = frame;
		this.managerController =uiController;
		this.repaint();
		this.type = type;
		accountblService = new AccountController();
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "manager/accManage/delAcc";
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
		new SetTable(showTable, frame, accountAllUIController);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exactForwardButton){
			nameString = name.getText();
			if(nameString.equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			}else{
				if(getFoundAcc() != null){
					name.setText("");
					frame.remove(FindAccountPanel.this);
					if(type.equals("account")){
						accountController.accountDetail(getFoundAcc());
					}else if(type.equals("manager")){
						managerController.accountDetail(getFoundAcc());
					}
				}else {
					frame.remove(this);
					resController.failed("不存在该账户！", failedAddress);
				}
			}
		}else if(e.getSource() == fuzzyForwardButton){
			infoString = info.getText();
			if(infoString.equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			}else{
				info.setText("");
				ArrayList<AccountVO> fuzzyAccVO = accountblService.searchFuzzyAccount_up(infoString);	
				ArrayList <String> infoArray = new ArrayList<String>();
				infoArray.add("账户名称;账户余额");
				/*for(int i=0; i<fuzzyAccVO.size();i++){
				String infoOfArray = fuzzyAccVO.get(i).name+";"+fuzzyAccVO.get(i).balance;
				infoArray.add(infoOfArray);
			}*/
				if(infoArray.size() != 1){
					setTable(infoArray);
				}else {
					frame.remove(this);
					resController.failed("不存在相关账户信息！", failedAddress);
				}
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
