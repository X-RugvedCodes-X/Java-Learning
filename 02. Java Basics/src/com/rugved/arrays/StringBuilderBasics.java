package com.rugved.arrays;

public class StringBuilderBasics {
  public static void main(String[] args) {
    //* StringBuilder is a mutable sequence of characters.We change the same object without creating a new one. */
    //* Default capacity: new StringBuilder(); // capacity = 16 */
    //* It grows like this: newCapacity = oldCapacity * 2 + 2 */
    //* 16 → 34 → 70 → 142 ... */
    //* No Thread-Safety and No Synchronization */
    //* Synchronization means Controlling access to an object when multiple threads try to use it at the same time. It prevents data corruption.*/
    //* In StringBuilder Multiple threads can modify it simultaneously, but Faster because no locking overhead */
    //* Therefore, StringBuffer was introduced as it is thread safe and synchronized but there is always the speed and safety tradeoff making it slower than StringBuilder */

    //^ String is immutable; StringBuilder is mutable and faster for modifications because it uses a resizable internal char array instead of creating new objects.
    // System.out.println("hello, string builder");

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; ++i) {
      char ch = (char)('a' + i);
      sb.append(ch);
    }
    // System.out.println(sb);

  }
};