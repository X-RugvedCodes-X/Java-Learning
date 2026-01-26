# JAVA STRING – MASTER CLASS (INTERVIEW ORIENTED)

## 1. What is a String in Java? (Interview Opening Answer)

> **In Java, `String` is an immutable class that represents a sequence of characters. It is stored in a special memory area called the String Constant Pool (SCP), and once created, its content cannot be changed.**

Key facts interviewers expect:

* `String` is a **class**, not a primitive
* Located in `java.lang`
* Immutable by design
* Thread-safe by nature
* Uses **String Constant Pool** for memory optimization

---

## 2. How Strings Are Stored Under the Hood (VERY IMPORTANT)

### 2.1 Memory Areas Involved

| Component          | Stored In                          |
| ------------------ | ---------------------------------- |
| Reference variable | Stack                              |
| String object      | Heap                               |
| String literal     | String Constant Pool (inside Heap) |

---

## 3. String Constant Pool (SCP)

### What is SCP?

* A **special memory region inside the Heap**
* Stores **unique string literals**
* Used to save memory by reusing identical strings

---

## 4. String Creation Scenarios (MOST IMPORTANT INTERVIEW SECTION)

---

### 4.1 String Created Using Literal

```java
String s1 = "Java";
String s2 = "Java";
```

#### What happens internally?

* `"Java"` is created **once** in SCP
* `s1` and `s2` both **point to the same object**

```java
System.out.println(s1 == s2);       // true
System.out.println(s1.equals(s2));  // true
```

#### Memory:

```
SCP:
"Java"  ← s1, s2
```

---

### 4.2 String Created Using `new` Keyword

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

#### What happens internally?

* One `"Java"` created in SCP (if not already present)
* **Two separate objects created in Heap**
* References point to different objects

```java
System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2));// true
```

#### Memory:

```
Heap:     "Java" ← s1
Heap:     "Java" ← s2
SCP:      "Java"
```

---

### INTERVIEW ONE-LINER

> **Using `new` always creates a new object in heap, whereas literals reuse existing objects from SCP.**

---

## 5. Immutability of String (CORE CONCEPT)

```java
String s = "Java";
s.concat(" World");
System.out.println(s);
```

### Output

```
Java
```

### Why?

* `concat()` creates a **new object**
* Original `s` still refers to `"Java"`

Correct way:

```java
s = s.concat(" World");
System.out.println(s);
```

### Output

```
Java World
```

---

### Interview Definition

> **String immutability means once a String object is created, its content cannot be changed. Any modification results in a new object.**

---

## 6. `==` vs `.equals()` (TOP INTERVIEW QUESTION)

---

### 6.1 `==` Operator

* Compares **references (memory address)**
* NOT content

```java
String s1 = "Java";
String s2 = "Java";
System.out.println(s1 == s2);
```

Output:

```
true
```

Reason: Same SCP object

---

```java
String s1 = new String("Java");
String s2 = new String("Java");
System.out.println(s1 == s2);
```

Output:

```
false
```

Reason: Different heap objects

---

### 6.2 `.equals()` Method

* Compares **actual content**
* Overridden in `String` class

```java
System.out.println(s1.equals(s2));
```

Output:

```
true
```

---

### Interview Summary Table

| Comparison  | `==`         | `.equals()` |
| ----------- | ------------ | ----------- |
| Compares    | Reference    | Content     |
| Overridden? | No           | Yes         |
| Use case    | Memory check | Value check |

---

## 7. String Interning

```java
String s1 = new String("Java");
String s2 = s1.intern();
String s3 = "Java";

System.out.println(s2 == s3); // true
```

### Explanation:

* `intern()` returns SCP reference
* Useful for memory optimization

---