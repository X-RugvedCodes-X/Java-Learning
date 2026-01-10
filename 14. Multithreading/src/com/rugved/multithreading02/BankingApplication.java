package com.rugved.multithreading02;

import java.util.Scanner;

public class BankingApplication implements Runnable {
  @Override
  public void run() {
    // * Here we write to check conditions thus reducing multiple classes and multiple run methods 
    String threadName = Thread.currentThread().getName();
    if(threadName.equals("BANK")) {
      bankingActivity();
    } else if (threadName.equals("ACTIVITY")) {
      printingActivity();
    } else if (threadName.equals("MESSAGE")) {
      importantMessage();
    }
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

  public void printingActivity() {
    System.out.println("Printing Activity Started....");
    for(int i = 0; i < 4; ++i) {
      System.out.println("*".repeat(5));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Printing Activity Ended....");
  }

  public void importantMessage() {
    System.out.println("Important Message Started....");
    for(int i = 0; i < 4; ++i) {
      System.out.println("COC is Best Game....");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Important Message Ended....");
  }
}