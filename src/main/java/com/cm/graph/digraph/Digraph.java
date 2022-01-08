package com.cm.graph.digraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @Description 有向图
 * @createTime 2022年01月04日 21:15:00
 */
public class Digraph {
    private final int vertexes;
    private int edges;
    private final List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int v) {
        vertexes = v;
        adj = (List<Integer>[]) new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int getEdges() {
        return edges;
    }

    public int getVertexes() {
        return vertexes;
    }

    public void addEdge(int start, int end) {
        adj[start].add(end);
        edges++;
    }

    public void removeEdge(int start, int end) {
        if (adj[start].contains(end)) {
            adj[start].remove(new Integer(end));
            edges--;
        }
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(vertexes);
        for (int i = 0; i < vertexes; i++) {
            for (Integer end : adj(i)) {
                reverse.addEdge(end, i);
            }
        }
        return reverse;
    }

    public Digraph copy() {
        Digraph copy = new Digraph(vertexes);
        for (int i = 0; i < vertexes; i++) {
            for (Integer end : adj(i)) {
                copy.addEdge(i, end);
            }
        }
        return copy;
    }
}
