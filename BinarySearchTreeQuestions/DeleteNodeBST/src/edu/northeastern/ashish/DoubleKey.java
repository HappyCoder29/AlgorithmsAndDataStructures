package edu.northeastern.ashish;

public class DoubleKey<K extends Comparable<K>>
        implements Comparable<DoubleKey<K>> {

    private K key1;

    public DoubleKey(K key1) {
        this.key1 = key1;
    }

    public K getFirstKey() {
        return this.key1;
    }


    public int compareTo(DoubleKey<K> that) {

        return this.getFirstKey().compareTo(that.getFirstKey());
    }
}
