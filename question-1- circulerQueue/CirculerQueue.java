package circulerQueue;



public class CirculerQueue {
	
	int size;
	int front = -1, rear =-1;
	int queque[];
	
	/*
	 * @param size
	 * */
	public CirculerQueue(int size) {
		this.size = size;
		queque = new int[size];
	}

	
	//Getter Setter
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}
	
	/*
	 * @return true if full else false
	 * */
	boolean isFull()
	{
	    if( (this.getFront() == this.getRear() + 1) || (this.getFront() == 0 && this.getRear() == this.getSize()-1)) {
	    	return true;
	    }
	    return false;
	}
	
	/*
	 * @return true if empty else false
	 * */
	boolean isEmpty()
	{
	    if(this.getFront() == -1) return true;
	    return false;
	}
	
	boolean enQueue(int element)
	{
	    if(isFull()) {
	    	
	    	throw new RuntimeException("\n Queue is full!! \n");
	    }
	    else
	    {
	        if(this.getFront() == -1) this.setFront(0);
	        int tempRear = (this.getRear() + 1) % this.getSize();
	        this.setRear(tempRear);
	        this.queque[this.getRear()] = element;
	        return true;
	    }
	}
	
	/*
	 *@return element, deleted element from queue
	 * */
	int deQueue()
	{
	    int element;
	    if(this.isEmpty()) {
	    	throw new RuntimeException("\n Queue is Empty!! \n");
	    } else {
	        element = this.queque[this.getFront()];
	        if (this.getFront() == this.getRear()){
	            this.setFront(-1);
	            this.setRear(-1);
	        } /* Q has only one element, so we reset the queue after dequeing it. ? */
	        else {
	            int tempFront = (this.getFront() + 1) % this.getSize();
	            this.setFront(tempFront);
	        }
	     
	        return(element);
	    }
	}
}
