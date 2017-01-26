package src.esercizio2.test.btree.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio2.comparator.FloatComparator;
import src.esercizio2.comparator.IntegerComparator;
import src.esercizio2.comparator.StringComparator;
import src.esercizio2.test.UtilsTest;
import src.esercizio2.tree.BinaryNode;
import src.esercizio2.tree.BinaryTree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class InsertTest  {
    BinaryTree binaryTree;
    String result;
    String message;

    @Before
    public void init(){

    }

    public InsertTest(BinaryTree binaryTree, String result, String message){
        this.binaryTree = binaryTree;
        this.result = result;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createInsertBTree("integer1", new IntegerComparator()), "3 1 5 4 10 25 23 15 56 32", "Test1 --> integer1"},
            {UtilsTest.createInsertBTree("float1", new FloatComparator()), "3.0 1.0 5.0 4.0 10.0 25.0 23.0 15.0 56.0 32.0", "Test2 --> float1"},
            {UtilsTest.createInsertBTree("string2", new StringComparator()), "n d b a l p o t r w", "Test4 --> string2"}
        });
    }


    @Test
    public void testInsert(){
        assertEquals(this.message, this.result, binaryTree.binPreorderString());
    }


}
