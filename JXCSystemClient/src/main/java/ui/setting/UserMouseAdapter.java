package ui.setting;

import java.awt.event.MouseEvent;

public class UserMouseAdapter  extends java.awt.event.MouseAdapter {
	 
	  private boolean flag=false;//用来判断是否已经执行双击事件
	  private int clickNum=0;//用来判断是否该执行双击事件

	  public void mouseClicked(MouseEvent e) {
	      final MouseEvent me=e;//事件源

	      this.flag=false;//每次点击鼠标初始化双击事件执行标志为false

	      if (this.clickNum == 1) {//当clickNum==1时执行双击事件
	        this.mouseDoubleClicked(me);//执行双击事件
	        this.clickNum=0;//初始化双击事件执行标志为0
	        this.flag=true;//双击事件已执行,事件标志为true
	        return;
	      }

	      //定义定时器
	      java.util.Timer timer=new java.util.Timer();

	      //定时器开始执行,延时0.2秒后确定是否执行单击事件
	      timer.schedule(new java.util.TimerTask(){
	        private int n=0;//记录定时器执行次数
	        public void run() {
	          if(flag){//如果双击事件已经执行,那么直接取消单击执行
	            n=0;
	            clickNum=0;
	            this.cancel();
	            return;
	          }
	          if (n == 1) {//定时器等待0.2秒后,双击事件仍未发生,执行单击事件
	            mouseSingleClicked(me);//执行单击事件
	            flag = true;
	            clickNum=0;
	            n=0;
	            this.cancel();
	            return;
	          }
	          clickNum++;
	          n++;
	        }
	      },new java.util.Date(),200); // 设置延迟时间
	    }

	    /** *//**
	     * 鼠标单击事件
	     * @param e 事件源参数
	     */
	    public void mouseSingleClicked(MouseEvent e){
	      //System.out.println("Single Clicked!");
	    }

	    /** *//**
	     * 鼠标双击事件
	     * @param e 事件源参数
	     */
	    public void mouseDoubleClicked(MouseEvent e){
	      //System.out.println("Doublc Clicked!");
	    }

}
