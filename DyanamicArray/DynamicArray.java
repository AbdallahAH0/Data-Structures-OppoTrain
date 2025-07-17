public class DynamicArray <T> {

    private Object[] data;
    private int size;

    public DynamicArray () {
        data = new Object[2]; // made it 2 to test the grow fun
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        check(index);
        return (T) data[index];
    }

    public void set(int index, T element) {
        check(index);
        data[index] = element;
    }

    public void add(T element) {
        if (size == data.length) grow();
        data[size] = element;
        size++;
    }

    public void addpos(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == data.length) grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public T remove(int index) {
        check(index);
        T removed = (T) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removed;
    }

    private void grow() {
        int newCap = data.length * 2;
        Object[] temp = new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private void check(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        DynamicArray <String> a = new DynamicArray <>();
        a.add("Abdallah");
        a.add("Kareem");
        a.addpos(1, "Taha");
        a.remove(1);
        a.add("Mark");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
}
