package com.rugved.hashset;

import java.util.HashSet;
// * Elements are stored in HashTable with a LoadFactor of 0.75
// * Order of Elements Stored is not confirmed
// * Duplicates are not allowed
public class Main {
  public static void main(String[] args) {
    System.out.println("hello, hashset !");
    HashSet<Integer> hashSet = new HashSet<>();
    hashSet.add(100);
    hashSet.add(150);
    hashSet.add(175);
    hashSet.add(35);
    hashSet.add(75);
    hashSet.add(50);
    hashSet.add(175);   // * Duplicates Not allowed
    System.out.println(hashSet);    // * [50, 35, 100, 150, 75, 175]
    
  }
};