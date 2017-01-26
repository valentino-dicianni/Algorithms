package src.esercizio2.tree;


public abstract class Tree<K, R> {
    public abstract void insertValue(K key, R value);
    public abstract void delete(K key);
    public abstract Boolean search(K key);


}
