# JAVA STRING METHODS – MASTER INTERVIEW SECTION

## 1. Core String Inspection Methods

These methods are used heavily in **logic building, validations, parsing, and algorithms**.

---

### 1.1 `length()`

**Purpose**
Returns the number of characters in the string.

**Signature**

```java
int length()
```

**Important Points**

* Returns `int`
* Counts **all characters including spaces**
* Time complexity: O(1)

**Example**

```java
String s = "Java Programming";

System.out.println(s.length()); 
// Output: 16
```

---

### 1.2 `isEmpty()` vs `isBlank()` (Java 11+)

#### `isEmpty()`

Checks if length is `0`.

```java
String s = "";
System.out.println(s.isEmpty()); // true
```

#### `isBlank()`

Checks if string contains only whitespaces.

```java
String s = "   ";
System.out.println(s.isBlank()); // true
System.out.println(s.isEmpty()); // false
```

**Interview Tip**

> Use `isBlank()` for user input validation, not `isEmpty()`.

---

## 2. Character Access & Conversion

---

### 2.1 `charAt(int index)`

**Purpose**
Returns character at a given index.

**Signature**

```java
char charAt(int index)
```

**Exceptions**

* `StringIndexOutOfBoundsException` if index < 0 or ≥ length

**Example**

```java
String s = "Rugved";

System.out.println(s.charAt(0)); // R
System.out.println(s.charAt(5)); // d
```

---

### 2.2 `toCharArray()` (VERY IMPORTANT)

**Purpose**
Converts string into a character array.

**Use Cases**

* Character frequency problems
* Palindrome checks
* Encryption / validation logic

**Signature**

```java
char[] toCharArray()
```

**Example**

```java
String s = "Java";

char[] arr = s.toCharArray();
for (char c : arr) {
    System.out.print(c + " ");
}
// Output: J a v a
```

**Interview Note**

> Preferred over repeated `charAt()` in loops for performance.

---

## 3. Substring & Extraction Methods

### 3.1 `substring(int beginIndex)`

```java
String substring(int beginIndex)
```

* Returns substring from index to end
* Index starts at `0`

```java
String s = "RugvedRaorane";

System.out.println(s.substring(6));
// Output: Raorane
```

---

### 3.2 `substring(int beginIndex, int endIndex)`

```java
String substring(int beginIndex, int endIndex)
```

* `beginIndex` → inclusive
* `endIndex` → exclusive

```java
System.out.println(s.substring(6, 9));
// Output: Rao
```

**Exception**

* `StringIndexOutOfBoundsException`

---

## 4. Case Conversion Methods

---

### 4.1 `toUpperCase()` / `toLowerCase()`

```java
String s = "Java";

System.out.println(s.toUpperCase()); // JAVA
System.out.println(s.toLowerCase()); // java
```

**Note**

* Locale-sensitive internally
* Returns new String

---

## 5. Searching & Matching Methods

---

### 5.1 `contains(CharSequence s)`

```java
System.out.println("Java Programming".contains("Program"));
// Output: true
```

---

### 5.2 `startsWith()` / `endsWith()`

```java
String s = "SpringBoot";

System.out.println(s.startsWith("Spring")); // true
System.out.println(s.endsWith("Boot"));     // true
```

---

### 5.3 `indexOf()` / `lastIndexOf()`

```java
String s = "banana";

System.out.println(s.indexOf('a'));     // 1
System.out.println(s.lastIndexOf('a')); // 5
```

Returns:

* index if found
* `-1` if not found

---

## 6. Replacement & Modification-Like Methods

(They **do not modify**, they return new strings)

---

### 6.1 `replace()`

```java
String s = "Java World";

String result = s.replace("World", "Developer");

System.out.println(result);
// Output: Java Developer
```

---

### 6.2 `replaceAll()` vs `replaceFirst()`

* Uses **regex**
* Powerful but slower

```java
String s = "a1b2c3";

System.out.println(s.replaceAll("\\d", ""));
// Output: abc
```

---

## 7. String Comparison Methods

---

### 7.1 `equals()`

```java
String s1 = "Java";
String s2 = new String("Java");

System.out.println(s1.equals(s2)); // true
```

* Case-sensitive
* Content comparison

