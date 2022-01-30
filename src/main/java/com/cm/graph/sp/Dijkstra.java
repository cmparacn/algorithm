package com.cm.graph.sp;

import java.util.*;

/**
 * 适用于权重非负的加权有向图单起点的 sp 问题
 * O(E * log(v))
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月29日 09:56:00
 */
public class Dijkstra extends SP {

    /**
     * 当前各点跟起始点的距离
     */
    private final double[] distTo;

    /**
     * 当前各点跟起始点的最短路径中与当前点最近的边 (最后一条边)
     */
    private final DirectedEdge[] edgeTo;

    /**
     * 当前距离 起始点 最短的点
     */
    private final PriorityQueue<Integer> priorityQueue;

    /**
     * @param s       起始点
     * @param digraph 有向图
     */
    public Dijkstra(int s, EdgeWeightedDigraph digraph) {
        super(s);
        int vertexes = digraph.getVertexes();
        this.distTo = new double[vertexes];
        this.edgeTo = new DirectedEdge[vertexes];
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(this::distTo));
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        // 起点赋值
        distTo[s] = 0;
        // 起点加入 pq
        priorityQueue.add(s);
        while (!priorityQueue.isEmpty()) {
            relax(priorityQueue.poll(), digraph);
        }
    }

    /**
     * 松弛当前点
     *
     * @param v       当前点
     * @param digraph 有向图
     */
    private void relax(int v, EdgeWeightedDigraph digraph) {
        // 松弛当前点的所有边
        for (DirectedEdge edge : digraph.adj(v)) {
            int next = edge.getTo();
            if (distTo[v] + edge.getWeight() < distTo[next]) {
                distTo[next] = distTo[v] + edge.getWeight();
                edgeTo[next] = edge;
                // 更新权值, update 操作
                if (priorityQueue.contains(next)) {
                    priorityQueue.remove(next);
                    priorityQueue.add(next);
                    // add 操作
                } else {
                    priorityQueue.add(next);
                }
            }
        }
    }

    /**
     * v 到顶点的最短距离
     *
     * @param v 图中某点
     * @return 最短距离
     */
    @Override
    protected double distTo(int v) {
        return distTo[v];
    }

    /**
     * 是否存在顶点到 v 的路径
     *
     * @param v 图中某点
     * @return 是否存在路径
     */
    @Override
    public boolean hashPathTo(int v) {
        return distTo(v) < Double.POSITIVE_INFINITY;
    }

    /**
     * v 到顶点的最短路径
     *
     * @param v 图中某点
     * @return 最短路径, 不存在时为 空 list
     */
    @Override
    protected List<DirectedEdge> pathTo(int v) {
        if (!hashPathTo(v)) {
            return Collections.emptyList();
        }
        List<DirectedEdge> path = new ArrayList<>();
        DirectedEdge edge = edgeTo[v];
        path.add(edge);
        while (edge.getFrom() != s) {
            edge = edgeTo[edge.getFrom()];
            path.add(edge);
        }
        return path;
    }
}
