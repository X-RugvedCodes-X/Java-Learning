
***

# ✅ 1. What is `available()`?

`available()` belongs to:

```java
InputStream.available()
```

***

### 📌 Definition:

> Returns the number of bytes that can be read **without blocking** from the input stream.

***

### Meaning:

When you call:

```java
in.available();
```

You're asking:

> "How many bytes can I read RIGHT NOW without the program waiting?"

***

# ✅ Example:

```java
InputStream in = new FileInputStream("test.txt");

System.out.println(in.available());
```

Suppose file contains:

    HELLO

Output:

    5

Because:

    H E L L O
    1 2 3 4 5

5 bytes available immediately ✅

***

# ⚠️ HUGE INTERVIEW GOTCHA

`available()` **does NOT mean**:

❌ Total file size  
❌ Total remaining bytes  
❌ EOF detection

***

# ❌ WRONG CODE (Most asked interview trap)

```java
byte[] data = new byte[in.available()];
in.read(data);
```

***

### Why this is WRONG?

Because:

> `available()` returns only **currently readable bytes**

For:

| Stream Type     | Behavior   |
| --------------- | ---------- |
| FileInputStream | Might work |
| Network stream  | WRONG      |
| Socket stream   | WRONG      |
| Pipe stream     | WRONG      |
| System.in       | WRONG      |

For sockets:

```java
available() == 0
```

Even though data may arrive later!

So this:

```java
new byte[in.available()]
```

Creates:

    new byte[0]

Then:

```java
in.read(data);
```

Reads nothing ❌

***

# ✅ Correct Way to Read Streams

Always use:

```java
byte[] buffer = new byte[1024];
int bytesRead;

while((bytesRead = in.read(buffer)) != -1)
{
    System.out.println(bytesRead);
}
```

Because:

```java
read() == -1
```

is the **ONLY reliable EOF check**

***

# ✅ 2. What is `ready()`?

`ready()` belongs to:

```java
Reader.ready()
```

***

### 📌 Definition:

> Returns true if the next `read()` **will not block**

It checks:

✔️ Character buffer state  
❌ EOF  
❌ Stream completion

***

# ✅ Example:

```java
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

System.out.println(br.ready());
```

You haven't typed anything:

Output:

    false

But:

❌ Stream has NOT ended  
✅ Data may still come later

***

# ✅ So Now:

| Method      | Checks                 |
| ----------- | ---------------------- |
| available() | Byte availability      |
| ready()     | Character availability |

***

# 🧠 Core Difference

| Feature          | available()     | ready()           |
| ---------------- | --------------- | ----------------- |
| Belongs to       | InputStream     | Reader            |
| Works on         | Byte Streams    | Character Streams |
| Returns          | int             | boolean           |
| Checks           | bytes in buffer | char in buffer    |
| Avoids blocking? | ✅ Yes           | ✅ Yes             |
| Detects EOF?     | ❌ No            | ❌ No              |
| Total size?      | ❌ No            | ❌ No              |
| Future data?     | ❌ No            | ❌ No              |
| Network safe?    | ❌ No            | ⚠️ Partially      |

***

# 🔥 Most Important Interview Question

### Q:

Can we use:

```java
while(in.available() > 0)
```

instead of:

```java
while(in.read() != -1)
```

***

### ✅ Correct Answer:

NO.

Because:

*   available() checks only current buffer
*   stream may still have more incoming data later
*   loop may exit prematurely

***

# ❌ WRONG EOF Detection Using available()

```java
while(in.available() > 0)
{
    System.out.print((char) in.read());
}
```

If reading from socket:

After first read:

    available() → 0

Loop exits ❌

But sender may send more data later!

***

# ✅ Correct EOF Detection

Always:

```java
int ch;

while((ch = in.read()) != -1)
{
    System.out.print((char) ch);
}
```

***

# ✅ When Should You Use available()?

Only when you want:

✔️ Non‑blocking peek  
✔️ Know temporary buffer size  
✔️ Skip immediate bytes  
✔️ Polling logic  
✔️ Real‑time byte consumption

***

# ✅ Real Use Case Example

```java
InputStream in = socket.getInputStream();

while(true)
{
    if(in.available() > 0)
    {
        int data = in.read();
        System.out.print((char) data);
    }

    doBackgroundWork();
}
```

Program continues even when no data arrives ✅

***

# ⚠️ Final Golden Rules (Interviews Love These)

✅ `read() == -1` → EOF  
✅ `available()` → current byte buffer  
✅ `ready()` → current char buffer  
❌ Neither detects stream end  
❌ Neither gives full size  
❌ Neither predicts future input

***

# 🧠 One Line Memory Trick

    available() → How much NOW?
    ready()     → Can I read NOW?
    read()      → Is it OVER?

***
