package src.esercizio2.test;

import src.esercizio2.comparator.FloatComparator;
import src.esercizio2.comparator.IntegerComparator;
import src.esercizio2.tree.BinaryNode;
import src.esercizio2.tree.BinaryTree;
import src.esercizio2.tree.RedBlackTree;

import java.util.Comparator;

public class UtilsTest {

    public static BinaryTree createTree(String type, Comparator comparator){
        if(type.equalsIgnoreCase("integer1")) {
//        3, 5, 1, 10, 25, 56, 32, 4, 23, 15
            BinaryNode b10 = new BinaryNode(15, null);
            BinaryNode b9 = new BinaryNode(23, null, b10, null);
            BinaryNode b7 = new BinaryNode(32, null);
            BinaryNode b6 = new BinaryNode(56, null, b7, null);
            BinaryNode b5 = new BinaryNode(25, null, b9, b6);
            BinaryNode b4 = new BinaryNode(10, null, null, b5);
            BinaryNode b8 = new BinaryNode(4, null);
            BinaryNode b2 = new BinaryNode(5, null, b8, b4);
            BinaryNode b3 = new BinaryNode(1, null);
            BinaryNode b1 = new BinaryNode(3, null, b3, b2);

            return new BinaryTree(b1, comparator);
        }else if(type.equalsIgnoreCase("float1")){
            BinaryNode b10 = new BinaryNode(new Float(15), null);
            BinaryNode b9 = new BinaryNode(new Float(23), null, b10, null);
            BinaryNode b7 = new BinaryNode(new Float(32), null);
            BinaryNode b6 = new BinaryNode(new Float(56), null, b7, null);
            BinaryNode b5 = new BinaryNode(new Float(25), null, b9, b6);
            BinaryNode b4 = new BinaryNode(new Float(10), null, null, b5);
            BinaryNode b8 = new BinaryNode(new Float(4), null);
            BinaryNode b2 = new BinaryNode(new Float(5), null, b8, b4);
            BinaryNode b3 = new BinaryNode(new Float(1), null);
            BinaryNode b1 = new BinaryNode(new Float(3), null, b3, b2);

            return new BinaryTree(b1, comparator);
        }else if(type.equalsIgnoreCase("string1")){
            BinaryNode b10 = new BinaryNode("15", null);
            BinaryNode b9 = new BinaryNode("23", null, b10, null);
            BinaryNode b7 = new BinaryNode("32", null);
            BinaryNode b6 = new BinaryNode("56", null, b7, null);
            BinaryNode b5 = new BinaryNode("25", null, b9, b6);
            BinaryNode b4 = new BinaryNode("10", null, null, b5);
            BinaryNode b8 = new BinaryNode("4", null);
            BinaryNode b2 = new BinaryNode("5", null, b8, b4);
            BinaryNode b3 = new BinaryNode("1", null);
            BinaryNode b1 = new BinaryNode("3", null, b3, b2);

            return new BinaryTree(b1, comparator);
        }else if(type.equalsIgnoreCase("string2")){
            //
            BinaryNode b1 = new BinaryNode("u", null);
            BinaryNode b2 = new BinaryNode("c", null);
            BinaryNode b3 = new BinaryNode("y", null, b1, null);
            BinaryNode b4 = new BinaryNode("b", null, null, b2);
            BinaryNode b5 = new BinaryNode("t", null, null, b3);
            BinaryNode b6 = new BinaryNode("o", null);
            BinaryNode b7 = new BinaryNode("f", null, b4, null);
            BinaryNode b8 = new BinaryNode("r", null, b6, b5);
            BinaryNode b9 = new BinaryNode("a", null, null, b7);
            BinaryNode root = new BinaryNode("m", null, b9, b8);
            return new BinaryTree(root, comparator);
        }else{
            return null;
        }




    }

