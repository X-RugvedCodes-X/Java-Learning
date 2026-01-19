package com.rugved.identityhashmap;

import java.util.IdentityHashMap;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, identity hashmap");
    // String key1 = new String("key");
    // String key2 = new String("key");
    // System.out.println(key1.equals(key2));    // * true - As though the key1 key2 references are different but the normal equals method of object class is overrided in String Class thus comparing only the string value and not the refrence

    // * Difference b/w hashCode and IdentityHashCode
    // System.out.println(System.identityHashCode(key1));    // * Different
    // System.out.println(System.identityHashCode(key2));    // * Different
    // System.out.println(key1.hashCode());  // * same
    // System.out.println(key2.hashCode());  // * same

    // IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
    // identityHashMap.put(key1, 1);
    // identityHashMap.put(key2, 2);
    // * In Normal Hashmap this would have been just {key = 2}
    // * But in IdentityHashMap we get both keys: {key = 2, key = 1}, Though String's hashCode is overidden but in Identity HashMap the hashCode is based on the Object and not on it'c Class's Overidden method
    // * In IdentityHashMap the HashCode and Equal Operator is like 
    // * identityHashCode and == (Double Equal to) thus checking the refrence too
    // System.out.println(identityHashMap);  // * {key = 2, key = 1}

    // * But Mind You 
    // IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();
    // Integer key1 = 1;
    // Integer key2 = 1;
    // identityHashMap.put(key1, "one");
    // identityHashMap.put(key2, "two");
    // System.out.println(identityHashMap);    // * {1=two} - This is due to Integer Caching
    // * Java caches Integer objects in this range: -128 to 127
    // So when we write:
    // Integer key1 = 1;
    // Integer key2 = 1;

    // Java actually does this internally:
    // key1 = Integer.valueOf(1);
    // key2 = Integer.valueOf(1);

    // And since 1 is within the cache range:
    // key1 == key2   // true
    // They are the same object reference 

    // * Now Breaking the Integer Cache
    IdentityHashMap<Integer, String> map = new IdentityHashMap<>();
    Integer key1 = new Integer(1);
    Integer key2 = new Integer(1);
    // * key1 != key2 - Two separate entries
    map.put(key1, "one");
    map.put(key2, "two");
    System.out.println(map);    // * {1=one, 1=two}

  }
}