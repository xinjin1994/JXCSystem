package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.SortVO;

public class DelSortPanel extends FatherPanel implements ActionListener{
	protected MyFrame frame;
	protected CommodityAllUIController commodityAllUIController;
	protected ResultPanelController resController;
	protected MyButton forwardButton;
	
	protected MyTextFieldBorder name;
	protected SortVO sort;
	protected String nameString;
	
	public DelSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		resController = new ResultPanelController(frame, this);
		
		commodityAllUIController.setBack_second(this,181, 151);
		setTextField();
		setForward();
	}

	protected void setForward() {
		ForwardButton forward = new ForwardButton(542, 340);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	protected void setTextField() {
		name = new MyTextFieldBorder(259, 254);
		this.add(name);
		name.setForeground(new ColorFactory().accColor);
	}

	protected void getSort() {
		nameString = name.getText();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			getSort();
//			sort = new SortVO(nameString, "dd", "12");
			commodityAllUIController.confirmSort(sort,"del");
		}
	}



}
