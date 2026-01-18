
# TreeMap (Java) — Interview Notes

## 1. What is TreeMap?

* `TreeMap` is a **Map implementation** in Java that stores key–value pairs in **sorted order**.
* It **maintains ordering of keys** either:

  * By **natural ordering** (`Comparable`), or
  * By a **custom `Comparator`** provided at creation.
* It does **not allow null keys** (from Java 7 onward).
* It allows **multiple null values**.
* It is **not synchronized** (not thread-safe).

---

## 2. Internal Implementation

* Internally implemented using a **Red-Black Tree** (self-balancing Binary Search Tree).
* Each node contains:

  * key
  * value
  * left, right child references
  * parent reference
  * color (RED or BLACK)

### Why Red-Black Tree?

* Ensures tree height remains **O(log n)**
* Guarantees predictable performance for all operations

---

## 3. Ordering Behavior

* Keys are always stored in **sorted order**
* Sorting is based on:

  * `Comparable` implementation of keys, or
  * Custom `Comparator`

Example:

```java
TreeMap<Integer, String> map = new TreeMap<>();
TreeMap<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
```

---

## 4. Time Complexity Summary (Quick View)

| Operation                  | Time Complexity |
| -------------------------- | --------------- |
| put                        | O(log n)        |
| get                        | O(log n)        |
| remove                     | O(log n)        |
| containsKey                | O(log n)        |
| firstKey / lastKey         | O(log n)        |
| floorKey / ceilingKey      | O(log n)        |
| higherKey / lowerKey       | O(log n)        |
| subMap / headMap / tailMap | O(log n)        |
| iteration                  | O(n)            |

---

## 5. Time & Space Complexity of All Major TreeMap Methods

### Core Operations

| Method               | Time Complexity | Space Complexity |
| -------------------- | --------------- | ---------------- |
| put(key, value)      | O(log n)        | O(1)             |
| get(key)             | O(log n)        | O(1)             |
| remove(key)          | O(log n)        | O(1)             |
| containsKey(key)     | O(log n)        | O(1)             |
| containsValue(value) | O(n)            | O(1)             |
| size()               | O(1)            | O(1)             |
| isEmpty()            | O(1)            | O(1)             |

---

### Navigational Methods (TreeMap Specialty)

| Method        | Description      | Time     | Space |
| ------------- | ---------------- | -------- | ----- |
| firstKey()    | Smallest key     | O(log n) | O(1)  |
| lastKey()     | Largest key      | O(log n) | O(1)  |
| floorKey(k)   | Greatest key ≤ k | O(log n) | O(1)  |
| ceilingKey(k) | Smallest key ≥ k | O(log n) | O(1)  |
| lowerKey(k)   | Greatest key < k | O(log n) | O(1)  |
| higherKey(k)  | Smallest key > k | O(log n) | O(1)  |

---

### View Methods (Backed by Tree)

| Method         | Time     | Space |
| -------------- | -------- | ----- |
| subMap(k1, k2) | O(log n) | O(1)  |
| headMap(k)     | O(log n) | O(1)  |
| tailMap(k)     | O(log n) | O(1)  |

Note: These return **views**, not copies.

---

### Iteration Methods

| Method               | Time | Space |
| -------------------- | ---- | ----- |
| keySet() iteration   | O(n) | O(1)  |
| entrySet() iteration | O(n) | O(1)  |
| values() iteration   | O(n) | O(1)  |

---

### Bulk Operations

| Method      | Time       | Space |
| ----------- | ---------- | ----- |
| putAll(map) | O(m log n) | O(1)  |
| clear()     | O(n)       | O(1)  |

---

## 6. Space Complexity (Overall)

* TreeMap stores **one node per entry**
* Each node stores references + color
* **Total Space Complexity**:
  **O(n)**

---

## 7. Advantages of TreeMap

* Maintains **sorted order of keys**
* Supports **range queries** efficiently
* Predictable **O(log n)** performance
* Useful when **ordering matters**
* Provides powerful **navigational methods**

---

## 8. Common Pitfalls (Very Important for Interviews)

### 1. Null Key Not Allowed

```java
map.put(null, "value"); // NullPointerException
```

---

### 2. Slower Than HashMap

* TreeMap: O(log n)
* HashMap: O(1) average
* Do not use TreeMap when ordering is not required

---

### 3. Comparator Inconsistency

```java
Comparator<Integer> cmp = (a, b) -> 0;
```

* Treats all keys as equal
* Causes data loss

Comparator must be **consistent with equals**

---

### 4. Mutating Keys

* If key objects are mutable and modified after insertion:

  * Tree order breaks
  * Retrieval may fail

---

### 5. containsValue() Is Costly

```java
map.containsValue(x); // O(n)
```

Avoid in performance-critical paths

---

## 9. TreeMap vs HashMap vs LinkedHashMap (Interview Favorite)

| Feature       | TreeMap        | HashMap    | LinkedHashMap     |
| ------------- | -------------- | ---------- | ----------------- |
| Ordering      | Sorted         | None       | Insertion         |
| Internal DS   | Red-Black Tree | Hash Table | Hash Table + List |
| put/get       | O(log n)       | O(1) avg   | O(1)              |
| Null Key      | No             | Yes        | Yes               |
| Range Queries | Yes            | No         | No                |

---

## 10. When Should You Use TreeMap?

* When you need **sorted keys**
* When performing **range queries**
* When you need **floor, ceiling, higher, lower**
* When predictable performance is required

---

## 11. One-Line Interview Summary

> TreeMap is a Map implementation backed by a Red-Black Tree that maintains sorted keys and guarantees O(log n) time for basic operations while using O(n) space.

---
