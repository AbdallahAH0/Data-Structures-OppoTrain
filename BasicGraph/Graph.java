package BasicGraph;

import java.util.*;

public class Graph {

    private Map<Object, List<Object>> adj; // map each vertex to it's adjacent list

    public Graph() {
        adj = new HashMap<>();
    }

    public void addVertex(Object v) { //creates empty list if vertex is absent 
        adj.computeIfAbsent(v, k -> new ArrayList<>());
    }

    public void addEdge(Object u, Object v) { //direct edge from U to V
        addVertex(u);
        addVertex(v);
        adj.get(u).add(v);
    }

    public void addEdge(Object u, Object v, boolean undirected) { // if undirected flag true, add V to U also
        addEdge(u, v);
        if (undirected) addEdge(v, u);
    }

    public List<Object> neighbors(Object v) {
        return adj.getOrDefault(v, Collections.emptyList());
    }

    public List<Object> bfs(Object src) { //bfs, returns visit order 
        List<Object> order = new ArrayList<>();
        if (!adj.containsKey(src)) return order;
        Set<Object> seen = new HashSet<>();
        Queue<Object> q = new ArrayDeque<>();
        seen.add(src);
        q.add(src);
        while (!q.isEmpty()) {
            Object cur = q.remove();
            order.add(cur);
            for (Object nxt : adj.get(cur)) {
                if (seen.add(nxt)) q.add(nxt); //unqueue unseen neighbors
            }
        }
        return order;
    }

    public List<Object> dfs(Object src) { //dfs, returns visit order 
        List<Object> order = new ArrayList<>();
        if (!adj.containsKey(src)) return order;
        Set<Object> seen = new HashSet<>();
        Deque<Object> st = new ArrayDeque<>();
        st.push(src);
        while (!st.isEmpty()) {
            Object cur = st.pop();
            if (!seen.add(cur)) continue; //skip if already visited 
            order.add(cur);
            List<Object> nbs = adj.get(cur);
            for (int i = nbs.size() - 1; i >= 0; i--) //push in reverse 
            st.push(nbs.get(i));
        }
        return order;
    }

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
}
