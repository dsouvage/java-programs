package ds.nonbinarytree;

public class BST {

	private Node root; //top of tree
	
	//insert method
	public void insert(int key, String value) {
		
		Node newNode = new Node(key, value); //create our new node
		
		
		if (root == null) { //if first, then root == new node
			root = newNode;
		} else { //figure out where to place if not first
			
			
			Node current = root; //traversing variable
			Node parent; //parent = parent of current node
			
			while(true) {
				
				parent = current;
				
				if (key < current.key) { //navigate left (less than currentnode)
					current = current.leftChild;
					
					
					//it's parent is the leaf node 
					if(current == null) { //at bottom -> insert node to previous node leftchild
						parent.leftChild = newNode; 
						return;
					}
					
				} else {
					current = current.rightChild; //navigate right (greater than currentnode)
					
					//it's parent is the leaf node
					if (current == null) {
						parent.rightChild = newNode; //at bottom -> insert node to previous node rightchild
					
						return;
					
					}
					
				}
				
			}	
			
		}
		
	}
	
	//traverses down leftside of tree
	public Node findMin() {
		
		Node current = root;
		Node last = null;
		
		//traversing
		while(current != null) {
			last = current;
			current = current.leftChild;
			
		}
		return last;
	}
	
	//traverses down rightside of tree
	public Node findMax() {
		Node current = root;
		Node last = null;
		
		//traversing
		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}
	
	
	public boolean remove(int key) {
		
		Node currentNode = root;
		Node parentNode = root;
		
		//easy enough to track one child
		boolean isLeftChild = false;
		
		//searching ot find the node with the key to delete
		
		while (currentNode.key != key) {
			
			//saves previous node
			parentNode = currentNode; 
			
			if (key < currentNode.key) {
				//traverse left side
				isLeftChild = true;
			
				currentNode = currentNode.leftChild;
				
			} else {
				//traverse right side
				currentNode = currentNode.rightChild;
				
				isLeftChild = false;
		
			}
			if (currentNode == null) {
				//doesn't exist
				return false; 
			}
			
		}
		
		//found node
		Node nodeToDelete = currentNode; //temp node
		
		//if node is a leaf
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			//
			if (nodeToDelete == root) {
				root = null;
			} else if (isLeftChild) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		}else if (nodeToDelete.rightChild == null) {//if node has one child that is on the left
			if (nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.leftChild;
			} else {
				parentNode.rightChild = nodeToDelete.leftChild;
			}
		} else if (nodeToDelete.leftChild == null) {//if node has one child that is on the right
			//
			if (nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.rightChild;
			} else {
				parentNode.rightChild = nodeToDelete.rightChild;
			}
			
		} else {//trying to delete a node if it has two children (most complicated)
		
			Node successor = getSuccessor(nodeToDelete);
			
			//connect parent of node to delete to successor instead
			if (nodeToDelete == root) {
				root = successor;
			} else if (isLeftChild) {
				parentNode.leftChild = successor;
			} else {//unplug and plug in successor
				parentNode.rightChild = successor;
			}
			
			//this is what does the actual replacement from successor we found
			successor.leftChild = nodeToDelete.leftChild;
			
		}
		
		
		
		
		
		return true; //returns if the node was deleted (true = true)
	}
	
	private Node getSuccessor(Node nodeToDelete) {
		
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;
		
		Node current = nodeToDelete.rightChild; //go to right child
		
		
		while (current != null) { //start going left down the tree 
			//assign parent first
			successorParent = successor;
			//advance until no more left children
			successor = current;
			current = current.leftChild; //leave loop at null
			
		}
		//if successor is not a right child
		//if successor is a left descendant of the right child of the node we're
		//trying to delete, if it's a left descendant -> 4 steps are required
		//to perform that deletion. 
		if (successor != nodeToDelete.rightChild) {
			
			successorParent.leftChild = successor.rightChild;//plug right child of successor into left child succesor parent
			successor.rightChild = nodeToDelete.rightChild;//plug right child into successor node rightchild
			
		}
		
		return successor;
	}
	
	
}

//print method looks like something like this
/*

    public void displayTree() {
            Stack globalStack = new Stack();
            globalStack.push(root);
            int nBlanks = 32;
            boolean isRowEmpty = false;
            System.out.println("......................................................");
            
            while(isRowEmpty==false) {
                Stack localStack = new Stack();
                isRowEmpty = true;
                for(int j=0; j<nBlanks; j++) {
                    System.out.print(" ");
                }
                    
                while(globalStack.isEmpty()==false) {
                    Node temp = (Node)globalStack.pop(); 
                    if(temp != null) {
                        System.out.print(temp.key); 
                        localStack.push(temp.leftChild); 
                        localStack.push(temp.rightChild);
                        if(temp.leftChild != null || temp.rightChild != null) {
                            isRowEmpty = false; 
                        }
                    } else {
                        System.out.print("--"); 
                        localStack.push(null); 
                        localStack.push(null);
                    }
                    
                    for(int j=0; j<nBlanks*2-2; j++) {
                        System.out.print(" ");
                    }
                }
                
                System.out.println();
                nBlanks = nBlanks/2;
                
                while(localStack.isEmpty()==false)
                    globalStack.push( localStack.pop() ); 
                }
            System.out.println( "......................................................");
     
     }



*/