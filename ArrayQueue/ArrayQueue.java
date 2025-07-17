public class ArrayQueue {

    private Object[] data;
    private int front; // points to the first element (helps with the dequeu operation)
    private int rear; //points to first empty slot
    private int size;

    public ArrayQueue() {
        data = new Object[4];
        front = 0;
        rear = 0;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(Object value) {
        if (size == data.length) grow(); //double capacity when full
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    public Object peek() {
        if (isEmpty()) throw new IllegalStateException();
        return data[front];
    }

    public Object dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        Object v = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return v;
    }

    private void grow() {
        Object[] tmp = new Object[data.length * 2];
        for (int i = 0; i < size; i++) tmp[i] = data[(front + i) % data.length]; //copy in logical order 
        data = tmp;
        front = 0;
        rear = size; //next free slot after last copy 
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println(q.dequeue()); // A
        q.enqueue("D");
        while (!q.isEmpty()) System.out.print(q.dequeue() + " "); // B C D
        System.out.println();
    }
}
