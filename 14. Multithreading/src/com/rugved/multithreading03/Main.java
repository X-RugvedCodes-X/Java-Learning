package com.rugved.multithreading03;

public class Main {

  public static void main(String[] args) {
    System.out.println("hello, race condition");
    Car c = new Car();
    Thread thread1 = new Thread(c);
    Thread thread2 = new Thread(c);
    Thread thread3 = new Thread(c);

    thread1.setName("Child1");
    thread2.setName("Child2");
    thread3.setName("Child3");

    thread1.start();
    thread2.start();
    thread3.start();
  }
}