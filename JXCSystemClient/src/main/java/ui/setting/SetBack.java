package ui.setting;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.Button.BackButton;
import ui.setting.Button.MyButton;

public class SetBack {
	FatherPanel prePanel;
	MyButton backButton,backButtonConfirm;
	MyFrame frame;
	UIController controller;
	
	public SetBack(MyFrame frame,UIController controller,FatherPanel prePanel) {
		this.frame = frame;
		this.controller = controller;
		this.prePanel = prePanel;
	}
	
	public void setBack_first(){
		
		BackButton back = new BackButton();
		backButton = back.back_white;
		setBack();
	}
	
	public void setBack_second(int x,int y){
		BackButton back = new BackButton(x,y);
		backButton = back.back_black;
		setBack();
	}
	
	public void setBack_third() {
		BackButton back = new BackButton();
		backButtonConfirm = back.back_white;
		Listener backListener = new Listener();
		prePanel.add(backButtonConfirm);
		backButtonConfirm.addMouseListener(backListener);
	}
	
	public void setBack(){
		Listener backListener = new Listener();
		prePanel.add(backButton);
		backButton.addMouseListener(backListener);
	}
	
	
	   class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == backButton){
				frame.remove(prePanel);
				frame.setPanel(controller.getMainPanel());
				frame.repaint();
			}else if(e.getSource() == backButtonConfirm){
				frame.remove(prePanel);
				frame.setPanel(controller.getPanel());
				frame.repaint();
			}
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		   

//		public void actionPerformed(ActionEvent e) {
//			if(e.getActionCommand().equals("back")){
//				System.out.println("klk");
//				frame.remove(prePanel);
//				delAccountPanel = new DelAccountPanel(frame,"Image/Account/删除账户.jpg",AccountAllUIController.this);
//				frame.setPanel(delAccountPanel);
//				frame.repaint();
//				
//			}
//		
		
	}


}
