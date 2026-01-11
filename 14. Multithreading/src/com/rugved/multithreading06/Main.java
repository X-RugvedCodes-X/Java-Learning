package com.rugved.multithreading06;

public class Main {

  public static void main(String[] args) {
    System.out.println("MS Word Application | Usage of Daemon Thread Method");
    // * There is a concept called Daemon Thread which runs at last atleast once, we can take this example as Garbage Collector which releases or clears the resources at the end atleast one.
    // * It can run even in the middle as a secdondary thread but at last it must run atleast once

    MSWord msWord1 = new MSWord();
    MSWord msWord2 = new MSWord();
    MSWord msWord3 = new MSWord();

    Thread thread1 = new Thread(msWord1);
    Thread thread2 = new Thread(msWord2);
    Thread thread3 = new Thread(msWord3);

    thread1.setName("TYPE");
    thread2.setName("SPELLCHECK");
    thread3.setName("AUTOSAVING");
    
    // * Now in this we want that even after all the processes the spellcheck and autosave thread must run after all the process atleast once
    // * To make this possible there is a method name called setDaemon for the thread which we want to make run at last
    thread2.setDaemon(true);
    thread3.setDaemon(true);

    thread2.setPriority(3);   // * thread2 which means spell check thread has low priority as compared to normal priority of 5
    thread3.setPriority(4);   // * thread3 which means auto saving thread has low priority as compared to normal priority of 5

    thread1.start();
    thread2.start();
    thread3.start();

  }
}