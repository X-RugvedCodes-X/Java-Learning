# Hashtable in Java – Interview Quick Guide

## 1. Introduction

* `Hashtable` is a **legacy collection class**
* Part of **`java.util` package**
* Implements the **`Map<K, V>` interface**
* Introduced in **JDK 1.0**
* Stores data as **key–value pairs**
* Uses **hashing** for storage

---

## 2. Key Characteristics

* **Thread-safe by default**
* **All public methods are synchronized**
* Does **NOT allow null keys**
* Does **NOT allow null values**
* Slower than `HashMap`
* Legacy alternative to `HashMap`

---

## 3. Hashtable vs HashMap (Very Common Question)

| Feature         | Hashtable    | HashMap          |
| --------------- | ------------ | ---------------- |
| Thread-safe     | Yes          | No               |
| Synchronization | Method-level | Not synchronized |
| Null key        | Not allowed  | One allowed      |
| Null value      | Not allowed  | Allowed          |
| Performance     | Slower       | Faster           |
| Introduced in   | JDK 1.0      | JDK 1.2          |

---

## 4. Internal Working (Brief)

* Uses **hashing mechanism**
* Index is calculated as:

  ```
  index = hash(key) % capacity
  ```
* Stores data in **buckets**
* Each bucket contains a linked list (or tree in newer JVMs)

---

## 5. Constructors

```java
Hashtable()
Hashtable(int initialCapacity)
Hashtable(int initialCapacity, float loadFactor)
Hashtable(Map<? extends K, ? extends V> m)
```

---

## 6. Commonly Used Methods (Interview Focus)

| Method                        | Description               | Time Complexity | Space Complexity |
| ----------------------------- | ------------------------- | --------------- | ---------------- |
| `put(K, V)`                   | Inserts key–value pair    | O(1) average    | O(1)             |
| `get(Object key)`             | Retrieves value by key    | O(1) average    | O(1)             |
| `remove(Object key)`          | Removes key–value pair    | O(1) average    | O(1)             |
| `containsKey(Object key)`     | Checks key existence      | O(1) average    | O(1)             |
| `containsValue(Object value)` | Checks value existence    | O(n)            | O(1)             |
| `size()`                      | Returns number of entries | O(1)            | O(1)             |
| `isEmpty()`                   | Checks if empty           | O(1)            | O(1)             |
| `clear()`                     | Removes all entries       | O(n)            | O(1)             |
| `keySet()`                    | Returns all keys          | O(n)            | O(n)             |
| `values()`                    | Returns all values        | O(n)            | O(n)             |
| `entrySet()`                  | Returns key–value pairs   | O(n)            | O(n)             |

---

## 7. Synchronization Behavior (Important)

* Every method is synchronized
* Only **one thread can access Hashtable at a time**
* Causes **performance bottleneck**
* Better alternatives exist

---

## 8. Advantages

* Thread-safe without extra code
* Simple and reliable in multi-threaded environments
* Safe from concurrent modification issues
* Useful in legacy systems

---

## 9. Pitfalls / Disadvantages

* Poor performance due to synchronization
* Does not allow null key or value
* Legacy class (not recommended for new projects)
* Method-level locking is too coarse-grained

---

## 10. Modern Alternatives (Interview Tip)

* `Collections.synchronizedMap(new HashMap<>())`
* `ConcurrentHashMap` (preferred)

  * Better concurrency
  * Segment-level locking
  * High performance

---

## 11. Hashtable vs ConcurrentHashMap

| Feature          | Hashtable   | ConcurrentHashMap |
| ---------------- | ----------- | ----------------- |
| Thread safety    | Yes         | Yes               |
| Locking          | Entire map  | Segment-based     |
| Performance      | Low         | High              |
| Null keys/values | Not allowed | Not allowed       |
| Recommendation   | Legacy      | Preferred         |

---

## 12. When to Use Hashtable

* Maintaining legacy code
* When method-level synchronization is acceptable
* Rarely used in modern applications

---

## 13. Interview One-Liners

* “Hashtable is synchronized, HashMap is not.”
* “Hashtable does not allow null key or value.”
* “ConcurrentHashMap is the modern replacement.”
* “Hashtable suffers from performance overhead.”

---
