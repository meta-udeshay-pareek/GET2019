package queue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

	PriorityQueue priority = new PriorityQueue(6);

	@Test
	public void isEmptytest() 
	{
		assertEquals(true, priority.isEmpty());
		priority.enqueue("job1",1);


		assertEquals(false, priority.isEmpty());

		priority.dequeue();

		assertEquals(true, priority.isEmpty());
	}

	@Test
	public void isFulltest() 
	{
		assertEquals(false, priority.isFull());
		priority.enqueue("job1",1);
		priority.enqueue("job2",2);
		priority.enqueue("job3",3);
		priority.enqueue("job4",4);
		priority.enqueue("job5",5);
		priority.enqueue("job6",6);
		assertEquals(true, priority.isFull());
	}

	@Test
	public void sizetest()
	{
		assertEquals(0, priority.getSize());
	}

	

}
