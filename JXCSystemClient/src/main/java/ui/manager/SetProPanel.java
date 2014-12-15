package ui.manager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;

import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CommodityVO;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;


public class SetProPanel extends FatherPanel implements ActionListener{
	private ManagerAllUIController uiController;
	private MyFrame frame;
	private JRadioButton[] levels = new JRadioButton[5];
	private MyTextFieldTrans[] time = new MyTextFieldTrans[2];
	private MyTextFieldTrans[] voucher = new MyTextFieldTrans[3];
	private MyTextFieldTrans[] discount = new MyTextFieldTrans[3];
	private MyComboBox commodity;
	private MyTextFieldTrans number,price;
	
//	private CommodityblService commodityblService;
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
//		commodityblService = new CommodityController();
		uiController.setBack_first(this);
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
		if()
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
			uiController.setTempPanel(SetProPanel.this);
			frame.remove(SetProPanel.this);
			if(e.getSource() == forwardButtons[0]){
				dis = new DiscountVO(time[0].getText(),time[1].getText(),Double.parseDouble(discount[0].getText()),
						Double.parseDouble(discount[2].getText()),Double.parseDouble(discount[1].getText()),level);
				
				discount();
				uiController.confirmProDis(dis);
				
			}else if(e.getSource() == forwardButtons[1]){
				vou = new VoucherVO(time[0].getText(),time[1].getText(),Double.parseDouble(voucher[0].getText()),
						Double.parseDouble(voucher[2].getText()),Double.parseDouble(voucher[1].getText()),level);
			
				
				uiController.confirmProVou(vou);
			}else if(e.getSource() == forwardButtons[2]){
				//ProGiftVO(CommodityVO commodity,int number,String start_time,
				//String end_time,double start_money,int level){
				String selectedName = commodity.getSelectedItem().toString();
				CommodityVO commodityVO = commodityblService.searchAccurateCommodity_up(selectedName);
				gift = new ProGiftVO(commodityVO,Integer.parseInt(number.getText()),time[0].getText(),time[1].getText(),0,level);
				
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
//		String [] rolesList = new String[]{"a","b"};
//		commodity = new MyComboBox(rolesList,471, 443, 156, 27);
		number = new MyTextFieldTrans(471,476, 156, 27);
		price = new MyTextFieldTrans(509, 408,130 ,27);
//		String [] rolesList = new String[]{"a","b"};
		ArrayList<CommodityVO> accVOArray = commodityblService.getAllCommodity_up();
			String[] rolesList = new String[accVOArray.size()];
			for (int i = 0; i < accVOArray.size(); i++) {
				rolesList[i] = accVOArray.get(i).name;
			}
		commodity = new MyComboBox(rolesList,471, 423, 156, 32);
		number = new MyTextFieldTrans(471,463, 156, 32);
		
		price.setFont(new FontFactory(18).font);
		number.setFont(new FontFactory(18).font);
		
		price.setForeground(new ColorFactory().greyFont);
		number.setForeground(new ColorFactory().greyFont);
		
		this.add(price);
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
			levels[i].setBounds(116,305+42*i,223,44);
			
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
