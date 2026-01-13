package com.rugved.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    // HashMap<Integer, String> hashMap = new HashMap<>();
    // * Adding Elements in A Map
    // hashMap.put(1, "Rugved");
    // hashMap.put(2, "Dada");
    // hashMap.put(3, "Sanskar");
    // System.out.println(hashMap);    // * {1=Rugved, 2=Dada, 3=Sanskar}

    // * Accessing Elements in A Map
    // String name = hashMap.get(3);
    // System.out.println(name);       // * Sanskar
    // String name = hashMap.get(10);  // * returns null if not present
    // System.out.println(name);       // * null

    // boolean checKey = hashMap.containsKey(2);
    // System.out.println(checKey);    // * true
    // boolean checKey = hashMap.containsKey(10);
    // System.out.println(checKey);    // ! false
    // * Similar Analogy for Value using .containsValue("name");

    // * Order not Guranteed
    // Set<Integer> keys = hashMap.keySet();
    // for (int i : keys) {
    //   System.out.println(hashMap.get(i));
    // }
    /*
    * Rugved
    * Dada
    * Sanskar
    */

    // Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
    // for (Map.Entry<Integer,String> entry : entries) {
    //   System.out.println(entry.getKey() + ": " + entry.getValue());
    // }
    /*
    * 1: Rugved
    * 2: Dada
    * 3: Sanskar
    */

    // for (Map.Entry<Integer, String> entry : entries) {
    //   System.out.println(entry.getValue().toUpperCase());
    // }
    /*
    * RUGVED
    * DADA
    * SANSKAR
    */

    // * Remove Operation in HashMap, .remove(key); returns the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
    // hashMap.remove(2);    // * Removing Dada  (returns String)
    // System.out.println(hashMap);    // * {1=Rugved, 3=Sanskar}
    // & If you try to remove something which is not associated to any key then:
    // boolean whetherRemoved = hashMap.remove(2, "Bandya");  // * Bandya Not present in our Map though; returns boolean
    // System.out.println(whetherRemoved);   // ! false

    // List<Integer> list = Arrays.asList(4, 10, 0, -1, 50, 72, 92, 100, 98);
    // list.contains(50);    // * Takes O(n) worst case

    // * Contains Method of Map gives in average O(1) constant time

    // * HashMap Constructor takes InitialCapacity and LoadFactor as params too
    // HashMap<Integer, String> hashMap = new HashMap<Integer, String>(17, 0.5f);

    // * Fruit -> Quantity
    // HashMap<String, Integer> fruitMap = new HashMap<>();
    // fruitMap.put("Apple", 50);
    // fruitMap.put("Banana", 30);
    // fruitMap.put("Orange", 80);
    // fruitMap.put("Grapes", 20);
    // System.out.println(fruitMap.get("Grapes"));   // * 20

    // * We Know that Object Class has certain methods like hashCode and .equals, they both work on memory address and reference which means that the hashCode Calculated for the particular object is based on its memory address and equals also compares reference values

    // * HashMaps with Custom Objects
    HashMap<Person, String> hashMap = new HashMap<>();
    Person p1 = new Person("Rugved", 1);
    Person p2 = new Person("Dada", 2);
    Person p3 = new Person("Rugved", 1);

    // * Now Here we know that p1 and p3 are same, we just intend to overwrite p3 but HashMap treats these two as different and new HashCode is there for each object
    // hashMap.put(p1, "Engineer");    // * new hashcode1 --> new index1
    // hashMap.put(p2, "CA");          // * new hashcode2 --> new index2
    // hashMap.put(p3, "Manager");     // * new hashcode3 --> new index3
    // printHashMap(hashMap);
    // System.out.println(hashMap.size());    // ! 3, But we were expecting it to be 2 
    // * To Clear this we make changes in Person Class

    // * But Normally 
    // Map<String, Integer> map = new HashMap<>();
    // map.put("Shubham", 90);
    // map.put("Bandya", 95);
    // map.put("Shubham", 99);   // * Here this overwrites marks of Shubham and replaces it with old, but in the above example it doesnot
    // System.out.println(map);

    // * Now it will Work Fine as we overidded the hashCode and equals method
    hashMap.put(p1, "Engineer");    
    hashMap.put(p2, "CA");          
    hashMap.put(p3, "Manager");     
    printHashMap(hashMap);
    System.out.println(hashMap.size());
    /*
    * Person -> Name: Dada, Id: 2=CA
    * Person -> Name: Rugved, Id: 1=Manager
    * 2
    */
  } 

  private static <K, V> void printHashMap(HashMap<K, V> hashMap) {
    Set<Map.Entry<K, V>> pair = hashMap.entrySet();
    for (Map.Entry<K, V> entry : pair) {
      System.out.println(entry);
    }
  }
};