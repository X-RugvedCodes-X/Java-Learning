# ConcurrentHashMap in Java – Detailed Interview Tutorial

## 1. Introduction

* `ConcurrentHashMap` is a **thread-safe, high-performance Map**
* Part of **`java.util.concurrent` package**
* Introduced in **Java 5 (JDK 1.5)**
* Designed for **highly concurrent environments**
* Eliminates the performance issues of `Hashtable`

---

## 2. Key Characteristics

* Thread-safe **without synchronizing the entire map**
* Allows **concurrent reads and writes**
* Uses **fine-grained locking**
* Does **NOT allow null keys or null values**
* Provides **weakly consistent iterators**
* Scales well in multi-threaded applications

---

## 3. ConcurrentHashMap vs HashMap vs Hashtable

| Feature     | HashMap   | Hashtable   | ConcurrentHashMap |
| ----------- | --------- | ----------- | ----------------- |
| Thread-safe | No        | Yes         | Yes               |
| Locking     | None      | Whole map   | Fine-grained      |
| Performance | High      | Low         | Very High         |
| Null keys   | 1 allowed | Not allowed | Not allowed       |
| Null values | Allowed   | Not allowed | Not allowed       |
| Iterators   | Fail-fast | Fail-fast   | Weakly consistent |

---

## 4. Internal Working (High Level)

* Uses **hashing** like other maps
* Data stored in **buckets**
* Supports **concurrent access** by multiple threads
* Locking is applied **only where required**
* Design changed significantly from Java 7 to Java 8+

---

## 5. Segment-Based Locking (Java 7 and Earlier)

### What is a Segment?

* A **segment** is a smaller portion of the map
* Each segment acts like an **independent HashMap**
* Each segment has its **own lock**

### How It Works

* Map is divided into **multiple segments**
* Default number of segments: **16**
* Each segment contains multiple buckets
* Threads accessing different segments **do not block each other**

### Example

```
ConcurrentHashMap
 ├── Segment 0 (Lock 0)
 ├── Segment 1 (Lock 1)
 ├── Segment 2 (Lock 2)
 └── Segment 15 (Lock 15)
```

### Effect

* Up to **16 threads** can modify the map simultaneously
* Much faster than locking the entire map

---

## 6. Java 8+ Improvement (Bucket-Level Locking)

* Segments were **removed**
* Uses **CAS (Compare-And-Swap)** and **synchronized blocks**
* Locks are applied **per bucket**
* Even finer granularity than segments
* Better memory usage and scalability

---

## 7. Thread Safety Mechanism

* Read operations are **lock-free**
* Write operations lock **only affected bucket**
* Uses:

  * Volatile variables
  * CAS operations
  * Minimal synchronized blocks
* No global lock

---

## 8. Constructors

```java
ConcurrentHashMap()
ConcurrentHashMap(int initialCapacity)
ConcurrentHashMap(int initialCapacity, float loadFactor)
ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
ConcurrentHashMap(Map<? extends K, ? extends V> m)
```

* `concurrencyLevel`: estimated number of concurrent threads

---

## 9. Commonly Used Methods with Code, TC & SC

---

### put(K key, V value)

```java
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "One");
```

* Inserts or updates key-value pair
* Locks only the relevant bucket

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(n)             |

---

### get(Object key)

```java
String value = map.get(1);
```

* Non-blocking read
* No locking involved

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(1)             |

---

### remove(Object key)

```java
map.remove(1);
```

* Removes entry safely
* Locks only affected bucket

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(1)             |

---

### putIfAbsent(K key, V value)

```java
map.putIfAbsent(2, "Two");
```

* Atomically inserts only if key does not exist
* Prevents race conditions

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(n)             |

---

### replace(K key, V value)

```java
map.replace(1, "ONE");
```

* Updates value only if key exists
* Thread-safe replacement

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(1)             |

---

### computeIfAbsent(K key, Function)

```java
map.computeIfAbsent(3, k -> "Three");
```

* Computes value only once
* Prevents duplicate computation
* Atomic operation

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(1)            | O(1)             |
| Worst   | O(n)            | O(n)             |

---

### forEach(BiConsumer)

```java
map.forEach((k, v) -> System.out.println(k + " " + v));
```

* Weakly consistent iteration
* No ConcurrentModificationException

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(n)            | O(1)             |

---

## 10. Iterators Behavior

* **Not fail-fast**
* Reflects state of map at some point
* Can see updates during iteration
* Safe for concurrent modification

---

## 11. Advantages

* High performance in multi-threaded apps
* Fine-grained locking
* No global synchronization
* Scales well with CPU cores
* Safer than HashMap in concurrency

---

## 12. Pitfalls / Limitations

* Slightly higher memory overhead
* No null keys or values
* Complex internal implementation
* Overkill for single-threaded apps

---

## 13. When to Use ConcurrentHashMap

* Multiple threads accessing map simultaneously
* High-read, high-write environments
* Caches, counters, session stores
* Real-time systems

---

## 14. Interview One-Liners

* “ConcurrentHashMap uses fine-grained locking.”
* “Reads are lock-free in ConcurrentHashMap.”
* “It avoids full-map synchronization.”
* “Segment locking was used before Java 8.”

---

## 15. Hashtable vs ConcurrentHashMap (Final Verdict)

* `Hashtable` is synchronized and slow
* `ConcurrentHashMap` is modern and scalable
* Always prefer `ConcurrentHashMap` for concurrency

---
