package com.rugved.multithreading02;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world");
    // * Continuing the Bank Example - This time only using one class and one run method
    BankingApplication bankingApplication = new BankingApplication();
    Thread thread1 = new Thread(bankingApplication);
    Thread thread2 = new Thread(bankingApplication);
    Thread thread3 = new Thread(bankingApplication);
    thread1.setName("BANK");
    thread2.setName("PRINTING");
    thread3.setName("MESSAGE");
    thread1.start();
    thread2.start();
    thread3.start();
  }
}