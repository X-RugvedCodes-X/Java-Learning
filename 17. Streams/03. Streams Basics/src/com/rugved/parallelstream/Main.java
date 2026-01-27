package com.rugved.parallelstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    // * A type of stream that enables parallel processing of elements Allowing multiple threads to process parts of the stream simultaneously 
    // * This can significantly improve performance for large data sets workload is distributed across multiple threads

    // long startTime = System.currentTimeMillis();
    // List<Integer> list = Stream.iterate(1, x -> x + 1).limit(5000).toList();
    // List<Long> factorialList = list.stream().map(x -> factorial(x)).toList();
    // List<Long> factorialList = list.stream().map(Main::factorial).toList();
    // long endTime = System.currentTimeMillis();
    // System.out.println(endTime - startTime + " ms");  // * 32ms, 43ms

    // * On Using Parallel Stream
    // long startTime = System.currentTimeMillis();
    // List<Integer> list = Stream.iterate(1, x -> x + 1).limit(5000).toList();
    // List<Long> factorialList = list.parallelStream().map(Main::factorial).toList();
    // long endTime = System.currentTimeMillis();
    // System.out.println(endTime - startTime + " ms");  // * 18ms, 17ms, 19ms

    // * Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent 
    // * They may add overhead for simple tasks or small datasets


    // * Q. Calculate Cumulative Sum, [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15]
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    // int currentSum = 0;
    // numbers.parallelStream().map(num -> { 
    //   int finalSum = currentSum + num;
    //   currentSum = finalSum;
    //   return finalSum;
    // }).toList();
    // ! The Above Approach gives error, as variables in Lambdas must be Effectively Final

    // * We use AtomicInteger to achieve Thread-Safety
    // AtomicInteger currentSum = new AtomicInteger(0);
    // List<Integer> cumulativeList = numbers.parallelStream().map(num -> currentSum.addAndGet(num)).toList();
    // List<Integer> cumulativeList = numbers.parallelStream().map(currentSum::addAndGet).toList(); // * But this does in very unordered manner
    // List<Integer> cumulativeList = numbers.parallelStream().map(currentSum::addAndGet).sequential().toList();
    // System.out.println(cumulativeList);   // * [1, 3, 6, 10, 15]

    // * toArray - Terminal Operation
    Object[] array = Stream.of(1, 2 ,3).toArray();
    
    // * min/max
    // System.out.println("max: " + Stream.of(45, -9, 222).max(Comparator.naturalOrder()).get());
    // System.out.println("min: " + Stream.of(45, -9, 222).min(Comparator.naturalOrder()).get());
    // System.out.println("max: " + Stream.of(45, -9, 222).max((a, b) -> b - a).get());    // * Custom Ordering - Gives Min. instead

  }

  private static long factorial(int n) {
    if(n < 0)
      throw new IllegalArgumentException("n must be non negative");
    if(n <= 1)
      return 1;
    else
      return n * factorial(n - 1);
  }
}
