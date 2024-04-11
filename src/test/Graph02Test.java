package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import suixianglu.graph.Graph02;

import java.util.Arrays;
import java.util.List;


public class Graph02Test {
    private Graph02 graph02;

    @Before
    public void setUp() {
        graph02 = new Graph02();
    }

    @Test
    public void testAllPathsSourceTarget01() {
        int[][] graphArray = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> result = graph02.allPathsSourceTarget(graphArray);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(Arrays.asList(0, 1, 3), result.get(0));
        Assert.assertEquals(Arrays.asList(0, 2, 3), result.get(1));
    }

    @Test
    public void testAllPathsSourceTarget02() {
        int[][] graphArray = {};
        List<List<Integer>> result = graph02.allPathsSourceTarget(graphArray);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testAllPathsSourceTarget03() {
        List<List<Integer>> result = graph02.allPathsSourceTarget(null);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testAllPathsSourceTarget04() {
        int[][] graphArray = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result = graph02.allPathsSourceTarget(graphArray);
        Assert.assertEquals(5, result.size());
        Assert.assertEquals(Arrays.asList(0, 4), result.get(0));
        Assert.assertEquals(Arrays.asList(0, 3, 4), result.get(1));
        Assert.assertEquals(Arrays.asList(0, 1, 3, 4), result.get(2));
        Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4), result.get(3));
        Assert.assertEquals(Arrays.asList(0, 1, 4), result.get(4));
    }

}