    public static RedBlackTree createRedBlackTree(String type, Comparator comparator){
        RedBlackTree redBlackTree = new RedBlackTree(comparator);
        if(type.equalsIgnoreCase("integer1")) {
//        3, 5, 1, 10, 25, 56, 32, 4, 23, 15
           RedBlackTree.RedBlackNode b10 = redBlackTree.createNode(15, null, true);
           RedBlackTree.RedBlackNode b9 = redBlackTree.createNode(25, null, true);
           RedBlackTree.RedBlackNode b7 = redBlackTree.createNode(4, null, true);
           RedBlackTree.RedBlackNode b6 = redBlackTree.createNode(23, null, b10, b9, false);
           RedBlackTree.RedBlackNode b5 = redBlackTree.createNode(56, null, false);
           RedBlackTree.RedBlackNode b4 = redBlackTree.createNode(5, null, b7, null, false);
           RedBlackTree.RedBlackNode b8 = redBlackTree.createNode(1, null, false);
           RedBlackTree.RedBlackNode b2 = redBlackTree.createNode(32, null, b6, b5, true);
           RedBlackTree.RedBlackNode b3 = redBlackTree.createNode(3, null, b8, b4, true);
           RedBlackTree.RedBlackNode b1 = redBlackTree.createNode(10, null, b3, b2, false);

            return new RedBlackTree(b1, comparator);
        }else if(type.equalsIgnoreCase("float1")){
            RedBlackTree.RedBlackNode b10 = redBlackTree.createNode(new Float(15), null, true);
            RedBlackTree.RedBlackNode b9 = redBlackTree.createNode(new Float(25), null, true);
            RedBlackTree.RedBlackNode b7 = redBlackTree.createNode(new Float(4), null, true);
            RedBlackTree.RedBlackNode b6 = redBlackTree.createNode(new Float(23), null, b10, b9, false);
            RedBlackTree.RedBlackNode b5 = redBlackTree.createNode(new Float(56), null, false);
            RedBlackTree.RedBlackNode b4 = redBlackTree.createNode(new Float(5), null, b7, null, false);
            RedBlackTree.RedBlackNode b8 = redBlackTree.createNode(new Float(1), null, false);
            RedBlackTree.RedBlackNode b2 = redBlackTree.createNode(new Float(32), null, b6, b5, true);
            RedBlackTree.RedBlackNode b3 = redBlackTree.createNode(new Float(3), null, b8, b4, true);
            RedBlackTree.RedBlackNode b1 = redBlackTree.createNode(new Float(10), null, b3, b2, false);

            return new RedBlackTree(b1, comparator);
        }else if(type.equalsIgnoreCase("string1")){
            RedBlackTree.RedBlackNode b10 = redBlackTree.createNode("15", null, true);
            RedBlackTree.RedBlackNode b9 = redBlackTree.createNode("25", null, true);
            RedBlackTree.RedBlackNode b7 = redBlackTree.createNode("4", null, true);
            RedBlackTree.RedBlackNode b6 = redBlackTree.createNode("23", null, b10, b9, false);
            RedBlackTree.RedBlackNode b5 = redBlackTree.createNode("56", null, false);
            RedBlackTree.RedBlackNode b4 = redBlackTree.createNode("5", null, b7, null, false);
            RedBlackTree.RedBlackNode b8 = redBlackTree.createNode("1", null, false);
            RedBlackTree.RedBlackNode b2 = redBlackTree.createNode("32", null, b6, b5, true);
            RedBlackTree.RedBlackNode b3 = redBlackTree.createNode("3", null, b8, b4, true);
            RedBlackTree.RedBlackNode b1 = redBlackTree.createNode("10", null, b3, b2, false);

            return new RedBlackTree(b1, comparator);
        }else if(type.equalsIgnoreCase("string2")){
            //
             RedBlackTree.RedBlackNode b1 = redBlackTree.createNode("f", null, true);
             RedBlackTree.RedBlackNode b2 = redBlackTree.createNode("p", null, true);
             RedBlackTree.RedBlackNode b3 = redBlackTree.createNode("r", null, true);
             RedBlackTree.RedBlackNode b4 = redBlackTree.createNode("a", null, false);
             RedBlackTree.RedBlackNode b5 = redBlackTree.createNode("i", null, b1, null, false);
             RedBlackTree.RedBlackNode b6 = redBlackTree.createNode("q", null, b2, null, false);
             RedBlackTree.RedBlackNode b7 = redBlackTree.createNode("t", null, b3, null, false);
             RedBlackTree.RedBlackNode b8 = redBlackTree.createNode("d", null, b4, b5, true);
             RedBlackTree.RedBlackNode b9 = redBlackTree.createNode("r", null, b6, b7, true);
             RedBlackTree.RedBlackNode root = redBlackTree.createNode("m", null, b8, b9, false);
            return new RedBlackTree(root, comparator);
        }
        else{
            return null;
        }




    }

