package ui.sales.impanel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.sales.cuspanel.AddCusPanel;
import ui.sales.impanel.ImInPanel.FocusAdapter;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldTrans;
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class ImBackPanel extends ImInPanel {

	SalesblService salesblService;
	public ImBackPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller, salesUIController);
		salesblService = new SalesController();
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addMouseListener(new MouListener());
		forward.addMouseListener(new MouListener());
	}

	public void addNum() {
		goodsNum = new MyTextFieldTrans(488, 334, 237, 31);
////	goodsNum.setText(salesblService.getImport_ReturnMaxNumber_up("")+"");
		goodsNum.setText("1");
		this.add(goodsNum);
//		goodsNum.addFocusListener(new FocusAdapter());
	}
	
	public void addTotalListener(){
		goodsTotal.addFocusListener(new FocusAdapter());
		
	}
	class FocusAdapter implements FocusListener {

		public void focusGained(FocusEvent e) {
			goodsTotal.setText("");
			try {
				num = Integer.parseInt(goodsNum.getText());
				totalPriceText = Double.parseDouble(goodsPrice.getText()) * num;
				int numMost = salesblService.getImport_ReturnMaxNumber_up("");
				numMost = 10;
				if (num <= 0) {
//					System.out.println("hello");
					failLabel.setText("商品数量有误！");
				}else if(num > numMost){
					failLabel.setText("超过最大可退货数量");
				} else {
					goodsTotal.setText(totalPriceText + "");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				failLabel.setText("请正确输入信息!");
				}
		}

		public void focusLost(FocusEvent e) {

		}

	}

	public void addSaveButton(){
		saveButton = new MyButton("Image/save.png", 670, 550, "Image/save_stop.png", "Image/save_stop");
		this.add(saveButton);
		saveButton.addMouseListener(new MouListener());
	}
	
	class MouListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(ImBackPanel.this);
			} else if (e.getSource() == forward) {
				if(id.getText().equals("")||remark.getText().equals("")||supplier.getText().equals("")||
						warehouse.getText().equals("")||person.getText().equals("")||operator.getText().equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,ImBackPanel.this);
					salesResult.failed("存在输入为空！", "import_return_failed");
				}else{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, totalPriceText, remark.getText());
				ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplier.getText(),
						warehouse.getText(), commodityListVO, 3);
				importMenuVO.person = person.getText();
				MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/二次确认/进货单_退货单确认信息.jpg", controller,
						importMenuVO, commodityListVO, person.getText(), operator.getText(), ImBackPanel.this,salesUIController);
				frame.remove(ImBackPanel.this);
				frame.setPanel(makeSureIm);
				}
				frame.repaint();
			} else if (e.getSource() == goodsName) {
				setType();
			} else if (e.getSource() == goodsType) {
				setGoodsID();
				getPrice();
			}else if(e.getSource() == saveButton){
				try{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, totalPriceText, remark.getText());
				ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplier.getText(),
						warehouse.getText(), commodityListVO, 2);
				importMenuVO.person = person.getText();
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, ImBackPanel.this);
//				salesResult.succeeded("成功添加草稿单！");
				switch(salesblService.addDraftImport_Return_up(importMenuVO)){
				case 0:
					salesResult.succeeded("成功添加草稿单！");
					break;
				default:
					salesResult.failed("添加失败！", "import_return_failed");
				}
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
		
	
	}
}
