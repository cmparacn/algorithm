package com.cm.graph.digraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @Description 有向图 dfs 的 order: 前序 & 后序 & 逆后序
 * @createTime 2022年01月08日 13:32:00
 */
public class DfsOrder {
    private List<Integer> pre;
    private List<Integer> post;
    private List<Integer> reversePost;
    private boolean[] visited;

    public DfsOrder(Digraph digraph) {
        int vertexes = digraph.getVertexes();
        pre = new ArrayList<>(vertexes);
        post = new ArrayList<>(vertexes);
        reversePost = new ArrayList<>(vertexes);
        visited = new boolean[vertexes];
        for (int i = 0; i < vertexes; i++) {
            if (!visited[i]) {
                dfs(digraph, i);
            }
        }
        reversePost = new ArrayList<>(post);
        Collections.reverse(reversePost);
    }

    private void dfs(Digraph digraph, int cur) {
        visited[cur] = true;
        pre.add(cur);
        for (Integer next : digraph.adj(cur)) {
            if (!visited[next]) {
                dfs(digraph, next);
            }
        }
        post.add(cur);
    }

    public List<Integer> getPre() {
        return pre;
    }

    public List<Integer> getPost() {
        return post;
    }

    public List<Integer> getReversePost() {
        return reversePost;
    }
}
