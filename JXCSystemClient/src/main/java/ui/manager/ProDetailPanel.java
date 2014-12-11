package ui.manager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;

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
		
		uiController.setBack_first(this);
		
		init();
		typeLabel = new MyLabel(355, 400, 46, 115);
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/gift_stop.png"));
		this.add(typeLabel);
		typeLabel.setVisible(true);
		
		setGiftLabels();
		this.repaint();
	}
	


	public ProDetailPanel(MyFrame frame, String url, ManagerAllUIController controller,VoucherVO voucher) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.voucher = voucher;
		this.level = voucher.getLevel();
		
		this.timeBegin = voucher.getStartTime();
		this.timeEnd = voucher.getEndTime();
		
		
		init();
		typeLabel = new MyLabel(355, 271, 46, 115);
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/cash_stop.png"));
		this.add(typeLabel);
		typeLabel.setVisible(true);
		
		setVoucherLabel();
		this.repaint();
	}
	


	public ProDetailPanel(MyFrame frame, String url, ManagerAllUIController controller,DiscountVO discount) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.discount = discount;
		this.level = discount.getLevel();
		
		this.timeBegin = discount.getStartTime();
		this.timeEnd = discount.getEndTime();
		
		init();
		typeLabel = new MyLabel(355, 141, 46, 115);
		typeLabel.setIcon(new ImageIcon("Image/Manager/promotion/discount_stop.png"));
		typeLabel.setVisible(true);
		this.add(typeLabel);
	
		setDiscountLabels();
		this.repaint();
	}
	
	
	protected void init() {
		uiController.setBack_first(this);
		setTime();	
		setLevel();
	}
	
	protected void setLevel() {
		switch (level) {
		case 1:
			levelLabel = new MyLabel(92, 306,212, 44);
			levelLabel.setIcon(new ImageIcon("Image/Manager/promotion/level1.png"));
			break;
		case 2:
			levelLabel = new MyLabel(92, 350,212, 44);
			levelLabel.setIcon(new ImageIcon("Image/Manager/promotion/level2.png"));
			break;
		case 3:
			levelLabel = new MyLabel(92, 394,212, 44);
			levelLabel.setIcon(new ImageIcon("Image/Manager/promotion/level3.png"));
			break;
		case 4:
			levelLabel = new MyLabel(92, 438,212, 44);
			levelLabel.setIcon(new ImageIcon("Image/Manager/promotion/level4.png"));
			break;
		case 5:
			levelLabel = new MyLabel(92, 482,212, 44);
			levelLabel.setIcon(new ImageIcon("Image/Manager/promotion/level5.png"));
			break;
		default:
			break;
		}
		levelLabel.setVisible(true);
		this.add(levelLabel);
	}

	protected void setTime() {
		timeBeginLabel = new MyLabel(87,224, 112, 42);
		timeEndLabel = new MyLabel(200, 224, 112, 42);
		
		timeBeginLabel.setText(timeBegin);
		timeEndLabel.setText(timeEnd);
		
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
