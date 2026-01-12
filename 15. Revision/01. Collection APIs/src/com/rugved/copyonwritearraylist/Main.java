package com.rugved.copyonwritearraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

  public static void main(String[] args) {
    System.out.println("hello, copyonwritearraylist");
    // * ArrayList and LinkedList Classes were not thread-safe though vector and stack are synchronized but locks and overhead are introduced that's why performance is the issue 
    // * For this CopyOnWriteArrayList was introduced

    // * Copy On Write means whenever a write operation like adding or removing an element is performed, instead of direclty modifying the current list 
    // * a new copy of that list is created under the hood, and this newly made copy is modified, This ensures that other threads reading the list while it's modified be unaffected

    // * Read and Lookup operations are fast and direct as they happen on stable list without interfernece from modification
    // * In doing write operation a new copy of list is created for every modification, The reference to the list is then updated so that subsequent reads use this new list
    // * So mind you copy is created only when write operation is done
    // * Hence this is best for Reading and Accessing
    // CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    // * When ArrayList is used 
    // List<String> shoppingList = new ArrayList<>();
    // shoppingList.add("Milk"); 
    // shoppingList.add("Eggs"); 
    // shoppingList.add("Bread"); 
    // System.out.println("Initial Shopping List: " + shoppingList);
    // for(String item : shoppingList) {
    //   System.out.println(item);
    //   if(item.equals("Eggs")) {   // ! java.util.ConcurrentModificationException
    //     shoppingList.add("Butter");      // ^ We are Modigying while Reading which is not good as ArrayList is not thread-safe  
    //     System.out.println("Added Butter While Reading.");
    //   }
    // }

    // * When CopyOnWriteArrayList is used
    // * This works because for modifying the list a new copy of it is created and modification is done on new copy
    // * Now after the modification (when new copy is made), all the threads now point to this new copy for all operations
    // List<String> shoppingList = new CopyOnWriteArrayList<>();
    // shoppingList.add("Milk"); 
    // shoppingList.add("Eggs"); 
    // shoppingList.add("Bread"); 
    // System.out.println("Initial Shopping List: " + shoppingList);
    // for(String item : shoppingList) {   // * Loop runs on the original one only
    //   System.out.println(item);
    //   if(item.equals("Eggs")) {   // * No Exception
    //     shoppingList.add("Butter");      // ^ We are Modigying while Reading which is not good as ArrayList is not thread-safe  
    //     System.out.println("Added Butter While Reading.");  
    //   }
    // }
    // * after ending of loop only the shopping list (original one) will be made equal to the newly made list
    // * old = new and new is destroyed or collected by GC
    // * This is single thread only
    // System.out.println("Updated Shopping List: " + shoppingList);   // * [Milk, Eggs, Bread, Butter]

    // * Simulation of Thread-safety while comparing ArrayList() and CopyOnWriteArrayList()

    // ! While using ArrayList()
    // List<String> sharedList = new ArrayList<>();
    // sharedList.add("item1");
    // sharedList.add("item2");
    // sharedList.add("item3");
    // Thread readerThread = new Thread(() -> {
    //   try {
    //     while(true) {
    //       for (String item : sharedList) {
    //         System.out.println("Reading item: " + item);
    //         Thread.sleep(1000);
    //       }
    //     }
    //   } catch(InterruptedException e) {
    //     e.printStackTrace();
    //   }
    // });
    // Thread writerThread = new Thread(() -> {
    //   try {
    //     Thread.sleep(1000);
    //     sharedList.add("item4");
    //     System.out.println("added item4 to the list.");

    //     Thread.sleep(1000);
    //     sharedList.remove("item1");
    //     System.out.println("Removed item1 to the list.");
    //   } catch(InterruptedException e) {
    //     e.printStackTrace();
    //   }
    // });
    // readerThread.start();
    // writerThread.start();
    // * Output: Exception in thread "Thread-0" java.util.ConcurrentModificationException

    // * On Using CopyOnWriteArrayList()
    List<String> sharedList = new CopyOnWriteArrayList<>();
    sharedList.add("item1");
    sharedList.add("item2");
    sharedList.add("item3");
    Thread readerThread = new Thread(() -> {
      try {
        while(true) {
          for (String item : sharedList) {
            System.out.println("Reading item: " + item);
            Thread.sleep(1000);
          }
        }
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread writerThread = new Thread(() -> {
      try {
        Thread.sleep(1000);
        sharedList.add("item4");
        System.out.println("added item4 to the list.");

        Thread.sleep(1000);
        sharedList.remove("item1");
        System.out.println("Removed item1 to the list.");
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    });
    readerThread.start();
    writerThread.start();
    // * Works As Expected

    // ^ The Above Operation is just that one thread is reading the list while other is writing in it
  }
}