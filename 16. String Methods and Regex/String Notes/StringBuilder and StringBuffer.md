# STRINGBUILDER & STRINGBUFFER — COMPLETE MASTER NOTES (JAVA)

## 1. WHY STRINGBUILDER & STRINGBUFFER EXIST

### Problem with `String`

```java
String s = "a";
s = s + "b";
s = s + "c";
```

What happens internally:

* Each `+` creates a **new String object**
* Old data is copied
* Time complexity becomes **O(n²)** in loops
* High memory overhead

This is unacceptable in:

* DSA
* Competitive Programming
* Performance-critical systems

---

### Solution

Java provides **mutable** alternatives:

| Class         | Introduced | Thread-safe | Use case              |
| ------------- | ---------- | ----------- | --------------------- |
| StringBuffer  | JDK 1.0    | Yes         | Multithreading        |
| StringBuilder | JDK 1.5    | No          | Single-threaded, fast |

Both modify the **same object**.

---

# 2. STRINGBUILDER — COMPLETE DETAILS

---

## 2.1 What is StringBuilder?

> `StringBuilder` is a **mutable, non-synchronized sequence of characters** optimized for **fast string manipulation**.

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" DSA");
```

* Same object modified
* No new objects created

---

## 2.2 Internal Implementation (INTERVIEW IMPORTANT)

```java
class StringBuilder {
    char[] value;   // internal buffer
    int count;      // number of characters used
}
```

* Uses a **resizable char array**
* No synchronization
* Faster than StringBuffer

---

## 2.3 Capacity Mechanism

### Default capacity

```java
new StringBuilder(); // capacity = 16
```

### With initial string

```java
new StringBuilder("Java"); // capacity = 16 + 4 = 20
```

### Growth formula

```
newCapacity = oldCapacity * 2 + 2
```

Example growth:

```
16 → 34 → 70 → 142 → ...
```

---

## 2.4 Constructors

```java
StringBuilder sb1 = new StringBuilder();        // default capacity 16
StringBuilder sb2 = new StringBuilder("Hello"); // 16 + length
StringBuilder sb3 = new StringBuilder(100);     // predefined capacity
```

Predefining capacity avoids repeated resizing (very important in loops).

---

# 3. STRINGBUILDER METHODS (ALL IMPORTANT ONES)

---

## 3.1 append()

**Purpose:** Adds data at the end (supports all data types)

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" ").append("DSA").append(101);

System.out.println(sb);
```

**Output**

```
Java DSA101
```

* No casting needed
* Most used method
* Preferred over `+`

---

## 3.2 insert(int index, String str)

**Purpose:** Inserts content at a specific position

```java
StringBuilder sb = new StringBuilder("JavaWorld");
sb.insert(4, " ");

System.out.println(sb);
```

**Output**

```
Java World
```

* Characters to the right are shifted
* Index must be valid, else `StringIndexOutOfBoundsException`

---

## 3.3 replace(int start, int end, String str)

**Purpose:** Replaces substring `[start, end)`

```java
StringBuilder sb = new StringBuilder("Java World");
sb.replace(5, 10, "Universe");

System.out.println(sb);
```

**Output**

```
Java Universe
```

* End index is exclusive

---

## 3.4 delete(int start, int end)

**Purpose:** Deletes substring `[start, end)`

```java
StringBuilder sb = new StringBuilder("Java Programming");
sb.delete(4, 16);

System.out.println(sb);
```

**Output**

```
Java
```

---

## 3.5 deleteCharAt(int index)

**Purpose:** Removes one character

```java
StringBuilder sb = new StringBuilder("Java");
sb.deleteCharAt(1);

System.out.println(sb);
```

**Output**

```
Jva
```

---

## 3.6 reverse()

**Purpose:** Reverses characters in place

```java
StringBuilder sb = new StringBuilder("abcd");
sb.reverse();

System.out.println(sb);
```

**Output**

```
dcba
```

Used heavily in palindrome problems.

---

## 3.7 charAt(int index)

**Purpose:** Access character at index

```java
StringBuilder sb = new StringBuilder("Java");
System.out.println(sb.charAt(2));
```

**Output**

```
v
```

---

## 3.8 setCharAt(int index, char ch)

**Purpose:** Modify character at index

```java
StringBuilder sb = new StringBuilder("Java");
sb.setCharAt(0, 'L');

System.out.println(sb);
```

