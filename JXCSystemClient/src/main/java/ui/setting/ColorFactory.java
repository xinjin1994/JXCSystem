package ui.setting;

import java.awt.Color;

public class ColorFactory {
	public Color greyFont;
	public Color accColor;//account界面的主色调
	public Color saleColor;
	
	public Color accTableColor;
	public ColorFactory(){
		greyFont = new Color(225,225,225);
		accColor = new Color(135,144,153);
		saleColor = new Color(245,190,185);
		accTableColor = new Color(185,188,193);
	}
}
