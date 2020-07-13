package com.company;

import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImp();


        int a [] = {90,9,2,12,123,4335,12,33,0,1,-1,-1000,121,98,12,-110101};

        for (int i : a){
            tree.insert(i);
        }
        Number b = tree.min();
        System.out.println("===============================================********************=============================");
        System.out.println(b == null ? "No Items in the Tree Currently":"Minimum value inserted in the tree is :"+b);
        System.out.println("=================*****************===============================================================");
        Number max = tree.max();

        System.out.println(max == null ?"No Items are present in the tree currently " : "Maximum value present in the tree is :"+max);

    }
}