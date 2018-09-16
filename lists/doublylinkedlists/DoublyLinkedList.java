package ds.doublylinkedlists;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			last = newNode; //if empty, last refers to new node being created
		}else{
			first.previous = newNode;
		}
		
		newNode.next = first; //new node next field points to old first
		this.first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {

			last.next = newNode; //assigning old last to new code
			newNode.previous = last; //old last will be newcodes previous
			
		}
		last = newNode; //make the new node be the last one in the list
	}
	
	//assume non empty list!!!
		public Node deleteFirst() {
		Node temp = first;
		if (first.next == null) { //only one item in list
			last = null;
		} else {
			first.next.previous = null; //lists first node points to null
		}
	
		first = first.next; //moves the first (now going to be deleted) node to the node that is following
		return temp;
	}
	
	//assume non empty list!!!
	public Node deleteLast() {
		Node temp = last;
		if (first.next == null) { //only one item in list
			first = null;
		} else {
			last.previous.next = null; //lists previous node's previous's node to point to null as next
		}
		
		last = last.previous; //moves the last (now going to be deleted) node to the node that is previous
		return temp;
	}
		
	//assume non empty list!!!
	public boolean insertAfter(int key, int data) {
		Node current = first; //we start from the beginning of the list
		while(current.data != key) { //as long as we have not found the key in a particular node
			current = current.next;
			if(current == null) {
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(current == last) {
			current.next = null;
			last = newNode;
		} else { 
			newNode.next = current.next; //new nodes next field should point to the node ahead of the current one
			current.next.previous = newNode; //the new nodes next nodes previous node will become the new node

		}
		
		newNode.previous = current;
		current.next = newNode;
		
		return true;
		
	}
	
	//assume non empty list!!!
	public Node deleteKey(int key) {
		Node current = first; //start from the beginning
		while(current.data != key) {
			current = current.next;
			if(current == null) {
				return null;
			}
		}
		
		if(current == first) {
			first = current.next;//make the first field point to the node following current since current will be deleted
		} else {
			current.previous.next = current.next; 
		}
		
		if(current == last) {
			last = current.previous; //if current is last, then previous node will become last
		} else {
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	//displays the list of nodes using the displayNode method from
	//the node class start to end
	public void displayForward() {
			System.out.println("List (first --> last)");
			
			Node current = first;
			
			while(current != null) {
				current.displayNode();
				current = current.next;
			}
			System.out.println();
	}
	
	//displays the list of nodes using the displayNode method from
	//the node class end to start
	public void displayBackward() {
		System.out.println("List (last --> first)");
		
		Node current = last;
		
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
	
		
}

	
	
	
		
		
	
	
	
	
	
	

