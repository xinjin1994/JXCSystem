package ui.setting;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.TabableView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import vo.CommodityVO;
import vo.SortVO;

public class MySortTree {
	DefaultTreeModel treeModel;
	static public JTree tree;
	static public JScrollPane scrollPane;
	public ShowPanel treePanel;
	ArrayList<SortID> allSortsIds = new ArrayList<SortID>();
	SortID temp;
	
	private DefaultTreeCellRenderer render;
	/**
	 * 
	 * @param allSorts 当前所有商品和对应分类
	 */
	public MySortTree(ArrayList<SortVO> allSorts) {
//		JFrame f = new JFrame("TreeDemo");
//		Container contentPane = f.getContentPane();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("商品");
		render = new DefaultTreeCellRenderer();
		treeModel = new DefaultTreeModel(root);
		
		treePanel = new ShowPanel();
		ArrayList<SortID> fatherSorts = new ArrayList<SortID>();
		this.treePanel = new ShowPanel();
		for(SortVO sort:allSorts){
			System.out.println(sort.getNote());
			String tempIDs[] = sort.getNote().split("-");
			System.out.println(tempIDs[0]);
			if(tempIDs.length == 2){
				SortID temp = new SortID("",tempIDs[1],sort.name,sort.commodity);
//				System.out.println("add 2 Sort");
				fatherSorts.add(temp);
			}else if(tempIDs.length == 3){
				SortID temp = new SortID(tempIDs[1], tempIDs[2], sort.name,sort.commodity);
//				System.out.println("add 3 Sort");
				allSortsIds.add(temp);
			}
		}
		for(SortID tempSorts:fatherSorts){
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(tempSorts.name);
			treeModel.insertNodeInto(node, root, root.getChildCount());
			tempSorts.setNode(node);
			setSort(tempSorts);
		}

//		UIManager.getLookAndFeelDefaults().put("ClassLoader",
//				getClass().getClassLoader());

		// 以TreeModel建立JTree。
		tree = new JTree(treeModel);
		tree.setOpaque(false);
		render.setOpaque(false);
		
		render.setBackgroundNonSelectionColor(new Color(0,0,0,0));
		render.setBackgroundSelectionColor(new Color(0,0,0,0));
		render.setFont(new FontFactory(14).font);
		
		
		tree.setCellRenderer(render);
		tree.setBounds(43,44,360,380);
		/* 改变JTree的外观* */
		tree.putClientProperty("JTree.lineStyle", "Horizontal");
		/* 改变JTree的外观* */
		scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(43,44,360,380);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVisible(true);
		
	
		
		
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(tree);
		
		scrollPane.repaint();
		treePanel.add(scrollPane);
		treePanel.repaint();
//		contentPane.add(scrollPane);
//		f.pack();
//		f.setVisible(true);
//
//		f.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
	}

//private  void setPanel() {
//		
////		tablePanel = new ShowPanel();
//		treePanel = new JPanel();
//		
//		treePanel.setLayout(null);
//		treePanel.setBounds(0,0,437 ,428);
//		treePanel.removeAll();
//		treePanel.setOpaque(false);
//		treePanel.setVisible(true);
//	//	backPanel.add(tablePanel);
//	}
	
	private void changeIcon(int type){
//		switch (type) {
//		case 1:
//			render.setForeground(new ColorFactory().greyFont);
//			break;
//			
//		case 0:
//			render.setForeground(new ColorFactory().accColor);
//			break;
//		default:
//			break;
//		}
	}
	
	private void setSort(SortID fatSort) {
		if(fatSort.commodities!=null&&(fatSort.commodities.size()!=0)){
			addCommodities(fatSort);
		}
			DefaultMutableTreeNode fatherNode = fatSort.treeNode;
			String node = fatSort.node;
			for(SortID tempSortSon:allSortsIds){
				
				if(tempSortSon.fatherNode.equals(node)){
					DefaultMutableTreeNode sonNode = new DefaultMutableTreeNode(tempSortSon.name);
					treeModel.insertNodeInto(sonNode,fatherNode, fatherNode.getChildCount());
					changeIcon(1);
					tempSortSon.setNode(sonNode);
					temp = tempSortSon;
					setSort(temp);
				}
			}
		


//		for(SortID tempSortFather:fatherSorts){
//			
//			DefaultMutableTreeNode treeNode = tempSortFather.treeNode;
//			
//			for(SortID tempSortSon:allSortsIds){
//				if(tempSortSon.fatherNode.equals(node)){
//					DefaultMutableTreeNode nodeSon = new DefaultMutableTreeNode();
//					treeModel .insertNodeInto(, , index);
//				}
//			}
//		}
//		
		
	}
	
	private void addCommodities(SortID tempSort) {
		ArrayList<CommodityVO> commodityVOs = tempSort.commodities;
		for(CommodityVO temp:commodityVOs){
			DefaultMutableTreeNode sonNode = new DefaultMutableTreeNode(new ImageIcon("Goods: "+temp.name+"--"+temp.type));
			treeModel.insertNodeInto(sonNode,tempSort.treeNode, tempSort.treeNode.getChildCount());
			changeIcon(0);
		}
		System.out.println("123");
	}
//	public static void main(String args[]) {
//
//		new MySortTree();
//	}
}


