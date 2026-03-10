# Java I/O Streams & File Handling — Complete Notes (with Examples & Interview Gotchas)

These notes give you a practical, “from-zero-to-pro” tour of Java I/O: streams, readers/writers, buffering, encoding, files/paths (classic `java.io.File` and NIO.2 `java.nio.file`), channels, serialization, and the common pitfalls interviewers love.

***

## 1) What is an `IOException`?

An `IOException` signals an I/O failure: filesystem errors (file not found, no permissions), stream failures, network errors, encoding/decoding errors, unexpected EOF, etc.

**Key subtypes you’ll meet:**

*   `FileNotFoundException` (extends `IOException`)
*   `EOFException` (end-of-file reached prematurely)
*   `UnsupportedEncodingException` / `MalformedInputException` (encoding-related)
*   `UncheckedIOException` (runtime wrapper introduced for lambdas / streams)

**Example: declare & handle**

```java
// Propagate
void loadConfig(Path path) throws IOException {
    List<String> lines = Files.readAllLines(path);
}

// Handle with try-catch
try {
    List<String> lines = Files.readAllLines(Path.of("config.txt"));
} catch (IOException e) {
    // log + fallback
    System.err.println("Failed to read config: " + e.getMessage());
}
```

***

## 2) Streams: The Abstraction

A **stream** is a sequence of data connected to a source/sink: files, sockets, arrays, etc.

*   **Byte streams**: `InputStream` / `OutputStream` (binary data)
*   **Character streams**: `Reader` / `Writer` (text, Unicode-aware)

**Decorator pattern** is heavily used: you *wrap* to add features (buffering, charset conversion, compression…).

    FileInputStream → InputStreamReader → BufferedReader
       (bytes)            (bytes→chars)     (line reading + buffer)

***

## 3) Predefined Streams

*   `System.in` : `InputStream` (keyboard by default)
*   `System.out`: `PrintStream`  (console)
*   `System.err`: `PrintStream`  (console)

```java
System.out.println("Hello");
System.err.println("Error!");
int b = System.in.read(); // reads a single byte (0–255) or -1 on EOF
```

> ⚠️ `PrintStream.write(int)` writes a **byte** (low 8 bits). It is **not** Unicode-aware.

***

## 4) Byte Streams (Binary I/O)

### 4.1 Core API: `InputStream` / `OutputStream`

**Common methods**

*   `int read()` → returns byte 0–255 or `-1` on EOF
*   `int read(byte[] b, int off, int len)`
*   `void write(int b)`
*   `void write(byte[] b, int off, int len)`
*   `void flush()` (mostly meaningful on buffered/printing streams)
*   `void close()`

**Example: copy bytes**

```java
try (InputStream in = new FileInputStream("in.bin");
     OutputStream out = new FileOutputStream("out.bin")) {
    byte[] buf = new byte[8192];
    int n;
    while ((n = in.read(buf)) != -1) {
        out.write(buf, 0, n);
    }
}
```

### 4.2 Buffered Streams

`BufferedInputStream` / `BufferedOutputStream` improve performance by reducing system calls.

```java
try (InputStream in = new BufferedInputStream(new FileInputStream("in.bin"));
     OutputStream out = new BufferedOutputStream(new FileOutputStream("out.bin"))) {
    in.transferTo(out); // Java 9+: internally loops read/write efficiently
}
```

### 4.3 Byte-Array Streams (in-memory)

```java
byte[] data = "hello".getBytes(StandardCharsets.UTF_8);
try (InputStream in = new ByteArrayInputStream(data)) {
    int b;
    while ((b = in.read()) != -1) { /* ... */ }
}

try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
    bos.write(0x41); // 'A'
    byte[] result = bos.toByteArray();
}
```

### 4.4 Data Streams (primitives in binary)

`DataInputStream` / `DataOutputStream` write/read Java primitives in a machine-independent binary format.

```java
// Write
try (DataOutputStream dos = new DataOutputStream(
         new BufferedOutputStream(new FileOutputStream("data.bin")))) {
    dos.writeInt(42);
    dos.writeDouble(3.14);
    dos.writeUTF("Rugved");
}

// Read (must read in same order)
try (DataInputStream dis = new DataInputStream(
         new BufferedInputStream(new FileInputStream("data.bin")))) {
    int i = dis.readInt();
    double d = dis.readDouble();
    String s = dis.readUTF();
}
```

### 4.5 Object Streams (serialization)

