> 🔥 Why is `Scanner` slower than `BufferedReader`?

This is asked in:

*   Java backend interviews
*   System design rounds
*   Competitive coding discussions
*   Performance optimization rounds

***

# ✅ First Look at Both

### Using `Scanner`

```java
Scanner sc = new Scanner(System.in);
String name = sc.nextLine();
int age = sc.nextInt();
```

***

### Using `BufferedReader`

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );

String name = br.readLine();
```

Both:

✔️ Take console input  
✔️ Read text  
✔️ Work fine

BUT:

    BufferedReader is MUCH faster 🚀

***

# 🧠 MAIN REASON

> Scanner does **Parsing + Tokenizing + Regex Matching**

BufferedReader does:

> ONLY raw input reading

***

# ✅ Internal Working

***

## 🔴 Scanner Flow (SLOW)

When you do:

```java
sc.nextInt();
```

Scanner does internally:

    1. Reads raw data
    2. Stores in buffer
    3. Applies REGEX
    4. Tokenizes input
    5. Converts String → int
    6. Returns value

So internally:

    Scanner = Reader + Parser + Tokenizer + Regex Engine

***

### Yes — REGEX is used internally 😱

Example:

```java
nextInt()
```

Uses pattern like:

    Integer Pattern = [-+]?[0-9]+

So every input:

✅ Pattern match  
✅ Validation  
✅ Conversion

➡️ CPU heavy  
➡️ Slower execution

***

# ✅ BufferedReader Flow (FAST)

```java
br.readLine();
```

Internally:

    1. Reads char buffer
    2. Returns String

That's it ✅

No:

❌ Parsing  
❌ Tokenizing  
❌ Regex  
❌ Conversion

So:

    BufferedReader = Raw Fast I/O
    Scanner        = Smart but Slow I/O

***

# ✅ Performance Comparison

Reading 1 Million Integers:

| Method         | Time Taken |
| -------------- | ---------- |
| Scanner        | \~2.5 sec  |
| BufferedReader | \~0.5 sec  |

Scanner is almost:

    5x slower

***

# ✅ Why Competitive Programmers Avoid Scanner?

In:

*   CodeChef
*   LeetCode
*   HackerRank
*   Codeforces

Input size may be:

    10^5
    10^6
    10^7

Scanner may cause:

    TLE (Time Limit Exceeded)

BufferedReader:

    AC ✅

***

# ✅ Example: Fast Input Using BufferedReader

***

## Scanner Version (Slow)

```java
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

for(int i=0;i<n;i++)
{
    int x = sc.nextInt();
}
```

***

## BufferedReader Version (Fast)

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );

int n = Integer.parseInt(br.readLine());

for(int i=0;i<n;i++)
{
    int x = Integer.parseInt(br.readLine());
}
```

***

# ✅ Multiple Input (Space Separated)

Scanner:

```java
int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
```

BufferedReader:

```java
String[] input = br.readLine().split(" ");

int a = Integer.parseInt(input[0]);
int b = Integer.parseInt(input[1]);
int c = Integer.parseInt(input[2]);
```

***

# ⚠️ Scanner Hidden Problem (Very Common Bug)

Mixing:

```java
nextInt()
nextLine()
```

Example:

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
String name = sc.nextLine(); // ❌ Skipped
```

Because:

    nextInt() DOES NOT consume newline

So:

    name = ""

Fix:

```java
sc.nextLine(); // consume leftover newline
String name = sc.nextLine();
```

BufferedReader does NOT have this issue ✅

***

# ✅ When Should You Use Scanner?

Use Scanner when:

✔️ Input is small  
✔️ You need parsing  
✔️ You want easy syntax  
✔️ Code readability matters  
✔️ Not performance critical

***

# ✅ When Should You Use BufferedReader?

Use BufferedReader when:

✔️ Large input  
✔️ Competitive programming  
✔️ Network apps  
✔️ File processing  
✔️ Performance critical systems

***

# 🔥 Interview Answer (Short Form)

### Q:

Why is Scanner slower than BufferedReader?

### ✅ Answer:

Because Scanner performs parsing, tokenizing, and regex matching internally for each input, while BufferedReader reads raw characters directly from buffer without any processing, resulting in fewer CPU cycles and better performance.

***

# 🧠 Memory Trick

    Scanner        = Easy but Slow
    BufferedReader = Hard but Fast

***

# ✅ Best Practice in Real Systems:

Use:

    BufferedReader + Parsing

instead of Scanner for:

*   High throughput
*   Large scale file reading
*   Backend systems
*   APIs
*   Real-time data streams

***
