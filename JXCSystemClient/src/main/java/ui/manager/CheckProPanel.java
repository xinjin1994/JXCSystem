package ui.manager;

import java.awt.Color;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.CommodityVO;
import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionblService;
/**
 * 该类用于显示当前所有等级客户的优惠策略
 * @author ZYC
 *
 */
public class CheckProPanel extends FatherPanel{

	ManagerAllUIController uiController;
	MyFrame frame;
	MyLabel labels[][] = new MyLabel[5][8];
	PromotionblService promotionblService;
	public CheckProPanel(MyFrame frame, String url, ManagerAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.repaint();
		promotionblService = new PromotionController();
		uiController.setBack_first(this);
		setProLabels();
		setText();
	}
	/**
	 * 将现行的优惠策略显示，如果没有，数字的显示0，商品的显示无
	 */
	private void setText() {
		
	}
	private void setProLabels() {
		setLabels(98, 385, labels[0]);
		setLabels(247, 326, labels[1]);
		setLabels(401, 268, labels[2]);
		setLabels(550, 210, labels[3]);
		setLabels(698, 144, labels[4]);
		// DiscountVO(String time1,String time2,double start_money,double end_money,double discount_money,int level)
		//VoucherVO(String start_time,String end_time,double start_money,double end_money,double money,int level)
		//ProGiftVO(CommodityVO commodity,int number,String start_time,String end_time,double start_money,int level)
		ArrayList<DiscountVO> discount = promotionblService.getDiscount_up();
		ArrayList<VoucherVO> voucher = promotionblService.getVoucher_up();
		ArrayList<ProGiftVO> gift = promotionblService.getProGift_up();
		for(int j=0;j<discount.size();j++){
			DiscountVO dis = discount.get(j);
			int level = dis.level;
			labels[level][0].setText(dis.start_money+"");
			labels[level][1].setText(dis.end_money+"");
			labels[level][2].setText(dis.discount_money+"");
		}
		for(int j=0;j<voucher.size();j++){
			VoucherVO vou = voucher.get(j);
			int level = vou.level;
			labels[level][3].setText(vou.start_money+"");
			labels[level][4].setText(vou.end_money+"");
			labels[level][5].setText(vou.money+"");
		}
		for(int j=0;j<gift.size();j++){
			ProGiftVO gif = gift.get(j);
			int level = gif.getLevel();
//			labels[level][6].setText();
//			labels[level][7].setText();
		}
		
		
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 8;j++){
//				labels[i][j].setText("0");
				labels[i][j].setFont(new FontFactory(14).font);
				labels[i][j].setForeground(Color.white);
				this.add(labels[i][j]);
			}
		}
		for(int i = 0;i < 8;i++){
			labels[0][i].setForeground(new ColorFactory().greyFont);
		}
		for(int i = 0;i < 8;i++){
			labels[1][i].setForeground(new ColorFactory().greyFont);
		}
		for(int i = 0;i < 8;i++){
			
		}
		
	}
	
	private void setLabels(int x,int y,MyLabel[] la){
		la[0] = new MyLabel(x, y, 21, 14);
		la[1] = new MyLabel(x+42, y, 21, 14);
		la[2] = new MyLabel(x+14, y+30, 40, 14);
		la[3] = new MyLabel(x, y+55, 21, 14);
		la[4] = new MyLabel(x+42,y+55, 21, 14);
		la[5] = new MyLabel(x+14, y+93, 40, 14);
		la[6] = new MyLabel(x+14, y+115, 40, 14);
		la[7] = new MyLabel(x+14, y+150, 40, 14);
	}
	
}