`ObjectOutputStream` / `ObjectInputStream` write/read objects that implement `Serializable`.

```java
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient String password; // not serialized
}

// Write
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.ser"))) {
    oos.writeObject(new Person());
}

// Read
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.ser"))) {
    Person p = (Person) ois.readObject();
}
```

> ⚠️ **Gotcha**: Appending to an existing object stream requires special handling (header). If you simply open `FileOutputStream("people.ser", true)` and create a *new* `ObjectOutputStream`, it writes another stream header → `StreamCorruptedException` on read. Solutions: (1) custom `ObjectOutputStream` that suppresses headers after the first; (2) keep one stream open.

### 4.6 Other useful byte-stream types

*   `SequenceInputStream` (concatenate input streams)
*   `PushbackInputStream` (unread bytes)
*   `GZIPInputStream` / `GZIPOutputStream` (compression)
*   `PipedInputStream` / `PipedOutputStream` (thread-to-thread stream)

***

## 5) Character Streams (Text I/O, Unicode)

### 5.1 Core API: `Reader` / `Writer`

*   `int read()` returns a 16-bit `char` (0–65535) or `-1` on EOF
*   `int read(char[] cbuf, int off, int len)`
*   `void write(int c)` writes a single char (low 16 bits used)
*   `void write(String s)` / `write(char[] …)`
*   `flush()`, `close()`

### 5.2 Adapters: `InputStreamReader` / `OutputStreamWriter`

Convert between **bytes** and **chars** using a **charset**.

```java
// Read bytes from System.in as UTF-8 text
try (BufferedReader br = new BufferedReader(
         new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
    String line = br.readLine();
}

// Write text to bytes encoded in UTF-8
try (Writer w = new OutputStreamWriter(new FileOutputStream("out.txt"), StandardCharsets.UTF_8);
     BufferedWriter bw = new BufferedWriter(w)) {
    bw.write("नमस्ते, Unicode!");
    bw.newLine();
}
```

> 🔎 **Why this matters (your example with 'ᛞ')**  
> `OutputStream`/`PrintStream.write(int)` are **byte**-oriented: only the low 8 bits get written, so `'ᛞ'` (U+16DE) will *not* be emitted correctly. Use a **`Writer`** (character stream) with a proper **charset** to output Unicode reliably.

```java
// Broken for 'ᛞ' – writes a single byte:
System.out.write('ᛞ'); // low 8 bits only → garbage or nothing

// Correct – uses a Writer with UTF-8
try (Writer out = new OutputStreamWriter(System.out, StandardCharsets.UTF_8)) {
    out.write('ᛞ');
    out.flush();
}
```

### 5.3 FileReader / FileWriter

Simplified text readers/writers (use system default charset). Prefer specifying charset explicitly.

```java
// NOT RECOMMENDED for cross-platform encoding correctness:
try (Reader r = new FileReader("test.txt");
     Writer w = new FileWriter("out.txt", /* append */ true)) {
    int ch;
    while ((ch = r.read()) != -1) w.write(ch);
}
```

### 5.4 BufferedReader / BufferedWriter

Adds buffering + line-oriented APIs.

```java
// Read lines
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}

// Write lines
try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
    bw.write("Line 1");
    bw.newLine();       // portable line separator
    bw.write("Line 2");
}
```

### 5.5 PrintWriter (formatted text & no checked IOEs by default)

```java
try (PrintWriter pw = new PrintWriter(
         new OutputStreamWriter(new FileOutputStream("log.txt"), StandardCharsets.UTF_8))) {
    pw.printf("User: %s, Score: %d%n", "Hemant", 95);
    if (pw.checkError()) {
        System.err.println("Printing error!");
    }
}
```

> ⚠️ **Gotcha**: `PrintWriter` swallows `IOException` by default—check `checkError()`.

***

## 6) Try-with-Resources (AutoCloseable)

Any `AutoCloseable` (e.g., streams/readers/writers) can be declared in the `try(...)`. Java closes them in reverse order.

```java
try (BufferedReader br = Files.newBufferedReader(Path.of("in.txt"), StandardCharsets.UTF_8);
     BufferedWriter bw = Files.newBufferedWriter(Path.of("out.txt"), StandardCharsets.UTF_8)) {
    bw.write(br.readLine());
} catch (IOException e) {
    // handle
}
```

**Multiple & multi-catch**

