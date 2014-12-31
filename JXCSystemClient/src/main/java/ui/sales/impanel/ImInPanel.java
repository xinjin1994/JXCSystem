package ui.sales.impanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldFilled;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;
import businesslogic.salesbl.SalesController;
import businesslogic.userbl.User;
import businesslogicservice.salesblservice.SalesblService;

public class ImInPanel extends FatherPanel {
	protected ButtonListener buttonListener;
	protected MyTextFieldFilled warehouse, remark, discount, voucher;
	protected MyComboBox supplier;
	protected MyTextFieldTrans goodsPrice, goodsNum, goodsTotal;
	protected MyComboBox goodsName, goodsType;
	protected MyTextFieldFilled person, operator;
	protected MyButton back, forward;
	protected MyLabel goodsID, id, failLabel;
	protected SalesblService salesblService;
	protected CommodityVO commodityVO;
	protected int num;
	protected double price, totalPriceText;
	protected String goodsNameSelected, goodsTypeSelected;
	protected SalesUIController salesUIController;
	protected MyFrame frame;
	protected UIController controller;
	protected boolean isGo = false;
	protected MyButton saveButton;
	protected String[] typeString ;
	protected int i = 0;
	protected String supplierString;

	public ImInPanel(MyFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.controller = controller;
		salesUIController = new SalesUIController(controller, frame);
		buttonListener = new ButtonListener();
		salesblService = new SalesController();
//		typeString = new String[1];
//		typeString[0] = "Type";
//		goodsType = new MyComboBox(typeString, 488, 252, 237, 31);
//		goodsType.setSelectedIndex(0);
//		this.add(goodsType);
		this.addTextField();
		this.addButton();
		this.addCombox();
		this.addLabel();
		this.addID();
		this.addNum();
		this.addTotalListener();
		this.addSaveButton();
		this.addWhichCus();
	}

	public ImInPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller);
		this.salesUIController = salesUIController;
		this.frame = frame;
		this.controller = controller;
		buttonListener = new ButtonListener();
		salesblService = new SalesController();
