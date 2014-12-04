package ui.setting;


//对应于类似基本信息一栏 没有边框且透明的
public class MyTextFieldTrans extends MyTextField{

	public MyTextFieldTrans(int x, int y, 
			int width,int height) {
		
		super(x, y);
		this.setSize(width, height);
		this.setOpaque(false);
		
		this.setFont(new FontFactory().font20);
		this.setBackground(null);
		this.setBorder(null);
		
	}
	
}
