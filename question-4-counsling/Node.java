package counsling;
public class Node {
	String data;
    Node next;
    public Node(String data) {
        this.data=data;
        this.next=null;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next=node;
    }
}


