package ui.commodity.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.commodity.CommodityAllUIController;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import vo.SortVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
/**
 * 修改商品具体界面
 * @see ChaComPanel
 * @author ZYC
 *
 */
public class ChaComDPanel extends AddComPanel implements ActionListener {

	private MyLabel name,typeID;
	public ChaComDPanel(MyFrame frame, String url, CommodityAllUIController uiController, CommodityVO chaCom) {
		super(frame, url, uiController, chaCom);
		commodityblService = new CommodityController();

		setFailedAddress();
		commodityAllUIController.setBack_first(this);
		sortBox.setSelectedItem(chaCom.fatherSort);
	}

	protected void setFailedAddress() {
		this.failedAddress = "com/chaComD";
	}

	protected void setLabels() {
		super.setLabels();
		id.setText(chaCom.id);
		inPriceRec.setText(String.valueOf(chaCom.latestInValue));
		outPriceRec.setText(String.valueOf(chaCom.latestOutValue));
		stockNumber.setText(String.valueOf(chaCom.num));
	}

	protected void setSort() {
		CommodityblService commodityblService = new CommodityController();
		ArrayList<SortVO> sortArray = commodityblService.getComSort_up();
		String[] sortList = new String[sortArray.size()];
		for (int i = 0; i < sortArray.size(); i++) {
			String sortItem = sortArray.get(i).name;
			sortList[i] = sortItem;
		}
		sortBox = new MyComboBox(sortList, 534, 245, 166, 41);
		sortBox.setForeground(color.accColor);
		sortBox.addActionListener(this);
		this.add(sortBox);
	}

	protected void setTextFields() {
		name = new MyLabel(534, 164, 166, 41);
		typeID = new MyLabel(534, 205, 166, 41);
		inPrice = new MyTextFieldTrans(534, 286, 166, 41);
		outPrice = new MyTextFieldTrans(534, 327, 166, 41);
		warnNumber = new MyTextFieldTrans(405, 449, 225, 89);

		name.setText(chaCom.name);
		typeID.setText(chaCom.type);
		inPrice.setText(String.valueOf(chaCom.inValue));
		outPrice.setText(String.valueOf(chaCom.outValue));
		warnNumber.setText(String.valueOf(chaCom.warn));

		setTextFieldsHelp();
	}
	
	protected void setTextFieldsHelp(){
		outPrice.setForeground(color.accColor);
		warnNumber.setForeground(color.accColor);
		name.setForeground(color.accColor);
		
		inPrice.setForeground(color.greyFont);
		typeID.setForeground(color.greyFont);
		warnNumber.setFont(new FontFactory(24).font);
	
		this.add(name);
		this.add(typeID);
		MyTextFieldTrans[] textINs = new MyTextFieldTrans[]{ 
				inPrice,outPrice,warnNumber};
		for(int i = 0;i < textINs.length;i++){
			this.add(textINs[i]);
		}
		this.add(warnNumber);
		
	}

	protected void setNewCom() {
		nameString = name.getText();
		typeString = typeID.getText();
		resController = new ResultPanelController(frame, this);
		if (nameString.equals("") || typeString.equals("") || inPrice.getText().equals("")
				|| outPrice.getText().equals("") || warnNumber.getText().equals("")) {
			// 添加失败
			resController.failed("存在您的输入为空！", failedAddress);
		} else {
			try {
				inValue = Double.parseDouble(inPrice.getText());
				outValue = Double.parseDouble(outPrice.getText());
				warnNum = Integer.parseInt(warnNumber.getText());
				idString = chaCom.id;
				// CommodityVO(String id, String name, String type, int num,
				// double inValue, double outValue,
				// double latestInValue, double latestOutValue,int warn
				sortVO = new SortVO(sortString);
				newCom = new CommodityVO(idString, nameString, typeString, num, inValue, outValue, latestInValue,
						latestOutValue, warnNum);
				newCom.fatherSort = sortVO.name;
				commodityAllUIController.setTempPanel(this);
				commodityAllUIController.confirmCom(newCom, "cha", sortVO, chaCom);
			} catch (Exception e) {
				resController.failed("请重新确认输入信息！", failedAddress);
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == forwardButton) {
			commodityAllUIController.setTempPanel(this);
			frame.remove(ChaComDPanel.this);
			setNewCom();
			
		} else if (event.getSource() == sortBox) {
			sortString = sortBox.getSelectedItem().toString();
		}
	}

}
