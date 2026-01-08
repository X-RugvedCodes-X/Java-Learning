package com.rugved.priorityqueue;

import java.util.PriorityQueue;

// * Uses Min-Heap Data Structure under the hood, which means after every consequent addition, it compares the values of upper and lower node and priotitizes the lower value at the upper node level

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, priorityqueue");
    PriorityQueue priorityQueue = new PriorityQueue<>();
    priorityQueue.add(100);
    priorityQueue.add(200);
    priorityQueue.add(700);
    priorityQueue.add(50);
    priorityQueue.add(70);
    priorityQueue.add(120);
    priorityQueue.add(175);
    priorityQueue.add(130);

    // System.out.println(priorityQueue.getClass().getName());
    System.out.println(priorityQueue);    // * [50, 70, 120, 130, 100, 700, 175, 200]
  }
};