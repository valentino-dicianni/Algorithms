package src.esercizio2.test.btree.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.BooleanSupplier;
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
public class SearchTest {
    BinaryTree binaryTree;
    Object value;
    Boolean result;

    @Before
    public void init(){

    }

    public SearchTest(BinaryTree binaryTree, Object value,  Boolean result){
        this.binaryTree = binaryTree;
        this.value = value;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {UtilsTest.createTree("integer1", new IntegerComparator()), 10, true},
            {UtilsTest.createTree("integer1", new IntegerComparator()), 14, false},
            {UtilsTest.createTree("float1", new FloatComparator()), new Float(14), false},
            {UtilsTest.createTree("string2", new StringComparator()), "r", true},
            {UtilsTest.createTree("string2", new StringComparator()), "w", false}

        });
    }


    @Test
    public void testInsert(){
        assertEquals(this.result, this.binaryTree.search(this.value));
    }
}
