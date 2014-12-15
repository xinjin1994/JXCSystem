package ui.manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.ManagerPanel;
import ui.ManagerPanel.InvoiceButtonListener;
import ui.setting.Button.MyButton;

public class InvoiceBills {
	ManagerPanel managerPanel;
	private MyButton approveButton,refuseButton;
	
	public InvoiceBills(ManagerPanel managerPanel) {
		this.managerPanel = managerPanel;
		
	}
	public void setThirdPanelButton(){
		InvoiceButtonListener listener = new InvoiceButtonListener();
		approveButton = new MyButton("Image/Manager/button/proManage/approve.png", 290, 450,
				"Image/Manager/button/proManage/approve_stop.png", "Image/Manager/button/proManage/approve.png");
		refuseButton = new MyButton("Image/Manager/button/proManage/refuse.png", 355, 450,
				"Image/Manager/button/proManage/refuse_stop.png","Image/Manager/button/proManage/refuse.png");
		managerThirdPanel.add(approveButton);
		managerThirdPanel.add(refuseButton);
		
		approveButton.addMouseListener(listener);
		refuseButton.addMouseListener(listener);
		
		managerThirdPanel.repaint();
		this.repaint();
	}
	private void check(int i){
		switch(i){
		case 1:
			frame.remove(managerPanel);
			resController.failed("单据不存在！", failedAddress);
			break;
		case 0:
			frame.remove(ManagerPanel.this);
			resController.succeeded("审批通过该单据！", "manager");
			break;
		case -1:
			frame.remove(ManagerPanel.this);
			resController.failed("审批单据出现错误！请检查操作！",failedAddress);
			break;
		default:
			break;
		}
	}
	class InvoiceButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == approveButton){
				check(invoiceblService.pass_up(vo));
			}else if (e.getSource() == refuseButton) {
				check(invoiceblService.refuse_up(note));
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
}