//		typeString = new String[0];
//		goodsType = new MyComboBox(typeString, 488, 252, 237, 31);
//		this.add(goodsType);
		this.addTextField();
		this.addButton();
		this.addCombox();
		this.addLabel();
		this.addID();
		this.addNum();
		this.addTotalListener();
		this.addSaveButton();
		this.addWhichCus();
	}

	public void addCombox() {
		ArrayList<CommodityVO> comVOArray = salesblService.getAllCommodity_up();
		String[] commodityName = new String[comVOArray.size()];
		for (int i = 0; i < comVOArray.size(); i++) {
			commodityName[i] = comVOArray.get(i).name;
		}
		// String[] commodityName = { "aa", "bb" };

		goodsName = new MyComboBox(commodityName, 488, 170, 237, 31);
		goodsName.addActionListener(buttonListener);
		this.add(goodsName);
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addActionListener(buttonListener);
		forward.addActionListener(buttonListener);
	}

	public void addID() {
		id = new MyLabel(105, 173, 222, 36);
		id.setText(salesblService.getImportNote_up());
		// id.setText("id");
		this.add(id);

	}

	/**
	 * 根据选择的商品名选择商品type，再出现单价
	 * 
	 * @return
	 */
	public void setType() {
		if(i > 0){
			System.out.println("hello");
			ImInPanel.this.remove(goodsType);
			ImInPanel.this.repaint();
		}
		i++;
		System.out.println("goodsType is Null");
		goodsPrice = new MyTextFieldTrans(488, 293, 237, 31);
		goodsNameSelected = goodsName.getSelectedItem().toString();
		System.out.println("goodsName" + goodsNameSelected);
		ArrayList<CommodityVO> comVOArray = salesblService.getAllCommodity_up();
		ArrayList<String> commodityType = new ArrayList<String>();
		for (int j = 0; j < comVOArray.size(); j++) {
			if (comVOArray.get(j).name.equals(goodsNameSelected)) {
				commodityType.add(comVOArray.get(j).type);
				System.out.println("type" + comVOArray.get(j).type);
			}
		}
		String[] typeString = new String[commodityType.size()];
		for (int i = 0; i < commodityType.size(); i++) {
			typeString[i] = commodityType.get(i);
		}
		System.out.println("size " + typeString.length + " " + typeString[0]);
		// String[] typeString = { "a", "b" };
		goodsType = new MyComboBox(typeString, 488, 252, 237, 31);
		this.add(goodsType);
		goodsType.addActionListener(buttonListener);
		this.repaint();
	}

	public void setGoodsID() {
		goodsTypeSelected = goodsType.getSelectedItem().toString();
		commodityVO = salesblService.getCommodity_up(goodsNameSelected, goodsTypeSelected);
		goodsID.setText(commodityVO.id);
		// goodsID.setText("id");
	}

	public void getPrice() {
		this.add(goodsPrice);
		goodsPrice.setText(commodityVO.inValue + "");
		// goodsPrice.addFocusListener(new FocusAdapter());
		try {
			price = Double.parseDouble(goodsPrice.getText());
			if (price <= 0) {
				this.addLabel();
			}
		} catch (Exception e) {
			this.addLabel();
		}

	}

	public void addTextField() {
		warehouse = new MyTextFieldFilled(210, 308, 116, 42);
		remark = new MyTextFieldFilled(104, 420, 200, 118);
		// discount = new MyTextFieldFilled(235, 421, 91, 37);
		// voucher = new MyTextFieldFilled(235, 500, 91, 27);
		goodsID = new MyLabel(488, 211, 237, 31);
		person = new MyTextFieldFilled(408, 481, 147, 36);
		operator = new MyTextFieldFilled(576, 481, 147, 36);
		goodsTotal = new MyTextFieldTrans(488, 375, 237, 31);
		this.add(warehouse);
		this.add(remark);
		// this.add(discount);
		// this.add(voucher);
		this.add(goodsID);
		this.add(person);
		this.add(operator);
		this.add(goodsTotal);
		operator.setText(User.operator);
	}
	
	public void addWhichCus(){
		ArrayList<CustomerVO> cus = salesblService.getAllImportCustomer_up();
		String[] cusStr = new String[cus.size()];
		for(int i = 0;i<cus.size();i++){
			cusStr[i] = cus.get(i).cusName;
		}

		supplier = new MyComboBox(cusStr,210, 255, 116, 42);
//		 supplierString = supplier.getSelectedItem().toString();
		supplier.addActionListener(buttonListener);
		this.add(supplier);
	}

	public void addNum() {
		goodsNum = new MyTextFieldTrans(488, 334, 237, 31);
		// //
//		 goodsNum.setText(salesblService.getImport_ReturnMaxNumber_up("")+"");
//		goodsNum.setText("1");
		this.add(goodsNum);
		// goodsNum.addFocusListener(new FocusAdapter());
	}


	public void addSaveButton() {
		saveButton = new MyButton("Image/save.png", 670, 550, "Image/save_stop.png", "Image/save_stop");
		this.add(saveButton);
		saveButton.addActionListener(buttonListener);
	}

	public void addTotalListener() {
		goodsTotal.addFocusListener(new FocusAdapter());
		
	}
	class FocusAdapter implements FocusListener {

		public void focusGained(FocusEvent e) {
			goodsTotal.setText("");
			try {
				num = Integer.parseInt(goodsNum.getText());
				totalPriceText = Double.parseDouble(goodsPrice.getText()) * num;
				if (num <= 0) {
					// System.out.println("hello");
					failLabel.setText("您输入的商品数量有误！");
				} else {
					goodsTotal.setText(totalPriceText + "");
					isGo = true;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				failLabel.setText("请正确输入信息!");
			}
		}

		public void focusLost(FocusEvent e) {

		}

	}

	public void addLabel() {
		failLabel = new MyLabel(488, 530, 200, 50);
		failLabel.setForeground(Color.red);
		this.add(failLabel);
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(ImInPanel.this);
			} else if (e.getSource() == forward) {

				if (id.getText().equals("") || (supplierString.toString()).equals("")
						|| warehouse.getText().equals("") || person.getText().equals("")
						|| operator.getText().equals("")) {
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController, ImInPanel.this);
					salesResult.failed("请重新确认输入信息！", "importFailed");
				} else {
					// System.out.println("isGo"+isGo);
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsTypeSelected, num, price, totalPriceText, remark.getText());
					ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplierString.toString(),
							warehouse.getText(), commodityListVO, 2);
					importMenuVO.person = person.getText();
					MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/二次确认/进货单_退货单确认信息.jpg",
							controller, importMenuVO, commodityListVO, person.getText(), operator.getText(),
							ImInPanel.this, salesUIController);
					frame.remove(ImInPanel.this);
					frame.setPanel(makeSureIm);
				}
				frame.repaint();
			} else if (e.getSource() == goodsName) {
				setType();
			} else if (e.getSource() == goodsType) {
				setGoodsID();
				getPrice();
			}else if(e.getSource() == supplier){
				 supplierString = supplier.getSelectedItem().toString();
				 person.setText(salesblService.searchExactCustomer_up(supplierString).person);
			}else if (e.getSource() == saveButton) {
				try {
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsNameSelected, num, price, totalPriceText, remark.getText());
					ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplierString,
							warehouse.getText(), commodityListVO, 2);
					importMenuVO.person = person.getText();
					System.out.println("id.getText()"+id.getText()+"goodsNameSelected"+goodsNameSelected
							+"supplierString"+supplierString);
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController, ImInPanel.this);
					switch (salesblService.addDraftImport_up(importMenuVO)) {
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "importFailed");
					}
				} catch (Exception e2) {
					CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
							goodsNameSelected, num, price, totalPriceText, remark.getText());
					ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplierString,
							warehouse.getText(), commodityListVO, 2);
					importMenuVO.person = person.getText();
					System.out.println("id.getText()"+id.getText()+"goodsNameSelected"+goodsNameSelected
							+"supplierString"+supplierString);
					SalesResult salesResult = new SalesResult(frame, controller, salesUIController, ImInPanel.this);
					switch (salesblService.addDraftImport_up(importMenuVO)) {
					case 0:
						salesResult.succeeded("成功添加草稿单！");
						break;
					default:
						salesResult.failed("添加失败！", "importFailed");
					}
//					e2.printStackTrace();
				}
			}

		}
	}
}
