package counsling;

public interface Queue {
	
	public void Enqueue(String data);
	public String  Dequeue();
	public boolean isEmpty();
	public void Traverse();
}
