package com.cm.graph.mst;

/**
 * @author CM cmpara@foxmail.com
 * @Description 边
 * @createTime 2022年01月09日 18:26:00
 */
public class Edge implements Comparable<Edge>{
    private final int start;
    private final int end;
    private final double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**
     *
     * @return 两个端点的任意一个
     */
    public int either() {
        return start;
    }

    /**
     *
     * @param v 端点
     * @return 返回另一条端点
     */
    public int other(int v) {
        return start == v ? end : start;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        if (other.getWeight() == this.weight) {
            return 0;
        }
        return this.weight < other.getWeight() ? -1 : 1;
    }
}
