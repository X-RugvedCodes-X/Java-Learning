package com.rugved.lambdarevision;

import java.util.function.Predicate;

@SuppressWarnings("unused")
public class Main {
  public static void main(String[] args) {
    IMathOperation addOperation = (var a, var b) -> a + b ;
    IMathOperation subOperation = (var a, var b) -> a - b ;

    int addResult = addOperation.operate(1, 2);
    int subResult = subOperation.operate(1, 2);
    // System.out.println(addResult + "\n" + subResult);

    // * Predicate is a Functional Interface (Boolean Valued Function), It has one method called test which takes any type and returns a boolean value
    // Predicate<Integer> isEven = x -> x % 2 == 0;
    // boolean answer = isEven.test(6);
    // System.out.println(answer ? "Yes, Even" : "No, Not Even");

    // Predicate<String> isWordStartingWithA = x -> x.startsWith("A");
    // System.out.println(isWordStartingWithA.test("Assam") ? "Yes, Starts With A" : "No, Does Not Start With A");

    Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("a");
    Predicate<String> isWordEndingWithA = x -> x.toLowerCase().endsWith("a");
    Predicate<String> startingAndEndingWithA = isWordEndingWithA.and(isWordEndingWithA);    // * Combining Predicates
    System.out.println(startingAndEndingWithA.test("Aniket"));    // ! false
    System.out.println(startingAndEndingWithA.test("Ankita"));    // * true
    
  }
};