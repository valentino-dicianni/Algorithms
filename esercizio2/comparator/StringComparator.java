package src.esercizio2.comparator;

import src.esercizio2.object.Record;
import src.esercizio2.tree.BinaryNode;

import java.util.Comparator;

public class StringComparator implements Comparator <String> {
  @Override
  public int compare(String o1, String o2) {
//    TODO IONUT: il compare fa il confronto solo del primo carattere
    return o1.compareTo(o2);
  }
}
