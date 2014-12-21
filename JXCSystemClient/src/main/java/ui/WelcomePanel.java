package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class WelcomePanel extends FatherPanel {

	ThreadDis thread;
	private static final long serialVersionUID = -1660303715688708759L;
	public WelcomePanel(JFrame frame, String url,UIController controller) {
		super(frame, url,controller);
		thread=new ThreadDis();
		thread.start();
	}
	
	class ThreadDis extends Thread{
		
		int times=0;
		public void run(){
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				times++;
				if(times==1){
					controller.loginPanel();
					break;
				}
			}
		}
	}
	
}
