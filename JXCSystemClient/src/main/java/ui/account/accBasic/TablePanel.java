package ui.account.accBasic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.UIController;
import ui.setting.FatherPanel;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;

public class TablePanel extends FatherPanel{
	
	private FindAccountPanel findAccountPanel;
	private MyTable table;
	private MyButton forward;
	private MyFrame frame;
	AccountblService accountblService;
	public TablePanel(MyFrame frame,String url,UIController controller,ArrayList<AccountVO> fuzzyAccVO,FindAccountPanel findAccountPanel){
		super(frame,url,controller);
		this.frame = frame;
		this.findAccountPanel = findAccountPanel;
		this.addButton();
		this.addTable();
	}
	
	public void addButton(){
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(forward);
		forward.addMouseListener(new ButtonListener());
	}
	
	class ButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			frame.remove(TablePanel.this);
			frame.setPanel(findAccountPanel);
			frame.repaint();				
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
		
	}
	public void addTable(){
		accountblService = new AccountController();	
		table = new MyTable();
		this.add(table);
		ArrayList <String> infoArray = new ArrayList<String>();
		infoArray.add("账户名称;账户余额");
		/*for(int i=0; i<fuzzyAccVO.size();i++){
			String infoOfArray = fuzzyAccVO.get(i).name+";"+fuzzyAccVO.get(i).balance;
			infoArray.add(infoOfArray);
		}*/
		table.setTable(infoArray);
		this.add(table);
	}
}
