package com.rugved.linkedlist;

import java.util.LinkedList;

// * The Advantage of Linkedlist over ArrayList is that it is suitable for insertion at any given position, due to it's node like structure
// * It follows DoublyLinkedList Data Structure

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, linkedlist !");
    LinkedList linkedList1 = new LinkedList<>();
    linkedList1.add(10);
    linkedList1.add(20.50);
    linkedList1.add("Java"); // * [10, 20.50, Java]
    // System.out.println(linkedList1);
    linkedList1.addFirst("Rugved");
    // System.out.println(linkedList1); // * [Rugved, 10, 20.5, Java]
    linkedList1.addLast("Raorane");
    // System.out.println(linkedList1);    // * [Rugved, 10, 20.5, Java, Raorane]

    linkedList1.add(2, "SpringBoot");
    // printLinkedList(linkedList1);   // * [Rugved, 10, SpringBoot, 20.5, Java, Raorane]
    linkedList1.offer("Microservices");
    linkedList1.offer("JUnit5");
    // printLinkedList(linkedList1);     // * [Rugved, 10, SpringBoot, 20.5, Java, Raorane, Microservices, JUnit5]
    linkedList1.offerFirst("Collections");
    // printLinkedList(linkedList1);       // * [Collections, Rugved, 10, SpringBoot, 20.5, Java, Raorane, Microservices, JUnit5]

    // * Difference b/w add and offer method in LinkedList is that:- 
    // * 1. add method will surely add the data till the total storage capacity of device availability.
    // * 2. offer method just makes a promise, the addition of element may get rejected based on the problem of memory. We aren't sure about that element is added or not

    // ^ peek() and poll() method
    System.out.println(linkedList1.peek());   // * Collections - just looks at the first object and returns it. (No Removal)
    printLinkedList(linkedList1);             // * [Collections, Rugved, 10, SpringBoot, 20.5, Java, Raorane, Microservices, JUnit5]
    System.out.println(linkedList1.poll());   // * Collections - removes the first object and returns it.
    printLinkedList(linkedList1);             // * [Rugved, 10, SpringBoot, 20.5, Java, Raorane, Microservices, JUnit5]


  }

  private static void printLinkedList(LinkedList linkedList) {
    System.out.println(linkedList);
  }
}