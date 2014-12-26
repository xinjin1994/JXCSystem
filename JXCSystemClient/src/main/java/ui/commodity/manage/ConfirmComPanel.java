package ui.commodity.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.CommodityPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class ConfirmComPanel extends ComDetailPanel implements ActionListener{

	private MyFrame frame;
	private MyButton forwardButton;
	private ResultPanelController resControllerS,resControllerF;
	private String type;
	private String failedAddress;
	private CommodityAllUIController commodityAllUIController;
	private CommodityVO commodityVO,oldVO;
	private SortVO sortVO;
	
	private CommodityblService commodityblService;
	public ConfirmComPanel(MyFrame frame, String url, CommodityAllUIController controller,CommodityVO commodityVO,
			String type,SortVO sortVO) {
		super(frame, url, controller,commodityVO);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.type = type;
		this.sortVO = sortVO;
		this.failedAddress = "commodity1";
		this.commodityVO = commodityVO;
		
		commodityAllUIController.setBack_first(this);

		commodityblService = new CommodityController();
		resControllerS = new ResultPanelController(frame,commodityAllUIController.getMainPanel());
		resControllerF = new ResultPanelController(frame,commodityAllUIController.getPanel());
		//!!!!!!
		//这个是错误，调用resControllerF.failedConfirm("错误信息", failedAddress);
		setForward();
	}
	public ConfirmComPanel(MyFrame frame, String url, CommodityAllUIController controller,CommodityVO commodityVO,
			String type,SortVO sortVO,CommodityVO oldVO) {
		super(frame, url, controller,commodityVO);
		this.frame = frame;
		this.oldVO = oldVO;
		this.commodityAllUIController = controller;
		this.type = type;
		this.sortVO = sortVO;
		this.failedAddress = "commodity1";
		this.commodityVO = commodityVO;
		
		commodityAllUIController.setBack_first(this);

		commodityblService = new CommodityController();
		resControllerF = new ResultPanelController(frame, commodityAllUIController.getPanel());
		//!!!!!!
		//这个是错误，调用resControllerF.failedConfirm("错误信息", failedAddress);
		setForward();
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(680,451 );
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
	}
	private void changeMainPanel(){
		CommodityPanel temp = (CommodityPanel)(commodityAllUIController.getMainPanel());
		temp.setTree(commodityblService.getAllSort_up());
		commodityAllUIController.setMainPanel(temp);
		resControllerS = new ResultPanelController(frame, commodityAllUIController.getMainPanel());
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
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
			//9  分类中存在分类，无法添加商品
			if(type.equals("add")){
				switch(commodityblService.addCommodity_up(commodityVO, sortVO)){
				case 0:
					changeMainPanel();
					resControllerS.succeeded("成功添加商品！", "commodity");
					break;
				case -1:
					resControllerF.failedConfirm("未知错误！", failedAddress);
					break;
				case 1:
					resControllerF.failedConfirm("商品已存在！", failedAddress);
					break;
				case 5:
					resControllerF.failedConfirm("分类中已存在该商品！", failedAddress);
					break;
				case 9:
					resControllerF.failedConfirm("分类中存在分类，无法添加商品", failedAddress);
					break;
				default:
					resControllerF.failedConfirm("未知错误！", failedAddress);
				}
			}else if(type.equals("del")){
				switch(commodityblService.delCommodity_up(commodityVO)){
				case 0:
					changeMainPanel();
					resControllerS.succeeded("成功删除商品！", "commodity");
					break;
				case 2:
					resControllerF.failedConfirm("商品不存在！", failedAddress);
					break;
				default:
					resControllerF.failedConfirm("未知错误！", failedAddress);
				}
			}else if (type.equals("cha")) {
				switch(commodityblService.updateCommodity_up(oldVO, commodityVO)){
				case 0:
					changeMainPanel();
					resControllerS.succeeded("成功修改商品信息！", "commodity");
					break;
				case 3:
					resControllerF.failedConfirm("分类已存在！",failedAddress);
					break;
				case 4:
					resControllerF.failedConfirm("分类不存在！",failedAddress);
					break;
				default:
					resControllerF.failedConfirm("未知错误！", failedAddress);
				}
			}
		}
	}

}
