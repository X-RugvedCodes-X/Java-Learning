package com.rugved.enums02;

public class Main {
  public static void main(String[] args) {
    // Day monday = Day.MONDAY;
    // int ordinal = monday.ordinal();
    // System.out.println(ordinal);        // * 1

    // Day enumDay = Day.valueOf("MONDAY");  // * O(n) - for checking each of the enum values
    // System.out.println(enumDay);          // * MONDAY

    // Day[] values = Day.values();
    // for (Day day : values) {
    //   System.out.println(day);
    // }
    // System.out.println(monday.display()); // * Today is MONDAY

    // Day monday = Day.MONDAY;
    // System.out.println(monday.getLower());  // * Monday

    Day day = Day.MONDAY;
    // switch (day) {
      // case MONDAY     -> System.out.println("M");
      // case TUESDAY    -> System.out.println("T");
      // case WEDNESDAY  -> System.out.println("W");
      // case THURSDAY   -> System.out.println("Th");
      // default         -> System.out.println("Weekend");
    // }

    String result = switch(day) {
      case MONDAY     -> "M";
      case TUESDAY    -> "T";
      case WEDNESDAY  -> "W";
      case THURSDAY   -> "Th";
      default         -> "Weekend";
    };
    System.out.println(result);
  }
}
