//node object used in a singly linked list program
//includes a displayNode function

package ds.singlylinkedlist;

public class Node {
	public int data;
	public Node next;
	
	public void displayNode() {
		System.out.println("{ " + data + " } ");
	}
}
