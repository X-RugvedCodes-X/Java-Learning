package com.rugved.exceptionHandling;

// * We can write multiple catch blocks for a try. Best practice is to write a Generic Exception at the end.
// * If Exception is not handled in one stack frame then automatically Exception Object will be propogated down the heireirchy which means to the caller of the method And if even it is not handled in main method then it will go to JVM's Default Exception Handler
// * Whenever there is Exception we can either Handle it or Duck it or Rethrow it

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // System.out.println("Connection Started");

    // * When Exception is Ducked or rethrowed
    // try {
    //   Division.divide();
    // } catch(ArithmeticException e) {
    //   System.out.println("Exception Caught in Main.main");
    //   e.printStackTrace();
    // }
    // System.out.println("Connection Terminated");

    // RuntimeError rt = new RuntimeError();
    // rt.beta();

    // try {
    //   CheckedAndUncheckedExceptions.checkedAndUncheckedException();
    // } catch(InterruptedException e) {
    //   e.printStackTrace();
    // }
    // TODO: try with resources
  }
};