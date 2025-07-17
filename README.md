

Java Data‑Structure Implementations: 
-------------------------------------------
The reposority contains 4 main data structures written in Java: 
1. Dynamic Array
2. SinglyLinkedList
3. ArrayStack
4. LinkedStack

each section will contain the implemenation and the run(Test).
----------------------------------------------------------------------------------------------------------------
### Dynamic Array Implementation
the dynamic array is resizble array that can extened and shrink, meaning in can automatically grow when adding above the capacity, also it offers constant time access like a normal java array. 

*Complexity:

get/set -----> time: O(1), no extra space
add -----> time : O(1), no extra space
addpos/ remove ----> time: O(n), because of element shifting, no extra space 
grow ----> O(n), becuase of copying the old capacity to the new capacity, the space is new capacity – old capacity.

total storage: O(n)

*Usage example:
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

*Run: 

javac DynamicArray.java
java  DynamicArray
----------------------------------------------------------------------------------------------------------------
### SinglyLinkedList Implementation
Data structure that contain nodes, where each of these nodes holds a value and a reference to the next node, gives the ability to fast insert/remove at the head and sequential access anywhere.

*Complexity:

add to tail ----> O(n), becuase we need to walk to the tail. the extra is space is the node. 
insert/remove at head ----> O(1), the extra space is the node also. 
get/set ----> O(n), there is no extra space.

total storage: O(n), which is the nodes.

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
javac SinglyLinkedList.java
java  SinglyLinkedList
----------------------------------------------------------------------------------------------------------------
### ArrayStack Implementation
a last in first out stack by a dynamically growing array simple as that.

*Complexity:

push ----> O(1)
pop/peek -----> O(1)

total storage: O(n)

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
javac ArrayStack.java
java  ArrayStack
----------------------------------------------------------------------------------------------------------------
### LinkedStack Implementation
a last in first out using a single linkedlist, each push creates a new node at the head.

*Complexity:

push/pop/peak ----> O(1)

total storage: O(n), which are the nodes.

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
javac LinkedStack.java
java  LinkedStack
----------------------------------------------------------------------------------------------------------------
