package ui.setting.ComboBox;

import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;

import ui.setting.ColorFactory;
import ui.setting.FontFactory;
/**
 * 封装ComboBoxButton
 * @author ZYC
 *
 */
public class MyComboBox extends JComboBox{
	public MyComboBox(String [] roleList,int x,int y,int width,int height) {
		super(roleList);
		this.setBounds(x, y, width, height);
		this.setSelectedItem(null);
		this.setOpaque(false);

		this.setFont(new FontFactory(20).font);
		
		this.setBackground(new ColorFactory().greyFont);
		
		this.setUI(new BasicComboBoxUI() {
	            public void installUI(JComponent comboBox) {
	                super.installUI(comboBox);
	                listBox.setOpaque(false);
	                listBox.setForeground(new ColorFactory().accColor);
	                
	                listBox.setSelectionBackground(new Color(0,0,0,0));
	                listBox.setSelectionForeground(Color.BLACK);
	            }
	             
	            /**
	             * 该方法返回右边的按钮
	             */
	        });
	}
}
