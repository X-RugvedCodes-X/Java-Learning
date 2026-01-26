# 1. INPUT FOR DSA

In real problems (LeetCode, Codeforces, interviews), input is **NOT clean**.

You’ll see things like:

```
[1,2,3,4]
{1, 2, 3, 4}
1 2 3 4
1,2,3,4
```

Mixed formats:

```
5
[1,2,3,4,5]
```

2D formats:

```
[[1,2,3],[4,5,6]]
```

or

```
3 3
1 2 3
4 5 6
7 8 9
```

So the **core skill** is:

> Convert ugly input → clean tokens → numbers

---

# 2. GENERAL INPUT PROCESSING STRATEGY (ALWAYS FOLLOW THIS)

### Step-by-step mental model

1. **Read entire line as `String`**
2. **Clean unwanted characters** (`[ ] { }`)
3. **Split using correct delimiter**
4. **Convert tokens to int using streams**
5. **Store in array / matrix**

This avoids 90% of Scanner bugs.

---

# 3. LINE CLEANING (MOST IMPORTANT SKILL)
### Universal Cleaning Regex

```java
line = line.replaceAll("[\\[\\]{}]", "");
```

This removes:

* `[`
* `]`
* `{`
* `}`

After cleaning:

```
[1, 2, 3]   →  1, 2, 3
{1,2,3}    →  1,2,3
```

---

# 4. 1D ARRAY INPUT PROCESSING

## CASE 1: Input like `[1,2,3,4]` or `{1, 2, 3, 4}`

### Using Streams (Cleanest & Interview-Friendly)

```java
import java.util.*;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read the full line
    String line = sc.nextLine();

    // Remove brackets {} []
    line = line.replaceAll("[\\[\\]{}]", "");

    // Split by comma or space (handles "1,2" and "1 2")
    int[] arr = Arrays.stream(line.split("[,\\s]+"))
                      .mapToInt(Integer::parseInt)
                      .toArray();

    // Print to verify
    System.out.println(Arrays.toString(arr));
  }
}
```

### Why this works

* `[,\s]+` handles commas and spaces
* Streams avoid manual loops
* Robust for CP input

---

## CASE 2: Codeforces-style input (space separated)

```
1 2 3 4 5
```

```java
int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                  .mapToInt(Integer::parseInt)
                  .toArray();
```

---

## CASE 3: Mixed input (number first, then array)

```
5
[1,2,3,4,5]
```

### Correct Pattern (IMPORTANT)

```java
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
sc.nextLine(); // consume leftover newline (VERY IMPORTANT)

String line = sc.nextLine();
line = line.replaceAll("[\\[\\]{}]", "");

int[] arr = Arrays.stream(line.split("[,\\s]+"))
                  .mapToInt(Integer::parseInt)
                  .toArray();
```

---

# 5. 2D ARRAY INPUT PROCESSING

## CASE 1: Input like `[[1,2,3],[4,5,6]]`

### Step-by-step approach

1. Remove outer brackets
2. Split rows
3. Parse each row

### Stream-based Solution

```java
import java.util.*;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String line = sc.nextLine();

    // Remove outer brackets
    line = line.substring(1, line.length() - 1);

    // Split rows
    String[] rows = line.split("\\],\\[");

    int[][] matrix = Arrays.stream(rows)
            .map(row -> row.replaceAll("[\\[\\]]", ""))
            .map(row -> Arrays.stream(row.split(","))
                              .mapToInt(Integer::parseInt)
                              .toArray())
            .toArray(int[][]::new);

    // Print matrix
    for (int[] r : matrix) {
        System.out.println(Arrays.toString(r));
    }
  }
}
```

---

## CASE 2: Codeforces-style 2D input

```
3 3
1 2 3
4 5 6
7 8 9
```

### Best CP Pattern

```java
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int m = sc.nextInt();
sc.nextLine(); // consume newline

int[][] matrix = new int[n][m];

for (int i = 0; i < n; i++) {
  matrix[i] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
}
```

---

# 6. MIXED INPUT (REAL INTERVIEW STYLE)

```
2
[1,2,3]
[4,5,6]
```

```java
int rows = sc.nextInt();
sc.nextLine();

int[][] matrix = new int[rows][];

for (int i = 0; i < rows; i++) {
  String line = sc.nextLine()
                  .replaceAll("[\\[\\]]", "");

  matrix[i] = Arrays.stream(line.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
}
```

---

# 7. SCANNER PITFALL: `nextInt()` + `nextLine()` (VERY IMPORTANT)

## Why the bug happens

Input:

```
5
[1,2,3]
```

Buffer internally:

```
5\n[1,2,3]\n
```

### Buggy Code

```java
int n = sc.nextInt();
String s = sc.nextLine(); // reads leftover '\n'
```

`s` becomes empty.

---

## GOLDEN FIX (MEMORIZE)

```java
int n = sc.nextInt();
sc.nextLine(); // ALWAYS consume newline
String s = sc.nextLine();
```

---

## Interview One-Liner

> Scanner methods like `nextInt()` do not consume the newline character, so `nextLine()` must explicitly clear it.

---

# 8. BEST PRACTICES FOR CP / DSA INPUT

1. Prefer `nextLine()` + parsing over `nextInt()` chains
2. Always clean input before splitting
3. Use regex `[,\s]+` for flexible tokenization
4. Always handle leftover newline
5. Streams make logic shorter but clarity > cleverness
6. Validate array length if input is user-provided
7. For CP speed, BufferedReader is faster (Scanner is fine for learning)

---
