package ui.commodity.sort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class AddSortPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private ResultPanelController resController;

	private MyTextFieldBorder id,name;
	private MyComboBox fatherSortBox;
	private String idString,nameString,sortString;
	
	private MyButton forwardButton;
	private SortVO newSort,fatherSort;
	
	private String failedAddress;
	public AddSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		resController = new ResultPanelController(frame, this);
		failedAddress = "com/addSort";
		
		commodityAllUIController.setBack_second(this,178 ,115 );
		setTextField();
		setFatherSort();
		setForward();
		
	}
	private void setFatherSort() {
		String roleList []= new String[]{"a","b"};
		fatherSortBox = new MyComboBox(roleList,253 , 423, 319, 37);
		fatherSortBox.addActionListener(this);
		this.add(fatherSortBox);
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
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			setNewSort();
		//	newSort = new SortVO(nameString,sortString,idString);
			commodityAllUIController.confirmSort(newSort,"add");
		}else if(e.getSource() == fatherSortBox){
			sortString = fatherSortBox.getSelectedItem().toString();
			
		}
	}

}
