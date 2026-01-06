package com.rugved.exceptionHandling;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    System.out.println("Connection Started");

    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("Enter the Numerator: ");
      int numerator = sc.nextInt();

      System.out.print("Enter the Denominator: ");
      int denominator = sc.nextInt();

      int result = numerator / denominator;
      System.out.println("Result is: " + result);

    } catch (ArithmeticException e) {
      System.out.println("Exeception Occured: " + e);
      e.printStackTrace();
      System.out.println("Please Enter Non-Zero Denominator");
    } finally {
      sc.close();
    }
    System.out.println("Connection Terminated");
  }
};