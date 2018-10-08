package ds.nonbinarytree;

public class Node {

	int key; //numeric key
	String value; //data 
	Node leftChild, rightChild; //left and right branches of the tree
	
	public Node(int key, String value) {
		super(); //calls the parent constructor with no arguments
		this.key = key;
		this.value = value;
	}
	
	
}
