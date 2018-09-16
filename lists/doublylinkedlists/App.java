package ds.doublylinkedlists;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		
		//inserts at start of list
		theList.insertFirst(1);
		theList.insertFirst(2);
		theList.insertFirst(3);
		//inserts at end of list
		theList.insertLast(25);
		theList.insertLast(26);
		theList.insertLast(27);
		//displays from start to back
		theList.displayForward();
		//displays from back to start
		theList.displayBackward();	
		//deletes at the start
		theList.deleteFirst();
		//deletes at the end
		theList.deleteLast();
		//deletes a specific reference
		theList.deleteKey(25);
		
		theList.displayForward();
		//inserts after a specific "key variable"
		theList.insertAfter(1, 77);
		theList.insertAfter(26, 88);
		
		theList.displayForward();
		
	
	}

}
