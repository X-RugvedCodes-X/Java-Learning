

## 1. HashMap: Most Used Methods (90% of usage)

### Core CRUD (used everywhere)

```java
map.put(key, value);
map.get(key);
map.containsKey(key);
map.remove(key);
map.size();
map.isEmpty();
```

These are absolute essentials and appear in almost every problem.

---

## 2. HashMap: Most Used Expressions (DSA Focus)

### 1. getOrDefault() (very high frequency)

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

Used for:

* Frequency counting
* Prefix sum problems
* Sliding window problems
* Anagram problems
* Majority element problems

This is the most used HashMap expression in DSA.

---

### 2. containsKey() before get()

```java
if (map.containsKey(key)) {
    // logic
}
```

Used in:

* Two Sum
* Subarray sum equals K
* First repeating element

---

### 3. Iteration using entrySet()

```java
for (Map.Entry<K, V> entry : map.entrySet()) {
    K key = entry.getKey();
    V value = entry.getValue();
}
```

Used in:

* Processing final results
* Finding maximum or minimum frequency
* Debugging and validations

---

### 4. Iteration using keySet()

```java
for (Integer key : map.keySet()) {
    // logic
}
```

Used when only keys are required.

---

### 5. Iteration using values()

```java
for (int val : map.values()) {
    max = Math.max(max, val);
}
```

Used to:

* Find maximum frequency
* Aggregate values

---

## 3. HashMap: Advanced but Common (Java 8+)

### computeIfAbsent()

```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```

Used in:

* Graph adjacency list creation
* Grouping elements
* Indexing data

---

### compute()

```java
map.compute(key, (k, v) -> v == null ? 1 : v + 1);
```

Used for atomic-style update logic.

---

### putIfAbsent()

```java
map.putIfAbsent(key, value);
```

Used for initialization logic.

---

## 4. ConcurrentHashMap: Most Used Methods (Projects)

### Core methods (same as HashMap)

```java
put()
get()
remove()
containsKey()
size()
```

---

### Important ConcurrentHashMap Methods

#### putIfAbsent()

```java
map.putIfAbsent(key, value);
```

Prevents overwriting values in a multithreaded environment.

---

#### computeIfAbsent()

```java
map.computeIfAbsent(key, k -> expensiveOperation());
```

Used in:

* Caching
* Lazy initialization
* Resource management

---

#### compute()

```java
map.compute(key, (k, v) -> v == null ? 1 : v + 1);
```

Provides atomic updates without external synchronization.

---

#### replace()

```java
map.replace(key, oldValue, newValue);
```

Used for compare-and-swap style updates.

---

## 5. ConcurrentHashMap: Common Project Patterns

### Thread-safe counter

```java
map.compute(key, (k, v) -> v == null ? 1 : v + 1);
```

### Thread-safe cache

```java
map.computeIfAbsent(key, k -> loadFromDB(k));
```

### Safe initialization

```java
map.putIfAbsent(key, new Object());
```

---

## 6. Rarely Used Methods (Low Priority for DSA)

* clone()
* clear() (except reset scenarios)
* equals() and hashCode() on the map itself
* forEach()
* merge()

---

## 7. DSA vs Project Usage Summary

| Feature         | DSA Usage | Project Usage |
| --------------- | --------- | ------------- |
| put / get       | Very High | Very High     |
| getOrDefault    | Very High | Medium        |
| containsKey     | High      | Medium        |
| entrySet        | High      | High          |
| computeIfAbsent | Medium    | Very High     |
| putIfAbsent     | Low       | Very High     |
| compute         | Low       | High          |

---

## 8. Minimal Set to Remember

### DSA Essentials

```java
put()
get()
getOrDefault()
containsKey()
entrySet()
```

### Project Essentials

```java
putIfAbsent()
computeIfAbsent()
compute()
replace()
```

---
