package com.rugved.multithreading04;

public class Car implements Runnable {

  // * Avoiding Race Condition using synchronized keyword (For specific statements)
  @Override
  public void run() {
    try {
      Thread.sleep(2000);
      System.out.println( Thread.currentThread().getName() + " Entered Parking Lot");
      synchronized(this) {
        System.out.println(Thread.currentThread().getName() + " Seated in Car");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " Started Driving Car");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " Went and came back and parked the car");
      } 
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  } 
}