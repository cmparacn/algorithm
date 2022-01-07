package com.cm.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author CM cmpara@foxmail.com
 * @Description 测试有向图求环
 * @createTime 2022年01月05日 10:50:00
 */
public class DirectedCycleTest {

    @Test
    public void testCycle() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 1);
        digraph.addEdge(3, 2);
        digraph.addEdge(1, 3);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        Assert.assertEquals(3, directedCycle.cycle().size());
    }
}