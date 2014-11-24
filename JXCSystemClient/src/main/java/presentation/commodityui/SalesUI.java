package presentation.commodityui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.commoditybl.Commodity;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;

public class SalesUI extends JFrame{
    JButton jb1,jb2,jb3,jb4;
    JTextField jtf1,jtf2;

	public SalesUI(){

	    jb1=new JButton("商品名称");
	    jb2=new JButton("商品类型");
	    jb3=new JButton("确定");
        jb4=new JButton("返回");
        
	    jb1.setBounds(100, 250, 110, 50);
		jb2.setBounds(100, 150, 110, 50);
		jb3.setBounds(150,350,110,50);
		jb4.setBounds(350,350,110,50);
		jb3.addActionListener(new jb3Action());
		
        jtf1=new JTextField();
        jtf2=new JTextField();
		jtf1.setBounds(230, 150, 300, 50);
		jtf2.setBounds(230, 250, 300, 50);
				
	    JPanel jp=new JPanel();
	    jp.setBounds(0,0,800,600);
	    jp.setLayout(null);
		setTitle("JXCS_addAccount");
//		setLayout(null);
		setBounds(300,100,800,600);

		jp.add(jb1);
	    jp.add(jb2);
	    jp.add(jb3);
	    jp.add(jb4);
		jp.add(jtf1);
		jp.add(jtf2);
		this.add(jp);
		

		setVisible(true);
	
        
	
	}
class jb3Action implements ActionListener{
	public void addActionListener(ActionEvent arg0){
		
	}

	public void actionPerformed(ActionEvent arg0) {
		String name=jtf1.getText();
		String type=jtf2.getText();
		CommodityblService a=new CommodityController();
		String result=a.addCommodity(name,type);
//		System.out.println("hello!");
		new FatherDialog(result);
		// TODO Auto-generated method stub
		
	}
}
	
	public static void main(String[]args){
		new SalesUI();
	}
	
	
}
