package circulerQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirculerQueueTest {
	
	//creating a circulerQueue of size 5
	CirculerQueue circulerQueue = new CirculerQueue(5);

	@Test
	public void isFulltest() {
		assertEquals(false, circulerQueue.isFull());
	}
	
	@Test
	public void isEmptytest() {
		assertEquals(true, circulerQueue.isEmpty());
	}
	
	
	@Test(expected=RuntimeException.class)
	public void enQueuetest() {
		assertEquals(true, circulerQueue.enQueue(1));
		assertEquals(true, circulerQueue.enQueue(2));
		assertEquals(true, circulerQueue.enQueue(3));
		assertEquals(true, circulerQueue.enQueue(4));
		assertEquals(true, circulerQueue.enQueue(5));
		
		//as Queue is full now , so at the time of insertion of new element it will generate runtime exception
		assertEquals(true, circulerQueue.enQueue(6));
		
		
		
	}
	
	@Test(expected = RuntimeException.class)
	public void deQueuetest() {
		
		//enQueuing element first
		assertEquals(true, circulerQueue.enQueue(1));
		assertEquals(true, circulerQueue.enQueue(2));
		assertEquals(true, circulerQueue.enQueue(3));
		assertEquals(true, circulerQueue.enQueue(4));
		assertEquals(true, circulerQueue.enQueue(5));
		
		
		//dequeuing element now
		assertEquals(1, circulerQueue.deQueue());
		assertEquals(2, circulerQueue.deQueue());
		assertEquals(3, circulerQueue.deQueue());
		assertEquals(4, circulerQueue.deQueue());
		assertEquals(5, circulerQueue.deQueue());
		
		//as Queue is Empty now , so at the time of insertion of new element it will generate runtime exception
		assertEquals(6, circulerQueue.deQueue());
	}
	
	


}
