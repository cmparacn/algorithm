package com.cm.graph.digraph;

/**
 * @author CM cmpara@foxmail.com
 * @Description 拓扑排序
 * @createTime 2022年01月05日 21:10:00
 */
public interface Topological {

    /**
     * 是否是有向无环图
     */
     boolean isDAG();

    /**
     * dfs 获取的 order
     */
    Iterable<Integer> order() ;

}
