package com.rugved.multithreading05;

public class Library implements Runnable {

  String java       = new String("Java");
  String dsa        = new String("DSA");
  String springBoot = new String("SpringBoot");

  // * Deadlock is such a phenomenon in multithreading where multiple threads are stuck in Blocked state permanently due to cyclic dependency of resources; waiting for the resources to be released
  // * Solution for Deadlock is Proper usage of Synchronized keyword

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();  
    if(threadName.equals("Student1")) {
      try {
        System.out.println("Student 1 Entered the Library");
        Thread.sleep(3000);
        // * This way we use the thread context schedular and synchronizer
        synchronized(java) {
          System.out.println("Student1 Has Acquired " + java);
          Thread.sleep(3000);
          synchronized(dsa) {
            System.out.println("Student1 Has Acquired " + dsa);
            Thread.sleep(3000);
            synchronized(springBoot) {
              System.out.println("Student1 Has Acquired " + springBoot);
              Thread.sleep(3000);   
            }
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      try {
        System.out.println("Student 2 Entered the Library");
        Thread.sleep(3000);
        synchronized(java) {
          System.out.println("Student2 Has Acquired " + java);
          Thread.sleep(3000);
          synchronized(dsa) {
            System.out.println("Student2 Has Acquired " + dsa);
            Thread.sleep(3000);
            synchronized(springBoot) {
              System.out.println("Student2 Has Acquired " + springBoot);
              Thread.sleep(3000);   
            }
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  } 
}