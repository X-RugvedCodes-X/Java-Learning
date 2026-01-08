package com.rugved.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// * A Legacy Data Structure in Java which was part of Enumeration Interface First and then Added to the List Family Interface
// * public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable


public class Main {
  public static void main(String[] args) {
    System.out.println("hello, vector !");
    Vector v = new Vector<>();
    // * Both addElement and add method to the same work
    v.addElement(100);
    v.add(200);
    v.add(300);
    v.addElement(400);

    // Iterator i = v.iterator();
    // while (i.hasNext()) {
    //   System.out.print(i.next() +  " ");
    // }
    // System.out.println();

    // * Enumeration does the same job as above iterator is doing
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.print(e.nextElement() + " ");
    }
    System.out.println();
  }
};