```java
try (InputStream in = new FileInputStream("a.bin");
     OutputStream out = new FileOutputStream("b.bin")) {
    in.transferTo(out);
} catch (FileNotFoundException | SecurityException e) {
    // specific handling
} catch (IOException e) {
    // generic I/O handling
}
```

***

## 7) `File` (Classic File API) — Paths, Portability, & Ops

**Constructors**

```java
File f1 = new File("c:\\Java\\BW\\Sample.txt");        // platform-sensitive path
File f2 = new File("/usr/local/app/config.yml");       // Unix-style
File dir = new File("/data/logs");
File f3 = new File(dir, "app.log");                    // parent + child
File f4 = new File(URI.create("file:///C:/temp/file.txt")); // URI
```

**Portability tips**

*   Use `File.separator` instead of hardcoding `\` or `/`.
*   Better yet: prefer `Path`/`Paths` (see NIO.2 below).

**Common operations**

```java
File f = new File("report.txt");
if (f.exists() && f.isFile()) {
    long size = f.length();
    long last = f.lastModified();
}

File parent = new File("logs");
if (!parent.exists()) parent.mkdirs();

File[] children = parent.listFiles();
File[] onlyTxt = parent.listFiles((dir, name) -> name.endsWith(".txt"));

File src = new File("old.txt");
File dst = new File("new.txt");
boolean renamed = src.renameTo(dst);

f.deleteOnExit();  // delete when JVM exits
```

***

## 8) NIO.2 (`java.nio.file`) — Modern File I/O

Prefer NIO.2 for **portability**, **richer features**, and **stream-friendly** APIs.

### 8.1 `Path` & `Paths`

```java
Path p = Paths.get("logs", "app.log");     // portable join
Path home = Path.of(System.getProperty("user.home"));
Path resolved = home.resolve("documents/report.md");
Path normalized = resolved.normalize();
```

### 8.2 `Files` utility methods

```java
// Read / write entire small text files
List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
byte[] bytes = Files.readAllBytes(Path.of("image.png"));

Files.write(Path.of("out.txt"), List.of("a", "b", "c"), StandardCharsets.UTF_8);
Files.write(Path.of("out.bin"), new byte[]{1,2,3});

// Buffered readers/writers with charset
try (BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8);
     BufferedWriter bw = Files.newBufferedWriter(Path.of("copy.txt"), StandardCharsets.UTF_8)) {
    br.lines().forEach(line -> {
        try { bw.write(line); bw.newLine(); } catch (IOException e) { throw new UncheckedIOException(e); }
    });
}

// Copy, move, delete
Files.copy(Path.of("a.txt"), Path.of("b.txt"), StandardCopyOption.REPLACE_EXISTING);
Files.move(Path.of("b.txt"), Path.of("c.txt"), StandardCopyOption.ATOMIC_MOVE);
Files.deleteIfExists(Path.of("c.txt"));

// Directories
Files.createDirectories(Path.of("data", "logs"));
Path temp = Files.createTempFile("prefix-", ".log");

// Walking file trees
try (Stream<Path> s = Files.walk(Path.of("src"), 3)) {
    s.filter(pth -> Files.isRegularFile(pth) && pth.toString().endsWith(".java"))
     .forEach(System.out::println);
}
```

### 8.3 Attributes & options

```java
BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
FileTime ft = attr.lastModifiedTime();
Files.setLastModifiedTime(p, FileTime.from(Instant.now()));

Set<PosixFilePermission> perms =
    PosixFilePermissions.fromString("rw-r-----");
