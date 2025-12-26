package com.rugved.oops;

class Test {
  static {
    System.out.println("Static Block 1");
  }

  static {
    System.out.println("Static Block 2");
  }

  //* Java Initialization Block - Always Execute before the constructor execution when the object is created. Use Java Initialization Block when something is to be common within all constructors, this is the best practice. Java Initialization Block executes before the super() method call. */
  {
    System.out.println("Non Static Block 1");
  }
  Test() {
    System.out.println("Constructor");
  }
  {
    System.out.println("Non Static Block 2");
  }
};  

public class NonStaticBlock {
  public static void main(String[] args) {
    System.out.println("hello, non static block");
    @SuppressWarnings("unused")
    Test t1 = new Test();
    @SuppressWarnings("unused")
    Test t2 = new Test();
  }
}