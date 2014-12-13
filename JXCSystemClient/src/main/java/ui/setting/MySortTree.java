package ui.setting;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import vo.SortVO;

public class MySortTree {
	DefaultTreeModel treeModel;
	JTree tree;
	JScrollPane scrollPane;
	ArrayList<SortID> allSortsIds = new ArrayList<SortID>();
	SortID temp;
	public MySortTree(ArrayList<SortVO> allSorts) {
		JFrame f = new JFrame("TreeDemo");
		Container contentPane = f.getContentPane();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("商品");

		treeModel = new DefaultTreeModel(root);
		
		ArrayList<SortID> fatherSorts = new ArrayList<SortID>();
		
		for(SortVO sort:allSorts){
			System.out.println(sort.getNote());
			String tempIDs[] = sort.getNote().split("-");
			System.out.println(tempIDs[0]);
			if(tempIDs.length == 2){
				SortID temp = new SortID("",tempIDs[1],sort.name,sort.commodity);
				fatherSorts.add(temp);
			}else if(tempIDs.length == 3){
				SortID temp = new SortID(tempIDs[1], tempIDs[2], sort.name,sort.commodity);
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
		/* 改变JTree的外观* */
		tree.putClientProperty("JTree.lineStyle", "Horizontal");
		/* 改变JTree的外观* */
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
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

	
	
	private void setSort(SortID fatSort) {
		if(fatSort.commodities!=null){
			addCommodities(fatSort);
		}else{
			DefaultMutableTreeNode fatherNode = fatSort.treeNode;
			String node = fatSort.node;
			for(SortID tempSortSon:allSortsIds){
				
				if(tempSortSon.fatherNode.equals(node)){
					DefaultMutableTreeNode sonNode = new DefaultMutableTreeNode(tempSortSon.name);
					tempSortSon.setNode(sonNode);
					treeModel.insertNodeInto(sonNode,fatherNode, fatherNode.getChildCount());
					temp = tempSortSon;
					setSort(temp);
				}
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
		System.out.println("123");
	}
//	public static void main(String args[]) {
//
//		new MySortTree();
//	}
}


