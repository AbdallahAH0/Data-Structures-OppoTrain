package GraphTraversal;

import java.util.*;


public class GraphTraversal {

    public static <V> List<V> bfs(Map<V, List<V>> g, V src) {
        List<V> order = new ArrayList<>();
        if (!g.containsKey(src)) return order;

        Set<V>    seen = new HashSet<>();
        Queue<V>  q    = new ArrayDeque<>();

        seen.add(src);
        q.add(src);

        while (!q.isEmpty()) {
            V cur = q.remove();
            order.add(cur);
            for (V nxt : g.get(cur)) {
                if (seen.add(nxt)) q.add(nxt);
            }
        }
        return order;
    }

    public static <V> List<V> dfs(Map<V, List<V>> g, V src) {
        List<V> order = new ArrayList<>();
        if (!g.containsKey(src)) return order;

        Set<V>   seen = new HashSet<>();
        Deque<V> st   = new ArrayDeque<>();

        st.push(src);

        while (!st.isEmpty()) {
            V cur = st.pop();
            if (!seen.add(cur)) continue;
            order.add(cur);
            List<V> nbs = g.get(cur);
            for (int i = nbs.size() - 1; i >= 0; i--) st.push(nbs.get(i));
        }
        return order;
    }

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
}
