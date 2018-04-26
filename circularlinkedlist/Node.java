//node object used in a linked list program
//includes a displayNode function

package ds.circularlinkedlist;

public class Node {
	public int data;
	public Node next;
	
	public void displayNode() {
		System.out.println("{ " + data + " } ");
	}
}
