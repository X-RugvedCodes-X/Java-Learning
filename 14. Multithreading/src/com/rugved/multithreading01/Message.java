package com.rugved.multithreading01;

public class Message implements Runnable {     // * Earlier Version - public class Message extends Thread (Interface is always better ) 

  @Override
  public void run() {
    importantMessage();
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