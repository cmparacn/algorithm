package com.cm.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * prim 算法 -> mst
 * <p> 失效边延时删除, 在 pq 出队时再判断 </p>
 * 时间复杂度: O(E * log(E))
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月13日 21:15:00
 */
public class LazyPrimMst {
    private final boolean[] marked;
    private final List<Edge> mst;
    private final PriorityQueue<Edge> minPQ;

    public LazyPrimMst(WeightedGraph graph) {
        int vertexes = graph.getVertexes();
        marked = new boolean[vertexes];
        minPQ = new PriorityQueue<>();
        mst = new ArrayList<>();
        visit(graph, 0);
        while (!minPQ.isEmpty()) {
            Edge minEdge = minPQ.poll();
            int either = minEdge.either();
            int other = minEdge.other(either);
            // 略过失效边
            if (marked[either] && marked[other]) {
                continue;
            }
            mst.add(minEdge);
            visit(graph, either);
            visit(graph, other);
        }
    }

    /**
     * @param graph 无向加权图
     * @param cur   当前节点
     */
    public void visit(WeightedGraph graph, int cur) {
        if (marked[cur]) {
            return;
        }
        marked[cur] = true;
        for (Edge edge : graph.adj(cur)) {
            if (!marked[edge.other(cur)]) {
                minPQ.offer(edge);
            }
        }
    }

    public List<Edge> getMst() {
        return mst;
    }

}
