package TreeTraversals;

public class TreeTraversals {

    private static class Node {  //simple node for the tree
        Object value;
        Node left;
        Node right;
        Node(Object v) { value = v; }
    }


    // root --> left --> right
    public static void preorder(Node n) {
        if (n == null) { return; } //empty branch 
        System.out.print(n.value + " "); //root
        preorder(n.left); //left subtree
        preorder(n.right); // right subtree
    }

    // left -->  root --> right
    public static void inorder(Node n) {
        if (n == null) { return; }
        inorder(n.left); // all smaller emlements first
        System.out.print(n.value + " "); //root
        inorder(n.right); //larger elements
    }

    // left --> right --> root
    public static void postorder(Node n) {
        if (n == null) { return; }
        postorder(n.left); //process subtree
        postorder(n.right);
        System.out.print(n.value + " "); //root after children
    }

    private static Node sampleTree() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        a.left  = b;
        a.right = c;
        b.left  = d;
        b.right = e;   
        return a;      
    }

    public static void main(String[] args) {

        Node root = sampleTree();

        System.out.print("Preorder  : ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder   : ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        postorder(root);
        System.out.println();
    }
}
