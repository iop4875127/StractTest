package StackTree;

import java.util.ArrayList;

public class ZnyyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node one = new Node();
		one.point = 1;
		one.value = 2;
		one.nextPoint = 2;
		Node two = new Node();
		two.point = 2;
		two.value = 7;
		two.nextPoint = 3;
		Node three = new Node();
		three.point = 3;
		three.value = 9;
		three.nextPoint = 4;
		Node four = new Node();
		four.point = 4;
		four.value = 11;
		four.nextPoint = 5; 
		Node five = new Node();
		five.point = 5;
		five.value = 1;
		five.nextPoint = 0;
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		nodes.add(five);
		
		ArrayList<Node> nodesResul = new ArrayList<Node>();
		for( int i = 0; i <= 3 ; i++){
			
			Node t = nodes.get(i);
			Node tx = nodes.get(i+1);
			
			swap(t, tx);
			nodesResul.add(t);
		}
		System.out.println(nodesResul);
		
	}
	static void swap(Node t, Node tx) {
        int temp = t.point;
//        t.point = tx.nextPoint;
        tx.nextPoint = temp;
        t.point = temp;
    }
}
