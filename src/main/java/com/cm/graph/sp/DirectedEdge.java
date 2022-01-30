package com.cm.graph.sp;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月24日 21:52:00
 */
public class DirectedEdge {
    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }
}
