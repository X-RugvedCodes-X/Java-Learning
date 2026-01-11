package com.rugved.multithreading07;

public class Queue {
  // * This acts as Mediator
  int data;
  boolean flag = false;

  synchronized public void produce(int i) {
    try {
      if(flag) {
        System.out.println("Producer In Waiting State....");
        wait();
      } else {
        data = i;
        System.out.println("Data Produced: " + data);
        flag = true;
        notify();
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  synchronized public void consume() {
    try {
      if(!flag) {
        System.out.println("Consumer In Waiting State....");
        wait();
      } else {
        System.out.println("Data Consumed: " + data); 
        flag = false;
        notify();
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}