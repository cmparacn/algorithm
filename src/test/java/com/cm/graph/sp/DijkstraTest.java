package com.cm.graph.sp;

import edu.princeton.cs.introcs.In;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author CM cmpara@foxmail.com
 * @createTime 2022年01月29日 12:13:00
 */
public class DijkstraTest {

    @Test
    public void testDijkstra() throws MalformedURLException {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(new In(
                new URL("https://algs4.cs.princeton.edu/44sp/tinyEWD.txt")));
        SP dijkstraSp = new Dijkstra(0, digraph);
        List<DirectedEdge> directedEdges = dijkstraSp.pathTo(6);
        Assert.assertEquals(4, directedEdges.size());
        Assert.assertEquals(3, dijkstraSp.pathTo(1).size());
    }
}