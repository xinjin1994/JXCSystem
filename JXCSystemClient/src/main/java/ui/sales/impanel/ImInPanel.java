package ui.sales.impanel;

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
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class ImInPanel extends FatherPanel {
	protected ButtonListener buttonListener;
	protected MyTextFieldFilled supplier, warehouse, remark, discount, voucher;
	protected MyTextFieldTrans goodsPrice, goodsNum, goodsTotal;
	protected MyComboBox goodsName, goodsType;
	protected MyTextFieldFilled person, operator;
	protected MyButton back, forward;
	protected MyLabel goodsID, id,failLabel;
	protected SalesblService salesblService;
	protected CommodityVO commodityVO;
	protected int num;
	protected double price, totalPriceText;
	protected String goodsNameSelected, goodsTypeSelected;
	protected SalesUIController salesUIController;
	protected MyFrame frame;
	protected UIController controller;

	public ImInPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller);
		this.salesUIController = salesUIController;
		this.frame = frame;
		this.controller = controller;
		buttonListener = new ButtonListener();
		salesblService = new SalesController();
//		this.addTextField();
//		this.addButton();
//		this.addCombox();
//		this.addID();
		this.addLabel();
		this.addTextField();
		this.addButton();
		this.addCombox();
		this.addID();
	}

	public void addCombox() {
//		ArrayList<CommodityVO> comVOArray = salesblService.getAllCommodity_up();
		// String []commodityName = new String[comVOArray.size()];
		// for(int i=0;i<comVOArray.size();i++){
		// commodityName[i] =comVOArray.get(i).name;
		// }
		String[] commodityName = { "aa", "bb" };

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
		// id.setText(salesblService.getImportNote_up());
		id.setText("id");
		this.add(id);

	}

	/**
	 * 根据选择的商品名选择商品type，再出现单价
	 * 
	 * @return
	 */
	public void setType() {
		goodsPrice = new MyTextFieldTrans(488, 293, 237, 31);
		goodsNameSelected = goodsName.getSelectedItem().toString();
		// ArrayList<CommodityVO> comVOArray =
		// salesblService.getAllCommodity_up();
		// ArrayList<String> commodityType = new ArrayList<String>();
		// for(int j=0;j<comVOArray.size();j++){
		// if(comVOArray.get(j).name.equals(goodsNameSelected)){
		// commodityType.add(comVOArray.get(j).type);
		// }
		// }
		// String[]typeString = new String[commodityType.size()];
		String[] typeString = { "a", "b" };
		goodsType = new MyComboBox(typeString, 488, 252, 237, 31);
		goodsType.addActionListener(buttonListener);
		this.add(goodsType);
		this.repaint();
	}

	public void setGoodsID() {
		// goodsID.setText(commodityVO.id);
		goodsID.setText("id");
	}

	public double getPrice() {
		goodsTypeSelected = goodsType.getSelectedItem().toString();
		// commodityVO = salesblService.getCommodity_up(goodsNameSelected,
		// goodsTypeSelected);
//		 goodsPrice.setText(commodityVO.inValue+"");
		goodsPrice.setText("20");
		this.add(goodsPrice);
		// price = commodityVO.inValue;
		price = 20;
		return price;
	}

	public void getTotalPrice() {
		totalPriceText = this.getPrice() * num;
		goodsTotal.setText(totalPriceText + "");
		this.add(goodsTotal);
	}

	public void addTextField() {
		supplier = new MyTextFieldFilled(210, 255, 116, 42);
		warehouse = new MyTextFieldFilled(210, 308, 116, 42);
		remark = new MyTextFieldFilled(104, 420, 111, 118);
		// discount = new MyTextFieldFilled(235, 421, 91, 37);
		// voucher = new MyTextFieldFilled(235, 500, 91, 27);
		goodsID = new MyLabel(488, 211, 237, 31);
		goodsNum = new MyTextFieldTrans(488, 334, 237, 31);
		person = new MyTextFieldFilled(408, 481, 147, 36);
		operator = new MyTextFieldFilled(576, 481, 147, 36);
		goodsTotal = new MyTextFieldTrans(488, 375, 237, 31);
		this.add(supplier);
		this.add(warehouse);
		this.add(remark);
		// this.add(discount);
		// this.add(voucher);
		this.add(goodsID);
		this.add(goodsNum);
		this.add(person);
		this.add(operator);
		goodsNum.addFocusListener(new FocusAdapter());
	}

	class FocusAdapter implements FocusListener {

		public void focusGained(FocusEvent e) {
			goodsTotal.setText("");
		}

		public void focusLost(FocusEvent e) {
			try{
			num = Integer.parseInt(goodsNum.getText());
			getTotalPrice();
			}catch(Exception e2){
				failLabel.setText("请正确输入信息!");
			}
		}

	}
	public void addLabel() {
		failLabel = new MyLabel(488, 530, 200, 35);
		this.add(failLabel);
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(ImInPanel.this);
			} else if (e.getSource() == forward) {
			
				if(id.getText().equals("")||remark.getText().equals("")||supplier.getText().equals("")||
						warehouse.getText().equals("")||person.getText().equals("")||operator.getText().equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,ImInPanel.this);
					salesResult.failed("请重新确认输入信息！", "import_failed");
				}else{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, totalPriceText, remark.getText());
				ImportMenuVO importMenuVO = new ImportMenuVO(id.getText(), supplier.getText(),
						warehouse.getText(), commodityListVO, 2);
	
				MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/二次确认/进货单_退货单确认信息.jpg", controller,
						importMenuVO, commodityListVO, person.getText(), operator.getText(), ImInPanel.this,salesUIController);
				frame.remove(ImInPanel.this);
				frame.setPanel(makeSureIm);
				}
				frame.repaint();
			} else if (e.getSource() == goodsName) {
				setType();
			} else if (e.getSource() == goodsType) {
				setGoodsID();
				getPrice();
			}

		}
	}
}
