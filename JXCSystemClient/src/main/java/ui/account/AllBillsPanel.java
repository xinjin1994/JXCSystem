package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
/**
 * 查询经营历程对话框
 * @author ZYC
 * 
 */
public class AllBillsPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		
		this.repaint();
		uiController.setBack_second(this,141,57);
		setTextField();
		setForward();
	}
	
	private void setForward() {
		// TODO Auto-generated method stub
		
	}

	private void setTextField() {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
