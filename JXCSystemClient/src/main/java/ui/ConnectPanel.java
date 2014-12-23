package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;

public class ConnectPanel extends FatherPanel implements ActionListener{

	private MyFrame frame;
	private UIController uiController;
	private MyButton forwardButton;
	private MyTextFieldBorder ipTextField;
	private String ip;
	
	public ConnectPanel(MyFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		setTextField();
		setForward();
	}


	private void setForward() {
		ForwardButton forward = new ForwardButton(390, 350);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}


	private void setTextField() {
		ipTextField = new MyTextFieldBorder(250, 250);
		this.add(ipTextField);
		ipTextField.setForeground(new ColorFactory().greyFont);
		this.add(ipTextField);
	}


	public void actionPerformed(ActionEvent arg0) {
		ip = ipTextField.getText();
		
		frame.remove(this);
		ipTextField.setText("");
		uiController.loginPanel();
	}

	/**
	 * 
	 */
}
