package ui.commodity.sort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.commodity.CommodityAllUIController;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class ConfirmSortPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private MyButton forwardButton;
	private MyLabel sortId,name,fatherSort;
	
	private CommodityAllUIController commodityAllUIController;
	private ResultPanelController resControllerS,resControllerF;
	private SortVO sort,oldSort;
	
	private String type;
	private String failedAddress,sortBelong;
	
	private CommodityblService commodityblService;
	public ConfirmSortPanel(MyFrame frame, String url, CommodityAllUIController controller,SortVO sort,String type) {
		super(frame, url, controller);
		System.out.println("hello");
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		resControllerF = new ResultPanelController(frame,this);
		resControllerS = new ResultPanelController(frame,commodityAllUIController.getMainPanel());
		this.failedAddress = "commodity2";
		
		this.sort = sort;
		this.type = type;
		
		commodityblService = new CommodityController();
		commodityAllUIController.setBack_third(this);
		setLabels();
		setForward();
	}
	public ConfirmSortPanel(MyFrame frame, String url, CommodityAllUIController controller,
			SortVO sort,String type,String sortBelong) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		resControllerF = new ResultPanelController(frame,this);
		resControllerS = new ResultPanelController(frame,commodityAllUIController.getMainPanel());
		this.failedAddress = "commodity2";
		
		this.sortBelong = sortBelong;
		this.sort = sort;
		this.type = type;
		
		commodityblService = new CommodityController();
		commodityAllUIController.setBack_third(this);
		setLabels();
		setForward();
	}
	public ConfirmSortPanel(MyFrame frame, String url, CommodityAllUIController controller,
			SortVO sort,String type,SortVO oldSort) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		resControllerF = new ResultPanelController(frame,this);
		resControllerS = new ResultPanelController(frame,commodityAllUIController.getMainPanel());
		this.failedAddress = "commodity2";
		
		this.oldSort= oldSort;
		this.sort = sort;
		this.type = type;
		
		commodityblService = new CommodityController();
		commodityAllUIController.setBack_third(this);
		setLabels();
		setForward();
	}
	private void setLabels() {
		sortId = new MyLabel(254, 204, 271, 42);
		name = new MyLabel(255, 323, 271, 42);
		fatherSort = new MyLabel(255, 442, 271, 42);
		MyLabel labels[] = new MyLabel[]{sortId,name,fatherSort};
		sort.note = commodityblService.getSortNote_up(new SortVO(sort.fatherSort));
		labels[0].setText(sort.note);
		labels[1].setText(sort.name);
		labels[2].setText(sort.fatherSort);
		
		for(int i = 0;i < labels.length;i++){
			this.add(labels[i]);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new FontFactory(24).font);
		}
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(573, 442);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			controller.setTempPanel(this);
			if(type.equals("add")){
				System.out.println("123");
				addSort();
			}else if(type.equals("del")){
				delSort();
			}else if(type.equals("cha")){
				chaSort();
			}
				
			
		}
	}

	//int错误类型：
	//-1 未知错误
	//1  商品已存在
	//2  商品不存在
	//3  分类已存在
	//4  分类不存在
	//5  分类中存在商品，不能删除
	//6  商品数量不足，不能添加为赠品
	//7  赠品数量不足，不能删除
	//8  商品数量不能为负
	private void chaSort() {
//		resControllerS.succeeded("成功修改分类信息！", "commodity");
		switch(commodityblService.updateSort_up_Inf(oldSort, sort)){
		case 0:
			resControllerS.succeeded("成功修改分类信息！", "commodity");
			break;
		default:
			resControllerF.failedConfirm("未知错误！",failedAddress);
		}
	}
	private void delSort() {
		System.out.println("成功删除分类！");
		switch(commodityblService.delSort_up(sort)){
		case 0:
			resControllerS.succeeded("成功删除分类！", "commodity");
			break;
		case 4:
			resControllerF.failedConfirm("分类不存在！", failedAddress);
			break;
		default:
			resControllerF.failedConfirm("未知错误！", failedAddress);
		}
	}
	private void addSort() {
//		SortVO fatherSortVO = commodityblService.searchSort_up(sortBelong);
		
		switch(commodityblService.addSort_up(sort, new SortVO(sortBelong))){
		
		case 0:
			resControllerS.succeeded("成功添加分类！", "commodity");
			break;
		case 3:
			resControllerF.failedConfirm("分类已存在！",failedAddress);
			break;
		default:
			resControllerF.failedConfirm("未知错误！", failedAddress);
			break;
		}
	}
}
