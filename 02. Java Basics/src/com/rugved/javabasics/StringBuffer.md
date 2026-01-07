# STRINGBUFFER IN JAVA – COMPLETE GUIDE

## 1. What is `StringBuffer`?

`StringBuffer` is a **mutable, thread-safe sequence of characters**.

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" World");
System.out.println(sb);
```

**Output**

```
Java World
```

### Key Features

* Mutable (can change without creating new objects)
* Thread-safe (methods are synchronized)
* Slower than `StringBuilder` due to synchronization
* Stored in Heap memory

---

## 2. Internal Working & Implementation

### Internal Structure (Simplified)

```java
class StringBuffer {
    char[] value;
    int count;
}
```

| Field          | Purpose                   |
| -------------- | ------------------------- |
| `char[] value` | Stores characters         |
| `int count`    | Number of characters used |

---

### Capacity Mechanism

* Default capacity = **16**
* If initialized with a string → `16 + string.length()`

#### Growth Formula

```
newCapacity = (oldCapacity * 2) + 2
```

---

### Example

```java
StringBuffer sb = new StringBuffer("Java");
System.out.println(sb.capacity());
```

**Output**

```
20
```

---

## 3. Memory Storage & Reference Behavior

### Where Stored?

| Component           | Memory |
| ------------------- | ------ |
| Reference (`sb`)    | Stack  |
| StringBuffer object | Heap   |
| Internal `char[]`   | Heap   |

---

### Reference Example

```java
StringBuffer sb1 = new StringBuffer("Java");
StringBuffer sb2 = sb1;
sb2.append(" Programming");
System.out.println(sb1);
```

**Output**

```
Java Programming
```

✔ Same object modified

---

## 4. Constructors

```java
StringBuffer sb1 = new StringBuffer();        // capacity = 16
StringBuffer sb2 = new StringBuffer("Hello"); // 16 + length
StringBuffer sb3 = new StringBuffer(50);      // capacity = 50
```

---

# 5. ALL IMPORTANT STRINGBUFFER METHODS (With Examples)

---

## 5.1 append()

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" ").append("Programming").append(101);
System.out.println(sb);
```

**Output**

```
Java Programming101
```

---

## 5.2 insert()

```java
StringBuffer sb = new StringBuffer("JavaWorld");
sb.insert(4, " ");
System.out.println(sb);
```

**Output**

```
Java World
```

---

## 5.3 replace()

```java
StringBuffer sb = new StringBuffer("Java World");
sb.replace(5, 10, "Universe");
System.out.println(sb);
```

**Output**

```
Java Universe
```

---

## 5.4 delete()

```java
StringBuffer sb = new StringBuffer("Java Programming");
sb.delete(4, 16);
System.out.println(sb);
```

**Output**

```
Java
```

---

## 5.5 deleteCharAt()

```java
StringBuffer sb = new StringBuffer("Java");
sb.deleteCharAt(1);
System.out.println(sb);
```

**Output**

```
Jva
```

---

## 5.6 reverse()

```java
StringBuffer sb = new StringBuffer("abcd");
sb.reverse();
System.out.println(sb);
```

**Output**

```
dcba
```

---

## 5.7 charAt()

```java
StringBuffer sb = new StringBuffer("Java");
System.out.println(sb.charAt(2));
```

**Output**

```
v
```

---

## 5.8 setCharAt()

```java
StringBuffer sb = new StringBuffer("Java");
sb.setCharAt(0, 'L');
System.out.println(sb);
```

**Output**

```
Lava
```

---

## 5.9 length()

```java
StringBuffer sb = new StringBuffer("Hello");
System.out.println(sb.length());
```

**Output**

```
5
```

---

## 5.10 capacity()

```java
StringBuffer sb = new StringBuffer();
System.out.println(sb.capacity());
```

**Output**

```
16
```

---

## 5.11 ensureCapacity()

```java
StringBuffer sb = new StringBuffer();
sb.ensureCapacity(100);
System.out.println(sb.capacity());
```

**Output**

```
100
```

---

## 5.12 trimToSize()

```java
StringBuffer sb = new StringBuffer("Hello");
sb.trimToSize();
System.out.println(sb.capacity());
```

**Output**

```
5
```

---

## 5.13 substring() ⚠️ IMPORTANT

### Returns `String`, not `StringBuffer`

```java
StringBuffer sb = new StringBuffer("Java Programming");
String s = sb.substring(5);
System.out.println(s);
System.out.println(sb);
```

**Output**

```
Programming
Java Programming
```

---

```java
String s2 = sb.substring(0, 4);
System.out.println(s2);
```

**Output**

```
Java
```

---

## 5.14 indexOf() / lastIndexOf()

```java
StringBuffer sb = new StringBuffer("Java Programming Java");
System.out.println(sb.indexOf("Java"));
System.out.println(sb.lastIndexOf("Java"));
```

**Output**

```
0
17
```

---

## 5.15 toString()

```java
StringBuffer sb = new StringBuffer("Java");
String s = sb.toString();
System.out.println(s);
```

**Output**

```
Java
```

---

## 5.16 equals() ⚠️ TRAP

```java
StringBuffer sb1 = new StringBuffer("Java");
StringBuffer sb2 = new StringBuffer("Java");
System.out.println(sb1.equals(sb2));
```

**Output**

```
false
```

✔ Reference comparison only

---

## 5.17 compareTo() ❌

```java
sb1.compareTo(sb2); // Compile-time error
```

❌ Not supported

---

# 6. String ↔ StringBuffer Conversion

## String → StringBuffer

```java
String s = "Java";
StringBuffer sb = new StringBuffer(s);
```

❌ Direct casting not allowed

---

## StringBuffer → String

```java
String s = sb.toString();
```

---

# 7. Best Practices

### ✔ Use StringBuffer when:

* Multiple threads modify the same string
* Thread safety is required

---

### ❌ Avoid when:

* Single-threaded → use `StringBuilder`

---

### ✔ Predefine capacity

```java
StringBuffer sb = new StringBuffer(1000);
```

---

### ✔ Use append instead of `+`

```java
sb.append("text");
```

---

### ✔ Convert to String only once

Avoid repeated `toString()` calls in loops.

---

# 8. Comparison Summary

| Feature     | String | StringBuffer | StringBuilder |
| ----------- | ------ | ------------ | ------------- |
| Mutable     | ❌      | ✔            | ✔             |
| Thread-safe | ✔      | ✔            | ❌             |
| Performance | Slow   | Medium       | Fast          |

---

## Final Interview One-Liner

> **`StringBuffer` is a synchronized, mutable character sequence implemented using a dynamically growing character array and stored in heap memory.**

---
