package com.company;

public class Node <T extends Number>{

    Node parent ;
    Node left ;
    Node right ;
    T value;


    public Node(Node parent, Node left, Node right, T value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
