package CircularLinkedList;
public class CircularLinkedList {

    private static class Node { //the single node
        Object v;
        Node next;
        Node(Object v) { this.v = v; }
    }

    private Node tail; //when list is non-empty, tail.next is the head 
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Object front() { // the value at the head 
        if (isEmpty()) throw new IllegalStateException();
        return tail.next.v;
    }

    public void add(Object val) { // enqueue at tail
        Node n = new Node(val);
        if (tail == null) { //first node, n points to itself 
            n.next = n;
            tail = n;
        } else {
            n.next = tail.next;
            tail.next = n;
            tail = n; // new node become tail
        }
        size++;
    }

    public Object remove() { // dequeue at head
        if (isEmpty()) throw new IllegalStateException();
        Node head = tail.next;
        Object v = head.v;
        if (head == tail) tail = null; //last element removed 
        else tail.next = head.next; //pass the old head
        size--;
        return v;
    }

    public void rotate() { if (tail != null) tail = tail.next; } // head --> next and tail ---> tail.next 

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.add(1); cl.add(2); cl.add(3);
        System.out.println(cl.front());   // 1
        cl.rotate();                      // head becomes 2
        System.out.println(cl.front());   // 2
        System.out.println(cl.remove());  // 2
        cl.rotate();
        while (!cl.isEmpty()) System.out.print(cl.remove() + " "); // 3 1
        System.out.println();
    }
}
