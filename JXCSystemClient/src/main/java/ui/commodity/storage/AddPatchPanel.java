package ui.commodity.storage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.bill.PatchVO;
import businesslogic.commoditybl.CommodityController;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.commodityblservice.CommodityblService;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class AddPatchPanel extends FatherPanel implements ActionListener{

	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private ResultPanelController resController;

	private MyTextFieldTrans number;
	private MyComboBox name,type;
	private String nameString,typeString,idString,timeString,opeString;
	
	private MyLabel id,time,operator;
	private MyButton forwardButton;
	private PatchVO newPatch;
	private int num;
	private ColorFactory color = new ColorFactory();
	
	private CommodityblService commodityblService;
	private InvoiceblService invoiceblService;
	private String failedAddress;
	public AddPatchPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.failedAddress = "com/addPatch";
		resController = new ResultPanelController(frame, this);
		commodityblService = new CommodityController();
		invoiceblService = new InvoiceController();
		commodityAllUIController.setBack_first(this);
		setTextField();
		setComboBox();
		
		setLabels();
		setForward();
	}
	private void setLabels() {
		id = new MyLabel(94, 188, 269, 42);
		time = new MyLabel(94, 308, 269, 42);
		operator = new MyLabel(94, 427, 269, 42);
		
//		id.setText("id");
//		time.setText("time");
//		operator.setText("operator");
		id.setText(commodityblService.getPatchNote());
		time.setText(invoiceblService.searchNote_up(id.getText()).time);
		operator.setText(invoiceblService.searchNote_up(id.getText()).operator);
		
		MyLabel [] labels = new MyLabel[]{id,time,operator};
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(color.greyFont);
			this.add(labels[i]);
		}
	}
	private void setComboBox() {
		//获得所有商品，用于报溢报损报警单中商品的选择
		//public ArrayList<CommodityVO> getAllCommodity_up();
		ArrayList<CommodityVO> comVO = commodityblService.getAllCommodity_up();
		String[]rolesList = new String[comVO.size()];
		String[]rolesList2 = new String[comVO.size()];
		for(int i=0;i<comVO.size();i++){
			rolesList[i] = comVO.get(i).name;
			rolesList2[i] = comVO.get(i).type;
		}
//		String [] rolesList = new String[]{"a","b"};
//		type = new MyComboBox(rolesList, 427, 308, 269, 42);
		name = new MyComboBox(rolesList,427,188,269,42);
		type = new MyComboBox(rolesList2, 427, 308, 269, 42);
		
		this.add(name);
		this.add(type);
		
		name.addActionListener(this);
		type.addActionListener(this);
	}
	private void setTextField() {
		number = new MyTextFieldTrans(427, 427, 269, 42);
		number.setForeground(color.greyFont);
		number.setText("报溢为正，报损为负");
		number.addFocusListener(new NumListener());
		this.add(number);
	}
	
	class NumListener implements FocusListener{

		public void focusGained(FocusEvent e) {
			number.setText("");
		}

		public void focusLost(FocusEvent e) {
			
		}
		
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(724, 426);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == name){
			nameString = name.getSelectedItem().toString();
		}else if(e.getSource() == type){
			typeString = type.getSelectedItem().toString();
		}else if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			setNewPatch();
			commodityAllUIController.confirmPatch(newPatch);
		}
	}
	private void setNewPatch() {
		try{
		num = Integer.parseInt(number.getText());
		newPatch = new PatchVO(nameString, typeString,num, id.getText(), time.getText(), operator.getText(),"");
		}catch(Exception e){
			resController.failed("请重新确认您的输入！", failedAddress);
		}
	}

}
