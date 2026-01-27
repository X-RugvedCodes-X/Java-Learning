package com.rugved.terminaloperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(20);

    // ^ 1. collect
    // List<Integer> streamList = stream.collect(Collectors.toList());
    // * In Newer Java Versions, We Can even Write it as
    // List<Integer> streamList = stream.toList();
    // System.out.println(streamList);

    // ^ 2. forEach
    // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
    // list.stream().forEach(System.out::println);
    
    // ^ 3. reduce
    // * Optional means either value will be there or not
    // Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
    // * Better Way to Write This, As sum is a static method in Integer Class
    // Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);
    // System.out.println(optionalInteger.get());    // * 21

    // * Now Below All are ShortCircuit Operation which means after any first match they don't check for any
    // ^ 4. anyMatch, allMatch, noneMatch
    // * returns boolean result for whatever condition we specify in the predicate
    // boolean b1 = list.stream().anyMatch(x -> x % 2 == 0);
    // System.out.println(b1);     // * true
    // boolean b2 = list.stream().allMatch(x -> x > 0);   // * When All elements satisfy for given Predicate Condition
    // System.out.println(b2);     // * true
    // boolean b3 = list.stream().noneMatch(x -> x < 0);
    // System.out.println(b3);     // * true

    // ^ 5. findfirst, findany
    // System.out.println(list.stream().findFirst().get());  // * an Optional describing the first element of this stream, or an empty Optional if the stream is empty
    // System.out.println(list.stream().findAny().get());

    // * Q. Get Names from the List who have Length greater than 3
    // List<String> names = Arrays.asList("Anna", "Bob", "Babdya", "Bandya", "Charlie", "Dada", "David");
    // System.out.println(names.stream().filter(name -> name.length() > 3).count());   // * 6
    // System.out.println(names.stream().filter(name -> name.length() > 3).collect(Collectors.toList()));   
    // * [Anna, Babdya, Bandya, Charlie, Dada, David] - Printed By above statement

    // * Q. Squaring and Sorting Numbers
    // List<Integer> numbers = Arrays.asList(-7, 14, -23, 58, -104, 207, 9, -86, 312, -45);
    // System.out.println(numbers.stream().map(number -> number * number).sorted().toList());
    // * [49, 81, 196, 529, 2025, 3364, 7396, 10816, 42849, 97344] - Printed By above statement

    // * Q. Summing Values
    // List<Integer> numbers = Arrays.asList(-7, 14, -23, 58, -104, 207, 9, -86, 312, -45);
    // System.out.println(numbers.stream().reduce((x, y) -> x + y));         // * Optional[335]
    // System.out.println(numbers.stream().reduce(Integer::sum).get());      // * 335
    
    // * Q. Counting Occurence of Character
    // String str = "hello, world ! I am A Boy";
    // IntStream intStream = str.chars();
    // intStream.forEach(System.out::println);   // * Prints ASCII values
    // System.out.println(str.chars().filter(ch -> ch == 'l').count());    // * 3

    // ^ Stateful and Stateless Operation
    // * Stateful operation means an operation which has knowledge or state of its whole stream (or all elements), eg. sorted, distinct etc
    // * Stateless operation means which don't bother having knowledge of whole conatiner or any of the elements, quietly focusing on thier present, eg. count, map, etc

    // * All Intermediate Operations are Lazy Evaluated Which means they don't evaluate unless and untill we don't execute any terminal operation
    // List<String> names = Arrays.asList("Anna", "Bob", "Babdya", "Bandya", "Charlie", "Dada", "David");
    // Stream<String> nameStream = names.stream().filter(name -> {
    //   System.out.println(name);
    //   return name.length() > 3;
    // });
    // System.out.println("Before Terminal Operation");

    // List<String> result = nameStream.toList();
    // System.out.println("After Terminal Operation");
    // System.out.println(result);
    // * The Output is Below, We can Decipher that Intermediate Operations are Evaluated in a lazy Manner
    /*
    * Before Terminal Operation
    * Anna
    * Bob
    * Babdya
    * Bandya
    * Charlie
    * Dada
    * David
    * After Terminal Operation
    * [Anna, Babdya, Bandya, Charlie, Dada, David]
    */
  }
}
