# REGEX IN JAVA — COMPLETE INTERVIEW NOTES

## 1. What is Regex?

**Regex (Regular Expression)** is a pattern used to **match, search, validate, extract, or replace text**.

### Why Regex is Important

* Input validation (email, phone, password)
* Searching text
* Data extraction from logs/files
* String manipulation
* Parsing structured/unstructured data

---

## 2. Regex Support in Java

Java provides Regex support through the package:

```java
java.util.regex
```

### Important Classes

| Class                  | Description                  |
| ---------------------- | ---------------------------- |
| Pattern                | Represents a compiled regex  |
| Matcher                | Performs matching operations |
| PatternSyntaxException | Thrown for invalid regex     |

---

## 3. Basic Workflow of Regex in Java

1. Write a regex
2. Compile it using `Pattern`
3. Match it using `Matcher`

```java
Pattern p = Pattern.compile("Java");
Matcher m = p.matcher("Java is powerful");
m.find();
```

---

## 4. Simple Regex Using String Methods

Java `String` class provides built-in regex methods:

```java
String s = "abc123";

s.matches("[a-z0-9]+");          // true
s.replaceAll("\\d", "#");        // abc###
s.split("\\d");                  // [abc]
```

---

## 5. Meta Characters (Very Important)

Meta characters have special meaning in regex.

| Symbol | Meaning                      |
| ------ | ---------------------------- |
| .      | Any character except newline |
| ^      | Start of string              |
| $      | End of string                |
| *      | 0 or more                    |
| +      | 1 or more                    |
| ?      | 0 or 1                       |
| []     | Character class              |
| ()     | Grouping                     |
| \      | Escape character             |

---

## 6. Character Classes

### Basic Character Classes

| Pattern  | Meaning           |
| -------- | ----------------- |
| [abc]    | a or b or c       |
| [a-z]    | lowercase letters |
| [A-Z]    | uppercase letters |
| [0-9]    | digits            |
| [a-zA-Z] | letters only      |

### Example

```java
"Java".matches("[A-Z][a-z]+"); // true
```

---

## 7. Predefined Character Classes

| Pattern | Meaning                     |
| ------- | --------------------------- |
| \d      | digit (0–9)                 |
| \D      | non-digit                   |
| \w      | word character (a-zA-Z0-9_) |
| \W      | non-word character          |
| \s      | whitespace                  |
| \S      | non-whitespace              |

Important: In Java, escape with double backslash:

```java
"123".matches("\\d+");
```

---

## 8. Quantifiers

| Quantifier | Meaning         |
| ---------- | --------------- |
| *          | 0 or more       |
| +          | 1 or more       |
| ?          | 0 or 1          |
| {n}        | exactly n       |
| {n,}       | at least n      |
| {n,m}      | between n and m |

### Example

```java
"99999".matches("\\d{5}"); // true
```

---

## 9. Anchors

| Anchor | Meaning         |
| ------ | --------------- |
| ^      | start of string |
| $      | end of string   |
| \b     | word boundary   |

### Example

```java
"Java".matches("^Java$"); // true
```

---

## 10. Groups and Capturing

Groups are created using parentheses `()`.

```java
String text = "John Doe";
Pattern p = Pattern.compile("(John) (Doe)");
Matcher m = p.matcher(text);

if (m.find()) {
    System.out.println(m.group(1)); // John
    System.out.println(m.group(2)); // Doe
}
```

---

## 11. Non-Capturing Groups

```regex
(?:regex)
```

Used when grouping is needed but capturing is not.

---

## 12. Alternation (OR)

```regex
Java|Python|C++
```

Example:

```java
"Java".matches("Java|Python"); // true
```

---

## 13. Greedy vs Lazy Quantifiers

| Type   | Example |
| ------ | ------- |
| Greedy | .*      |
| Lazy   | .*?     |

Example:

```regex
"<.*?>"   // matches shortest HTML tag
```

---

## 14. Common Regex Methods in Matcher

| Method       | Description           |
| ------------ | --------------------- |
| find()       | Finds next match      |
| matches()    | Matches entire input  |
| group()      | Returns matched group |
| start()      | Start index           |
| end()        | End index             |
| replaceAll() | Replace all matches   |

---

## 15. Difference: matches() vs find()

| Method    | Behavior               |
| --------- | ---------------------- |
| matches() | Matches entire string  |
| find()    | Matches part of string |

---

## 16. Escaping Rules in Java Regex

| Regex | Java String |
| ----- | ----------- |
| \d    | "\d"        |
| .     | "\."        |
| \     | "\\"        |

---

# FAMOUS & MOST USED REGEX PATTERNS IN JAVA PROJECTS

## 1. Email Validation

```regex
^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$
```

---

## 2. Mobile Number (India Example)

```regex
^[6-9][0-9]{9}$
```

---

## 3. Password Validation (Strong)

At least:

* 1 uppercase
* 1 lowercase
* 1 digit
* 1 special char
* Min 8 chars

```regex
^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$
```

---

## 4. Username (Alphanumeric, 5–15 chars)

```regex
^[a-zA-Z0-9]{5,15}$
```

---

## 5. Date (DD/MM/YYYY)

```regex
^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$
```

---

## 6. Only Digits

```regex
^\d+$
```

---

## 7. Only Alphabets

```regex
^[a-zA-Z]+$
```

---

## 8. Alphanumeric with Space

```regex
^[a-zA-Z0-9 ]+$
```

---

## 9. PAN Card (India)

```regex
^[A-Z]{5}[0-9]{4}[A-Z]$
```

---

## 10. URL Validation

```regex
^(https?|ftp)://[^\s/$.?#].[^\s]*$
```

---

## 11. Extract Numbers from String

```regex
\d+
```

---

## 12. Remove Special Characters

```regex
[^a-zA-Z0-9 ]
```

---

## 13. IP Address (IPv4)

```regex
^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}
(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$
```

---

## 14. HTML Tag Removal

```regex
<[^>]+>
```

---

## 15. Whitespace Removal

```regex
\s+
```

---

# INTERVIEW TIPS

* Always mention `Pattern` and `Matcher`
* Know difference between `matches()` and `find()`
* Explain greedy vs lazy
* Mention escaping rules in Java
* Use lookahead in password validation
