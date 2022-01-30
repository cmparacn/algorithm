package com.cm.graph.mst;

import edu.princeton.cs.introcs.In;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月15日 11:42:00
 */
public class PrimTest {

    @Test
    public void testLazyPrim() {
        WeightedGraph weightedGraph = new WeightedGraph(new In
                (new File("src/test/java/com/cm/graph/mst/tinyEWG.txt")));
        LazyPrimMst lazyPrimMst = new LazyPrimMst(weightedGraph);
        List<Edge> mst = lazyPrimMst.getMst();
        Assert.assertEquals(7, mst.size());
    }

    @Test
    public void testEagerPrim() {
        WeightedGraph weightedGraph = new WeightedGraph(new In
                (new File("src/test/java/com/cm/graph/mst/tinyEWG.txt")));
        PrimMst primMst = new PrimMst(weightedGraph);
        List<Edge> mst = primMst.getMst();
        Assert.assertEquals(7, mst.size());
    }

}