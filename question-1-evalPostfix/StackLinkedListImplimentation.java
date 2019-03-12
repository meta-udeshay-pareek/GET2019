package evalPostfix;

public class StackLinkedListImplimentation implements Stack {
	
	Node top ;
	int size ;
	
	//Getter Setter
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}   

	
	/*  Constructor  */
	public StackLinkedListImplimentation()
	{
		this.top = null;
		this.size = 0;
	}    
	
	
	/*  Function to check if stack is empty */
	public boolean isEmpty()
	{
		return this.top == null;
	}    
	
	
	
	/*  Function to push an element to the stack */
	public void push(int data)
	{
		Node node = new Node (data, null);
		if (this.top == null)
			this.setTop(node);
		else
		{
			node.setLink(top);
			this.setTop(node);
		}
		this.size++ ;
	}    
	

	/*  Function to pop an element from the stack */
	public int pop()
	{
		if (isEmpty() )
			throw new RuntimeException("Underflow Exception") ;
		Node ptr = this.getTop();
		this.setTop(ptr.getLink());
		this.size-- ;
		return ptr.getData();
	}    
	
	/*  Function to check the top element of the stack */
	public int peek()
	{
		if (isEmpty() )
			throw new RuntimeException("Underflow Exception") ;
		return this.top.getData();
	}    
}
