package com.rugved.multithreading05;

public class Main {

  public static void main(String[] args) {
    // * Library Example to Demonstrate Synchronization
    Library library = new Library();

    // * Threads in New State
    Thread thread1 = new Thread(library);
    Thread thread2 = new Thread(library);

    thread1.setName("Student1");
    thread2.setName("Student2");

    // ^ After Runnable state only one method will be there in the running state
    // ^ States of a Thread are -> New, Runnable, Running, Sleep, Blocked and Dead
      
    // * Now Both threads in Runnable State
    thread1.start();
    thread2.start();
  }
}