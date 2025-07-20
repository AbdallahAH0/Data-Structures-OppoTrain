package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private int[] parent;
    private int[] rank;
    private int   count;

    private Map<Object,Integer> id = new HashMap<>();

    public UnionFind(int n) {
        parent = new int[n];
        rank   = new int[n];
        count  = n;
        for (int i = 0; i < n; i++) parent[i] = i; //start with n singleton sets 
    }

    public UnionFind(Object[] elements) { //aceept an array of objects and map them to indices 0..k-1
        this(elements.length);
        for (int i = 0; i < elements.length; i++) id.put(elements[i], i);
    }

    public int find(int x) { //finds root of set containing x, compresses path on the fly 
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) { //merge sets that contain x and y
        int rx = find(x), ry = find(y);
        if (rx == ry) return; //already connected 
        if (rank[rx] < rank[ry])
         parent[rx] = ry; //attach shallower tree
        else if (rank[rx] > rank[ry])
         parent[ry] = rx;
        else { //same rank --> pick one root
            parent[ry] = rx;
             rank[rx]++; }
        count--; //one less disjoint set
    }

    private int idx(Object o) { 
        return id.get(o); //assumes key exists
     }

    public void union(Object a, Object b) { union(idx(a), idx(b)); }
    public boolean connected(Object a, Object b) { return find(idx(a)) == find(idx(b)); }
    public int setCount() { return count; }

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
}
