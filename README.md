Java Data‑Structure Implementations: 
-------------------------------------------
The reposority contains 11 main data structures written in Java: 
1. Dynamic Array
2. SinglyLinkedList
3. ArrayStack
4. LinkedStack
5. ArrayQueue
6. LinkedQueue
7. DoublyLinkedList
8. CircularLinkedList
9. java BinaryTree
10. java BinarySearchTree
11. java TreeTraversals

each section will contain the implemenation and the run(Test).
----------------------------------------------------------------------------------------------------------------
### Dynamic Array Implementation
the dynamic array is resizble array that can extened and shrink, meaning in can automatically grow when adding above the capacity, also it offers constant time access like a normal java array. 

*Complexity:

- get/set -----> time: O(1), no extra space
- add -----> time : O(1), no extra space
- addpos/ remove ----> time: O(n), because of element shifting, no extra space 
- grow ----> O(n), becuase of copying the old capacity to the new capacity, the space is new capacity – old capacity.

- total storage: O(n)

*Usage example:
 - DynamicArray <String> a = new DynamicArray <>();
        a.add("Abdallah");
        a.add("Kareem");
        a.addpos(1, "Taha");
        a.remove(1);
        a.add("Mark");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();

*Run: 

- javac DynamicArray.java
- java  DynamicArray
----------------------------------------------------------------------------------------------------------------
### SinglyLinkedList Implementation
Data structure that contain nodes, where each of these nodes holds a value and a reference to the next node, gives the ability to fast insert/remove at the head and sequential access anywhere.

*Complexity:

- add to tail ----> O(n), becuase we need to walk to the tail. the extra is space is the node. 
- insert/remove at head ----> O(1), the extra space is the node also. 
- get/set ----> O(n), there is no extra space.

- total storage: O(n), which is the nodes.

*Usage:
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

*Run: 
- javac SinglyLinkedList.java
- java  SinglyLinkedList
----------------------------------------------------------------------------------------------------------------
### ArrayStack Implementation
a last in first out stack by a dynamically growing array simple as that.

*Complexity:

- push ----> O(1)
- pop/peek -----> O(1)

- total storage: O(n)

*Usage:
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

*Run:
- javac ArrayStack.java
- java  ArrayStack
----------------------------------------------------------------------------------------------------------------
### LinkedStack Implementation
a last in first out using a single linkedlist, each push creates a new node at the head.

*Complexity:

- push/pop/peak ----> O(1)

- total storage: O(n), which are the nodes.

*Usage: 
public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());  // 3
        System.out.println(s.pop());   // 3
        s.push(4);
        while (!s.isEmpty()) System.out.print(s.pop() + " "); // 4 2 1
        System.out.println();
    }

*Run:
- javac LinkedStack.java
- java  LinkedStack
----------------------------------------------------------------------------------------------------------------
### ArrayQueue Implementation
First in first out data structure that stores it's element in an array as simple as that. front points to the element to dequeue next, rear points to the next free slot.

*Complexity:
- enqueue ----> time: O(1), no extra space
- dequeue/peek ----> time: O(1), no extra space 
- grow ----> O(n), copies. the space is new capacity – old capacity

- full storage : O(n)

*Usage: 
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

*Run:
- javac ArrayQueue.java
- java  ArrayQueue
----------------------------------------------------------------------------------------------------------------
### LinkedQueue Implementation
First in first out queue using singnly linkedlist wiht head and tail nodes. Enqueue appends at tail; dequeue removes from head.

*Complexity: 
- enqueue / dequeue / peek -----> time: O(1).
- Storage is O(n), which is the nodes.

*Usage:
public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());   // 1
        System.out.println(q.dequeue()); // 1
        q.enqueue(4);
        while (!q.isEmpty()) System.out.print(q.dequeue() + " "); // 2 3 4
        System.out.println();
    }

*Run:
- javac LinkedQueue.java
- java  LinkedQueue
----------------------------------------------------------------------------------------------------------------
### DoublyLinkedList Implementation
it a list with 2 ends where each node holds links to both the previous and next node. allowing insertions and deletions at either ends.

*Complexity: 
- add/remove head or tail ----> time: O(1)
- insert/remove at index -----> time: O(n)
- get/set ----> time: O(n)

-Storage: O(n) which is the nodes.

*Usage:
public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add("A"); dl.add("B"); dl.add("C");
        dl.insert(1, "X");                 // A X B C
        dl.set(2, "Y");                    // A X Y C
        dl.remove(0);                      // X Y C
        for (int i = 0; i < dl.size(); i++) System.out.print(dl.get(i) + " ");
        System.out.println();
    }

*Run: 
- javac DoublyLinkedList.java
- java  DoublyLinkedList
----------------------------------------------------------------------------------------------------------------
### CircularLinkedList Implementation
Singly linked list whose tail points back to the head, like a ring. maintains only a tail pointer.

*Complexity:
- add(enqueue) -----> time: O(1)
- remove(dequeue) -----> time: O(1)
- rotate ----> time: O(1)

-Storage: O(n), which is the nodes.

*Usage: 
public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.add(1); cl.add(2); cl.add(3);
        System.out.println(cl.front());   // 1
        cl.rotate();                      // head becomes 2
        System.out.println(cl.front());   // 2
        System.out.println(cl.remove());  // 2
        cl.rotate();
        while (!cl.isEmpty()) System.out.print(cl.remove() + " "); // 3 1
        System.out.println();
    }

*Run: 
- javac CircularLinkedList.java
- java  CircularLinkedList
----------------------------------------------------------------------------------------------------------------
### BinaryTree Implementation
Simple binary tree that fills level‑by‑level (like a heap). it inserts in breadth‑first order to keep the tree complete.

*Complexity: 
- add ---> O(n), in worst case (because must scan)
- Storage ---> O(n), which is the nodes. 

*Usage: 
public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        t.add("E");

        System.out.println("Tree size = " + t.size());  // 5 
        System.out.println("Is empty? " + t.isEmpty()); // false
    }

*Run:
- javac BinaryTree.java
- java BinaryTree
----------------------------------------------------------------------------------------------------------------
### BinarySearchTree Implementation
Ordered binary search tree (BST) with iterative add, contains, min, and max operations.

*Complexity:
- add ---> average case can cost O(log n), while the worst case can cost O(n)
- contains ---> average case can cost O(log n), while the worst case can cost O(n)
- min/max ---> average case can cost O(log n), while the worst case can cost O(n)
- Storage: O(n), which is the nodes.

*Usage:
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

*Run:
- javac BinarySearchTree.java
- java BinarySearchTree
----------------------------------------------------------------------------------------------------------------
### Tree Traversals Implementation
static methods for preorder, inorder, and postorder depth‑first traversals over any binary tree node.

*Complexity:
- preorder ---> O(n), space is according to recursion stack
- inorder ---> O(n), space is according to recursion stack
- postorder ---> O(n),  space is according to recursion stack

*Usage: 
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

*Run:
- javac BinarySearchTree.java
- java BinarySearchTree
----------------------------------------------------------------------------------------------------------------
*Run all demos: 
- javac *.java
- java DynamicArray
- java SinglyLinkedList
- java ArrayStack
- java LinkedStack
- java ArrayQueue
- java LinkedQueue
- java BinaryTree
- java BinarySearchTree
- java TreeTraversals
----------------------------------------------------------------------------------------------------------------
