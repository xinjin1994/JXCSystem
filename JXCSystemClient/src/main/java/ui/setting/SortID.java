package ui.setting;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import vo.CommodityVO;
/**
 * 封装与树相关的结点
 * @author ZYC
 *
 */
public class SortID {
	public String fatherNode;
	public String node;
	public String name;
	public ArrayList<CommodityVO> commodities;
	public DefaultMutableTreeNode treeNode;
	public SortID(String fatherNode,String node,String name,ArrayList<CommodityVO>commodities) {
		this.fatherNode = fatherNode;
		this.node = node;
		this.name = name;
		this.commodities = commodities;
	}
	public void setNode(DefaultMutableTreeNode treeNode){
		this.treeNode = treeNode;
	}
}
