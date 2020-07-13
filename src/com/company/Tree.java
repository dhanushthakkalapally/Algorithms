package com.company;

public interface Tree<T extends Number> {

/**
 * This is a tree class and will currently perform insertion and deletion of the tree
 *
 * */
    public boolean insert(T value);

    public T delete(T value);

    public T min();

    public T max();




}
