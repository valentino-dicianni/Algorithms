package src.esercizio2.test.redBlackTree.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio2.comparator.FloatComparator;
import src.esercizio2.comparator.IntegerComparator;
import src.esercizio2.comparator.StringComparator;
import src.esercizio2.test.UtilsTest;
import src.esercizio2.tree.BinaryTree;
import src.esercizio2.tree.RedBlackTree;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SearchTest {
	RedBlackTree redBlackTree;
	Object value;
	Boolean result;

	@Before
	public void init(){

	}

	public SearchTest(RedBlackTree redBlackTree, Object value,  Boolean result){
		this.redBlackTree = redBlackTree;
		this.value = value;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection parametri() {
		return Arrays.asList(new Object[][]{
			{UtilsTest.createRedBlackTree("integer1", new IntegerComparator()), 10, true},
			{UtilsTest.createRedBlackTree("integer1", new IntegerComparator()), 14, false},
			{UtilsTest.createRedBlackTree("float1", new FloatComparator()), new Float(14), false},
			{UtilsTest.createRedBlackTree("string2", new StringComparator()), "r", true},
			{UtilsTest.createRedBlackTree("string2", new StringComparator()), "w", false}
		});
	}


	@Test
	public void testInsert(){
//		System.out.println(this.redBlackTree.nodePreorderString(this.redBlackTree.root));
		assertEquals(this.result, this.redBlackTree.search(this.value));
	}
}
