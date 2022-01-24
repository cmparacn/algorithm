package com.cm.graph.mst;

import edu.princeton.cs.introcs.In;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月24日 21:41:00
 */
public class KruskalMSTTest {
    @Test
    public void testKruskal() {
        WeightedGraph weightedGraph = new WeightedGraph(new In
                (new File("src/test/java/com/cm/graph/mst/tinyEWG.txt")));
        KruskalMST kruskalMST = new KruskalMST(weightedGraph);
        List<Edge> mst = kruskalMST.getMst();
        Assert.assertEquals(7, mst.size());
    }
}