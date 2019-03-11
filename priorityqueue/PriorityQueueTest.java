package priorityqueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class PriorityQueueTest 
{
	PriorityQueue priority = new PriorityQueue(6);
	
	@Test
	public void isEmptytest() 
	{
		assertEquals(true, priority.isEmpty());
		priority.enqueue(2);
		
		
		assertEquals(false, priority.isEmpty());
		
		priority.dequeue(0);
		
		assertEquals(true, priority.isEmpty());
	}
	
	@Test
	public void isFulltest() 
	{
		assertEquals(false, priority.isFull());
		priority.enqueue(3);
		priority.enqueue(5);
		priority.enqueue(4);
		priority.enqueue(7);
		priority.enqueue(6);
		priority.enqueue(5);
		assertEquals(true, priority.isFull());
	}
	
	@Test
	public void sizetest()
	{
		assertEquals(0, priority.size());
	}
	
	@Test
	public void toStringtest()
	{
		assertEquals("[ ]", priority.toString());
		priority.enqueue(3);
		priority.enqueue(5);
		priority.enqueue(4);
		priority.enqueue(7);
		priority.enqueue(6);
		priority.enqueue(8);
		assertEquals("[8, 7, 6, 5, 4, 3]", priority.toString());
	}
	
}
