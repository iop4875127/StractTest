package StackTree;

/**
 * Created by Andrew_wl on 2017/11/13.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

	//静态值
	public static String preOrderTravResult = "先序遍历结果：";
	public static String inOrderTravResult = "中序遍历结果：";
	public static String postOrderTravResult = "后序遍历结果：";
	public static String levelOrderTravResult = "层次遍历结果：";
	//stack控制开关
	public static boolean logPrintSwitch = false;
	//基础属性
	private Tree leftTree;
	private Tree rightTree;
	private Object treeValue;

	public Tree getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	public Tree getRightTree() {
		return rightTree;
	}
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}
	public String toString(){
		//return "tree-"+this.treeNum;
		return treeValue+"";
	}

	//重写构造函数
	public Tree(Object treeValue){
		this.treeValue = treeValue;
	}

	//stack栈用来保存相关数据
	public static Stack<Tree> stack = new Stack<Tree>();
	//stack显示代码行数
	public static int executeNum = 1;

	public static void main(String [] args){
		System.out.println("打印Stack中的对象：");
		//控制开关
		logPrintSwitch = true;
		preOrderTrav(buildTree());
		System.out.println(preOrderTravResult);
		inOrderTrav(buildTree());
		System.out.println(inOrderTravResult);
		postOrderTrav(buildTree());
		System.out.println(postOrderTravResult);
		levelTrav(buildTree());
		System.out.println(levelOrderTravResult);
	}

	//二叉树的构建
	public static Tree buildTree(){
		Tree rootTree = new Tree("A");
		Tree tLeft1 = new Tree("B");
		Tree dTree = new Tree("D");
		dTree.setLeftTree(new Tree("H"));
		Tree kTree = new Tree("K");
		dTree.setRightTree(kTree);
		tLeft1.setLeftTree(dTree);
		Tree eTree = new Tree("E");
		eTree.setRightTree(new Tree("I"));
		tLeft1.setRightTree(eTree);
		Tree tRight1 = new Tree("C");
		tRight1.setLeftTree(new Tree("F"));
		tRight1.setRightTree(new Tree("G"));
		rootTree.setLeftTree(tLeft1);
		rootTree.setRightTree(tRight1);
		return rootTree;
	}

	public static void logPrintln(Object str){
		if(logPrintSwitch)
			System.out.println(str);
	}
	public static void logPrint(Object str){
		if(logPrintSwitch)
			System.out.print(str);
	}
	public static List<Tree> treeHeap = new ArrayList<Tree>();



	/*先序遍历
	 	1.二叉树有左节点
			1.1有右节点
				1.1.1入栈
			1.2没有右节点
			1.3遍历左节点树
		2.二叉树中没有左节点
			2.1有右节点
				2.1.1遍历该右节点
			2.2没有右节点
				2.2.1遍历栈
	 */
	public static void preOrderTrav(Tree t){
		// 先序排列：根——>左——>右
		logPrint(executeNum++ + ":");
		if( t != null ){
			preOrderTravResult += t;
			logPrintln(t);
			if(t.getLeftTree() != null){
				if(t.getRightTree() != null){
					stack.push(t.getRightTree());
					logPrintln("------>" + stack);
				}
				preOrderTrav(t.getLeftTree());
			}else{
				if(t.getRightTree() != null){
					preOrderTrav(t.getRightTree());
				}else if(t.getRightTree() == null && !stack.empty()){
					Tree tempTree = stack.pop();
					preOrderTrav(tempTree);
				}
			}
		}
	}

	/**
	 * 中序遍历
	 * 1.有左节点
	 * 		1.1 入栈
	 * 		1.2 遍历左节点
	 * 2.没有左节点
	 * 		2.1 有右节点
	 * 			2.1.1 遍历树
	 * 		2.2 没有右节点
	 * 			2.2.1 将栈中的树作为右节点
	 * 			2.2.2 遍历右节点
	 * */
	public static void inOrderTrav(Tree t){
		logPrint(executeNum++ + ":");
		// 中序排列：左——>根——>右
		if(t != null){
			if(t.getLeftTree() != null){
				stack.push(t);
				logPrintln("------>"+stack);
				inOrderTrav(t.getLeftTree());
			}else{
				logPrintln(t);
				inOrderTravResult += t;
				if(t.getRightTree() != null){
					inOrderTrav(t.getRightTree());
				}else if(t.getRightTree() == null && !stack.empty()){
					Tree tempTree = stack.pop();
					tempTree.setLeftTree(null);
					inOrderTrav(tempTree);
				}
			}
		}
	}

	/**
	 * 后续遍历
	 * 1.1 有左节点
	 * 		1.1.1入栈
	 * 		1.1.2后序遍历树
	 * 1.2 没有左节点
	 * 		1.2.1有右节点
	 * 			1.2.1.1入栈
	 * 		1.2.2没有右节点
	 * 			1.2.2.1将栈中元素取出，确定节点位置关系
	 * */
	public static void postOrderTrav(Tree t){
		logPrint(executeNum++ + ":");
		// 后序排列：左——>右——>根
		if(t != null){
			if(t.getLeftTree() != null){
				stack.push(t);
				logPrintln("------>"+stack);
				postOrderTrav(t.getLeftTree());
			}else{
				if(t.getRightTree() != null){
					stack.push(t);
					logPrintln("------>" + stack);
					postOrderTrav(t.getRightTree());
				}else if(t.getRightTree() == null){
					logPrintln(t);
					postOrderTravResult += t;
					if(!stack.empty()){
						Tree tx = stack.pop();
						logPrintln("------>"+stack);
						int relationx = getRelation(t,tx);
						if(relationx == -1){
							tx.setLeftTree(null);
							if(tx.getRightTree() != null){
								stack.push(tx);
								logPrintln("------>" + stack);
								postOrderTrav(tx.getRightTree());
							}else{
								postOrderTrav(tx);
							}
						}else if(relationx == -2){
							tx.setRightTree(null);
							postOrderTrav(tx);
						}
					}
				}
			}
		}
	}

	/**
	 * 后续遍历确定t1和t2的位置
	 * 判断前者与后者是什么关系
	 *默认t1为父树,t2为子树
	 * 返回值 1 则t2是t1的左子树，2 则t2是t1的右子树，0表示两者没有联系
	 * 返回值为负值，-1 则t1是t2的左子树，-2 则t1是t2的右子树
	 */
	public static int getRelation(Tree t1,Tree t2){
		if(t1.getLeftTree() != null){
			if(t1.getLeftTree().toString().equals(t2.toString()))
				return 1;
		}
		if(t1.getRightTree() != null){
			if (t1.getRightTree().toString().equals(t2.toString())) 
				return 2;
		}
		if(t2.getLeftTree() != null){
			if(t2.getLeftTree().toString().equals(t1.toString()))
				return -1;
		}
		if(t2.getRightTree() != null){
			if (t2.getRightTree().toString().equals(t1.toString()))
				return -2;
		}
		return 0;
	}

	//层次遍历
	public static void  levelTrav(Tree t){
		logPrint(executeNum++ + ":");
		if(t != null){
			logPrintln(t+"");
			levelOrderTravResult += t;
			if(t.getLeftTree() != null){
				treeHeap.add(t.getLeftTree());
			}
			if(t.getRightTree() != null){
				treeHeap.add(t.getRightTree());
			}
			if(treeHeap.size()>0){
				Tree tx = popHeap(treeHeap);
				levelTrav(tx);
			}
		}
	}

	//层次遍历将集合中的元素取出
	public static Tree popHeap(List<Tree> heapList){
		Tree tempTree = null;
		if(heapList != null && heapList.size() > 0){
			tempTree = heapList.get(0);
			heapList.remove(tempTree);
		}
		return tempTree;
	}
}
