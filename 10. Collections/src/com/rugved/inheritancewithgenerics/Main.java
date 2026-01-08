package com.rugved.inheritancewithgenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, inheritance in generics");
    // Object obj = new Object();
    // String str = new String("Dada");
    // obj = str;         // * Yes, Valid
    // str = obj;         // ! Invalid
    
    Human human = new Human();
    Student student = new Student();

    // human = student;      // * Yes, Valid
    // student = human;      // ! Invalid

    // * Human is Parent of Student
    // ArrayList<Human> humans = new ArrayList<Human>();
    // ArrayList<Student> students = new ArrayList<Student>();
    // humans = students;         // ! Invalid
    // students = humans;         // ! Invalid        

    // * WildCard Syntax
    // ArrayList<?> humans = new ArrayList<>();
    // ArrayList<Student> students = new ArrayList<Student>();
    // humans = students;      // * Valid

    // * Upperbound Syntax
    // ArrayList<? extends Human> humans = new ArrayList<>();    // * This means either Human or Child of Human, nothing other than that
    // ArrayList<Student> students = new ArrayList<>();
    // humans = students;        // * Valid
    // students = humans;        // ! Invalid
    
    // * Lowerbound Syntax
    // ArrayList<? super Human> humans = new ArrayList<>();      // * This means either Human or Parent of Human, nothing other than that
    // ArrayList<Student> students = new ArrayList<>();       
    // ArrayList<Employee> employees = new ArrayList<>();       
    // ArrayList<Object> objects = new ArrayList<>();       
    // humans = objects;     // * Only Valid Assignment

    // ArrayList<Human> humans = new ArrayList<>();
    // humans.add(new Human());
    // humans.add(new Human());
    // humans.add(new Human());
    // invokeDisplay(humans);

    // ArrayList<Student> students = new ArrayList<>();
    // students.add(new Student());
    // students.add(new Student());
    // students.add(new Student());
    // invokeDisplay(students);      // * No Error here, as in the argument we have used WildCard Upperbound Syntax

    // List<Integer> list1 = new ArrayList<>();
    // List<Integer> list2 = new LinkedList<>();   // * Here List as a Parent is Valid but we cannot access specialized method of LinkedList Class using the List Reference Interface

    // * Utility Class of Arrays to Create Collection
    // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    // * Other Ways to use Utility Class
    // int[] arr = {1, 2, 3, 4, 5};
    // List<int[]> list = Arrays.asList(arr);
    
    // ! InCorrect Way
    // int[] arr = {5, 1, 0, 2, 3, 4};
    // ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(arr));
    // arrayList.sort(null);
    // System.out.println(arrayList);    // * Prints: [[I@7e9e5f8a]

    // ^ Code to Convert normal Array into ArrayList and Now We can Use the Collections.sort() method on this arrayList
    int[] arr = {5, 1, 0, 2, 3, 4};
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int nums : arr) {
      arrayList.add(nums);
    }
    arrayList.sort(null);
    System.out.println(arrayList);
      
  };

  public static void invokeDisplay(List<? extends Human> list) {
    for (Human human : list) {
      System.out.print(human);
    }
  }

  public static Iterable<Integer> getCollection() {
    return new ArrayList<Integer>();    
    // return new List<Integer>();      // ! Why this Gives Error but other two dont give is because List is an Interface not a class, so it cannot be instantiated.
    // return new TreeSet<Integer>();    
  }

  public static List<Integer> getList() {
    // return new ArrayList<Integer>();
    return new LinkedList<Integer>();
  }
};