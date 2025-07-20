package Trie;

public class Trie { //trie is a prefix tree that stores lowercase a-z words

    private static class Node {
        Node[] child = new Node[26]; 
        boolean word;                  
    }

    private final Node root = new Node();


    public void insert(String s) { //insert a lowercase word
        Node cur = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a'; //maps 'a'..'z' ---> 0..25
            if (cur.child[idx] == null) 
            cur.child[idx] = new Node(); //create missing link
            cur = cur.child[idx];
        }
        cur.word = true; //mark end of word
    }

    public boolean contains(String s) {
        Node n = walk(s); //walk returns null if path breaks 
        return n != null && n.word;
    }

    
    public boolean startsWith(String prefix) { //does any word start with this prefix?
        return walk(prefix) != null;
    }

    private Node walk(String s) { //walk down the tree following the string; null if dead end
        Node cur = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx >= 26) return null;     // reject non-letter 
            cur = cur.child[idx];
            if (cur == null) return null;
        }
        return cur;
    }

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
}
