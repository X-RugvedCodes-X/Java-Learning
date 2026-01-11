package com.rugved.multithreading07;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, inter thread communication");
    Queue queue = new Queue();
    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    producer.start();
    consumer.start();
  }
}