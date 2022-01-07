package com.cm.graph;

import java.util.*;

/**
 * @author CM cmpara@foxmail.com
 * @Description 拓扑排序
 * @createTime 2022年01月05日 21:10:00
 */
public class Topological {

    private boolean isDag;
    private final boolean[] visited;
    private final List<Integer> reversePostOrder;

    /**
     * dfs 构建拓扑排序
     */
    public Topological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        isDag = !directedCycle.hasCycle();
        int vertexes = digraph.getVertexes();
        visited = new boolean[vertexes];
        reversePostOrder = new Stack<>();
        for (int i = 0; i < vertexes; i++) {
            if (!visited[i]) {
                dfs(digraph, i);
            }
        }
        Collections.reverse(reversePostOrder);
    }

    /**
     * 入度法 拓扑排序
     */
    public List<Integer> getTopological(Digraph digraph) {
        List<Integer> topologicalOrder;topologicalOrder = new ArrayList<>(digraph.getVertexes());
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        isDag = !directedCycle.hasCycle();
        if (!isDAG()) {
            return Collections.emptyList();
        }
        int vertexes = digraph.getVertexes();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> vSet = new HashSet<>();
        for (int i = 0; i < vertexes; i++) {
            vSet.add(i);
            for (Integer next : digraph.adj(i)) {
                inDegree.put(next, inDegree.getOrDefault(next, 0) + 1);
            }
        }
        while (!vSet.isEmpty()) {
            Iterator<Integer> vSetIterator = vSet.iterator();
            while (vSetIterator.hasNext()) {
                Integer cur = vSetIterator.next();
                if (inDegree.getOrDefault(cur, 0) == 0) {
                    vSetIterator.remove();
                    topologicalOrder.add(cur);
                    for (Integer next : digraph.adj(cur)) {
                        inDegree.compute(next, (k, v) -> v == null ? 0 : v - 1);
                    }
                }
            }
        }
        return topologicalOrder;
    }

    private void dfs(Digraph digraph, int cur) {
        visited[cur] = true;
        for (Integer next : digraph.adj(cur)) {
            if (!visited[next]) {
                dfs(digraph, next);
            }
        }
        reversePostOrder.add(cur);
    }

    /**
     * 是否是有向无环图
     */
    public boolean isDAG() {
        return isDag;
    }

    /**
     * dfs 获取的 order
     */
    public Iterable<Integer> order() {
        return reversePostOrder;
    }

}
