package ui.manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyComboBox;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldTrans;
import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;

public class SetProPanel extends FatherPanel implements ActionListener{
	private ManagerAllUIController uiController;
	private MyFrame frame;
	private JRadioButton[] levels = new JRadioButton[5];
	private MyTextFieldTrans[] time = new MyTextFieldTrans[2];
	private MyTextFieldTrans[] voucher = new MyTextFieldTrans[3];
	private MyTextFieldTrans[] discount = new MyTextFieldTrans[3];
	private MyComboBox commodity;
	private MyTextFieldTrans number;
	
	private int level;
	
	private MyButton forwardButtons[] = new MyButton[3];
	private ForwardButton forwards[] = new ForwardButton[3];
	
	private DiscountVO dis;
	private ProGiftVO gift;
	private VoucherVO vou;
	
	public SetProPanel(MyFrame frame, String url, ManagerAllUIController controller) {
		super(frame, url, controller);
		this.uiController = controller;
		this.frame = frame;
		this.repaint();

		setTime();
		setDiscountText();
		setVoucherText();
		setGiftText();
		setForward();
		
		setRadioButtons();
	}	private void setForward() {
		ForwardMouseListener listener = new ForwardMouseListener();
		for(int i = 0;i < forwards.length;i++){
			forwards[i] = new ForwardButton(700,175+i*132);
			forwardButtons[i] = forwards[i].forward_black;
			
			this.add(forwardButtons[i]);
			forwardButtons[i].addMouseListener(listener);
		}
		
	}
	private void discount(){
		
	}
	private void voucher(){
		
	}
	private void proGift(){
		
	}
	class ForwardMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			frame.remove(SetProPanel.this);
			if(e.getSource() == forwardButtons[0]){
				dis = new DiscountVO(time[0].getText(),time[1].getText(),Integer.parseInt(discount[0].getText()),
						Integer.parseInt(discount[2].getText()),Integer.parseInt(discount[1].getText()),level);
				
				uiController.confirmProDis(dis);
			}else if(e.getSource() == forwardButtons[1]){
				vou = new VoucherVO(time[0].getText(),time[1].getText(),Integer.parseInt(voucher[0].getText()),
						Integer.parseInt(voucher[2].getText()),Integer.parseInt(voucher[1].getText()),level);
			
				uiController.confirmProVou(vou);
			}else if(e.getSource() == forwardButtons[2]){
				//因为这里构建ProGiftVO需要CommodityVO，所以我就不出事或gift了==
				
				uiController.confirmProGift(gift);
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	private void setTime() {
		for(int i = 0; i < time.length;i++){
			time[i] = new MyTextFieldTrans(87+113*i,224, 112, 42);
			time[i].setForeground(new ColorFactory().accColor);
			this.add(time[i]);
		}
		
	}
	private void setGiftText() {
		String [] rolesList = new String[]{"a","b"};
		commodity = new MyComboBox(rolesList,471, 423, 156, 32);
		number = new MyTextFieldTrans(471,463, 156, 32);
		
		number.setFont(new FontFactory(18).font);
		number.setForeground(new ColorFactory().greyFont);
		this.add(commodity);
		this.add(number);
	}
	private void setVoucherText() {
		for(int i = 0;i < voucher.length;i++){
			voucher[i] = new MyTextFieldTrans(551,277+37*i,76,27);
			voucher[i].setFont(new FontFactory(18).font);
			voucher[i].setForeground(new ColorFactory().greyFont);
			this.add(voucher[i]);
		}
	}
	private void setDiscountText() {
		for(int i = 0;i < discount.length;i++){
			discount[i] = new MyTextFieldTrans(551, 147 + 37*i, 120, 27);
			discount[i].setFont(new FontFactory(18).font);
			discount[i].setForeground(new ColorFactory().greyFont);
			this.add(discount[i]);
		}
	}


	private void setRadioButtons() {
		ButtonGroup cusLevels = new ButtonGroup();
		for(int i = 0;i < 5;i++){
			levels[i] = new JRadioButton("",false);
			levels[i].setBorderPainted(false);
			levels[i].setContentAreaFilled(false);
			levels[i].setBounds(116,305+42*i,44,44);
			
			levels[i].setActionCommand("level"+(i+1));
			levels[i].addActionListener(this);
			
			levels[i].setOpaque(false);
			cusLevels.add(levels[i]);
			this.add(levels[i]);
		}
		
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("level1")){
			level = 1;
		}else if(e.getActionCommand().equals("level2")){
			level = 2;
		}else if (e.getActionCommand().equals("level3")) {
			level = 3;
		}else if (e.getActionCommand().equals("level4")) {
			level = 4;
		}else if (e.getActionCommand().equals("level5")) {
			level = 5;
		}
	}

}
