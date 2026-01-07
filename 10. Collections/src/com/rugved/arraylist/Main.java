package com.rugved.arraylist;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");

    ArrayList arrayList1 = new ArrayList();
    arrayList1.add(100);
    arrayList1.add("Rugved");
    arrayList1.add('r');
    arrayList1.add(true);
    arrayList1.add(44.5);
    // * [100, Rugved, r, true, 44.5]
    

    ArrayList arrayList2 = new ArrayList();
    arrayList2.add(10);
    arrayList2.add(20);
    arrayList2.add(0, 5);
    arrayList2.addAll(arrayList1);
    // * [5, 10, 20, 100, Rugved, r, true, 44.5]


    // ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
    // arrayList1.add(100);
    // arrayList1.add(200);
    // arrayList1.add(300);
    // arrayList1.add(400);

    System.out.println(arrayList1);
    System.out.println(arrayList2);
  }
};