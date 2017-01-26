package src.esercizio2;

import src.esercizio2.comparator.*;
import src.esercizio2.object.Record;
import src.esercizio2.tree.BinaryTree;
import src.esercizio2.tree.Tree;
import src.esercizio2.tree.RedBlackTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {

  static String path = "records.csv";
  final static int SIZE =   20000000;
  final static int NUM_KEY = 1000000;

  static long start;
  static long elapsedTimeMillisec;

  /**
   * Tree filling methods: they returns a vector filled with random key
   * for testing on search and delete method. For avoiding random number repeats,
   * the vector for positions "randomInt" is extended: SIZE+30000. We calculated
   * that the amount of repeats in numbers is around 22000 and 26000 for 1 ml numbers
   * chosen between 0 and 20ml. After that, for eliminate duplications, we create an
   * HashSet where to store 1ml all different numbers(in this kind of structure, when a
   * value is insert, if already existing, it is not set again). Once the values are ready,
   * they are copied again into the vector and than sorted.
   *
   * The second part of the method is the most important: here, the "records.csv" is scanned
   * and and objects Record are created. Now the tree is filled thanks to insertValue()
   * method, which creates a new node and fill it into the tree itself.  During this
   * operation, when the value of "count" is the same of the randomInt "pos" value, the record
   * field is also insert into the vector randomKey.
   * At the end, the vector randomKey is returned.
   */

  public static Vector<Integer> integerFillTree(Tree tree) {
    elapsedTimeMillisec = 0;
    Random random = new Random();
    Vector<Integer> randomInt = new Vector<Integer>(NUM_KEY);
    for (int i=0; i<NUM_KEY+30000; i++) randomInt.add(random.nextInt(SIZE));
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i : randomInt) {
      if (set.size() >= NUM_KEY) break;
      set.add(i);
    }
    randomInt.clear();
    randomInt.addAll(set);
    Collections.sort(randomInt);

    Vector<Integer> randomKey = new Vector<Integer>(NUM_KEY);
    int count = 0, pos = 0;

    BufferedReader br = null;
    try {
      String sCurrentLine;
      br = new BufferedReader(new FileReader(path));
      while ((sCurrentLine = br.readLine()) != null) {
        String[] fields = sCurrentLine.split(",");
        Record <String, Integer, Float> value = new Record<String, Integer, Float>(fields[1], Integer.parseInt(fields[2]), Float.parseFloat(fields[3]));
        start = System.currentTimeMillis();
        tree.insertValue(value.getField2(), value);
        elapsedTimeMillisec += System.currentTimeMillis() - start;
        if (pos < NUM_KEY && randomInt.get(pos) == count) {
          randomKey.add(Integer.parseInt(fields[2]));
          pos++;
        }
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return randomKey;
  }

  public static Vector<Float> floatFillTree(Tree tree) {
    elapsedTimeMillisec = 0;
    Random random = new Random();
    Vector<Integer> randomInt = new Vector<Integer>(NUM_KEY);
    for (int i=0; i<NUM_KEY+30000; i++) randomInt.add(random.nextInt(SIZE));
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i : randomInt) {
      if (set.size() >= NUM_KEY) break;
      set.add(i);
    }
    randomInt.clear();
    randomInt.addAll(set);
    Collections.sort(randomInt);

    Vector<Float> randomKey = new Vector<Float>(NUM_KEY);
    int count = 0, pos = 0;
    BufferedReader br = null;
    try {
      String sCurrentLine;
      br = new BufferedReader(new FileReader(path));
      int i = 0;
      while ((sCurrentLine = br.readLine()) != null && i < SIZE) {
        String[] fields = sCurrentLine.split(",");
        Record <String, Integer, Float> value = new Record<String, Integer, Float>(fields[1], Integer.parseInt(fields[2]), Float.parseFloat(fields[3]));
        start = System.currentTimeMillis();
        tree.insertValue(value.getField3(), value);
        elapsedTimeMillisec += System.currentTimeMillis() - start;
        if (pos < NUM_KEY && randomInt.get(pos) == count) {
          randomKey.add(Float.parseFloat(fields[3]));
          pos++;
        }
        i++;
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return randomKey;
  }

  public static Vector<String> stringFillTree(Tree tree) {
    elapsedTimeMillisec = 0;
    Random random = new Random();
    Vector<Integer> randomInt = new Vector<Integer>(NUM_KEY);
    for (int i=0; i<NUM_KEY+30000; i++) randomInt.add(random.nextInt(SIZE));
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i : randomInt) {
      if (set.size() >= NUM_KEY) break;
      set.add(i);
    }
    randomInt.clear();
    randomInt.addAll(set);
    Collections.sort(randomInt);

    Vector<String> randomKey = new Vector<String>(NUM_KEY);
    int count = 0, pos = 0;
    BufferedReader br = null;
    try {
      String sCurrentLine;
      br = new BufferedReader(new FileReader(path));
      while ((sCurrentLine = br.readLine()) != null) {
        String[] fields = sCurrentLine.split(",");
        Record <String, Integer, Float> value = new Record<String, Integer, Float>(fields[1], Integer.parseInt(fields[2]), Float.parseFloat(fields[3]));
        start = System.currentTimeMillis();
        tree.insertValue(value.getField1(), value);
        elapsedTimeMillisec += System.currentTimeMillis() - start;
        if (pos < NUM_KEY && randomInt.get(pos) == count) {
          randomKey.add(fields[1]);
          pos++;
        }
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return randomKey;
  }


  public static <T> void searchKey(Tree tree, Vector<T> vect) {
    boolean b;
    for(T i : vect){
      b = tree.search(i);
      if(b == false)
        System.out.println("----------->ERRORE: chiave non trovata!" + i);
    }
  }
  public static <T> void deleteKey(Tree tree, Vector<T> vect) {
    for(T i : vect){
      tree.delete(i);
    }
  }




  public static void main(String args []){
    BinaryTree integerBT = new BinaryTree(new IntegerComparator());
    BinaryTree stringBT = new BinaryTree(new StringComparator());
    BinaryTree floatBT = new BinaryTree(new FloatComparator());
    RedBlackTree integerRBT = new RedBlackTree(new IntegerComparator());
    RedBlackTree stringRBT = new RedBlackTree(new StringComparator());
    RedBlackTree floatRBT = new RedBlackTree(new FloatComparator());


    /*INTEGER BINARY TREE*/
    Vector<Integer> IntegerVect = integerFillTree(integerBT);
    System.out.println("\n-> INSERT time 20ml nodes in INTEGER Binary Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + integerBT.contaNodi());
    System.out.println("max level tree before delete: " + integerBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(integerBT, IntegerVect);
    System.out.println("-> SEARCH 1ml integer key in Binary Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(integerBT, IntegerVect);
    System.out.println("-> DELETE 1ml integer key in Binary Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    System.out.println("max level tree after delete: " + integerBT.maxLevel());
    integerBT.root = null;
    System.out.println("/**********************************/");


    /*FLOAT BINARY TREE*/
    Vector<Float> FloatVect = floatFillTree(floatBT);
    System.out.println("-> INSERT time 20ml nodes in FLOAT Binary Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + floatBT.contaNodi());
    System.out.println("max level tree before delete: " + floatBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(floatBT, FloatVect);
    System.out.println("-> SEARCH 1ml float key in Binary Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(floatBT, FloatVect);
    System.out.println("-> DELETE 1ml float key in: " + (System.currentTimeMillis()-start) + " millisec " );
    System.out.println("max level tree after delete: " + floatBT.maxLevel());
    floatBT.root = null;
    System.out.println("/**********************************/");


    /*STRING BINARY TREE*/
    Vector<String> StringVect = stringFillTree(stringBT);
    System.out.println("-> INSERT time 20ml nodes in STRING Binary Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + stringBT.contaNodi());
    System.out.println("max level tree before delete: " + stringBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(stringBT, StringVect);
    System.out.println("-> SEARCH 1ml string key in Binary Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(stringBT, StringVect);
    System.out.println("-> DELETE 1ml string key in: " + (System.currentTimeMillis()-start) + " millisec " );
    System.out.println("max level tree after delete: " + stringBT.maxLevel());
    floatBT.root = null;
    System.out.println("/**********************************/");
    System.out.println("/**********************************/");


    /*INTEGER RED BLACK TREE*/
    Vector<Integer> IntegerVect1 = integerFillTree(integerRBT);
    System.out.println("-> INSERT time 20ml nodes in integer RedBlack Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + integerRBT.contaNodi());
    System.out.println("max level tree before delete: " + integerRBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(integerRBT, IntegerVect1);
    System.out.println("-> SEARCH 1ml integer key in RedBlack Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(integerRBT, IntegerVect1);
    System.out.println("-> DELETE 1ml integer key in: " + (System.currentTimeMillis()-start) + " millisec " );
    System.out.println("max level tree after delete: " + integerRBT.maxLevel());
    integerRBT.root = null;
    System.out.println("/**********************************/");

     /*FLOAT RED BLACK TREE*/
    Vector<Float> FloatVect1 = floatFillTree(floatRBT);
    System.out.println("-> INSERT time 20ml nodes in float RedBlack Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + floatRBT.contaNodi());
    System.out.println("max level tree before delete: " + floatRBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(floatRBT, FloatVect1);
    System.out.println("-> SEARCH 1ml float key in RedBlack Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(floatRBT, FloatVect1);
    System.out.println("-> DELETE 1ml float key in: " + (System.currentTimeMillis()-start) + " millisec " );
    System.out.println("max level tree after delete: " + floatRBT.maxLevel());
    floatRBT.root = null;
    System.out.println("/**********************************/");


    /*STRING RED BLACK TREE*/
    Vector<String> StringVect1 = stringFillTree(stringRBT);
    System.out.println("-> INSERT time 20ml nodes in string RedBlack Tree: " + elapsedTimeMillisec/1000 + " sec");
    System.out.println("number of nodes: " + stringRBT.contaNodi());
    System.out.println("max level tree before delete: " + stringRBT.maxLevel());

    start = System.currentTimeMillis();
    searchKey(stringRBT, StringVect1);
    System.out.println("-> SEARCH 1ml string key in RedBlack Tree in: " + (System.currentTimeMillis()-start) + " millisec " );

    start = System.currentTimeMillis();
    deleteKey(stringRBT, StringVect1);
    System.out.println("-> DELETE 1ml string key in: " + (System.currentTimeMillis()-start) + " millisec " );
    System.out.println("max level tree after delete: " + stringRBT.maxLevel());
    stringRBT.root = null;
    System.out.println("/**********************************/");


  }
}
