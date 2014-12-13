package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class ConfirmComPanel extends ComDetailPanel implements ActionListener{

	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private MyButton forwardButton;
	private ResultPanelController resController;
	private String type;
	
	public ConfirmComPanel(MyFrame frame, String url, CommodityAllUIController controller,CommodityVO com,String type) {
		super(frame, url, controller,com);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.type = type;
		
		commodityAllUIController.setBack_first(this);
		resController = new ResultPanelController(commodityAllUIController, frame);
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
				resController.succeeded("成功添加商品！", "commodity");
			}else if(type.equals("del")){
				resController.succeeded("成功删除商品！", "commodity");
			}else if (type.equals("cha")) {
				resController.succeeded("成功修改商品信息！", "commodity");
			}
		}
	}

}
