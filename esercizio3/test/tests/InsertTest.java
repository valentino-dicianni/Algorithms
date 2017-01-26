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
public class InsertTest  {
    Graph graph;
    String result;

    @Before
    public void init(){

    }

    public InsertTest(Graph graph, String result){
        this.graph = graph;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createGraph(1), "3--> 5(5.0), 7(7.0), \n2--> 0(7.0), \n1--> 2(4.0), 5(8.0), 6(3.0), \n7--> 6(5.0), " +
                    "\n6--> 4(6.0), 5(4.0), \n5--> 1(5.0), 6(3.0), 7(3.0), \n4--> 7(2.0), \n"}
        });
    }


    @Test
    public void testInsert(){
        System.out.println(this.graph.printAll());
        assertEquals(this.result, this.graph.printAll());
    }


}
