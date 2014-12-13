package ui.setting.Button;

public class ForwardButton extends MyButton{
	public MyButton forward_white,forward_black;
	
	public ForwardButton(int x,int y){
		forward_white = new MyButton("Image/goon_white.png", x, y, "Image/Sales/对话框/images/前进_stop_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		
		forward_black = new MyButton("Image/Sales/对话框/images/前进_黑.png", x, y, "Image/Sales/对话框/images/前进_stop_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
	}
}
