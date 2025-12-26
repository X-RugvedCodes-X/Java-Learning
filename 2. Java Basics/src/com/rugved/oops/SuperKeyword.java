package com.rugved.oops;

class Parent {
  int i = 10;

  void parentDisplay() {
    System.out.println("Display Method of Parent");
  }
};

class Child extends Parent {
  int i = 100;

  void childDisplay() {
    System.out.println("Display Method of Child: " + i);
    System.out.println(super.i);
    parentDisplay();        //* Calls Method of Child Class */
    super.parentDisplay();  //* Calls method of Parent Class */
  }

  void parentDisplay() {
    System.out.println("Overriden Display of Child");
  }
};

public class SuperKeyword {
  public static void main(String[] args) {
    System.out.println("hello, super keyword");
    //* Just like this keyword refers to current instance(object) of a class.   */
    //* Similarly super keyword refers to the parent class's instance (object). */
    new Child().childDisplay();
  }
}