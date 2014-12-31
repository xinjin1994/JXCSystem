package ui.sales.salespanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.sales.impanel.ImInPanel;
import ui.sales.impanel.MakeSureIm;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldFilled;
import vo.CustomerVO;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import businesslogic.userbl.User;

public class SalesInPanel extends ImInPanel {
	/*
	 * 添加销售单界面
	 */

	MyTextFieldFilled newRemark;
	SalesResult salesResult = new SalesResult(frame, controller, salesUIController, SalesInPanel.this);
	protected MyComboBox newSupplier;
	protected String supplierNewString;

	public SalesInPanel(MyFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.remove(remark);
		this.addRestText();
	}

	public SalesInPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller, salesUIController);
		this.remove(remark);
		this.addRestText();
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
		id.setText(salesblService.getExportNote_up());
		// id.setText("id");
		this.add(id);

	}
	
	public void addRestText() {
		newRemark = new MyTextFieldFilled(104, 420, 104, 118);
		discount = new MyTextFieldFilled(235, 421, 91, 37);
		voucher = new MyTextFieldFilled(235, 500, 91, 27);
		this.add(newRemark);
		this.add(discount);
		this.add(voucher);
		discount.addFocusListener(new disLis());
	}

	class disLis implements FocusListener {

		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			double dis = Double.parseDouble(discount.getText());
			int i = User.duty;
			if (i == 2) {
				// 销售人员
				if (dis > 1000) {
					salesResult.failed("您的权限无法制定此价值的折让！", "export_failed");
				}
			} else if (i == 3) {
				// 销售经理
				if (dis > 5000) {
					salesResult.failed("您的权限无法制定此价值的折让！", "export_failed");
				}
			}
		}

	}

	public void getPrice() {
		goodsTypeSelected = goodsType.getSelectedItem().toString();
		commodityVO = salesblService.getCommodity_up(goodsNameSelected, goodsTypeSelected);
		goodsPrice.setText(commodityVO.outValue + "");
		// goodsPrice.setText("30");
		this.add(goodsPrice);
		try {
			price = Double.parseDouble(goodsPrice.getText());
			if (price <= 0) {
				this.addLabel();
			}
		} catch (Exception e) {
			this.addLabel();
		}
		// price = 30;
	}

	
	public void addTotalListener() {
		goodsTotal.addFocusListener(new FocusAdapter());
		
	}
	class FocusAdapter implements FocusListener {

		public void focusGained(FocusEvent e) {
			goodsTotal.setText("");
			try {
				num = Integer.parseInt(goodsNum.getText());
				if (Double.parseDouble(voucher.getText()) > Double.parseDouble(goodsPrice.getText()) * num) {
					totalPriceText = 0;
				} else {
					int level = salesblService
							.searchExactCustomer_up(newSupplier.getSelectedItem().toString()).level;
					double dis_UnSeen = salesblService
							.getDiscount_up(Double.parseDouble(goodsPrice.getText()) * num, level);
					System.out.println("level"+level+"dis"+dis_UnSeen);
					totalPriceText = Double.parseDouble(goodsPrice.getText())
							* num
							- Double.parseDouble(discount.getText())
							- Double.parseDouble(voucher.getText())
							- dis_UnSeen;
					if (totalPriceText < 0) {
						totalPriceText = 0;
					}
				}
				
					goodsTotal.setText(totalPriceText + "");
					isGo = true;
			} catch (Exception e2) {
				e2.printStackTrace();
				failLabel.setText("请正确输入信息!");
			}
		}

		public void focusLost(FocusEvent e) {

		}

	}

	public void addWhichCus() {
		ArrayList<CustomerVO> cus = salesblService.getAllExportCustomer_up();
		String[] cusStr = new String[cus.size()];
		for (int i = 0; i < cus.size(); i++) {
			cusStr[i] = cus.get(i).cusName;
		}
		newSupplier = new MyComboBox(cusStr, 210, 255, 116, 42);
		newSupplier.addActionListener(new SupLis());
		this.add(newSupplier);
	}

	class SupLis implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == newSupplier) {
				supplierNewString = newSupplier.getSelectedItem().toString();
				person.setText(salesblService.searchExactCustomer_up(supplierNewString).person);
			}
		}

	}

	public void addSaveButton() {
		saveButton = new MyButton("Image/save.png", 670, 550, "Image/save_stop.png", "Image/save_stop");
		this.add(saveButton);
		saveButton.addMouseListener(new MouListener());
	}

	class MouListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(SalesInPanel.this);
			} else if (e.getSource() == forward) {
				if (id.getText().equals("") || newRemark.getText().equals("") || supplierNewString.equals("")
						|| warehouse.getText().equals("") || person.getText().equals("")
						|| operator.getText().equals("")) {
					salesResult.failed("请重新确认输入信息！", "export_failed");
				} else {
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsTypeSelected, num, price, num * price, newRemark.getText());
					
					ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString, person.getText(),
							warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),
							Double.parseDouble(voucher.getText()), totalPriceText, 4);
					exportMenuVO.person = person.getText();
					MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/创建销售单/创建销售单_背景.jpg",
							controller, exportMenuVO, commodityListVO, person.getText(), operator.getText(),
							SalesInPanel.this, salesUIController);
					frame.remove(SalesInPanel.this);
					frame.setPanel(makeSureIm);
				}
				frame.repaint();
			} else if (e.getSource() == goodsName) {
				setType();
			} else if (e.getSource() == goodsType) {
				setGoodsID();
				getPrice();
			} else if (e.getSource() == saveButton) {
				try {
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsTypeSelected, num, price, num * price, newRemark.getText());

					ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString, person.getText(),
							warehouse.getText(), commodityListVO, Double.parseDouble(discount.getText()),
							Double.parseDouble(voucher.getText()), totalPriceText, 4);
					exportMenuVO.person = person.getText();
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController,
							SalesInPanel.this);
					// salesResult.succeeded("成功添加草稿单！");
					switch (salesblService.addDraftExport_up(exportMenuVO)) {
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "export_failed");
					}
				} catch (Exception e2) {
					double dis = 0, vou = 0;
					if(!discount.getText().equals("")){
						dis = Double.parseDouble(discount.getText());
					}
					if(!voucher.getText().equals("")){
						vou = Double.parseDouble(voucher.getText());
					}
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsTypeSelected, num, price, num * price, newRemark.getText());
					ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplierNewString, person.getText(),
							warehouse.getText(), commodityListVO, dis,
							vou, totalPriceText, 4);
					exportMenuVO.person = person.getText();
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController,
							SalesInPanel.this);
					// salesResult.succeeded("成功添加草稿单！");
					switch (salesblService.addDraftExport_up(exportMenuVO)) {
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "export_failed");
					}
//					e2.printStackTrace();
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
