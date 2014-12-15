package ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.setting.MyFrame;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CommodityVO;

public class ChaComDPanel extends AddComPanel implements ActionListener{
	
	public ChaComDPanel(MyFrame frame,String url,CommodityAllUIController uiController,CommodityVO chaCom){
		super(frame, url, uiController,chaCom);
	}

	protected void setFailedAddress(){
		this.failedAddress = "chaComD";
	}
	protected void setLabels() {
		super.setLabels();
		id.setText(chaCom.id);
		inPriceRec.setText(String.valueOf(chaCom.latestInValue));
		outPriceRec.setText(String.valueOf(chaCom.latestOutValue));
		stockNumber.setText(String.valueOf(chaCom.num));
	}


	protected void setTextFields() {
		name = new MyTextFieldTrans(534, 164, 166, 41);
		typeID = new MyTextFieldTrans(534,205 ,166, 41);
		inPrice = new MyTextFieldTrans(534, 286, 166, 41);
		outPrice = new MyTextFieldTrans(534, 327, 166, 41);
		warnNumber = new MyTextFieldTrans(405, 449, 225, 89);
		
		
		System.out.println(chaCom.name);
		name.setText(chaCom.name);
		typeID.setText(chaCom.type);
		inPrice.setText(String.valueOf(chaCom.inValue));
		outPrice.setText(String.valueOf(chaCom.outValue));
		warnNumber.setText(String.valueOf(chaCom.warnNumber));
		
		super.setTextFieldsHelp();
	}


	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(ChaComDPanel.this);
			setNewCom();
			commodityAllUIController.confirmCom(newCom,"cha");
		}else if(event.getSource() == sortBox){
			sortString = sortBox.getSelectedItem().toString();
		}
	}



}
