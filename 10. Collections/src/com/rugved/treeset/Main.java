package com.rugved.treeset;

import java.util.TreeSet;
// * In PriorityQueue, ArrayDequeue and TreeSet Index based Insetion is not allowed 

// * This TreeSet Data Structure belongs to Family of Set, It can create Balanced Binary Search Tree also and Skewed Tree Also
// * Before adding any element, it checks the value with the value from the top most node, and lower value gets placed at left side and higher one at right side
// * TreeSet Follows InOrder Traversal
// * Duplicate Objects are not allowed in TreeSet

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, treeset");

    TreeSet treeSet = new TreeSet<>();
    treeSet.add(100);
    treeSet.add(200);
    treeSet.add(700);
    treeSet.add(50);
    treeSet.add(70);
    treeSet.add(120);
    treeSet.add(175);
    treeSet.add(130);
    System.out.println(treeSet);    //  * [50, 70, 100, 120, 130, 175, 200, 700]
  }
};