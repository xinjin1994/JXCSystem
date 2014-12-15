package ui.commodity.storage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.MyTextFieldBorder;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.ExamineVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class ExamineStockPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private CommodityVO com;
	private ResultPanelController resController;
	private MyButton forwardButton;
	private MyTextFieldBorder timeBegin,timeEnd;
	
	private ColorFactory colors = new ColorFactory();
	private MyTable showTable;
	private String failedAddress;
	
	private CommodityblService commodityblService;
	/**
	 * 库存查看
	 * @param frame
	 * @param url
	 * @param controller
	 */
	public ExamineStockPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		
		this.failedAddress = "com/examine";
		commodityblService = new CommodityController();
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

	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.remove(this);
		frame.add(showTable.tablePanel);
		frame.setPanel(commodityAllUIController.getMainPanel());
		frame.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		commodityAllUIController.setTempPanel(this);
		
		String time1 = timeBegin.getText();
		String time2 = timeEnd.getText();

		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		boolean isLegal = true;
		try{
			dateFormat.parse(time1);
			isLegal = true;
		}catch(Exception e2){
			isLegal = false;
		}

		if(time1.equals("")||time2.equals("")){
			frame.remove(this);
			resController.failedConfirm("存在输入为空！", failedAddress);
		}else if(isLegal == false){
			frame.remove(this);
			resController.failedConfirm("时间输入格式错误！请按照“yyyy-mm-dd”格式输入！", failedAddress);
		}else{
//		ArrayList<ExamineVO> examineVO = commodityblService.Examine_up(time1, time2);
		ArrayList<String> examStr = new ArrayList<String>();
		int num = 0;
		int import_num = 0, import_return = 0,export_num = 0, export_return = 0,patch_num = 0, sendGift = 0;
		int totalNum = 0;
		double total = 0;
		examStr.add("商品名称;商品型号;进货数量;进货退货数量;销售数量;销售退货数量;"
				+ "报溢报损数量;赠品数量;总价值;商品进出库时间;合计");
	/*	for(int i=0;i<examineVO.size();i++){
			num = examineVO.get(i).import_num - examineVO.get(i).export_num-examineVO.get(i).import_return_num
					+examineVO.get(i).export_return_num-examineVO.get(i).sendgift_num+examineVO.get(i).patch_num;
			String examItem = examineVO.get(i).name+";"+examineVO.get(i).type+";"+examineVO.get(i).import_num+";"+examineVO.get(i).import_return_num
					+";"+examineVO.get(i).export_num+";"+examineVO.get(i).export_return_num+";"+examineVO.get(i).patch_num+";"+examineVO.get(i).sendgift_num
					+";"+examineVO.get(i).total_money+";"+examineVO.get(i).time+";"+num;
			import_num = import_num +examineVO.get(i).import_num;
			import_return = import_return + examineVO.get(i).import_return_num;
			export_num = export_num + examineVO.get(i).export_num;
			export_return =  export_return +examineVO.get(i).export_return_num;
			patch_num = patch_num +examineVO.get(i).patch_num;
			sendGift = sendGift+examineVO.get(i).sendgift_num;
			total = total+examineVO.get(i).total_money;
			totalNum = totalNum + num;
			examStr.add(examItem);
		}*/
		examStr.add("总计;;"+import_num+";"+import_return+";"+export_num+";"+export_return+";"+patch_num+";"+sendGift+";"+total+";"+";"+totalNum);
		setTable(examStr);
		}
	}
	
}
