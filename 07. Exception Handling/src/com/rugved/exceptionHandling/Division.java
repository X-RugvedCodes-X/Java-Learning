package com.rugved.exceptionHandling;

import java.util.Scanner;

public class Division {
  // * Handling the Exception
  // public static void divide() {
  //   Scanner sc = new Scanner(System.in);
  //   try {
  //     System.out.print("Enter the Numerator: ");
  //     int numerator = sc.nextInt();

  //     System.out.print("Enter the Denominator: ");
  //     int denominator = sc.nextInt();

  //     int result = numerator / denominator;
  //     System.out.println("Result is: " + result);

  //   } catch (ArithmeticException e) {
  //     System.out.println("Exeception Occured: " + e);
  //     e.printStackTrace();
  //     System.out.println("Please Enter Non-Zero Denominator");
  //     divide();
  //   } catch (Exception e) {
  //     System.out.println("Something went wrong " + e);
  //     e.printStackTrace();
  //   } finally {
  //     sc.close();
  //   }

  // * Exception Ducking, Leaving the ball like Rahul Dravid, now ball handled by wicketkeeper
  // * Now Responsiblity of the caller to handle the Exception
  // * Exception Ducking is part of Method Signature
  // public static void divide() throws ArithmeticException {
  //   Scanner sc = new Scanner(System.in);
  //   System.out.print("Enter the Numerator: ");
  //   int numerator = sc.nextInt();

  //   System.out.print("Enter the Denominator: ");
  //   int denominator = sc.nextInt();

  //   int result = numerator / denominator;
  //   System.out.println("Result is: " + result);
  //   sc.close();
  // }

  // * Throwing a Handled Exception is called as Rethrowing Exception
  // * Line Statements below throw keyword will not be executed becuase thread will the method immediately
  public static void divide() throws ArithmeticException {
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
      divide();
      throw e;
    } catch (Exception e) {
      System.out.println("Something went wrong " + e);
      e.printStackTrace();
      throw e;
    } finally {
      sc.close();
    }

    // ^ Whether Exception occured or not occured code in the finally block will always get executed.
  }  
};