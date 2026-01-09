package com.rugved.hashmap;

// import java.util.Collection;
// import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // HashMap<Integer, String> hashMap = new HashMap<>();
    // hashMap.put(0, "Java");
    // hashMap.put(1, "Spring");
    // hashMap.put(2, "SpringBoot");
    // hashMap.put(3, "Microservices");
    // System.out.println(hashMap);          // * {0=Java, 1=Spring, 2=SpringBoot, 3=Microservices}

    // Academy academy = new Academy(10, "Redis");
    // HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
    // hashMap.put(1, "Java");
    // hashMap.put(2, "Spring");
    // hashMap.put(2, "Spring");
    // System.out.println(hashMap);        // * {1=Java, 2=Spring} - key must be unique
    // hashMap.put(3, "Spring");
    // System.out.println(hashMap);       // * {1=Java, 2=Spring, 3=Spring} - Value not necessary to be unique
    // hashMap.put(null, "Kafka");
    // System.out.println(hashMap);      // * {null=Kafka, 1=Java, 2=Spring, 3=Spring} - key can be null even value can also be null
    // hashMap.put(null, null);
    // System.out.println(hashMap);      // * {null=null, 1=Java, 2=Spring, 3=Spring}
    // hashMap.put(4, null);
    // System.out.println(hashMap);      // * {null=null, 1=Java, 2=Spring, 3=Spring, 4=null}
    // hashMap.put(academy.getId(), academy.getCourseName());
    // System.out.println(hashMap);      // * {null=null, 1=Java, 2=Spring, 3=Spring, 4=null, 10=Redis}

    // ^ LinkedHashmap is child class of HashMap
    // & Duplicate Keys are not allowed in Any of Map Collection Family
    // ! In HashTable (HashTable<> hashTable = new HashTable<>();) key and value cannot be null 

    // * TreeMap Gives in Sorted Order By Default
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(1, "Java");
    treeMap.put(2, "Spring");
    treeMap.put(0, "Programming");
    treeMap.put(-1, "Math");
    System.out.println(treeMap);    // * {-1=Math, 0=Programming, 1=Java, 2=Spring}
    // treeMap.put(null, "Hibernate"); // ! null key not allowed (java.lang.NullPointerException)
    treeMap.put(4, null);           
    System.out.println(treeMap);    // * {-1=Math, 0=Programming, 1=Java, 2=Spring, 4=null}
    // * treeMap.get(key) - is a way to get the Data at that key.

    // Collection<String> values = treeMap.values();
    // Iterator<String> it = values.iterator();
    // while (it.hasNext()) {
    //   System.out.print(it.next() + " ");
    // }   // * Math Programming Java Spring null
    // System.out.println();

    // Collection<Integer> keys = treeMap.keySet();
    // Iterator<Integer> it = keys.iterator();
    // while (it.hasNext()) {
    //   System.out.print(it.next() + " ");
    // }   // * -1 0 1 2 4
    // System.out.println();

    // * To Get Both Values and Keys use EntrySet()

    Set<Map.Entry<Integer, String>> keyValues = treeMap.entrySet();
    Iterator<Map.Entry<Integer, String>> it = keyValues.iterator();
    while (it.hasNext()) { 
      // System.out.print(it.next() + " ");
      Map.Entry<Integer, String> pair = it.next();
      System.out.println("key: " + pair.getKey() + ", Value: " + pair.getValue());
    }
    System.out.println();

    // * Or (Best Practice)
    for (Map.Entry<Integer,String> entry : keyValues) {
      System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
    }
  }
};