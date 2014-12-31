package ui.sales.salespanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.sales.impanel.MakeSureIm;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;

public class SalesBackPanel extends SalesInPanel{
	/*
	 * 添加销售退货单界面
	 */

	MyButton saveNewButton;
	public SalesBackPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame, url, controller,salesUIController);
	//	this.remove(remark);
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
	
	public void addID() {
		id = new MyLabel(105, 173, 222, 36);
		id.setText(salesblService.getExport_ReturnNote_up());
		// id.setText("id");
		this.add(id);

	}
	
	public void addSaveButton(){
		saveNewButton = new MyButton("Image/save.png", 670, 550, "Image/save_stop.png", "Image/save_stop");
		this.add(saveNewButton);
		saveNewButton.addMouseListener(new MouListener());
	}
	class MouListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(SalesBackPanel.this);
			} else if (e.getSource() == forward) {
				frame.remove(SalesBackPanel.this);
				if(id.getText().equals("")||supplierNewString.equals("")||
						warehouse.getText().equals("")||person.getText().equals("")||
						operator.getText().equals("")||goodsNameSelected.equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,SalesBackPanel.this);
					salesResult.failed("请重新确认输入信息！", "export_return_failed");
				}
				else{
					try{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, num*price, newRemark.getText());
				ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString,person.getText(),
						warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),Double.parseDouble(voucher.getText()),totalPriceText,5);
				exportMenuVO.person = person.getText();
				MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/创建销售单/创建销售单_背景.jpg", controller,
						exportMenuVO, commodityListVO, person.getText(), operator.getText(), SalesBackPanel.this,salesUIController);
				frame.remove(SalesBackPanel.this);
				frame.setPanel(makeSureIm);
				
				}catch(Exception e2){
					salesResult.failed("请重新确认输入信息！", "export_return_failed");
				}
				frame.repaint();
				}
			}
				else if(e.getSource() == saveNewButton){
					System.out.println("saveButtonListener");
					frame.remove(SalesBackPanel.this);
					try{
						CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
								goodsTypeSelected, num, price, num*price, newRemark.getText());

						ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString,person.getText(),
								warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),Double.parseDouble(voucher.getText()),totalPriceText,4);
						exportMenuVO.person = person.getText();
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController, SalesBackPanel.this);
					salesResult.succeeded("成功添加草稿单！");
					switch(salesblService.addDraftExport_Return_up(exportMenuVO)){
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "export_return_failed");
					}
					}catch(Exception e2){
						double dis = 0, vou = 0;
						if(!discount.getText().equals("")){
							dis = Double.parseDouble(discount.getText());
						}
						if(!voucher.getText().equals("")){
							vou = Double.parseDouble(voucher.getText());
						}
						
						CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
								goodsTypeSelected, num, price, num*price, newRemark.getText());

						ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString,person.getText(),
								warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),Double.parseDouble(voucher.getText()),totalPriceText,4);
						exportMenuVO.person = person.getText();
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController, SalesBackPanel.this);
//					salesResult.succeeded("成功添加草稿单！");
					switch(salesblService.addDraftExport_Return_up(exportMenuVO)){
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "export_return_failed");
//						e2.printStackTrace();
					}
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
