package ArrayStack;
public class ArrayStack {

    private Object[] data;
    private int top;

    public ArrayStack() {
        data = new Object[4];
        top = 0;
    }

    public int size() { return top; }
    public boolean isEmpty() { return top == 0; }

    public void push(Object v) {
        if (top == data.length) grow();
        data[top++] = v;
    }

    public Object peek() {
        if (isEmpty()) throw new IllegalStateException();
        return data[top - 1];
    }

    public Object pop() {
        if (isEmpty()) throw new IllegalStateException();
        Object v = data[--top];
        data[top] = null;
        return v;
    }

    private void grow() {
        Object[] t = new Object[data.length * 2];
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
