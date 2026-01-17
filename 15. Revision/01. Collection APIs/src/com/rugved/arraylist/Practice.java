package com.rugved.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Practice {
  public static void practice() {
    
    // * Initialization Ways of An ArrayList
    ArrayList<Integer> arrayList1 = new ArrayList<>();   // * Default Capacity is 10
    arrayList1.add(1);
    arrayList1.add(2);
    arrayList1.add(3);
    printArrayList(arrayList1);
    
    // * ArrayList from Integer Arrays
    ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    printArrayList(arrayList2);
    System.out.println(arrayList2.getClass().getName());

    ArrayList<Integer> arrayList3 = new ArrayList<>(List.of(1, 2, 3, 4));
    printArrayList(arrayList3);
    System.out.println(arrayList3.getClass().getName());

    // * ArrayList from Primitive Arrays
    int[] arr = {0, 6, -2, 10, 43, 65, 100};
    // ArrayList<Integer> arrayList4 = new ArrayList<>(Arrays.asList(arr));   // ! Doesnot Work
    ArrayList<Integer> arrayList4 = Arrays.stream(arr).
                                          boxed().
                                          collect(Collectors.toCollection(ArrayList::new));
    printArrayList(arrayList4);
    // * Or
    ArrayList<Integer> arrayList5 = new ArrayList<>();
    for(int x : arr) {
      arrayList5.add(x);
    }
    printArrayList(arrayList5);

  }

  private static <T> void printArrayList(List<T> arrayList) {
    System.out.println(arrayList);
  }
}