package com.rugved.hugefilereading;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


// import sun.misc.Unsafe;
// import java.lang.reflect.Field;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;

@SuppressWarnings({"unused", "preview"})
public class Main {

  public static void main(String[] args) {
    final Path path = Path.of("src/com/rugved/filehandling/1000mb.txt");
    
    // * Warming up JIT before time checks
    for(int i = 0; i < 5; ++i) {
      // fileRead(path);
      try {
      modernFileRead(path);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println("====================Actual Starts Now====================");
    long start = System.nanoTime();
    // fileRead(path);

    // * MemorySegment provides safer deterministic lifecycle management for memory‑mapped files but may introduce performance overhead compared to MappedByteBuffer due to bounds and scope checks on each memory access.
    try {
      modernFileRead(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
    //   long fileSize = fileChannel.size();
    //   final long CHUNK_SIZE = 1024 * 1024 * 100; // * 100 MB
    //   long position = 0;

    //   while (position < fileSize) {
    //     long remaining = Math.min(CHUNK_SIZE, fileSize - position);
    //     // MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, remaining);
    //     MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);    // * For Small file

    //     // processChunk(buffer);  // ! As Console Output is slow
    //     position += remaining;
    //   }
    // } catch (Exception e) {
    //   e.printStackTrace();
    // }

    long end = System.nanoTime();
    System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
  }

  
  private static void fileRead(Path path) {
    try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
      long fileSize = fileChannel.size();
      final long CHUNK_SIZE = 1024 * 1024 * 100; // * 100 MB
      long position = 0;

      // MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);    // * For Small File
      // processChunk(buffer);
      while (position < fileSize) {
        long remaining = Math.min(CHUNK_SIZE, fileSize - position);  // * For Large files, Use this loop
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, remaining);
        // processChunk(buffer);

        // unmap(buffer);
        position += remaining;
        System.out.println("Processed: " + (position / (1024 * 1024)) + " MB");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // * Correct way to read from MappedBytebuffer
  private static void processChunk(MappedByteBuffer buffer) {
    StringBuilder batch = new StringBuilder();
    int batchSize = 10_000;

    while(buffer.hasRemaining()) {
      char c = (char) buffer.get();
      batch.append(c);

      if (batch.length() >= batchSize) {
        System.out.print(batch);
        batch.setLength(0);
      }
      buffer.get();
    }
    System.out.println(batch);
  }

  
  // private static void unmap(MappedByteBuffer buffer) {
  //   try {
  //     Unsafe unsafe = getUnsafe();
  //     unsafe.invokeCleaner(buffer);
  //   } catch (Exception e) {
  //     throw new RuntimeException(e);
  //   }
  // }

  // private static Unsafe getUnsafe() {
  //   try {
  //     Field field = Unsafe.class.getDeclaredField("theUnsafe");
  //     field.setAccessible(true);
  //     return (Unsafe) field.get(null);
  //   } catch (Exception e) {
  //     throw new RuntimeException(e);
  //   }
  // }

  private static void modernFileRead(Path path) throws Exception {

    try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
         Arena arena = Arena.ofConfined()) {
      MemorySegment segment = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size(), arena);
      process(segment);
    } 
  }

  private static void process(MemorySegment segment) {
    for (long i = 0; i < segment.byteSize(); i++) {
      byte b = segment.getAtIndex(java.lang.foreign.ValueLayout.JAVA_BYTE, i);
    }
  }
}