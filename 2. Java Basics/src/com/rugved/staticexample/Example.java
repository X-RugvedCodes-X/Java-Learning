package com.rugved.staticexample;

public class Example {
  public static void main(String[] args) {
    System.out.println("hello, main !");

    Human rugved = new Human("Rugved", 21, 0, false);
    rugved.display();

    System.out.println("\n*******************\n");

    Human kunal = new Human("Kunal", 25, 100000000, true);
    kunal.display();
  }
};