package com.rugved.multithreading07;

public class Producer extends Thread {
  Queue queue;
  int i = 1;

  public Producer(Queue queue) {
    if (queue != null) {
      this.queue = queue;
    }
  }

  public void run() {
    while (true) {
      queue.produce(++i);
    }
  }

};