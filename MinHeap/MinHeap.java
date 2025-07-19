package MinHeap;

public class MinHeap<T extends Comparable<T>> {

    private Object[] data; //array, root is at index 0
    private int size; //current numbers of elements 

    public MinHeap() {
        data = new Object[8]; //initial capacity 
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void add(T value) { //insert value then reset heap order 
        if (size == data.length) grow(); // double the array when it's full
        data[size] = value; // add at the next free slot 
        siftUp(size); // move toward root if needed 
        size++;
    }

    public T peek() { // gets the smallest element without removing 
        if (isEmpty()) throw new IllegalStateException();
        return elementAt(0);
    }

    public T poll() { // remove and gets the smallets element also it pushes last down to reset order
        if (isEmpty()) throw new IllegalStateException();
        T root = elementAt(0);
        data[0] = data[--size];
        data[size] = null;
        if (!isEmpty()) siftDown(0); //reset heap property 
        return root;
    }

    private void siftUp(int idx) { //move the element up until the parent is smaller 
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (elementAt(idx).compareTo(elementAt(parent)) >= 0) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    private void siftDown(int idx) { //move element down until childern are larger 
        while (true) {
            int left  = idx * 2 + 1;
            int right = idx * 2 + 2;
            if (left >= size) break; //no children 
            int smaller = (right < size && elementAt(right).compareTo(elementAt(left)) < 0) ? right : left;
            if (elementAt(idx).compareTo(elementAt(smaller)) <= 0) break;
            swap(idx, smaller);
            idx = smaller;
        }
    }

    private void swap(int i, int j) {
        Object tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int i) {
        return (T) data[i];
    }

    private void grow() { //double backing array capacity 
        Object[] tmp = new Object[data.length * 2];
        System.arraycopy(data, 0, tmp, 0, data.length);
        data = tmp;
    }


    public static void main(String[] args) {
        MinHeap<Integer> h = new MinHeap<>();
        h.add(5);
        h.add(3);
        h.add(8);
        h.add(1);
        h.add(4);

        System.out.println(h.peek());   // 1
        while (!h.isEmpty()) System.out.print(h.poll() + " "); // 1 3 4 5 8
        System.out.println();
    }
}
