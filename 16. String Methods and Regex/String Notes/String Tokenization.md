# PART 1: `split(String regex, int limit)` — HOW IT REALLY WORKS

---

## 1. What `split()` Actually Does Internally

When you call:

```java
String[] result = input.split(regex, limit);
```

Internally Java does the following:

1. Treats `regex` as a **regular expression**
2. Scans the string **from left to right**
3. Every time it finds a **regex match**, it cuts the string
4. Stores resulting substrings into a **String[]**
5. Applies **limit rules** to decide:

   * how many splits are allowed
   * whether to keep or discard empty strings

---

## 2. Meaning of `limit` (THIS IS WHERE MOST CONFUSION HAPPENS)

### Rule Summary (Memorize for Interview)

| limit value | Behavior                                                        |
| ----------- | --------------------------------------------------------------- |
| `> 0`       | Perform **at most `limit-1` splits**                            |
| `= 0`       | Perform **all possible splits**, discard trailing empty strings |
| `< 0`       | Perform **all possible splits**, KEEP trailing empty strings    |

---

## 3. Case-by-Case Execution (STEP BY STEP)

---

## CASE 1: `limit > 0`

### Example

```java
String s = "A-B-C-D";
String[] arr = s.split("-", 2);
```

### Step-by-step execution

Input string:

```
A-B-C-D
```

Limit = 2
So maximum splits allowed = `limit - 1 = 1`

Execution:

* First `-` found → split happens
* Remaining string is **NOT split further**

Result:

```
arr[0] = "A"
arr[1] = "B-C-D"
```

### Output

```java
A
B-C-D
```

### Interview Line

> When limit is positive, Java performs only `limit - 1` splits and puts the remaining string as the last element.

---

## CASE 2: `limit = 0` (DEFAULT BEHAVIOR)

### Example

```java
String s = "A-B-C-";
String[] arr = s.split("-");
```

Equivalent to:

```java
s.split("-", 0);
```

### Step-by-step execution

Raw split result before limit processing:

```
["A", "B", "C", ""]
```

Now Java applies limit = 0 rule:

* **Remove trailing empty strings**

Final Result:

```
["A", "B", "C"]
```

### Output

```java
A
B
C
```

### Interview Line

> `limit = 0` removes only trailing empty strings, not leading or middle empty strings.

---

## CASE 3: `limit < 0` (MOST IMPORTANT FOR REAL PROJECTS)

### Example

```java
String s = "A-B-C-";
String[] arr = s.split("-", -1);
```

### Step-by-step execution

* Perform **all possible splits**
* **DO NOT discard empty strings**

Result:

```
["A", "B", "C", ""]
```

### Output

```java
A
B
C

```

### WHY THIS IS IMPORTANT

Used in:

* CSV files
* Fixed-format data
* API payload parsing

Example:

```
id,name,age,
```

If you don’t use `-1`, the last empty column is lost.

### Interview Line

> Always use negative limit when empty trailing fields are meaningful.

---

## 4. Regex Pitfalls in `split()`

### Example (COMMON INTERVIEW TRAP)

```java
String s = "1.2.3";
String[] arr = s.split(".");
```

### What happens?

`.` in regex means **any character**

So it splits **everything**, result is empty.

### Correct Way

```java
String[] arr = s.split("\\.");
```

### Interview Line

> `split()` takes regex, not plain text — special characters must be escaped.

---

# PART 2: INSERTING OR REPLACING CONTENT INSIDE A STRING

**Very Important Rule**

> `String` is immutable — you CANNOT modify it in place.
> Every insertion or replacement creates a NEW string.

---

## 5. How to INSERT Something at a Given Position in a String

### There is NO `insert()` in `String`

So we do it manually using:

* `substring()`
* concatenation

---

### Example: Insert `"XYZ"` at index 3

```java
String s = "ABCDEFG";

// Split string into two parts
String first = s.substring(0, 3);   // ABC
String second = s.substring(3);     // DEFG

// Insert in between
String result = first + "XYZ" + second;

System.out.println(result);
```

### Output

```
ABCXYZDEFG
```

### Interview Explanation

* First part → before insertion index
* Second part → from insertion index onwards
* Concatenate all

---

## 6. Replace Content at a Specific Position

---

### Replace characters between index 2 and 5

```java
String s = "ABCDEFG";

// Replace CDE with XYZ
String result =
        s.substring(0, 2)   // AB
      + "XYZ"
      + s.substring(5);    // FG

System.out.println(result);
```

### Output

```
ABXYZFG
```

---

## 7. Replace Using `replace()` vs Position-Based Replace

### Using `replace()` (Content-based)

```java
String s = "Java World";
System.out.println(s.replace("World", "Developer"));
```

Output:

```
Java Developer
```

### Limitation

* Cannot control **index**
* Replaces **all matching content**

---

### Position-based replace (Preferred in Interviews)

Use `substring()` approach shown above.

---

## 8. Insert or Replace Using `char[]` (Algorithmic Way)

Used in competitive programming.

```java
String s = "ABCDE";
char[] arr = s.toCharArray();

arr[2] = 'X'; // Replace character at index 2

String result = new String(arr);

System.out.println(result);
```

### Output

```
ABXDE
```

---

## 9. Passing Strings to Methods — Why Insert Doesn’t Reflect Back

```java
static void insertText(String s) {
    s = s.substring(0, 2) + "XYZ" + s.substring(2);
}

public static void main(String[] args) {
    String str = "ABCDE";
    insertText(str);
    System.out.println(str);
}
```

### Output

```
ABCDE
```

### Why?

* Java passes **copy of reference**
* New string created inside method
* Original reference unchanged

### Correct Way

```java
static String insertText(String s) {
    return s.substring(0, 2) + "XYZ" + s.substring(2);
}
```

---

## 10. Best Practices for Insertion & Replacement Using String

1. Always remember: **new object is created**
2. Prefer index-based logic in interviews
3. Use `split(limit < 0)` for data parsing
4. Avoid repeated concatenation in loops
5. Escape regex in `split()`
6. Validate index bounds before substring

---

## FINAL INTERVIEW ONE-LINERS (GOLD)

* `split()` uses regex, not characters
* Positive limit controls number of splits
* Negative limit preserves empty tokens
* Strings cannot be modified — only replaced
* All insertions are done via substring + concatenation
* Java is pass-by-value even for object references

---
