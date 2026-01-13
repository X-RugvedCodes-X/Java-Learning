package com.rugved.lrucache;

public class Main {
  public static void main(String[] args) {
    System.out.println("lrucache implementation from LinkedHashMap");
    LRUCache<String, Integer> studentMap = new LRUCache<>(3); // * When Size is Greater than Capacity the least recently Used will be remove automatically
    studentMap.put("Dada", 100);
    studentMap.put("Bandya", 90);
    studentMap.put("Saunskar", 95);
    studentMap.put("Sameer", 92);
    System.out.println(studentMap);   // * {Bandya=90, Saunskar=95, Sameer=92} as Dada is least recently used

    studentMap.put("Dada", 91); // * Now Bandya Becomes least recently used
    System.out.println(studentMap);   // * {Saunskar=95, Sameer=92, Dada=91}
  }
}