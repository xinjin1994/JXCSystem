package ui.setting.ComboBox;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import ui.setting.XUtil;
import vo.initial.InitialCommodityVO;

public class MyComboboxButton extends JComboBox{
	public MyComboboxButton(){
		  super();
		  init();
		 }
		 public MyComboboxButton(ComboBoxModel model){
		  super(model);
		  init();
		 }
		 public MyComboboxButton(Object[] items){
		  super(items);
		  init();
		 }
		 public MyComboboxButton(Vector<?> items){
		  super(items);
		  init();
		 }
		 private void init(){
		  setOpaque(false);
		  setUI(new MyComboBoxUI());
		  setRenderer(new MyComboBoxRenderer());
		  setBackground(XUtil.defaultComboBoxColor);
		 }
		 public Dimension getPreferredSize(){
		  return super.getPreferredSize();
		 }
}
