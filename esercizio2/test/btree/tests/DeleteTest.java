package src.esercizio2.test.btree.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio2.comparator.FloatComparator;
import src.esercizio2.comparator.IntegerComparator;
import src.esercizio2.comparator.StringComparator;
import src.esercizio2.test.UtilsTest;
import src.esercizio2.tree.BinaryTree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class DeleteTest {
    Comparator comparator;
    BinaryTree binaryTree;
    String result;
    Object valueToDelete;

    @Before
    public void init(){

    }

    public DeleteTest(BinaryTree binaryTree, Object valueToDelete, String result){
        this.binaryTree = binaryTree;
        this.result = result;
        this.valueToDelete = valueToDelete;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createTree("float1", new FloatComparator()), new Float(5), "3.0 1.0 4.0 10.0 25.0 23.0 15.0 56.0 32.0"},
            {UtilsTest.createTree("integer1", new IntegerComparator()), 25, "3 1 5 4 10 23 15 56 32"},
            {UtilsTest.createTree("string2", new StringComparator()), "t", "m a f b c r o y u"}

        });
    }


    @Test
    public void testDelete(){
        System.out.println(this.binaryTree.binPreorderString());
        binaryTree.delete(this.valueToDelete);
        assertEquals(this.result, binaryTree.binPreorderString());
    }

}
