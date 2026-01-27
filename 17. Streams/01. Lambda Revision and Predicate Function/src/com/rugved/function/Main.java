package com.rugved.function;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    // * Function is a Functional Interface which has one method named apply it takes input as any type and returns the appropriate corresponding type
    // * It Looks like this:
    // public interface Function<T, R> {
    //   R apply(T t);
    // }
    // Function<Integer, Integer> doubleIt = x -> x * 2; 
    // int doubleNumber = doubleIt.apply(Integer.valueOf(10));
    // System.out.println(doubleNumber);    // * 20

    // Function<Integer, Integer> doubleIt = x -> x * 2; 
    // Function<Integer, Integer> tripleIt = x -> x * 3; 
    // int doubleAndTripleTheNumber = doubleIt.andThen(tripleIt).apply(Integer.valueOf(10));
    // * .compose just executes tripleIt first and then doubleIt 
    // int doubleAndTripleTheNumberUsingCompose = doubleIt.compose(tripleIt).apply(Integer.valueOf(10));
    // System.out.println(doubleAndTripleTheNumber);               // * 60
    // System.out.println(doubleAndTripleTheNumberUsingCompose);   // * 60

    // * Function Interface has one static Method named identity. It looks like this:
    // static <T> Function<T, T> identity() {
    //     return t -> t;
    // }
    // * Returns the Same output as input we give (Usage will be introduced in Streams)

    // Function<Integer, Integer> identity = Function.identity();
    // Integer result = identity.apply(Integer.valueOf(5));
    // System.out.println(result);       // * 5

    // ^ Consumer : It consumes the given Value and Doesnot return anything
    // * Structure :
    // public interface Consumer<T> {
    //   void accept(T t);

    //   default Consumer<T> andThen(Consumer<? super T> after) {
    //     Objects.requireNonNull(after);
    //     return (T t) -> { accept(t); after.accept(t); };
    //   }
    // }

    // Consumer<Integer> print = x -> System.out.println(x);
    // print.accept(Integer.valueOf(5));     // * 5
    
    // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    // Consumer<List<Integer>> printList = x -> {
    //   for (Integer integer : list) {
    //     System.out.print(integer + " ");
    //   }
    // };
    // printList.accept(list);   // * 1 2 3 4 5
    // System.out.println();

    // ^ Supplier : Doesnot Consume Anything but returns a value, It has Just one Method in it.
    // public interface Supplier<T> {
    //   T get();
    // }

    // Supplier<String> giveHelloWorld = () -> "hello, world !";
    // System.out.println(giveHelloWorld.get());   // * hello, world !

    // * BiPredicate
    // BiPredicate<Integer, Integer> isSumEven = (var x, var y) -> (x + y) % 2 == 0;
    // System.out.println(isSumEven.test(Integer.valueOf(2), Integer.valueOf(7)));     // ! false

    // * BiConsumer
    // BiConsumer<Integer, String> biConsumer = (x, y) -> {
    //   System.out.println(x);
    //   System.out.println(y);
    // };
    // biConsumer.accept(Integer.valueOf(4), "Rugved");

    // * BiFunction - First Two Types are Params and Third is Return Type Generic
    // BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
    // int lengthOfTwoStrings = biFunction.apply("a", "se");
    // System.out.println(lengthOfTwoStrings);     // * 3

    // * Better Way to Write : Function<Integer, Integer> doubleIt = x -> x * 2;
    // public interface UnaryOperator<T> extends Function<T, T> {
    //   static <T> UnaryOperator<T> identity() {
    //     return t -> t;
    //   }
    // }
    // UnaryOperator<Integer> unaryOperator = x -> x * 2;
    // Integer result = unaryOperator.apply(Integer.valueOf(4));
    // System.out.println(result);   // * 8

    // * Similary We Have BinaryOperator
    // BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
    // Integer result = binaryOperator.apply(Integer.valueOf(4), Integer.valueOf(5));
    // System.out.println(result);   // * 9

    
  }
}
