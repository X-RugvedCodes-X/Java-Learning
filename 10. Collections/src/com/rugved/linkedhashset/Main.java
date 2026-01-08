package com.rugved.linkedhashset;

import java.util.LinkedHashSet;

// * Hashing + Order of Insertion Guranteed = LinkedHashSet

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, linkedhashset");
    LinkedHashSet linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add(100);
    linkedHashSet.add(150);
    linkedHashSet.add(175);
    linkedHashSet.add(35);
    linkedHashSet.add(75);
    linkedHashSet.add(50);
    linkedHashSet.add(175);   // * Duplicates Not allowed
    System.out.println(linkedHashSet);     // * [100, 150, 175, 35, 75, 50]
  }
};