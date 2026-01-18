
# NavigableMap — Interview Notes

## 1. What is NavigableMap?

* `NavigableMap` is a **Java interface** that extends `SortedMap`.
* It provides **navigation methods** to traverse the map relative to a given key.
* It supports **closest-match searches** and **range views**.
* It maintains keys in **sorted order**.
* It allows **bi-directional navigation** (both forward and backward).

Important:

* `NavigableMap` is **not an implementation**.
* Common implementations:

  * `TreeMap`
  * `ConcurrentSkipListMap`

---

## 2. Internal Implementation

Since `NavigableMap` is an interface, internal behavior depends on implementation:

### TreeMap (Most Common)

* Implemented using a **Red-Black Tree**
* Self-balancing binary search tree
* Guarantees **O(log n)** time for operations

### ConcurrentSkipListMap

* Implemented using a **Skip List**
* Non-blocking, thread-safe
* Average **O(log n)** time

In interviews, **TreeMap is assumed unless stated otherwise**.

---

## 3. Ordering Behavior

* Keys are stored in **sorted order**
* Ordering is defined by:

  * Natural ordering (`Comparable`)
  * Custom `Comparator`

```java
NavigableMap<Integer, String> map = new TreeMap<>();
NavigableMap<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
```

---

## 4. Key Capabilities of NavigableMap

* Find **closest keys** (≤, ≥, <, >)
* Retrieve **first and last entries**
* Traverse in **reverse order**
* Create **range-based views**

---

## 5. Time Complexity Summary (Assuming TreeMap)

| Operation Type     | Time Complexity |
| ------------------ | --------------- |
| Basic operations   | O(log n)        |
| Navigation methods | O(log n)        |
| Range views        | O(log n)        |
| Iteration          | O(n)            |

---

## 6. Time & Space Complexity of NavigableMap Methods

### Core Map Methods (Inherited)

| Method               | Time     | Space |
| -------------------- | -------- | ----- |
| put(key, value)      | O(log n) | O(1)  |
| get(key)             | O(log n) | O(1)  |
| remove(key)          | O(log n) | O(1)  |
| containsKey(key)     | O(log n) | O(1)  |
| containsValue(value) | O(n)     | O(1)  |
| size()               | O(1)     | O(1)  |
| isEmpty()            | O(1)     | O(1)  |

---

### Navigational Methods (Core of NavigableMap)

| Method          | Description        | Time     | Space |
| --------------- | ------------------ | -------- | ----- |
| lowerKey(k)     | Greatest key < k   | O(log n) | O(1)  |
| floorKey(k)     | Greatest key ≤ k   | O(log n) | O(1)  |
| ceilingKey(k)   | Smallest key ≥ k   | O(log n) | O(1)  |
| higherKey(k)    | Smallest key > k   | O(log n) | O(1)  |
| lowerEntry(k)   | Entry with key < k | O(log n) | O(1)  |
| floorEntry(k)   | Entry with key ≤ k | O(log n) | O(1)  |
| ceilingEntry(k) | Entry with key ≥ k | O(log n) | O(1)  |
| higherEntry(k)  | Entry with key > k | O(log n) | O(1)  |

---

### Boundary Access Methods

| Method           | Time     | Space |
| ---------------- | -------- | ----- |
| firstKey()       | O(log n) | O(1)  |
| lastKey()        | O(log n) | O(1)  |
| firstEntry()     | O(log n) | O(1)  |
| lastEntry()      | O(log n) | O(1)  |
| pollFirstEntry() | O(log n) | O(1)  |
| pollLastEntry()  | O(log n) | O(1)  |

---

### View and Range Methods (Backed Views)

| Method                     | Description         | Time     | Space |
| -------------------------- | ------------------- | -------- | ----- |
| subMap(k1, k2)             | Range view          | O(log n) | O(1)  |
| subMap(k1, inc1, k2, inc2) | Inclusive/exclusive | O(log n) | O(1)  |
| headMap(k)                 | Keys < k            | O(log n) | O(1)  |
| tailMap(k)                 | Keys ≥ k            | O(log n) | O(1)  |
| descendingMap()            | Reverse order view  | O(log n) | O(1)  |

---

### Iteration Methods

| Method              | Time | Space |
| ------------------- | ---- | ----- |
| keySet()            | O(1) | O(1)  |
| navigableKeySet()   | O(1) | O(1)  |
| descendingKeySet()  | O(1) | O(1)  |
| Iteration over keys | O(n) | O(1)  |

---

## 7. Space Complexity (Overall)

* Stores one node per entry
* Extra pointers for navigation
* **Overall Space Complexity**: O(n)

---

## 8. Advantages of NavigableMap

* Powerful **navigation operations**
* Efficient **range queries**
* Sorted data access
* Predictable performance
* Cleaner alternative to manual BST traversal

---

## 9. Common Pitfalls (Interview Important)

### 1. Interface, Not Implementation

```java
NavigableMap map = new NavigableMap(); // Invalid
```

Must use `TreeMap` or `ConcurrentSkipListMap`

---

### 2. Null Key Restrictions

* TreeMap-based NavigableMap does not allow null keys

---

### 3. View-Based SubMaps

```java
subMap.clear(); // Affects original map
```

Submaps are **backed views**, not copies

---

### 4. Performance Assumptions

* All navigation methods are O(log n), not O(1)

---

### 5. Thread Safety Confusion

* `NavigableMap` itself is not thread-safe
* Use `ConcurrentSkipListMap` for concurrency

---

## 10. NavigableMap vs SortedMap vs Map

| Feature           | Map | SortedMap | NavigableMap |
| ----------------- | --- | --------- | ------------ |
| Ordering          | No  | Yes       | Yes          |
| Navigation        | No  | Limited   | Full         |
| Closest Match     | No  | No        | Yes          |
| Reverse Traversal | No  | No        | Yes          |

---

## 11. When Should You Use NavigableMap?

* When you need **range queries**
* When you need **floor/ceiling operations**
* When you need **reverse traversal**
* When sorted keys are required

---

## 12. One-Line Interview Summary

> NavigableMap is a sorted map interface that provides navigation methods for closest-match key searches with O(log n) performance when implemented using TreeMap.

---
