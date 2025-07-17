package LinkedQueue;
public class LinkedQueue {

    private static class Node { // single queue node
        Object v;
        Node n;
        Node(Object v) { this.v = v; }
    }

    private Node head; //points to next element (helps with dequeue)
    private Node tail; // points to last element (helps with enqueue)
    private int size;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(Object value) {
        Node node = new Node(value);
        if (tail == null) { //queue was empty 
            head = tail = node;
        } else {
            tail.n = node; //link new node after the old tail
            tail = node; //update tail
        }
        size++;
    }

    public Object peek() {
        if (isEmpty()) throw new IllegalStateException();
        return head.v;
    }

    public Object dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        Object v = head.v;
        head = head.n; //move head forward 
        if (head == null) tail = null; //queue became empty
        size--;
        return v;
    }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());   // 1
        System.out.println(q.dequeue()); // 1
        q.enqueue(4);
        while (!q.isEmpty()) System.out.print(q.dequeue() + " "); // 2 3 4
        System.out.println();
    }
}
