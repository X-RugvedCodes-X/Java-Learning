package com.rugved.collectionutilities;

public class Cricketer implements Comparable<Cricketer> {   // * Instead of Comparator and Lambda Stuff we can even use Comparable on the target class itself, just override one method
  public String name;
  public int age;
  public double average;

  public Cricketer() {
    super();  
  }

  public Cricketer(String name, int age, double average) {
    this.name = name;
    this.age = age;
    this.average = average;
  }

  @Override
  public String toString() {
    return "Cricketer -> Name: " + this.name + ", Age: " + this.age + ", Average: " + this.average;
  }

  // * Comparable Method
  @Override
  public int compareTo(Cricketer c) {
    if (this.average > c.average)
      return 1;
    else 
      return -1;
  }
};