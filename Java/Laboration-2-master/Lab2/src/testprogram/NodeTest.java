package testprogram;

import myutil.Node;

public class NodeTest {

	public NodeTest() {
	}
	
	public static void main(String [] args) {
		Node<Integer> nod = new Node<Integer>(5);
		System.out.println(nod.getData());
		
		Node<Integer> nod2 = new Node<Integer>(3);
		System.out.println(nod2.getData());
	}

}
