package com.cm.graph.mst;

import edu.princeton.cs.introcs.In;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 加权无向图
 * 假设不存在自环
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月09日 17:59:00
 */
public class WeightedGraph {
    private final int vertexes;
    private int edges;
    private final List<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public WeightedGraph(int vertexes) {
        this.vertexes = vertexes;
        this.adj = (List<Edge>[]) new List[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public WeightedGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");

        try {
            this.vertexes  = in.readInt();
            this.adj = (List<Edge>[]) new List[vertexes];
            for (int v = 0; v < vertexes; v++) {
                adj[v] = new ArrayList<>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                double weight = in.readDouble();
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
        }

    }

    public int getEdges() {
        return edges;
    }

    public int getVertexes() {
        return vertexes;
    }

    public void addEdge(Edge e) {
        int either = e.either();
        adj[either].add(e);
        adj[e.other(either)].add(e);
        edges++;
    }

    public List<Edge> adj(int v) {
        return adj[v];
    }

    public List<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < vertexes; i++) {
            for (Edge edge : adj(i)) {
                if (edge.other(i) > i) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
}
