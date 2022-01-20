package com.cm.base;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月16日 23:21:00
 */
public abstract class UnionFind {

    public UnionFind(int count) {
        this.count = count;
    }

    protected int count;

    /**
     * 新增连接, 将两者合为一个集
     *
     * @param p item p
     * @param q item q
     */
     public void union(int p, int q) {

     }

    /**
     * 查找 item p 所属的集合
     *
     * @param p item p
     * @return 所属的集编号
     */
    public int find(int p){
        return 0;
    }

    /**
     *  p q 是否在一个并查集中
     * @param p item p
     * @param q item q
     * @return 在 or 不在
     */
    public boolean connected(int p, int q) {
        return  find(p) == find(q);
    }

    /**
     * @return 并查集的数量
     */
    public int count() {
        return count;
    }
}
