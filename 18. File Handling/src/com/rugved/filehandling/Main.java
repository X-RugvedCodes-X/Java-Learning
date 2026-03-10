package com.rugved.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    // String str = "helloworld, hello world";
    // Map<Character, Integer> characterFrequencyCount = new HashMap<>();
    // for(char ch : str.toCharArray()) {      
    //   characterFrequencyCount.put(ch, characterFrequencyCount.getOrDefault(ch, 0) + 1);
    // }
    // System.out.println(characterFrequencyCount);

    // * Basic Example of Reading From a Input Stream -> Taking Data in Byte Stream and putting out in Character Stream
    // System.out.println("Enter Something: ");
    // try (InputStreamReader in = new InputStreamReader(System.in)) {
    //   int inputData;
    //   while((inputData = in.read()) != -1) {  // * -1 means EOL check
    //     System.out.println((char) inputData);
    //   }
      // in.close();  // * No Need to Write Close as we use try with resources
    //   System.out.println();
    // } catch (IOException e) {
    //   System.out.println(e.getMessage());
    // }

    // * FileReader -> Reading from a File and writing to console
    // try (FileReader fileReader = new FileReader("src/com/rugved/filehandling/sample.txt")) {
    //   int fileData;
    //   while((fileData = fileReader.read()) != -1) {
    //     System.out.print((char) fileData);
    //   }
    //   System.out.println();
    // } catch (Exception e) {
    //   System.out.println(e.getMessage());
    // }

    // * FileReader -> Reading from a File and writing to another file
    // long start = System.nanoTime();
    // try (FileReader fileReader = new FileReader("src/com/rugved/filehandling/sample.txt");
    //      FileWriter fileWriter = new FileWriter("src/com/rugved/filehandling/output.txt")) {
    //   int fileData;
    //   while((fileData = fileReader.read()) != -1) {
    //    // System.out.print((char) fileData);
    //     fileWriter.append((char) fileData);
    //   }
    //   System.out.println();
    // } catch (Exception e) {
    //   System.out.println(e.getMessage());
    // }
    // long end = System.nanoTime();
    // System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

    // * Optimized File Reading in Java -> Instead of reading every character, this reads line-to-line
    // * Uses CharSequence, Buffering (Can even be acheieved by StringBuilder or StringBuffer), Less Sys Calls, Faster IO
    // long start = System.nanoTime();
    // try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/rugved/filehandling/input.txt"));
    //      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/rugved/filehandling/output.txt", true))) {
    //   String line; 
    //   while ((line = bufferedReader.readLine()) != null) {
    //     bufferedWriter.append(line);
    //     // bufferedWriter.append("\n");
    //     bufferedWriter.newLine(); // * Internally calls System.lineSeperator() -> So even compatible with Unicode
    //     // System.out.println(line); // * Console output is slow that's why dont include it in performance bench-marking
    //   }
    //   bufferedWriter.flush();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
    
    // * Only File Writing to console takes extra 51 - 6 = 45ms, Otherwise its just 6-7 ms for reading the file
    // try (Stream<String> lines = Files.lines(Path.of("src/com/rugved/filehandling/output.txt"))) {
    //   StringBuilder batch = new StringBuilder();
    //   lines.forEach(line -> batch.append(line).append(System.lineSeparator()));
    //   System.out.print(batch);
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
    // long end = System.nanoTime();
    // System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

    // * But for Reading Huge Files, Use NIO ie. new IO in Java, more optimzied as: 
    // * BufferedReader Still does: User Space → Kernel Space → Disk, So flow is Disk → Kernel → JVM → Your Program which is Double Copy
    // * But NIO uses OS-level Zero Copy, Uses OS Page Cache
    // * BufferedReader reads into: Heap Memory
    // * MappedByteBuffer reads into: Direct Memory

    // * BufferedReader is suitable for moderately large files, but for extremely large files in the order of gigabytes or terabytes, Java NIO's FileChannel with memory-mapped buffers like MappedByteBuffer is more efficient because it avoids multiple memory copies between kernel and user space and leverages OS-level zero-copy mechanisms for faster file access.


    // * Using StringBuilder and StringBuffer (In Multithreaded Environments to ensure synchronous behaviour and thread safety)
    // long start = System.nanoTime();
    // try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/rugved/filehandling/input.txt"));
    //      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/rugved/filehandling/output.txt"))) {
    //   StringBuilder fileData = new StringBuilder(); 
    //   String line;
    //   while ((line = bufferedReader.readLine()) != null) {
    //     fileData.append(line).append(System.lineSeparator());
    //   }
    //   bufferedWriter.append(fileData);
    //   bufferedWriter.flush();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }

    // long end = System.nanoTime();
    // System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

    creatingAndDeletingNewFile();

  }

  private static void creatingAndDeletingNewFile() {
    try {
      File file = new File("random.txt");
      if (file.createNewFile()) {
        System.out.println("File Created Successfully !");
        System.out.println(file.getAbsolutePath());
      };
      if (file.delete()) {
        System.out.println("File " + file.getName() + " Deleted Successfully !");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
};