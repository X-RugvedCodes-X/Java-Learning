package com.rugved.comparable;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // * Comparable is nothing but a syntactical Sugar to be more explicit to the code reader that natural ordering is done
    // * compareTo method is overidded
    // * Comparable is way just to tell natural ordering, but for custom sorting logic we use comparator only (compare method is overrided in comparator)
    ArrayList<Student> arrayList1 = new ArrayList<>();
    arrayList1.add(new Student("Rugved", 9.09));
    arrayList1.add(new Student("Saunskar", 8.54));
    arrayList1.add(new Student("Dada", 9.24));
    arrayList1.sort(null);
    for (Student student : arrayList1) {
      System.out.println(student);
    }
  }
};
