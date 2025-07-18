package BinarySearchTree;

public class BinarySearchTree {

    private static class Node { // node with value and 2 children
        Comparable value;
        Node left;
        Node right;
        Node(Comparable v) { value = v; }
    }

    private Node root; // root of the tree
    private int  size; // number of nodes

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void add(Comparable val) { // insert 
        if (root == null) { // first node creates the treee
            root = new Node(val);
            size++;
            return;
        }
        Node cur = root;
        while (true) {
            if (val.compareTo(cur.value) < 0) { //go left 
                if (cur.left == null) { // found a spot 
                    cur.left = new Node(val);
                    break;
                }
                cur = cur.left;
            } else { // go right
                if (cur.right == null) { // found a spot at right because we are searching right
                    cur.right = new Node(val);
                    break;
                }
                cur = cur.right;
            }
        }
        size++;
    }

    public boolean contains(Comparable val) { // the search method 
        Node cur = root;
        while (cur != null) {
            int cmp = val.compareTo(cur.value);
            if (cmp == 0) { // match
                return true;
            }
            if (cmp < 0) { // smaller, go left
                cur = cur.left;
            } else { // bigger, go right
                cur = cur.right;
            }
        }
        return false;
    }

    public Comparable min() { // min value (always leftmost)
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node cur = root;
        while (cur.left != null) { //keep stepping left 
            cur = cur.left;
        }
        return cur.value;
    }

    public Comparable max() { //max value (always rightmost)
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.value;
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.add(50); 
        t.add(30);
        t.add(70);
        t.add(20);
        t.add(40);
        t.add(60); 
        t.add(80);
        System.out.println("size=" + t.size());
        System.out.println("min=" + t.min());
        System.out.println("max=" + t.max());
        System.out.println("contains 60? " + t.contains(60));
        System.out.println("contains 25? " + t.contains(25));
    }
}
