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
import vo.CommodityVO;

public class ExamineStockPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private CommodityVO com;
	private ResultPanelController resController;
	private MyButton forwardButton;
	private MyTextFieldBorder timeBegin,timeEnd;
	private String timeBeginString,timeEndString;
	
	private ColorFactory color = new ColorFactory();
	private String failedAddress;
	
	public ExamineStockPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		this.failedAddress = "com/examine";
		
		resController = new ResultPanelController(frame, this);
		commodityAllUIController.setBack_second(this, 202, 133);
		setTextField();
		setForward();
		
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(612, 385);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void setTextField() {
		timeBegin = new MyTextFieldBorder(279, 236);
		timeEnd = new MyTextFieldBorder(279, 326);
		
		this.add(timeBegin);
		this.add(timeEnd);
		
		timeBegin.setForeground(new ColorFactory().accColor);
		timeEnd.setForeground(new ColorFactory().accColor);
		
	}

	public void actionPerformed(ActionEvent e) {
		commodityAllUIController.setTempPanel(this);
		frame.remove(this);
		frame.setPanel(commodityAllUIController.getMainPanel());
		frame.repaint();
	}
	
}
