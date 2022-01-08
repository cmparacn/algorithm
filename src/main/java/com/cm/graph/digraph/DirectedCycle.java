package com.cm.graph.digraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @Description 有向图检测环
 * @createTime 2022年01月04日 21:45:00
 */
public class DirectedCycle {
    private boolean hasCycle;
    private List<Integer> cycle;
    private final boolean[] visited;
    private final boolean[] onPath;
    private final int[] from;

    public DirectedCycle(Digraph graph) {
        int vertexes = graph.getVertexes();
        from = new int[vertexes];
        visited = new boolean[vertexes];
        onPath = new boolean[vertexes];
        for (int i = 0; i < vertexes; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(Digraph graph, int cur) {
        onPath[cur] = true;
        visited[cur] = true;
        for (Integer next : graph.adj(cur)) {
            if (hasCycle()) {
                return;
                // 成环
            } else if (onPath[next]) {
                cycle = new ArrayList<>();
                for (int i = cur; i != next; i = from[i]) {
                    cycle.add(i);
                }
                cycle.add(next);
                hasCycle = true;
                return;
            } else {
                from[next] = cur;
                dfs(graph, next);
            }
        }
        onPath[cur] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    /**
     * 返回环中的所有节点
     * @return 环中节点 list
     */
    public List<Integer> cycle() {
        return cycle;
    }


}
