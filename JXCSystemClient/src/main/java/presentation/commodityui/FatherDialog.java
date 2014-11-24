package presentation.commodityui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FatherDialog extends JFrame{
   JButton jb;
   JLabel jl;
   JPanel jp;
   public FatherDialog(String isSuccess){
	   jp=new JPanel();
	   jb=new JButton("È·¶¨");
	   jl=new JLabel(isSuccess,jl.CENTER);
	   jb.setBounds(90,80,100,50);
       jp.add(jl);
	   jp.add(jb);
	   jb.addActionListener(new jbAction());
	   jl.setBounds(0,0,300,100);
	   jp.setBounds(0,0,300,200);
	   jp.setLayout(null);
	   this.add(jp);
	   setBounds(500,250,300,200);
	   setVisible(true);
	   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
	class jbAction implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
//   public static void main(String[]args){
//	   new FatherDialog();
//   }
}

