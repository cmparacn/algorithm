package com.cm.graph.digraph;

import org.junit.Test;

/**
 * @author CM cmpara@foxmail.com
 * @Description 测试 Kosaraju 算法
 * @createTime 2022年01月08日 12:05:00
 */
public class KosarajuSCCTest {
    @Test
    public void testKosaraju() {
        Digraph digraph = initGraph();
        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);
        for (int id : kosarajuSCC.getId()) {
            System.out.println(id);
        }
    }

    private Digraph initGraph(){
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 0);
        digraph.addEdge(0, 5);
        digraph.addEdge(5, 0);
        digraph.addEdge(0, 6);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(9, 12);
        digraph.addEdge(11, 12);
        return digraph;
    }

}