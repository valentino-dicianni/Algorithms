package src.esercizio2.tree;


import java.util.Comparator;


public class BinaryNode<K, R> {

  K key;
  R value;
  BinaryNode <K, R> left;
  BinaryNode <K, R> right;

  /*CONSTRUCTORS*/
  public BinaryNode() {
    this.left = null;
    this.right = null;
  }

  public BinaryNode(K key, R value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public BinaryNode(K key, R value, BinaryNode left, BinaryNode right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  /*GETTER E SETTER*/
  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public R getValue() {
    return this.value;
  }

  public void setValue(R value) {
    this.value = value;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }
  /*END GETTER E SETTER*/


  public Boolean isLeaf() {
    return this.left == null && this.right == null;
  }


  public void nodePreorder () {
    System.out.print(this.getKey() + " ");
    if (left != null) left.nodePreorder();
    if (right != null) right.nodePreorder();
  }

  public String nodePreorderString () {
    String left = "";
    String right = "";
    if (this.left != null) left = " "+this.left.nodePreorderString();
    if (this.right != null) right = " "+this.right.nodePreorderString();
    return this.getKey() + left + right;
  }
	
  /**
   * nodeSearch helper method. It search the node on the value field
   */
  public boolean nodeSearch(K key, Comparator comparator) {
    boolean leftB = false, rightB = false;
    int compare = comparator.compare(this.key, key);
    if(compare == 0) {
      return true;
    }
    else {
      if(compare > 0 && left != null)
        leftB = left.nodeSearch(key, comparator);
      if(compare < 0 && right != null)
       rightB = right.nodeSearch(key, comparator);
      return (leftB || rightB);
    }
  }

  /**
   * calcolaLivello herlper method. It calculate the max tree level
   */
  public int calcolaLivello(){
    if(right != null && left != null){
      int contRight = right.calcolaLivello();
      int contLeft = left.calcolaLivello();

      if(contRight > contLeft)
        return 1+contRight;
      else return 1+contLeft;
    }
    else if(right != null)return 1+right.calcolaLivello();
    else if(left != null)return 1+left.calcolaLivello();
    return 0;
  }

  public int contaNodi() {
    int result = 1;
    if (right != null)
      result += right.contaNodi();
    if (left != null)
      result += left.contaNodi();
    return result;


  }



}