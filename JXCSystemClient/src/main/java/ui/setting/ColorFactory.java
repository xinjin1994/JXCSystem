package ui.setting;

import java.awt.Color;

public class ColorFactory {
	public Color greyFont;
	public Color accColor;//account界面的主色调
	public Color saleColor;
	
	public Color accTableColor;
	public Color manTableColor;
	public Color manColor;//manager界面主色调
	public Color manBkColor;
	
	public Color adminColor;
	public Color adminBkColor;
	public Color adminTableColor;
	
	public Color comColor;
	public ColorFactory(){
		
		greyFont = new Color(225,225,225);
		accColor = new Color(135,144,153);
		saleColor = new Color(245,190,185);
		accTableColor = new Color(185,188,193);
		
		manTableColor = new Color(166,199,230);
		manColor = new Color(126,178,226);
		manBkColor = new Color(212,227,248);
		
		adminTableColor = new Color(231,212,147);
		adminColor = new Color(215,184,102);
		adminBkColor = new Color(232,229,216);
		
		comColor = new Color(104,184,157);
		
	}
}
