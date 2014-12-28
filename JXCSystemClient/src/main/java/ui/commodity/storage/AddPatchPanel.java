package ui.commodity.storage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import data.accountdata.AccountDataService_Stub;
import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.Button.SaveButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.bill.PatchVO;
import vo.bill.PayVO;
import businesslogic.commoditybl.CommodityController;
import businesslogic.invoicebl.InvoiceController;
import businesslogic.userbl.User;
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
	private MyButton forwardButton,saveButton;
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
		init();
		setId();
	}
	public AddPatchPanel(MyFrame frame2, String string,
			CommodityAllUIController commodityAllUIController2, PatchVO bill) {
		super(frame2, string, commodityAllUIController2);
		init();
		setInfo(bill);
	}
	
	private void setInfo(PatchVO bill) {
		id.setText(bill.note);
		time.setText(bill.time);
		operator.setText(bill.operator);
		name.setSelectedItem(bill.name);
		type.setSelectedItem(bill.type);
		number.setText(String.valueOf(bill.number));
	}
	private void init(){
		resController = new ResultPanelController(frame, this);
		commodityblService = new CommodityController();
		invoiceblService = new InvoiceController();
		commodityAllUIController.setBack_first(this);
		setTextField();
		setComboBox();
		
		setLabels();
		setForward();
	}
	
	private void setId(){

		id.setText(commodityblService.getPatchNote());
	}
	private void setLabels() {
		id = new MyLabel(94, 188, 269, 42);
		time = new MyLabel(94, 308, 269, 42);
		operator = new MyLabel(94, 427, 269, 42);
		this.add(id);
		this.add(time);
		this.add(operator);
//		id.setText("id");
//		time.setText("time");
//		operator.setText("operator");
		try{
		
		time.setText(AccountDataService_Stub.getNoteTime());
		operator.setText(User.operator);
		MyLabel [] labels = new MyLabel[]{id,time,operator};
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(color.greyFont);
			this.add(labels[i]);
		}
		}catch(Exception e){
			resController.failed("您要查看的信息不存在！", failedAddress);
			e.printStackTrace();
		}
	}
	private void setComboBox() {
		//获得所有商品，用于报溢报损报警单中商品的选择
		ArrayList<CommodityVO> comVO = commodityblService.getAllCommodity_up();
		String[]rolesList = new String[comVO.size()];
		for(int i=0;i<comVO.size();i++){
			if(arrContains(rolesList, comVO.get(i).name)) {
				rolesList[i] = comVO.get(i).name;
			}
		}
		
		name = new MyComboBox(rolesList,427,188,269,42);
		
		this.add(name);
		
		name.addActionListener(this);
	}
	
	private boolean arrContains(String[] rolesList, String str) {
		for(int i = 0; i < rolesList.length; i++){
			if(str.equals(rolesList[i])) {
				//说明重复
				return false;
			}
		}
		return true;
	}
	
	private void setType(String nameString){
		ArrayList<CommodityVO> comVO = commodityblService.getAllCommodity_up();
		ArrayList<String> role = new ArrayList<String>();
		for(int i=0;i<comVO.size();i++){
			if(comVO.get(i).name.equals(nameString)) {
				role.add(comVO.get(i).type);
			}
		}
		String[]rolesList2 = new String[role.size()];
		for(int j=0;j<role.size();j++){
			rolesList2[j] = role.get(j);
		}
		type = new MyComboBox(rolesList2, 427, 308, 269, 42);
		this.add(type);
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
		SaveButton save = new SaveButton(this,736, 493);
		saveButton = save.saveButton;
		this.add(saveButton);
		saveButton.addActionListener(this);
		
		ForwardButton forward = new ForwardButton(724, 426);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == name){
			nameString = name.getSelectedItem().toString();
			setType(nameString);
			this.repaint();
		}else if(e.getSource() == type){
			typeString = type.getSelectedItem().toString();
		}else if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			try{
				num = Integer.parseInt(number.getText());
				newPatch = new PatchVO(nameString, typeString,num, id.getText(), time.getText(), operator.getText(),"1");
				}catch(Exception e){
					frame.remove(this);
					resController.failed("请重新确认您的输入！", failedAddress);
				}
			commodityAllUIController.confirmPatch(newPatch);
		}else if(e.getSource() == saveButton){
			setNewPatch();
			commodityblService.patchDraft_up(newPatch);
			frame.remove(this);
			resController = new ResultPanelController(frame, commodityAllUIController.getMainPanel());
			resController.succeeded("保存一条报溢报损草稿单！", "commodity");
		}
	}
	private void setNewPatch() {
		try {
			num = Integer.parseInt(number.getText());
		} catch (Exception e) {
			num = 0;
		}
		newPatch = new PatchVO(nameString, typeString,num, id.getText(), time.getText(), operator.getText(),"1");
	}

}
