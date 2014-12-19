package ui.commodity.sort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.resultPanels.ResultPanelController;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class AddSortPanel extends FatherPanel implements ActionListener{
	private CommodityAllUIController commodityAllUIController;
	private ResultPanelController resController;
	private SortVO newSort,fatherSort;

	private MyFrame frame;
	private MyTextFieldBorder id,name;
	private MyComboBox fatherSortBox;
	private MyButton forwardButton;

	private String idString,nameString,sortString;
	private String failedAddress;
	
	private CommodityblService commodityblService;
	public AddSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		resController = new ResultPanelController(frame, this);
		failedAddress = "com/addSort";
		commodityblService = new CommodityController();
		commodityAllUIController.setBack_second(this,178 ,115 );
		setTextField();
		setFatherSort();
		setForward();
		
	}
	private void setFatherSort() {
		ArrayList<SortVO> arraySort = commodityblService.getSortSort_up();
		if(arraySort.size() == 0){
			resController.failedConfirm("信息不存在！", failedAddress);
		}else{
		String roleList[] = new String[arraySort.size()+1];
		roleList[0] = "";
		for(int i=0;i<arraySort.size();i++){
			roleList[i+1] = arraySort.get(i).getName();
		}
//		String roleList []= new String[]{"","a","b"};
		fatherSortBox = new MyComboBox(roleList,253 , 423, 319, 37);
		fatherSortBox.addActionListener(this);
		this.add(fatherSortBox);
		}
	}
	private void setTextField() {
		id = new MyTextFieldBorder(254, 218);
		name = new MyTextFieldBorder(254, 307);
		
		id.setForeground(new ColorFactory().accColor);
		name.setForeground(new ColorFactory().accColor);
		
		this.add(id);
		this.add(name);
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(630, 424);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	private void setNewSort() {
		nameString = name.getText();
		idString = id.getText();
		if(nameString.equals("")||idString.equals("")){
			resController.failedConfirm("请重新确认输入信息！", failedAddress);
		}else{
			newSort = new SortVO(nameString);
			newSort.note = idString;
			newSort.fatherSort = sortString;
			frame.remove(this);
			commodityAllUIController.confirmSort(newSort,"add",sortString);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			setNewSort();
		}else if(e.getSource() == fatherSortBox){
			sortString = fatherSortBox.getSelectedItem().toString();
		}
	}

}
