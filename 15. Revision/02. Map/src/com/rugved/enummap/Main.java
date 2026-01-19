package com.rugved.enummap;

import java.util.EnumMap;

enum Day {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
};

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, enum map");
    // * No Hashing, Ordinal is used for indexing, Faster than HashMap, Memory Efficient
    EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);
    enumMap.put(Day.TUESDAY, "Veg");
    enumMap.put(Day.MONDAY, "Veg");
    System.out.println(enumMap);    // * {MONDAY=Veg, TUESDAY=Veg} - Order As per Enum
    enumMap.put(Day.WEDNESDAY, "Non-Veg");
    System.out.println(enumMap);    // * {MONDAY=Veg, TUESDAY=Veg, WEDNESDAY=Non-Veg}
    System.out.println(Day.TUESDAY.ordinal());    // * 1
  }
}
