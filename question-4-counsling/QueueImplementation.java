package counsling;

public class QueueImplementation implements Queue{
    static Queue queue;
    static Node front,rear;

    @Override
    public void Enqueue(String data) {
        Node node =new Node(data);
        if(front==null) {
            front=node;  
            rear=node;
        }
        else {
            rear.setNext(node);
            rear=node;
        }
    }

    @Override
    public String Dequeue() {
        if(front==rear) {
            String data=front.data;
            front=null;
            rear=null;
            return data;
        }
        String data=front.data;
        front=front.next;
        return data;
    }

    @Override
    public void Traverse() {
        Node trace=front;
        while(trace!=null) {
            System.out.print(trace.data+" ");
            trace=trace.next;
        }
    }

    @Override
    public boolean isEmpty() {

        if(rear==null) 
            return true; 
        else 
            return false;        
    }
    public static Queue getInstance() {
        if(queue==null) {
            queue=new QueueImplementation();
        }
        return queue;
    }
}
