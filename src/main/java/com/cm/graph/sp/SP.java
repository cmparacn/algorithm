package com.cm.graph.sp;

import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月24日 22:27:00
 */
public abstract class SP {

    /**
     * 顶点
     */
    protected int s;

    protected SP(int s) {
        this.s = s;
    }

    /**
     * v 到顶点的最短距离
     * @param v 图中某点
     * @return 最短距离
     */
    protected double distTo(int v) {
        return 0;
    }

    /**
     * 是否存在顶点到 v 的路径
     * @param v 图中某点
     * @return 是否存在路径
     */
    public boolean hashPathTo(int v) {
        return false;
    }

    /**
     * v 到顶点的最短路径
     * @param v 图中某点
     * @return 最短路径, 不存在时为 null
     */
    protected List<DirectedEdge> pathTo(int v) {
        return null;
    }
}
