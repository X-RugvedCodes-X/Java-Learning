package com.rugved.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    // ^ Method Reference Means Using Method Without Invoking and in place of Lambda Expressions.
    List<String> students = Arrays.asList("Rugved", "Biswas", "Surya", "Sahani");

    // * forEach Method lies in the Iterable<T> interface, and Takes a Consumer
    // default void forEach(Consumer<? super T> action) {
    //   Objects.requireNonNull(action);
    //   for (T t : this) {
    //     action.accept(t);
    //   }
    // }
    // students.forEach(student -> System.out.println(student));
    // * Lambda Expression Can be Replaced with Method Reference
    students.forEach(System.out::println);    // * Prints All the Students

    // ^ Constructor Reference
    List<String> names = Arrays.asList("IPhone", "Samsung", "RedMi", "Nokia");
    // * .stream is used to convert any collection to stream
    // List<MobilePhone> mobilePhones = names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
    // * Better way to write Above Line
    List<MobilePhone> mobilePhones = names.stream().map(MobilePhone::new).collect(Collectors.toList());
    mobilePhones.forEach(System.out::println);
  }
};