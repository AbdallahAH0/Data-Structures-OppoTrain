package SinglyLinkedList;
public class SinglyLinkedList {

    private static class Node {
        Object data;
        Node next;
        Node(Object d, Node n) { data = d; next = n; }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public int size()            { return size; }
    public boolean isEmpty()     { return size == 0; }

    public Object get(int index) {
        check(index);
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.data;
    }

    public void set(int index, Object element) {
        check(index);
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        cur.data = element;
    }

    public void add(Object element) {
        if (head == null) {
            head = new Node(element, null);
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node(element, null);
        }
        size++;
    }

    public void insert(int index, Object element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            prev.next = new Node(element, prev.next);
        }
        size++;
    }

    public Object remove(int index) {
        check(index);
        Object removed;
        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            removed = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    private void check(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("Ahmad");
        list.add("Qusay");
        list.insert(1, "Bob");
        list.set(0, "Suhaib");
        list.remove(1);
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
