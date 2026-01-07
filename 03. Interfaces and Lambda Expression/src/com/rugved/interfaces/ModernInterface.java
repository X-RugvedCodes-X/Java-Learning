package com.rugved.interfaces;

interface Dada {
  void show();
  // * Modern Change in interface, use default keyword if want to give implementation to the method in interface itself, this default is seperate from that default where we don't write anything. 
  // * Default Method in an interface means, method with body. (From Java 1.8 or Java 8)
  // * Hence it is not compulsory for the implementing class to override / implement this default method.

  default void disp() {
    System.out.println("Dada");
  }

  // * static method must have, implementation too.
  // * static methods of an interface do not inherited in implementing classes, which means we cannot call static method of interface using a class.
  static void announcement() {

  }
};

// * An implementing class can have it's own specialized methods too, however using interface reference type we cannot access them, in such scenario down casting is required.

class Bhau implements Dada {
  public void show() {
    System.out.println("Show");
  }
};

public class ModernInterface {
  public static void main(String[] args) {
    System.out.println("Modern Interface Changes");
  }
};