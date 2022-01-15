package com.cm.graph.digraph;

/**
 * @author CM cmpara@foxmail.com
 * @Description 有向图的强连通分量 o(n)
 * @createTime 2022年01月08日 11:33:00
 */
public class KosarajuSCC {
    private final boolean[] visited;
    private final int[] id;
    private int count = 0;

    /**
      @param digraph 有向图
     */
    public KosarajuSCC(Digraph digraph) {
        visited = new boolean[digraph.getVertexes()];
        id = new int[digraph.getVertexes()];
        Digraph reverse = digraph.reverse();
        DfsOrder dfsOrder = new DfsOrder(reverse);
        for (Integer cur : dfsOrder.getReversePost()) {
            if (!visited[cur]) {
                dfs(digraph, cur);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int cur) {
        visited[cur] = true;
        id[cur] = count;
        for (Integer next : digraph.adj(cur)) {
            if (!visited[next]) {
                dfs(digraph, next);
            }
        }
    }

    public int[] getId() {
        return id;
    }
}
