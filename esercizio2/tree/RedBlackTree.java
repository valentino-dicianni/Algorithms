package src.esercizio2.tree;

import java.util.Comparator;

public class RedBlackTree <K,R> extends Tree<K,R> {

  private static final boolean RED   = true;
  private static final boolean BLACK = false;

  public RedBlackNode root;
  public Comparator comparator;

  /**
   *  inner class for Node's implementation
   */
  public class RedBlackNode<K, R> {
    private K key;
    private R value;
    private boolean color;
    private RedBlackNode <K, R> left;
    private RedBlackNode <K, R> right;

    /*CONSTRUCTORS*/
    public RedBlackNode() {
      this.left = null;
      this.right = null;
    }

    public RedBlackNode(K key, R value) {
      this.key = key;
      this.value = value;
      this.color = RED;
      this.left = null;
      this.right = null;
    }

    public RedBlackNode(K key, R value, RedBlackNode left, RedBlackNode right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public RedBlackNode(K key, R value, boolean color) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.left = null;
      this.right = null;
    }

    public RedBlackNode(K key, R value, RedBlackNode left, RedBlackNode right, boolean color) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.left = left;
      this.right = right;
    }
  }

  public RedBlackTree(Comparator comp) {
    this.root = null;
    this.comparator = comp;
  }

  public RedBlackTree(RedBlackNode root, Comparator comp) {
    this.root = root;
    this.comparator = comp;
  }

  private Boolean isRed(RedBlackNode node) {
    if (node == null) return false;
    return node.color == RED;
  }

  public void insertValue(K key, R value) {
  	if (key == null) return;
  	root = insert(root, key, value);
    root.color = BLACK;
  }


  /**
   * INSERT METHOD: insert the key-value pair in the subtree rooted at node
   */

   private RedBlackNode insert(RedBlackNode node, K key, R value) {
    if (node == null) return new RedBlackNode(key, value);
    int compare = comparator.compare(key, node.key);

    if (compare < 0) node.left = insert(node.left, key, value);
    else if (compare > 0) node.right = insert(node.right, key, value);
    else node.value = value;
      if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
      if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
      if (isRed(node.left) && isRed(node.right)) flipColors(node);

    return node;
  }

  /**
   * SEARCH METHOD
   */

  public Boolean search(K key) {
    if (key == null)return false;
    return searchNode(this.root, key);
  }

  private Boolean searchNode(RedBlackNode node, K key) {
    while (node != null) {
      int compare =  comparator.compare(key, node.key);
      if (compare < 0) node = node.left;
      else if (compare > 0) node = node.right;
      else return true;
    }
    return false;
  }

  /**
   *  DELETE method
   */

  public void delete(K key) {
  	if (key == null) return;
  	//if (!contains(key)) return;
    if(this.root == null) return;
  	if (!isRed(this.root.left) && !isRed(this.root.right))
  		this.root.color = RED;
  	this.root = deleteRic(this.root, key);
  	if (this.root != null) this.root.color = BLACK;
  }

  // delete the key-value pair with the given key rooted at h
  public RedBlackNode deleteRic(RedBlackNode node, K key) {
  	// assert get(h, key) != null;
    if (node == null) return null;
  	if (comparator.compare(key, node.key) < 0) {
  		if (!isRed(node.left) && !isRed(node.left!=null ? node.left.left : null))
  			node = moveRedLeft(node);
  		node.left = deleteRic(node.left, key);
  	}
  	else {
  		if (isRed(node.left))
  			node = rotateRight(node);
  		if (comparator.compare(key, node.key) == 0 && (node.right == null))
  			return null;
  		if (!isRed(node.right) && !isRed(node.right!=null ? node.right.left : null))
  			node = moveRedRight(node);
  		if (comparator.compare(key, node.key) == 0) {
  			RedBlackNode x = getMin(node.right);
  			node.key = x.key;
  			node.value = x.value;
  			node.right = deleteMin(node.right);
  		}
  		else node.right = deleteRic(node.right, key);
  	}
  	return balance(node);
  }

  /**
   * HELPER METHOD
   */

  public RedBlackNode rotateRight(RedBlackNode node) {
    // assert (h != null) && isRed(h.left);
    if (node == null) return null;
    RedBlackNode x = node.left;
    node.left = x.right;
    x.right = node;
    x.color = x.right.color;
    x.right.color = RED;
    return x;
  }

  // make a right-leaning link lean to the left
  public RedBlackNode rotateLeft(RedBlackNode node) {
    // assert (h != null) && isRed(h.right);
    if (node == null) return null;
    RedBlackNode x = node.right;
    node.right = x.left;
    x.left = node;
    x.color = x.left.color;
    x.left.color = RED;
    return x;
  }

  // flip the colors of a node and its two children
  public void flipColors(RedBlackNode node) {
    // h must have opposite color of its two children
    // assert (h != null) && (h.left != null) && (h.right != null);
    // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
    //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
    if (node == null) return;
    node.color = !node.color;
    if (node.left != null) node.left.color = !node.left.color;
    if (node.right != null) node.right.color = !node.right.color;
  }

  // Assuming that node is red and both node.left and node.left.left
  // are black, make node.left or one of its children red.
  public RedBlackNode moveRedLeft(RedBlackNode node) {
    // assert (h != null);
    // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);
    if (node == null) return null;
    flipColors(node);
    if (node.right!=null ? isRed(node.right.left) : false) {
      node.right = rotateRight(node.right);
      node = rotateLeft(node);
      flipColors(node);
    }
    return node;
  }

  // Assuming that node is red and both node.right and node.right.left
  // are black, make node.right or one of its children red.
  public RedBlackNode moveRedRight(RedBlackNode node) {
    // assert (h != null);
    // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
    if (node == null) return null;
    flipColors(node);
    if (node.left!=null ? isRed(node.left.left) : false) {
      node = rotateRight(node);
      flipColors(node);
    }
    return node;
  }

  // the smallest key in subtree rooted at x; null if no such key
  public RedBlackNode getMin(RedBlackNode node) {
    // assert x != null;
    if (node.left == null) return node;
    else return getMin(node.left);
  }

   // Removes the smallest key and associated value from the symbol table.
  public RedBlackNode deleteMin(RedBlackNode node) {
    if (node.left == null)
      return null;

    if (!isRed(node.left) && !isRed(node.left.left))
      node = moveRedLeft(node);

    node.left = deleteMin(node.left);
    return balance(node);
  }

  // restore red-black tree invariant
  public RedBlackNode balance(RedBlackNode node) {
    // assert (h != null);

    if (isRed(node.right))
      node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left))
      node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right))
      flipColors(node);
    return node;
  }

  public int contaNodi() {
    if(this.root == null) return 0;
    return contaNodi(this.root);
  }
  private int contaNodi(RedBlackNode node) {
    int result = 1;
    if (node.right != null)
      result += contaNodi(node.right);
    if (node.left != null)
      result += contaNodi(node.left);
    return result;
  }

  public int maxLevel(){
    if(root != null){
      return 1 + calcolaLivello(this.root);
    }
    return 0;
  }

  public int calcolaLivello(RedBlackNode node){
    if(node.right != null && node.left != null){
      int contRight = calcolaLivello(node.right);
      int contLeft = calcolaLivello(node.left);

      if(contRight > contLeft)
        return 1+contRight;
      else return 1+contLeft;
    }
    else if(node.right != null)return 1 + calcolaLivello(node.right);
    else if(node.left != null)return 1 + calcolaLivello(node.left);
    return 0;
  }

  public RedBlackNode createNode(K key, R value, boolean color){
    return new RedBlackNode(key, value, color);
  }

  public RedBlackNode createNode(K key, R value, RedBlackNode left, RedBlackNode right, boolean color){
    return new RedBlackNode(key, value, left, right, color);
  }


  public String nodePreorderString (RedBlackNode node) {
    String left = "";
    String right = "";
    if (node.left != null) left = " "+nodePreorderString(node.left);
    if (node.right != null) right = " "+nodePreorderString(node.right);
    return node.key +(node.color ? "-R" : "-N") + left + right;
  }

  public boolean isLeaf(RedBlackNode node) {
    return node.right == null && node.left == null;
  }

  public void display() {
    display(this.root, 0);
  }

  private void display(RedBlackNode node, int k) {
    if(node != null) {
      display(node.right, k+1);
      for(int i = 0; i < k; i++) System.out.print("   ");
      System.out.println(node.key+"("+(node.color ? "R" : "N")+")");
      display(node.left, k+1);
    }
  }
}
