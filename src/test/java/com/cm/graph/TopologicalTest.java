package com.cm.graph;

import org.junit.Test;

import java.util.Iterator;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月05日 23:48:00
 */
public class TopologicalTest {

    @Test
    public void testTopological() {
        Topological topological = new Topological(initGraph());
        Iterable<Integer> order = topological.order();
        for (Integer integer : order) {
            System.out.println(integer);
        }
    }

    @Test
    public void testTopological1() {
        Topological topological = new Topological(initGraph());
        Iterable<Integer> order = topological.getTopological(initGraph());
        for (Integer integer : order) {
            System.out.println(integer);
        }
    }


    private Digraph initGraph(){
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
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