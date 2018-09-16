//creates a singly linked list of nodes from the node class
//contains a variety of methods to play and use the linked list

package ds.singlylinkedlist;

public class SinglyLinkedList {
	private Node first;
	private Node last;
	
	//representation of the default constructor
	public SinglyLinkedList() {
		
	}

	public boolean isEmpty() {
		return (first == null);
	}
	
	//used to insert at the beginning of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		
		newNode.data = data;
		
		newNode.next = first;
		
		first = newNode;
		
	}
	
	//inserts a data node into the last chain of the list
	public void insertLast(int data) {
		Node current = first;
		while(current.next != null) {
			current = current.next; //we'll loop until current.next is null
		}
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
		
	}
	
	//deletes the first node in a singly linked list
	public Node deleteFirst() {
		Node temp = first;
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

