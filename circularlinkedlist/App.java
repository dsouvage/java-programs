package ds.circularlinkedlist;

public class App {

	public static void main(String[] args) {
		CircularLinkedList mylist = new CircularLinkedList();
		mylist.insertFirst(100);
		mylist.insertFirst(55);
		mylist.insertFirst(99);
		mylist.insertFirst(88);
		
		mylist.insertLast(9999);
		
		mylist.displayList();	

	}
}
