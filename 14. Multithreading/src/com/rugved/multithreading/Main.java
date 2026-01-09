package com.rugved.multithreading;

public class Main {
  public static void main(String[] args) {
    System.out.println("Application Started....");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      System.out.println(e);
      e.printStackTrace();
    }
    System.out.println("Application Ended....");
  }
};