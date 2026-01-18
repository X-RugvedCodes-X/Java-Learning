package com.rugved.weakreference;

import java.lang.ref.WeakReference;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, weakreference");
    // Phone phone = new Phone("Apple", "IPhone 16 pro Max");    // * This is a strong reference
    // System.out.println(phone);
    // phone = null;
    // System.gc();      // * Advisory to GC to collect and clear the unreferenced resources
    // System.out.println(phone);

    // WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Apple", "IPhone 16 pro Max")); // * This is a weak reference object
    // System.out.println(weakReference.get());  // * Phone -> [brand=Apple, phoneName=IPhone 16 pro Max]
    // * Let's make the main thread sleep for 3 seconds
    // try {
    //   Thread.sleep(3000);
    // } catch (Exception e) {
    //   e.printStackTrace();
    // }
    // System.out.println(weakReference.get());  // * Still it prints: Phone -> [brand=Apple, phoneName=IPhone 16 pro Max], but we were expecting it to be null as weakreference are collected and cleared by JVM

    WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Apple", "IPhone 16 pro Max")); // * This is a weak reference object
    System.out.println(weakReference.get());  // * Phone -> [brand=Apple, phoneName=IPhone 16 pro Max]
    // * Let's make the main thread sleep for 3 seconds again, but now:
    System.gc();      // * We didn't made anything null yet
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(weakReference.get()); // * null, as we called the GC to clear WeakReferences

  }
};