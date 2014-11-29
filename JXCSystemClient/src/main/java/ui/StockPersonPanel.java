package ui;

import javax.swing.JFrame;

//1 库存人员
public class StockPersonPanel extends FatherPanel{
	public StockPersonPanel(JFrame frame,String url,UIController controller){
		super(frame,url,controller);
		this.controller=controller;
	}
}