Files.setPosixFilePermissions(p, perms); // on POSIX systems
```

***

## 9) Channels & Buffers (High-performance I/O)

`FileChannel` + `ByteBuffer` → **faster** bulk I/O, memory-mapping, zero-copy transfers.

```java
try (FileChannel in = FileChannel.open(Path.of("in.bin"), StandardOpenOption.READ);
     FileChannel out = FileChannel.open(Path.of("out.bin"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

    // Zero-copy transfer (kernel-level)
    long bytes = in.transferTo(0, in.size(), out);
}
```

**Memory-mapped file**

```java
try (FileChannel ch = FileChannel.open(Path.of("big.dat"), StandardOpenOption.READ)) {
    MappedByteBuffer map = ch.map(FileChannel.MapMode.READ_ONLY, 0, ch.size());
    while (map.hasRemaining()) {
        byte b = map.get();
    }
}
```

***

## 10) Random Access

`RandomAccessFile` allows reading/writing at arbitrary positions (but it’s not a stream).

```java
try (RandomAccessFile raf = new RandomAccessFile("data.bin", "rw")) {
    raf.seek(100);
    raf.writeInt(12345);
    raf.seek(100);
    int val = raf.readInt(); // 12345
}
```

***

## 11) Console Input (Keyboard)

### 11.1 With `BufferedReader`

```java
try (BufferedReader br = new BufferedReader(
         new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
    System.out.print("Enter name: ");
    String name = br.readLine();
    System.out.println("Hello " + name);
}
```

### 11.2 With `Scanner` (parsing tokens)

```java
try (Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8)) {
    System.out.print("Age? ");
    int age = sc.nextInt();
    sc.nextLine(); // gotcha: consume the leftover newline before nextLine()
    System.out.print("Name? ");
    String name = sc.nextLine();
}
```

***

## 12) Encoding & Charset (Must-know)

Always specify a charset for **text** I/O:

```java
// Read UTF-8 text
try (BufferedReader br = Files.newBufferedReader(Path.of("in.txt"), StandardCharsets.UTF_8)) { ... }

// Write UTF-8 text
try (BufferedWriter bw = Files.newBufferedWriter(Path.of("out.txt"), StandardCharsets.UTF_8)) { ... }
```

*   Do **not** rely on the platform default (varies across machines).
*   For console output of Unicode, wrap `System.out` with a `Writer` using the desired charset (see `'ᛞ'` example earlier).

***

## 13) Common Recipes (Text & Binary)

### 13.1 Copy a text file (charset-aware)

```java
Path src = Path.of("input.txt");
Path dst = Path.of("output.txt");
try (BufferedReader br = Files.newBufferedReader(src, StandardCharsets.UTF_8);
     BufferedWriter bw = Files.newBufferedWriter(dst, StandardCharsets.UTF_8)) {
    br.transferTo(bw); // Java 11+ convenience
}
```

### 13.2 Copy a binary file

```java
Files.copy(Path.of("a.png"), Path.of("b.png"), StandardCopyOption.REPLACE_EXISTING);
```

### 13.3 Read entire small text file as String

```java
String content = Files.readString(Path.of("readme.md"), StandardCharsets.UTF_8);
```

### 13.4 Write lines atomically

```java
Path tmp = Files.createTempFile("notes-", ".txt");
Files.write(tmp, List.of("one", "two", "three"), StandardCharsets.UTF_8);
Files.move(tmp, Path.of("notes.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
```

### 13.5 Count lines in a big file (streaming)

```java
long count;
try (Stream<String> lines = Files.lines(Path.of("big.txt"), StandardCharsets.UTF_8)) {
    count = lines.count();
}
System.out.println(count);
```

### 13.6 Filter filenames by extension

```java
try (Stream<Path> s = Files.list(Path.of("logs"))) {
    s.filter(p -> p.toString().endsWith(".log")).forEach(System.out::println);
}
```

### 13.7 CSV write/read (simple)

```java
// Write
try (BufferedWriter bw = Files.newBufferedWriter(Path.of("data.csv"), StandardCharsets.UTF_8)) {
    bw.write("name,age");
    bw.newLine();
    bw.write("Hemant,28");
    bw.newLine();
}

// Read
try (BufferedReader br = Files.newBufferedReader(Path.of("data.csv"), StandardCharsets.UTF_8)) {
    br.lines().skip(1) // skip header
      .map(line -> line.split(","))
      .forEach(arr -> System.out.println(arr[0] + " -> " + arr[1]));
}
```

***

## 14) Advanced / Less Common Stream Types (Byte & Char)

### 14.1 Pushback (tokenizers / parsers)

```java
try (PushbackReader pr = new PushbackReader(new FileReader("code.txt"), 1)) {
    int c = pr.read();
    if (c == '#') {
        // comment; unread if needed
        pr.unread(c);
    }
}
```

### 14.2 String & CharArray readers/writers

```java
try (Reader r = new StringReader("in-memory text")) {
    int ch;
    while ((ch = r.read()) != -1) { /* ... */ }
}

try (CharArrayWriter cw = new CharArrayWriter()) {
    cw.write("hello");
    char[] data = cw.toCharArray();
}
```

***

## 15) Subtle Behaviors & Interview Gotchas

1.  **Byte vs Character streams**
    *   `InputStream`/`OutputStream` deal in **bytes**. `Reader`/`Writer` deal in **chars** (Unicode).
    *   **Printing Unicode to `OutputStream` directly is wrong** unless you explicitly encode. Use `Writer` with a `Charset`.

2.  **Default charset pitfalls**
    *   `new FileReader(...)`, `new FileWriter(...)` use **platform default** charset → inconsistent behavior across machines. Prefer NIO.2 with explicit `StandardCharsets.UTF_8`.

3.  **`available()` is not the size**
    *   `InputStream.available()` is *not* guaranteed to return the total bytes left; it returns an *estimate* of bytes that can be read **without blocking**. Do not use it to size buffers or for EOF logic.

4.  **`PrintWriter` swallows IOExceptions**
    *   Use `checkError()` or wrap the stream in your own try/catch.

5.  **`flush()` vs `close()`**
    *   `close()` implies `flush()`. But call `flush()` explicitly when streaming to long-lived targets (e.g., network sockets) and you want to push the data before closing.

6.  **Buffering**
    *   Wrapping with `Buffered*` classes can dramatically improve performance for small reads/writes.

7.  **Mixing `Scanner` with `Reader`**
    *   Watch out for token vs line boundaries: `nextInt()` leaves the newline. Call `nextLine()` after numeric reads to consume the rest of the line.

8.  **`RandomAccessFile` is not a stream**
    *   Cannot wrap with `BufferedInputStream`. If you need buffering, manage your own or use `FileChannel`.

9.  **Object stream headers**
    *   Appending objects to existing `.ser` files requires suppressing extra headers or maintaining a single stream instance. Otherwise, you’ll hit `StreamCorruptedException`.

10. **`mark()`/`reset()` support**
    *   Not all streams support marking. Check `markSupported()` before using.

11. **Closing order (nested resources)**
    *   Try-with-resources closes **in reverse order**. This usually “just works” with wrappers.

12. **Huge file read**
    *   Avoid `Files.readAllBytes()`/`readString()` for very large files → memory pressure. Use streaming with buffers.

13. **Permissions & cross-platform paths**
    *   On Windows you cannot set POSIX permissions. Prefer using `Path`/`Files` and feature-check where needed.

14. **`File.renameTo` unreliability**
    *   May fail across volumes. Prefer `Files.move` with options.

15. **`System.out` is a `PrintStream`**
    *   `println` uses platform default encoding → console may not display some Unicode correctly unless the console and JVM encoding agree. For full control, wrap `System.out` with `OutputStreamWriter` + charset.

***

## 16) A Few “All-in-One” Examples

### 16.1 Console-to-file (UTF‑8, buffered, safe)

```java
Path out = Path.of("notes.txt");
try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
     BufferedWriter bw = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

    System.out.println("Type lines, enter empty line to finish:");
    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
        bw.write(line);
        bw.newLine();
    }
}
```

### 16.2 File copy with size reporting and timing (binary)

```java
Path src = Path.of("large.iso");
Path dst = Path.of("large-copy.iso");
long t0 = System.nanoTime();
Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
long t1 = System.nanoTime();
System.out.printf("Copied %,d bytes in %.2f s%n", Files.size(dst), (t1 - t0) / 1e9);
```

### 16.3 Channel-based zero-copy copy

```java
try (FileChannel in = FileChannel.open(Path.of("vid.mp4"), StandardOpenOption.READ);
     FileChannel out = FileChannel.open(Path.of("vid-copy.mp4"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
    long size = in.size();
    long pos = 0;
    while (pos < size) {
        pos += in.transferTo(pos, size - pos, out);
    }
}
```

***

## 17) Summary Cheat Codes

*   **Binary?** `InputStream`/`OutputStream` (+ `Buffered*`)
*   **Text?** `Reader`/`Writer` (+ `Buffered*`) with **explicit charset**
*   **Primitives?** `DataInput/OutputStream`
*   **Objects?** `ObjectInput/OutputStream` (mind headers)
*   **Paths?** Prefer `Path`/`Files` over `File`
*   **Performance?** Buffering; channels; `transferTo/From`; memory-mapped
*   **Resource safety?** `try-with-resources` everywhere

***

## 18) Quick Encoding Demo (Your Unicode Case)

```java
// Byte stream (WRONG for Unicode chars beyond 0xFF)
OutputStream os = System.out;
os.write('ᛞ'); // writes only low 8 bits → wrong glyph or nothing

// Character stream (RIGHT)
try (Writer writer = new OutputStreamWriter(System.out, StandardCharsets.UTF_8)) {
    writer.write('ᛞ'); // proper UTF-8 encoding to console
    writer.flush();
}
