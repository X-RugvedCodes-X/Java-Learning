# Immutable Map in Java – Short Tutorial


## 1. What is an Immutable Map?

* An **immutable map** is a map whose contents **cannot be modified** after creation
* No `put`, `remove`, or `clear` operations allowed
* Any modification attempt throws **`UnsupportedOperationException`**
* Introduced as **factory methods in Java 9**

---

## 2. Why Immutable Maps?

* Thread-safe by design
* Prevents accidental modification
* Safer for constants and configuration data
* Better performance (no synchronization needed)
* Encourages functional programming style

---

## 3. `Map.of()` – Creating Small Immutable Maps

### Syntax

```java
Map<K, V> map = Map.of(k1, v1, k2, v2, ...);
```

### Example

```java
Map<Integer, String> map = Map.of(
    1, "One",
    2, "Two",
    3, "Three"
);

System.out.println(map);
```

**Output**

```
{1=One, 2=Two, 3=Three}
```

### Key Points

* Supports **up to 10 key-value pairs**
* Keys and values **cannot be null**
* Order is **not guaranteed**
* Immutable

---

## 4. `Map.ofEntries()` – Creating Large Immutable Maps

### Syntax

```java
Map<K, V> map = Map.ofEntries(
    Map.entry(k1, v1),
    Map.entry(k2, v2)
);
```

### Example

```java
Map<Integer, String> map = Map.ofEntries(
    Map.entry(1, "One"),
    Map.entry(2, "Two"),
    Map.entry(3, "Three"),
    Map.entry(4, "Four")
);

System.out.println(map);
```

### When to Use

* When more than **10 entries** are required
* Cleaner and scalable syntax
* Still immutable

---

## 5. `Map.Entry` – Key-Value Pair Representation

### What is `Map.Entry`?

* Represents a **single key-value pair**
* Nested interface inside `Map`
* Used heavily in iteration and `Map.ofEntries`

---

### Creating a Map.Entry

```java
Map.Entry<Integer, String> entry =
    Map.entry(1, "One");
```

---

### Iterating Using `Map.Entry`

```java
for (Map.Entry<Integer, String> e : map.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}
```

---

## 6. Immutability in Action (Exception Example)

```java
Map<Integer, String> map = Map.of(1, "One");
map.put(2, "Two"); // Runtime Exception
```

**Exception**

```
UnsupportedOperationException
```

---

## 7. `Map.of()` vs `Map.ofEntries()`

| Feature          | Map.of()            | Map.ofEntries()       |
| ---------------- | ------------------- | --------------------- |
| Entry limit      | Max 10              | Unlimited             |
| Readability      | Good for small maps | Better for large maps |
| Uses Map.Entry   | No                  | Yes                   |
| Null keys/values | Not allowed         | Not allowed           |
| Immutable        | Yes                 | Yes                   |

---

## 8. Immutable Map vs Unmodifiable Map

| Feature            | Immutable Map | Collections.unmodifiableMap |
| ------------------ | ------------- | --------------------------- |
| Truly immutable    | Yes           | No (backed by original map) |
| Thread-safe        | Yes           | Depends                     |
| Structural changes | Not allowed   | Possible via original map   |
| Java version       | Java 9+       | Java 1.2                    |

---

## 9. Common Interview Questions (Quick Hits)

* Can immutable maps have null keys?
  No
* Can you modify Map.of map?
  No
* Is Map.of thread-safe?
  Yes
* Difference between immutable and unmodifiable map?
  Immutable has no backing modifiable map

---

## 10. When to Use Immutable Maps

* Constants and configuration
* Shared data across threads
* Read-only lookup tables
* Preventing defensive copies

---

## 11. One-Line Interview Answers

* “Map.of creates immutable maps.”
* “Map.ofEntries is used for more than 10 entries.”
* “Immutable maps throw UnsupportedOperationException on modification.”
* “Map.Entry represents a single key-value pair.”

---
