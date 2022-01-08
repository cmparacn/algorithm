package com.cm.graph.digraph;

import java.util.*;

/**
 * @author CM cmpara@foxmail.com
 * @Description 拓扑排序
 * @createTime 2022年01月05日 21:10:00
 */
public class Topological {

    private final boolean isDag;
    private Iterable<Integer> order;

    /**
     * dfs 构建拓扑排序
     */
    public Topological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        isDag = !directedCycle.hasCycle();
        if (isDag) {
            DfsOrder dfsOrder = new DfsOrder(digraph);
            order = dfsOrder.getReversePost();
        }
    }

    /**
     * 入度法 拓扑排序
     */
    public static List<Integer> getTopological(Digraph digraph) {
        List<Integer> topologicalOrder = new ArrayList<>(digraph.getVertexes());
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (!directedCycle.hasCycle()) {
            return Collections.emptyList();
        }
        int vertexes = digraph.getVertexes();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> vSet = new HashSet<>();
        // 计算各个 v 的入度
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
        return order;
    }

}
