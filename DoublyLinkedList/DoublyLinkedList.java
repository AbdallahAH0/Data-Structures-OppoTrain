package DoublyLinkedList;

public class DoublyLinkedList {

    private static class Node { // double linked node 
        Object v;
        Node prev, next;
        Node(Object v, Node p, Node n) { this.v = v; this.prev = p; this.next = n; }
    }

    private Node head, tail; // head = first, tail = last 
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Object get(int idx) {
        check(idx);
        Node cur = (idx < size / 2) ? head : tail; //choose nearest end 
        if (idx < size / 2)
            for (int i = 0; i < idx; i++) cur = cur.next; // walking forward 
        else
            for (int i = size - 1; i > idx; i--) cur = cur.prev; // walking backward 
        return cur.v;
    }

    public void set(int idx, Object val) {
        check(idx);
        Node cur = (idx < size / 2) ? head : tail;
        if (idx < size / 2)
            for (int i = 0; i < idx; i++) cur = cur.next;
        else
            for (int i = size - 1; i > idx; i--) cur = cur.prev;
        cur.v = val; //change the value 
    }
 
    public void add(Object val) { //append at tail
        Node n = new Node(val, tail, null);
        if (tail == null) head = n; else tail.next = n;
        tail = n;
        size++;
    }

    public void insert(int idx, Object val) { // insert at any index 
        if (idx < 0 || idx > size) throw new IndexOutOfBoundsException();
        if (idx == size) { add(val); return; }
        Node cur = (idx < size / 2) ? head : tail;
        if (idx < size / 2)
            for (int i = 0; i < idx; i++) cur = cur.next;
        else
            for (int i = size - 1; i > idx; i--) cur = cur.prev;
        Node n = new Node(val, cur.prev, cur);
        if (cur.prev == null) head = n; else cur.prev.next = n;
        cur.prev = n;
        size++;
    }

    public Object remove(int idx) { //remove and return value 
        check(idx);
        Node cur = (idx < size / 2) ? head : tail;
        if (idx < size / 2)
            for (int i = 0; i < idx; i++) cur = cur.next;
        else
            for (int i = size - 1; i > idx; i--) cur = cur.prev;
        if (cur.prev == null) head = cur.next; else cur.prev.next = cur.next;
        if (cur.next == null) tail = cur.prev; else cur.next.prev = cur.prev;
        size--;
        return cur.v;
    }

    private void check(int i) { if (i < 0 || i >= size) throw new IndexOutOfBoundsException(); } //bounds checking  

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add("A"); dl.add("B"); dl.add("C");
        dl.insert(1, "X");                 // A X B C
        dl.set(2, "Y");                    // A X Y C
        dl.remove(0);                      // X Y C
        for (int i = 0; i < dl.size(); i++) System.out.print(dl.get(i) + " ");
        System.out.println();
    }
}

