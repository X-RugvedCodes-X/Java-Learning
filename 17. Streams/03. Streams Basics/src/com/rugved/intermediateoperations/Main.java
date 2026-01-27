package com.rugved.intermediateoperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    // ^ Intermediate Operations
    // * Intermediate operations transform a stream into another stream
    // * They are lazy, meaning they don't execute until a terminal operation is invoked which is their prime Advantage

    // ^ 1. filter
    // List<String> list = Arrays.asList("Akshit", "Ankita", "Khushi", "Ram", "Omkar", "Aniket", "John");
    // * No Filtering Done At this point, Filtering only will be done when we use any Terminal Operation like .forEach() or .collect(), etc
    // Stream<String> filteredStream = list.stream().filter(student -> student.toLowerCase().startsWith("a"));   
    // * Now Filtering is done
    // long namesStartingWithA = list.stream().filter(student -> student.toLowerCase().startsWith("a")).count();   
    // System.out.println(namesStartingWithA);     // * 3

    // ^ 2. map
    // List<String> list = Arrays.asList("Akshit", "Ankita", "Khushi", "Ram", "Omkar", "Aniket", "John");
    // Stream<String> stringStream = list.stream().map(String::toUpperCase);   // * Method Reference

    // ^ 3. sorted
    // List<String> list = Arrays.asList("Akshit", "Ankita", "Khushi", "Ram", "Omkar", "Aniket", "John");
    // Stream<String> sortedStream = list.stream().sorted();
    // Stream<String> sortedStreamWithCustomComparator = list.stream().sorted((a, b) -> a.length() - b.length());

    // ^ 4. distinct
    // List<String> list = Arrays.asList("Akshit", "Ankita", "Khushi", "Ram", "Omkar", "Aniket", "John", "Akshit");
    // System.out.println(list.stream().filter(name -> name.toLowerCase().startsWith("a")).count());                   // * 4
    // System.out.println(list.stream().filter(name -> name.toLowerCase().startsWith("a")).distinct().count());        // * 3

    // ^ 5. skip - Skips first specified entities
    // List<Integer> skipList = Stream.iterate(Integer.valueOf(1), x -> x + 1).skip(10).limit(20).collect(Collectors.toList());
    // System.out.println(skipList); // * [11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]

    // ^ 6. peek - a consumer which performs an action on each element as it is consumed.
    // * Yes we know forEach does the same but forEach is a terminal Operation na, 
    // * though to execute peek we have to use one terminal operation atleast as it is intermediate operation and we know that intermediate operation evalualate lazily
    // Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

    // ^ 7. flatMap
    // * Handle streams of collections, lists, or arrays where each element is itself a collection Flatten nested structures (e.g., lists within lists) 
    // * So that they can be processed as a single sequence of elements Transform and flatten elements at the same time.
    List<List<String>> listOfFruitList = Arrays.asList(
      Arrays.asList("Apple", "Banana", "Orange"),
      Arrays.asList("Mango", "Pineapple", "Papaya"),
      Arrays.asList("Grapes", "Strawberry", "Blueberry"),
      Arrays.asList("Watermelon", "Kiwi"),
      Arrays.asList("Peach", "Plum", "Cherry")
    );
    // System.out.println(listOfFruitList.stream().flatMap(singleFruitList -> singleFruitList.stream()).map(String::toUpperCase).toList());
    // * [APPLE, BANANA, ORANGE, MANGO, PINEAPPLE, PAPAYA, GRAPES, STRAWBERRY, BLUEBERRY, WATERMELON, KIWI, PEACH, PLUM, CHERRY]

    List<String> sentences = Arrays.asList(
      "Hello World",
      "Java Streams are Useful",
      "FlatMap is Powerful"
    );
    // sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).forEach(System.out::println);
    // List<String> word = sentences.stream()
    //                              .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
    //                              .map(String::toUpperCase)
    //                              .toList();
    // System.out.println(word);   // * [HELLO, WORLD, JAVA, STREAMS, ARE, USEFUL, FLATMAP, IS, POWERFUL]
    


  }
}
