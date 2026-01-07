package com.rugved.javabasics;

// import java.lang.*; //* This Package is By default there in every Java file.

class Mobile {
  String brand;
  int price;
  // static String name = "SmartPhone";  //! Bad Practice, Use Static Initialization Block
  static String name;

  //* This Block Executes Only once when the class is loaded in the Runtime Phase on the Heap, Static Variables and Methods are initialized at the start itself without any extra need of calling the static Methods.
  static {
    name = "SmartPhone";
    System.out.println("Inside Static Initialization Block");
  }

  Mobile() {
    System.out.println("Inside Default Constructor [Just to know whether Object Created]");
  }

  Mobile(String brand, int price) {
    this.brand = brand;
    this.price = price;
  }

  public static void staticDisplay(Mobile mobile) {
    System.out.println(mobile.brand + ", " + mobile.price);
  }

  public void nonStaticDisplay() {
    System.out.println(brand + ", " + price);
  }
};

public class StaticMethod {
  public static void main(String[] args) throws ClassNotFoundException {
    
    //* This does not creates the object but just loads the class manually at the time of class Loading subsystem phase, and we know that when the class is loaded, then and there static variable memory is allocated on the Heap and static initialization block is executed. This prints "Inside Static Initialization Block" even if we dont create any object.
    Class.forName("com.rugved.javabasics.Mobile");  

    System.out.println("hello, static method");

    Mobile mb1 = new Mobile("Apple",  2000);
    Mobile mb2 = new Mobile("Samsung",1500);

    mb1.nonStaticDisplay();
    mb2.nonStaticDisplay();

    //^ Technique to use Static Method with regards to any specfic Object.
    Mobile.staticDisplay(mb1);
    Mobile.staticDisplay(mb2);

    new Mobile(); //* This is Valid in Java, It's called Anonymous Object and it executes whatever there is inside the default constructor. No worries of Memory Handling as Garbage Collector releases its memory at the end of Program. Even We can use methods in the class with this object, new Mobile().nonStaticDisplay(). 
  }
}