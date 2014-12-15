package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class ConfirmComPanel extends ComDetailPanel implements ActionListener{

	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private MyButton forwardButton;
	private ResultPanelController resControllerS,resControllerF;
	private String type;
	
	private String failedAddress;
	public ConfirmComPanel(MyFrame frame, String url, CommodityAllUIController controller,CommodityVO com,String type) {
		super(frame, url, controller,com);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.type = type;
		this.failedAddress = "commodity1";
		commodityAllUIController.setBack_first(this);

		resControllerS = new ResultPanelController(frame,commodityAllUIController.getMainPanel());
		resControllerF = new ResultPanelController(frame, this);
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

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			if(type.equals("add")){
				resControllerS.succeeded("成功添加商品！", "commodity");
			}else if(type.equals("del")){
				resControllerS.succeeded("成功删除商品！", "commodity");
			}else if (type.equals("cha")) {
				resControllerS.succeeded("成功修改商品信息！", "commodity");
			}
		}
	}

}
