package BinaryTree;

public class BinaryTree {

    private static class Node { //basic node    
        Object value;
        Node left;
        Node right;

        Node(Object v) {
            value = v;
        }
    }

    private static class NodeQueue { //simple queue (acts as a helper method for the tree)
        private static class QNode {
            Node treeNode;
            QNode next;
            QNode(Node t) { treeNode = t; }
        }
        private QNode front; // first node
        private QNode rear; // last node 

        void enqueue(Node t) { //add at tail
            QNode qn = new QNode(t);
            if (rear == null) {
                front = rear = qn;
            } else {
                rear.next = qn;
                rear = qn;
            }
        }

        Node dequeue() { // remove from head 
            Node t = front.treeNode;
            front = front.next;
            if (front == null) rear = null; //queue is empty 
            return t;
        }

        boolean isEmpty() {
            return front == null;
        }
    }

    private Node root; // tree root
    private int  size; // number of nodes 

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    public void add(Object val) {
        Node n = new Node(val);

        if (root == null) { // first node is assigned to root 
            root = n;
            size++;
            return;
        }

        NodeQueue q = new NodeQueue();
        q.enqueue(root);

        while (!q.isEmpty()) {
            Node cur = q.dequeue();

            if (cur.left == null) { // found free slot at left child 
                cur.left = n;
                break;
            }

            if (cur.right == null) { // found free slot at right child 
                cur.right = n;
                break;
            }

            q.enqueue(cur.left); // keep searching down the tree 
            q.enqueue(cur.right);
        }

        size++;
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        t.add("E");

        System.out.println("Tree size = " + t.size());  // 5 
        System.out.println("Is empty? " + t.isEmpty()); // false
        System.out.println("test2? " + t.isEmpty()); // false
    }
}
