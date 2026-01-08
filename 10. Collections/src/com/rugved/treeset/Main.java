package com.rugved.treeset;

import java.util.TreeSet;
// * In PriorityQueue, ArrayDequeue and TreeSet Index based Insetion is not allowed 

// * This TreeSet Data Structure belongs to Family of Set, It can create Balanced Binary Search Tree also and Skewed Tree Also
// * Before adding any element, it checks the value with the value from the top most node, and lower value gets placed at left side and higher one at right side
// * TreeSet Follows InOrder Traversal
// * Duplicate Objects are not allowed in TreeSet
// * As Compared to ArrayList, ArrayDeque, LinkeList and PriotiyQueue, TreeSet is good for searching only and only if it forms Balanced Binary Search Tree, If a Skewed Tree is formed then the worst case is O(n) and normally in case of Balanced Binary Search Tree the Case is O(logn)
// * For the Searching Operation, the Best Data Structure is HashSet and LinkedHashSet from the Hash Table family. (Searching in O(1) time)

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

    // * ceiling method gives nearest highest value when the element is not present
    // * higher method will give value higher than the requested element, it won't check if the requested element is present or not
    // System.out.println(treeSet.ceiling(50));  // * 50
    // System.out.println(treeSet.higher(50));   // * 70

    // System.out.println(treeSet.ceiling(100));  // * 100
    // System.out.println(treeSet.higher(100));   // * 120

    // System.out.println(treeSet.ceiling(75));  // * 100
    // System.out.println(treeSet.higher(75));   // * 100

    // // * [50, 70, 100, 120, 130, 175, 200, 700]
    // System.out.println(treeSet.floor(60));    // * 50 - similar analogy to the ceiling and higher method
    // System.out.println(treeSet.lower(60));    // * 50

    System.out.println(treeSet.tailSet(100));   // * [100, 120, 130, 175, 200, 700]
    System.out.println(treeSet.headSet(100));     // * [50, 70]
  }
};