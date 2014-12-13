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

import vo.SortVO;

public class MySortTree {
	public MySortTree() {
		JFrame f = new JFrame("TreeDemo");
		Container contentPane = f.getContentPane();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("我q的公文包");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
		DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");

		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		/*
		 * DefaultTreeModel类所提供的insertNodeInto()方法加入节点到父节点的数量.
		 * 利用DefaultMutableTreeNode类所提供的getChildCount()方法取得目前子节点的数量.
		 */
		treeModel.insertNodeInto(node1, root, root.getChildCount());
		treeModel.insertNodeInto(node2, root, root.getChildCount());
		treeModel.insertNodeInto(node3, root, root.getChildCount());
		treeModel.insertNodeInto(node4, root, root.getChildCount());

		DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("公司文件");

		// DefaultTreeModel类所提供的insertNodeInto()方法加入节点到父节点的数量.
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("个人信件");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("私人文件");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());

		leafnode = new DefaultMutableTreeNode("本机磁盘(C:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("本机磁盘(D:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("本机磁盘(E:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());

		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("网站列表");
		treeModel.insertNodeInto(node31, node3, node3.getChildCount());
		leafnode = new DefaultMutableTreeNode("奇摩站");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode = new DefaultMutableTreeNode("职棒消息");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode = new DefaultMutableTreeNode("网络书店");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
//		try {
//			LookAndFeel alloyLnF = new LookAndFeel();
//			UIManager.setLookAndFeel(alloyLnF);
//		} catch (UnsupportedLookAndFeelException ex) {
//			// You may handle the exception here
//		}
		// this line needs to be implemented in order to make JWS work properly
		UIManager.getLookAndFeelDefaults().put("ClassLoader",
				getClass().getClassLoader());

		// 以TreeModel建立JTree。
		JTree tree = new JTree(treeModel);
		/* 改变JTree的外观* */
		tree.putClientProperty("JTree.lineStyle", "Horizontal");
		/* 改变JTree的外观* */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);

		contentPane.add(scrollPane);
		f.pack();
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	public static void main(String args[]) {

		new MySortTree();
	}
}


