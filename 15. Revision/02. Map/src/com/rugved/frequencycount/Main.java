package com.rugved.frequencycount;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    // * Count Frequency of Characters in Strings using HashMap
    String str = "Rugved Raorane";
    frequencyCount(str);
  }

  private static void frequencyCount(String str) {
    HashMap<Character, Integer> countLetters = new HashMap<>();
    for(char ch : str.toCharArray()) {
      if (countLetters.containsKey(ch)) {
        countLetters.put(ch, countLetters.get(ch) + 1);
      } else {
        countLetters.put(ch, 1);
      }
    } 
    System.out.println(countLetters);
  }
}