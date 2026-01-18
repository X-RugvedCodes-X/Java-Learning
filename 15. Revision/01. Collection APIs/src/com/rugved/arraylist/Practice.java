package com.rugved.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Practice {
  public static void practice() {
    
    // * Initialization Ways of An ArrayList
    ArrayList<Integer> arrayList1 = new ArrayList<>();   // * Default Capacity is 10
    arrayList1.add(1);
    arrayList1.add(2);
    arrayList1.add(3);
    // printArrayList(arrayList1);
    
    // * ArrayList from Integer Arrays
    ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    // printArrayList(arrayList2);
    // System.out.println(arrayList2.getClass().getName());

    ArrayList<Integer> arrayList3 = new ArrayList<>(List.of(1, 2, 3, 4));
    // printArrayList(arrayList3);
    // System.out.println(arrayList3.getClass().getName());

    // * ArrayList from Primitive Arrays
    int[] arr = {0, 6, -2, 10, 43, 65, 100};
    // ArrayList<Integer> arrayList4 = new ArrayList<>(Arrays.asList(arr));   // ! Doesnot Work
    ArrayList<Integer> arrayList4 = Arrays.stream(arr).
                                          boxed().
                                          collect(Collectors.toCollection(ArrayList::new));
    // printArrayList(arrayList4);
    // * Or
    ArrayList<Integer> arrayList5 = new ArrayList<>();
    for(int x : arr) {
      arrayList5.add(x);
    }
    // printArrayList(arrayList5);

    ArrayList<Integer> arrayList10 = new ArrayList<>(Collections.nCopies(10, Integer.valueOf(4)));
    // printArrayList(arrayList10);
    Collections.fill(arrayList10, 5);
    // printArrayList(arrayList10);

    // * ArrayList to Integer
    ArrayList<Integer> arrayList11 = new ArrayList<>(Arrays.asList(2, 8, 10, 5, 0, -8));
    Integer[] integerArray = arrayList11.toArray(new Integer[0]);
    
    // * ArrayList to primitive integer array
    ArrayList<Integer> arrayList12 = new ArrayList<>(Arrays.asList(19, 3, 15, 2, 0, -4));
    int[] newArr = arrayList12.stream()
                              .mapToInt(Integer::intValue)
                              .toArray();
    // for (int i : newArr) {
    //   System.out.println(i);
    // }



    // * One More Time Practice
    int[] arr1 = {8, 10, 4, 32, 11, -92};
    // ArrayList<Integer> arrayList13 = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
    // printArrayList(arrayList13);

    // * primitive array to Integer Array
    // Integer[] integerArray1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);

    // * ArrayList to Integer Array
    ArrayList<Integer> arrayList15 = new ArrayList<>(Arrays.asList(8, 10, 4, 32, 11, -92));
    Integer[] integerArray2 = arrayList15.toArray(new Integer[0]);

    // * ArrayList to Primitve Array
    int[] arr2 = arrayList15.stream().mapToInt(Integer::intValue).toArray();

  }

  private static <T> void printArrayList(List<T> arrayList) {
    System.out.println(arrayList);
  }
}