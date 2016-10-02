package tests;

import lessen.les7.ThomGraph;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thom
 * On 2-10-2016
 */
public class ThomGraphTest {
    ThomGraph thomGraph = null;

    @Before
    public void setUp() throws Exception {
        thomGraph = new ThomGraph("test1");
    }

    @Test
    public void addVertex() throws Exception {
        thomGraph.addVertex("test2");
    }

    @Test
    public void addEdge() throws Exception {
        thomGraph.addEdge("test1", "test2", 2);
    }

    @Test
    public void setUnweightedTest() throws Exception {
        thomGraph.setUnweighted("test1");
    }

    @Test
    public void getPathTest() throws Exception {
        thomGraph.addEdge("test1", "test2", 2);
//        thomGraph.setUnweighted("test1");
        System.out.println(thomGraph.getVertex("test1").getName());
//        System.out.println(thomGraph.getPath("test2"));
    }

}