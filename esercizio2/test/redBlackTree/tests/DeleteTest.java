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
import java.util.Comparator;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class DeleteTest {
    Comparator comparator;
    RedBlackTree redBlackTree;
    String result;
    Object valueToDelete;

    @Before
    public void init(){

    }

    public DeleteTest(RedBlackTree redBlackTree, Object valueToDelete, String result){
        this.redBlackTree = redBlackTree;
        this.result = result;
        this.valueToDelete = valueToDelete;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createRedBlackTree("float1", new FloatComparator()), new Float(5), "10.0-N 3.0-R 1.0-N 4.0-N 32.0-R 23.0-N 15.0-R 25.0-R 56.0-N"},
            {UtilsTest.createRedBlackTree("integer1", new IntegerComparator()), 25, "10-N 3-R 1-N 5-N 4-R 32-R 23-N 15-R 56-N"},
            {UtilsTest.createRedBlackTree("string2", new StringComparator()), "t", "m-N d-R a-N i-N f-R r-R q-N p-R r-N"}
        });
    }


    @Test
    public void testDelete(){
        System.out.println(redBlackTree.nodePreorderString(redBlackTree.root));
        redBlackTree.delete(this.valueToDelete);
        assertEquals(this.result, redBlackTree.nodePreorderString(redBlackTree.root));
    }

}
