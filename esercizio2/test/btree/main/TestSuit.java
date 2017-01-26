package src.esercizio2.test.btree.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import src.esercizio2.test.btree.tests.ComparatorTest;
import src.esercizio2.test.btree.tests.InsertTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ComparatorTest.class,
        InsertTest.class
})
public class TestSuit {
}
