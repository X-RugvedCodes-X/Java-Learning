package com.rugved.comparable;

public class Student implements Comparable<Student> {
  private String name;
  private Double gpa;
  public Student(String name, Double gpa) {
    this.name = name;
    this.gpa = gpa;
  }
  @Override
  public int compareTo(Student student) {
    // return (int) (student.getGpa() - this.getGpa());
    // * Or
    return Double.compare(student.getGpa(), this.getGpa());
  }
  @Override
  public String toString() {
    return "Student -> [name=" + name + ", gpa=" + gpa + "]";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Double getGpa() {
    return gpa;
  }
  public void setGpa(Double gpa) {
    this.gpa = gpa;
  }
  
}