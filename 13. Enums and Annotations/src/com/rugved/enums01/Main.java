package com.rugved.enums01;

public class Main {
  public static void main(String[] args) {
    Day monday = Day.MONDAY;
    int ordinal = monday.ordinal();
    // System.out.println(ordinal);        // * 1

    // Day enumDay = Day.valueOf("MONDAY");  // * O(n) - for checking each of the enum values
    // System.out.println(enumDay);          // * MONDAY

    // Day[] values = Day.values();
    // for (Day day : values) {
    //   System.out.println(day);
    // }

    System.out.println(monday.display()); // * Today is MONDAY
  }
}
