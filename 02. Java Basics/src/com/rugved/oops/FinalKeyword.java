package com.rugved.oops;

//* final Keyword prohibits a class from participating in Inheritance ie. we cannot inherit from a final class. final class cannot be parent of any class. 
//* final Methods do participate in inheritance but we cannot override them in the child class 
//^ So Static and final are two methods which get inherited in child class but we cannot override.

//* final keyword also retricts the modification of primitive types variable values. 
//* for eg. final double PI = 3.1415... (can't change the value later) 
//* final keyword can be applied to static variables and methods too. 
//! final keyword cannot be applied to constructor as the syntax itself is illegal. 

// final class Human {   
//   public void walk() {
//     System.out.println("Human Walks");
//   }
// };

// class Man extends Human {
//   public void walk() {
//     System.out.println("Man Walks");
//   }
// };


// class Human {   
//   final public void walk() {
//     System.out.println("Human Walks");
//   }
// };

// class Man extends Human {
//   public void walk() {
//     System.out.println("Man Walks");
//   }
// };

public class FinalKeyword {
  public static void main(String[] args) {
    System.out.println("hello, final keyword");

  }
}