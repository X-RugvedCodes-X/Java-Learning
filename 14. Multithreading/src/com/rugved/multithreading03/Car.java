package com.rugved.multithreading03;

public class Car implements Runnable {

  // * Avoiding Race Condition using synchronized
  // * Race Condition means Each thread races to complete their task irrespective of being in sync or not
  @Override
  synchronized public void run() {
    try {
      System.out.println( Thread.currentThread().getName() + " Entered Parking Lot");
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + " Seated in Car");
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + " Started Driving Car");
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + " Went and came back and parked the car");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  } 
}