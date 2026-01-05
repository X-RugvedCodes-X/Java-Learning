package com.rugved.main;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, wordld !");
    // Demo1 d1 = new Demo2();
    // d1.show();

    // * To access specialized method of child class
    // d1.display();              // ! Incorrect Way
    // ((Demo2) d1).display();    // * Correct Way

    // * Anonymous Inner Class 
    // Demo1 d1 = new Demo1() {
    //   public void show() {
    //     System.out.println("In New Show()");
    //   }
    //   // * Here if we create any specialized methods for this inner Class then we can't use it.
    //   public void getData() {
    //     System.out.println("Get Data");
    //   }
    // };

    // * We can only use Inner Class once. We cannot reuse it.
    // d1.show();
    // d1.getData(); // ! Doesn't work

    // * This is Anonymous Object of Anonymous Class
    // new Demo1() {
    //   public void show() {
    //     System.out.println("In New Show()");
    //   }
    //  // * Here if we create any specialized methods for this inner Class then we can't use it.
    //   public void getData() {
    //     System.out.println("Get Data");
    //   }
    // }.getData();

    // P obj = new P() {
    //   public void show() {
    //     System.out.println("In newly Implemented show");
    //   }
    // };

    // * Lambda Expression - Replacement of Anonymous Inner Class
    // P obj = () ->  {
    //   System.out.println("In newly Implemented show");
    // };

    // * Even Shorter Syntax
    // P obj = () ->  System.out.println("In newly Implemented show");
    // obj.show();

    // ^ Another Example
    // Calculator c = (int a, int b) -> {
    //   return a + b;
    // };

    // Calculator c = (int a, int b) -> a + b;

    Calculator c = (a, b) -> a + b; // * And when we have only one argument we don't even need round brackets

    int result = c.add(2, 3);
    System.out.println(result);
  }
};