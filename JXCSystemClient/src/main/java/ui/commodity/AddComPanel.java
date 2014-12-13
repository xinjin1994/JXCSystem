package ui.commodity;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.omg.CORBA.PRIVATE_MEMBER;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyComboBox;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;

public class AddComPanel extends FatherPanel implements ActionListener{
	
	protected CommodityAllUIController commodityAllUIController;
	protected MyFrame frame;

	protected MyButton forwardButton;
	protected ResultPanelController resController;
	
	String type = "account";
	
	protected CommodityVO newCom;
	
	protected MyLabel id,inPriceRec,outPriceRec,stockNumber;
	protected MyTextFieldTrans name,typeID,inPrice,outPrice,warnNumber;
	protected MyComboBox sortBox;
	
	protected ColorFactory color = new ColorFactory();
	
	protected String nameString,typeString,sortString;
	protected double latestInValue,latestOutValue,inValue,outValue;
	protected int num,warnNum;
	
	protected CommodityVO chaCom;
	protected String idString = "";
	public AddComPanel( MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.repaint();
		
		commodityAllUIController.setBack_first(this);
		resController = new ResultPanelController(frame, this);
		init();

	}
	
	public AddComPanel( MyFrame frame, String url, CommodityAllUIController controller,CommodityVO com) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.chaCom = com;
		System.out.println(chaCom.name);
		frame.repaint();
		
		resController = new ResultPanelController(frame, this);
		init();

	}

	protected void init() {
		setTextFields();
		setLabels();
		setSort();
		setForward();
	}

/**
 *默认进价，售价，库存数量都为0
 */
	protected void setLabels() {
		id = new MyLabel(106, 165, 221, 55);
		id.setText(idString);
		
		inPriceRec = new MyLabel(106, 347, 107, 55);
		inPriceRec.setText("0");
		latestInValue = Double.parseDouble(inPriceRec.getText());
		
		outPriceRec = new MyLabel(212,347, 107, 55);
		outPriceRec.setText("0");
		latestOutValue = Double.parseDouble(outPriceRec.getText());
		
		stockNumber = new MyLabel(106, 491, 226, 46);
		stockNumber.setText("0");
		num = Integer.parseInt(stockNumber.getText());
		
		MyLabel[] labels = new MyLabel[]{id,inPriceRec,outPriceRec,stockNumber};
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(color.accColor);
			labels[i].setFont(new FontFactory(24).font);
			if(i == 1){
				labels[i].setForeground(color.greyFont);
			}
			this.add(labels[i]);
		}
	}


	protected void setSort() {
		String []sortList = new String[]{"a","b"};//所有可以添加商品的分类
		sortBox = new MyComboBox(sortList, 534, 245, 166, 41);
		sortBox.setForeground(color.accColor);
		sortBox.addActionListener(this);
		this.add(sortBox);
	}


	protected void setTextFields() {
		name = new MyTextFieldTrans(534, 164, 166, 41);
		typeID = new MyTextFieldTrans(534,205 ,166, 41);
		inPrice = new MyTextFieldTrans(534, 286, 166, 41);
		outPrice = new MyTextFieldTrans(534, 327, 166, 41);
		warnNumber = new MyTextFieldTrans(405, 449, 225, 89);
		setTextFieldsHelp();
	}

	protected void setTextFieldsHelp(){
		outPrice.setForeground(color.accColor);
		warnNumber.setForeground(color.accColor);
		name.setForeground(color.accColor);
		
		inPrice.setForeground(color.greyFont);
		typeID.setForeground(color.greyFont);
		warnNumber.setFont(new FontFactory(24).font);
	
		MyTextFieldTrans[] textINs = new MyTextFieldTrans[]{ 
				 name,typeID,inPrice,outPrice,warnNumber};
		for(int i = 0;i < textINs.length;i++){
			this.add(textINs[i]);
		}
		this.add(warnNumber);
		
	}
	protected void setForward() {
		System.out.println("1234");
		ForwardButton forward = new ForwardButton(680,451 );
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
	}

	protected void setNewCom() {
		nameString = name.getText();
		typeString = typeID.getText();
		inValue = Double.parseDouble(inPrice.getText());
		outValue = Double.parseDouble(outPrice.getText());
		warnNum = Integer.parseInt(warnNumber.getText());
//		newCom = new CommodityVO(idString, nameString, typeString, num, inValue,
//				outValue, latestInValue, latestOutValue, warnNum, sortString);
		
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			frame.remove(this);
			setNewCom();
			commodityAllUIController.confirmCom(newCom,"add");
		}else if(event.getSource() == sortBox){
			sortString = sortBox.getSelectedItem().toString();
		}
	}


	
}
