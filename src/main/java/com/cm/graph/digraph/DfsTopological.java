package com.cm.graph.digraph;

/**
 * DFS 构建拓扑排序 -> dfs 的逆后序排序即为拓扑排序
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月30日 10:18:00
 */
public class DfsTopological implements Topological{
    /**
     * 是否有环
     */
    private final boolean isDag;
    private Iterable<Integer> order;

    /**
     * dfs 构建拓扑排序
     */
    public DfsTopological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        isDag = !directedCycle.hasCycle();
        if (isDag) {
            DfsOrder dfsOrder = new DfsOrder(digraph);
            order = dfsOrder.getReversePost();
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
