package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.PatchVO;

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
	
	private String failedAddress;
	
	private CommodityblService commodityblService;
	public AddPatchPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.failedAddress = "com/addPatch";
		resController = new ResultPanelController(frame, this);
	
		commodityAllUIController.setBack_first(this);
		commodityblService = new CommodityController();
		setTextField();
		setComboBox();
		
		setLabels();
		setForward();
	}
	private void setLabels() {
		id = new MyLabel(94, 188, 269, 42);
		time = new MyLabel(94, 308, 269, 42);
		operator = new MyLabel(94, 427, 269, 42);
		
		id.setText(idString);
		time.setText(timeString);
		operator.setText(opeString);
		
		MyLabel [] labels = new MyLabel[]{id,time,operator};
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(color.greyFont);
			this.add(labels[i]);
		}
	}
	private void setComboBox() {
		String [] rolesList = new String[]{"a","b"};
		name = new MyComboBox(rolesList,427,188,269,42);
		type = new MyComboBox(rolesList, 427, 308, 269, 42);
		
		this.add(name);
		this.add(type);
		
		name.addActionListener(this);
		type.addActionListener(this);
	}
	private void setTextField() {
		number = new MyTextFieldTrans(427, 427, 269, 42);
		number.setForeground(color.greyFont);
		number.setText("报溢为正，报损为负");
		
		this.add(number);
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(724, 426);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		
		saveButton = new MyButton("Image/save.png", 724, 480, "Image/save_stop.png", "Image/save_stop");
		this.add(saveButton);
		saveButton.addActionListener(this);
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
		}else if (e.getSource() == saveButton) {
			setNewPatch();
			commodityblService.patchDraft_up(newPatch);
		}
	}
	private void setNewPatch() {
		num = Integer.parseInt(number.getText());
		newPatch = new PatchVO(nameString, typeString,num, idString, timeString, opeString,"");
	}

}
