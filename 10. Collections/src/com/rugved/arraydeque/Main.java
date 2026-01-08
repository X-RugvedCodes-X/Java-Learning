package com.rugved.arraydeque;

import java.util.ArrayDeque;

// * Insertion in between is not allowed in ArrayDeque as it implements Queue Interface, Only insertion at first and last is allowed

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, arraydeque");
    ArrayDeque arrayDeque = new ArrayDeque<>();
    arrayDeque.add(10);
    arrayDeque.add(12);
    arrayDeque.add("Rugved");
    arrayDeque.add("Raorane");
    // System.out.println(arrayDeque);   // * [10, 12, Rugved, Raorane]

    // !  Insertion in between is not allowed in ArrayDeque as it implements Queue Interface, Only insertion at first and last is allowed
    arrayDeque.addFirst("Java");
    arrayDeque.addFirst("SpringBoot");
    System.out.println(arrayDeque);     // * [SpringBoot, Java, 10, 12, Rugved, Raorane]
  }
}