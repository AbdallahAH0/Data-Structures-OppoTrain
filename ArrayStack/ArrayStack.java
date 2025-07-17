package ArrayStack;
public class ArrayStack {

    private Object[] data;
    private int top; //index of next free slot also it's the current size

    public ArrayStack() {
        data = new Object[4]; 
        top = 0;
    }

    public int size() { return top; }
    public boolean isEmpty() { return top == 0; }

    public void push(Object v) {
        if (top == data.length) grow(); //resize when full
        data[top++] = v; // store then advance top 
    }

    public Object peek() {
        if (isEmpty()) throw new IllegalStateException();
        return data[top - 1]; //last pushed element
    }

    public Object pop() {
        if (isEmpty()) throw new IllegalStateException();
        Object v = data[--top]; //step back and then read
        data[top] = null; //avoid memory leak
        return v;
    }

    private void grow() {
        Object[] t = new Object[data.length * 2]; //double the capacity 
        for (int i = 0; i < data.length; i++) t[i] = data[i];
        data = t;
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s.pop());   // C
        System.out.println(s.peek());  // B
        s.push("D");
        while (!s.isEmpty()) System.out.print(s.pop() + " "); // D B A
        System.out.println();
    }
}
