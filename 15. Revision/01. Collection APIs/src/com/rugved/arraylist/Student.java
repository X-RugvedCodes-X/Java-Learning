package com.rugved.arraylist;

public class Student {
  private String name;
  private double gpa;

  public Student(String name, double gpa) {
    if ((name != null) && (gpa >= 0.0 && gpa <= 10.0)) {
      this.name = name;
      this.gpa = gpa;
    }
  }

  public String getName() {
    return this.name;
  }

  public double getGpa() {
    return this.gpa;
  }

  @Override
  public String toString() {
    return "Student -> Name: " + this.name + ", GPA: " + this.gpa;
  }
};