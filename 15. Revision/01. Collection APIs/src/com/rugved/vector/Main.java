package com.rugved.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

  public static void main(String[] args) {
    // System.out.println("hello, vector !");

    // * Other Than those pngs one more cool feature is that we can check the capacity
    // Vector<Integer> vector = new Vector<>();    // * By Default Capacity is 10
    // System.out.println(vector.capacity());

    // Vector<Integer> vector = new Vector<>(5, 3); // * If leaven Blank then initialCapacity is 10 and increament is double
    // vector.add(10);
    // vector.add(10);
    // vector.add(10);
    // vector.add(10);
    // vector.add(10);   // * 5 times done
    // System.out.println(vector.capacity());     // * 5
    // vector.add(10);   // * 6th Addition
    // System.out.println(vector.capacity());    // * 8
    // vector.add(10);   // * 7th Addition
    // vector.add(10);   // * 8th Addition
    // System.out.println(vector.capacity());    // * 8
    // vector.add(10);   // * 9th Addition
    // System.out.println(vector.capacity());    // * 11 (As increament by 3 is given)

    // * From LinkedList and ArrayList
    // LinkedList<Integer> linkedList = new LinkedList<>();
    // linkedList.add(1);
    // linkedList.add(2);
    // linkedList.add(3);
    // Vector<Integer> vector1 = new Vector<>(linkedList);
    // System.out.println(vector1);    // * [1, 2, 3]

    // Vector<Integer> vector2 = new Vector<>(Arrays.asList(2, 3, 4));
    // System.out.println(vector2);    // * [2, 3, 4]

    // * clear() in vector
    // vector2.clear();
    // System.out.println(vector2);    // * []
    // ^ clear() is also in LinkedList and ArrayList


    // * Thread Safety And Synchronization
    // ArrayList<Integer> list = new ArrayList<>();
    // Thread t1 = new Thread(() -> {
    //   for(int i = 0; i < 1000; ++i) {
    //     list.add(i);
    //   }
    // });
    // Thread t2 = new Thread(() -> {
    //   for(int i = 0; i < 1000; ++i) {
    //     list.add(i);
    //   }
    // });
    // t1.start();
    // t2.start();

    // try {
    //   t1.join();
    //   t2.join();
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // System.out.println("Size of List: " + list.size());   
    // ! Gives Random value like 1422, 1615, etc because not thread safe any thread can access abruptly and there is no synchronization

    // * Vector Resolves This Concern
    Vector<Integer> list = new Vector<>();
    Thread t1 = new Thread(() -> {
      for(int i = 0; i < 1000; ++i) {
        list.add(i);
      }
    });
    Thread t2 = new Thread(() -> {
      for(int i = 0; i < 1000; ++i) {
        list.add(i);
      }
    });
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Size of List: " + list.size()); // * 2000
  }
}