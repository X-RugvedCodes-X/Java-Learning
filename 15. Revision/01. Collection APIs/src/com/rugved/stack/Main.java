package com.rugved.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    // System.out.println("hello, stack");
    // Stack<Integer> stack = new Stack<>();
    // stack.push(1);
    // stack.push(2);
    // stack.push(3);
    // stack.push(4);
    // stack.push(5);
    // System.out.println(stack);
    // Integer removedObject = stack.pop();  // * Removes and returns object at the top of the stack
    // System.out.println(removedObject);    // * 5
    // System.out.println(stack);            // * [1, 2, 3, 4]
    // Integer topElement = stack.peek();
    // System.out.println(topElement);       // * 4
    
    // boolean checkStack = stack.isEmpty();
    // System.out.println(checkStack);     // * false
    // int size = stack.size();    
    // System.out.println(size);           // * 4
    // ^ As stack class extends vector we can use all the methods of vector in it 

    // * Some Specialized methods of Stack class
    // * returns the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack
    // int search = stack.search(2);  
    // System.out.println(search);     // * 3

    // * Using LinkedList as Stack as Java as Doubly Linked List
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.getLast();       // * peek
    linkedList.removeLast();    // * pop
    linkedList.size();
    linkedList.isEmpty();

    // * Using ArrayList as Stack (But not Good Practice)
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.get(arrayList.size() - 1); // * peek
    arrayList.remove(arrayList.size() - 1); // * pop
  }
}