//node object used in a linked list program
//includes a displayNode function

package ds.doublylinkedlists;

public class Node {
	public int data;
	public Node next;
	public Node previous;
	
	public void displayNode() {
		System.out.println("{ " + data + " } ");
	}
}
