package com.rugved.multithreading06;

public class MSWord implements Runnable {

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    if(threadName.equals("TYPE")) {
      typing();
    } else if(threadName.equals("SPELLCHECK")) {
      spellCheck();
    } else {
      autoSave();
    }
  }

  public void typing() {
    try {
      for(int i = 0; i < 3; ++i) {
        System.out.println("Typing....");
        Thread.sleep(2000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void spellCheck() {
    try {
      // for(int i = 0; i < 3; ++i) {   // * Usually we keep the daemon thread in infinite loop, we know infinite loop runs infinite times but in case of daemon thread it will follow the normal thread execution flow, Daemon thread follows the route of primary thread
      for(; ;) {
        System.out.println("SpellChecking....");
        Thread.sleep(2000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void autoSave() {
    try {
      // for(int i = 0; i < 3; ++i) {
      for(; ;) {
        System.out.println("AutoSaving....");
        Thread.sleep(2000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}