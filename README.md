Java Data‑Structure Implementations: 
-------------------------------------------
The reposority contains 14 main data structures written in Java: 
1. Dynamic Array
2. SinglyLinkedList
3. ArrayStack
4. LinkedStack
5. ArrayQueue
6. LinkedQueue
7. DoublyLinkedList
8. CircularLinkedList
9.  BinaryTree
10. BinarySearchTree
11. TreeTraversals
12. MinHeap
13. Graph
14. HashTable

each section will contain the implemenation, Time Complexity, Usage and the run.
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
### HashTable Implementation
Key → value map using an array of buckets. Each bucket holds a linked list, so that collisions are resolved by chaining entries.

*Complexity: 
- put/get/remove ---> in average it's O(1), in the worst cases O(n)

*Space: O(n), number of entries.

*Usage:
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

*Run: 
- javac HashTable.java
- java HashTable
----------------------------------------------------------------------------------------------------------------
### MinHeap Implementation
Binary heap stored in an array, the most operation used and the power of the minheap is peek returns the smallest element.

*Complexity: 
- add(push) ---> O(log n)
- poll (pop) ---> O(log n)
- peek ---> O(1)

-Storage: O(n), the backing array.

*Usage: 
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

*Run: 
- javac MinHeap.java
- java MinHeap
----------------------------------------------------------------------------------------------------------------
### Basic Graph Implementation
Adjacency‑list graph using Map<V List<V>>. Supports directed or undirected edges plus BFS and DFS traversals.

*Complexity:
- addVertex ---> O(1)
- addEdge ---> O(1)
- neighbors ---> O(k), where k is the dgree 
- BFS and DFS ---> O(V+E)

-Storage ---> O(V+E)

*Usage:
public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B", true);
        g.addEdge("A", "C", true);
        g.addEdge("B", "D", true);
        g.addEdge("C", "D", true);
        g.addEdge("D", "E", true);
        System.out.println("Neighbors of A: " + g.neighbors("A"));
        System.out.println("BFS from A     : " + g.bfs("A"));
        System.out.println("DFS from A     : " + g.dfs("A"));
    }

*Run: 
- javac Graph.java
- java Graph
----------------------------------------------------------------------------------------------------------------
### BasicTrie Implementation
Prefix tree storing lowercase a–z words; supports insert, exact lookup contains, and prefix check startsWith.

*Complexity:
- insert ---> O(L)
- contains ---> O(L)
- startsWith ---> O(P)
- Storage ---> O(total chars)
 
 *Usage:
 public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("app");
        t.insert("apt");
        t.insert("bat");

        System.out.println(t.contains("app"));     // true
        System.out.println(t.contains("ap"));      // false
        System.out.println(t.startsWith("ap"));    // true
        System.out.println(t.startsWith("ba"));    // true
        System.out.println(t.startsWith("cat"));   // false
    }

 *Run: 
 - javac Trie.java
 - java Trie
 ---------------------------------------------------------------------------------------------------------------
 ### Union‑Find (Disjoint Set) Implementation
Efficient data structure for keeping track of disjoint groups; operations union (merge) and find (set id) use path compression and union‑by‑rank.

*Complexity: 
- union ---> O(α(n))
- find ---> O(α(n))
- Storage ---> O(n), (parent,rank) 

*Usage:
public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        System.out.println(uf.find(2) == uf.find(0)); //true
        System.out.println(uf.find(2) == uf.find(3)); //false 
        System.out.println("sets = " + uf.setCount()); //8

        UnionFind ufObj = new UnionFind(new Object[]{"A","B","C","D"});
        ufObj.union("A", "B");
        System.out.println(ufObj.connected("A", "C")); //false 
        ufObj.union("B", "C");
        System.out.println(ufObj.connected("A", "C")); //true 
    }

*Run:
- javac UnionFind.java
- java UnionFind
---------------------------------------------------------------------------------------------------------------
### Graph Traversal Implementation
tatic generic methods for BFS and DFS over any Map<V, List<V>> adjacency list. Returns visit order.

*Complexity: 
- BFS and DFS ---> O(|V| + |E|)
-Storage: frontier + seen

*Usage: 
public static void main(String[] args) {
        Map<String, List<String>> g = new HashMap<>();
        g.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        g.put("B", new ArrayList<>(Arrays.asList("D")));
        g.put("C", new ArrayList<>(Arrays.asList("D")));
        g.put("D", new ArrayList<>(Arrays.asList("E")));
        g.put("E", new ArrayList<>());

        System.out.println("BFS from A: " + bfs(g, "A")); // [A, B, C, D, E]
        System.out.println("DFS from A: " + dfs(g, "A")); // e.g. [A, B, D, E, C]
    }

*Run: 
- javac GraphTraversal.java
- java GraphTraversal
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
- java MinHeap
- java Graph
- java HashTable
- java UnionFind
- java GraphTraversal
- java Trie
----------------------------------------------------------------------------------------------------------------
