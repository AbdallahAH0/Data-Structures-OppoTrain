package HashTable;

public class HashTable {

   
    private static class Entry { // the key and it's value
        Object key;
        Object value;
        Entry next;
        Entry(Object k, Object v, Entry n) { key = k; value = v; next = n; }
    }

    private Entry[] table;      // array of buckets
    private int      size;      // number of stored pairs
    private int      capacity;  // current bucket count

    private static final double LOAD_FACTOR = 0.75;

    public HashTable() {
        capacity = 4;
        table    = new Entry[capacity];
        size     = 0;
    }

    public void put(Object key, Object value) { // the update 

        int idx = index(key);

        Entry cur = table[idx];

        while (cur != null) {            // update existing key
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        table[idx] = new Entry(key, value, table[idx]); // insert at head
        size++;

        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }
    }


    public Object get(Object key) { // the get method

        int idx = index(key);

        Entry cur = table[idx];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }

        return null;
    }

    public Object remove(Object key) { // the remove object method

        int idx = index(key);

        Entry cur = table[idx];
        Entry prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {

                if (prev == null) {
                    table[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }

                size--;
                return cur.value;
            }

            prev = cur;
            cur  = cur.next;
        }

        return null;
    }

    private int index(Object key) { // helper method to turn any key into the bucket slot where it should be.
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void resize() {

        int oldCap = capacity;
        capacity   = capacity * 2;

        Entry[] oldTable = table;
        table            = new Entry[capacity];

        for (int i = 0; i < oldCap; i++) {

            Entry cur = oldTable[i];

            while (cur != null) {

                Entry next = cur.next; // save link
                int idx   = index(cur.key); // recompute bucket

                cur.next  = table[idx];
                table[idx] = cur;

                cur = next;
            }
        }
    }

    public static void main(String[] args) { //Testing

        HashTable ht = new HashTable();

        ht.put("A", 1);
        ht.put("B", 2);
        ht.put("C", 3);

        System.out.println(ht.get("B"));  // 2

        ht.put("B", 22);                  // update
        System.out.println(ht.get("B"));  // 22

        ht.remove("A");
        System.out.println(ht.get("A"));  // null

        for (int i = 0; i < 10; i++) {
            ht.put("key" + i, i);
        }

        System.out.println("size=" + ht.size);  // 12
    }
}
