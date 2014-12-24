package ui.manager;

import java.awt.Color;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
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
	
	MyLabel labels[][] = new MyLabel[5][9];
	PromotionblService promotionblService;

	public CheckProPanel(MyFrame frame, String url, ManagerAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.repaint();
		promotionblService = new PromotionController();

		uiController.setBack_first(this);
		setProLabels();
	}

	private void setProLabels() {
		setLabels(98, 385, labels[0]);//level1
		setLabels(247, 326, labels[1]);//level2
		setLabels(401, 268, labels[2]);//level3
		setLabels(550, 210, labels[3]);//level4
		setLabels(698, 144, labels[4]);//level5
		// DiscountVO(String time1,String time2,double start_money,double end_money,double discount_money,int level)
		//VoucherVO(String start_time,String end_time,double start_money,double end_money,double money,int level)
		//ProGiftVO(CommodityVO commodity,int number,String start_time,String end_time,double start_money,int level)
		ArrayList<DiscountVO> discount = promotionblService.getDiscount_up();
		ArrayList<VoucherVO> voucher = promotionblService.getVoucher_up();
		ArrayList<ProGiftVO> gift = promotionblService.getProGift_up();

		if(discount!=null){
			for(int j=0;j<discount.size();j++){
				DiscountVO dis = discount.get(j);
				int level = dis.level-1;
				labels[level][0].setText(dis.start_money+"");
				labels[level][1].setText(dis.end_money+"");
				labels[level][2].setText(dis.discount_money+"");
			}
		}
		if(voucher != null){
			for(int j=0;j<voucher.size();j++){
				VoucherVO vou = voucher.get(j);
				int level = vou.level-1;
				labels[level][3].setText(vou.start_money+"");
				labels[level][4].setText(vou.end_money+"");
				labels[level][5].setText(vou.money+"");
			}
		}
		if(gift != null){
			for(int j=0;j<gift.size();j++){
				ProGiftVO gif = gift.get(j);
				int level = gif.getLevel()-1;
				labels[level][6].setText(gif.start_money+"");
				labels[level][7].setText(gif.commodity.id);
				labels[level][8].setText(gif.number+"");

			}
		}

		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 9;j++){
				labels[i][j].setFont(new FontFactory(12).font);
				labels[i][j].setForeground(Color.white);
				this.add(labels[i][j]);
			}
		}
		
	}
	
	private void setLabels(int x,int y,MyLabel[] la){
		la[0] = new MyLabel(x, y, 21, 14);
		la[1] = new MyLabel(x+42, y, 21, 14);
		la[2] = new MyLabel(x+14, y+30, 40, 14);
		la[3] = new MyLabel(x, y+55, 21, 14);
		la[4] = new MyLabel(x+42,y+55, 21, 14);
		la[5] = new MyLabel(x+14, y+93, 40, 14);
		la[6] = new MyLabel(x+42, y+111, 36, 14);
		la[7] = new MyLabel(x+14, y+133, 40, 14);
		la[8] = new MyLabel(x+14, y+155, 40, 14);
	}
	
}
