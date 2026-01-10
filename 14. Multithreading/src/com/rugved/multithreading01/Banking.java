package com.rugved.multithreading01;

import java.util.Scanner;

public class Banking implements Runnable {

  @Override
  public void run() {
    bankingActivity();
  }
  @SuppressWarnings("unused")
  public void bankingActivity() {
    System.out.println("Banking Activity Started.....");
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println("Enter User Number: ");
      int userNumber = sc.nextInt();
      System.out.println("Enter Password: ");
      int password = sc.nextInt();
    }
    System.out.println("Collect Your Cash");
    System.out.println("Banking Activity Ended.....");
  }
};