package com.rugved.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // ^ Streams :
    // * feature introduced in Java 8
    // * process collections of data in a functional and declarative manner
    // * Simplify Data Processing
    // * Embrace Functional Programming
    // * Improve Readability and Maintainability
    // * Enable Easy Parallelism

    // * First we Have a Source then we Perform Intermediate Operation and then Terminal Operation on it
    // * A Stream is a sequence of Element supporting functional and declarative programming
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    // Stream<Integer> stream = numbers.stream();
    long evenNumbers = numbers.stream().filter(x -> x % 2 == 0).count();    // * count returns a long
    // System.out.println(evenNumbers);    // * 2

    // * Converting Arrays To Streams
    String[] arrays = {"str1", "str2", "str3"};
    Stream<String> stream1 = Arrays.stream(arrays);
    // * Another Method
    Stream<String> stream2 = Stream.of("str1", "str2", "str3");
    // * Infinite Stream - .generate() takes a Supplier generating an infinite stream of specified number
    // Stream<Integer> stream3 = Stream.generate(() -> Integer.valueOf(1));
    // * We can Even Limit the Above one
    // Stream<Integer> stream3 = Stream.generate(() -> Integer.valueOf(1)).limit(100);
    // List<Integer> listWithAll1s = stream3.collect(Collectors.toList());
    // System.out.println(listWithAll1s);
    // * Now Using iterate() - to create Infinite Stream
    // * iterate(Integer seed, UnaryOperator<Integer> f)
    // * Type Parameters:
    // * <T> the type of stream elements
    // * Parameters:
    // * seed : the initial element
    // * f : a function to be applied to the previous element to produce a new element
    // * Returns:
    // * a new sequential Stream
    // Stream<Integer> stream4 = Stream.iterate(Integer.valueOf(1), x -> x + 1).limit(20);
    // List<Integer> stream4sList = stream4.collect(Collectors.toList());
    // System.out.println(stream4sList); // * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]


  }
};