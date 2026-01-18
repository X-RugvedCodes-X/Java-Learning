package com.rugved.treemap;

import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // * If we Want keys to be sorted in a Map then we use Sorted Map, Mind You Sorted Map is an interface and TreeMap and NavigableMap class implements this interface
    // SortedMap<String, Integer> sortedMap = new TreeMap<>(); 
    // sortedMap.put("Rugved", 94);
    // sortedMap.put("Dada", 65);
    // sortedMap.put("Saunskar", 85);
    // System.out.println(sortedMap);  // * {Dada=65, Rugved=94, Saunskar=85}
    // * Sorted Based on key, here key is string so lexicographical Comparison is done

    // SortedMap<Integer, String> sortedMap = new TreeMap<>();
    // sortedMap.put(10, "Dada");
    // sortedMap.put(5, "Rugved");
    // sortedMap.put(32, "Saunskar");
    // sortedMap.put(2, "Bandya");
    // System.out.println(sortedMap);    // * {2=Bandya, 5=Rugved, 10=Dada, 32=Saunskar} - sorted based on key which here is integer

    // * Some Specialized Concrete Methods in SortedMap
    // System.out.println(sortedMap.firstKey());
    // System.out.println(sortedMap.lastKey());
    // * Returns data from start upto signified value mention in parameter
    // System.out.println(sortedMap.headMap(12));    // * {2=Bandya, 5=Rugved, 10=Dada}
    // * Returns data from signified value mention in parameter to the end of Map
    // System.out.println(sortedMap.tailMap(5));   // * {5=Rugved, 10=Dada, 32=Saunskar}

    // * Internally Red Black Tree is Used for implementation of SortedMap Interface
    SortedMap<Integer, String> sortedMap = new TreeMap<>((var a, var b) -> b - a);    // * Custom Comparator for descending order of keys
    sortedMap.put(10, "Dada");
    sortedMap.put(5, "Rugved");
    sortedMap.put(32, "Saunskar");
    sortedMap.put(2, "Bandya");
    System.out.println(sortedMap);    // * {32=Saunskar, 10=Dada, 5=Rugved, 2=Bandya}
    
  }
};