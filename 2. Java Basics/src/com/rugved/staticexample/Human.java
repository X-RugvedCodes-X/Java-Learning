package com.rugved.staticexample;

public class Human {
  String name;
  int age, salary;
  boolean isMarried;

  static long population;

  //* Runs Only once when the class is loaded. */
  static {
    population  = 0;
  }

  public Human(String name, int age, int salary, boolean isMarried) {
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.isMarried = isMarried;
    population++;
  }

  public void display() {
    System.out.println("Name: "               + this.name);
    System.out.println("Age:  "               + this.age);
    System.out.println("Salary: "             + this.salary);
    System.out.println("isMarried: "          + this.isMarried);
    System.out.println("Population Counter: " + population);
  }
};