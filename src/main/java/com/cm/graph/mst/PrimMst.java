package com.cm.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * prim 算法 -> mst
 * <p> 不保存无效边, pq 只存储当前树外节点与树内最小的连接边 </p>
 * 时间复杂度: O(E * log(V))
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月13日 21:15:00
 */
public class PrimMst {

    /**
     * 树外节点和树内的最短边, 当在树内时, null
     */
    private final Edge[] edgeTo;
    private final double[] distTo;
    private final List<Edge> mst;
    private final PriorityQueue<Edge> minPQ;

    /**
     * 代表是否已在树中
     */
    private final boolean[] marked;

    public PrimMst(WeightedGraph graph) {
        int vertexes = graph.getVertexes();
        minPQ = new PriorityQueue<>();
        edgeTo = new Edge[vertexes];
        distTo = new double[vertexes];
        mst = new ArrayList<>();
        marked = new boolean[vertexes];
        for (int i = 0; i < vertexes; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        visit(graph, 0);
        while (!minPQ.isEmpty()) {
            Edge edge = minPQ.poll();
            int either = edge.either();
            int other = edge.other(either);
            mst.add(edge);
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
        for (Edge edge : graph.adj(cur)) {
            int other = edge.other(cur);
            if (!marked[other] && edge.getWeight() < distTo[other]) {
                distTo[other] = edge.getWeight();
                // 当前节点已在 minQueue 中右边, 将其进行更新 (remove & add)
                if (edgeTo[other] != null) {
                    minPQ.remove(edgeTo[other]);
                }
                edgeTo[other] = edge;
                minPQ.offer(edge);
            }
        }
        marked[cur] = true;
    }

    public List<Edge> getMst() {
        return mst;
    }
}
