package com.cm.base;

/**
 * 快速 union
 * <P>加权 quickUnion, 总是将深度小的树接在深度大的树下面, 避免退化成单链表</P>
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月19日 23:53:00
 */
public class WeightedQuickUnionUF extends UnionFind{

    private final int[] id;

    /**
     * 树的深度
     */
    private final int[] depth;

    public WeightedQuickUnionUF(int count) {
        super(count);
        id = new int[count];
        depth = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            depth[i] = 1;
        }
    }

    /**
     * 新增连接, 将两者合为一个集
     * 总是将 p 接在 q 下面
     *
     * @param p item p
     * @param q item q
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        // 根 root 一致
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
            count--;
        }
    }

    /**
     * 查找 item p 所属的集合
     *
     * @param p item p
     * @return 所属的集编号
     */
    @Override
    public int find(int p) {
        int cur = p;
        while (id[cur] != cur) {
            cur = id[cur];
        }
        return cur;
    }
}
