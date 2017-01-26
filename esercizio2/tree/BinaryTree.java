package src.esercizio2.tree;

import src.esercizio2.object.Record;
import java.util.Comparator;

public class BinaryTree<K,R> extends Tree<K,R> {

  public  BinaryNode root;
  public Comparator comparator;

  public BinaryTree(Comparator comp) {
    this.root = null;
    this.comparator = comp;
  }

  public BinaryTree(BinaryNode root, Comparator comp) {
    this.root = root;
    this.comparator = comp;
  }

  public BinaryNode getRoot() {
    return this.root;
  }

  public Comparator getComparator() {
    return this.comparator;
  }

  public BinaryNode getMaxNode(BinaryNode node) {
    if (node == null) return null;
    if(node.getRight() == null) {
      return node;
    } else {
      return getMaxNode(node.getRight());
    }
  }

  public BinaryNode getMinNode(BinaryNode node) {
    //if (node == null) return null;
    if(node.getLeft() == null) {
      return node;
    } else {
      return getMinNode(node.getLeft());
    }
  }

	/**
	* wrapper method for insert. It creates a new Binarynode and insert it into
	* the BinaryTree thanks to insert method.
	*/
  public void insertValue(K key, R value) {
    BinaryNode<K, Record> node = new BinaryNode(key, value);
    if (this.root == null) {
      this.root = node;
    } else {
      insert(node, this.root);
    }
  }

  /**
  * insert method: if the new node has the same value of an existing node
  * the method call binaryNode's setKey() method
  */
  private void insert(BinaryNode node, BinaryNode levelNode) {
    int compare = comparator.compare(node.getKey(), levelNode.getKey());
    if(compare < 0) {
      if (levelNode.getLeft() ==  null) {
        levelNode.setLeft(node);
      } else {
        insert(node, levelNode.getLeft());
      }
    } else if (compare > 0){
      if (levelNode.getRight() == null) {
        levelNode.setRight(node);
      } else {
        insert(node, levelNode.getRight());
      }
    } else levelNode.setValue(node.getValue());
  }



  public Boolean search(K key) {
    if(root == null)
      return false;
    else
      return root.nodeSearch(key, this.comparator);
  }

  private BinaryNode deleteMin(BinaryNode node) {
    if(node.getLeft() == null) {
      return node.getRight();
    }
    node.setLeft(deleteMin(node.getLeft()));
    return node;
  }

  private BinaryNode deleteMax(BinaryNode node) {
    if(node.getRight() == null) {
      return node.getLeft();
    }
    node.setRight(deleteMax(node.getRight()));
    return node;
  }

  public void delete(K key) {
    this.root = deleteRic(key, this.root);
  }

  public BinaryNode deleteRic(K key, BinaryNode node) {
    if (node == null) return null;
    int compare = comparator.compare(key, node.getKey());
    if(compare > 0) {
      node.setRight(deleteRic(key, node.getRight()));
    } else if(compare < 0) {
      node.setLeft(deleteRic(key, node.getLeft()));
    } else {
      if(node.isLeaf()) return null;
      if(node.getRight() == null) {
        return node.getLeft();
      }
      if(node.getLeft() == null) {
        return node.getRight();
      }
      BinaryNode<K, Record>  temp = node;
//      node = getMinNode(temp.getRight());
//      node.setRight(deleteMin(temp.getRight()));
//      node.setLeft(temp.getLeft());

//      TODO ELIA: I TEST FUNZIONANO CON QUESTO PEZZO
      node = getMaxNode(temp.getLeft());
      node.setLeft(deleteMax(temp.getLeft()));
      node.setRight(temp.getRight());
    }
    return node;
  }

  public int maxLevel(){
    if(root != null){
      return 1+root.calcolaLivello();
    }
    return 0;
  }

  public int contaNodi() {
    if(root == null)
      return 0;
    else
      return root.contaNodi();

  }

  public void binPreorder () {
    if (root != null) {
      System.out.print("preorder:   ");
      root.nodePreorder();
      System.out.println("");
    }
    else System.out.println("l'albero non contiene nodi!");
  }

  public String binPreorderString () {
    if (root != null) {
      return root.nodePreorderString();
    }
    else return "l'albero non contiene nodi!";
  }

  public void binInorder () {
    if (root != null) {
      System.out.print("inorder:   ");
      root.nodePreorder();
      System.out.println("");
    }
    else System.out.println("l'albero non contiene nodi!");
  }

  public void display() {
    display(root, 0);
  }

  private void display(BinaryNode node, int k) {
    if(node != null) {
      display(node.right, k+1);
      for(int i = 0; i < k; i++) System.out.print("   ");
      System.out.println(node.getKey());
      display(node.left, k+1);
    }
  }



}
