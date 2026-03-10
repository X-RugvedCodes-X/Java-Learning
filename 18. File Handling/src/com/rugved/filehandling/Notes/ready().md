
***

# ✅ What does `ready()` actually do?

`ready()` is a method of:

```java
Reader.ready()
```

### Definition (in simple words):

> **Returns true if the stream is ready to be read *without blocking*.**

It checks:

✔️ Is data already available in the buffer?  
✔️ Can `read()` be called immediately?  
❌ It does NOT check EOF  
❌ It does NOT mean more data will never come  
❌ It does NOT mean stream has ended

***

# 📌 Internal Meaning

When you call:

```java
in.ready()
```

You're asking:

> “If I call `read()` right now… will it block the thread waiting for input?”

***

# ⚠️ VERY IMPORTANT

It **DOES NOT MEAN**

```java
ready() == false  → stream ended ❌
ready() == true   → stream has data forever ❌
```

It only means:

| ready() | Meaning                         |
| ------- | ------------------------------- |
| true    | read() will NOT block right now |
| false   | read() MAY block                |

That’s it.

***

# 🧠 Why does blocking matter?

Streams like:

```java
System.in
Socket input stream
File stream
Network stream
Pipe stream
```

may **block your thread** if no data is available.

Example:

```java
int ch = in.read();
```

If user hasn’t typed anything:

➡️ Your program will pause  
➡️ Thread waits  
➡️ This is called **blocking I/O**

***

# ✅ How `ready()` helps

It helps you avoid blocking reads in:

*   GUI apps
*   Network apps
*   Multithreaded servers
*   Real‑time processing

***

# ✅ Example 1 — Using `ready()` correctly

```java
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

while (true) {

    if (br.ready()) {       // Non‑blocking check
        int ch = br.read(); // Safe: won't block
        System.out.print((char) ch);
    }

    System.out.println("Doing other work...");
    Thread.sleep(1000);
}
```

Here:

*   Program keeps running
*   Reads input only when available
*   Doesn't pause execution

***

# ❌ Example 2 — WRONG Usage (EOF check)

```java
while(br.ready())   // ❌ WRONG
{
    System.out.println((char) br.read());
}
```

Why?

Imagine:

User types:

    Hello

After reading `H`

Buffer becomes empty momentarily

Now:

```java
ready() == false
```

➡️ Loop exits  
➡️ But stream is NOT ended  
➡️ User may type more later

So you're **mistaking temporary absence of data for EOF**

***

# ✅ EOF vs ready()

| Concept            | Method         |
| ------------------ | -------------- |
| EOF check          | `read() == -1` |
| Non‑blocking check | `ready()`      |

***

# ✅ Example — System.in behavior

```java
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

System.out.println(br.ready());
```

You haven't typed anything.

Output:

    false

But is stream ended?

❌ NO

You can still type input later.

So:

```java
ready() == false
```

≠

```java
EOF reached
```

***

# 🔥 Interview Trick Question

### Q:

Can `ready()` be used instead of:

```java
while((ch = read()) != -1)
```

### ✅ Answer:

NO.

Because:

*   `ready()` only checks buffer state
*   It doesn't detect EOF
*   Stream may still have incoming data later

***

# ✅ Where should you use ready()?

Mostly in:

✔️ Event-driven systems  
✔️ Network chat apps  
✔️ Console tools doing background tasks  
✔️ GUI apps avoiding UI freeze  
✔️ Multithreaded polling systems

***

# ✅ Real-Life Use Case (Socket Example)

```java
BufferedReader socketReader = ...

while(true)
{
    if(socketReader.ready())
    {
        String msg = socketReader.readLine();
        System.out.println(msg);
    }

    doBackgroundWork();
}
```

Without `ready()`:

```java
socketReader.readLine();
```

➡️ Thread blocks  
➡️ Server freezes waiting for client  
➡️ BAD design

***

# ⚠️ Another Gotcha

`ready()` works **reliably only with buffered streams**

Good:

```java
BufferedReader
```

Unreliable:

```java
InputStreamReader
FileReader
```

Why?

Because buffering is what tells you:

> "Hey, I already have some characters available."

***

# ✅ Best Practice Rule

| Use Case              | Method         |
| --------------------- | -------------- |
| Reading till EOF      | `read() != -1` |
| Avoid blocking        | `ready()`      |
| Reading console lines | `readLine()`   |
| Network polling       | `ready()`      |
| File reading          | `read()`       |

***

# 🧠 One-Line Memory Trick

> **`ready()` checks availability, not completion**

***

