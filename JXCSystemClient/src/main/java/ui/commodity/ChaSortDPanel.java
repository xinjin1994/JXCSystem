package ui.commodity;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.SortVO;

public class ChaSortDPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private ResultPanelController resController;

	private MyButton forwardButton;
	private SortVO chaSort,newSort;

	private MyTextFieldTrans id,name;
	private MyComboBox fatherSortBox;
	private String idString,nameString,sortString;
	private String failedAddress;
	
	public ChaSortDPanel(MyFrame frame, String url, CommodityAllUIController controller,SortVO sort) {
		super(frame, url, controller);
		this.chaSort = sort;
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.failedAddress = "com/chaSortD";
		resController = new ResultPanelController(frame, this);
		commodityAllUIController.setBack_first(this);
		
		setTextField();
		setFatherSort();
		setForward();
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(573, 442);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void setFatherSort() {
		String roleList []= new String[]{"a","b"};
		fatherSortBox = new MyComboBox(roleList,255,442,271,42);
		this.add(fatherSortBox);
		fatherSortBox.addActionListener(this);
	}

	private void setTextField() {
		name = new MyTextFieldTrans(255, 323, 271, 42);
		id = new MyTextFieldTrans(254, 204, 271, 42);
	
		name.setText(chaSort.name);
	//	id.setText(chaSort.id);
		id.setText("23");
		
		name.setForeground(Color.white);
		id.setForeground(Color.white);
		
		this.add(name);
		this.add(id);
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
	//		newSort = new SortVO(nameString,sortString,idString);
			commodityAllUIController.confirmSort(newSort,"cha");
		}else if(e.getSource() == fatherSortBox){
			sortString = fatherSortBox.getSelectedItem().toString();
		}
	}

}
