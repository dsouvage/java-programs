//creates a circular linked list class which is more 
//efficient than a single linked list program
//needs a node class

package ds.circularlinkedlist;

public class CircularLinkedList {
	
	private Node first;
	private Node last;
	
	
	public CircularLinkedList() {
		first = null;
		last = null;
	}
	
	private boolean isEmpty() {
		return first==null;
	}
	
	//pushes a value to the front of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			last = newNode;
		}
		newNode.next = first; //new node is being assigned old first
		first = newNode; //first place
	}

	//pushes a value to the end of the list
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; //the next value of the last node will point to the new node
			last = newNode; //make the new node be the last one in the list
		}
	}
	
	public int deleteFirst() {
		int temp = first.data;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	//displays the list of nodes using the displayNode method from
	//the node class
	public void displayList() {
		System.out.println("List (first --> last)");
		
		Node current = first;
		
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
}
