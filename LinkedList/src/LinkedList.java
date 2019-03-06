public class LinkedList {

	private Node head;
	private int size=0;

	//Getter Setter
	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList() {
		head=null;
	}

	/*
	 * @param currentNode, reference of last node
	 * @param element, element to be inserted at last of linked list
	 * @return Node,reference of current last node
	 * */

	public Node addElementAtLast(Node currentNode,int element){

		if(this.head==null) {
			this.head= new Node(element);
			this.size++;
			return this.head;
		}
		currentNode.setNext(new Node(element));

		this.size++;
		return currentNode.getNext();

	}


	/*
	 * @param list , on which we have to apply rotate operation
	 * @param L, the starting of sublist in list
	 * @param R,the ending position in list of sublist
	 * @return list,updated whole list after apply rotation 
	 * */
	public LinkedList rotate(LinkedList list,int L, int R,int N){
		
		//currentNode first will point to head of the linked list
		Node currentNode = list.getHead();
		
		
		Node subListHead=null,subListTail=null,parentSubListHead=null;
		
		//count for reaching at L and R
		int count=1;
		
		
		//fetching sublist from the whole list for apply rotation part on that
		while(currentNode.getNext()!=null) {
			
			//if count+1==L then psh will be current node and next node will be sublistHead
			if(count+1==L) {
				parentSubListHead=currentNode;
				subListHead=currentNode.getNext();
			}
			//if got the Right position then break out from this loop
			if(count==R) {
				subListTail=currentNode;
				break;
			}
			
			currentNode=currentNode.getNext();
			count++;
		}
		

		//For Rotating the sublist N times
		while(N!=0) {
			//currentNode will be subListHead now
			currentNode=subListHead;
			
			//reaching at second last element of sublist so that last element can be move to first
			while(currentNode.getNext()!=subListTail) {
				currentNode = currentNode.getNext();
			}
		
			//currentNode is now secondLast Element Of sublist
			//setting currentNode's next to next of last node so last node will be separate from list
			currentNode.setNext(subListTail.getNext());
			
			//setting up the separated node at first of subList (separated Node's next will point to subListHead)
			subListTail.setNext(subListHead);
			
			//separated node is now added at head and this node is head of subList
			subListHead = subListTail;
			
			//parentSubListHead will be parent of subListHead
			parentSubListHead.setNext(subListHead);
			
			//currentNode will be last node of the sublist
			subListTail=currentNode;
			N--;
		}
	

		//returning updated list
		return list;
	}
	
	/*
	 * @param list , LinkedList in which we have to detect loop
	 * @return "true" if loop found in linkedList else "false"
	 * */
	static boolean isLoopinLinkedList(LinkedList list) {
		
		Node slowPointer = list.getHead(), fastPointer = list.getHead();
		
		while(slowPointer!=null && fastPointer != null && fastPointer.getNext() != null) {
			 slowPointer = slowPointer.getNext();
			 fastPointer = fastPointer.getNext().getNext();
			 
			 if (slowPointer == fastPointer) {
				 return true;
			 }
			
		}
		
		return false;
	}
	

}
