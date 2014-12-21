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
import ui.setting.resultPanels.ResultPanelController;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class DelSortPanel extends FatherPanel implements ActionListener{
	protected MyFrame frame;
	protected CommodityAllUIController commodityAllUIController;
	protected ResultPanelController resController;
	protected MyButton forwardButton;
	
	protected MyTextFieldBorder name;
	protected SortVO sort;
	protected String nameString;
	
	protected String failedAddress;
	
	protected CommodityblService commodityblService;
	public DelSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		resController = new ResultPanelController(frame, this);
		commodityblService = new CommodityController();
		setFailedAddress();
		commodityAllUIController.setBack_second(this,181, 151);
		setTextField();
		setForward();
	}

	private void setFailedAddress() {
		this.failedAddress = "com/delSort";
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
		if(nameString.equals("")){
			resController.failedConfirm("请重新确认输入信息！", failedAddress);
		}else{
			try{
//			frame.remove(this);
//			sort = new SortVO(nameString);
//			sort.note = "2";
//			sort.fatherSort = "hello";
			sort = commodityblService.searchSort_up(nameString);
			if(sort.equals(null)){
				System.out.println("heeee");
				resController.failed("您要删除的分类不存在！", failedAddress);
			}else{
			commodityAllUIController.confirmSort(sort,"del");
			}
			}catch(Exception e){
				resController.failedConfirm("您要删除的分类不存在！", failedAddress);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			getSort();
		}
	}



}
