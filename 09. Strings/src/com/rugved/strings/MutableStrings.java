package com.rugved.strings;

public class MutableStrings {
  public static void main(String[] args) {
    // ! Error
    // StringBuffer str = "Rugved";
    // * Correct Way
    // StringBuffer str = new StringBuffer("Rugved");  // * This is created on the Heap.
    // System.out.println(str);
    // str.append(" Raorane");   // * And as this is on Heap, so existing string is getting modified as StringBuffer is Mutable. so no need of reassigning
    // str.append(2);
    // str.append(21.56);
    // str.append(false);
    // System.out.println(str);    // * Rugved Raorane221.56false

    // StringBuffer sb1 = new StringBuffer();
    // System.out.println(sb1.capacity());   // * 16

    // StringBuilder sb2 = new StringBuilder();
    // System.out.println(sb2.capacity());   // * 16
    // New Capacity = (Old Capacity * 2) + 2
    // 16 -> 34 -> 80 ...
    // sb1.trimToSize(); // * Very Important Method 

    StringBuilder sb1 = new StringBuilder("Sachin");
    StringBuilder sb2 = new StringBuilder("Sachin");
    String str1 = new String("Sachin");
    String str2 = new String("Sachin");
    System.out.println(str1.equals(str2));    // * true
    System.out.println(sb1.equals(sb2));      // ! false 

    // * Because: It Compares Address, yes we know .equals compares the actual string value but in StringBuilder the .equals method from the Object class is just inherited and not overrided and in String Class it's overrided to Compare two Strings Lexicographically
    // * equals method is always part of Object class and it by default compares references but in case of Immutable String class it compares actual content, as it is overrided in that way

    //* Synchronization means Controlling access to an object when multiple threads try to use it at the same time. It prevents data corruption.*/
    //* In StringBuilder Multiple threads can modify it simultaneously, but Faster because no locking overhead */
    
    // * All Methods in StringBuffer are synchronized and in StringBuffer not synchronized.
    // * In StringBuffer Multithreading is allowed but It is thread-safe, not single-threaded
    // * In StringBuilder Multithreading is allowed but not safe

    //^ String is immutable; StringBuilder is mutable and faster for modifications because it uses a resizable internal char array instead of creating new objects.

    // * String is immutable: any modification creates a new object.

    // * StringBuilder is mutable and NOT thread-safe.
    // * It is NOT synchronized, so multiple threads can access it,
    // * but concurrent modification can cause data corruption.
    // * It is faster because there is no synchronization (no locking overhead).

    // * StringBuffer is mutable and thread-safe.
    // * All its public methods are synchronized.
    // * It allows safe access in multithreaded environments,
    // * but is slower than StringBuilder due to synchronization overhead.

    // * Summary:
    // * String       -> Immutable, thread-safe by design
    // * StringBuffer -> Mutable, thread-safe, slower
    // * StringBuilder-> Mutable, NOT thread-safe, faster

  }
};