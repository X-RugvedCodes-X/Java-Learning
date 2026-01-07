package com.rugved.javabasics;

class Student {
  String name;
  int marks;

  Student(String name, int marks) {
    this.name   = name;
    this.marks  = marks;
  }
};

public class Array {
  public static void main(String[] args) {
    int arr1[] = new int[5];
    int arr2[][] = new int[3][3];
    int size = arr1.length;

    for (int i = 0; i < size; ++i) {
      System.out.println(arr1[i]);
    }

    for (int m : arr1) {
      System.out.println(m);
    }

    System.out.println("---------------------------");

    for (int n[] : arr2) {
      for (int m : n) {
        System.out.println(m);
      }
    }

    //* Jackass Arrays

    int arr3[][] = new int[3][];
    arr3[0] = new int[3];
    arr3[1] = new int[4];
    arr3[2] = new int[2];

    System.out.println("---------------------------");

    for (int n[] : arr3) {
      for (int m : n) {
        System.out.print(m + " ");
      }
      System.out.println();
    }

    Student s1 = new Student("Rugved",  80);
    Student s2 = new Student("Anuj",    88);

    Student students[] = new Student[2];
    students[0] = s1;
    students[1] = s2;

    for (Student student : students) {
      System.out.println(student.name + ", " + student.marks);
    }
  }
}