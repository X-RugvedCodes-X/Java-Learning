***

# 🎯 1. HIGH‑LEVEL GOAL (WHAT ARE WE TRYING TO ACHIEVE?)

***

Normally when you read a file using:

```java
BufferedReader br = new BufferedReader(...)
```

The flow is:

    Disk
     ↓
    OS Kernel Buffer
     ↓
    JVM Heap Memory
     ↓
    Your Program

So:

✅ Data is copied from disk  
✅ Then copied again into JVM Heap  
✅ Then GC manages it  
✅ Then you process it

This causes:

    Heap pressure ❌
    Extra memory copies ❌
    GC overhead ❌
    Slower for GB/TB files ❌

***

# ✅ WHAT WE WANT TO DO INSTEAD

We want:

    ❌ NOT copy file into JVM Heap

Instead:

    ✅ Make file appear as memory

So that:

    Disk File → Virtual Memory

And when we do:

```java
buffer.get()
```

OS loads only that required page (4KB) into RAM.

This is called:

    Demand Paging

So our AIM is:

***

## ✅ AIM:

> Map the file into the process's virtual memory so that file data can be accessed like RAM without explicitly copying it into the JVM heap.

So we get:

✅ Constant memory usage  
✅ No heap pressure  
✅ OS Page Cache usage  
✅ Lazy loading  
✅ Works for TB files

***

# 🧠 Now Let’s Explain Your CODE

***

# ✅ FUNCTION 1 — `fileRead(Path path)`

***

## 🔹 Opening FileChannel

```java
try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
```

This:

✅ Opens file in READ mode  
✅ Returns a FileChannel

A **FileChannel** is:

    Low-level NIO file access API

Unlike:

    FileReader → Stream API

Channel works with:

    Direct Memory (Off Heap)

***

## 🔹 Get File Size

```java
long fileSize = fileChannel.size();
```

This asks OS:

    What is the total size of this file?

Needed because:

    We must know how much to map

***

## 🔹 Define Chunk Size

```java
final long CHUNK_SIZE = 1024 * 1024 * 100;
```

This is:

    100 MB

Why chunk?

Because:

    Max mmap ≈ 2GB per mapping

Mapping TB file at once ❌  
So we map:

    Piece by piece ✅

***

## 🔹 Current Mapping Start

```java
long position = 0;
```

This tells:

    Which part of file are we mapping?

***

## 🔹 Loop Until Full File Mapped

```java
while (position < fileSize) {
```

Loop continues until:

    Entire file mapped

***

## 🔹 Calculate Remaining

```java
long remaining = Math.min(CHUNK_SIZE, fileSize - position);
```

Suppose:

    File = 1GB
    Position = 900MB

Remaining = 100MB

So we map:

    Only available part

***

## 🔹 MEMORY MAPPING (IMPORTANT LINE)

***

### ✅ LARGE FILE VERSION:

```java
MappedByteBuffer buffer =
    fileChannel.map(
        FileChannel.MapMode.READ_ONLY,
        position,
        remaining
    );
```

This:

Does NOT read file.

Instead OS:

    Maps [position → position+remaining]
    into Virtual Memory

So:

    File becomes addressable like RAM

NO Heap usage ✅

***

### ❌ SMALL FILE VERSION (YOUR CURRENT CODE):

```java
MappedByteBuffer buffer =
    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
```

This maps entire file every iteration 😄

So your loop is useless here.

Correct for small file is:

    Remove loop completely

***

## 🔹 Process That Chunk

```java
processChunk(buffer);
```

Now we read mapped memory.

***

## 🔹 Move To Next Chunk

```java
position += remaining;
```

Move forward in file.

***

***

# ✅ FUNCTION 2 — `processChunk(MappedByteBuffer buffer)`

***

## 🔹 Create RAM Batch

```java
StringBuilder batch = new StringBuilder();
```

We collect characters:

    Before printing

Why?

Because:

    System.out.print() = syscall

Batching reduces:

    Thousands of syscalls → few

***

## 🔹 Batch Limit

```java
int batchSize = 10_000;
```

After 10,000 chars:

    Print once

***

## 🔹 Loop Through Mapped Memory

```java
while(buffer.hasRemaining()) {
```

Checks:

    More mapped bytes available?

***

## 🔹 Read One Byte

```java
char c = (char) buffer.get();
```

Here:

    buffer.get()

Triggers:

✅ Virtual Address access  
If page not in RAM:

🚨 Page Fault happens  
OS loads 4KB page from disk

Lazy loading ✅

***

## 🔹 Add To Batch

```java
batch.append(c);
```

Store in RAM.

***

## 🔹 If Batch Full

```java
if (batch.length() >= batchSize)
```

***

## 🔹 Print Once

```java
System.out.print(batch);
batch.setLength(0);
```

Clear memory.

***

## 🔹 Print Remaining

```java
System.out.println(batch);
```

After loop ends.

***

# ✅ FINAL EXECUTION FLOW

    Java → map()
     ↓
    JVM → OS mmap()
     ↓
    OS maps file into Virtual Memory
     ↓
    buffer.get()
     ↓
    Page Fault (if needed)
     ↓
    Load 4KB page into RAM
     ↓
    Process

***

# 🧠 MEMORY SUMMARY

| Memory Type    | Managed By |
| -------------- | ---------- |
| Heap           | JVM        |
| Virtual Memory | OS         |
| Physical RAM   | MMU        |

MappedByteBuffer uses:

    Virtual Memory
    NOT Heap

***

# 🔥 INTERVIEW ONE-LINER

> Memory-mapped I/O allows files to be mapped into the process's virtual address space so that file data can be accessed directly through memory without copying into JVM heap, improving scalability for very large files.

***