    public static BinaryTree createInsertBTree(String type, Comparator comparator){
        //        3, 5, 1, 10, 25, 56, 32, 4, 23, 15
        if(type.equalsIgnoreCase("integer1")) {
            BinaryTree binaryTree = new BinaryTree(comparator);
            binaryTree.insertValue(3, null);
            binaryTree.insertValue(5, null);
            binaryTree.insertValue(1, null);
            binaryTree.insertValue(10, null);
            binaryTree.insertValue(25, null);
            binaryTree.insertValue(56, null);
            binaryTree.insertValue(32, null);
            binaryTree.insertValue(4, null);
            binaryTree.insertValue(23, null);
            binaryTree.insertValue(15, null);
            return binaryTree;
        }else if(type.equalsIgnoreCase("float1")) {
            BinaryTree binaryTree = new BinaryTree(comparator);
            binaryTree.insertValue(new Float(3), null);
            binaryTree.insertValue(new Float(5), null);
            binaryTree.insertValue(new Float(1), null);
            binaryTree.insertValue(new Float(10), null);
            binaryTree.insertValue(new Float(25), null);
            binaryTree.insertValue(new Float(56), null);
            binaryTree.insertValue(new Float(32), null);
            binaryTree.insertValue(new Float(4), null);
            binaryTree.insertValue(new Float(23), null);
            binaryTree.insertValue(new Float(15), null);
            return binaryTree;
        }else if(type.equalsIgnoreCase("string1")) {
            BinaryTree binaryTree = new BinaryTree(comparator);
            binaryTree.insertValue("3", null);
            binaryTree.insertValue("5", null);
            binaryTree.insertValue("1", null);
            binaryTree.insertValue("10", null);
            binaryTree.insertValue("25", null);
            binaryTree.insertValue("56", null);
            binaryTree.insertValue("32", null);
            binaryTree.insertValue("4", null);
            binaryTree.insertValue("23", null);
            binaryTree.insertValue("15", null);
            return binaryTree;
        }else if(type.equalsIgnoreCase("string2")) {
            BinaryTree binaryTree = new BinaryTree(comparator);
            binaryTree.insertValue("n", null);
            binaryTree.insertValue("p", null);
            binaryTree.insertValue("d", null);
            binaryTree.insertValue("t", null);
            binaryTree.insertValue("o", null);
            binaryTree.insertValue("w", null);
            binaryTree.insertValue("b", null);
            binaryTree.insertValue("l", null);
            binaryTree.insertValue("r", null);
            binaryTree.insertValue("a", null);
            return binaryTree;
        }else{
            return null;
        }
    }

    public static RedBlackTree createInsertRedBlackTree(String type, Comparator comparator){
        //        3, 5, 1, 10, 25, 56, 32, 4, 23, 15
        if(type.equalsIgnoreCase("integer1")) {
            RedBlackTree redBlackTree = new RedBlackTree(comparator);
            redBlackTree.insertValue(3, null);
            redBlackTree.insertValue(5, null);
            redBlackTree.insertValue(1, null);
            redBlackTree.insertValue(10, null);
            redBlackTree.insertValue(25, null);
            redBlackTree.insertValue(56, null);
            redBlackTree.insertValue(32, null);
            redBlackTree.insertValue(4, null);
            redBlackTree.insertValue(23, null);
            redBlackTree.insertValue(15, null);
            return redBlackTree;
        }else if(type.equalsIgnoreCase("float1")) {
            RedBlackTree redBlackTree = new RedBlackTree(comparator);
            redBlackTree.insertValue(new Float(3), null);
            redBlackTree.insertValue(new Float(5), null);
            redBlackTree.insertValue(new Float(1), null);
            redBlackTree.insertValue(new Float(10), null);
            redBlackTree.insertValue(new Float(25), null);
            redBlackTree.insertValue(new Float(56), null);
            redBlackTree.insertValue(new Float(32), null);
            redBlackTree.insertValue(new Float(4), null);
            redBlackTree.insertValue(new Float(23), null);
            redBlackTree.insertValue(new Float(15), null);
            return redBlackTree;
        }else if(type.equalsIgnoreCase("string1")) {
            RedBlackTree redBlackTree = new RedBlackTree(comparator);
            redBlackTree.insertValue("3", null);
            redBlackTree.insertValue("5", null);
            redBlackTree.insertValue("1", null);
            redBlackTree.insertValue("10", null);
            redBlackTree.insertValue("25", null);
            redBlackTree.insertValue("56", null);
            redBlackTree.insertValue("32", null);
            redBlackTree.insertValue("4", null);
            redBlackTree.insertValue("23", null);
            redBlackTree.insertValue("15", null);
            return redBlackTree;
        }else if(type.equalsIgnoreCase("string2")) {
            RedBlackTree redBlackTree = new RedBlackTree(comparator);
            redBlackTree.insertValue("n", null);
            redBlackTree.insertValue("p", null);
            redBlackTree.insertValue("d", null);
            redBlackTree.insertValue("t", null);
            redBlackTree.insertValue("o", null);
            redBlackTree.insertValue("w", null);
            redBlackTree.insertValue("b", null);
            redBlackTree.insertValue("l", null);
            redBlackTree.insertValue("r", null);
            redBlackTree.insertValue("a", null);
            return redBlackTree;
        }else{
            return null;
        }
    }
}
