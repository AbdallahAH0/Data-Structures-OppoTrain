package LinkedStack;
public class LinkedStack {

    private static class Node { //single stack node
        Object v;
        Node n;
        Node(Object v, Node n) 
        { this.v = v; this.n = n; }
    }

    private Node head; //top of stack 
    private int size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(Object v) {
        head = new Node(v, head); //link new node before currnet head 
        size++;
    }

    public Object peek() {
        if (isEmpty()) throw new IllegalStateException();
        return head.v;
    }

    public Object pop() {
        if (isEmpty()) throw new IllegalStateException();
        Object v = head.v;
        head = head.n; //move head down
        size--;
        return v;
    }

    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());  // 3
        System.out.println(s.pop());   // 3
        s.push(4);
        while (!s.isEmpty()) System.out.print(s.pop() + " "); // 4 2 1
        System.out.println();
    }
}
