package com.rugved.multithreading01;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Application Started....");
    // try {
    //   Thread.sleep(3000);
    // } catch (InterruptedException e) {
    //   System.out.println(e);
    //   e.printStackTrace();
    // }

    // * This is the main Thread and it is already available for us
    // Thread thread = Thread.currentThread();
    // System.out.println(thread);         // * Thread[#3,main,5,main]
    // System.out.println(thread.getName());
    // System.out.println(thread.getPriority());   // * Default priority is 5
    // thread.setName("Barbarian");
    // thread.setPriority(4);
    // System.out.println(thread.getName());
    // System.out.println(thread.getPriority());
    // System.out.println("Application Ended....");

    // ^ Banking Application Example
    System.out.println("Application Started.....");

    // * As we created object of the class which are extending Thread Class, we are creating new Thread behind the scenes 
    Banking banking   = new Banking();
    Activity activity = new Activity();
    Message message   = new Message();
    // ! Dont do this, It will again behave like SingleThreading
    // banking.run();
    // activity.run();
    // message.run();
    // * Start the Life of Threads. - Now No function waits for itself, Though we don't have control over their order of Execution, but we achieved Multithreading by doing this thus not wasting CPU Cycle
    // banking.start();
    // activity.start();
    // message.start();

    // * Now After implementing Runnable, we can't use earlier way of .start() as it works only on Threads and it's inherited due to extends Thread but now not available
    // * Another way to make multithreading
    // * But in this way the we don't have control on the exection order (Application Started and Application Terminated occurs just after running the program which we dont want) We want the main thread to wait for the other threads to complete their processes
    // * So we use .join method so that the threads will join the main thread in sync
    // * To check if any thread's life use thread.isAlive()
    Thread thread1 = new Thread(banking);
    Thread thread2 = new Thread(activity);
    Thread thread3 = new Thread(message);
    thread1.start();
    thread2.start();
    thread3.start();
    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Application Ended.....");
  }
};