package com.rugved.linkedhashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    System.out.println("hello, linkedHashMap");
    // * Order is not Guranteed in HashMap, But in LinkedhashMap order is maintained
    // HashMap<Integer, String> hashMap = new HashMap<>();
    // hashMap.put(20, "Orange");
    // hashMap.put(10, "Banana");
    // hashMap.put(13, "Guava");
    // printMap(hashMap);
    
    // * Internally has Doubly LinkedList for Mapping, Which makes the retrieval traversal a bit slow but still TC is same as HashMap, also it requires more space due to Double LinkedList
    // * It's Constructor has intialCapacity, loadFactor and Access Order (By Default Access order is false)
    // LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.8f, true);
    // linkedHashMap.put("Orange", 20);
    // linkedHashMap.put("Banana", 10);
    // linkedHashMap.put("Guava", 13);
    // printMap(linkedHashMap);
    // seperator();
    // linkedHashMap.get("Banana"); // * Now Banana will reach at the end as we made the access order true
    // printMap(linkedHashMap);
    /*
    * Orange=20
    * Guava=13
    * Banana=10 
    */
    // linkedHashMap.get("Orange"); // * Now Orange will reach at the end as we made the access order true
    // linkedHashMap.get("Guava"); // * Now Guava will reach at the end as we made the access order true

    // * It uses LRU (Least Recently Used) - which means element coming at the top is least used in the HashMap and we can either remove or do whatever to it according to our business logic
    // * This is Cache Eviction Strategy and LRU Cache is used to optimize it, This all is achieved by 

    // * Creating LinkedHashMap from HashMap
    HashMap<String, Integer> hashMap = new HashMap<>();
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(hashMap); // * This is Valid
    hashMap.put("Dada", 100);
    hashMap.put("Rugved", 90);
    hashMap.put("Saunskar", 95);
    // * getOrDefault(Object key, K default value); return type: Integer (In our case)
    // * It denotes that if key is not matching to any value then return a default value
    Integer value = hashMap.getOrDefault("Hemant", 0);    // * Here Hemant is not presnt
    System.out.println(value);    // * 0
    // printMap(hashMap);

    // * putIfAbsent(key, value) If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value (optional operation).
    // * If we use normal put then it will replace the value but putIfAbsent does not replace if something is already present, if not present then it will put
    hashMap.putIfAbsent("Dada", 95);
    printMap(hashMap);
    /*
    * Saunskar=95
    * Dada=100
    * Rugved=90
    */
    // ^ LinkedHashMap and HashMap are not thread-safe
  }

  private static <K, V> void printMap(Map<K, V> map) {
    Set<Map.Entry<K, V>> entries = map.entrySet();
    for (Map.Entry<K,V> entry : entries) {
      System.out.println(entry);
    } 
  }

  private static void seperator() {
    System.out.println("*".repeat(65));
  }
}