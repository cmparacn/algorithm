package com.cm.base;

/**
 * 快速 union
 * <P>当所有对象均属于一个分量时, 会形成类似单链表的结构, n 个点的并查集构造复杂度退化为 o(n^2)</P>
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月19日 23:53:00
 */
public class QuickUnionUnionFind extends UnionFind{

    private final int[] id;

    public QuickUnionUnionFind(int count) {
        super(count);
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
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
