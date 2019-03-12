package evalPostfix;

public interface Stack {
	void push(int data);
	int pop();
	int peek();
	boolean isEmpty();
	int getSize();
}
