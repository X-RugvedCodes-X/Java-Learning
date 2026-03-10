
***

# 🧠 First Understand This:

## I/O is SLOW

Reading from:

*   Keyboard
*   File
*   Network
*   Disk
*   Socket

means:

➡️ JVM must talk to OS  
➡️ OS must talk to hardware

Every time you do:

```java
read()
```

JVM makes a **System Call** (aka Kernel Call)

And:

> System Calls are EXPENSIVE ⚠️

***

# 🔴 Case 1: Using Only `InputStreamReader`

```java
InputStreamReader in = new InputStreamReader(System.in);

int ch;
while((ch = in.read()) != -1)
{
    System.out.print((char) ch);
}
```

***

## What happens internally?

You type:

    HELLO

Now loop runs:

| Loop | read() | JVM → OS Call |
| ---- | ------ | ------------- |
| 1    | H      | syscall       |
| 2    | E      | syscall       |
| 3    | L      | syscall       |
| 4    | L      | syscall       |
| 5    | O      | syscall       |

➡️ 5 Characters  
➡️ 5 System Calls ❌

Each:

    read()

Triggers:

    JVM → OS → Hardware → OS → JVM

So performance becomes:

    VERY SLOW

Especially for:

*   Large files
*   Network streams
*   Big logs
*   Real-time systems

***

# ✅ Case 2: Using `BufferedReader`

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );
```

Now:

```java
br.read();
```

***

## What happens internally?

Instead of reading **1 character at a time**,  
`BufferedReader` does this:

### Step 1:

Reads:

    8192 characters (default buffer size)

from OS in **ONE SYSTEM CALL**

***

### Step 2:

Stores internally in:

    char buffer[8192]

inside JVM memory ✅

***

### Step 3:

Now when you call:

```java
br.read()
```

It DOES NOT go to OS again.

It reads from:

    RAM (buffer)

***

# ✅ So for "HELLO":

| Method            | OS Calls |
| ----------------- | -------- |
| InputStreamReader | 5 ❌      |
| BufferedReader    | 1 ✅      |

***

# 📊 Real Performance Example

Reading 1MB file:

| Class             | System Calls |
| ----------------- | ------------ |
| InputStreamReader | \~1,000,000  |
| BufferedReader    | \~122        |

Because:

    1MB / 8192 ≈ 122

***

# 🚀 Why RAM Access is Faster?

| Operation   | Time         |
| ----------- | ------------ |
| RAM Read    | Nanoseconds  |
| Disk Read   | Milliseconds |
| System Call | Microseconds |

So:

    BufferedReader avoids System Calls

and uses:

    Fast JVM Memory Access

***

# 🧠 Internal Flow Comparison

***

## Without Buffer:

    Program
      ↓
    InputStreamReader.read()
      ↓
    JVM
      ↓
    OS
      ↓
    Hardware
      ↓
    OS
      ↓
    JVM
      ↓
    Program

For EVERY character ❌

***

## With BufferedReader:

    Program
      ↓
    BufferedReader.read()
      ↓
    Checks internal buffer
      ↓
    If empty:
        ONE syscall → Fill 8192 chars
    Else:
        Return from RAM ✅

***

# ✅ `readLine()` Superpower

`BufferedReader` also gives:

```java
readLine()
```

Which:

✔️ Reads full line  
✔️ Avoids manual loops  
✔️ Uses buffer internally  
✔️ Faster parsing

Example:

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );

String line = br.readLine();
```

***

# 🔥 Interview Question:

### Q:

Why do we wrap:

```java
new BufferedReader(
    new InputStreamReader(System.in)
)
```

***

### ✅ Answer:

Because:

*   `System.in` → byte stream
*   `InputStreamReader` → converts bytes → characters
*   `BufferedReader` → reduces system calls using buffering

So:

| Layer             | Role               |
| ----------------- | ------------------ |
| System.in         | byte source        |
| InputStreamReader | byte → char        |
| BufferedReader    | performance buffer |

***

# ⚠️ Bonus Interview Trap

### Q:

Is this enough?

```java
InputStreamReader in = new InputStreamReader(System.in);
```

### ✅ Answer:

NO — because it still reads character-by-character from OS.

Need:

```java
BufferedReader
```

to reduce system calls.

***

# ✅ Same Concept Applies To:

| Slow         | Fast                 |
| ------------ | -------------------- |
| FileReader   | BufferedReader       |
| FileWriter   | BufferedWriter       |
| InputStream  | BufferedInputStream  |
| OutputStream | BufferedOutputStream |

***

# 🧠 One-Line Memory Trick

    BufferedReader = Fewer System Calls = Faster I/O

***

# ✅ Best Practice Always:

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );
```

***
