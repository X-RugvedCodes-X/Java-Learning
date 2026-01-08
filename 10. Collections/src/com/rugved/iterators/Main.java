package com.rugved.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, iterators");

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(100);
    arrayList.add(200);
    arrayList.add(300);
    arrayList.add(400);
    arrayList.add(500);

    // Iterator<Integer> i1 = arrayList.iterator();
    // while(i1.hasNext()) {
    //   System.out.print(i1.next() + " ");
    // }
    // System.out.println();

    // while(i1.hasNext()) {
    //   System.out.print(i1.next() + " ");
    //   arrayList.add(20);          
    //   // * If this is done in normal for loop then it goes on till Stack Overflow (No Exception is Reported) but using iterators and writing hasNext and next in such a way, then it returns Exception which is good, So in Case of Iterators JVM Understands Concurrent Modifications
    //   // * Exception in thread "main" java.util.ConcurrentModificationException
    //   // * This is called fail-fast - this means concurrent modification is stopped but exception is generated
    // }
    // System.out.println();

    CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
    copyOnWriteArrayList.add(100);
    copyOnWriteArrayList.add(200);
    copyOnWriteArrayList.add(300);
    copyOnWriteArrayList.add(400);
    copyOnWriteArrayList.add(500);

    // Iterator<Integer> i2 = copyOnWriteArrayList.iterator();
    // while(i2.hasNext()) {
    //   System.out.print(i2.next() + " ");
    //   copyOnWriteArrayList.add(20);          
    //   // * Now Here we don't get any exception but the value 20 is also not added, this is called fail-safe case for the concurrent modification
    //   // * Mind you - to use fail-safe case use the CopyOnWrite Collections from the concurrent package
    // }
    // // * 100 200 300 400 500 
    // System.out.println();

    // * Similarly we even have ListIterators
    // ListIterator<Integer> listIterator = copyOnWriteArrayList.listIterator();
    // while (listIterator.hasNext()) {
    //   System.out.println(listIterator.next());
    // }
    
    // * Printing in Reverse Order
    ListIterator<Integer> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());  
    while (listIterator.hasPrevious()) {
      System.out.print(listIterator.previous() + " ");
    } // * 500 400 300 200 100 
    System.out.println();
    
  }
}
