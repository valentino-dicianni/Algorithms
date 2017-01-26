package src.esercizio3.test.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio3.Graph;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ShortestPathTest {
    Graph graph;
    String result;
    String  nodeStart;
    String nodeEnd;

    @Before
    public void init(){

    }

    public ShortestPathTest(Graph graph, String nodeStart, String nodeEnd, String result){
        this.graph = graph;
        this.nodeStart = nodeStart;
        this.nodeEnd = nodeEnd;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createGraph(1), "3", "7", "[7.0]"},
            {UtilsTest.createGraph(1), "5", "4", "[9.0]"},
            {UtilsTest.createGraph(1), "1", "7", "[10.0]"},
            {UtilsTest.createGraph(1), "1", "5", "[7.0]"}
        });
    }


    @Test
    public void testShortestPath(){
        assertEquals(this.result, UtilsTest.getShortestPathString(graph.findShortestPath(this.nodeStart, this.nodeEnd)));
        System.out.println(this.result);
    }

}
