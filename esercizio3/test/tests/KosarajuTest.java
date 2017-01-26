package src.esercizio3.test.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio3.Kosaraju;
import src.esercizio3.Graph;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class KosarajuTest {
	Graph graph;
	String result;

	@Before
	public void init(){

	}

	public KosarajuTest(Graph graph, String result){
		this.graph = graph;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection parametri() {
		return Arrays.asList(new Object[][]{
			{UtilsTest.createGraph(2), "[3 5 ]\n[2 1 6 4 ]\n"},
			{UtilsTest.createGraph(3), "[d c b ]\n[f e ]\n"}
		});
	}


	@Test
	public void testKosaraju(){
		assertEquals(this.result, new Kosaraju().gatherStronglyConnectedString(graph.getGraph(), graph.getGraphRev()));
	}
}
