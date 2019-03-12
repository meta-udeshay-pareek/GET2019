package queue;
/**
 ** Java Program to implement Priority Queue
 **/
 


 
/** Class PriorityQueue **/
class PriorityQueue implements Queue<Task>
{
    private Task[] heap; 
    private int size, capacity;
 
    /** Constructor **/
    public PriorityQueue(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        this.setSize(0);
    }
    
    
    
    /** Getter Setter **/
    public int getSize()
    {
        return size;
    }
    
    public int getCapacity() {
		return capacity;
	}
    
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	/** Getter Setter End **/
    
	
	
    
    
    /** function to clear **/
    public void clear()
    {
        heap = new Task[capacity];
        this.setSize(0);
    }
    
    
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return this.getSize() == 0;
    }
    
    
    /** function to check if full **/
    public boolean isFull()
    {
        return this.getSize() == capacity - 1;
    }
   
    
    
	/** function to insert task **/
    public void enqueue(String job, int priority)
    {
        Task newJob = new Task(job, priority);
 
        heap[++size] = newJob;
        int pos = this.getSize();
        while (pos != 1 && newJob.getPriority() > heap[pos/2].getPriority())
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    
    }
    
    
    /** function to remove task **/
    public Task dequeue()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[size--];
 
        parent = 1;
        child = 2;
        while (child <= size)
        {
            if (child < size && heap[child].getPriority() < heap[child + 1].getPriority())
                child++;
            if (temp.getPriority() >= heap[child].getPriority())
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }



	
}
 
