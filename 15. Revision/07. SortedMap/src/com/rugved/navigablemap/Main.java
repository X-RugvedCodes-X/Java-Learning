package com.rugved.navigablemap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {
    System.out.println("hello, navigable map");
    NavigableMap<Integer, String> navigableMap = new TreeMap<>();
    navigableMap.put(5, "Five");
    navigableMap.put(1, "One");
    navigableMap.put(3, "Three");
    System.out.println(navigableMap);   // * {1=One, 3=Three, 5=Five}

    // ^ Specialized Concrete Methods

    // * lowerKey(key): Returns the greatest key strictly less than the given key, or null if there is no such key.
    System.out.println(navigableMap.lowerKey(4));   // * 3
    // * ceilingKey(key): Returns the least key greater than or equal to the given key, or null if there is no such key
    System.out.println(navigableMap.ceilingKey(3)); // * 3
  }
}