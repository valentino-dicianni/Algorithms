package src.esercizio2.test.btree.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import src.esercizio2.comparator.FloatComparator;
import src.esercizio2.comparator.IntegerComparator;
import src.esercizio2.comparator.StringComparator;

import java.awt.event.ComponentAdapter;
import java.awt.geom.Arc2D;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComparatorTest <V1, V2> {
    Comparator comparator;
    V1 value1;
    V2 value2;
    int result;

    @Before
    public void init(){

    }

    public ComparatorTest(Comparator c, V1 v1, V2 v2, int result){
        this.comparator = c;
        this.value1 = v1;
        this.value2 = v2;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection parametri() {
        return Arrays.asList(new Object[][]{
            {new FloatComparator(), new Float(2), new Float(2), 0},
            {new IntegerComparator(), 1, 2, -1},
            {new StringComparator(), "ciao", "prova", -1}
        });
    }


    @Test
    public void testCompare(){
        assertEquals(this.result, comparator.compare(this.value1, this.value2));
    }
}
