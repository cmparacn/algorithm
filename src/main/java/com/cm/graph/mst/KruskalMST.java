package com.cm.graph.mst;

import com.cm.base.UnionFind;
import com.cm.base.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 基于边的 mst
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月24日 21:04:00
 */
public class KruskalMST {

    private final List<Edge> mst;

    public KruskalMST(WeightedGraph graph) {
        int vertexes = graph.getVertexes();
        this.mst = new ArrayList<>(vertexes - 1);
        UnionFind unionFind = new WeightedQuickUnionUF(vertexes);
        // 获取权值最小的边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(graph.edges());
        while (!priorityQueue.isEmpty()) {
            Edge curEdge = priorityQueue.poll();
            int either = curEdge.either();
            int other = curEdge.other(either);
            // 当前边是横切边
            if (!unionFind.connected(either, other)) {
                mst.add(curEdge);
                unionFind.union(either, other);
            }
        }
    }

    public List<Edge> getMst() {
        return mst;
    }
}
