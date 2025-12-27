package com.rugved.arrays;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListBasics {
  public static void main(String[] args) {
    // ArrayList<Integer> al = new ArrayList<Integer>(10);
    // al.add(10);
    // al.add(10);
    // al.add(10);
    // al.add(8);
    // al.add(10);
    // al.add(16);
    // al.add(167);
    // al.add(50);
    // al.add(760);
    // al.add(103);
    // al.add(10);
    // System.out.println(al + "\n");

    // al.set(0, 3);
    // System.out.println(al + "\n");

    // al.remove(3);
    // System.out.println(al + "\n");

    // int element = al.get(3);  // Subscript Operator arr[i] doesnot work here.
    // System.out.println(element);

    //* Multidimensional ArrayList */
    ArrayList<ArrayList<Integer>> multiArrayList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < 3; ++i) {
      multiArrayList.add(new ArrayList<Integer>());
    }
    Scanner sc = new Scanner(System.in);
    try {
      for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
          multiArrayList.get(i).add(sc.nextInt());
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Please Enter Intergers Only.");
    } finally {
      sc.close();
    }
    System.out.println(multiArrayList);
    
  }
}