**Output**

```
Lava
```

---

## 3.9 length()

**Purpose:** Number of characters

```java
StringBuilder sb = new StringBuilder("Hello");
System.out.println(sb.length());
```

**Output**

```
5
```

---

## 3.10 capacity()

**Purpose:** Total allocated buffer size

```java
StringBuilder sb = new StringBuilder();
System.out.println(sb.capacity());
```

**Output**

```
16
```

---

## 3.11 ensureCapacity(int minCapacity)

**Purpose:** Ensures minimum capacity

```java
StringBuilder sb = new StringBuilder();
sb.ensureCapacity(100);

System.out.println(sb.capacity());
```

**Output**

```
100
```

Avoids repeated resizing in loops.

---

## 3.12 trimToSize()

**Purpose:** Shrinks capacity to current length

```java
StringBuilder sb = new StringBuilder("Hello");
sb.trimToSize();

System.out.println(sb.capacity());
```

**Output**

```
5
```

---

## 3.13 substring() (VERY IMPORTANT)

**Purpose:** Extracts substring

```java
StringBuilder sb = new StringBuilder("Java Programming");
String s = sb.substring(5);

System.out.println(s);
System.out.println(sb);
```

**Output**

```
Programming
Java Programming
```

Important:

* Returns **String**
* Original StringBuilder unchanged

---

## 3.14 indexOf() / lastIndexOf()

```java
StringBuilder sb = new StringBuilder("Java Programming Java");

System.out.println(sb.indexOf("Java"));
System.out.println(sb.lastIndexOf("Java"));
```

**Output**

```
0
17
```

---

## 3.15 toString()

**Purpose:** Converts to immutable String

```java
StringBuilder sb = new StringBuilder("Java");
String s = sb.toString();

System.out.println(s);
```

**Output**

```
Java
```

---

## 3.16 equals() (INTERVIEW TRAP)

```java
StringBuilder sb1 = new StringBuilder("Java");
StringBuilder sb2 = new StringBuilder("Java");

System.out.println(sb1.equals(sb2));
```

**Output**

```
false
```

Reason:

* Unlike in String Class, here `equals()` is **not overridden**
* Reference comparison only

---

## 3.17 compareTo()

Not supported

---

# 4. STRINGBUFFER — COMPLETE DETAILS

---

## 4.1 What is StringBuffer?

> `StringBuffer` is a **mutable, synchronized, thread-safe** sequence of characters.

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" Thread Safe");
```

---

## 4.2 Internal Structure

Same as StringBuilder:

```java
char[] value;
int count;
```

Difference: **synchronization**

---

## 4.3 Thread Safety (KEY POINT)

```java
public synchronized StringBuffer append(String str)
```

* Only one thread can access at a time
* Prevents data corruption
* Slower due to locking

---

## 4.4 Methods

All methods are **same as StringBuilder**:

* append
* insert
* replace
* delete
* reverse
* substring
* indexOf
* capacity
* ensureCapacity
* trimToSize

Same behavior, just synchronized.

---

## 4.5 equals() Trap (Same)

```java
StringBuffer sb1 = new StringBuffer("Java");
StringBuffer sb2 = new StringBuffer("Java");

System.out.println(sb1.equals(sb2));
```

**Output**

```
false
```

---

# 5. FINAL COMPARISON TABLE

| Feature           | String | StringBuilder | StringBuffer |
| ----------------- | ------ | ------------- | ------------ |
| Mutable           | No     | Yes           | Yes          |
| Thread-safe       | Yes    | No            | Yes          |
| Synchronized      | No     | No            | Yes          |
| Performance       | Slow   | Fastest       | Medium       |
| equals overridden | Yes    | No            | No           |
| CP / DSA          | No     | Yes           | No           |

---

# 6. INTERVIEW ONE-LINERS

* StringBuilder is preferred in single-threaded environments due to absence of synchronization.
* StringBuffer synchronizes every public method, ensuring thread safety.
* Both use a dynamically growing char array internally.
* equals() is not overridden in StringBuilder/StringBuffer.

---

# 7. FINAL BEST PRACTICES

* Use StringBuilder in loops
* Never use `+` for repeated concatenation
* Predefine capacity
* Convert to String only once
* Use StringBuffer only when thread safety is required

---
