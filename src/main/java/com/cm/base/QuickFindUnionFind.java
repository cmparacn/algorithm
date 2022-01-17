package com.cm.base;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月17日 23:21:00
 */
public class QuickFindUnionFind extends UnionFind {

    private final int[] id;

    public QuickFindUnionFind(int count) {
        this.count = count;
        this.id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    /**
     * 新增连接, 将两者合为一个集
     *
     * @param p item p
     * @param q item q
     */
    @Override
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int qId = id[q];
        int pId = id[p];
        for (int i = 0; i < count; i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }
        count--;
    }

    /**
     * 查找 item p 所属的集合
     *
     * @param p item p
     * @return 所属的集编号
     */
    @Override
    public int find(int p) {
        return id[p];
    }
}
