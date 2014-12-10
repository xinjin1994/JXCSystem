package ui.manager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;

public class ProDetailPanel extends FatherPanel{
	private ManagerAllUIController uiController;
	private MyFrame frame;
	private ProGiftVO gift;
	private VoucherVO voucher;
	private DiscountVO discount;
	
	private MyLabel typeLabel,levelLabel,timeBeginLabel,timeEndLabel;
	private int level;
	
	private String timeBegin,timeEnd;
	
	public ProDetailPanel(MyFrame frame, String url, ManagerAllUIController controller,ProGiftVO gift) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.gift = gift;
		this.level = gift.getLevel();
		
		this.timeBegin = gift.getStartTime();
		this.timeEnd = gift.getEndTime();
		
		this.repaint();
		
		init();
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/gift_stop.png"));
		setGiftLabels();
	}
	


	public ProDetailPanel(MyFrame frame, String url, ManagerAllUIController controller,VoucherVO voucher) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.voucher = voucher;
		this.level = voucher.getLevel();
		
		this.timeBegin = voucher.getStartTime();
		this.timeEnd = voucher.getEndTime();
		
		this.repaint();
		
		init();
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/cash_stop.png"));
		setVoucherLabel();
	}
	


	public ProDetailPanel(MyFrame frame, String url, ManagerAllUIController controller,DiscountVO discount) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.discount = discount;
		this.level = discount.getLevel();
		
		this.timeBegin = discount.getStartTime();
		this.timeEnd = discount.getEndTime();
		
		this.repaint();
		
		init();
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/discount_stop.png"));
		setDiscountLabels();
	}
	
	
	protected void init() {
		uiController.setBack_first(this);
		typeLabel = new MyLabel(355, 271, 46, 115);
		setTime();	
		setLevel();
	}
	
	
	protected void setLevel() {
		switch (level) {
		case 1:
			levelLabel = new MyLabel(87, 306,212, 44);
			levelLabel.setIcon(new ImageIcon(""));
			break;
		case 2:
			levelLabel = new MyLabel(87, 350,212, 44);
			levelLabel.setIcon(new ImageIcon(""));
			break;
		case 3:
			levelLabel = new MyLabel(87, 394,212, 44);
			levelLabel.setIcon(new ImageIcon(""));
			break;
		case 4:
			levelLabel = new MyLabel(87, 438,212, 44);
			levelLabel.setIcon(new ImageIcon(""));
			break;
		case 5:
			levelLabel = new MyLabel(87, 482,212, 44);
			levelLabel.setIcon(new ImageIcon(""));
			break;
		default:
			break;
		}
	}

	protected void setTime() {
		timeBeginLabel = new MyLabel(87,224, 112, 42);
		timeEndLabel = new MyLabel(200, 224, 112, 42);
		
		
		this.add(timeBeginLabel);
		this.add(timeEndLabel);
		
	}
	
	private void setGiftLabels() {
		MyLabel commodity = new MyLabel(471, 423, 156, 32);
		MyLabel number = new MyLabel(471, 463, 156, 32);
		
		commodity.setText(gift.commodity.name);
		number.setText(String.valueOf(gift.number));
		
		this.add(commodity);
		this.add(number);
	}
	
	private void setVoucherLabel() {
		MyLabel start_money = new MyLabel(551,277,76,27);
		MyLabel money = new MyLabel(551,313, 76, 27);
		MyLabel end_money = new MyLabel(551,347,76,27);
		
		start_money.setText(String.valueOf(voucher.start_money));
		money.setText(String.valueOf(voucher.money));
		end_money.setText(String.valueOf(voucher.end_money));
		
		this.add(start_money);
		this.add(money);
		this.add(end_money);
		
	}
	
	private void setDiscountLabels() {
		MyLabel start_money = new MyLabel(551,147,120,28);
		MyLabel money = new MyLabel(551,181, 120, 28);
		MyLabel end_money = new MyLabel(551,220,120,28);
		
		start_money.setText(String.valueOf(discount.getStartMoney()));
		money.setText(String.valueOf(discount.getDiscontMoney()));
		end_money.setText(String.valueOf(discount.getEndMoney()));
		
		this.add(start_money);
		this.add(money);
		this.add(end_money); 
	}


}
