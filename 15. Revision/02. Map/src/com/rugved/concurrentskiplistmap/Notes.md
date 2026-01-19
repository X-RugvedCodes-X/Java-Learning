# ConcurrentSkipListMap in Java – Detailed Tutorial

## 1. Introduction

* `ConcurrentSkipListMap` is a **thread-safe, sorted map**
* Part of **`java.util.concurrent` package**
* Introduced in **Java 6**
* Implements:

  * `ConcurrentNavigableMap`
  * `NavigableMap`
  * `SortedMap`
* Maintains keys in **natural order** or **custom Comparator**
* Designed for **high concurrency with sorted access**

---

## 2. Key Characteristics

* Thread-safe and **non-blocking**
* Maintains **sorted order of keys**
* Uses **Skip List (probabilistic data structure)**
* Does **NOT allow null keys or values**
* Provides **weakly consistent iterators**
* Scales well in concurrent environments

---

## 3. How Elements Are Stored (Skip List Structure)

### What is a Skip List?

* A **layered linked list**
* Each node may appear in multiple levels
* Higher levels act as **express lanes** for faster traversal

### Visualization (Conceptual)

```
Level 3:  1 ----------- 9
Level 2:  1 ----- 5 --- 9
Level 1:  1 - 3 - 5 - 7 - 9
```

* Bottom level contains **all elements**
* Higher levels contain **subset of elements**
* Nodes are promoted to higher levels **randomly**

---

## 4. Probabilistic Logic (Core Concept)

* On insertion, node level is decided **randomly**
* Each level has probability ≈ **0.5**
* Expected height: **O(log n)**
* No rebalancing required (unlike TreeMap)

### Why Probabilistic?

* Avoids costly tree rotations
* Maintains performance with high concurrency
* Simpler structure than Red-Black Trees

---

## 5. Thread Safety Model

* Uses **lock-free algorithms**
* Relies on:

  * CAS (Compare-And-Swap)
  * Volatile pointers
* No global locks
* Threads can read and write concurrently

---

## 6. Internal Comparison with TreeMap

| Feature                  | ConcurrentSkipListMap | TreeMap         |
| ------------------------ | --------------------- | --------------- |
| Thread-safe              | Yes                   | No              |
| Sorting                  | Yes                   | Yes             |
| Data structure           | Skip List             | Red-Black Tree  |
| Locking                  | Lock-free             | Not thread-safe |
| Null keys                | Not allowed           | Allowed         |
| Performance (concurrent) | High                  | Poor            |

---

## 7. Constructors

```java
ConcurrentSkipListMap()
ConcurrentSkipListMap(Comparator<? super K> comparator)
ConcurrentSkipListMap(Map<? extends K, ? extends V> m)
ConcurrentSkipListMap(SortedMap<K, ? extends V> m)
```

---

## 8. Commonly Used Methods (With Code, TC & SC)

---

### put(K key, V value)

**Before**

```
{}
```

```java
ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
map.put(5, "Five");
map.put(1, "One");
map.put(3, "Three");
```

**After**

```
{1=One, 3=Three, 5=Five}
```

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(log n)        | O(log n)         |
| Worst   | O(log n)        | O(log n)         |

---

### get(Object key)

```java
String value = map.get(3);
```

* Navigates levels top-down

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(log n)        | O(1)             |
| Worst   | O(log n)        | O(1)             |

---

### remove(Object key)

```java
map.remove(1);
```

**Before**

```
{1=One, 3=Three, 5=Five}
```

**After**

```
{3=Three, 5=Five}
```

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(log n)        | O(1)             |
| Worst   | O(log n)        | O(1)             |

---

### firstKey() / lastKey()

```java
map.firstKey(); // 3
map.lastKey();  // 5
```

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| firstKey  | O(1)            | O(1)             |
| lastKey   | O(1)            | O(1)             |

---

### subMap(fromKey, toKey)

```java
map.subMap(3, true, 6, true);
```

**Result**

```
{3=Three, 5=Five}
```

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(log n)        | O(1)             |

---

### ceilingKey() / floorKey()

```java
map.ceilingKey(4); // 5
map.floorKey(4);   // 3
```

| Case    | Time Complexity | Space Complexity |
| ------- | --------------- | ---------------- |
| Average | O(log n)        | O(1)             |

---

## 9. Iteration Behavior

* Iterators are **weakly consistent**
* No `ConcurrentModificationException`
* Reflects state at some point during iteration
* Safe during concurrent updates

---

## 10. Advantages Over Alternatives

### Over TreeMap

* Thread-safe
* No explicit synchronization
* Better concurrent performance

### Over ConcurrentHashMap

* Maintains **sorted order**
* Supports range queries (`subMap`, `headMap`)
* Navigational operations available

---

## 11. Pitfalls / Limitations

* Higher memory usage than HashMap
* Slower than ConcurrentHashMap for direct lookup
* No null keys or values
* Probabilistic structure harder to reason about

---

## 12. When to Use ConcurrentSkipListMap

* Need **sorted, concurrent map**
* Range queries in concurrent environment
* Time-based or priority-based data
* Leaderboards, schedulers, indexing

---

## 13. Space Complexity (Overall)

* Each node may exist in multiple levels
* Expected space: **O(n log n)** pointers
* Actual average space: **~2n pointers**

---

## 14. Interview One-Liners

* “ConcurrentSkipListMap is a thread-safe sorted map.”
* “It uses a probabilistic skip list.”
* “Provides log-time performance without locks.”
* “Alternative to TreeMap in concurrent scenarios.”

---

## 15. Final Comparison Table

| Use Case                         | Best Choice           |
| -------------------------------- | --------------------- |
| Fast unordered concurrent access | ConcurrentHashMap     |
| Sorted concurrent access         | ConcurrentSkipListMap |
| Single-threaded sorted           | TreeMap               |
| Legacy synchronization           | Hashtable             |

---
