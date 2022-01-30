package com.cm.graph.sp;

import edu.princeton.cs.introcs.In;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权有向图
 *
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月24日 21:54:00
 */
public class EdgeWeightedDigraph {
    private final int vertexes;
    private int edges;
    private final List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int vertexes, int edges) {
        this(vertexes);
        this.edges = edges;
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int vertexes) {
        this.vertexes = vertexes;
        this.adj = new List[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new ArrayList<>();
        }
    }


    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            if (v < 0 || v >= vertexes) {
                throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (vertexes - 1));
            }
            if (w < 0 || w >= vertexes) {
                throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (vertexes - 1));
            }
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int getEdges() {
        return edges;
    }

    public int getVertexes() {
        return vertexes;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.getFrom()].add(edge);
        edges++;
    }

    public List<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
