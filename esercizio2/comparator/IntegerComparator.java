package src.esercizio2.comparator;

import java.util.Comparator;
import src.esercizio2.object.Record;
import src.esercizio2.tree.BinaryNode;

public class IntegerComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    if(o1 > o2){
      return 1;
    }else if(o1 < o2){
      return -1;
    }
    return 0;
  }
}
