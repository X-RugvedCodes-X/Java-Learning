package com.rugved.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, linkedlist");

    // * Java has Doubly Linked List, Elements are not stored in contagious location
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(5);
    linkedList.add(4);
    System.out.println(linkedList.get(2));    // * TC = O(n)
    // * More Methods are:- .add(Object). get(index), addLast(index), addFirst(index), getLast(), getFirst() (No Arguments for getFirst and getLast, getFirst() has O(1) T.C.) 

    // ^ Remove Methods:- remove(Object), remove(index), remove(), removeFirst(), removeLast(), removeFirstOccurrence(Object), removeLastOccurrence(Object), removeAll(Collection<?> c), removeIf(Predicate<? super>) (removeIf in Java 8)
    linkedList.removeIf(x -> x % 2 == 0);
    System.out.println(linkedList);   // * [1, 3, 5]

    LinkedList<String> animals = new LinkedList<>(Arrays.asList("Lion", "Elephant", "Tiger", "Giraffe", "Cheetah", "Dog"));
    LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Lion", "Cheetah", "Dog"));
    animals.removeAll(animalsToRemove);
    System.out.println(animals);    // * [Elephant, Tiger, Giraffe]
    // * removeAll method is also there in ArrayList
 
    // ^ LinkedList is a very Powerful class it can also behave like ArrayList, Stack or even Queue
    // ^ It is more Efficient for Insertion and Deletion Operation as compared to ArrayList
    // ^ For Fast Accessing and Reading Use HashTable APIs

    LinkedList<Integer> numbers = new LinkedList<>(List.of(1, 2, 3, 4, 5));
    LinkedList<Integer> numbersToRemove = new LinkedList<>(List.of( 2, 4, 5));
    numbers.removeAll(numbersToRemove);
    System.out.println(numbers);    // * [1, 3]
    
  }
}