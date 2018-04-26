//App for using the singly linked list

package ds.singlylinkedlist;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList mylist = new SinglyLinkedList();
		mylist.insertFirst(100);
		mylist.insertFirst(55);
		mylist.insertFirst(99);
		mylist.insertFirst(88);
		
		mylist.insertLast(9999);
		
		mylist.displayList();
		
		
		

	}

}