---

### 7.2 `equalsIgnoreCase()`

```java
System.out.println("java".equalsIgnoreCase("JAVA"));
// true
```

---

### 7.3 `compareTo()` (VERY IMPORTANT)

**Purpose**
Lexicographical comparison using Unicode values.

**Signature**

```java
int compareTo(String anotherString)
```

**Return Values**

* `0` → equal
* `< 0` → calling string is smaller
* `> 0` → calling string is larger

---

#### Basic Example

```java
System.out.println("A".compareTo("B")); // -1
System.out.println("B".compareTo("A")); // 1
System.out.println("A".compareTo("A")); // 0
```

---

#### Sorting Example (INTERVIEW FAVORITE)

```java
String[] names = {"Rugved", "Amit", "Sachin", "Bhavesh"};

Arrays.sort(names);

for (String name : names) {
    System.out.println(name);
}
```

**Output**

```
Amit
Bhavesh
Rugved
Sachin
```

**Explanation**

* Sorting internally uses `compareTo()`
* Based on Unicode values

---

#### Case Sensitivity Trap

```java
System.out.println("apple".compareTo("Banana"));
// Positive value because lowercase > uppercase in Unicode
```

---

## 8. STRING TOKENIZATION – `split()` (EXTREMELY IMPORTANT)

---

### 8.1 What is Tokenization?

> **Breaking a string into smaller parts (tokens) using a delimiter.**

Used in:

* CSV parsing
* User input processing
* Log analysis
* API request parsing

---

### 8.2 `split(String regex)`

```java
String s = "Java,Spring,Hibernate";

String[] tokens = s.split(",");

for (String token : tokens) {
    System.out.println(token);
}
```

---

### 8.3 `split(String regex, int limit)` (INTERVIEW CRITICAL)

---

#### Case 1: limit > 0

```java
String s = "A-B-C-D";

String[] arr = s.split("-", 2);
```

Output:

```
A
B-C-D
```

**Rule**

* Split only `limit - 1` times

---

#### Case 2: limit = 0 (DEFAULT)

```java
String s = "A-B-C-";
String[] arr = s.split("-");
```

Output:

```
A
B
C
```

* Trailing empty strings discarded

---

#### Case 3: limit < 0 (MOST IMPORTANT)

```java
String s = "A-B-C-";
String[] arr = s.split("-", -1);
```

Output:

```
A
B
C

```

**Why important?**

* Preserves empty tokens
* Essential in CSV and file parsing

---

### Regex Trap in `split()`

```java
String s = "1.2.3";
String[] arr = s.split("\\.");
```

**Why `\\.`?**

* `.` is a regex wildcard
* Must be escaped

---

## 9. Whitespace Handling

---

### 9.1 `trim()` vs `strip()`

```java
String s = "   Java   ";

System.out.println(s.trim());
System.out.println(s.strip());
```

* `trim()` → ASCII spaces
* `strip()` → Unicode spaces (preferred)

---

## 10. Passing Strings to Methods (INTERVIEW THEORY)

---

### Java is ALWAYS Pass-by-Value

```java
void modify(String s) {
    s = s + " World";
}

String str = "Hello";
modify(str);

System.out.println(str);
// Output: Hello
```

**Why?**

* Copy of reference is passed
* New String created
* Original reference unchanged

---

### Key Interview Line

> **Java does not support pass-by-reference. For objects, the reference itself is passed by value.**

---

## 11. Best Practices While Working with String

---

### 1. Avoid `+` inside loops

Creates multiple objects.

---

### 2. Use `equals()`, not `==`

Unless explicitly checking references.

---

### 3. Validate input using `isBlank()`

---

### 4. Use `split()` with negative limit for data parsing

---

### 5. Prefer `toCharArray()` for algorithms

---

### 6. Minimize temporary string creation

Especially in large loops or streams.

---

### 7. Be careful with regex in `split()`

Escape special characters.

---

## FINAL INTERVIEW WRAP-UP

* Strings are immutable and memory-optimized
* Most bugs occur due to misuse of `==`, `split()`, and `compareTo()`
* Tokenization and sorting rely heavily on `compareTo()`
* Always remember: **new object is created on every modification**

---