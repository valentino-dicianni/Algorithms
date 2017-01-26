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
public class InsertTest  {
    RedBlackTree redBlackTree;
    String result;

    @Before
    public void init(){

    }

    public InsertTest(RedBlackTree redBlackTree, String result){
        this.redBlackTree = redBlackTree;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createInsertRedBlackTree("integer1", new IntegerComparator()), "10-N 3-R 1-N 5-N 4-R 32-R 23-N 15-R 25-R 56-N"},
            {UtilsTest.createInsertRedBlackTree("float1", new FloatComparator()), "10.0-N 3.0-R 1.0-N 5.0-N 4.0-R 32.0-R 23.0-N 15.0-R 25.0-R 56.0-N"},
            {UtilsTest.createInsertRedBlackTree("string2", new StringComparator()), "n-N d-R b-N a-R l-N p-R o-N t-N r-R w-R"}
        });
    }


    @Test
    public void testInsert(){
        assertEquals(this.result, redBlackTree.nodePreorderString(redBlackTree.root));
    }


}
