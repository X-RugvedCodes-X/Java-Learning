package com.rugved.arrays;

public class Human {
  private int age;
  private String name;
  private boolean isMarried;

  public Human() {}
  public Human(int age, String name, boolean isMarried) {
    this.age = age;
    this.name = name;
    this.isMarried = isMarried;
  }
  public int getAge() {
    return age;
  }
  public String getName() {
    return name;
  }
  public boolean isMarried() {
    return isMarried;
  }

  @Override
  public String toString() {
    return "Human [ " + this.name + ", " + this.age + ", " + this.isMarried + " ]";
  }
};