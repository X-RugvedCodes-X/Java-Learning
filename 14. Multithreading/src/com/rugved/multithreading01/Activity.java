package com.rugved.multithreading01;

public class Activity implements Runnable {

  @Override
  public void run() {
    printingActivity();
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
}