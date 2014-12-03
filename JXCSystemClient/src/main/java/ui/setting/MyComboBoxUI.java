package ui.setting;

import javax.swing.JComboBox;
import javax.swing.plaf.ComboBoxUI;

public class MyComboBoxUI extends ComboBoxUI {

	@Override
	public boolean isFocusTraversable(JComboBox arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPopupVisible(JComboBox arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPopupVisible(JComboBox arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

}
