package queue;

public interface Queue<T>{
	void enqueue(String job, int priority);
	T dequeue();
}
