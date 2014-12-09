package ui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;

public class ConfirmProPanel extends ProDetailPanel implements ActionListener{
	
	ResultPanelController resController;
	private MyFrame frame;
	private ManagerAllUIController uiController;
	private MyButton forwardButton;
	
	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, DiscountVO discount) {
		super(frame, url, controller, discount);
		addPro();
		forwardButton.setActionCommand("discount");
		
	}

	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, VoucherVO voucher) {
		super(frame, url, controller, voucher);
		addPro();
		forwardButton.setActionCommand("voucher");
		
	}

	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, ProGiftVO gift) {
		super(frame, url, controller, gift);
		addPro();
		forwardButton.setActionCommand("gift");
	}
	/**
	 * 下面三个方法用于向下层传新增的促销策略
	 */
	private void addProGift() {
		System.out.println("gift");
	}


	private void addDiscount() {
		System.out.println("discount");
	}

	private void addVoucher() {
		System.out.println("voucher");
	}
	
	private void addPro() {
		ForwardButton forwardDel = new ForwardButton(700,445);
		forwardButton = forwardDel.forward_black;		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		resController = new ResultPanelController(controller, frame);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("discount")){
			addDiscount();
			resController.successed("成功添加一个折扣促销策略！", "manager");
		}else if(e.getActionCommand().equals("voucher")) {
			addVoucher();
			resController.successed("成功添加一个优惠券促销策略！", "manager");
		}else if (e.getActionCommand().equals("gift")) {
			addProGift();
			resController.successed("成功添加一个赠品促销策略！", "manager");
		}
	}

}
