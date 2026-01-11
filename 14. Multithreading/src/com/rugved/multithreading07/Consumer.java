package com.rugved.multithreading07;

public class Consumer extends Thread {
  Queue queue;

  public Consumer(Queue queue) {
    if(queue != null) {
      this.queue = queue;
    }
  }

  public void run() {
    while (true) {
      queue.consume();
    }
  }
}