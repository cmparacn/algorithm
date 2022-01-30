package com.cm.graph.digraph;

import java.util.*;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月30日 10:21:00
 */
public class InDegreeTopological implements Topological {

    /**
     * 有无环
     */
    private final boolean isDag;

    /**
     * 拓扑序列
     */
    private List<Integer> order;

    /**
     * 各个 v 的入度
     */
    private Map<Integer, Integer> inDegree;

    /**
     * 还未处理的点
     */
    private Set<Integer> vSet;

    public InDegreeTopological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        this.isDag = !directedCycle.hasCycle();
        if (isDag) {
            this.inDegree = new HashMap<>();
            this.vSet = new HashSet<>();
            this.order = new ArrayList<>();
            getTopological(digraph);
        }
    }

    /**
     * 入度法构建
     *
     * @param digraph 有向图
     */
    private void getTopological(Digraph digraph) {
        int vertexes = digraph.getVertexes();
        // 计算各个 v 的入度
        for (int i = 0; i < vertexes; i++) {
            vSet.add(i);
            for (Integer next : digraph.adj(i)) {
                inDegree.put(next, inDegree.getOrDefault(next, 0) + 1);
            }
        }
        // 遍历未进入拓扑序列的点, 找到 入度 为 0 的点, 加入序列, 删除关联边
        while (!vSet.isEmpty()) {
            Iterator<Integer> vSetIterator = vSet.iterator();
            while (vSetIterator.hasNext()) {
                Integer cur = vSetIterator.next();
                if (inDegree.getOrDefault(cur, 0) == 0) {
                    vSetIterator.remove();
                    order.add(cur);
                    for (Integer next : digraph.adj(cur)) {
                        inDegree.compute(next, (k, v) -> v == null ? 0 : v - 1);
                    }
                }
            }
        }
    }

    /**
     * 是否是有向无环图
     */
    @Override
    public boolean isDAG() {
        return isDag;
    }

    /**
     * dfs 获取的 order
     */
    @Override
    public Iterable<Integer> order() {
        return order;
    }
}
