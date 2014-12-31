package ui.sales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;

public class SalesResult implements ActionListener{
	/*
	 * sales模块操作返回结果界面
	 */
	UIController controller;
	FatherPanel resultPanel,oldPanel;
	MyFrame frame;
	MyLabel textLabel;
	MyButton forwardButton;
	FatherPanel backPanel;
	SalesUIController salesUIController;
	
	public SalesResult(MyFrame frame,UIController controller,SalesUIController salesUIController,
			FatherPanel backPanel){
		textLabel = new MyLabel(0, 263, 800, 55);
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		this.backPanel = backPanel;
//		resultPanel = new FatherPanel(frame, "Image/result/account_result.jpg", controller);

	}
	
	public void succeeded(String text){
		System.out.println("Ffdf");
			resultPanel = new FatherPanel(frame, "Image/Sales/sales_result.jpg", controller);
			setForward(resultPanel);
			textLabel.setText(text);
			setPanel(resultPanel);
		}

		public void failed(String text,String type){
			resultPanel = new FatherPanel(frame, "Image/Sales/fail/"+type+".jpg", controller);
			setForward(resultPanel);
			
			forwardButton.setActionCommand("failed");
			textLabel.setText(text);
			setPanel(resultPanel);
		}
		
		private void setPanel(FatherPanel resultPanel) {
			resultPanel.add(textLabel);
			resultPanel.add(forwardButton);
			frame.remove(backPanel);
			frame.setPanel(resultPanel);
			frame.repaint();
		}

		private void setForward(FatherPanel resultPanel) {
			ForwardButton forward = new ForwardButton(382, 327);
			forwardButton = forward.forward_black;
			resultPanel.add(forwardButton);
			forwardButton.setActionCommand("succ");
			forwardButton.addActionListener(this);	
		}



		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("succ")){
				salesUIController.backPanel(resultPanel);
			}else if(e.getActionCommand().equals("failed")){
				frame.remove(resultPanel);
				frame.setPanel(backPanel);
				frame.repaint();
			}
			
		}


}
