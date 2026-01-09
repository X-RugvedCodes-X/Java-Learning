package com.rugved.collectionutilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, collectionutilities");
    ArrayList<Integer> arrayList1 = new ArrayList<>();
    arrayList1.add(100);
    arrayList1.add(50);
    arrayList1.add(150);
    arrayList1.add(70);
    arrayList1.add(120);
    System.out.println(arrayList1);
    // Collections.sort(arrayList1);
    arrayList1.sort(null);
    System.out.println(arrayList1);

    seperator();

    ArrayList<String> arrayList2 = new ArrayList<>();
    arrayList2.add("Rugved");
    arrayList2.add("Java");
    arrayList2.add("Spring");
    arrayList2.add("SpringBoot");
    arrayList2.add("Microservices");
    arrayList2.add("Docker");
    System.out.println(arrayList2);
    arrayList2.sort(null);
    System.out.println(arrayList2);

    seperator();

    ArrayList<Cricketer> cricketers = new ArrayList<Cricketer>();
    cricketers.add(new Cricketer("Sachin", 30, 90.99));
    cricketers.add(new Cricketer("Virat", 20, 80.99));
    cricketers.add(new Cricketer("Dhoni", 50, 10.34));
    System.out.println("Before Sorting");
    printArrayList(cricketers);
    // * Custom Sorting Class And Method
    // SortCustomObjsInArrayList sortCustomObjects = new SortCustomObjsInArrayList();
    // cricketers.sort(sortCustomObjects);
    // System.out.println("After Sorting");
    // printArrayList(cricketers);

    // * Anonymous Inner Class
    // Comparator<Cricketer> sortCricketersOnAverage = new Comparator<Cricketer>() {
    //   @Override
    //   public int compare(Cricketer c1, Cricketer c2) {
    //     if(c1.average > c2.average)
    //       return 1;
    //     else 
    //       return -1;
    //   }
    // };
    // cricketers.sort(sortCricketersOnAverage);
    // System.out.println("After Sorting");
    // printArrayList(cricketers);

    // * Lambda Expressions
    // * New Java 11 Feature Instead of mentioning actual type, var can be used
    // Comparator<Cricketer> sortCricketersOnAverage = (var c1, var c2) -> {   
    //   if(c1.average > c2.average)
    //     return 1;
    //   else 
    //     return -1;
    // };

    // * Chad Way - Java 11
    // Comparator<Cricketer> sortCricketersOnAverage = (var c1, var c2) -> c1.average > c2.average ? 1 : -1;
    // cricketers.sort(sortCricketersOnAverage);
    // System.out.println("After Sorting");
    // printArrayList(cricketers);

    // * On Using Comparable No need to Create Another Method like we Do in Comparator. Comparable will do natural order sorting by itself.
    cricketers.sort(null);
    System.out.println("After Sorting");
    printArrayList(cricketers);

    seperator();

    
  } 

  private static void seperator() {
    System.out.println("\n" + "*".repeat(60) + "\n");
  }

  private static <T> void printArrayList(ArrayList<T> arrayList) {
    for (T element : arrayList) {
      System.out.println(element);
    }
  }
}