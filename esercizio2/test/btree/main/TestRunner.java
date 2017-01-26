package src.esercizio2.test.btree.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void  main(String [] args){
        Result result = JUnitCore.runClasses(TestSuit.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

//        FrequenzeCaratteriSingoli fcs;
//        fcs = new FrequenzeCaratteriSingoli();
//        String [] risultato = fcs.calcolaFrequenze("francese", "BonjourmonnomestIonut");
    }
}
