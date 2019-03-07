import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedTest {

	@Test
	void testRotate1() {
		int inputList[] = {2,3,4,5,6,7},expectedList[] = {2,5,6,3,4,7};
		LinkedList list = intitializeLinkedList(inputList);
		int L = 2,R=5,N=2;
		
		assertArrayEquals(expectedList, LinkedList.rotate(list,L,R,N).toArray());
	}
	
	@Test
	void testRotate2() {
		int inputList[] = {1,2,3,4,5,6,7,8,9},expectedList[] = {1,7,8,2,3,4,5,6,9};
		LinkedList list = intitializeLinkedList(inputList);
		int L = 2,R=8,N=2;
		
		assertArrayEquals(expectedList, LinkedList.rotate(list,L,R,N).toArray());
	}
	
	@Test
	void testRotate3() {
		int inputList[] = {1,2,3,4,5,6,7},expectedList[] = {6,7,1,2,3,4,5};
		LinkedList list = intitializeLinkedList(inputList);
		int L = 1,R=7,N=2;
		
		assertArrayEquals(expectedList, LinkedList.rotate(list,L,R,N).toArray());
	}
	
	@Test
	void testRotate4() {
		int inputList[] = {1,2,3,4,5,6,7},expectedList[] = {1,5,2,3,4,6,7};
		LinkedList list = intitializeLinkedList(inputList);
		int L = 2,R=5,N=1;
		
		assertArrayEquals(expectedList, LinkedList.rotate(list,L,R,N).toArray());
	}
	
	@Test
	void testLoop1() {
        LinkedList list = new LinkedList(); 
        list.setHead(new Node(50)); 
        list.getHead().setNext(new Node(20)); 
        list.getHead().getNext().setNext(new Node(15)); 
        list.getHead().getNext().getNext().setNext(new Node(4)); 
        list.getHead().getNext().getNext().getNext().setNext(new Node(10)); 
  
        // Creating a loop for testing  
        list.getHead().getNext().getNext().getNext().getNext().setNext(list.getHead().getNext().getNext()); 
        assertEquals(true,LinkedList.isLoopinLinkedList(list));
	}
	
	@Test
	void testLoop2() {
        LinkedList list = new LinkedList(); 
        list.setHead(new Node(10)); 
        list.getHead().setNext(new Node(60)); 
        list.getHead().getNext().setNext(new Node(25)); 
        list.getHead().getNext().getNext().setNext(new Node(84)); 
        list.getHead().getNext().getNext().getNext().setNext(new Node(19)); 
  
        // Creating a loop for testing  
        list.getHead().getNext().getNext().getNext().setNext(list.getHead().getNext()); 
        assertEquals(true,LinkedList.isLoopinLinkedList(list));
	}
	
	
	@Test
	void testLoop3() {  
		int inputList[] = {2,3,4,5,6,7};
		LinkedList list = intitializeLinkedList(inputList);
        assertEquals(false,LinkedList.isLoopinLinkedList(list));
	}
	
	@Test
	void testLoop4() {
		int inputList[] = {2,3,4,5,6,7,8,9,1,2,3,4};
		LinkedList list = intitializeLinkedList(inputList);
        assertEquals(false,LinkedList.isLoopinLinkedList(list));
	}
	
	
	/*
	 * @param arr, element for creation of a linked list
	 * @return list, the created linkedList
	 *   this method is taking linkedList elements into an array and creating a linkedList for testing 
	 *   	
	 * */
	private LinkedList intitializeLinkedList(int [] arr) {
		LinkedList list = new LinkedList();
		Node currentNode = list.getHead();
		for(int element:arr) {
			currentNode = list.addElementAtLast(currentNode, element);
		}
		
		return list;
	}
	
	

}
